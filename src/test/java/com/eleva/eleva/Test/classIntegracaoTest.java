/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Test;

import com.eleva.eleva.Controller.DatabaseManager;
import com.eleva.eleva.Model.classConfirmaCandidato;
import com.eleva.eleva.Model.classConfirmaEmpresa;
import com.eleva.eleva.Model.classExclusaoCandidato;
import com.eleva.eleva.Model.classExclusaoEmpresa;
import com.eleva.eleva.Model.classGravaRecuperacaoSenha;
import com.eleva.eleva.Model.classLogin;
import com.eleva.eleva.Model.classMensageria;
import com.eleva.eleva.Model.classValidaCandidato;
import java.util.Arrays; 
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Gustavo
 **/ 
public class classIntegracaoTest { 
    @Test
    public void testVerificaUsuarioDuplicado(){
        System.out.println("usuario duplicado"); 
        //Ao cadastrar, verifica se já existe um usuario no banco de dados após as verificações dos campos 
        //Verificando pelo CPF e e-mail do usuario
        JTextField tfNome = new JTextField("Maria Oliveira");
        JTextField tfAtuacao = new JTextField("Programador");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField("529.982.247-25");
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("maria.oliveira@email.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField("senhaForte456");
        JPasswordField tfSenhaConfirma = new JPasswordField("senhaForte456");
 
        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100);
        String senhaStr = new String(tfSenha.getPassword());
        String tela = "Cadastro";
        String nascimento = "04/04/2004";
        
        
        //APAGA OS DADOS PARA INSERIR NOVAMENTE
        DatabaseManager.deleteCandidato(tfCPF.getText());
        
        //Inserindo um participante com esses dados
        DatabaseManager.insertCandidatos(tfAtuacao.getText(), tfCEP.getText(), tfCPF.getText(), tfContato.getText(), 
                tfEmail.getText(), tfEndereco.getText(), senhaStr, tfResumo.getText(), tfNome.getText(), dados, nascimento);
        
        //Fazendo a validação para outro cadastro igual
        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertFalse(result, "Deve retornar falso pois já existe um participante com os dados");
    }
    
    @Test
    public void testLogin(){
        System.out.println("testa login");
        String email;
        String senha;
        boolean result;
        
        //Verifica o tipo de usuario ao fazer login
        email = "gustavo.nunes@gmail.com";
        senha = "admin1234";
        String retorno = classLogin.retornaTipologin(email, senha);
        assertEquals(retorno, "Candidato"); //DEVE RETORNAR TIPO DE CANDIDATO JA CADASTRADO
        
        String email1 = "joao.silva@empresa.com";
        String senha1 = "senhaSegura123";
        retorno = classLogin.retornaTipologin(email1, senha1);
        assertEquals(retorno, "Recrutador"); //DEVE RETORNAR TIPO DE RECRUTADOR/EMPRESA JA CADASTRADO
        
        String email2 = "gustav111111111o@gmail.com";
        String senha2 = "admin123456";
        retorno = classLogin.retornaTipologin(email2, senha2);
        assertEquals(retorno, "Usuário não encontrado"); //DEVE RETORNAR TIPO DE RECRUTADOR/EMPRESA JA CADASTRADO
    }    
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void testLogin2(){    
        System.out.println("testa login");
        String email = "gustavo.nunes@gmail.com";
        String senha = "admin1234";
        boolean result;    
         
        result = classLogin.tryLogin(null, email, senha);
        assertFalse(result, "Deve retornar falso pois tipo de usuario é vazio");
        
        result = classLogin.tryLogin("Usuário não encontrado", email, senha);
        assertFalse(result, "Deve retornar falso pois Usuário não encontrado");
        
        email = "gustavo.nunes@gmail.com";
        senha = "admin1234";
        result = classLogin.tryLogin("Candidato", email, senha);
        assertTrue(result, "Deve retornar verdadeiro");
    }
    
