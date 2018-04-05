package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;
import interpreter.elements.Unknown;

public class Clear extends Function {
	private static final long serialVersionUID = 1L;

	public Clear() {
		super(0);
	}
	
	public Element evaluate() {return new Unknown("clear");}
}