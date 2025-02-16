package dao;

import database.ConnectionFactory;
import dto.ProcessoDTO;

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
public class ProcessoDAO {
    
    Connection conn = null;
    Statement statement = null;
    PreparedStatement prepStatement = null;
    ResultSet resultSet = null;
    
    public ProcessoDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void registarProcessoDAO(ProcessoDTO processoDTO) {
        String query = "INSERT INTO processo (id_servico, id_funcionario, descricao, custo) VALUES (?, ?, ?, ?)";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, processoDTO.getIdServico());
            prepStatement.setInt(2, processoDTO.getIdFuncionario());
            prepStatement.setString(3, processoDTO.getDescricao());
            prepStatement.setBigDecimal(4, processoDTO.getCusto());
            prepStatement.executeUpdate();
            System.out.println("DAO: Processo registado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarProcessoDAO(ProcessoDTO processoDTO) {
        String query = "UPDATE processo SET id_servico=?, id_funcionario=?, descricao=?, custo=? WHERE id=?";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, processoDTO.getIdServico());
            prepStatement.setInt(2, processoDTO.getIdFuncionario());
            prepStatement.setString(3, processoDTO.getDescricao());
            prepStatement.setBigDecimal(4, processoDTO.getCusto());
            prepStatement.setInt(5, processoDTO.getId());
            prepStatement.executeUpdate();
            System.out.println("DAO: Processo editado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerProcessoDAO(int id) {
        String query = "DELETE FROM processo WHERE id=?";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, id);
            prepStatement.executeUpdate();
            System.out.println("DAO: Processo removido.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ProcessoDTO getProcessoById(int id) {
        String query = "SELECT * FROM processo WHERE id=?";
        try {
            prepStatement = conn.prepareStatement(query);
            prepStatement.setInt(1, id);
            resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                ProcessoDTO processo = new ProcessoDTO();
                processo.setId(resultSet.getInt("id"));
                processo.setIdServico(resultSet.getInt("id_servico"));
                processo.setIdFuncionario(resultSet.getInt("id_funcionario"));
                processo.setDescricao(resultSet.getString("descricao"));
                processo.setCusto(resultSet.getBigDecimal("custo"));
                return processo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ProcessoDTO> getAllProcessos() {
        String query = "SELECT * FROM processo";
        List<ProcessoDTO> processos = new ArrayList<>();
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ProcessoDTO processo = new ProcessoDTO();
                processo.setId(resultSet.getInt("id"));
                processo.setIdServico(resultSet.getInt("id_servico"));
                processo.setIdFuncionario(resultSet.getInt("id_funcionario"));
                processo.setDescricao(resultSet.getString("descricao"));
                processo.setCusto(resultSet.getBigDecimal("custo"));
                processos.add(processo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return processos;
    }
    
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT processo.id, servico.descricao AS 'serviço', utilizador.nome AS 'funcionario', processo.descricao, processo.custo, processo.criado_em FROM processo INNER JOIN servico ON servico.id=processo.id_servico INNER JOIN utilizador ON utilizador.id=processo.id_funcionario ORDER BY processo.id";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    

    public ResultSet getSearchResult(String searchText) {
        try {
            String query = "SELECT processo.id, servico.descricao AS 'serviço', utilizador.nome AS 'funcionario', processo.descricao, processo.custo, processo.criado_em "
                    + "FROM processo INNER JOIN servico ON servico.id=processo.id_servico INNER JOIN utilizador ON utilizador.id=processo.id_funcionario "
                    + "WHERE processo.id LIKE '%" + searchText 
                    + "%' OR servico.descricao LIKE '%" + searchText 
                    + "%' OR utilizador.nome LIKE '%" + searchText 
                    + "%' OR processo.descricao LIKE '%" + searchText 
                    + "%' OR processo.custo LIKE '%" + searchText 
                    + "%' OR processo.criado_em LIKE '%" + searchText 
                    + "%' ORDER BY processo.id";
            System.out.println(query);
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
