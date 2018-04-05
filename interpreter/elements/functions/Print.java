package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;

public class Print extends Function {
	private static final long serialVersionUID = 1L;
	
	public Print() {
		super(1);
	}
	
	public Element evaluate() {
		System.out.print(getArg(0).toText());
		return null;
	}
}
