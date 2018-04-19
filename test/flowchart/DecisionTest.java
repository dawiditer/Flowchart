package flowchart;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class DecisionTest {
	// setTarget(Symbol:target, boolean:choice) -> boolean:added
	// - target exists, doesn't exist
	// - target exists as true branch, as false branch
	// - choice = true, false
	//
	// getTrueBranch() -> Symbol:trueBranch
	// - true branch exists, doesn't exist
	//
	// getFalseBranch() -> Symbol:falseBranch
	// - false branch exists, doesn't exist
	//
	// getBranch(boolean:choice) -> Symbol:branch
	// - true branch exists, doesn't exist
	// - false branch exists, doesn't exist
	// - choice = true
	//
	// getBranches() -> List:branches
	// - true branch exists, doesn't exist
	// - false branch exists, doesn't exist
	//
	// getTargets() -> Set:targets
	// - true branch exists, doesn't exist
	// - false branch exists, doesn't exist
	
	// Tests for setTarget()
	@Test
	// covers target doesn't exist
	//		  choice = true
	public void testSetTarget_NotExist() {
		Decision decision = new Decision("Pinging?");
		Activity trueBranch = new Activity("What's the ping time");
		
		boolean targetAdded = decision.setTarget(trueBranch, true);
		
		assertTrue("Expected target branch added", targetAdded);
		assertEquals("Expected a target added", 1, decision.getTargets().size());
		assertEquals("Expected decision to contain a true branch", 
				trueBranch, decision.getTrueBranch());
	}
	@Test
	// covers target exists as a true branch
	//		  choice = true, false
	public void testSetTarget_TrueBranch() {
		Decision decision = new Decision("Pinging?");
		Activity trueBranch = new Activity("Enter the ping reaction time");
		Decision falseBranch = new Decision("Connected to the network?");
		
		boolean trueAdded = decision.setTarget(trueBranch, true);
		boolean falseAdded = decision.setTarget(falseBranch, false);
		
		boolean trueAddedAgain = decision.setTarget(trueBranch, true);
		
		assertTrue("Expected true branch added", trueAdded);
		assertTrue("Expected decision to contain true branch", trueAddedAgain);
		assertTrue("Expected false branch added", falseAdded);
		assertEquals("Expected a target added", 2, decision.getTargets().size());
		assertEquals("Expected decision to contain a true branch", 
				trueBranch, decision.getTrueBranch());
		assertEquals("Expected decision to contain a false branch", 
				falseBranch, decision.getFalseBranch());
		
	}
	@Test
	// covers target exists as a false branch
	// 		  choice = true, false
	public void testSetTarget_FalseBranch() {
		Decision decision = new Decision("Pinging?");
		Activity trueBranch = new Activity("Enter the ping reaction time");
		Decision falseBranch = new Decision("Connected to the network?");
		
		boolean trueAdded = decision.setTarget(trueBranch, true);
		boolean falseAdded = decision.setTarget(falseBranch, false);
		
		boolean falseAddedAgain = decision.setTarget(falseBranch, false);
		
		assertTrue("Expected true branch added", trueAdded);
		assertTrue("Expected decision to contain true branch", falseAddedAgain);
		assertTrue("Expected false branch added", falseAdded);
		assertEquals("Expected a target added", 2, decision.getTargets().size());
		assertEquals("Expected decision to contain a true branch", 
				trueBranch, decision.getTrueBranch());
		assertEquals("Expected decision to contain a false branch", 
				falseBranch, decision.getFalseBranch());
		
	}
	
	// Tests for getTrueBranch()
	@Test
	// covers true branch doesn't exist
	public void testGetTrueBranch_NotExist() {
		Decision decision = new Decision("Pinging?");
		Activity falseBranch = new Activity("What's the ping time");
		
		boolean targetAdded = decision.setTarget(falseBranch, false);
		
		assertTrue("Expected target branch added", targetAdded);
		assertEquals("Expected no true branch", null, decision.getTrueBranch());
	}
	@Test
	// covers true branch exists
	public void testGetTrueBranch_Exists() {
		Decision decision = new Decision("Pinging?");
		Activity trueBranch = new Activity("What's the ping time");
		
		boolean targetAdded = decision.setTarget(trueBranch, true);
		
		assertTrue("Expected target branch added", targetAdded);
		assertEquals("Expected decision to contain a true branch", 
				trueBranch, decision.getTrueBranch());
	}
	
	// Tests for getFalseBranch()
	@Test
	// covers false branch exists
	public void testGetFalseBranch_Exists() {
		Decision decision = new Decision("Pinging?");
		Activity falseBranch = new Activity("What's the ping time");
		
		boolean targetAdded = decision.setTarget(falseBranch, false);
		
		assertTrue("Expected target branch added", targetAdded);
		assertEquals("Expected decision to contain a false branch", 
				falseBranch, decision.getFalseBranch());
	}
	@Test
	// covers false branch doesn't exist
	public void testGetFalseBranch_NotExist() {
		Decision decision = new Decision("Pinging?");
		Activity trueBranch = new Activity("What's the ping time");
		
		boolean targetAdded = decision.setTarget(trueBranch, true);
		
		assertTrue("Expected target branch added", targetAdded);
		assertEquals("Expected no false branch", null, decision.getFalseBranch());
	}
	
	// Tests for getBranch()
	@Test
	// covers true branch exists
	//		  choice = true
	public void testGetBranch_True_Exists() {
		Decision decision = new Decision("Pinging?");
		Activity trueBranch = new Activity("What's the ping time");
		boolean targetAdded = decision.setTarget(trueBranch, true);
		
		assertTrue("Expected target branch added", targetAdded);
		assertEquals("Expected decision to contain a true branch", 
				trueBranch, decision.getBranch(true));
	}
	@Test
	// covers true branch doesn't exist
	//		  choice = true
	public void testGetBranch_True_NotExist() {
		Decision decision = new Decision("Pinging?");
		Activity falseBranch = new Activity("What's the ping time");
		
		boolean targetAdded = decision.setTarget(falseBranch, false);
		
		assertTrue("Expected target branch added", targetAdded);
		assertEquals("Expected no true branch", null, decision.getBranch(true));
	}
	@Test
	// covers false branch exists
	//		  choice = false
	public void testGetBranch_False_Exists() {
		Decision decision = new Decision("Pinging?");
		Activity falseBranch = new Activity("What's the ping time");
		
		boolean targetAdded = decision.setTarget(falseBranch, false);
		
		assertTrue("Expected target branch added", targetAdded);
		assertEquals("Expected decision to contain a false branch", 
				falseBranch, decision.getBranch(false));
	}
	@Test
	// covers false branch doen't exist
	//		  choice = false
	public void testGetBranch_False_NotExist() {
		Decision decision = new Decision("Pinging?");
		Activity trueBranch = new Activity("What's the ping time");
		
		boolean targetAdded = decision.setTarget(trueBranch, true);
		
		assertTrue("Expected target branch added", targetAdded);
		assertEquals("Expected no false branch", null, decision.getBranch(false));
		
	}
	
	// Tests for getBranches()
	@Test
	// covers true branch exists
	//		  false branch exists
	public void testGetBranches_TrueExists_FalseExists() {
		Decision decision = new Decision("Pinging?");
		Activity trueBranch = new Activity("Enter the ping reaction time");
		Decision falseBranch = new Decision("Connected to the network?");
		
		decision.setTarget(trueBranch, true);
		decision.setTarget(falseBranch, false);
		
		List<Symbol> branches = decision.getBranches();
		
		assertEquals("Expected doubleton list", 2, branches.size());
		assertEquals("Expected first element to be true branch",
				trueBranch, branches.get(0));
		assertEquals("Expected last element to be false branch",
				falseBranch, branches.get(1));
	}
	@Test
	// covers true branch exists
	//		  false branch doesn't exist
	public void testGetBranches_TrueExists_FalseNotExist() {
		Decision decision = new Decision("Pinging?");
		Activity trueBranch = new Activity("Enter the ping reaction time");
		
		decision.setTarget(trueBranch, true);
		
		List<Symbol> branches = decision.getBranches();
		
		assertEquals("Expected doubleton list", 2, branches.size());
		assertEquals("Expected first element to be true branch",
				trueBranch, branches.get(0));
		assertEquals("Expected last element to be null",
				null, branches.get(1));
	}
	@Test
	// covers true branch doesn't exist
	//		  false branch exists
	public void testGetBranches_TrueNotExist_FalseExists() {
		Decision decision = new Decision("Pinging?");
		Decision falseBranch = new Decision("Connected to the network?");
		
		decision.setTarget(falseBranch, false);
		
		List<Symbol> branches = decision.getBranches();
		
		assertEquals("Expected doubleton list", 2, branches.size());
		assertEquals("Expected first element to be null",
				null, branches.get(0));
		assertEquals("Expected last element to be false branch",
				falseBranch, branches.get(1));
	}
	@Test
	// covers true branch doesn't exist
	//		  false branch doesn't exist
	public void testGetBranches_TrueFalseNotExist() {
		Decision decision = new Decision("Pinging?");	
		List<Symbol> targets = decision.getBranches();
		
		assertEquals("Expected doubleton list", 2, targets.size());
		assertEquals("Expected first element to be null",
				null, targets.get(0));
		assertEquals("Expected last element to be null",
				null, targets.get(1));
	}
	
	// Tests for getTargets()
	@Test
	// covers true branch exists
	//		  false branch exists
	public void testGetTargets_TrueExists_FalseExists() {
		Decision decision = new Decision("Pinging?");
		Activity trueBranch = new Activity("Enter the ping reaction time");
		Decision falseBranch = new Decision("Connected to the network?");
		
		decision.setTarget(trueBranch, true);
		decision.setTarget(falseBranch, false);
		
		Set<Symbol> targets = decision.getTargets();
		
		assertEquals("Expected doubleton set", 2, targets.size());
		assertTrue("Expected set to contain true branch",
				targets.contains(trueBranch));
		assertTrue("Expected set to contain false branch",
				targets.contains(falseBranch));
	}
	@Test
	// covers true branch exists
	//		  false branch doesn't exist
	public void testGetTargets_TrueExists_FalseNotExist() {
		Decision decision = new Decision("Pinging?");
		Activity trueBranch = new Activity("Enter the ping reaction time");
		
		decision.setTarget(trueBranch, true);
		
		Set<Symbol> targets = decision.getTargets();
		
		assertEquals("Expected singleton set", 1, targets.size());
		assertTrue("Expected set to contain true branch",
				targets.contains(trueBranch));
	}
	@Test
	// covers true branch doesn't exist
	//		  false branch exists
	public void testGetTargets_TrueNotExist_FalseExists() {
		Decision decision = new Decision("Pinging?");
		Decision falseBranch = new Decision("Connected to the network?");
		
		decision.setTarget(falseBranch, false);
		
		Set<Symbol> targets = decision.getTargets();
		
		assertEquals("Expected singleton set", 1, targets.size());
		assertTrue("Expected set to contain true branch",
				targets.contains(falseBranch));
	}
	@Test
	// covers true branch doesn't exist
	//		  false branch doesn't exist
	public void testGetTargets_TrueFalseNotExist() {
		Decision decision = new Decision("Pinging?");	
		Set<Symbol> targets = decision.getTargets();
		
		assertTrue("Expected an empty set", targets.isEmpty());
	}
}
