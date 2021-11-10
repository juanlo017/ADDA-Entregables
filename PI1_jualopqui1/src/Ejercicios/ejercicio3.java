package Ejercicios;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

public class ejercicio3 {
	//iterativo
	public static String iterativo(Integer a, Integer limit) {
		List<Par> pairList = new ArrayList<>();
		Par numberPair = Par.of(0, a);
		
		while(numberPair.v1() < limit) {
			Integer v1 = numberPair.v1() + 1;
			Integer v2 = numberPair.v1() + numberPair.v2();
			
			if(numberPair.v1() % 3 == 1) {
				v2 = numberPair.v2();
			}
			
			pairList.add(numberPair);
			numberPair = Par.of(v1, v2);
		}
		return pairList.toString();
	}
	
	//recursivo
	public static String recursivo(Integer a, Integer limit) {
		
		List<Par> pairList = new ArrayList<>();
		Integer i = 0;
		
		return recursivo(a, limit, i, pairList);
	}
	
	public static String recursivo(Integer a, Integer limit, Integer i, List<Par> pairList) {
		
		Par numberPair = Par.of(i, a);
		
		if(i < limit) {
			
			pairList.add(numberPair);
			
			Integer v1 = numberPair.v1() + 1;
			Integer v2 = numberPair.v1() + numberPair.v2();
			
			if(numberPair.v1() % 3 == 1) {
				v2 = numberPair.v2();
			}
			
			recursivo(v2, limit, v1, pairList);
		}
		return pairList.toString();
	}
	
	//funcional
	public static String funcional(Integer a, Integer limit) {
		return Stream
				.iterate(Par.of(0, a),
				t-> t.v1() < limit,
				t-> Par.of(t.v1()+1, t.v1() % 3 == 1 ? t.v2() : t.v1() + t.v2()))
				.collect(Collectors.toList())
				.toString();
	}
}