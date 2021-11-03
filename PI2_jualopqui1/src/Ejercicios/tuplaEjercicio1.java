package Ejercicios;

public record tuplaEjercicio1(String res, Integer a, Integer b, Integer c) {
	
	public static tuplaEjercicio1 of(String res1, Integer n1, Integer n2, Integer n3) {
		tuplaEjercicio1 res = new tuplaEjercicio1(res1, n1, n2, n3);
		return res;
	}
	
	public tuplaEjercicio1 next() {
		Integer a = this.a();
		Integer b = this.b();
		Integer c = this.c();
		String s = this.res();
		if(!(a<3 &&  b<3 &&  c<3) && !(a<5 || b<5 || c<5)) {
			if(a%2==0 &&  b%2==0 &&  c%2==0) {
				s = String.format("%s%s", this.res(), String.valueOf(a*b*c));
				a = a/2;
				b = b-2;
				c = c/2;
				
			}else{
				s = String.format("%s%s", this.res(), String.valueOf(a+b+c));
				a = a/3;
				b = b-3;
				c = c/3;
			}
		}
		return tuplaEjercicio1.of(s, a, b, c);
	}
}