    @Test
    public void testConfirmaSenhaCandidato(){
        System.out.println("Confirma candidato");
        String senhaAnterior = "admin1234";
        String areaAtuacao     = "Programador";
        String usuario         = "Gustavo Nunes";   
        String cep             = "04474-240";
        String cpf             = "286.292.088-64";
        String contato         = "(11)95555-8424";
        String email           = "gustavo.nunes@gmail.com";
        String endereco        = "rua miguel fleta";
        String resumoPessoal   = "Programador Junior com 4 anos de xp"; 
        JPasswordField tfSenha = new JPasswordField("");
        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100);
        boolean result; 
        
        //PRIMEIRO, TESTA SE SENHA DIGITADA FOR NULO
        result = classConfirmaCandidato.confirmaCandidato(senhaAnterior, tfSenha, areaAtuacao, cep, cpf, contato, email, endereco, resumoPessoal, usuario, dados);
        assertFalse(result, "Deve retornar falso, pois esta vazio");
        
        senhaAnterior = "admin1234121";
        JPasswordField tfSenha1 = new JPasswordField("admin123"); 
        //TESTA SE SENHA DIGITADA FOR DIFERENTE DA ANTERIOR
        result = classConfirmaCandidato.confirmaCandidato(senhaAnterior, tfSenha1, areaAtuacao, cep, cpf, contato, email, endereco, resumoPessoal, usuario, dados);
        assertFalse(result, "Deve retornar falso, pois senhas estão diferente");
        
