/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.eleva.eleva.View;

import com.eleva.eleva.Controller.DatabaseManager;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Gustavo
 */
public class formCadastro extends javax.swing.JFrame {
    
    String sAreaAtuacao;
    String sCEP;
    String sCPF;
    String sContato;
    String sEmail;
    String sEndereco;
    String sSenha;
    String sSenha1;
    String sResumoPessoal;
    String sNomeUsuario; 
    String pathCurriculo;
    
    /**
     * Creates new form formCadastro
     */
    public formCadastro() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnBuscaCurriculo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfAtuacao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfResumo = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        tfSenhaConfirma = new javax.swing.JPasswordField();
        tfSenha = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labelCurriculo = new java.awt.Label();
        btnCadastro = new javax.swing.JButton();
        tfCPF = new javax.swing.JFormattedTextField();
        tfContato = new javax.swing.JFormattedTextField();
        tfCEP = new javax.swing.JFormattedTextField();
        tfNome = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(53, 53, 140));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 2, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Eleva");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 30, 140, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 970, 100);

        jPanel3.setBackground(new java.awt.Color(242, 245, 247));
        jPanel3.setBorder(new org.edisoncor.gui.util.DropShadowBorder());
        jPanel3.setLayout(null);

        btnBuscaCurriculo.setBackground(new java.awt.Color(229, 229, 229));
        btnBuscaCurriculo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscaCurriculo.setForeground(new java.awt.Color(51, 51, 51));
        btnBuscaCurriculo.setText("Buscar");
        btnBuscaCurriculo.setBorder(null);
        btnBuscaCurriculo.setBorderPainted(false);
        btnBuscaCurriculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaCurriculoActionPerformed(evt);
            }
        });
        jPanel3.add(btnBuscaCurriculo);
        btnBuscaCurriculo.setBounds(640, 390, 100, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cadastro");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(430, 10, 120, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Senha");
        jLabel3.setToolTipText("");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(40, 200, 80, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nome Completo");
        jLabel4.setToolTipText("");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(40, 60, 120, 16);

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
        btnSair.setBounds(420, 490, 70, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("E-mail");
        jLabel5.setToolTipText("");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(40, 130, 80, 16);

        tfEmail.setBackground(new java.awt.Color(234, 237, 239));
        tfEmail.setForeground(new java.awt.Color(0, 0, 0));
        tfEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(tfEmail);
        tfEmail.setBounds(40, 150, 280, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Confirme a senha");
        jLabel6.setToolTipText("");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(40, 270, 120, 16);

        tfAtuacao.setBackground(new java.awt.Color(234, 237, 239));
        tfAtuacao.setForeground(new java.awt.Color(0, 0, 0));
        tfAtuacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(tfAtuacao);
        tfAtuacao.setBounds(640, 80, 280, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Anexar curriculo (.PDF)");
        jLabel7.setToolTipText("");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(640, 340, 200, 16);

        tfResumo.setBackground(new java.awt.Color(234, 237, 239));
        tfResumo.setColumns(20);
        tfResumo.setForeground(new java.awt.Color(0, 0, 0));
        tfResumo.setRows(5);
        tfResumo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportView(tfResumo);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(640, 160, 280, 170);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Área de atuação");
        jLabel8.setToolTipText("");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(640, 60, 100, 16);

        tfSenhaConfirma.setBackground(new java.awt.Color(234, 236, 238));
        tfSenhaConfirma.setForeground(new java.awt.Color(0, 0, 0));
        tfSenhaConfirma.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(tfSenhaConfirma);
        tfSenhaConfirma.setBounds(40, 290, 280, 40);

        tfSenha.setBackground(new java.awt.Color(234, 236, 238));
        tfSenha.setForeground(new java.awt.Color(0, 0, 0));
        tfSenha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(tfSenha);
        tfSenha.setBounds(40, 220, 280, 40);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("CPF");
        jLabel9.setToolTipText("");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(340, 60, 80, 16);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Contato");
        jLabel10.setToolTipText("");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(340, 130, 80, 16);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Conte um pouco mais sobre você");
        jLabel11.setToolTipText("");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(640, 140, 200, 16);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Endereço");
        jLabel12.setToolTipText("");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(340, 270, 80, 16);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("CEP");
        jLabel13.setToolTipText("");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(340, 200, 80, 16);

        labelCurriculo.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jPanel3.add(labelCurriculo);
        labelCurriculo.setBounds(640, 360, 270, 22);

        btnCadastro.setBackground(new java.awt.Color(229, 229, 229));
        btnCadastro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastro.setForeground(new java.awt.Color(51, 51, 51));
        btnCadastro.setText("Confirmar Cadastro");
        btnCadastro.setBorder(null);
        btnCadastro.setBorderPainted(false);
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });
        jPanel3.add(btnCadastro);
        btnCadastro.setBounds(360, 430, 200, 50);

        tfCPF.setBackground(new java.awt.Color(234, 237, 239));
        tfCPF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfCPF.setForeground(new java.awt.Color(0, 0, 0));
        try {
            tfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(tfCPF);
        tfCPF.setBounds(340, 80, 280, 40);

        tfContato.setBackground(new java.awt.Color(234, 237, 239));
        tfContato.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfContato.setForeground(new java.awt.Color(0, 0, 0));
        try {
            tfContato.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(tfContato);
        tfContato.setBounds(340, 150, 280, 40);

        tfCEP.setBackground(new java.awt.Color(234, 237, 239));
        tfCEP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfCEP.setForeground(new java.awt.Color(0, 0, 0));
        try {
            tfCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(tfCEP);
        tfCEP.setBounds(340, 220, 280, 40);

        tfNome.setBackground(new java.awt.Color(234, 237, 239));
        tfNome.setForeground(new java.awt.Color(0, 0, 0));
        tfNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(tfNome);
        tfNome.setBounds(40, 80, 280, 40);

        tfEndereco.setBackground(new java.awt.Color(234, 237, 239));
        tfEndereco.setForeground(new java.awt.Color(0, 0, 0));
        tfEndereco.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(tfEndereco);
        tfEndereco.setBounds(340, 290, 280, 40);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 110, 950, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscaCurriculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaCurriculoActionPerformed
        JFileChooser chooser = new JFileChooser();

        // Define um filtro para aceitar apenas arquivos PDF
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos PDF (*.pdf)", "pdf");
        chooser.setFileFilter(filter);

        // Abre o seletor de arquivos
        int returnValue = chooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
    
            // Garante que o arquivo selecionado seja realmente um PDF
            if (f.getName().toLowerCase().endsWith(".pdf")) {
                String filename = f.getAbsolutePath();
                labelCurriculo.setText(filename);
            } else {
               JOptionPane.showMessageDialog(null, "Por favor, selecione um arquivo PDF válido.", "Arquivo inválido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuscaCurriculoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        formPrincipal principal1 = new formPrincipal();
        principal1.setVisible(true); // Torna a SegundaTela visível

        // Fecha a TelaInicial
        this.dispose(); 
    }//GEN-LAST:event_btnSairActionPerformed
    
    private void GuardarDados(){
        sAreaAtuacao = tfAtuacao.getText();
        sCEP = tfCEP.getText();
        sCPF = tfCPF.getText();
        sContato = tfContato.getText();
        sEmail = tfEmail.getText();
        sEndereco = tfEndereco.getText();
        char[] senhaArray = tfSenha.getPassword();
        sSenha = new String(senhaArray); 
        sResumoPessoal = tfResumo.getText();
        sNomeUsuario = tfNome.getText();
        pathCurriculo = labelCurriculo.getText();
    }
    
    
    
    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        if (!Validacao()) {
            // Exibe uma mensagem de erro se os campos não estiverem preenchidos
            javax.swing.JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }else {
            // Se a validação passar, você pode prosseguir com o cadastro
            GuardarDados();
            try {
                DatabaseManager.insertCandidatos(sAreaAtuacao, sCEP, sCPF, sContato, sEmail, sEndereco, sSenha, sResumoPessoal, sNomeUsuario, pathCurriculo);
                javax.swing.JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!", "Sucesso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
                e.printStackTrace(); // Para depuração no console
            } 
        }
    }//GEN-LAST:event_btnCadastroActionPerformed
    
    public boolean Validacao() { 
        
        if (tfAtuacao.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo Área de Atuação é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tfCEP.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo CEP é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tfCPF.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo CPF é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tfContato.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo Contato é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tfEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo Email é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tfEndereco.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo Endereço é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tfResumo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campo Resumo é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tfSenha.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Campo Senha é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (tfSenhaConfirma.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Campo Confirmar Senha é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
         
        // Verifica se as senhas coincidem
        if (!new String(tfSenha.getPassword()).equals(new String(tfSenhaConfirma.getPassword()))) {
            JOptionPane.showMessageDialog(this, "As senhas não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true; 
    }
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
            java.util.logging.Logger.getLogger(formCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscaCurriculo;
    private javax.swing.JButton btnCadastro;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label labelCurriculo;
    private javax.swing.JTextField tfAtuacao;
    private javax.swing.JFormattedTextField tfCEP;
    private javax.swing.JFormattedTextField tfCPF;
    private javax.swing.JFormattedTextField tfContato;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextArea tfResumo;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JPasswordField tfSenhaConfirma;
    // End of variables declaration//GEN-END:variables
}
