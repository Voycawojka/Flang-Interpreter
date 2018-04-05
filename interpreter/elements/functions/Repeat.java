package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Expression;
import interpreter.elements.Function;
import interpreter.elements.Unknown;

public class Repeat extends Function {
	private static final long serialVersionUID = 1L;
	
	public Repeat() {
		super(2);
	}
	
	public Element evaluate() throws Unknown {
		int end = getArg(1).toInt();
		
		Expression code = new Expression(getArg(0).toText());
		
		for(int i = 0; i < end; i ++) {
			Element output = code.evaluate();
			if(output != null) {
				if(output.getType() == "unknown") return output;
				else return new Unknown("reszta elementow na stosie petli");
			}
		}
		
		return null;
	}
}
