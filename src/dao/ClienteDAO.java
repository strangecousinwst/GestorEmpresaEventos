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
 *
 * @author joao
 */
public class ClienteDAO {

    Connection conn = null;
    Statement statement = null;
    PreparedStatement prepStatement = null;
    ResultSet resultSet = null;

    // Constructor method
    public ClienteDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean registarClienteDAO(ClienteDTO clienteDTO) {
        String query = "INSERT INTO cliente (nome, email, telemovel, localidade) VALUES (?, ?, ?, ?)";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, clienteDTO.getNome());
            prepStatement.setString(2, clienteDTO.getEmail());
            prepStatement.setString(3, clienteDTO.getTelemovel());
            prepStatement.setString(4, clienteDTO.getLocalidade());
            prepStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean editarClienteDAO(ClienteDTO clienteDTO) {
        String query = "UPDATE cliente SET nome=?, email=?, telemovel=?, localidade=? WHERE id=?";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, clienteDTO.getNome());
            prepStatement.setString(2, clienteDTO.getEmail());
            prepStatement.setString(3, clienteDTO.getTelemovel());
            prepStatement.setString(4, clienteDTO.getLocalidade());
            prepStatement.setInt(5, clienteDTO.getId());
            prepStatement.executeUpdate();
            System.out.println("DAO: Cliente editado.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void removerClienteDAO(int id) {
        String query = "DELETE FROM cliente WHERE id=?";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, id);
            prepStatement.executeUpdate();
            System.out.println("DAO: Cliente removido.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ClienteDTO getClienteById(int id) {
        String query = "SELECT * FROM cliente WHERE id=?";
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

    public List<ClienteDTO> getAllClientes() {
        String query = "SELECT * FROM cliente";
        List<ClienteDTO> clientes = new ArrayList<>();
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setTelemovel(resultSet.getString("telefone"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
    
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT * FROM cliente";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    

    public ResultSet getSearchResult(String searchText) {
        try {
            String query = "SELECT id, nome, email, telemovel, localidade FROM cliente "
                    + "WHERE id LIKE '%" + searchText + "%' OR email LIKE '%" + searchText + "%' "
                    + "OR telemovel LIKE '%" + searchText + "%' OR localidade LIKE '%" + searchText + "%' ";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    // Method to display data set in tabular form
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
