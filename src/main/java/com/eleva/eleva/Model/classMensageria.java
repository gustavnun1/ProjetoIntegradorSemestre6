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
public class classMensageria {
    public String Email;
    public String Mensagem;
    public String Data;
    public String Empresa;
    
    public static boolean VerificaMensageriaUsuario(String usuario, String email){
        if (usuario.equals("Recrutador")){
            try {
                JOptionPane.showMessageDialog(null, "Seja bem vindo ao Mensageria Eleva!", "Bem vindo!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                String empresa  = JOptionPane.showInputDialog(null, "Qual o nome empresarial gostaria de se contactar com o destinatário?", "Nome Empresarial", javax.swing.JOptionPane.QUESTION_MESSAGE);
                if (empresa == null || (empresa.isEmpty())){
                    JOptionPane.showMessageDialog(null, "Operação cancelada.", "Cancelada!", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                String mensagem = JOptionPane.showInputDialog(null, "Digite a mensagem ao destinatário abaixo, o candidato verá a mensagem e poderá entrar em contato pelas informações descritas", "Mensagem", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                if (mensagem == null || (mensagem.isEmpty())){
                    JOptionPane.showMessageDialog(null, "Operação cancelada.", "Cancelada!", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                if (DatabaseManager.enviaMensagem(email, empresa, mensagem)){
                    JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso!");
                    return true;
                } 
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao enviar mensagem! Tente novamente ou contate nosso suporte.", "Erro!", javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        else{
            try {
                JOptionPane.showMessageDialog(null, "Seja bem vindo ao Mensageria Eleva!", "Bem vindo!", javax.swing.JOptionPane.INFORMATION_MESSAGE); 
                DatabaseManager.carregaMensagens(email);  
                JOptionPane.showMessageDialog(null, "Finalizando...!", "Finalizado!", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                return true;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao carregar mensagens! Tente novamente ou contate nosso suporte.", "Erro!", javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
}
