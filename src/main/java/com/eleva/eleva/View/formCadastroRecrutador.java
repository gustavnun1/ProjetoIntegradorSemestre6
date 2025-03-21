/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.eleva.eleva.View;

import com.eleva.eleva.Controller.DatabaseManager;
import com.eleva.eleva.Model.classValidacao;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class formCadastroRecrutador extends javax.swing.JFrame {

    /**
     * Creates new form formCadastroRecrutador
     */
    private classValidacao valida;
    String sAreaAtuacao;
    String sCEP;
    String sCNPJ;
    String sContato;
    String sEmail;
    String sEndereco;
    String sSenha;
    String sSenha1;
    String sResumoEmpresa;
    String sNomeResponsavel; 
    String pathCurriculo;
    String sEmpresa;
    
    formCadastro telaCadastro = new formCadastro();
    public formCadastroRecrutador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tfResponsavel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfAreaAtuacao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfResumo = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        tfSenhaConfirma = new javax.swing.JPasswordField();
        tfSenha = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfEmpresa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnCadastroEmpresa = new javax.swing.JButton();
        tfCNPJ = new javax.swing.JFormattedTextField();
        tfCEP = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(53, 53, 140));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 2, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Eleva");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 30, 140, 40);

        jPanel3.setBackground(new java.awt.Color(242, 245, 247));
        jPanel3.setBorder(new org.edisoncor.gui.util.DropShadowBorder());
        jPanel3.setLayout(null);

        tfResponsavel.setBackground(new java.awt.Color(234, 237, 239));
        tfResponsavel.setForeground(new java.awt.Color(0, 0, 0));
        tfResponsavel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(tfResponsavel);
        tfResponsavel.setBounds(40, 100, 280, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cadastro");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(410, 10, 120, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Senha");
        jLabel3.setToolTipText("");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(40, 220, 80, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nome Responsavel");
        jLabel4.setToolTipText("");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(40, 80, 120, 16);

        btnSair.setBackground(new java.awt.Color(242, 245, 247));
        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSair.setForeground(new java.awt.Color(0, 0, 0));
        btnSair.setText("Sair");
        btnSair.setBorder(null);
        btnSair.setBorderPainted(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel3.add(btnSair);
        btnSair.setBounds(420, 460, 70, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("E-mail");
        jLabel5.setToolTipText("");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(40, 150, 80, 16);

        tfEmail.setBackground(new java.awt.Color(234, 237, 239));
        tfEmail.setForeground(new java.awt.Color(0, 0, 0));
        tfEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(tfEmail);
        tfEmail.setBounds(40, 170, 280, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Confirme a senha");
        jLabel6.setToolTipText("");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(40, 290, 120, 16);

        tfAreaAtuacao.setBackground(new java.awt.Color(234, 237, 239));
        tfAreaAtuacao.setForeground(new java.awt.Color(0, 0, 0));
        tfAreaAtuacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(tfAreaAtuacao);
        tfAreaAtuacao.setBounds(640, 100, 280, 40);

        tfResumo.setBackground(new java.awt.Color(234, 237, 239));
        tfResumo.setColumns(20);
        tfResumo.setForeground(new java.awt.Color(0, 0, 0));
        tfResumo.setRows(5);
        tfResumo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(tfResumo);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(640, 180, 280, 170);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Área de atuação");
        jLabel8.setToolTipText("");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(640, 80, 100, 16);

        tfSenhaConfirma.setBackground(new java.awt.Color(234, 236, 238));
        tfSenhaConfirma.setForeground(new java.awt.Color(0, 0, 0));
        tfSenhaConfirma.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(tfSenhaConfirma);
        tfSenhaConfirma.setBounds(40, 310, 280, 40);

        tfSenha.setBackground(new java.awt.Color(234, 236, 238));
        tfSenha.setForeground(new java.awt.Color(0, 0, 0));
        tfSenha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(tfSenha);
        tfSenha.setBounds(40, 240, 280, 40);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("CNPJ");
        jLabel9.setToolTipText("");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(340, 80, 80, 16);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Empresa");
        jLabel10.setToolTipText("");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(340, 150, 80, 16);

        tfEmpresa.setBackground(new java.awt.Color(234, 237, 239));
        tfEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        tfEmpresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(tfEmpresa);
        tfEmpresa.setBounds(340, 170, 280, 40);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Conte um pouco mais sobre a empresa");
        jLabel11.setToolTipText("");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(640, 160, 250, 16);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Endereço da Empresa");
        jLabel12.setToolTipText("");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(340, 290, 140, 16);

        tfEndereco.setBackground(new java.awt.Color(234, 237, 239));
        tfEndereco.setForeground(new java.awt.Color(0, 0, 0));
        tfEndereco.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(tfEndereco);
        tfEndereco.setBounds(340, 310, 280, 40);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("CEP da Empresa");
        jLabel13.setToolTipText("");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(340, 220, 110, 16);

        btnCadastroEmpresa.setBackground(new java.awt.Color(229, 229, 229));
        btnCadastroEmpresa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastroEmpresa.setForeground(new java.awt.Color(51, 51, 51));
        btnCadastroEmpresa.setText("Confirmar Cadastro");
        btnCadastroEmpresa.setBorder(null);
        btnCadastroEmpresa.setBorderPainted(false);
        btnCadastroEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroEmpresaActionPerformed(evt);
            }
        });
        jPanel3.add(btnCadastroEmpresa);
        btnCadastroEmpresa.setBounds(360, 400, 200, 50);

        tfCNPJ.setBackground(new java.awt.Color(234, 237, 239));
        tfCNPJ.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfCNPJ.setForeground(new java.awt.Color(0, 0, 0));
        try {
            tfCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(tfCNPJ);
        tfCNPJ.setBounds(340, 100, 280, 40);

        tfCEP.setBackground(new java.awt.Color(234, 237, 239));
        tfCEP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfCEP.setForeground(new java.awt.Color(0, 0, 0));
        try {
            tfCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(tfCEP);
        tfCEP.setBounds(340, 240, 280, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        formPrincipal principal1 = new formPrincipal();
        principal1.setVisible(true); // Torna a SegundaTela visível

        // Fecha a TelaInicial
        this.dispose(); 
    }//GEN-LAST:event_btnSairActionPerformed
    
    private void GuardarDados(){
        sAreaAtuacao = tfAreaAtuacao.getText();
        sCEP = tfCEP.getText();
        sCNPJ = tfCNPJ.getText(); 
        sEmail = tfEmail.getText();
        sEndereco = tfEndereco.getText();
        char[] senhaArray = tfSenha.getPassword();
        sSenha = new String(senhaArray); 
        sResumoEmpresa = tfResumo.getText();
        sNomeResponsavel = tfResponsavel.getText(); 
        sEmpresa = tfEmpresa.getText();
    }
    
    private void btnCadastroEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroEmpresaActionPerformed
         if (!valida.ValidacaoCadastroRecrutador(tfAreaAtuacao, tfCEP, tfCNPJ,tfResponsavel, tfEmail, tfEndereco, tfResumo, tfSenha, tfSenhaConfirma)) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }else {
            // Se a validação passar, você pode prosseguir com o cadastro
            GuardarDados();
            try {
                DatabaseManager.insertRecrutador(sNomeResponsavel, sEmail, sSenha, sCNPJ, sEmpresa, sCEP, sEndereco, sAreaAtuacao, sResumoEmpresa);
                javax.swing.JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!", "Sucesso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                e.printStackTrace(); // Para depuração no console
            } 
        }
    }//GEN-LAST:event_btnCadastroEmpresaActionPerformed
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formCadastroRecrutador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formCadastroRecrutador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formCadastroRecrutador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formCadastroRecrutador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formCadastroRecrutador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroEmpresa;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfAreaAtuacao;
    private javax.swing.JFormattedTextField tfCEP;
    private javax.swing.JFormattedTextField tfCNPJ;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEmpresa;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfResponsavel;
    private javax.swing.JTextArea tfResumo;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JPasswordField tfSenhaConfirma;
    // End of variables declaration//GEN-END:variables
}
