/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eleva.eleva.Test;

import com.eleva.eleva.Controller.DatabaseManager;
import com.eleva.eleva.Model.classCNPJValido;
import com.eleva.eleva.Model.classCPFInvalido;
import com.eleva.eleva.Model.classConfirmaCandidato;
import com.eleva.eleva.Model.classCurriculo;
import com.eleva.eleva.Model.classEmail;
import com.eleva.eleva.Model.classLogin;
import com.eleva.eleva.Model.classRecusaNumeros;
import com.eleva.eleva.Model.classValidaCampos;
import com.eleva.eleva.Model.classValidaCandidato;
import com.eleva.eleva.Model.classValidaData;
import com.eleva.eleva.Model.classValidaRecrutador;
import com.eleva.eleva.Model.classVerificaLinhaSelecionada;
import java.io.FileInputStream;
import java.util.Arrays;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Gustavo
 */
public class classUnitarioTest {
    @Test
    public void testCPFCandidato() {
        classCPFInvalido CPF  = new classCPFInvalido();
        //PRIMEIRO TESTE - CPF INVALIDO
        boolean result = CPF.isCPFValido("111.111.111-11");
        assertFalse(result, "Falso pois CPF invalido");
        
        boolean result1 = CPF.isCPFValido("493.575.468-04");
        assertTrue(result1, "Verdadeiro pois CPF valido");
        //TESTE APROVADO 100%
        //1 TENTATIVA
        //0,041s DE TEMPO
    }
    
    @Test
    public void testValidaCadastroCandidato_NomeVazio() {
        // Configuração dos campos (nome vazio)
        JTextField tfNome = new JTextField();
        JTextField tfAtuacao = new JTextField("Programador");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField("493.575.468-04");
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("gustavo.nunes@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfNome.setText(""); // Campo sendo testado vazio

        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100); 
        String tela = "Cadastro";

        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertFalse(result, "Deve retornar falso quando nome está vazio");
        //TESTE VALIDADO 100%
        //1 TENTATIVA
        //TEMPO 3,14 segundos
    }
    
    @Test
    public void testValidaCadastroCandidato_AtuacaoVazia() {
        // Configuração dos campos (atuacao vazia)
        JTextField tfNome = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField();
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField("493.575.468-04");
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("gustavo.nunes@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfAtuacao.setText(""); // Campo sendo testado vazio

        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100); 
        String tela = "Cadastro";

        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertFalse(result, "Deve retornar falso quando atuação está vazia");
        //TESTE VALIDADO 100%
        //1 TENTATIVA
        //TEMPO 2,162 segundos
    }
    
    @Test
    public void testValidaCadastroCandidato_CEPVazio() {
        // Configuração dos campos (CEP vazio)
        JTextField tfNome = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Programador");
        JTextField tfCEP = new JTextField();
        JTextField tfCPF = new JTextField("493.575.468-04");
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("gustavo.nunes@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfCEP.setText(""); // Campo sendo testado vazio

        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100); 
        String tela = "Cadastro";

        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertFalse(result, "Deve retornar falso quando CEP está vazio");
        //TESTE VALIDADO 100%
        //1 TENTATIVA
        //TEMPO 1,787 segundos
    }
    
    @Test
    public void testValidaCadastroCandidato_CPFVazio() {
        // Configuração dos campos (CPF vazio)
        JTextField tfNome = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Programador");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField();
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("gustavo.nunes@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfCPF.setText(""); // Campo sendo testado vazio

        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100); 
        String tela = "Cadastro";

        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertFalse(result, "Deve retornar falso quando CPF está vazio");
    }
    
    @Test
    public void testValidaCadastroCandidato_ContatoVazio() {
        // Configuração dos campos (Contato vazio)
        JTextField tfNome = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Programador");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField("493.575.468-04");
        JTextField tfContato = new JTextField();
        JTextField tfEmail = new JTextField("gustavo.nunes@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfContato.setText(""); // Campo sendo testado vazio

        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100); 
        String tela = "Cadastro";

        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertFalse(result, "Deve retornar falso quando Contato está vazio");
    }
    
