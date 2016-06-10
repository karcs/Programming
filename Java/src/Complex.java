public class Complex {

	// a)
	private double re;
	private double im;

	// b)
	public static Complex I = new Complex(0, 1);
	public static Complex ZERO = new Complex(0);
	public static Complex ONE = new Complex(1);
	public static Complex HALF = new Complex(0.5);

	// c)
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public Complex(double re) {
		this.re = re;
		this.im = 0;
	}

	// d)
	public static double real(Complex c) {
		return c.re;
	}

	public static double imag(Complex c) {
		return c.im;
	}

	public static double abs(Complex c) {
		return Math.sqrt(Math.pow(c.re, 2) + Math.pow(c.im, 2));
	}

	public static double arg(Complex c) {
		double r = abs(c);
		if (c.im > 0)
			return Math.acos(c.re/r);
		else
			return -Math.acos(c.re/r);
	}

	public static Complex conj(Complex c) {
		return new Complex(c.re, -c.im);
	}

	// e)
	public static Complex add(Complex a, Complex b) {
		return new Complex(a.re + b.re, a.im + b.im);
	}

	public static Complex sub(Complex a, Complex b) {
		return new Complex(a.re - b.re, a.im - b.im);
	}

	public static Complex mul(Complex a, Complex b) {
		return new Complex(a.re * b.re - a.im * b.im, a.re * b.im + a.im * b.re);
	}

	public static Complex div(Complex a, Complex b) {
		Complex r = new Complex(1/(b.re*b.re+b.im*b.im));
		return mul(mul(a, conj(b)),r);
	}

	// f)
	public static boolean equals(Complex a, Complex b) {
		return (a.re == b.re) && (a.im == b.im);
	}

	// g)
	public String toString() {
		// Complex -> String --- ohne doppelte Operator/VZsymbole: "1.0 - i*3.0"
		if (im < 0.0) {
			return "(" + re + " - i*" + -im + ")";
		} else {
			return "(" + re + " + i*" + im + ")";
		}
	}

	/*
	 * Assertion mit Ausgabe auf Standardausgabe (Konsole), statt kryptischem
	 * Laufzeitfehler bei Benutzung des assert Statements. Dieses ist dennoch
	 * aus verschiedenen Gruenden einer selbst implementierten vorzuziehen.
	 * erhaelt das Ergebnis einer Korrektheitsueberpruefung als boolean und
	 * einen String, der beschreibt was schief gelaufen ist
	 */
	private static void assert_out(boolean passed, String message) {
		if (!passed) {
			System.out.println("WARNING: Assertion raised: " + message);
		}
	}

	/*
	 * testet die Korrektheit der arithmetischen Grundoperationen sowie einige
	 * andere math. Funktionen. Falls Test fehlschlaegt wird entsprechende
	 * Warnung auf Konsole mittels assert_out(...) ausgegeben.
	 */
	private static void test() {
		Complex z1 = new Complex(3.0, -7.0);
		Complex z2 = new Complex(-5.0, 11.0);

		assert_out(equals(z1, new Complex(3.0, -7.0)),
				"equals falsch definiert!");
		assert_out(equals(add(z1, z2), new Complex(-2.0, 4.0)),
				"Komplexe Addition falsch definiert!");
		assert_out(equals(sub(z1, z2), new Complex(8.0, -18.0)),
				"Komplexe Subtraktion falsch definiert!");
		assert_out(equals(mul(z1, z2), new Complex(62.0, 68.0)),
				"Komplexe Multiplikation falsch definiert!");
		assert_out(equals(div(z1, z2), new Complex(-46.0 / 73.0, 1.0 / 73.0)),
				"Komplexe Division falsch definiert!");
		assert_out(equals(conj(z1), new Complex(3.0, 7.0)),
				"Komplexe Konjugation falsch definiert!");
		assert_out(abs(z1) == 7.615773105863909,
				"Komplexer Absolutbetrag falsch definiert!");
		assert_out(arg(z2) == 1.9974238199217726,
				"Komplexer Winkel falsch definiert!");
	}

	private static void test(Complex z1, Complex z2) {
		System.out.println("\nComplex Test Start");
		System.out.println("z1: " + z1 + " ... z2: " + z2);
		System.out.println("z1 == z2: " + equals(z1, z2) + " ... z2 == z1: "
				+ equals(z2, z1));
		System.out.println("conj(z1): " + conj(z1) + " ... conj(z2): "
				+ conj(z2));

		if (!equals(z1, conj(conj(z1)))) {
			System.out.println("FEHLER in conj");
		}

		if (!equals(z2, conj(conj(z2)))) {
			System.out.println("FEHLER in conj");
		}

		System.out.println("real(z1)(): " + real(z1) + " ... imag(z1): "
				+ imag(z1));
		System.out.println("real(z2)(): " + real(z2) + " ... imag(z2): "
				+ imag(z2));

		System.out.println("abs(z1): " + abs(z1) + " ... arg(z1): " + arg(z1));
		System.out.println("abs(z1): " + abs(z1) + " ... arg(z1): " + arg(z1));

		System.out.println("Add: " + add(z1, z2) + " ... " + add(z2, z1));
		System.out.println("Sub: " + sub(z1, z2) + " ... " + sub(z2, z1));
		System.out.println("Mul: " + mul(z1, z2) + " ... " + mul(z2, z1));
		System.out.println("Div: " + div(z1, z2) + " ... " + div(z2, z1));

		System.out.println("ARI: " + sub(sub(add(z1, z2), z1), z2));
		System.out.println("ARI: " + sub(add(z1, sub(z2, z1)), z2));
		System.out.println("ARI: " + div(div(mul(z1, z2), z1), z2));
		System.out.println("ARI: " + div(mul(z1, div(z2, z1)), z2));

		System.out.println("Complex Test Ende");
	}

	// Test der Grundfunktionalitaet
	public static void main(String[] args) {
		test();

		test(new Complex(2.0, -3.0), new Complex(5.0, -7.0));
		test(new Complex(1.0), new Complex(0.0, 1.0));
		test(new Complex(Math.PI, Math.E), new Complex(Math.PI, Math.E));
		test(new Complex(3.0, 4.0), new Complex(4.0, 3.0));
		test(new Complex(0.0, 0.0), new Complex(0.0, 0.0));

		if (!equals(new Complex(13.0), new Complex(13.0, 0.0))) {
			System.out.println("FEHLER in Konstruktoren");
		}

		// Test, ob REFERENZ I wirklich nicht aenderbar?
		// I = I.add (new Complex(1.0, -1.0)); // Compilezeitfehler
		System.out.println("\nImaginaere Einheit: " + I);
		// T est, ob WERT von I aenderbar?
		I.re = 5.0;
		System.out.println("Imaginaere Einheit? " + I + "\n");
		System.out.println(arg(ZERO));
		}
}
