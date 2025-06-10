/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Test;
 
import com.eleva.eleva.Controller.DatabaseManager;
import com.eleva.eleva.Model.classCNPJValido;
import com.eleva.eleva.Model.classCPFInvalido;
import com.eleva.eleva.Model.classCadastraCandidato;
import com.eleva.eleva.Model.classCadastroEmpresa;
import com.eleva.eleva.Model.classConfirmaCandidato;
import com.eleva.eleva.Model.classConfirmaEmpresa;
import com.eleva.eleva.Model.classCurriculo;
import com.eleva.eleva.Model.classEmail;
import com.eleva.eleva.Model.classExclusaoCandidato;
import com.eleva.eleva.Model.classExclusaoEmpresa;
import com.eleva.eleva.Model.classLogin;
import com.eleva.eleva.Model.classMensageria;
import com.eleva.eleva.Model.classRecusaNumeros;
import com.eleva.eleva.Model.classValidaCampos;
import com.eleva.eleva.Model.classValidaCandidato;
import com.eleva.eleva.Model.classValidaData;
import com.eleva.eleva.Model.classValidaRecrutador;
import com.eleva.eleva.Model.classVerificaLinhaSelecionada;
import java.io.FileInputStream;
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
        
public class classPontaAPonta {
    @Test
    public void testCandidatoPontaAPonta(){ 
        boolean result;
          
         
        //Valida tamanho dos campos
        String Nome_Responsavel = "Usuario Teste Oliveira";
        String Nome_ou_Empresa = "Usuario Teste Oliveira"; 
        String Senha = "senhaForte45612";
        String Atuacao     = "Programador Junior";
        String usuario         = "Usuario Teste Oliveira";   
        String CEP             = "04474-240";
        String cpf             = "983.070.610-91";
        String contato         = "(11)95555-8424";
        String Email           = "oliveira.oliveira@email.com";
        String Endereco        = "Rua Miguel Fleta";
        String Resumo   = "Programador Junior com 3 anos de xp em Java e C# Profissional"; 
        String tipoUsuario = "Candidato"; 
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertTrue(result, "Deve retornar verdadeiro"); 
        
        
        
        
        //Verifica se existe numeros para campos como: nome  
        Nome_Responsavel = "Usuario Teste Oliveira";
        result = classRecusaNumeros.contemNumeros(Nome_Responsavel);
        assertFalse(result, "Deve retornar falso");
        
        
        
        
        //Valida email
        result = classEmail.Validacao(Email); 
        assertTrue(result, "Deve retornar verdadeiro"); 
        
        
         
        
        
        //Ao cadastrar, verifica se já existe um usuario no banco de dados após as verificações dos campos 
        //Verificando pelo CPF e e-mail do usuario
        JTextField tfNome = new JTextField("Usuario Teste Oliveira");
        JTextField tfAtuacao = new JTextField("Programador Junior");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField("983.070.610-91");
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("oliveira.oliveira@email.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp em Java e C# Profissional");
        JPasswordField tfSenha = new JPasswordField("senhaForte45612");
        JPasswordField tfSenhaConfirma = new JPasswordField("senhaForte45612"); 
        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100);
        String senhaStr = new String(tfSenha.getPassword());
        String tela = "Cadastro";
        String nascimento = "04/04/2004"; 
        result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        ); 
        assertTrue(result, "Deve retornar verdadeiro pois não existe um participante com os dados");
         
            
         
        
        
        //Valida data de nascimento
        result = classValidaData.dataNascimentoValida(nascimento);
        assertTrue(result, "Deve retornar verdadeiro");
        
        
        
        
        
        //Cadastra
        result = classCadastraCandidato.cadastraCandidato(Atuacao,  CEP,  cpf,  contato,  Email, 
             Endereco,  Senha,  Resumo,  Nome_ou_Empresa, dados,  nascimento);
        
        
        
        
        
        
        //Verifica o tipo de usuario ao fazer login
        Email = "oliveira.oliveira@email.com";
        Senha = "senhaForte45612";
        String retorno = classLogin.retornaTipologin(Email, Senha);
        assertEquals(retorno, "Candidato"); //DEVE RETORNAR TIPO DE CANDIDATO JA CADASTRADO
        
        
        
        
        //Realiza o Login
        result = classLogin.tryLogin(retorno, Email, Senha);
        assertTrue(result, "Deve retornar verdadeiro");
        
 
        
        
        
        
        //Teste de recebimento de mensagem 
        result = classMensageria.VerificaMensageriaUsuario(retorno, Email);  
        assertTrue(result, "Retorna verdadeiro e as mensagens, sem erro"); 
        
        
        
        
        
        //Atualização de perfil
        String senhaAnterior = "senhaForte45612"; 
        Atuacao = "Profissional Developer";
        //RESULTADO APROVADO
        result = classConfirmaCandidato.confirmaCandidato(senhaAnterior, tfSenha, Atuacao, CEP, cpf, contato, Email, Endereco, Resumo, usuario, dados);
        assertTrue(result, "Deve retornar verdadeiro");
        
        
        
        
        
        //Exclusão de conta 
        result = classExclusaoCandidato.confirmaExclusao(cpf, Senha);
        assertTrue(result, "Deve vir verdadeiro e apagar a conta");  
    }
     
    
    @Test
    public void testEmpresaPontaAPonta() {
        boolean result;
          
         
        //Valida tamanho dos campos
        String Nome_Responsavel = "Usuario Teste Nunes";
        String Nome_ou_Empresa = "Empresa Teste Senac"; 
        String Senha = "senhaForte45612";
        String Atuacao     = "Empresa De Programação";
        String usuario         = "Usuario Teste Nunes";   
        String CEP             = "04474-240";
        String cnpj             = "25.183.637/0001-91";
        String contato         = "(11)95555-8424";
        String Email           = "empresaTI@email.com";
        String Endereco        = "Rua Miguel Fleta";
        String Resumo   = "Empresa de TI para o mercado digital e da educação nacional"; 
        String tipoUsuario = "Empresa"; 
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertTrue(result, "Deve retornar verdadeiro"); 
        
        
        
        
        //Verifica se existe numeros para campos como: nome   
        result = classRecusaNumeros.contemNumeros(Nome_Responsavel);
        assertFalse(result, "Deve retornar falso");
        
         
        
        
        
        
        //Valida email
        result = classEmail.Validacao(Email); 
        assertTrue(result, "Deve retornar verdadeiro"); 
        
        
        
         
        
        
        //Ao cadastrar, verifica se já existe um usuario no banco de dados após as verificações dos campos 
        //Verificando pelo CPF e e-mail do usuario
        JTextField tfResponsavel = new JTextField("Usuario Teste Nunes");
        JTextField tfAtuacao = new JTextField("Empresa Teste Senac");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCNPJ = new JTextField("25.183.637/0001-91"); 
        JTextField tfEmail = new JTextField("empresaTI@email.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Empresa de TI para o mercado digital e da educação nacional");
        JPasswordField tfSenha = new JPasswordField("senhaForte45612");
        JPasswordField tfSenhaConfirma = new JPasswordField("senhaForte45612"); 
        result = classValidaRecrutador.ValidacaoCadastroRecrutador(tfAtuacao, tfCEP, tfCNPJ, tfResponsavel, tfEmail, tfEndereco, tfResumo, tfSenha, tfSenhaConfirma);
        assertTrue(result, "Deve retornar VERDADEIRO");
         
              
        
        
        
        //Cadastra
        result = classCadastroEmpresa.cadastraEmpresa(Nome_Responsavel, Email, Senha, cnpj, Nome_ou_Empresa, CEP, Endereco, Atuacao, Resumo);
        
        
        
        
        
        
        
        //Verifica o tipo de usuario ao fazer login
        Email = "empresaTI@email.com";
        Senha = "senhaForte45612";
        String retorno = classLogin.retornaTipologin(Email, Senha);
        assertEquals(retorno, "Recrutador"); //DEVE RETORNAR TIPO DE CANDIDATO JA CADASTRADO
        
        
        
        
        
        
        //Realiza o Login
        result = classLogin.tryLogin(retorno, Email, Senha);
        assertTrue(result, "Deve retornar verdadeiro");
        
  
        
        
        
        //Atualização de perfil
        String senhaAnterior = "senhaForte45612"; 
        Atuacao = "Empresa de TI de Produção";
        result  = classConfirmaEmpresa.confirmaEmpresa(
            senhaAnterior, tfSenha, Nome_Responsavel, Email, cnpj, Nome_ou_Empresa,
            CEP, Endereco, Atuacao, Resumo);  
        assertTrue(result, "Deve vir verdadeiro");
         
        
        
        
        
        //Envia mensagem
        result = classMensageria.VerificaMensageriaUsuario(retorno, Email); 
        assertTrue(result, "Retorna verdadeiro pois foi digitado a mensagem e nome da empresa");
        
        
         
        
        //Exclusão de conta 
        result = classExclusaoEmpresa.confirmaExclusao(cnpj, Senha);
        assertTrue(result, "Deve vir verdadeiro e apagar a conta");  
    }
} 

