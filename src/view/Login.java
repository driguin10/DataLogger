package view;

import dao.JavaConnect;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Login extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public Login() {
        initComponents();
        setLocationRelativeTo(null);//centraliza a tela
        conn = JavaConnect.ConnectDb();
    }

    private void entrar() {
        if (validarCampos()) {
            String sql = "select * from usuarios where usuario=? and senha=?";
            try {
                conn = JavaConnect.ConnectDb();
                pst = conn.prepareStatement(sql);
                pst.setString(1, inputUsuario.getText());
                pst.setString(2, String.valueOf(inputSenha.getPassword()));
                rs = pst.executeQuery();
                if (rs.next()) {
                    new Principal().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario não localizado");
                    inputSenha.setText("");
                    inputUsuario.requestFocus();
                }
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }

            try {
                pst.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        inputUsuario = new javax.swing.JTextField();
        BtEntrar = new javax.swing.JButton();
        BtCadastrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DataLogger");
        setPreferredSize(new java.awt.Dimension(325, 420));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/iconfinder_BT_database_export_905551.png"))); // NOI18N

        inputUsuario.setToolTipText("");
        inputUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputUsuarioKeyPressed(evt);
            }
        });

        BtEntrar.setText("Entrar");
        BtEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEntrarActionPerformed(evt);
            }
        });

        BtCadastrar.setText("Cadastrar");
        BtCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCadastrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Usuário");

        jLabel3.setText("Senha");

        inputSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputSenhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(inputUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addComponent(inputSenha)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(BtEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BtCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtEntrar)
                    .addComponent(BtCadastrar))
                .addContainerGap())
        );

        jLabel4.setText("v1.0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel4)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEntrarActionPerformed
        entrar();
    }//GEN-LAST:event_BtEntrarActionPerformed

    private void BtCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCadastrarActionPerformed
        new CadastroUsuario().setVisible(true);        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BtCadastrarActionPerformed

    private void inputSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            entrar();
        }
    }//GEN-LAST:event_inputSenhaKeyPressed

    private void inputUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            entrar();
        }
    }//GEN-LAST:event_inputUsuarioKeyPressed

    public boolean validarCampos() {
        boolean valido = true;

        if (inputUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Insira o usuario");
            valido = false;
        } else if (inputSenha.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Insira a senha");
            valido = false;
        }

        return valido;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCadastrar;
    private javax.swing.JButton BtEntrar;
    private javax.swing.JPasswordField inputSenha;
    private javax.swing.JTextField inputUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
