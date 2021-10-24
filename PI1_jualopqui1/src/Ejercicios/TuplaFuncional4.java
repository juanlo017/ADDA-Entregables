package Ejercicios;

public record TuplaFuncional4(Double n, Double e, Double inicioIntervalo, Double finIntervalo, Double medio, Double error) {
	
	public static TuplaFuncional4 of(Double numero, Double precision, Double initIntervalo, Double endIntervalo, Double valorMedio, Double err) {
		return new TuplaFuncional4(numero, precision, initIntervalo, endIntervalo, valorMedio, err);
	}
	
	public TuplaFuncional4 next(){
		Double n = this.n();
		Double e = this.e();
		Double inicioIntervalo = this.inicioIntervalo();
		Double finIntervalo = this.finIntervalo();
		
		Double medio = (inicioIntervalo + finIntervalo)/2;
	     
        Double error = Math.abs(n - (medio*medio*medio));
        
        if ((medio*medio*medio) >= n) {
        	finIntervalo = medio;
        }else {
        	inicioIntervalo = medio;
        }
        
		return TuplaFuncional4.of(n, e, inicioIntervalo, finIntervalo, medio, error);
	}
}
