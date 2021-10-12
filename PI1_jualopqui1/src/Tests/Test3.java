package Tests;

import java.util.ArrayList;
import java.util.List;

import Ejercicios.Par;
import Ejercicios.ejercicio1;
import Ejercicios.ejercicio3;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> file = ejercicio1.leeFichero(".\\ficheros\\PI1E3_DatosEntrada.txt");
		
		for(List<String> i : file) {
			List<Par> pairList = new ArrayList<>();
			
			Integer a = Integer.valueOf(i.get(0));
			Integer limit = Integer.valueOf(i.get(1));
			
			System.out.println(
					"Entrada: " + a + ", " + limit + "\n" + 
					"Iterativa: " + ejercicio3.iterativo(a, limit) + "\n" +
					"Recursiva:" + ejercicio3.recursivo(a, limit, 0, pairList) + "\n" +
					"Funcional: " + ejercicio3.funcional(a, limit) + "\n"									
					);
		}
	}
}