    @Test
    public void testValidaCadastroCandidato_EmailVazio() {
        // Configuração dos campos (Email vazio)
        JTextField tfNome = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Programador");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField("493.575.468-04");
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField();
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfEmail.setText(""); // Campo sendo testado vazio

        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100); 
        String tela = "Cadastro";

        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertFalse(result, "Deve retornar falso quando Email está vazio");
    }
    
    @Test
    public void testValidaCadastroCandidato_EnderecoVazio() {
        // Configuração dos campos (Endereco vazio)
        JTextField tfNome = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Programador");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField("493.575.468-04");
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("gustavo.nunes@gmail.com");
        JTextField tfEndereco = new JTextField();
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfEndereco.setText(""); // Campo sendo testado vazio

        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100); 
        String tela = "Cadastro";

        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertFalse(result, "Deve retornar falso quando Endereço está vazio");
    }
    
    @Test
    public void testValidaCadastroCandidato_ResumoVazio() {
        // Configuração dos campos (Resumo vazio)
        JTextField tfNome = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Programador");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField("493.575.468-04");
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("gustavo.nunes@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea();
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfResumo.setText(""); // Campo sendo testado vazio

        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100); 
        String tela = "Cadastro";

        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertFalse(result, "Deve retornar falso quando Resumo está vazio");
    }
    
    @Test
    public void testValidaCadastroCandidato_SenhaVazia() {
        // Configuração dos campos (Senha vazia)
        JTextField tfNome = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Programador");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField("493.575.468-04");
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("gustavo.nunes@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField();
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfSenha.setText(""); // Campo sendo testado vazio

        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100); 
        String tela = "Cadastro";

        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertFalse(result, "Deve retornar falso quando Senha está vazia");
    }
    
    @Test
    public void testValidaCadastroCandidato_SenhaConfirmaVazia() {
        // Configuração dos campos (SenhaConfirma vazia)
        JTextField tfNome = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Programador");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField("493.575.468-04");
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("gustavo.nunes@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField();

        tfSenhaConfirma.setText(""); // Campo sendo testado vazio

        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100); 
        String tela = "Cadastro";

        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertFalse(result, "Deve retornar falso quando Senha de Confirmação está vazia");
    }
    
    @Test
    public void testValidaCadastroCandidato_CurriculoVazio() {
        // Configuração dos campos (Curriculo vazio)
        JTextField tfNome = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Programador");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField("493.575.468-04");
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("gustavo.nunes@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        byte[] dados = new byte[0]; // Curriculo vazio
        String tela = "Cadastro";

        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertFalse(result, "Deve retornar falso quando Currículo está vazio");
    }
    
    @Test
    public void testValidaCadastroCandidato_SenhasCoincidem() {
        // Configuração dos campos (Curriculo vazio)
        JTextField tfNome = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Programador");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField("493.575.468-04");
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("gustavo.nunes@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField("admin12345678");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100); 
        String tela = "Cadastro";

        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertFalse(result, "Deve retornar falso pois senhas são diferentes");
    }
    
    public void testValidaCadastroCandidato() {
        // Configuração dos campos (Curriculo vazio)
        JTextField tfNome = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Programador");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCPF = new JTextField("493.575.468-04");
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("gustavo.nunes@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        byte[] dados = new byte[1];  
        Arrays.fill(dados, (byte) 100); 
        String tela = "Cadastro";

        boolean result = classValidaCandidato.ValidacaoCadastroCandidato(
            tfNome, tfAtuacao, tfCEP, tfCPF, tfContato, tfEmail, 
            tfEndereco, tfResumo, tfSenha, tfSenhaConfirma, dados, tela
        );

        assertTrue(result, "Deve retornar verdadeiro");
    }
    
    @Test
    public void testValidaNascimento(){
        //Faz as validações para a data de nascimento do participante
        //Primeiro valida se data é null
        String nascimento = "";
        boolean result;
        result = classValidaData.dataNascimentoValida(nascimento);
        assertFalse(result, "Deve retornar falso pois data é vazia");
        
        //Valida se é uma data futura
        nascimento = "30/07/2028"; 
        result = classValidaData.dataNascimentoValida(nascimento);
        assertFalse(result, "Deve retornar falso pois data é futura");
        
        nascimento = "30/07/1800"; 
        result = classValidaData.dataNascimentoValida(nascimento);
        assertFalse(result, "Deve retornar falso pois ultrapassou ano limite de 130 anos");
        
        nascimento = "31/02/2002"; 
        result = classValidaData.dataNascimentoValida(nascimento);
        assertFalse(result, "Deve retornar falso pois data não existe");
        
        nascimento = "04/04/2004"; 
        result = classValidaData.dataNascimentoValida(nascimento);
        assertTrue(result, "Deve retornar verdadeiro");
        
        //TESTES APROVADOS 100% DE APROVAÇÃO
        //TEMPO 7.8 Segundos
        //1 TENTATIVA
    }
      
    @Test
    public void testEmailValido(){
        //Verifica se email é valido
        String email = "";
        boolean result; 
        
        email = "gustavonunes.com";
        result = classEmail.Validacao(email); 
        assertFalse(result, "Deve retornar falso");
        
        email = "gustavonunes123@gmail.com";
        result = classEmail.Validacao(email); 
        assertTrue(result, "Deve retornar verdadeiro"); 
    }
    
    @Test
    public void testContemNumeros(){
        //Verifica se existe numeros para campos como: nome
        boolean result;
        String texto;
        
        texto = "Gustavo1 de Oliveira2";
        result = classRecusaNumeros.contemNumeros(texto);
        assertTrue(result, "Deve retornar verdadeiro");
        
        texto = "Gustavo de Oliveira";
        result = classRecusaNumeros.contemNumeros(texto);
        assertFalse(result, "Deve retornar falso");
    }
    
    @Test
    public void testValidaCamposCandidato_Nome(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes de Oliveirassssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
        String Nome_ou_Empresa = "Gustavo Nunes de Oliveiraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasssssssssssssssssssssssssssss"; 
        String Senha = "admin1234";
        String Atuacao     = "Programador"; 
        String CEP             = "04474-240"; 
        String contato         = "(11)95555-8424";
        String Email           = "gustavo.nunes0422@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Programador Junior com 4 anos de xp"; 
        String tipoUsuario = "Candidato";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois nome é maior do que o disponivel");
        
        Nome_Responsavel = "G";
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois nome é menor do que o disponivel");
    }
    
    public void testValidaCamposCandidato_Senha(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes de Oliveira";
        String Nome_ou_Empresa = "Gustavo Nunes de Oliveira"; 
        String Senha = "admin123467890101010101010101010101111111111111111111111111111111111111111111101010101010101011010010101010101010101010101001000000011111111111111000000000";
        String Atuacao     = "Programador";   
        String CEP             = "04474-240"; 
        String contato         = "(11)95555-8424";
        String Email           = "gustavo.nunes0422@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Programador Junior com 4 anos de xp"; 
        String tipoUsuario = "Candidato";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois senha é maior do que o disponivel");
                
        Senha = "aaa1";
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel,contato, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois senha é menor do que o disponivel");
    }
    
    public void testValidaCamposCandidato_Atuacao(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes de Oliveira";
        String Nome_ou_Empresa = "Gustavo Nunes de Oliveira"; 
        String Senha = "admin1234";
        String Atuacao     = "Programadoraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"; 
        String CEP             = "04474-240"; 
        String contato         = "(11)95555-8424";
        String Email           = "gustavo.nunes0422@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Programador Junior com 4 anos de xp"; 
        String tipoUsuario = "Candidato";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois atuação é maior do que o disponivel");
        
        Atuacao = "Test";
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois atuação é menor do que o disponivel");
    }
    
    public void testValidaCamposCandidato_CEP(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes de Oliveira";
        String Nome_ou_Empresa = "Gustavo Nunes de Oliveira"; 
        String Senha = "admin1234";
        String Atuacao     = "Programador";   
        String CEP             = "21211";
        String cpf             = "493.575.468-04";
        String contato         = "(11)95555-8424";
        String Email           = "gustavo.nunes0422@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Programador Junior com 4 anos de xp"; 
        String tipoUsuario = "Candidato";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois CEP é invalido"); 
    }
    
    
    public void testValidaCamposCandidato_Email(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes de Oliveira";
        String Nome_ou_Empresa = "Gustavo Nunes de Oliveira"; 
        String Senha = "admin1234";
        String Atuacao     = "Programador";
        String usuario         = "Gustavo Nunes";   
        String CEP             = "04474-240";
        String cpf             = "493.575.468-04";
        String contato         = "(11)95555-8424";
        String Email           = "gustavo.nunes0422@gmail.commmmmmmaaaaaaaaaaaaaaaaaaaaaaaaammmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Programador Junior com 4 anos de xp"; 
        String tipoUsuario = "Candidato";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois EMAIL é maior do que o disponivel");
         
    }
    
    public void testValidaCamposCandidato_Endereco(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes de Oliveira";
        String Nome_ou_Empresa = "Gustavo Nunes de Oliveira"; 
        String Senha = "admin1234";
        String Atuacao     = "Programador";
        String usuario         = "Gustavo Nunes";   
        String CEP             = "04474-240";
        String cpf             = "493.575.468-04";
        String contato         = "(11)95555-8424";
        String Email           = "gustavo.nunes0422@gmail.com";
        String Endereco        = "rua miguel fletaaiiiiqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";
        String Resumo   = "Programador Junior com 4 anos de xp"; 
        String tipoUsuario = "Candidato";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois endereço é maior do que o disponivel");
        
        Endereco = "rua a ";
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois endereço é menor do que o disponivel");
    }
    
    public void testValidaCamposCandidato_Resumo(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes de Oliveira";
        String Nome_ou_Empresa = "Gustavo Nunes de Oliveira"; 
        String Senha = "admin1234";
        String Atuacao     = "Programador"; 
        String CEP             = "04474-240"; 
        String contato         = "(11)95555-8424";
        String Email           = "gustavo.nunes0422@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo        = "Programador Junior eiiiiiiiissssssssssssssssssssssssssssssssssssiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";
        String tipoUsuario = "Candidato";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois resumo é maior do que o disponivel");
        
        Resumo = "TestResusmo";
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois resumo é menor do que o disponivel");
    }
    
    public void testValidaCamposCandidato_Contato(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes de Oliveira";
        String Nome_ou_Empresa = "Gustavo Nunes de Oliveira"; 
        String Senha = "admin1234";
        String Atuacao     = "Programador"; 
        String CEP             = "04474-240"; 
        String contato         = "(11)95555-8";
        String Email           = "gustavo.nunes0422@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo        = "Programador Junior";
        String tipoUsuario = "Candidato";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois contato é menor do que o disponivel"); 
    }
     
    
    public void testValidaCamposCandidato(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes de Oliveira";
        String Nome_ou_Empresa = "Gustavo Nunes de Oliveira"; 
        String Senha = "admin1234";
        String Atuacao     = "Programador";
        String usuario         = "Gustavo Nunes";   
        String CEP             = "04474-240";
        String cpf             = "493.575.468-04";
        String contato         = "(11)95555-8424";
        String Email           = "gustavo.nunes0422@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Programador Junior com 4 anos de xp na area de programação com Java e C#"; 
        String tipoUsuario = "Candidato";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, contato, Nome_ou_Empresa, tipoUsuario);
        assertTrue(result, "Deve retornar verdadeiro");
    }
    
    @Test
    public void testBaixaCurriculo(){
        byte[] pdfBytes = "".getBytes();
        boolean result;
        
        //Testa se o arquivo foi vazio
        result = classCurriculo.salvarCurriculoParaTestar(pdfBytes);
        assertFalse(result, "Deve retornar falso pois curriculo é vazio para salvar"); 
        
        pdfBytes = "curriculo teste".getBytes();
        //Testa se cancelar 
        result = classCurriculo.salvarCurriculoParaTestar(pdfBytes);
        assertFalse(result, "Deve retornar falso, pois ação foi cancelada"); 
         
        
        result = classCurriculo.salvarCurriculoParaTestar(pdfBytes);
        assertTrue(result, "Deve retornar verdadeiro"); 
    }
    
    @Test
    public void testEditarCurriculo(){
        byte[] pdfBytes;
        boolean result;  
        
        //Testa se operação é cancelada
        pdfBytes = classCurriculo.editarCurriculo();
        assertNull(pdfBytes , "Deve retornar nulo, pois operação de seleção é cancelada"); 
        
        //Testa se operação é cancelada
        pdfBytes = classCurriculo.editarCurriculo();
        assertTrue(pdfBytes.length > 0 , "Deve retornar verdadeiro, pois existe registro");  
    }
    
    @Test
    public void testBuscarCurriculo(){
        byte[] pdfBytes;
        boolean result;  
        
        //Testa se operação é cancelada
        pdfBytes = classCurriculo.buscarCurriculo();
        assertNull(pdfBytes , "Deve retornar nulo, pois operação de seleção é cancelada");  
        
        //Testa se operação é cancelada
        pdfBytes = classCurriculo.buscarCurriculo(); 
        assertTrue(pdfBytes.length > 0 , "Deve retornar verdadeiro, pois existe registro");  
    }
    
    @Test
    public void testUnitarioLogin(){
        //Validação de campos vazios no login
        JTextField tfEmail = new JTextField("");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        boolean result = classLogin.ValidacaoLogin(tfEmail, tfSenha);
        assertFalse(result, "Deve retornar falso pois e-mail é vazio");
        
        JTextField tfEmail1 = new JTextField("gustavo.nunes0422@gmail.com");
        JPasswordField tfSenha1 = new JPasswordField("");
        result = classLogin.ValidacaoLogin(tfEmail1, tfSenha1);
        assertFalse(result, "Deve retornar falso pois senha é vazio");
        
        JTextField tfEmail2 = new JTextField("gustavo.nunes0422@gmail.com");
        JPasswordField tfSenha2 = new JPasswordField("admin123");
        result = classLogin.ValidacaoLogin(tfEmail2, tfSenha2);
        assertTrue(result, "Deve retornar verdadeiro");
    }
    
    @Test 
    public void testCNPJValido(){
        String cnpj = "11.111.111/1111-11"; 
        boolean result = classCNPJValido.isCNPJValido(cnpj); 
        assertFalse(result, "Deve retornar falso pois cnpj é invalido");
        
        cnpj = "77.844.068/0001-81";
        result = classCNPJValido.isCNPJValido(cnpj);
        assertTrue(result, "Deve retornar verdadeiro pois cnpj é valido");
    }
    
    @Test
    public void testValidaCamposRecrutador_ResponsavelLegal(){ 
        JTextField tfResponsavel = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Empresa de TI Financeira");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCNPJ = new JTextField();
        JTextField tfContato = new JTextField("(11)95555-8424");
        JTextField tfEmail = new JTextField("gustavo.nunes@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Miguel Fleta");
        JTextArea tfResumo = new JTextArea("Programador Junior com 3 anos de xp");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfResponsavel.setText(""); // Campo sendo testado vazio
  
        boolean result = classValidaRecrutador.ValidacaoCadastroRecrutador(tfAtuacao, tfCEP, tfCNPJ, tfResponsavel, tfEmail, tfEndereco, tfResumo, tfSenha, tfSenhaConfirma);

        assertFalse(result, "Deve retornar falso quando responsavel está vazio");
    }
    
    @Test
    public void testValidaCamposRecrutador_AtuacaoEmpresarial(){ 
        JTextField tfResponsavel = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Empresa de TI Financeira");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCNPJ = new JTextField("77.844.068/0001-81"); 
        JTextField tfEmail = new JTextField("sinqia@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Bela Cintra, 755");
        JTextArea tfResumo = new JTextArea("Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfAtuacao.setText(""); // Campo sendo testado vazio
  
        boolean result = classValidaRecrutador.ValidacaoCadastroRecrutador(tfAtuacao, tfCEP, tfCNPJ, tfResponsavel, tfEmail, tfEndereco, tfResumo, tfSenha, tfSenhaConfirma); 
        assertFalse(result, "Deve retornar falso quando atuação está vazio");
    }
    
    @Test
    public void testValidaCamposRecrutador_CEP(){ 
        JTextField tfResponsavel = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Empresa de TI Financeira");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCNPJ = new JTextField("77.844.068/0001-81"); 
        JTextField tfEmail = new JTextField("sinqia@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Bela Cintra, 755");
        JTextArea tfResumo = new JTextArea("Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");
        
        tfCEP.setText(""); // Campo sendo testado vazio
  
        boolean result = classValidaRecrutador.ValidacaoCadastroRecrutador(tfAtuacao, tfCEP, tfCNPJ, tfResponsavel, tfEmail, tfEndereco, tfResumo, tfSenha, tfSenhaConfirma);

        assertFalse(result, "Deve retornar falso quando CEP está vazio");
    }
    
    @Test
    public void testValidaCamposRecrutador_CNPJ(){ 
        JTextField tfResponsavel = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Empresa de TI Financeira");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCNPJ = new JTextField("77.844.068/0001-81"); 
        JTextField tfEmail = new JTextField("sinqia@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Bela Cintra, 755");
        JTextArea tfResumo = new JTextArea("Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfCNPJ.setText(""); // Campo sendo testado vazio
  
        boolean result = classValidaRecrutador.ValidacaoCadastroRecrutador(tfAtuacao, tfCEP, tfCNPJ, tfResponsavel, tfEmail, tfEndereco, tfResumo, tfSenha, tfSenhaConfirma);

        assertFalse(result, "Deve retornar falso quando CNPJ está vazio");
    }
    
    @Test
    public void testValidaCamposRecrutador_EMAIL(){ 
        JTextField tfResponsavel = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Empresa de TI Financeira");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCNPJ = new JTextField("77.844.068/0001-81"); 
        JTextField tfEmail = new JTextField("sinqia@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Bela Cintra, 755");
        JTextArea tfResumo = new JTextArea("Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfEmail.setText(""); // Campo sendo testado vazio
  
        boolean result = classValidaRecrutador.ValidacaoCadastroRecrutador(tfAtuacao, tfCEP, tfCNPJ, tfResponsavel, tfEmail, tfEndereco, tfResumo, tfSenha, tfSenhaConfirma);

        assertFalse(result, "Deve retornar falso quando Email está vazio");
    }
    
    @Test
    public void testValidaCamposRecrutador_Endereco(){ 
        JTextField tfResponsavel = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Empresa de TI Financeira");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCNPJ = new JTextField("77.844.068/0001-81"); 
        JTextField tfEmail = new JTextField("sinqia@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Bela Cintra, 755");
        JTextArea tfResumo = new JTextArea("Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfEndereco.setText(""); // Campo sendo testado vazio
  
        boolean result = classValidaRecrutador.ValidacaoCadastroRecrutador(tfAtuacao, tfCEP, tfCNPJ, tfResponsavel, tfEmail, tfEndereco, tfResumo, tfSenha, tfSenhaConfirma);

        assertFalse(result, "Deve retornar falso quando endereço está vazio");
    }
    
    @Test
    public void testValidaCamposRecrutador_ResumoEmpresa(){ 
        JTextField tfResponsavel = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Empresa de TI Financeira");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCNPJ = new JTextField("77.844.068/0001-81"); 
        JTextField tfEmail = new JTextField("sinqia@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Bela Cintra, 755");
        JTextArea tfResumo = new JTextArea("Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfResumo.setText(""); // Campo sendo testado vazio
  
        boolean result = classValidaRecrutador.ValidacaoCadastroRecrutador(tfAtuacao, tfCEP, tfCNPJ, tfResponsavel, tfEmail, tfEndereco, tfResumo, tfSenha, tfSenhaConfirma);

        assertFalse(result, "Deve retornar falso quando resumo está vazio");
    }
    
    @Test
    public void testValidaCamposRecrutador_Senha1(){ 
        JTextField tfResponsavel = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Empresa de TI Financeira");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCNPJ = new JTextField("77.844.068/0001-81"); 
        JTextField tfEmail = new JTextField("sinqia@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Bela Cintra, 755");
        JTextArea tfResumo = new JTextArea("Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfSenha.setText(""); // Campo sendo testado vazio
  
        boolean result = classValidaRecrutador.ValidacaoCadastroRecrutador(tfAtuacao, tfCEP, tfCNPJ, tfResponsavel, tfEmail, tfEndereco, tfResumo, tfSenha, tfSenhaConfirma);

        assertFalse(result, "Deve retornar falso quando senha está vazio");
    }
    
    @Test
    public void testValidaCamposRecrutador_Senha2(){ 
        JTextField tfResponsavel = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Empresa de TI Financeira");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCNPJ = new JTextField("77.844.068/0001-81"); 
        JTextField tfEmail = new JTextField("sinqia@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Bela Cintra, 755");
        JTextArea tfResumo = new JTextArea("Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");

        tfSenhaConfirma.setText(""); // Campo sendo testado vazio
  
        boolean result = classValidaRecrutador.ValidacaoCadastroRecrutador(tfAtuacao, tfCEP, tfCNPJ, tfResponsavel, tfEmail, tfEndereco, tfResumo, tfSenha, tfSenhaConfirma);

        assertFalse(result, "Deve retornar falso quando confirmação de senha está vazio");
    }
    
    @Test
    public void testValidaCamposRecrutador_SenhasCoincidem(){ 
        JTextField tfResponsavel = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Empresa de TI Financeira");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCNPJ = new JTextField("77.844.068/0001-81"); 
        JTextField tfEmail = new JTextField("sinqia@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Bela Cintra, 755");
        JTextArea tfResumo = new JTextArea("Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil");
        JPasswordField tfSenha = new JPasswordField("admin12344567");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");
 
        boolean result = classValidaRecrutador.ValidacaoCadastroRecrutador(tfAtuacao, tfCEP, tfCNPJ, tfResponsavel, tfEmail, tfEndereco, tfResumo, tfSenha, tfSenhaConfirma);

        assertFalse(result, "Deve retornar falso quando senhas não forem iguais");
    } 
    
    @Test
    public void testValidaCamposRecrutador(){ 
        JTextField tfResponsavel = new JTextField("Gustavo Nunes");
        JTextField tfAtuacao = new JTextField("Empresa de TI Financeira");
        JTextField tfCEP = new JTextField("04474-240");
        JTextField tfCNPJ = new JTextField("77.844.068/0001-81"); 
        JTextField tfEmail = new JTextField("sinqia12@gmail.com");
        JTextField tfEndereco = new JTextField("Rua Bela Cintra, 755");
        JTextArea tfResumo = new JTextArea("Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil");
        JPasswordField tfSenha = new JPasswordField("admin1234");
        JPasswordField tfSenhaConfirma = new JPasswordField("admin1234");
 
        boolean result = classValidaRecrutador.ValidacaoCadastroRecrutador(tfAtuacao, tfCEP, tfCNPJ, tfResponsavel, tfEmail, tfEndereco, tfResumo, tfSenha, tfSenhaConfirma);
        assertTrue(result, "Deve retornar VERDADEIRO");
    } 
    
    @Test
    public void testValidaCamposRecrutador_Nome_Responsavel(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes de Oliveiraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"; 
        String Nome_ou_Empresa = "Gustavo Nunes"; 
        String Senha = "admin1234";
        String Atuacao     = "Empresa de TI Financeira";  
        String CEP             = "04474-240"; 
        String Email           = "sinqia@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil"; 
        String tipoUsuario = "Empresa";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois nome é maior do que o disponivel");
        
        Nome_Responsavel = "S";
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois nome é menor do que o disponivel");
    }
    
    @Test
    public void testValidaCamposRecrutador_Nome_ou_Empresa(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes"; 
        String Nome_ou_Empresa = "Sinqia SAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"; 
        String Senha = "admin1234";
        String Atuacao     = "Empresa de TI Financeira";  
        String CEP             = "04474-240"; 
        String Email           = "sinqia@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil"; 
        String tipoUsuario = "Empresa";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois nome é maior do que o disponivel");
        
        Nome_ou_Empresa = "S";
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois nome é maior do que o disponivel");
    }
    
    @Test
    public void testValidaCamposRecrutador_Senha(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes"; 
        String Nome_ou_Empresa = "Sinqia SA"; 
        String Senha = "admin1231111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111114";
        String Atuacao     = "Empresa de TI Financeira";  
        String CEP             = "04474-240"; 
        String Email           = "sinqia@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil"; 
        String tipoUsuario = "Empresa";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois Senha é maior do que o disponivel");
        
        Senha = "aa";
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois Senha é menor do que o disponivel"); 
    }
    
    @Test
    public void testValidaCamposRecrutador_Atuacao(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes"; 
        String Nome_ou_Empresa = "Sinqia SA"; 
        String Senha = "admin1234";
        String Atuacao     = "Empresa de TI Financeiraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";  
        String CEP             = "04474-240"; 
        String Email           = "sinqia@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil"; 
        String tipoUsuario = "Empresa";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois atuação é maior do que o disponivel");
        
        Atuacao = "Test";
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois atuação é menor do que o disponivel");
    }
    
    @Test
    public void testValidaCamposRecrutador_TamanhoCEP(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes"; 
        String Nome_ou_Empresa = "Sinqia SA"; 
        String Senha = "admin1234";
        String Atuacao     = "Empresa de TI Financeira";  
        String CEP             = "04474-2"; 
        String Email           = "sinqia@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil"; 
        String tipoUsuario = "Empresa";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois CEP é menor do que o disponivel");
    }
    
    @Test
    public void testValidaCamposRecrutador_Email(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes"; 
        String Nome_ou_Empresa = "Sinqia SA"; 
        String Senha = "admin1234";
        String Atuacao     = "Empresa de TI Financeira";  
        String CEP             = "04474-240"; 
        String Email           = "sinqia@gmail.commmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil"; 
        String tipoUsuario = "Empresa";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois email é maior do que o disponivel");
    }
    
    @Test
    public void testValidaCamposRecrutador_EnderecoTamanho(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes"; 
        String Nome_ou_Empresa = "Sinqia SA"; 
        String Senha = "admin1234";
        String Atuacao     = "Empresa de TI Fintech";  
        String CEP             = "04474-240"; 
        String Email           = "sinqia@gmail.com";
        String Endereco        = "rua miguel fletaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String Resumo   = "Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil"; 
        String tipoUsuario = "Empresa";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois endereço é maior do que o disponivel");
        
        Endereco = "rua b";
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois endereço é maior do que o disponivel");
    }
    
    @Test
    public void testValidaCamposRecrutador_Resumo(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes"; 
        String Nome_ou_Empresa = "Sinqia SA"; 
        String Senha = "admin1234";
        String Atuacao     = "Empresa de TI Fintech";  
        String CEP             = "04474-240";  
        String Email           = "sinqia@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do Financeiraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanceiraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"; 
        String tipoUsuario = "Empresa";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois resumo é maior do que o disponivel");
        
        Resumo = "TesteTes";
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertFalse(result, "Deve retornar falso, pois resumo é menor do que o disponivel");
    }
    
    
    @Test
    public void testValidaCamposRecrutadorTamanho(){
        boolean result;
        String Nome_Responsavel = "Gustavo Nunes"; 
        String Nome_ou_Empresa = "Sinqia SA"; 
        String Senha = "admin1234";
        String Atuacao     = "Empresa de TI Fintech";  
        String CEP             = "04474-240";
        String CNPJ             = "77.844.068/0001-81"; 
        String Email           = "sinqia@gmail.com";
        String Endereco        = "rua miguel fleta";
        String Resumo   = "Empresa financeira no ramo de TI a mais de 30 anos no mercado, a maior do brasil"; 
        String tipoUsuario = "Empresa";
        
        result = classValidaCampos.ValidaLength(Email, Senha, Atuacao, Endereco, CEP, Resumo, Nome_Responsavel, null, Nome_ou_Empresa, tipoUsuario);
        assertTrue(result, "Deve retornar VERDADEIRO");
    }
    
    @Test
    public void testValidaLinha(){
        Integer linhaSelec = -1;
        boolean result;
        result = classVerificaLinhaSelecionada.ValidaLinha(linhaSelec);
        assertFalse(result, "Deve retornar falso, pois não foi selecionado nada");
        
        linhaSelec = 1;
        result = classVerificaLinhaSelecionada.ValidaLinha(linhaSelec);
        assertTrue(result, "Deve retornar verdadeiro");
    }
    ///////////////////////////////////////////////////TESTES UNITARIOS FINALIZADOS///////////////////////////////////////////////////////////////
   
}
