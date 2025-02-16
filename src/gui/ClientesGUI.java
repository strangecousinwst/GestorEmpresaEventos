package gui;

import dao.ClienteDAO;
import dto.ClienteDTO;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author joao
 */
public class ClientesGUI extends javax.swing.JPanel {

    /**
     * Creates new form Utilizadores1
     */
    public ClientesGUI() {
        initComponents();
                
        loadDataSet();
    }
    
    public void loadDataSet() {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            tblMain.setModel(clienteDAO.buildTableModel(clienteDAO.getQueryResult()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadSearchData(String texto) {
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            tblMain.setModel(clienteDAO.buildTableModel(clienteDAO.getSearchResult(texto)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void clearCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtTelemovel.setText("");
        txtLocalidade.setText("");
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
        lblLinhasSelecionadas = new javax.swing.JLabel();
        txtFiltrar = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTelemovel = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelemovel = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRegistar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        lvlLocalidade = new javax.swing.JLabel();
        txtLocalidade = new javax.swing.JTextField();
        lblFiltrar = new javax.swing.JLabel();

        tblMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMainMouseClicked(evt);
            }
        });
        jScrollPaneMain.setViewportView(tblMain);

        lblLinhasSelecionadas.setText("x de y linhas selecionadas.");

        txtFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarKeyReleased(evt);
            }
        });

        lblCliente.setText("Cliente");

        lblName.setText("Nome");

        lblEmail.setText("Email");

        lblTelemovel.setText("Telemóvel");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRegistar.setText("Registar");
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });

        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        lvlLocalidade.setText("Localidade");

        lblFiltrar.setText("Filtrar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(399, 399, 399)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCliente)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTelemovel)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTelemovel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblName)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblEmail)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lvlLocalidade)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRegistar)
                                        .addGap(23, 23, 23)
                                        .addComponent(btnEditar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnApagar))
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblLinhasSelecionadas))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFiltrar))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblFiltrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelemovel)
                            .addComponent(txtTelemovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lvlLocalidade)
                            .addComponent(txtLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(148, 148, 148)
                        .addComponent(btnCancelar)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistar)
                            .addComponent(btnEditar)
                            .addComponent(btnApagar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLinhasSelecionadas)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblMain.getSelectedRow() < 0)
            JOptionPane.showMessageDialog(this, "Por favor selecione um Cliente.");
        else {
            if (txtNome.getText().equals("") || txtEmail.getText().equals("") || txtTelemovel.getText().equals("")|| txtLocalidade.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos.");
            } else {
                ClienteDTO clienteDTO = new ClienteDTO();
                clienteDTO.setId((int) tblMain.getValueAt(tblMain.getSelectedRow(), 0));
                clienteDTO.setNome(txtNome.getText());
                clienteDTO.setEmail(txtEmail.getText());
                clienteDTO.setTelemovel(txtTelemovel.getText());
                clienteDTO.setLocalidade(txtLocalidade.getText());
                new ClienteDAO().editarClienteDAO(clienteDTO);
                loadDataSet();
                clearCampos();
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        if (txtNome.getText().equals("") || txtEmail.getText().equals("") || txtTelemovel.getText().equals("")|| txtLocalidade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos.");
        } else {
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNome(txtNome.getText());
            clienteDTO.setEmail(txtEmail.getText());
            clienteDTO.setTelemovel(txtTelemovel.getText());
            clienteDTO.setLocalidade(txtLocalidade.getText());
            new ClienteDAO().registarClienteDAO(clienteDTO);
            loadDataSet();
            clearCampos();
        }
    }//GEN-LAST:event_btnRegistarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        if (tblMain.getSelectedRow()<0) {
            JOptionPane.showMessageDialog(null, "Por favor selecione um Cliente.");
        } else{
            int opt = JOptionPane.showConfirmDialog(
                    null,
                    "Tem a certeza que deseja remover este Cliente?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if(opt==JOptionPane.YES_OPTION) {
                new ClienteDAO().removerClienteDAO((int)(tblMain.getValueAt(
                        tblMain.getSelectedRow(), 0)));
                loadDataSet();
                clearCampos();
            }
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void txtFiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarKeyReleased
        String texto = txtFiltrar.getText();
        loadSearchData(texto);
    }//GEN-LAST:event_txtFiltrarKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        clearCampos();
        loadDataSet();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMainMouseClicked
        int linha = tblMain.getSelectedRow();
        int coluna = tblMain.getColumnCount();
        Object[] val = new Object[coluna];

        for (int i = 0; i < coluna; i++) {
            val[i] = tblMain.getValueAt(linha, i);
        }
        txtNome.setText(val[1].toString());
        txtEmail.setText(val[2].toString());
        txtTelemovel.setText(val[3].toString());
        txtLocalidade.setText(val[4].toString());
    }//GEN-LAST:event_tblMainMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRegistar;
    private javax.swing.JScrollPane jScrollPaneMain;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JLabel lblLinhasSelecionadas;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTelemovel;
    private javax.swing.JLabel lvlLocalidade;
    private javax.swing.JTable tblMain;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFiltrar;
    private javax.swing.JTextField txtLocalidade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelemovel;
    // End of variables declaration//GEN-END:variables
}
