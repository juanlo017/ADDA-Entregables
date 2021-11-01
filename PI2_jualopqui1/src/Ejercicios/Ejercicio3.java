package Ejercicios;

import java.util.List;
import us.lsi.common.IntegerSet;

public class Ejercicio3 {
	
	public static IntegerSet recursivo(List<Integer> ls, Integer a, Integer b){
		IntegerSet res = IntegerSet.empty();
		IntegerSet range = IntegerSet.ofRange(a, b);
		Integer i = 0;
		return recursivo(range, i, ls, res);
	}

	private static IntegerSet recursivo(IntegerSet range, Integer i, List<Integer> ls, IntegerSet res) {
		if(i < ls.size()) {
			if(range.contains(ls.get(i))) {
				res.add(ls.get(i));
			}
			recursivo(range, i+1, ls, res);
		}
		return res;
	}
}
