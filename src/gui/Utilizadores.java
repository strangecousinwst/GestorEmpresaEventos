/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.UtilizadorDAO;
import dto.UtilizadorDTO;
import enums.TipoUtilizador;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author joao
 */
public class Utilizadores extends javax.swing.JPanel {

    /**
     * Creates new form Utilizadores1
     */
    public Utilizadores() {
        initComponents();
        
        loadDataSet();
    }

    public void loadDataSet() {
        try {
            UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
            tblMain.setModel(utilizadorDAO.buildTableModel(utilizadorDAO.getQueryResult()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void loadSearchData(String texto) {
        try {
            UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
            tblMain.setModel(utilizadorDAO.buildTableModel(utilizadorDAO.getSearchResult(texto)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void clearCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        cbxTipoUtilizador.setSelectedIndex(0);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneMain = new javax.swing.JScrollPane();
        tblMain = new javax.swing.JTable();
        jLabelLinhasSelecionadas = new javax.swing.JLabel();
        txtFiltrar = new javax.swing.JTextField();
        jLabelUtilizador = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelTipoUtilizador = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonRegistar = new javax.swing.JButton();
        jButtonApagar = new javax.swing.JButton();
        cbxTipoUtilizador = new javax.swing.JComboBox<>();

        tblMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMainMouseClicked(evt);
            }
        });
        jScrollPaneMain.setViewportView(tblMain);

        jLabelLinhasSelecionadas.setText("x de y linhas selecionadas.");

        txtFiltrar.setText("Filtrar..");
        txtFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarKeyReleased(evt);
            }
        });

        jLabelUtilizador.setText("Utilizador");

        jLabelNome.setText("Nome");

        jLabelEmail.setText("Email");

        jLabelPassword.setText("Password");

        jLabelTipoUtilizador.setText("Tipo Utilizador");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonRegistar.setText("Registar");
        jButtonRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistarActionPerformed(evt);
            }
        });

        jButtonApagar.setText("Apagar");
        jButtonApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarActionPerformed(evt);
            }
        });

        cbxTipoUtilizador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "FUNCIONARIO" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLinhasSelecionadas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelPassword)
                                            .addComponent(jLabelTipoUtilizador)
                                            .addComponent(jLabelNome)
                                            .addComponent(jLabelEmail))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxTipoUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabelUtilizador)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonRegistar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonEditar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonApagar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(txtFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUtilizador)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEmail))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPassword))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTipoUtilizador)
                            .addComponent(cbxTipoUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(166, 166, 166)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonRegistar)
                            .addComponent(jButtonEditar)
                            .addComponent(jButtonApagar)
                            .addComponent(jButtonCancelar))))
                .addGap(33, 33, 33)
                .addComponent(jLabelLinhasSelecionadas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        if (tblMain.getSelectedRow() < 0)
            JOptionPane.showMessageDialog(this, "Por favor selecione um Utilizador.");
        else {
            if (txtNome.getText().equals("") || txtEmail.getText().equals("") || txtPassword.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos.");
            } else {
                UtilizadorDTO utilizadorDTO = new UtilizadorDTO();
                utilizadorDTO.setId((int) tblMain.getValueAt(tblMain.getSelectedRow(), 0));
                utilizadorDTO.setNome(txtNome.getText());
                utilizadorDTO.setEmail(txtEmail.getText());
                utilizadorDTO.setPassword(txtPassword.getText());
                utilizadorDTO.setTipoUtilizador(TipoUtilizador.valueOf(cbxTipoUtilizador.getSelectedItem().toString()));
                new UtilizadorDAO().editarUtilizadorDAO(utilizadorDTO);
                loadDataSet();
                clearCampos();
            }
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistarActionPerformed
        if (txtNome.getText().equals("") || txtEmail.getText().equals("") || txtPassword.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos.");
        else {
            UtilizadorDTO utilizadorDTO = new UtilizadorDTO();
            utilizadorDTO.setNome(txtNome.getText());
            utilizadorDTO.setEmail(txtEmail.getText());
            utilizadorDTO.setPassword(txtPassword.getText());
            utilizadorDTO.setTipoUtilizador(TipoUtilizador.valueOf(cbxTipoUtilizador.getSelectedItem().toString()));
            new UtilizadorDAO().registarUtilizador(utilizadorDTO);
            loadDataSet();
            clearCampos();
        }
    }//GEN-LAST:event_jButtonRegistarActionPerformed

    private void jButtonApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarActionPerformed
        if (tblMain.getSelectedRow()<0)
            JOptionPane.showMessageDialog(null, "Por favor selecione um Utilizador.");
        else{
            int opt = JOptionPane.showConfirmDialog(
                    null,
                    "Tem a certeza que deseja remover este Utilizador?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if(opt==JOptionPane.YES_OPTION) {
                new UtilizadorDAO().removerUtilizadorDAO((int)(tblMain.getValueAt(
                        tblMain.getSelectedRow(), 0)));
                loadDataSet();
                clearCampos();
                
            }
        }
    }//GEN-LAST:event_jButtonApagarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        clearCampos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void tblMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMainMouseClicked
        int linha = tblMain.getSelectedRow();
        int coluna = tblMain.getColumnCount();
        Object[] val = new Object[coluna];

        for (int i = 0; i < coluna; i++) {
            val[i] = tblMain.getValueAt(linha, i);
        }
        txtNome.setText(val[1].toString());
        txtEmail.setText(val[2].toString());
        txtPassword.setText(val[3].toString());
        cbxTipoUtilizador.setSelectedItem(val[4].toString().toUpperCase());
    }//GEN-LAST:event_tblMainMouseClicked

    private void txtFiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarKeyReleased
        String texto = txtFiltrar.getText();
        loadSearchData(texto);
    }//GEN-LAST:event_txtFiltrarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxTipoUtilizador;
    private javax.swing.JButton jButtonApagar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonRegistar;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelLinhasSelecionadas;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTipoUtilizador;
    private javax.swing.JLabel jLabelUtilizador;
    private javax.swing.JScrollPane jScrollPaneMain;
    private javax.swing.JTable tblMain;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFiltrar;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
