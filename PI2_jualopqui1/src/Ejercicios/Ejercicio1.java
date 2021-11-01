package Ejercicios;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio1 {
/*
a<3 y  b<3 y  c<3 --------------- (a*b*c)
a<5 o b<5 o c<5 ----------------- (a+b+c)
a,b y c son pares ---------------- a*b*c + f(a/2, b-2, c/2)
else ----------------------------- a+b+c + f(a/3, b-3, c/3)
 */
	
	public static String recursivoNoFinal(Integer a, Integer b, Integer c) {
		String res = "";
		return recursivoNoFinal(res,a, b, c);
	}

	private static String recursivoNoFinal(String res, Integer a, Integer b, Integer c) {
		if(a<3 &&  b<3 &&  c<3) res = String.format("(%s)", a*b*c);//caso base 1
		else if(a<5 || b<5 || c<5) res = String.format("(%s)", a+b+c);//caso base 2
		else if (a%2==0 &&  b%2==0 &&  c%2==0){
			Integer n1 = a/2;
			Integer n2 = b-2;
			Integer n3 = c/2;
			res = String.format("%s%s", String.valueOf(a*b*c), recursivoNoFinal(res,  n1, n2, n3));
		}else {
			Integer n1 = a/3;
			Integer n2 = b-3;
			Integer n3 = c/3;
			res = String.format("%s%s",  String.valueOf(a+b+c), recursivoNoFinal(res,  n1, n2, n3));
		}
		return res;
	}
	
	
	public static String iterativo (Integer a, Integer b, Integer c) {
		String res = "";
		
		while(!(a<3 &&  b<3 &&  c<3) && !(a<5 || b<5 || c<5)) {
			if(a%2==0 &&  b%2==0 &&  c%2==0) {
				res = String.format("%s%s", res, String.valueOf(a*b*c));
				a = a/2;
				b = b-2;
				c = c/2;
			}else{
				res = String.format("%s%s", res, String.valueOf(a+b+c));
				a = a/3;
				b = b-3;
				c = c/3;
			}
		}
		if(a<3 &&  b<3 &&  c<3) res = String.format("%s(%s)", res, String.valueOf(a*b*c));
		else res = String.format("%s(%s)", res, a+b+c);
		
		return res;
	}
	
	public static String recursivoFinal(Integer a, Integer b, Integer c) {
		String res = "";
		return recursivoFinal(res, a, b, c);
	}

	private static String recursivoFinal(String res, Integer a, Integer b, Integer c) {
		if(!(a<3 &&  b<3 &&  c<3) && !(a<5 || b<5 || c<5)) {
			if(a%2==0 &&  b%2==0 &&  c%2==0) {
				String s = String.format("%s%s", res, String.valueOf(a*b*c));
				Integer n1 = a/2;
				Integer n2 = b-2;
				Integer n3 = c/2;
				res = recursivoFinal(s, n1, n2, n3);
			}else{
				String s = String.format("%s%s", res, String.valueOf(a+b+c));
				Integer n1 = a/3;
				Integer n2 = b-3;
				Integer n3 = c/3;
				res = recursivoFinal(s, n1, n2, n3);
			}
		}
		else if(a<3 && b<3 && c<3) res = String.format("%s(%s)", res, String.valueOf(a*b*c));
		else if(a<5 || b<5 || c<5)res = String.format("%s(%s)", res, a+b+c);
		
		return res;
	}
	
//	public static String funcional(Integer a, Integer b, Integer c) {
//		String s = "";
//		String res = Stream.iterate(tuplaEjercicio1.of(s, a, b, c), x -> x.next())
//									.filter(x -> !(x.a()<3 &&  x.b()<3 &&  x.c()<3) && !(x.a()<5 || x.b()<5 || x.c()<5))					
//	}
	
	
	
}
