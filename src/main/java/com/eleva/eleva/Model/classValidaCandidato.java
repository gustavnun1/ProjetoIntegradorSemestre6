/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;

import com.eleva.eleva.Controller.DatabaseManager;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo
 */
public class classValidaCandidato {
    public static boolean ValidacaoCadastroCandidato(
        JTextField tfNome, JTextField tfAtuacao, JTextField tfCEP, JTextField tfCPF, 
        JTextField tfContato, JTextField tfEmail, JTextField tfEndereco, 
        JTextArea tfResumo, JPasswordField tfSenha, JPasswordField tfSenhaConfirma, byte[] curriculo, String tela
    ) {
        if (tfNome.getText().trim().isEmpty()) {
            showError("Campo Nome é obrigatório!");
            return false;
        }
        else if (classRecusaNumeros.contemNumeros(tfNome.getText())){
            showError("Campo Nome não deve conter números!");
            return false;
        }
        if (tfAtuacao.getText().trim().isEmpty()) {
            showError("Campo Área de Atuação é obrigatório!");
            return false;
        }
        if (tfCEP.getText().trim().isEmpty()) {
            showError("Campo CEP é obrigatório!");
            return false;
        }
        
        if (tfCPF.getText().trim().isEmpty()) {
            showError("Campo CPF é obrigatório!");
            return false;
        } 
        else if (!classCPFInvalido.isCPFValido(tfCPF.getText())){
            showError("CPF Inválido!");
            return false;
        }
        
        if (tfContato.getText().trim().isEmpty()) {
            showError("Campo Contato é obrigatório!");
            return false;
        }
        
        if (tfEmail.getText().trim().isEmpty()) {
            showError("Campo Email é obrigatório!");
            return false;
        }
        else if (!classEmail.Validacao(tfEmail.getText())){
            showError("Digite um e-mail válido!");
            return false;
        }
        
        if (tfEndereco.getText().trim().isEmpty()) {
            showError("Campo Endereço é obrigatório!");
            return false;
        }
        if (tfResumo.getText().trim().isEmpty()) {
            showError("Campo Resumo é obrigatório!");
            return false;
        }
        
        if (tfSenha.getPassword().length == 0) {
            showError("Campo Senha é obrigatório!");
            return false;
        }
        else if (tfSenha.getPassword().length < 4){
            showError("Senha deve conter mais que 4 digitos!");
            return false;
        }
        
        if (tfSenhaConfirma.getPassword().length == 0) {
            showError("Campo Confirmar Senha é obrigatório!");
            return false;
        }
        
        if (curriculo == null || curriculo.length == 0) {
            JOptionPane.showMessageDialog(null, "Curriculo não selecionado ou inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false; 
        }

        // Verifica se as senhas coincidem
        String senha = new String(tfSenha.getPassword());
        String senhaConfirma = new String(tfSenhaConfirma.getPassword());
        if (!senha.equals(senhaConfirma)) {
            showError("As senhas não coincidem!");
            return false;
        }

        // Verifica se o usuário já existe no banco
         
        if (tela == "Cadastro"){
            try {
                String loginDuplo = DatabaseManager.login(tfEmail.getText(), senha);
                if (loginDuplo != null && !loginDuplo.isEmpty() && !loginDuplo.equals("Usuário não encontrado")) {
                    showError("Usuário já existente! Utilize outros dados.");
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                showError("Erro ao verificar usuário! Tente novamente.");
                return false;
            }
        } 
        return true;
    }

    private static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
