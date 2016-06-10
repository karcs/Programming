import static Prog1Tools.IOTools.readDouble;
import static Prog1Tools.IOTools.readInteger;

class MatrixD {

    public MatrixD() {
	System.
    }
	
	
	
	public String toString() {
	StringBuffer ret = new StringBuffer();
	
	ret.append("{ ");
	
	for (int i=0; i < elem.length; i++) {
	    ret.append("{");

	    for (int j=0; j < elem[i].length-1; j++) {
		ret.append(elem[i][j]).append(", ");
	    }
	    
	    ret.append(elem[i][elem[i].length-1]).append("}");
	    if (i+1 < elem.length ) {
		ret.append(";\n");
	    }
	}
	ret.append(" }");
	return ret.toString();
    }
    

  public static void test(MatrixD A, MatrixD B) {
    System.out.println("MatrixD Test Start"); 

    System.out.println("A ist eine " + A.getRowCount() + "x" + A.getColCount() + " Matrix");
    A.print("A");

    System.out.println("B ist eine " + B.getRowCount() + "x" + B.getColCount() + " Matrix");
    B.print("B");

    System.out.println("A==B?: " + A.equals(B) + " ... B==A?: " + B.equals(A));
    System.out.println("A.isSymm(): " + A.isSymm() + " ... A.isAntiSymm(): " + A.isAntiSymm());
    System.out.println("B.isSymm(): " + B.isSymm() + " ... B.isAntiSymm(): " + B.isAntiSymm());

    A.transpose().print("A.transpose()");
    B.transpose().print("B.transpose()");

    A.symm().print("A.symm()");
    B.symm().print("B.symm()");

    A.antiSymm().print("A.antiSymm()");
    B.antiSymm().print("B.antiSymm()");

    A.add(B).print("A+B");
    B.add(A).print("B+A");

    A.sub(B).print("A-B");
    B.sub(A).print("B-A");

    A.transpose().print("A.transpose()");
    B.transpose().print("B.transpose()");
    
    System.out.println("A==(A.symm() + A.antiSymm()): " + A.equals(A.symm().add(A.antiSymm())));
    System.out.println("B==(B.symm() + B.antiSymm()): " + B.equals(B.symm().add(B.antiSymm())));

    System.out.println("A+A==A.mul(2.0): " + A.mul(2.0).equals(A.add(A)));
    System.out.println("B+B==B.mul(2.0): " + B.mul(2.0).equals(B.add(B)));

    System.out.println("MatrixD Test Ende"); 
  }

  public static void main(String[] args) {
    MatrixD B = new MatrixD(2,2, true);
    MatrixD A = new MatrixD(2,2, true);

  	test(A, B);
  }
}
