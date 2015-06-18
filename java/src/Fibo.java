import java.math.BigInteger;

// Aufgabe 4 und 6

public class Fibo {

	public static long iterativ(int n) {
		long a=0;
		long b=1;
		long c;
		for(int i=0;i<n;i++) {
			c=a;
			a=b;
			b=a+c;
		}
		return a;
	}
	
	public static long rekursiv(int n) {
		if (n<=1)
			return n;
		else
			return rekursiv(n-1)+rekursiv(n-2);
	}
	
	// a)
	public static long[] fiboZahlen(int n) {
		long[] res = new long[n+1];
		long a=0;
		long b=1;
		long c;
		for(int i=0;i<n+1;i++) {
			res[i]=a;
			c=a;
			a=b;
			// b)
			if(a < Long.MAX_VALUE - c)
				b=a+c;
			else
				b=-1;
		}
		return res;
	}
	
	// a)
	public static void main(String[] args) {
		for(int i=0;i < args.length;i++) {
			System.out.println(iterativ(Integer.parseInt(args[i])));
		}
		System.out.println("Test of fiboZahlen");
		int l=100;
		long[] fiboList=fiboZahlen(l+1);
		BigInteger[] bigFiboList=bigFiboZahlen(l+1);
		// b)
		for(int i=0;i<l+1 && fiboList[i]>=0;i++) {
			System.out.println(fiboList[i]);
		}
		for(int i=0;i<l+1 && fiboList[i]>=0;i++) {
			System.out.println(bigFiboList[i]);
		}
	}
	
	// c)
	public static BigInteger[] bigFiboZahlen(int n) {
		BigInteger[] res = new BigInteger[n+1];
		BigInteger a= new BigInteger("0");
		BigInteger b= new BigInteger("1");
		BigInteger c;
		for(int i=0;i<n+1;i++) {
			res[i]=a;
			c = a;
			a = b;
			b = a.add(c);
			}
		return res;
	}
}
