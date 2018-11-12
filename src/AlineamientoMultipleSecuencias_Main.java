public class AlineamientoMultipleSecuencias_Main {

	public static void main(String[] args) {
		AlineamientoMultipleSecuencias alineamiento1 = new AlineamientoMultipleSecuencias();

		System.out.println("Sequence size: " + alineamiento1.tamanyoGap);

		/*
		 * Se crea un nuevo objeto de tipo AlgoritmoGenetico pasando al
		 * constructor de dicha clase: - Tama�o del Gap. - N�mero de secuencias
		 * a analizar. - Objeto de tipo AlineamientoMultipleSecuencias.
		 */
		AlgoritmoGenetico algoritmoGenetico1 = new AlgoritmoGenetico(
				alineamiento1.tamanyoGap, alineamiento1.numeroSecuencias,
				alineamiento1);

		// C�lculo del tiempo de ejecuci�n.
		long time_start, time_end;
		time_start = System.currentTimeMillis();

		System.out.println("Running genetic algorithm...");

		double ultimoMejor = algoritmoGenetico1.eliteF;

		algoritmoGenetico1.ejecutarAlgoritmoGenetico();
		time_end = System.currentTimeMillis();

		System.out.println("Best result: " + algoritmoGenetico1.eliteF);
		ultimoMejor = algoritmoGenetico1.eliteF;

		System.out.println("Total time: " + (time_end - time_start)
				+ " milliseconds");

		System.out.println("Sequence matches:");
		imprimirMejorResultado(algoritmoGenetico1, alineamiento1);
	}

	private static void imprimirMejorResultado(
			AlgoritmoGenetico algoritmoGenetico,
			AlineamientoMultipleSecuencias alineamientoMultipleSecuencias) {
		Integer[][] individuo = algoritmoGenetico.vector_eliteIndividual;
		for (int l = 0; l < individuo.length; l++) {
			int size = -1;
			for (int c = 0; c < individuo[0].length; c++) {
				char c1;
				if (individuo[l][c] == 1) {
					size++;
					c1 = alineamientoMultipleSecuencias.getChar(l, size);
				} else
					c1 = '-';
				System.out.print(c1);
			}
			System.out.println();
		}
		int[] tam = new int[individuo.length];
		char[] columna = new char[individuo.length];
		int coincidencias = 0;
		for (int i = 0; i < individuo.length; i++) {
			tam[i] = -1;
		}
		for (int c = 0; c < individuo[0].length; c++) {
			for (int l = 0; l < individuo.length; l++) {
				if (individuo[l][c] == 1) {
					tam[l]++;
					columna[l] = alineamientoMultipleSecuencias.getChar(l,
							tam[l]);
				} else
					columna[l] = '-';
			}
			// Comprobar la columna
			boolean match = true;
			char e = columna[0];
			for (int i = 1; i < individuo.length; i++) {
				if (columna[i] != e)
					match = false;
			}
			if (match && e != '-') {
				System.out.print("*");
				coincidencias++;
			} else
				System.out.print(" ");
		}
		System.out.println();
		System.out.println("Sequence score = "
				+ algoritmoGenetico.eliteF
				+ ", Matching number in the sequence: " + coincidencias
				+ ".");
	}
}
