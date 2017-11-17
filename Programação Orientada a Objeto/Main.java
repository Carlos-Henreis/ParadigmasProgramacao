/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8rainhas;

/**
 *
 * @author carlos
 */
public class Main {

    
    public static void main(String[] args) {
       //Tabuleiro com 8 rainhas
        Tabuleiro t = new Tabuleiro(8);
       //Começa com a rainha da pos 0
       t.executa(0);
    }
    
}
