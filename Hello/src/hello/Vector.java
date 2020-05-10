/*
 * Practica matriz definida en espiral.
 * 
 * */

package hello;

public class Vector {

	public static void main(String[] args) {
		//Definicion de la matriz
		char[][] Matriz = {{'A','B','C','D'},
							{'E','F','G','H'},
							{'I','J','K','L'},
							{'M','N','O','P'},
							{'Q','R','S','T'}};
		
		int i = 0; //Variable para recorrer la matriz
		int j = 0;
		
		//Este primer bucle mostrará la primera fila completa.
		while(i == 0 && j < 4) {
			System.out.print(Matriz[i][j] + " ");
			j+=1;
		}i+=1; j-=1; //Le sumamos a i para que no repita un valor y le restamos a j para evitar una excepción.
		
		//Columna exceptuando el valor de la primera fila.
		while(j == 3 && i < 5) {
			System.out.print(Matriz[i][j] + " ");
			i+=1;
		}i-=1; j-=1;
		
		while (i == 4 && j > -1) {
			System.out.print(Matriz[i][j] + " ");
			j-=1;
		}j+=1; i-=1;
		
		while (j == 0 && i>0) {
			System.out.print(Matriz[i][j] + " ");
			i-=1;
		}i+=1; j+=1;
		
		while(i == 1 && j<3) {
			System.out.print(Matriz[i][j] + " ");
			j+=1;
		}i+=1; j-=1;
		
		while (j == 2 && i<4) {
			System.out.print(Matriz[i][j] + " ");
			i+=1;
		}System.out.print(Matriz[3][1] + " ");
		System.out.print(Matriz[2][1] + " ");		
	}

}
