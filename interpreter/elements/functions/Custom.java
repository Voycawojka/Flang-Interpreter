package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Expression;
import interpreter.elements.Function;
import interpreter.elements.Unknown;

public class Custom extends Function {
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String name;
	
	public Custom(int argN, String name, String code) {
		super(argN);
		this.name = name;
		this.code = code;
		
		setType("custom");
	}
	
	public Element evaluate() throws Unknown {
		String argsCode = "";
		for(int i = 0; i < getArgNum(); i ++) {
			argsCode += "(ARG_" + String.valueOf(i) + ") (" + getArg(i).toText() + ") var ";
		}
		
		return new Expression(argsCode + code).evaluate();
	}
	
	public void resetType() {
		setType("function");
	}
	
	public String getName() {return name;}
}
