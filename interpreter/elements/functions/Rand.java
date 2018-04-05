package interpreter.elements.functions;

import java.util.Random;

import interpreter.Element;
import interpreter.elements.Function;
import interpreter.elements.Real;
import interpreter.elements.Unknown;

public class Rand extends Function {
	private static final long serialVersionUID = 1L;
	
	public static Random gen = new Random();
	
	public Rand() {
		super(2);
	}
	
	public Element evaluate() throws Unknown {
		double min = getArg(1).toReal();
		double max = getArg(0).toReal();
		
		double v = min + (max - min) * gen.nextDouble();
		
		return new Real(v);
	}
}
