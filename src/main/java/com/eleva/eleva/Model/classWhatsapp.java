/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Model;

import java.awt.Desktop;
import java.net.URI;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class classWhatsapp {
    
    String numero = "11955558424";
    String mensagem = "Olá, gostaria de obter algumas informações sobre a aplicação, poderia me ajudar?";
    
    public void abrirWhatsapp(){ 
        try {
            String url = "https://api.whatsapp.com/send?phone=" + numero + "&text=" + mensagem.replace(" ", "%20");
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o WhatsApp!", "Erro", JOptionPane.ERROR_MESSAGE); 
        }
    }
}
