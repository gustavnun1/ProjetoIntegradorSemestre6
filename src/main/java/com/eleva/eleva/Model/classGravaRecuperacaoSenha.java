/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;

import com.eleva.eleva.Controller.DatabaseManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class classGravaRecuperacaoSenha {
    public static boolean GravaRecuperaSenha(String email){
        try {
            JOptionPane.showMessageDialog(null, "Para a recuperação futura da senha, escolha uma das opções abaixo!", "Recuperação de Senha!", javax.swing.JOptionPane.INFORMATION_MESSAGE); 
            String opcao = JOptionPane.showInputDialog(null, "1 - Qual é o nome do seu primeiro animal de estimação?\n"
                    + "2 - Qual é o nome da sua mãe?\n"
                    + "3 - Qual cidade você nasceu?\n"  
                    + "4 - Qual é o nome da sua escola primária?", "Digite apenas o numero", javax.swing.JOptionPane.OK_CANCEL_OPTION); 
            int numero = Integer.parseInt(opcao);
            if (numero >= 1 && numero <= 4){
                String resposta = JOptionPane.showInputDialog(null, "Digite sua resposta abaixo:", "Digite a resposta", javax.swing.JOptionPane.OK_CANCEL_OPTION); 
                if (resposta.equals(null) || resposta.length() <= 1 || resposta.length() >= 200 ){
                    JOptionPane.showMessageDialog(null, "Erro! Digite corretamente a sua resposta.", "Erro!", javax.swing.JOptionPane.ERROR_MESSAGE); 
                    return false;
                }
                else{
                    try {
                        DatabaseManager.gravaRecuperacaoSenha(email, opcao, resposta);
                        return true;
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Erro! Erro ao realizar gravação, contate nosso suporte caso necessário", "Erro!", javax.swing.JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro! Opção inválida", "Erro!", javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro! Contate nosso suporte.", "Erro!", javax.swing.JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
