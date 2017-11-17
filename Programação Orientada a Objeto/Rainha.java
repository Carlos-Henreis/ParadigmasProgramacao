
package pkg8rainhas;

public class Rainha {
    /*Definição dos atributos*/
    int coluna;
    int linha;
    /*Definição dos métodos*/
    /*Construtor*/
    public Rainha(int coluna) {
        this.coluna = coluna;
    }


    /*sets e gets*/
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }
    
    public int getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }
    
    
}
