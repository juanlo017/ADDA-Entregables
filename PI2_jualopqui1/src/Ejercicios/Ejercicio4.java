package Ejercicios;

import java.util.HashMap;
import java.util.Map;

/*f0=2
 * f1=5
 * f2=6
 * 
 * fn=2fn-1 + 4fn-2 + 6fn-3
 * 
 * */
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
			res = 2*recursivoSinMemoria(n-1, res) + 4*recursivoSinMemoria(n-2, res) + 6*recursivoSinMemoria(n-3, res);
		}
		return res;
	}
	
	public static Long iterativo(Integer n) {
		Long res = 0L;
		Integer i = 0;
		Map<Integer, Long> memoria = new HashMap<>();
		memoria.put(0, 2L);
		memoria.put(1, 4L);
		memoria.put(2, 6L);
		while(i <= n) {
			if(memoria.containsKey(i)) {
				res = res + memoria.get(i);
			}else {
				Long valor = 2*memoria.get(i-1) + 4*memoria.get(i-2) + 6*memoria.get(i-3);
				res = res + valor;
				memoria.put(i, valor);
			}
			i++;
		}
		return res;
	}
}
