package dao;

import dto.ClienteDTO;
import database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Cliente Data Acess Object
 * Esta classe permite fazer operações na base de dados baseadas na entidade Clientes.
 * 
 * @author joao
 */
public class ClienteDAO {

    private Connection conn = null;
    private Statement statement = null;
    private PreparedStatement prepStatement = null;
    private ResultSet resultSet = null;

    /**
     * Método construtor, instancia uma conexão à base de dados
     * e prepara um statement.
     */
    public ClienteDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Método para registar um Cliente na base de dados.
     * 
     * @param clienteDTO Cliente para registar.
     */
    public void registarClienteDAO(ClienteDTO clienteDTO) {
        String query = "INSERT INTO cliente (nome, email, telemovel, localidade) "
                + "VALUES (?, ?, ?, ?)";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, clienteDTO.getNome());
            prepStatement.setString(2, clienteDTO.getEmail());
            prepStatement.setString(3, clienteDTO.getTelemovel());
            prepStatement.setString(4, clienteDTO.getLocalidade());
            prepStatement.executeUpdate();
            System.out.println("DAO: Cliente registado.");
        } catch (SQLException e) {
            System.out.println("DAO: Erro ao registar cliente");
            e.printStackTrace();
        }
    }

    /**
     * Método para editar um Cliente na base de dados
     * @param clienteDTO Cliente para editar.
     */
    public void editarClienteDAO(ClienteDTO clienteDTO) {
        String query = "UPDATE cliente SET nome=?, email=?, telemovel=?, localidade=? "
                + "WHERE id=?";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, clienteDTO.getNome());
            prepStatement.setString(2, clienteDTO.getEmail());
            prepStatement.setString(3, clienteDTO.getTelemovel());
            prepStatement.setString(4, clienteDTO.getLocalidade());
            prepStatement.setInt(5, clienteDTO.getId());
            prepStatement.executeUpdate();
            System.out.println("DAO: Cliente editado.");
        } catch (SQLException e) {
            System.out.println("DAO: Erro ao editar cliente.");
            e.printStackTrace();
        }
    }

    /**
     * Método para remover um Cliente da base de dados.
     * @param id id do Cliente para remover.
     */
    public void removerClienteDAO(int id) {
        String query = "DELETE FROM cliente "
                + "WHERE id=?";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, id);
            prepStatement.executeUpdate();
            System.out.println("DAO: Cliente removido.");
        } catch (SQLException e) {
            System.out.println("DAO: Erro ao remover cliente.");
            e.printStackTrace();
        }
    }

    /**
     * Método para encontrar um cliente na base de dados através do id.
     * @param id id do Cliente desejado.
     * @return Cliente com o respectivo id.
     */
    public ClienteDTO getClienteById(int id) {
        String query = "SELECT * FROM cliente "
                + "WHERE id=?";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, id);
            resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setTelemovel(resultSet.getString("telemovel"));
                cliente.setLocalidade(resultSet.getString("localidade"));
                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Query SQL para obter todos os Clientes.
     * @return Lista de clientesDTO.
     */
    public List<ClienteDTO> getClientesDAO() {
        String query = "SELECT * FROM cliente";
        List<ClienteDTO> clientes = new ArrayList<>();
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setTelemovel(resultSet.getString("telemovel"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return clientes;
    }
    
    /**
     * Método para selecionar todos os Clientes numa tabela.
     * @return O resultado de um query SQL genérico, que seleciona todos.
     */
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT * FROM cliente";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * Método para procurar entre todos os clientes numa tabela, dado uma string.
     * @param searchText Palavra a procurar.
     * @return O resultado de um query SQL em que algum dos campos contenha o searchText.
     */
    public ResultSet getSearchResult(String searchText) {
        try {
            String query = "SELECT id, nome, email, telemovel, localidade "
                    + "FROM cliente "
                    + "WHERE id LIKE '%" + searchText + "%' OR email LIKE '%" 
                    + searchText + "%' OR telemovel LIKE '%" + searchText + "%'"
                    + " OR localidade LIKE '%" + searchText + "%' ";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * Método para criar uma Table, dado um resultSet de um query SQL
     * @param resultSet ResultSet de um querySQL,
     * @return Uma Table para depois ser mostrada nos JPanels.
     * @throws SQLException
     */
    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int colCount = metaData.getColumnCount();
        String[] columnNames = new String[colCount];
        for (int col = 1; col <= colCount; col++) {
            columnNames[col - 1] = metaData.getColumnName(col).toUpperCase();
        }
        List<Object[]> dataList = new ArrayList<>();
        while (resultSet.next()) {
            Object[] linha = new Object[colCount];
            for (int col = 1; col <= colCount; col++) {
                linha[col - 1] = resultSet.getObject(col);
            }
            dataList.add(linha);
        }
        Object[][] data = new Object[dataList.size()][colCount];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        return new DefaultTableModel(data, columnNames);
    }
}
