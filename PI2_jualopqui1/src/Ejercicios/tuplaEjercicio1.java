package Ejercicios;

public record tuplaEjercicio1(String s, Integer a, Integer b, Integer c) {
	
	public static tuplaEjercicio1 of(String s1, Integer n1, Integer n2, Integer n3) {
		tuplaEjercicio1 res = new tuplaEjercicio1(s1, n1, n2, n3);
		return res;
	}
	
	public tuplaEjercicio1 next() {
		String s = this.s();
		Integer a = this.a();
		Integer b = this.b();
		Integer c = this.c();
		
		if(a%2==0 &&  b%2==0 &&  c%2==0) {
			a = a/2;
			b = b-2;
			c = c/2;
		}else{
			a = a/3;
			b = b-3;
			c = c/3;
		}
		return tuplaEjercicio1.of(s, a, b, c);
	}
}
