package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Expression;
import interpreter.elements.Function;
import interpreter.elements.Unknown;

public class StopLoop extends Function {
	private static final long serialVersionUID = 1L;
	
	public StopLoop() {
		super(1);
	}
	
	public Element evaluate() throws Unknown {
		Expression code = new Expression(getArg(0).toText());
		
		while(true) {
			Element output = code.evaluate();
			if(output != null) {
				if(output.getType() == "unknown") {
					if(output.toText().equals("stop")) return null;
					else return output;
				}else return new Unknown("reszta elementow na stosie petli");
			}
		}
	}
}
