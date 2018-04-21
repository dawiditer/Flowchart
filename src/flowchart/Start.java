package flowchart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Start implements Flowchart {
	private final String title;
	private final Flowchart target =  null;
	
	// Abstraction Function
	//	represents a single flowchart as the start symbol having zero or one
	//	target symbol that's not itself and no source symbol. 
	// 
	// Representation Invariant
	//	- title is a non-empty string containing at least one non-whitespace character 
	//    that identifies this symbol.
	//	- target is a Flowchart whose this symbol is the source.
	//	- target cannot be this symbol.
	//
	// TODO: Safety from Exposure
	Start(final String title) {
		this.title = title;
	}
	@Override
	public Flowchart setStart(Flowchart start, boolean reset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flowchart setStartIfAbsent(Flowchart start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flowchart setEnd(Flowchart end, boolean reset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flowchart setEndIfAbsent(Flowchart end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flowchart getStart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flowchart getEnd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flowchart> getTargets(Flowchart source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flowchart> getSources(Flowchart target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flowchart connectActivity(Flowchart source, Flowchart target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flowchart connectActivityIfAbsent(Flowchart source, Flowchart target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flowchart connectDecision(Flowchart source, Flowchart yesBranch, Flowchart noBranch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flowchart connectToYesBranch(Flowchart source, Flowchart yesBranch, boolean reset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flowchart connectToNoBranch(Flowchart source, Flowchart noBranch, boolean reset) {
		// TODO Auto-generated method stub
		return null;
	}

}
