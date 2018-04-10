package flowchart;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlowchartTest {
	// setStart: Activity -> boolean
	//    no start exists
	//	  Activity already set as start
	//	  start exists as a different activity
	// setEnd: Activity -> boolean
	//    no end exists
	//	  Activity already set as end
	//	  end exists as a different activity
	// getStart: void -> Activity
	//	  start exists,
	//			doesn't exist
	// getEnd: void -> Activity
	//	  end exists,
	//		  doesn't exist
	// createActivity: String -> Activity
	//	  Activity having String:title exists,
	//			   doesn't exist
	// createDecision: String -> Decision
	//	  Decision having String:title exists,
	//			   doesn't exist
	// getTargets: Symbol -> List<Symbol>
	//	  Symbol has no targets,
	//			 has one target,
	//			 has multiple targets
	//	  include tests for Activity and Decision as
	//    a source and as targets.
	// getSources: Symbol -> List<Symbol>
	//	  Symbol has no sources,
	//			 has one source,
	//			 has multiple sources
	//	  include tests for Activity and Decision as
	//    a target and as sources.
	// connectSymbols: Symbol, Symbol -> boolean
	//	  Symbol:source, Symbol:target as Activity, Decision
	//	  Symbol:source, Symbol:target connection already exists,
	//					 connection doesn't exist
	// connectDecision: Decision, Symbol, Symbol -> boolean
	//    Decision:source has no branches,
	//					  has one branch,
	//					  has both branches
	//	  Symbol:source, Symbol:target as Activity, Decision
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
