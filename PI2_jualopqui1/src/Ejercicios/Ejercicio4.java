package Ejercicios;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio4 {
	public static Long recursivoSinMemoria(Integer n) {
		Long res = 0L;
		return recursivoSinMemoria(n, res);
	}
	private static Long recursivoSinMemoria(Integer n, Long res) {
		if(n==2) {
			res = 6L;
		}else if(n==1){
			res = 4L;
		}else if(n==0){
			res = 2L;
		}else {
			res = 2*recursivoSinMemoria(n-1, res) + 4*recursivoSinMemoria(n-2, res) + 6*recursivoSinMemoria(n-3, res);
		}
		return res;
	}
	
	public static Long recursivoConMemoria(Integer n) {
		Long res = 0L;
		Map<Integer, Long> memoria = new HashMap<>();
		return recursivoConMemoria(n, res, memoria);
	}
	private static Long recursivoConMemoria(Integer n, Long res, Map<Integer, Long> memoria) {
		if(memoria.containsKey(n)){
			res = memoria.get(n);
		}
		else if(n==2) {
			res = 6L;
		}else if(n==1){
			res = 4L;
		}else if(n==0){
			res = 2L;
		}else {
			res = 2*recursivoConMemoria(n-1, res, memoria) + 4*recursivoConMemoria(n-2, res, memoria) + 6*recursivoConMemoria(n-3, res, memoria);
			memoria.put(n, res);
		}
		return res;
	}

	
	public static Long iterativo(Integer n) {
		Long res = 0L;
		Integer i = 0; 
		Map<Integer, Long> memoria = new HashMap<>();
		
		while(i <= n) {
			if(i==2) {
				memoria.put(i, 6L);
			}else if(i==1){
				memoria.put(i, 4L);
			}else if(i==0){
				memoria.put(i, 2L);
			}else{
				Long valor = 2L*memoria.get(i-1) + 4L*memoria.get(i-2) + 6L*memoria.get(i-3);
				res += valor;
				memoria.put(i, valor);
				memoria.remove(i-4); //quitamos los valores que no interesan y ocupan espacio de memoria
			}
			i++;
		}
		return memoria.get(n);
	}		
	
}
