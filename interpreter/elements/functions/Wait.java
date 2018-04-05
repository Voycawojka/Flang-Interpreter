package interpreter.elements.functions;

import java.util.concurrent.TimeUnit;

import interpreter.Element;
import interpreter.elements.Function;
import interpreter.elements.Unknown;

public class Wait extends Function {
	private static final long serialVersionUID = 1L;
	
	public Wait() {
		super(2);
	}
	
	public Element evaluate() throws Unknown {
		try {
			if(getArg(0).toText().equals("ns")) TimeUnit.NANOSECONDS.sleep(getArg(1).toInt());
			if(getArg(0).toText().equals("us")) TimeUnit.MICROSECONDS.sleep(getArg(1).toInt());
			if(getArg(0).toText().equals("ms")) TimeUnit.MILLISECONDS.sleep(getArg(1).toInt());
			if(getArg(0).toText().equals("s")) TimeUnit.SECONDS.sleep(getArg(1).toInt());
			if(getArg(0).toText().equals("m")) TimeUnit.MINUTES.sleep(getArg(1).toInt());
			if(getArg(0).toText().equals("h")) TimeUnit.HOURS.sleep(getArg(1).toInt());
		}catch(InterruptedException ex) {
		}
		
		return null;
	}
}
