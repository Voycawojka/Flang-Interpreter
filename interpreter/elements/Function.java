package interpreter.elements;

import interpreter.Element;

public abstract class Function extends Element {
	private static final long serialVersionUID = 1L;
	
	private boolean dtb(double x) {
		return !(x == 0);
	}
	
	private int argNum;
	private Element[] args;
	
	protected Element getArg(int i) {return args[i];}
	
	protected boolean logicOperator(double a, double b, String op) {
		if(op == "<") return a < b;
		if(op == ">") return a > b;
		if(op == "<=") return a <= b;
		if(op == ">=") return a >= b;
		if(op == "=") return a == b;
		if(op == "!=") return a != b;
		if(op == "and") return dtb(a) && dtb(b);
		if(op == "or") return dtb(a) || dtb(b);
		if(op == "nand") return !(dtb(a) && dtb(b));
		if(op == "nor") return !(dtb(a) || dtb(b));
		return false;
	}
	
	public Function(int argNum) {
		super();
		this.argNum = argNum;
		setType("function");
		
		args = new Element[argNum];
	}
	
	public String toText() {return "";}
	public int toInt() {return 0;}
	public double toReal() {return 0;}
	
	public Element add(Element el) {return this;}
	public Element sub(Element el) {return this;}
	public Element mul(Element el) {return this;}
	public Element div(Element el) {return this;}
	public Element mod(Element el) {return this;}
	
	public abstract Element evaluate() throws Unknown;
	
	public int getArgNum() {return argNum;}
	public void setArg(int i, Element arg) {args[i] = arg;}
}
