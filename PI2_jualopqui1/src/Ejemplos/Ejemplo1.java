package Ejemplos;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo1 {
//	
//	public List<Integer> inversaNoFinal(List<Integer> ls){
//		return inversaNoFinal(ls, 0);
//	}

//	private List<Integer> inversaNoFinal(List<Integer> ls, int i) {
//		// TODO Auto-generated method stub
//		List<Integer> res;
//		if(i < ls.size()) {
//			ls.get(i);
//			inversaNoFinal(ls, i + 1);
//		}else {
//			res = new ArrayList<Integer>(); 
//		}
//		return res;
//	}
	
	public List<Integer> iterativo(List<Integer> ls){
			List<Integer> res = new ArrayList<Integer>();
			Integer i = 0;
			
			while(i < ls.size()) {
				res.add(0, ls.get(i));
				i++;
			}
			return res;
	}
	
	
}
