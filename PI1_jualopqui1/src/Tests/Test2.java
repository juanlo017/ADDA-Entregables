package Tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicios.ejercicio1;
import Ejercicios.ejercicio2;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> file = ejercicio1.leeFichero(".\\ficheros\\PI1E2_DatosEntrada1.txt");
		Map<Integer, List<String>> m = new HashMap<>();
		System.out.println(
				"Iterativo: " +ejercicio2.iterativo(file) + "\n" +
				"Recursivo: " + ejercicio2.recursivo(file, 0, m) + "\n" +
				"Funcional: " + ejercicio2.funcional(file));	
	}
}
