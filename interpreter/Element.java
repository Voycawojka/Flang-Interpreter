package interpreter;

import interpreter.elements.Unknown;

public abstract class Element extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String type;
	protected void setType(String t) {type = t;}
	public String getType() {return type;}
	
	public Element() {
	}
	
	public abstract String toText();
	public abstract int	toInt() throws Unknown;
	public abstract double toReal() throws Unknown;
	
	public abstract Element add(Element el) throws Unknown;
	public abstract Element sub(Element el) throws Unknown;
	public abstract Element mul(Element el) throws Unknown;
	public abstract Element div(Element el) throws Unknown;
	public abstract Element mod(Element el) throws Unknown;
	
	public abstract Element evaluate() throws Unknown;
}