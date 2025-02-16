package gui;

import dao.ProcessoDAO;
import dto.ProcessoDTO;
import dao.ServicoDAO;
import dto.ServicoDTO;
import dao.UtilizadorDAO;
import dto.UtilizadorDTO;
import exceptions.ExceptionDAO;
import java.math.BigDecimal;


import java.util.List;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author joao
 */
public class ProcessosGUI extends javax.swing.JPanel {

    public ProcessosGUI() throws ExceptionDAO {
        initComponents();
        
        loadDataSet();
        loadCbxFuncionarios();
        loadCbxServicos();
        clearCampos();
    }
    
    public void loadDataSet() {
        try {
            ProcessoDAO processoDAO = new ProcessoDAO();
            tblMain.setModel(processoDAO.buildTableModel(processoDAO.getQueryResult()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void loadSearchData(String texto) {
        try {
            ProcessoDAO processoDAO = new ProcessoDAO();
            tblMain.setModel(processoDAO.buildTableModel(processoDAO.getSearchResult(texto)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void clearCampos() {
        txtDescricao.setText("");
        txtCusto.setText("");
        txtFiltrar.setText("");
        cbxServicos.setSelectedIndex(-1);
        cbxFuncionario.setSelectedIndex(-1);
    }
    
    
    private void loadCbxFuncionarios() throws ExceptionDAO {
        UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
        List<UtilizadorDTO> funcionariosDTO = utilizadorDAO.getFuncionariosDAO();
        for (UtilizadorDTO funcionarioDTO : funcionariosDTO) {
            cbxFuncionario.addItem(funcionarioDTO);
        }
    }
    
    private void loadCbxServicos() throws ExceptionDAO {
        ServicoDAO servicoDAO = new ServicoDAO();
        List<ServicoDTO> servicosDTO = servicoDAO.getServicosDAO();
        for (ServicoDTO servicoDTO : servicosDTO) {
            cbxServicos.addItem(servicoDTO);
        }
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
        lblProcessos = new javax.swing.JLabel();
        lblServico = new javax.swing.JLabel();
        lblFuncionario = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblCusto = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRegistar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        cbxServicos = new javax.swing.JComboBox<>();
        cbxFuncionario = new javax.swing.JComboBox<>();
        txtCusto = new javax.swing.JTextField();
        lblFiltrar = new javax.swing.JLabel();

        tblMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMainMouseClicked(evt);
            }
        });
        jScrollPaneMain.setViewportView(tblMain);

        jLabelLinhasSelecionadas.setText("x de y linhas selecionadas.");

        txtFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarKeyReleased(evt);
            }
        });

        lblProcessos.setText("Processo");

        lblServico.setText("Serviço");

        lblFuncionario.setText("Funcionario");

        lblDescricao.setText("Descricao");

        lblCusto.setText("Custo");

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

        lblFiltrar.setText("Filtrar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(lblProcessos))
                                    .addComponent(lblCusto)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblFuncionario)
                                        .addComponent(cbxFuncionario, 0, 177, Short.MAX_VALUE)
                                        .addComponent(lblDescricao)
                                        .addComponent(txtDescricao))
                                    .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRegistar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblServico)
                                    .addComponent(cbxServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabelLinhasSelecionadas)
                    .addComponent(lblFiltrar))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblFiltrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProcessos)
                    .addComponent(txtFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLinhasSelecionadas))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblServico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxServicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCusto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnApagar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblMain.getSelectedRow() < 0)
            JOptionPane.showMessageDialog(this, "Por favor selecione um Processo.");
        else {
            if (txtDescricao.getText().equals("") || txtCusto.getText().equals("") || cbxFuncionario.getSelectedItem().equals(null) || cbxServicos.getSelectedItem().equals(null)) {
                JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos.");
            } else {
                ProcessoDTO processoDTO = new ProcessoDTO();
                processoDTO.setId((int) tblMain.getValueAt(tblMain.getSelectedRow(), 0));
                // sacar o id do serviço que esta na combobox
                ServicoDTO servicoDTO = (ServicoDTO) cbxServicos.getSelectedItem();
                if (servicoDTO != null) {
                    processoDTO.setIdServico(servicoDTO.getId());
                }
                
                UtilizadorDTO funcionarioDTO = (UtilizadorDTO) cbxFuncionario.getSelectedItem();
                if (funcionarioDTO != null) {
                    processoDTO.setIdFuncionario(funcionarioDTO.getId());
                }
                
                processoDTO.setDescricao(txtDescricao.getText());
                processoDTO.setCusto(BigDecimal.valueOf(Double.parseDouble(txtCusto.getText().replace(",", "."))));
                new ProcessoDAO().editarProcessoDAO(processoDTO);
                loadDataSet();
                clearCampos();
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        if (txtDescricao.getText().equals("") || txtCusto.getText().equals("") || cbxFuncionario.getSelectedItem().equals(null) || cbxServicos.getSelectedItem().equals(null)) {
            JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos."); 
        } else {
            ProcessoDTO processoDTO = new ProcessoDTO();
            // sacar o id do serviço que esta na combobox
            ServicoDTO servicoDTO = (ServicoDTO) cbxServicos.getSelectedItem();
            if (servicoDTO != null) {
                processoDTO.setIdServico(servicoDTO.getId());
            }
            
            UtilizadorDTO funcionarioDTO = (UtilizadorDTO) cbxFuncionario.getSelectedItem();
            if (funcionarioDTO != null) {
                processoDTO.setIdFuncionario(funcionarioDTO.getId());
            }

            processoDTO.setDescricao(txtDescricao.getText());
            processoDTO.setCusto(BigDecimal.valueOf(Double.parseDouble(txtCusto.getText().replace(",", "."))));
            new ProcessoDAO().registarProcessoDAO(processoDTO);
            loadDataSet();
            clearCampos();
        }
    }//GEN-LAST:event_btnRegistarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        if (tblMain.getSelectedRow()<0) {
            JOptionPane.showMessageDialog(null, "Por favor selecione um Processo.");
        } else{
            int opt = JOptionPane.showConfirmDialog(
                    null,
                    "Tem a certeza que deseja remover este Processo?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if(opt==JOptionPane.YES_OPTION) {
                new ProcessoDAO().removerProcessoDAO((int)(tblMain.getValueAt(
                        tblMain.getSelectedRow(), 0)));
                loadDataSet();
                clearCampos(); 
            }
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void tblMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMainMouseClicked
        int linha = tblMain.getSelectedRow();
        int coluna = tblMain.getColumnCount();
        Object[] val = new Object[coluna];

        for (int i = 0; i < coluna; i++) {
            val[i] = tblMain.getValueAt(linha, i);
        }
        
        // Escolhe o serviço do processo selecionado na cbxServicos
        for (int i = 0; i < cbxServicos.getItemCount(); i++) {
            ServicoDTO servicoDTO = cbxServicos.getItemAt(i);
            if (servicoDTO.getDescricao().equals(val[1].toString())) {
                cbxServicos.setSelectedItem(servicoDTO);
                break;
            }
        }
        // Escolhe o funcionario do processo selecionado na cbxFuncionarios
        for (int i = 0; i < cbxFuncionario.getItemCount(); i++) {
            UtilizadorDTO utilizadorDTO = cbxFuncionario.getItemAt(i);
            if (utilizadorDTO.getNome().equals(val[2].toString())) {
                cbxFuncionario.setSelectedItem(utilizadorDTO);
                break;
            }
        }
        txtDescricao.setText(val[3].toString());
        txtCusto.setText(val[4].toString());
    }//GEN-LAST:event_tblMainMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        clearCampos();
        loadDataSet();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtFiltrarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarKeyReleased
        String texto = txtFiltrar.getText();
        loadSearchData(texto);
    }//GEN-LAST:event_txtFiltrarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRegistar;
    private javax.swing.JComboBox<UtilizadorDTO> cbxFuncionario;
    private javax.swing.JComboBox<ServicoDTO> cbxServicos;
    private javax.swing.JLabel jLabelLinhasSelecionadas;
    private javax.swing.JScrollPane jScrollPaneMain;
    private javax.swing.JLabel lblCusto;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblFiltrar;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblProcessos;
    private javax.swing.JLabel lblServico;
    private javax.swing.JTable tblMain;
    private javax.swing.JTextField txtCusto;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtFiltrar;
    // End of variables declaration//GEN-END:variables
}
