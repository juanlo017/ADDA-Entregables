package Ejercicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio5 {
	public static Integer recursivoSinMemoria(Integer a, Integer b, Integer c) {
		Integer res = 0;
		return recursivoSinMemoria(res, a, b, c);
	}

	private static Integer recursivoSinMemoria(Integer res, Integer a, Integer b, Integer c) {
		if(a<3 || b<3 || c<3) {
			res = a + b*b + 2*c;
		}else {
			if(a%b == 0) {
				res = recursivoSinMemoria(res, a-1,b/2,c/2) + recursivoSinMemoria(res,a-3,b/3,c/3);
			}else {
				res = recursivoSinMemoria(res,a/3,b-3,c-3) + recursivoSinMemoria(res,a/2,b-2,c-2);
			}
		}
		return res;
	}
	/*checkea si esta en el map; caso base -> a�adir al map; resto de condiciones -> a�adir al map*/
	public static Integer recursivoConMemoria(Integer a, Integer b, Integer c) {
		Map<List<Integer>,Integer> memoria = new HashMap<>();
		Integer res = 0;
		return recursivoConMemoria(res, memoria, a, b, c);
	}

	private static Integer recursivoConMemoria(Integer res, Map<List<Integer>,Integer> memoria, Integer a, Integer b, Integer c) {
		List<Integer> problemaActual = List.of(a,b,c);
		if(memoria.containsKey(problemaActual)) {
			res = memoria.get(problemaActual);
		}else if(a<3 || b<3 || c<3) {
			res = a + b*b + 2*c;
			memoria.put(problemaActual, res);
		}else {
			if(a%b == 0) {
				res = recursivoConMemoria(res, memoria, a-1,b/2,c/2) + recursivoConMemoria(res, memoria,a-3,b/3,c/3);
				memoria.put(problemaActual, res);
			}else {
				res = recursivoConMemoria(res, memoria,a/3,b-3,c-3) + recursivoConMemoria(res, memoria,a/2,b-2,c-2);
				memoria.put(problemaActual, res);
			}
		}
		return res;
	}
	
	public static Integer iterativo(Integer a, Integer b, Integer c) {
		Map<List<Integer>,Integer> memoria = new HashMap<>();
		//bottom up
		Integer i = 0;
		while(i<=a) {
			Integer j = 0;
			while(j<=b) {
				Integer k = 0;
				while(k<=c) {
					if(i<3 || j<3 || k<3) {
						Integer res = i + j*j + 2*k;
						memoria.put(List.of(i,j,k), res);
					}else if(i%j == 0){
						Integer res = memoria.get(List.of(i-1,j/2,k/2)) + memoria.get(List.of(i-3,j/3,k/3));
						memoria.put(List.of(i,j,k), res);
					}else {
						Integer res = memoria.get(List.of(i/3,j-3,k-3)) + memoria.get(List.of(i/2,j-2,k-2));
						memoria.put(List.of(i,j,k), res);
					}
					k++;
				}
				j++;
			}
			i++;
		}
		return memoria.get(List.of(a,b,c));
	}
	
	
}
