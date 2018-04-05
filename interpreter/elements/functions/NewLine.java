package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;

public class NewLine extends Function {
	private static final long serialVersionUID = 1L;
	
	public NewLine() {
		super(0);
	}
	
	public Element evaluate() {
		System.out.print("\n");
		return null;
	}
}