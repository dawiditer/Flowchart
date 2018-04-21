package flowchart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class End implements Flowchart {
	private final String label;
	private final Set<Flowchart> sources = new HashSet<>();
	
	// Abstraction Function
	//	represents a single flowchart as the end symbol having one or
	//	more sources that's not itself and no target symbol.
	//
	// Representation Invariant
	//	- label is a non-empty string containing at least one non-whitespace character 
	//    that identifies this symbol.
	//	- sources is a set of one or more Flowcharts whose this Flowchart is a target symbol.
	//	- sources cannot contain this.
	//	
	// TODO: Safety from Exposure
	End(final String label) {
		this.label = label;
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
