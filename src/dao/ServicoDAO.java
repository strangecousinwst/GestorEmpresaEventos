package dao;

import dto.ServicoDTO;
import database.ConnectionFactory;
import enums.EstadoServico;
import exceptions.ExceptionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joao
 */
public class ServicoDAO {
    
    Connection conn = null;
    Statement statement = null;
    PreparedStatement prepStatement = null;
    ResultSet resultSet = null;
    
    // Constructor method
    public ServicoDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void registarServicoDAO(ServicoDTO servicoDTO) {
        String query = "INSERT INTO servico (id_cliente, descricao, estado, preco) VALUES (?, ?, ?, ?)";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, servicoDTO.getIdCliente());
            prepStatement.setString(2, servicoDTO.getDescricao());
            prepStatement.setString(3, servicoDTO.getEstadoServico().toString().toLowerCase().replace("i", "í").replace("_", " "));
            prepStatement.setBigDecimal(4, servicoDTO.getPreco());
            prepStatement.executeUpdate();
            System.out.println("DAO: Servico registado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void editarServicoDAO(ServicoDTO servicoDTO) {
        String query = "UPDATE servico SET id_cliente=?, descricao=?, estado=?, preco=? WHERE id=?";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, servicoDTO.getIdCliente());
            prepStatement.setString(2, servicoDTO.getDescricao());
            prepStatement.setString(3, servicoDTO.getEstadoServico().toString().toLowerCase().replace("i", "í").replace("_", " "));
            prepStatement.setBigDecimal(4, servicoDTO.getPreco());
            prepStatement.setInt(5, servicoDTO.getId());
            prepStatement.executeUpdate();
            System.out.println("DAO: Servico editado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void removerServicoDAO(int id) {
        String query = "DELETE FROM servico WHERE id=?";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, id);
            prepStatement.executeUpdate();
            System.out.println("DAO: Servico removido.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getSearchResult(String searchText) {
        try {
            String query = "SELECT servico.id, cliente.nome AS 'cliente', servico.descricao, servico.estado, servico.preco, servico.criado_em, servico.atualizado_em "
                    + "FROM servico INNER JOIN cliente ON cliente.id=servico.id_cliente "
                    + "WHERE servico.id LIKE '%" + searchText 
                    + "%' OR cliente.nome LIKE '%" + searchText 
                    + "%' OR servico.descricao LIKE '%" + searchText 
                    + "%' OR servico.estado LIKE '%" + searchText 
                    + "%' OR servico.preco LIKE '%" + searchText 
                    + "%' OR servico.criado_em LIKE '%" + searchText
                    + "%' OR servico.atualizado_em LIKE '%" + searchText
                    + "%' ORDER BY servico.id";
            System.out.println(query);
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    
    public List<ServicoDTO> getServicosDAO() {

        String query = "SELECT * FROM servico";
        List<ServicoDTO> servicosDTO = new ArrayList<>();
        try {
            prepStatement = conn.prepareStatement(query);
            resultSet = prepStatement.executeQuery();
            while (resultSet.next()) {
                ServicoDTO servicoDTO = new ServicoDTO();
                servicoDTO.setId(resultSet.getInt("id"));
                servicoDTO.setIdCliente(resultSet.getInt("id_cliente"));
                servicoDTO.setDescricao(resultSet.getString("descricao"));
                servicoDTO.setEstadoServico(EstadoServico.valueOf(
                    Normalizer.normalize(resultSet.getString("estado").toUpperCase(),           // Passar para maíuscula
                    Normalizer.Form.NFD).replaceAll("\\p{M}", "").replaceAll("\\s+", "_")));    // trocar "Í"/"I" && " "/"_"
                servicoDTO.setPreco(resultSet.getBigDecimal("preco"));
                servicosDTO.add(servicoDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicosDTO;
    }
    
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT servico.id, cliente.nome AS 'cliente', servico.descricao, servico.estado, servico.preco, servico.criado_em, servico.atualizado_em FROM servico INNER JOIN cliente ON cliente.id=servico.id_cliente ORDER BY servico.id";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    // metodo para gerar uma tabela
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
