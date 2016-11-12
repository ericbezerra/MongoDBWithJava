/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mongodb.util;

import javax.swing.JOptionPane;

/**
 *
 * @author eric.bezerra
 */
public class Menssagem {
    
    public void sobre(){
        JOptionPane.showMessageDialog(null, 
                "Sistema de consultas Médicas"+
                        "\nUsando Java e MongoDB"+
                        "\nCriado por:"+
                        "\nEric do Nascimento Bezerra RA: 6088308"+
                        "\nYago dos Santos Senhorini RA: 6868000"+
                        "\nLeonardo Alves Almeida RA: 6177288");
    }
}
