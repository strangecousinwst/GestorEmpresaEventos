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
    
    
    public List<ServicoDTO> getServicosDAO() throws ExceptionDAO {

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
            throw new ExceptionDAO("DAO: Erro ao procurar utilizador: " + e);
        } finally {
            try {
                if (prepStatement != null) {
                    prepStatement.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("DAO: Erro ao fechar o preparedStatement: " + e);
            }
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("DAO: Erro ao fechar o resultSet: " + e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("DAO: Erro ao fechar a conexão: " + e);
            }
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
