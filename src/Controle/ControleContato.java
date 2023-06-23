/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;
import Model.*;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public class ControleContato {
    
    
    public void inserirContato(DadosContato dc) throws SQLException
    {
        //chama o cadastro, coitado ele só repassa
        ContatoBanco.cadastrarContato(dc);    //<------------------------------------------aqui original do sor resto eu que inventei
        
        // Obtém a data e hora atual
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        
        // Define o formato de saída desejado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        
        // Formata a data e hora atual usando o formato definido
        String dataHoraFormatada = dataHoraAtual.format(formato);
        
        System.out.println("---------------------------------------------------");
        // Imprime a data e hora formatada
        System.out.println(dataHoraFormatada);
        System.out.println("O contato "+dc.getNome()+" foi adicionado");
        
        System.out.println("---------------------------------------------------");
    }
    
    public ArrayList<DadosContato> listar()throws SQLException
    {
        // Obtém a data e hora atual
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        
        // Define o formato de saída desejado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        
        // Formata a data e hora atual usando o formato definido
        String dataHoraFormatada = dataHoraAtual.format(formato);
        
        System.out.println("---------------------------------------------------");
        // Imprime a data e hora formatada
        System.out.println(dataHoraFormatada);
        System.out.println("Houve listagem dos contatos");
        
        System.out.println("---------------------------------------------------");
        
        return ContatoBanco.listarContato();          //<------------------------------------------aqui original do sor resto eu que inventei
    }
    
    //apagar
    public void apagarContato(DadosContato dc) throws SQLException {
        ContatoBanco.apagarContato(dc);      //<------------------------------------------aqui original do sor resto eu que inventei
        
        // Obtém a data e hora atual
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        
        // Define o formato de saída desejado
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        
        // Formata a data e hora atual usando o formato definido
        String dataHoraFormatada = dataHoraAtual.format(formato);
        
        System.out.println("---------------------------------------------------");
        // Imprime a data e hora formatada
        System.out.println(dataHoraFormatada);
        System.out.println("O contato "+dc.getNome()+" foi removido");
        
        System.out.println("---------------------------------------------------");

    }
    
    public void atualizrContato(DadosContato dc) throws SQLException{
        ContatoBanco.atualizarContato(dc);            //<------------------------------------------aqui original do sor resto eu que inventei
    }
}
