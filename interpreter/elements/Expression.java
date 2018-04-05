package interpreter.elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import interpreter.Element;
import interpreter.elements.functions.Add;
import interpreter.elements.functions.Clear;
import interpreter.elements.functions.Compare;
import interpreter.elements.functions.Convert;
import interpreter.elements.functions.Custom;
import interpreter.elements.functions.Def;
import interpreter.elements.functions.Div;
import interpreter.elements.functions.Equal;
import interpreter.elements.functions.Evaluate;
import interpreter.elements.functions.For;
import interpreter.elements.functions.Get;
import interpreter.elements.functions.GetLetter;
import interpreter.elements.functions.HandleUnknown;
import interpreter.elements.functions.If;
import interpreter.elements.functions.Mod;
import interpreter.elements.functions.Mul;
import interpreter.elements.functions.NewLine;
import interpreter.elements.functions.Print;
import interpreter.elements.functions.Rand;
import interpreter.elements.functions.RandomSeed;
import interpreter.elements.functions.Repeat;
import interpreter.elements.functions.StopLoop;
import interpreter.elements.functions.Sub;
import interpreter.elements.functions.TextSize;
import interpreter.elements.functions.TypeOf;
import interpreter.elements.functions.Var;
import interpreter.elements.functions.Wait;

public class Expression extends Element {
	private static final long serialVersionUID = 1L;

	private String expr;
	private static Map<String, Function> functions = new HashMap<String, Function>();
	
	private Element recognizeElement(String e) {		
		if(functions.get(e) != null) return functions.get(e);
		
		try {
			return new Integ(Integer.valueOf(e));
		}catch(NumberFormatException iex) {
			try {
				return new Real(Double.valueOf(e));
			}catch(NumberFormatException rex) {
				return new Unknown(e);
			}
		}		
	}
	
	private static void initFunctions() {
		functions.put("+", new Add());
		functions.put("-", new Sub());
		functions.put("*", new Mul());
		functions.put("/", new Div());
		functions.put("mod", new Mod());
		functions.put("print", new Print());
		functions.put("convert", new Convert());
		functions.put("wait", new Wait());
		functions.put("evaluate", new Evaluate());
		functions.put("for", new For());
		functions.put("repeat", new Repeat());
		functions.put("if", new If());
		functions.put("?", new Compare());
		functions.put("stoploop", new StopLoop());
		functions.put("get", new Get());
		functions.put("typeof", new TypeOf());
		functions.put("clear", new Clear());
		functions.put("!", new HandleUnknown());
		functions.put("equal", new Equal());
		functions.put("def", new Def());
		functions.put("var", new Var());
		functions.put("random", new Rand());
		functions.put("nl", new NewLine());
		functions.put("rseed", new RandomSeed());
		functions.put("textsize", new TextSize());
		functions.put("getletter", new GetLetter());
	}
	
	public Expression(String expr) {
		super();
		this.expr = expr + " ";
		setType("expression");
		initFunctions();
	}
	
	public static void addFunction(String k, Function f) {
		functions.put(k, f);
	}
	
	public static void resetFunctions() {
		functions.clear();
		initFunctions();
	}
	
	public String toText() {return expr;}
	public int toInt() {return 0;}
	public double toReal() {return 0;}
	
	public Element add(Element el) {return this;}
	public Element sub(Element el) {return this;}
	public Element mul(Element el) {return this;}
	public Element div(Element el) {return this;}
	public Element mod(Element el) {return this;}
	
	public Element evaluate() throws Unknown {
		Stack<Element> elements = new Stack<>();
		
		boolean handleUnknown = false;
		
		String tmp = "";
		int quot = 0;
		for(int i = 0; i < expr.length(); i ++) {
			if(expr.charAt(i) == '#') {
				for(int j = i; j < expr.length(); j ++) {
					i = j;
					if(expr.charAt(i) == '\n') break;
				}
				continue;
			}
			
			if(expr.charAt(i) == '(') {
				quot ++;
				if(quot == 1) continue;
			}
			if(expr.charAt(i) == ')') {
				quot --;
				if(quot == 0) {
					elements.push(new Text(tmp));
					tmp = "";
					continue;
				}else if(quot < 0) return new Unknown("zamkniecie nawiasu");
			}
			
			if((expr.charAt(i) == ' ' || expr.charAt(i) == '\t' || expr.charAt(i) == '\n') && quot == 0) {
				if(tmp != "") {
					elements.push(recognizeElement(tmp));
					tmp = "";
					
					if(elements.lastElement().getType() == "unknown" && !handleUnknown) return elements.lastElement();
					else if(elements.lastElement().getType() == "return") return elements.lastElement().evaluate();
					else if(elements.lastElement().getType() == "function") {
						Function func = (Function) elements.lastElement();
						elements.pop();
						for(int j = 0; j < func.getArgNum(); j ++) {
							if(elements.isEmpty()) {
								if(handleUnknown) {
									elements.push(new Unknown("argument dla funkcji"));
									continue;
								}else return new Unknown("argument dla funkcji");
							}
							
							func.setArg(j, elements.pop());	
						}
						
						try {
							Element returned = func.evaluate();
							if(returned != null) {
								if(returned.getType() != "unknown") {
									if(returned.getType() == "custom") {
										Custom custom = (Custom) returned;
										custom.resetType();
									
										functions.put(custom.getName(), custom);
									}else elements.push(returned);
								}else {
									if(returned.toText() == "stop") return returned;
									else if(returned.toText() == "clear") elements.clear();
									else if(returned.toText() == "handleUnknown") handleUnknown = !handleUnknown;
									else if(handleUnknown) elements.push(returned);
									else return returned;
								}
							}
						}catch(Unknown u) {
							if(!handleUnknown) return u;
							else elements.push(u);
						}
					}
				}
			}else tmp += expr.charAt(i);
		}
		
		if(elements.size() > 1) {
			String err = "operacje dla pozostalych elementow stosu.";
			while(elements.size() > 0) {
				err += "\n   -" + elements.lastElement().getType() + ": " + elements.lastElement().toText();
				elements.pop();
			}
			
			return new Unknown(err);
		}else if(elements.size() == 1) return elements.lastElement();
		else return null;
	}
	
	public List<String> getKeywordList() {
		initFunctions();
		
		List<String> list = new ArrayList<>();
		for(Map.Entry<String, Function> fmap : functions.entrySet()) {
			list.add(fmap.getKey());
		}
		
		return list;
	}
	
	public List<String> getKeystringList() {
		return Arrays.asList("(<)", "(>)", "(<=)", "(>=)", "(=)", "(!=)", "(and)", "(or)", "(nand)", "(nor)", "(integer)", "(real)", "(text)", "(unknown)", "(ns)", "(us)", "(ms)", "(s)", "(m)", "(h)");
	}
}
