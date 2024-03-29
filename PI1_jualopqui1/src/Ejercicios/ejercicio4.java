package Ejercicios;

import java.util.stream.Stream;

public class ejercicio4 {
	/*Algoritmo que dados 2 numeros n, e (con n > 1 y e en (0,1)), devuelva un 
	  numero real que se corresponda a la raiz cubica de n con error menor que e.
	 */
	
	//iterativa
	public static Double iterativo (Double n, Double e) {
		Double inicioIntervalo = 0.;
		Double finIntervalo = n;
		Double medio = 0.;
		Double error = 2.;
		
		while(error >= e) {
		
	            medio = (inicioIntervalo + finIntervalo)/2;
	     
	            error = Math.abs(n - (medio*medio*medio));
	            
	            
	            if ((medio*medio*medio) >= n) {
	            	finIntervalo = medio;
	            }else {
	            	inicioIntervalo = medio;
	            }
	        }
		return medio;
	}
	
	//recursiva
	public static Double recursivo (Double n, Double e) {
		Double inicioIntervalo = 0.;
		Double finIntervalo = n;
		Double medio = 0.;
		Double error = 2.;
		return  recursivo(n, e, inicioIntervalo, finIntervalo, medio, error);
	}
	
	public static Double recursivo(Double n, Double e, Double inicioIntervalo, Double finIntervalo, Double medio, Double error) {
		
		if(error >= e) {
			
			medio = (inicioIntervalo + finIntervalo)/2;
		     
            error = Math.abs(n - (medio*medio*medio));
            
            
            if ((medio*medio*medio) >= n) {
            	finIntervalo = medio;
            }else {
            	inicioIntervalo = medio;
            }
            
            medio = recursivo(n, e, inicioIntervalo, finIntervalo, medio, error);
		}
		return medio;
	}
	
	//funcional
	public static Double funcional (Double n, Double e) {
		Double inicioIntervalo = 0.;
		Double finIntervalo = n;
		Double medio = 0.;
		Double error = 2.;
		
		TuplaFuncional4 res = Stream.iterate(TuplaFuncional4.of(n, e, inicioIntervalo, finIntervalo, medio, error), tupla -> tupla.next())
							.filter(x -> !(x.error() >= x.e()))
							.findFirst()
							.get();
		return res.medio();			
	}

}