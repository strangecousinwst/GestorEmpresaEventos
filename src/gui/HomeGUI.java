package gui;

import dto.UtilizadorDTO;
import enums.TipoUtilizador;
import exceptions.ExceptionDAO;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * HomeGUI
 * Este JFrame é a principal janela da aplicação.
 * 
 * @author joao
 */
public class HomeGUI extends javax.swing.JFrame {
    
    // Layout para os vários JPanels
    private final CardLayout cardLayout;
    // Propriedades do utilizador
    private final String tipoUtilizador;
    private final String email;
    private final String nome;
    private final UtilizadorDTO utilizadorDTO;

    /**
     * Creates new form Main
     * @param utilizadorDTO Objeto instanciado a partir do utilizador que deu login na aplicação
     * @throws exceptions.ExceptionDAO
     */
    public HomeGUI(UtilizadorDTO utilizadorDTO) throws ExceptionDAO {
        initComponents();
        this.utilizadorDTO = utilizadorDTO;
        this.nome = utilizadorDTO.getNome();
        this.email = utilizadorDTO.getEmail();
        tipoUtilizador = utilizadorDTO.getTipoUtilizador().toString();
        pnlMenu.setVisible(true);
        pnlOpcoes.setVisible(false);
        cardLayout = new CardLayout();
        getUtilizador();
        SetupCardLayout();
        SetupFrame();
    }
    
    // Definições do Layout do Frame
    private void SetupFrame() {        
        setTitle("Gestor Processos");
        setLocationRelativeTo(null);
        setSize(1024,768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        cardLayout.show(pnlMain, "Bem-Vindo");   
        pack();
    }

    private void SetupCardLayout() throws ExceptionDAO {
        // pnlMain com o layout em card, permite alterar pelos varios menus
        pnlMain.setLayout(cardLayout);
        // Painel Bem-Vindo
        JPanel BemVindoPanel = new BemVindoGUI(utilizadorDTO);
        BemVindoPanel.setPreferredSize(pnlMain.getPreferredSize());
        pnlMain.add("Bem-Vindo", BemVindoPanel);
        //Painel Serviços
        JPanel ServicosPanel = new ServicosGUI();
        ServicosPanel.setPreferredSize(pnlMain.getPreferredSize());
        pnlMain.add("Serviços", ServicosPanel);
        // Painel Processos
        JPanel ProcessosPanel = new ProcessosGUI();
        ProcessosPanel.setPreferredSize(pnlMain.getPreferredSize());
        pnlMain.add("Processos", ProcessosPanel);
        // Painel Clientes
        JPanel ClientesPanel = new ClientesGUI();
        ClientesPanel.setPreferredSize(pnlMain.getPreferredSize());
        pnlMain.add("Clientes", ClientesPanel);
        // Painel Utilizadores
        JPanel UtilizadoresPanel = new UtilizadoresGUI();
        UtilizadoresPanel.setPreferredSize(pnlMain.getPreferredSize());
        pnlMain.add("Utilizadores", UtilizadoresPanel);
    }
    
    // Metodo para mostar o utilizador no JFrame
    private void getUtilizadorSessao() {
        lblUtilizador.setText("Utilizador: " + utilizadorDTO.getNome()+ " (" + tipoUtilizador + ")");
    }
    
    // Metodo para definir o tipo do utilizador, admin/funcionario
    private void getUtilizador() {
        getUtilizadorSessao();
        if (tipoUtilizador.equals(TipoUtilizador.FUNCIONARIO.toString())) {
            restrictFuncionario();
        }
        System.out.println("Login com: " + nome + " " + email + " " + tipoUtilizador);
    }
    
    // Metodos para chamar quando se escolher a opcao na nav bar
    private void mostrarBemVindo(){
        cardLayout.show(pnlMain, "Bem-Vindo");
        pnlOpcoes.setVisible(!pnlOpcoes.isVisible());
    }
    private void mostrarServicos() {
        cardLayout.show(pnlMain, "Serviços");
        pnlOpcoes.setVisible(!pnlOpcoes.isVisible());
    }
    private void mostrarProcessos() {
        cardLayout.show(pnlMain, "Processos");
        pnlOpcoes.setVisible(!pnlOpcoes.isVisible());
    }
    private void mostrarClientes() {
        cardLayout.show(pnlMain, "Clientes");
        pnlOpcoes.setVisible(!pnlOpcoes.isVisible());
    }
    private void mostrarUtilizadores() {
        cardLayout.show(pnlMain, "Utilizadores");
        pnlOpcoes.setVisible(!pnlOpcoes.isVisible());
    }
    private void restrictFuncionario() {
        pnlOpcoes.remove(btnUtilizadores);
        pnlOpcoes.remove(btnClientes);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        pnlMain = new javax.swing.JPanel();
        pnlOpcoes = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnServicos = new javax.swing.JButton();
        btnProcessos = new javax.swing.JButton();
        btnUtilizadores = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        pnlUtilizador = new javax.swing.JPanel();
        lblUtilizador = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        pnlMenu = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnServicos.setText("Serviços");
        btnServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicosActionPerformed(evt);
            }
        });

        btnProcessos.setText("Processos");
        btnProcessos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessosActionPerformed(evt);
            }
        });

        btnUtilizadores.setText("Utilizadores");
        btnUtilizadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUtilizadoresActionPerformed(evt);
            }
        });

        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOpcoesLayout = new javax.swing.GroupLayout(pnlOpcoes);
        pnlOpcoes.setLayout(pnlOpcoesLayout);
        pnlOpcoesLayout.setHorizontalGroup(
            pnlOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUtilizadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProcessos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnServicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOpcoesLayout.setVerticalGroup(
            pnlOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcoesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnServicos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProcessos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUtilizadores)
                .addContainerGap(478, Short.MAX_VALUE))
        );

        lblUtilizador.setText("Utilizador");

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUtilizadorLayout = new javax.swing.GroupLayout(pnlUtilizador);
        pnlUtilizador.setLayout(pnlUtilizadorLayout);
        pnlUtilizadorLayout.setHorizontalGroup(
            pnlUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUtilizadorLayout.createSequentialGroup()
                .addContainerGap(829, Short.MAX_VALUE)
                .addGroup(pnlUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUtilizador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        pnlUtilizadorLayout.setVerticalGroup(
            pnlUtilizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUtilizadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUtilizador)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlUtilizador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(pnlUtilizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOpcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        pnlOpcoes.setVisible(!pnlOpcoes.isVisible());
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnUtilizadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtilizadoresActionPerformed
        mostrarUtilizadores();
    }//GEN-LAST:event_btnUtilizadoresActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int opt = JOptionPane.showConfirmDialog(null,
                "<html>Tem a certeza que deseja fazer terminar sessão?<br>Terá de fazer novo login.<html>",
                "Confirme",
                JOptionPane.YES_NO_OPTION);
        if (opt==JOptionPane.YES_OPTION){
            dispose();
            LoginGUI login = new LoginGUI();
            login.setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        mostrarClientes();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProcessosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessosActionPerformed
        mostrarProcessos();
    }//GEN-LAST:event_btnProcessosActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        mostrarBemVindo();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicosActionPerformed
        mostrarServicos();
    }//GEN-LAST:event_btnServicosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnProcessos;
    private javax.swing.JButton btnServicos;
    private javax.swing.JButton btnUtilizadores;
    private javax.swing.JLabel lblUtilizador;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlOpcoes;
    private javax.swing.JPanel pnlUtilizador;
    // End of variables declaration//GEN-END:variables
}
