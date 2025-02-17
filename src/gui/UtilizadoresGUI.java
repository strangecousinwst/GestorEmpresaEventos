package gui;

import dao.UtilizadorDAO;
import dto.UtilizadorDTO;
import enums.TipoUtilizador;

import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JOptionPane;
import myutils.TableFormatter;

/**
 * UtilizadoresGUI
 * Este JPanel contém operações sobre Utilizadores.
 * 
 * @author joao
 */
public class UtilizadoresGUI extends javax.swing.JPanel {

    /**
     * Creates new form UtilizadoresGUI
     */
    public UtilizadoresGUI() {
        initComponents();
        setupTable();
        loadDataSet();
        clearCampos();
    }
    
    /**
     * Método que carrega informações para uma table.
     */
    public void loadDataSet() {
        try {
            UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
            tblMain.setModel(utilizadorDAO.buildTableModel(utilizadorDAO.getQueryResult()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void setupTable() {
        TableFormatter.formatTable(tblMain);
    }
    
    /**
     * Método que carrega informações da base de dados para uma table, dado um texto.
     * @param texto Texto para procurar
     */
    public void loadSearchData(String texto) {
        try {
            UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
            tblMain.setModel(utilizadorDAO.buildTableModel(utilizadorDAO.getSearchResult(texto)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método para limpar os campos de inserir inputs.
     */
    public void clearCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtFiltrar.setText("");
        cbxTipoUtilizador.setSelectedIndex(-1);
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
        txtFiltrar = new javax.swing.JTextField();
        lblFiltrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelUtilizador = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabelTipoUtilizador = new javax.swing.JLabel();
        cbxTipoUtilizador = new javax.swing.JComboBox<>();
        jButtonRegistar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonApagar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        tblMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMainMouseClicked(evt);
            }
        });
        jScrollPaneMain.setViewportView(tblMain);

        txtFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarKeyReleased(evt);
            }
        });

        lblFiltrar.setText("Filtrar :");

        jLabelUtilizador.setText("Utilizador");

        jLabelNome.setText("Nome");

        jLabelEmail.setText("Email");

        jLabelPassword.setText("Password");

        jLabelTipoUtilizador.setText("Tipo Utilizador");

        cbxTipoUtilizador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "FUNCIONARIO" }));

        jButtonRegistar.setText("Registar");
        jButtonRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonApagar.setText("Apagar");
        jButtonApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelUtilizador)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTipoUtilizador, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxTipoUtilizador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRegistar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jButtonApagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUtilizador)
                .addGap(5, 5, 5)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTipoUtilizador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipoUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonRegistar)
                .addGap(18, 18, 18)
                .addComponent(jButtonEditar)
                .addGap(18, 18, 18)
                .addComponent(jButtonApagar)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFiltrar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblFiltrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        if (tblMain.getSelectedRow() < 0)
            JOptionPane.showMessageDialog(this, "Por favor selecione um Utilizador.");
        else {
            if (txtNome.getText().isEmpty() || txtEmail.getText().isEmpty() || txtPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos.");
            } else {
                UtilizadorDTO utilizadorDTO = new UtilizadorDTO();
                utilizadorDTO.setId((int) tblMain.getValueAt(tblMain.getSelectedRow(), 0));
                utilizadorDTO.setNome(txtNome.getText());
                utilizadorDTO.setEmail(txtEmail.getText());
                utilizadorDTO.setPassword(txtPassword.getText());
                utilizadorDTO.setTipoUtilizador(TipoUtilizador.valueOf(Objects.requireNonNull(cbxTipoUtilizador.getSelectedItem()).toString()));
                new UtilizadorDAO().editarUtilizadorDAO(utilizadorDTO);
                loadDataSet();
                clearCampos();
            }
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistarActionPerformed
        if (txtNome.getText().isEmpty() || txtEmail.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos."); 
        } else {
            UtilizadorDTO utilizadorDTO = new UtilizadorDTO();
            utilizadorDTO.setNome(txtNome.getText());
            utilizadorDTO.setEmail(txtEmail.getText());
            utilizadorDTO.setPassword(txtPassword.getText());
            utilizadorDTO.setTipoUtilizador(TipoUtilizador.valueOf(Objects.requireNonNull(cbxTipoUtilizador.getSelectedItem()).toString()));
            try {
                
            } catch (Exception e) {
                
            }
            new UtilizadorDAO().registarUtilizadorDAO(utilizadorDTO);
            loadDataSet();
            clearCampos();
        }
    }//GEN-LAST:event_jButtonRegistarActionPerformed

    private void jButtonApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarActionPerformed
        if (tblMain.getSelectedRow()<0) {
            JOptionPane.showMessageDialog(null, "Por favor selecione um Utilizador.");
        } else{
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
        loadDataSet();
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
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTipoUtilizador;
    private javax.swing.JLabel jLabelUtilizador;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneMain;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JTable tblMain;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFiltrar;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