        senhaAnterior = "admin1234";
        JPasswordField tfSenha2 = new JPasswordField("admin1234"); 
        //RESULTADO APROVADO
        result = classConfirmaCandidato.confirmaCandidato(senhaAnterior, tfSenha2, areaAtuacao, cep, cpf, contato, email, endereco, resumoPessoal, usuario, dados);
        assertTrue(result, "Deve retornar verdadeiro");
    }
    
    @Test
    public void testMensageriaRecrutador(){
        System.out.println("Confirma mensagem");
        //Teste mensagem para o usuario
        //TESTES PLANEJADOS, PRIMEIRAMENTE TESTA SE O NOME DA EMPRESA FOI DIGITADO
        String usuario = "Recrutador", email = "gustavo.nunes@gmail.com";
        boolean result = classMensageria.VerificaMensageriaUsuario(usuario, email);  
        assertFalse(result, "Retorna falso pois não foi digitado o nome da empresa");
        
        
        //TESTES PLANEJADOS, TESTA SE A MENSAGEM FOI DIGITADO
        result = classMensageria.VerificaMensageriaUsuario(usuario, email); 
        assertFalse(result, "Retorna falso pois não foi digitado a mensagem para o candidato");
        

        //TESTES PLANEJADOS 
        result = classMensageria.VerificaMensageriaUsuario(usuario, email); 
        assertTrue(result, "Retorna verdadeiro pois foi digitado a mensagem e nome da empresa");
    }
    
    @Test
    public void testMensageriaCandidato(){
        //Teste de recebimento de mensagem
        String usuario = "Candidato", email = "gustavo.nunes@gmail.com";
        boolean result = classMensageria.VerificaMensageriaUsuario(usuario, email);  
        assertTrue(result, "Retorna verdadeiro e as mensagens, sem erro"); 
    }
    
    @Test
    public void testGravaRecuperacaoSenha(){
        System.out.println("grava senha");
        String email = "gustavo.nunes@gmail.com";
        
        //TESTES PLANEJADOS 
        //Testa numero fora de 1 e 4, ou outros digitos
        boolean result = classGravaRecuperacaoSenha.GravaRecuperaSenha(email);
        assertFalse(result, "Numero fora entre 1 e 4"); 
        
        //Testa resposta nao digitada
        result = classGravaRecuperacaoSenha.GravaRecuperaSenha(email);
        assertFalse(result, "Resposta não digitada"); 
        
        //Teste correto
        result = classGravaRecuperacaoSenha.GravaRecuperaSenha(email);
        assertTrue(result, "Retorna true pois tudo foi enviado"); 
    }
    
    @Test
    public void testExclusaoEmpresa(){
        System.out.println("exclui empresa");
        //TESTES PLANEJADOS 
        String CNPJ = "12.345.678/0001-99", senha = "admin";
        
        //Testa se o valor 'S' não for confirmado
        boolean result = classExclusaoEmpresa.confirmaExclusao(CNPJ, senha);
        assertFalse(result, "Deve vir falso, pois não foi confirmado com o S - Sim"); 
        
        //Testa se a senha for vazia
        senha = null;
        result = classExclusaoEmpresa.confirmaExclusao(CNPJ, senha);
        assertFalse(result, "Deve vir falso, pois senha esta vazia"); 
        
        //Testa se a senha for vazia
        senha = "admin";
        result = classExclusaoEmpresa.confirmaExclusao(CNPJ, senha);
        assertFalse(result, "Deve vir falso, pois senha esta vazia"); 
        
        //Testa verdadeiro
        senha = "admin";
        result = classExclusaoEmpresa.confirmaExclusao(CNPJ, senha);
        assertTrue(result, "Deve vir verdadeiro e apagar a conta");  
    }
    
    
    
    @Test
    public void testExclusaoCandidato(){
        System.out.println("exclui candidato");
        //TESTES PLANEJADOS 
        String CPF = "529.982.247-25", senha = "senhaForte456";
        
        //Testa se o valor 'S' não for confirmado
        boolean result = classExclusaoCandidato.confirmaExclusao(CPF, senha);
        assertFalse(result, "Deve vir falso, pois não foi confirmado com o S - Sim"); 
        
        //Testa se a senha for vazia
        senha = null;
        result = classExclusaoCandidato.confirmaExclusao(CPF, senha);
        assertFalse(result, "Deve vir falso, pois senha esta vazia"); 
        
        //Testa se a senha for vazia
        senha = "admin123";
        result = classExclusaoCandidato.confirmaExclusao(CPF, senha);
        assertFalse(result, "Deve vir falso, pois senha esta vazia"); 
        
        //Testa se a senha for vazia
        senha = "admin123";
        result = classExclusaoCandidato.confirmaExclusao(CPF, senha);
        assertTrue(result, "Deve vir verdadeiro e apagar a conta");  
    }
    
    @Test
    public void testConfirmaEmpresa(){  
        System.out.println("Confirma empresa");
        boolean resultado; 
        // Dados da empresa simulados
        String sNomeResponsavel = "João da Silva";
        JPasswordField tfSenha = new JPasswordField();
        tfSenha.setText("admin12345");  // simula o preenchimento do campo
        String sEmail = "roro.jose@empresa.com";
        String sCNPJ = "12.451.231/0001-99";
        String sEmpresa = "LTDA";
        String sCEP = "12345-678";
        String sEndereco = "Rua Exemplo, 100";
        String sAreaAtuacao = "Tecnologia da Informação para Finanças";
        String sResumoEmpresa = "Empresa de tecnologia focada em soluções inovadoras para o mercado financeiro e digital.";

        String senhaAnterior = "senhaSegura123";
        
        //TESTES PLANEJADOS
        //Testa se senha digitada for vazia
        resultado = classConfirmaEmpresa.confirmaEmpresa(
            senhaAnterior, tfSenha, sNomeResponsavel, sEmail, sCNPJ, sEmpresa,
            sCEP, sEndereco, sAreaAtuacao, sResumoEmpresa
        );  
        assertFalse(resultado, "Deve vir falso, pois senha digitada é vazia");
        
        //Testa se senha digitada é diferente da anterior
        resultado = classConfirmaEmpresa.confirmaEmpresa(
            senhaAnterior, tfSenha, sNomeResponsavel, sEmail, sCNPJ, sEmpresa,
            sCEP, sEndereco, sAreaAtuacao, sResumoEmpresa
        );  
        assertFalse(resultado, "Deve vir falso, pois senha digitada é diferente da anterior");
        
        //Testa caso valido
        resultado = classConfirmaEmpresa.confirmaEmpresa(
            senhaAnterior, tfSenha, sNomeResponsavel, sEmail, sCNPJ, sEmpresa,
            sCEP, sEndereco, sAreaAtuacao, sResumoEmpresa
        );  
        assertTrue(resultado, "Deve vir verdadeiro");
    } 
}
