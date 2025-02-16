package dao;

import dto.UtilizadorDTO;
import database.ConnectionFactory;
import enums.TipoUtilizador;

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
 * @author efapro01.24
 */
public class UtilizadorDAO {
    
    Connection conn = null;
    Statement statement = null;
    PreparedStatement prepStatement = null;
    ResultSet resultSet = null;
    
    // Constructor method
    public UtilizadorDAO() {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public UtilizadorDTO getLogin(String email, String password) {
        UtilizadorDTO utilizadorDTO = null;
        String query = "SELECT * FROM utilizador WHERE email='"
                + email
                + "' AND password='"
                + password
                + "' LIMIT 1";
        try {
            resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                utilizadorDTO = new UtilizadorDTO();
                utilizadorDTO.setId(resultSet.getInt("id"));
                utilizadorDTO.setNome(resultSet.getString("nome"));
                utilizadorDTO.setEmail(resultSet.getString("email"));
                utilizadorDTO.setPassword(resultSet.getString("password"));
                utilizadorDTO.setTipoUtilizador(TipoUtilizador.valueOf(resultSet.getString("tipo_utilizador").toUpperCase()));
                System.out.println("DAO: Login com sucesso.");
            } else {
                System.out.println("DAO: Login falhado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilizadorDTO;
    }
    



    // Methods to add new user
    public void isUtilizadorDAO(UtilizadorDTO utilizadorDTO) {
        try {
            String query = "SELECT * FROM utilizador WHERE nome='"
                    + utilizadorDTO.getNome()
                    + "' AND email='"
                    + utilizadorDTO.getEmail()
                    + "' AND password='"
                    + utilizadorDTO.getPassword()
                    + "' AND tipo_utilizador='"
                    + utilizadorDTO.getTipoUtilizador().toString()
                    + "'";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                System.out.println("DAO: Utilizador já existe");
            } else
                registarUtilizador(utilizadorDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void registarUtilizador(UtilizadorDTO utilizadorDTO) {
        try {
            String nome = null;
            String email = null;
            String password = null;
            TipoUtilizador tipoUtilizador = null;
            String resultQuery = "SELECT * FROM utilizador";
            resultSet = statement.executeQuery(resultQuery);
            
            // se não tiver resultados não existem utilizadores,
            // criar o primeiro, root root
            if(!resultSet.next()){
                email = "root";
                password = "root";
            } else {
                String query = "INSERT INTO utilizador (nome, email, password, tipo_utilizador) " +
                    "VALUES(?,?,?,?)";
                prepStatement = conn.prepareStatement(query);
                prepStatement.setString(1, utilizadorDTO.getNome());
                prepStatement.setString(2, utilizadorDTO.getEmail());
                prepStatement.setString(3, utilizadorDTO.getPassword());
                prepStatement.setString(4, utilizadorDTO.getTipoUtilizador().toString());
                prepStatement.executeUpdate();
                System.out.println("DAO: Utilizador registado.");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // Metodo para editar utilizador
    public void editarUtilizadorDAO(UtilizadorDTO utilizadorDTO) {

        try {
            String query = "UPDATE utilizador SET nome=?, email=?, password=?, tipo_utilizador=? WHERE id=?";
            prepStatement = conn.prepareStatement(query);
            prepStatement.setString(1, utilizadorDTO.getNome());
            prepStatement.setString(2, utilizadorDTO.getEmail());
            prepStatement.setString(3, utilizadorDTO.getPassword());
            prepStatement.setString(4, utilizadorDTO.getTipoUtilizador().toString());
            prepStatement.setInt(5, utilizadorDTO.getId());
            prepStatement.executeUpdate();
            System.out.println("DAO: Utilizador editado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo para remover utilizador
    public void removerUtilizadorDAO(int id) {
        try {
            String query = "DELETE FROM utilizador WHERE id=?";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setInt(1, id);
            prepStatement.executeUpdate();
            System.out.println("DAO: Utilizador removido.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Metodo que retorna um resultset de um query
    // Usado para fazer tabelas
    public ResultSet getQueryResult() {
        try {
            String query = "SELECT * FROM utilizador";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public ResultSet getSearchResult(String searchText) {
        try {
            String query = "SELECT id, nome, email, password, tipo_utilizador FROM utilizador "
                    + "WHERE id LIKE '%" + searchText + "%' OR email LIKE '%" + searchText + "%' "
                    + "OR tipo_utilizador LIKE '%" + searchText + "%'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    

    public ResultSet getUtilizadorDAO(int id) {
        try {
            String query = "SELECT * FROM utilizador WHERE id='" + id + "'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    public void getNome(UtilizadorDTO utilizadorDTO, String email, String password) {
        try {
            String query = "SELECT * FROM utilizador WHERE email='" 
                    + email
                    + "' AND password='" 
                    + password 
                    + "' LIMIT 1";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                String nome = resultSet.getString(2);
                utilizadorDTO.setNome(nome);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void getTipoUtilizador(UtilizadorDTO utilizadorDTO, String email, String password) {
        try {
            String query = "SELECT * FROM utilizador WHERE email = '"
                    + email
                    + "' AND password='" 
                    + password 
                    + "' LIMIT 1";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                TipoUtilizador tipoUtilizador = TipoUtilizador.valueOf(resultSet.getString(5).toUpperCase());
                utilizadorDTO.setTipoUtilizador(tipoUtilizador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet getPassDAO(String email, String password){
        try {
            String query = "SELECT password FROM utilizador WHERE email='"
                    + email
                    + "' AND password='"
                    + password
                    +"'";
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    
    

    public void mudarPassword(String email, String password) {
        try {
            String query = "UPDATE utilizador SET password=? WHERE email='" +email+ "'";
            prepStatement = (PreparedStatement) conn.prepareStatement(query);
            prepStatement.setString(1, password);
            prepStatement.setString(2, email);
            prepStatement.executeUpdate();
            System.out.println("Password mudada com sucesso");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // Method to display data set in tabular form
    public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int colCount = metaData.getColumnCount();
        String[] columnNames = new String[colCount];

        for (int col=1; col <= colCount; col++){
            columnNames[col -1] = metaData.getColumnName(col).toUpperCase();
        }

        List<Object[]> dataList = new ArrayList<>();
        while (resultSet.next()) {
            Object[] linha = new Object[colCount];
            for (int col=1; col<=colCount; col++) {
                linha[col -1] = resultSet.getObject(col);
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
