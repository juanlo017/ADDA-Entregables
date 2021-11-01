package Ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
	
	public static List<String> recursivo(List<List<String>> matrix) {
		List<String> res = new ArrayList<String>();
		Integer x = 0;
		Integer y = 0;
		Integer dimension = matrix.size();
	return recursivo(res, matrix, x, y, dimension);
}

	private static List<String> recursivo(List<String> res, List<List<String>> matrix, Integer x, Integer y, Integer dimension) {
		if(dimension >= 2) {
			Integer up = x;
			Integer down = x + dimension-1;
			Integer left = y;
			Integer right = y + dimension-1;
			
			String corner1 = String.valueOf(matrix.get(up).get(left));
			String corner2 = String.valueOf(matrix.get(up).get(right));
			String corner3 = String.valueOf(matrix.get(down).get(left));
			String corner4 = String.valueOf(matrix.get(down).get(right));
			
			res.add(String.format("%s%s%s%s", corner1, corner2, corner3, corner4));
			
			recursivo(res, matrix, x, y, dimension/2);//submatrix sup izq
			recursivo(res, matrix, x, y+dimension/2, dimension/2);//submatrix sup der
			recursivo(res, matrix, x+dimension/2, y, dimension/2);//submatrix inf izq
			recursivo(res, matrix, x+dimension/2, y+dimension/2, dimension/2);//submatrix inf der
		}
		return res;
	}
}