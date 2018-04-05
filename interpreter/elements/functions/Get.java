package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;
import interpreter.elements.Text;

public class Get extends Function {
	private static final long serialVersionUID = 1L;
	
	public Get() {
		super(0);
	}
	
	public Element evaluate() {
		String text = System.console().readLine();
		return new Text("(" + text + ")");
	}
}
