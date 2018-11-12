final public class ADN {

	/*
	 * Matriz de substitucion para el ADN obtenida de:
	 * http://www.evolution-textbook.org/content/free/tables/ch27.html
	 */
	private static final int[][] matrizADN = { { 0, 2, 1, 2 }, { 2, 0, 2, 1 },
			{ 1, 2, 0, 2 }, { 2, 1, 2, 0 }, };

	private static int dameIndice(char a) throws Exception {
		// Comprobaci�n de may�sculas y min�sculas.
		switch ((String.valueOf(a)).toUpperCase().charAt(0)) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		default:
			throw new Exception("Invalid character: " + a);
		}
	}

	// Funci�n sobrecargada
	private static int dameDistancia(int i, int j) throws Exception {
		if (i < 0 || i > matrizADN[0].length) {
			throw new Exception("Invalid character in string1, position " + i);
		}
		if (j < 0 || j > matrizADN[0].length) {
			throw new Exception("Invalid character in string2, position " + j);
		}

		return matrizADN[i][j];
	}

	public static int dameDistancia(char a1, char a2) throws Exception {
		return dameDistancia(dameIndice(a1), dameIndice(a2));
	}
}