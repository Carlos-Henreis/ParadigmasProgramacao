#include <stdio.h>
#include <stdlib.h>

#define FALSE 0
#define TRUE 1

//Exibe as linhas onde estão cada rainhas em suas respectivas colunas
void mostraSolucao (int **tab, int n){
	int i, j;
	for (i=0; i< n; i++){
		for (j=0; j< n; j++){
			if(tab[i][j] == 1)
				printf("%d, ", j+1);
		}
	}
	printf("\n");
}

int vallidaPos (int **tab, int n, int linha, int coluna) {
	int i, j;
	//Ataque na linha
	for(i = 0; i < n; i++){
		if(tab[linha][i] == 1)
			return FALSE;
	}
	//Ataque na coluna
	for(i = 0; i < n; i++){
		if(tab[i][coluna] == 1)
			return FALSE;
	}
	// verifica se ocorre ataque na diagonal principal
	// acima e abaixo/ verifica se ocorre ataque na diagonal principal
	for(i = linha, j = coluna; i >= 0 && j >= 0; i--, j--){
		if(tab[i][j] == 1)
			return FALSE;
	}
	for(i = linha, j = coluna; i < n && j < n; i++, j++){
		if(tab[i][j] == 1)
			return FALSE;
	}
	// verifica se ocorre ataque na diagonal secundária
	// acima e abaixo
	for(i = linha, j = coluna; i >= 0 && j < n; i--, j++){
		if(tab[i][j] == 1)
			return FALSE;
	}
	for(i = linha, j = coluna; i < n && j >= 0; i++, j--)
	{
		if(tab[i][j] == 1)
			return FALSE;
	}
	return TRUE;

}

void executa (int **tab, int n, int coluna){
	int i;
	if (coluna == n){
		mostraSolucao(tab, n);
		return;
	}
	for (i = 0; i < n; i++)	{
		if (vallidaPos (tab, n, i, coluna)){
			tab[i][coluna] = 1;
			executa(tab, n, coluna+1);
			tab[i][coluna] = 0;
		}
	}
}

int main (void) {
	int i, j, n = 8;
	int **tab;
	tab = (int**) calloc (n, sizeof(int*));
	if (!tab){
		printf("Erro de alocação\n");
		return 0;
	}

	for (i = 0; i < n; i++) {
		tab[i] = (int*) calloc (n, sizeof(int));
		if (!tab[i]) {
			for (j = 0; i < i; j++){
				free(tab[j]);
			}
			free(tab);
			printf("Erro em alocar memória\n");
		}
	}
	executa (tab, n, 0);

	for (i = 0; i < n; i++) {
		free(tab[i]);
	}
	free(tab);
	return 0;


}