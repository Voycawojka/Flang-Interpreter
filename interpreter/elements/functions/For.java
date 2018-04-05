package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Expression;
import interpreter.elements.Function;
import interpreter.elements.Unknown;

public class For extends Function {
	private static final long serialVersionUID = 1L;
	
	public For() {
		super(5);
	}
	
	public Element evaluate() throws Unknown {
		int start = getArg(4).toInt();
		int step = getArg(3).toInt();
		int end = getArg(2).toInt();
		
		String oper = getArg(1).toText();
		
		Expression code = new Expression(getArg(0).toText());
		
		for(int i = start; logicOperator((double) i, (double) end, oper); i += step) {
			Element output = code.evaluate();
			if(output != null) {
				if(output.getType() == "unknown") return output;
				else return new Unknown("reszta elementow na stopsie petli.");
			}
		}
		
		return null;
	}
}
