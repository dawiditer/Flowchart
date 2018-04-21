package flowchart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Activity implements Flowchart {
	private final String label;
	private final Set<Flowchart> sources  = new HashSet<>();
	private Flowchart target = null;
	
	// Abstraction Function
	//	represents a flowchart as an activity connected to one
	//	or more sources and one target.
	// 
	// Representation Invariant
	//	- label is a non-empty string containing at least one non-whitespace character 
	//    that identifies this Flowchart.
	//	- sources is a set of zero or more Flowcharts whose this Flowchart is a target symbol.
	//	- target is any other Flowchart but Start.
	// 	  
	// TODO: Safety from Exposure
	
	Activity(final String label) {
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
	// USE Collections.singletonList()
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
