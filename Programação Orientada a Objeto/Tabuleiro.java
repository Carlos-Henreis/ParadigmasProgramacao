
package pkg8rainhas;

public class Tabuleiro {
    /*Definição dos atributos*/
    int tam;
    int tab [][];
    Rainha rainhas[];

    public Tabuleiro(int tam) {
        this.tam = tam;
        this.tab = new int[tam][tam];
        this.rainhas = new Rainha[tam];
        for (int i = 0; i < rainhas.length; i++) {
            rainhas[i] = new Rainha(i);            
        }
    }
    
    public void mostraSolucao () {
        int i, j;
	for (i=0; i< this.tam; i++){
		for (j=0; j< this.tam; j++){
			if(tab[i][j] == 1)
                            System.out.print(j+1+"  ");
		}
	}
	System.out.println();
        
    }
    
    public boolean vallidaPos (Rainha r){
        int i, j;
	//Ataque na linha
	for(i = 0; i < this.tam; i++){
		if(tab[r.getLinha()][i] == 1)
			return false;
	}
        //Ataque na coluna
	for(i = 0; i < this.tam; i++){
		if(tab[i][r.getColuna()] == 1)
			return false;
	}
	// verifica se ocorre ataque na diagonal principal
	// acima e abaixo/ verifica se ocorre ataque na diagonal principal
	for(i = r.getLinha(), j = r.getColuna(); i >= 0 && j >= 0; i--, j--){
		if(tab[i][j] == 1)
			return false;
	}
	for(i = r.getLinha(), j = r.getColuna(); i < this.tam && j < this.tam; i++, j++){
		if(tab[i][j] == 1)
			return false;
	}
	// verifica se ocorre ataque na diagonal secundária
	// acima e abaixo
	for(i = r.getLinha(), j = r.getColuna(); i >= 0 && j < this.tam; i--, j++){
		if(tab[i][j] == 1)
			return false;
	}
	for(i = r.getLinha(), j = r.getColuna(); i < this.tam && j >= 0; i++, j--)
	{
		if(tab[i][j] == 1)
			return false;
	}
	return true;
    }
    
    public void executa (int coluna){
	int i;
	if (coluna == this.tam){
            this.mostraSolucao();
            return;
	}
	for (i = 0; i < this.tam; i++)	{
            /*Devemos setar a posição  da rainha que está na coluna para linha i*/
            rainhas[coluna].setLinha(i);
            if (vallidaPos (rainhas[coluna])){
                this.tab[i][coluna] = 1;
                executa(coluna+1);
                this.tab[i][coluna] = 0;
            }
	}
    }
}
