/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author Gustavo
 */
public class classConfirmaEmpresa {
    
    public static boolean confirmaEmpresa(String senhaAnterior, JPasswordField tfSenha, String sNomeResponsavel, String sEmail, String sCNPJ, String sEmpresa, 
    String sCEP, String sEndereco, String sAreaAtuacao, String sResumoEmpresa){
        
        String senhaCorreta = JOptionPane.showInputDialog(null, "Para alterar os dados, digite sua senha abaixo.", "Atenção", JOptionPane.OK_OPTION);
        String senhaAtualizada = new String(tfSenha.getPassword());
        
        if (senhaCorreta != null && senhaCorreta.equals(senhaAnterior)) {
            classAtualizaEmpresa.atualizaEmpresa(sNomeResponsavel, sEmail, senhaAtualizada, sCNPJ, sEmpresa, sCEP, sEndereco, sAreaAtuacao, sResumoEmpresa);
            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } 
        else{
            JOptionPane.showMessageDialog(null, "Senha incorreta ou incompleta! Tente Novamente", "Erro", JOptionPane.ERROR_MESSAGE); 
            return false;
        }
    }
    
}
