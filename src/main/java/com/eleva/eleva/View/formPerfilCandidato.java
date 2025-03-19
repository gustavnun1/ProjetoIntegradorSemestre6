/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.eleva.eleva.View;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class formPerfilCandidato extends javax.swing.JFrame {

    /**
     * Creates new form formPerfilCandidato
     */
    
    public static String Usuario;
    public static String emailUsuario;
    String curriculoCandidato;
    
    public formPerfilCandidato(String tipoUsuario, String email) {
        initComponents();
        Usuario = tipoUsuario;
        emailUsuario = email;
        VerificaVisivel();
        carregarDados(emailUsuario);
        setaImagem(); 
    }
    
     // Setter para receber o nome
      
    
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
        btnSair = new javax.swing.JButton();
        btnEdicao = new javax.swing.JButton();
        tfEmail = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        tfExperiencia = new javax.swing.JTextField();
        tfContato = new javax.swing.JTextField();
        tfCEP = new javax.swing.JTextField();
        tfEndereco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfResumo = new javax.swing.JTextPane();
        lblImagem = new javax.swing.JLabel();
        btnCurriculo = new javax.swing.JButton();

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
        btnSair.setBounds(410, 490, 70, 30);

        btnEdicao.setBackground(new java.awt.Color(229, 229, 229));
        btnEdicao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEdicao.setForeground(new java.awt.Color(51, 51, 51));
        btnEdicao.setText("Confirmar Edição");
        btnEdicao.setBorder(null);
        btnEdicao.setBorderPainted(false);
        btnEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdicaoActionPerformed(evt);
            }
        });
        jPanel3.add(btnEdicao);
        btnEdicao.setBounds(340, 430, 210, 50);

        tfEmail.setBackground(new java.awt.Color(234, 236, 238));
        tfEmail.setForeground(new java.awt.Color(0, 0, 0));
        tfEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfEmail.setEnabled(false);
        jPanel3.add(tfEmail);
        tfEmail.setBounds(30, 290, 260, 40);

        tfNome.setBackground(new java.awt.Color(234, 236, 238));
        tfNome.setForeground(new java.awt.Color(0, 0, 0));
        tfNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfNome.setEnabled(false);
        jPanel3.add(tfNome);
        tfNome.setBounds(30, 220, 260, 40);

        tfExperiencia.setBackground(new java.awt.Color(234, 236, 238));
        tfExperiencia.setForeground(new java.awt.Color(0, 0, 0));
        tfExperiencia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfExperiencia.setEnabled(false);
        jPanel3.add(tfExperiencia);
        tfExperiencia.setBounds(320, 290, 260, 40);

        tfContato.setBackground(new java.awt.Color(234, 236, 238));
        tfContato.setForeground(new java.awt.Color(0, 0, 0));
        tfContato.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfContato.setEnabled(false);
        jPanel3.add(tfContato);
        tfContato.setBounds(30, 360, 260, 40);

        tfCEP.setBackground(new java.awt.Color(234, 236, 238));
        tfCEP.setForeground(new java.awt.Color(0, 0, 0));
        tfCEP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfCEP.setEnabled(false);
        jPanel3.add(tfCEP);
        tfCEP.setBounds(320, 360, 260, 40);

        tfEndereco.setBackground(new java.awt.Color(234, 236, 238));
        tfEndereco.setForeground(new java.awt.Color(0, 0, 0));
        tfEndereco.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfEndereco.setEnabled(false);
        jPanel3.add(tfEndereco);
        tfEndereco.setBounds(320, 220, 260, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("E-mail");
        jLabel4.setToolTipText("");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(30, 270, 120, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Contato");
        jLabel5.setToolTipText("");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(30, 340, 120, 16);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Endereço");
        jLabel6.setToolTipText("");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(320, 200, 120, 16);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Resumo Profissional");
        jLabel7.setToolTipText("");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(600, 200, 120, 16);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Experiência");
        jLabel8.setToolTipText("");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(320, 270, 120, 16);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("CEP");
        jLabel9.setToolTipText("");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(320, 340, 120, 16);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Nome Completo");
        jLabel11.setToolTipText("");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(30, 200, 120, 16);

        tfResumo.setBackground(new java.awt.Color(234, 236, 238));
        tfResumo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfResumo.setEnabled(false);
        jScrollPane1.setViewportView(tfResumo);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(600, 220, 260, 180);

        lblImagem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(lblImagem);
        lblImagem.setBounds(30, 20, 150, 150);

        btnCurriculo.setBackground(new java.awt.Color(229, 229, 229));
        btnCurriculo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCurriculo.setForeground(new java.awt.Color(51, 51, 51));
        btnCurriculo.setText("Baixar Curriculo");
        btnCurriculo.setBorder(null);
        btnCurriculo.setBorderPainted(false);
        btnCurriculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurriculoActionPerformed(evt);
            }
        });
        jPanel3.add(btnCurriculo);
        btnCurriculo.setBounds(200, 140, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
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
            .addGap(0, 693, Short.MAX_VALUE)
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
    private void setaImagem(){
        ImageIcon icon = new ImageIcon("C:/Users/gusta/OneDrive/Documentos/NetBeansProjects/Eleva/src/main/java/images/picpeople_9291864 (2).png");

        // Redimensionar a imagem para caber no JLabel
        Image image = icon.getImage().getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_SMOOTH);
    
        lblImagem.setIcon(new ImageIcon(image)); // Define a imagem na JLabel
    }
    private void VerificaVisivel(){
        if (Usuario.equals("Recrutador")){
            btnEdicao.setVisible(false); // Oculta o botão
        }else if (Usuario.equals("Candidato")){
            btnCurriculo.setVisible(false); // Oculta o botão
            tfNome.setEnabled(true);  
            tfEmail.setEnabled(true);  
            tfContato.setEnabled(true);  
            tfEndereco.setEnabled(true);  
            tfExperiencia.setEnabled(true);  
            tfResumo.setEnabled(true);  
            tfCEP.setEnabled(true);  
        } 
    }
    
    private void carregarDados(String email) {
    String url = "jdbc:sqlserver://localhost:1433;databaseName=dbEleva;encrypt=false";
    String user = "AdministradorEleva";
    String password = "admin123";

    String sql = "SELECT Nome, Email, Contato, Endereco, Area_Atuacao, Resumo_profissional, CEP, Curriculo FROM eCandidatos WHERE Email = ?"; 

    try (Connection conn = DriverManager.getConnection(url, user, password);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, email); // Define o parâmetro antes da execução

        try (ResultSet rs = pstmt.executeQuery()) { // Executa a consulta

            if (rs.next()) { // Verifica se há resultados antes de acessar os campos
                tfNome.setText(rs.getString("Nome"));
                tfEmail.setText(rs.getString("Email"));
                tfContato.setText(rs.getString("Contato"));
                tfEndereco.setText(rs.getString("Endereco"));
                tfExperiencia.setText(rs.getString("Area_Atuacao"));
                tfResumo.setText(rs.getString("Resumo_profissional"));
                tfCEP.setText(rs.getString("CEP"));
                curriculoCandidato = rs.getString("curriculo");
            } 
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    
    private void btnEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdicaoActionPerformed
         
    }//GEN-LAST:event_btnEdicaoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        
        if (Usuario.equals("Recrutador")){
            formRecrutador recrutador = new formRecrutador();
            recrutador.setVisible(true); // Torna a SegundaTela visível
        
        }else if (Usuario.equals("Candidato")){
            formPrincipal principal = new formPrincipal();
            principal.setVisible(true); // Torna a SegundaTela visível
        }
         
        // Fecha a TelaInicial
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCurriculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurriculoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolha onde salvar o arquivo");
        fileChooser.setSelectedFile(new File("curriculo.pdf")); // Nome padrão do arquivo

        int userSelection = fileChooser.showSaveDialog(this);
    
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File arquivoOrigem = new File(curriculoCandidato); // Caminho original do arquivo
            File arquivoDestino = fileChooser.getSelectedFile(); // Caminho onde salvará

            try (InputStream in = new FileInputStream(arquivoOrigem);
                 OutputStream out = new FileOutputStream(arquivoDestino)) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                JOptionPane.showMessageDialog(this, "Download concluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao baixar o arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        };
    }//GEN-LAST:event_btnCurriculoActionPerformed
  
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
            java.util.logging.Logger.getLogger(formPerfilCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formPerfilCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formPerfilCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formPerfilCandidato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
              
            new formPerfilCandidato(Usuario, emailUsuario).setVisible(true);
        }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCurriculo;
    private javax.swing.JButton btnEdicao;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JTextField tfCEP;
    private javax.swing.JTextField tfContato;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfExperiencia;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextPane tfResumo;
    // End of variables declaration//GEN-END:variables
}
