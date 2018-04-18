package flowchart;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class ActivityTest {
	// setTarget(Symbol:target) -> boolean:added
	//  - activity contains target; true, false
	// containsTarget(Symbol:target) -> boolean:contains
	//  - activity contains target; true, false
	// getTargets() -> SortedSet:targets
	//	- targets.size(); 0, 1, > 1
	
	// Tests for setTarget()
	@Test
	// covers activity doesn't contain target
	public void testSetTarget_NotExist() {
		Activity activity = new Activity("Start Node");
		Activity target = new Activity("Test Cases");
		boolean added = activity.setTarget(target);
		boolean contains = activity.containsTarget(target);
		
		assertTrue("Expected target added successfully", added);
		assertTrue("Expected activity to contain target", contains);
	}
	@Test
	// covers activity contains target
	public void testSetTarget_Exists() {
		Activity activity = new Activity("Start Node");
		Activity target = new Activity("Test Cases");
		boolean added = activity.setTarget(target);
		boolean contains = activity.containsTarget(target);
		boolean addedAgain = activity.setTarget(target);
		boolean stillContains = activity.containsTarget(target);
		
		assertTrue("Expected target added successfully", added);
		assertTrue("Expected existing target", addedAgain);
		assertTrue("Expected activity to contain target", contains);
		assertTrue("Expected activity to still contain target", stillContains);
	}
	
	// Tests for containsTarget()
	@Test
	// covers activity contains target
	public void testContainsTarget_Exists() {
		Activity activity = new Activity("Start Node");
		Activity target = new Activity("Test Cases");
		boolean added = activity.setTarget(target);
		boolean contains = activity.containsTarget(target);
		
		assertTrue("Expected target added successfully", added);
		assertTrue("Expected activity to contain target", contains);
	}
	@Test
	// covers activity contains target
	public void testContainsTarget_NotExist() {
		Activity activity = new Activity("Start Node");
		Activity target = new Activity("Test Cases");
		boolean contains = activity.containsTarget(target);
		
		assertFalse("Expected activity to contain target", contains);
	}
	
	// Tests for getTargets()
	@Test
	// covers targets.size() = 0
	public void testGetTargets_Empty() {
		Activity activity = new Activity("Start Node");
		Set<Symbol> targets = activity.getTargets();
		
		assertTrue("Expected an empty set", targets.isEmpty());
	}

	@Test
	// covers targets.size() = 1
	public void testGetTargets_Singleton() {
		Activity activity = new Activity("Start Node");
		Activity target = new Activity("Test Cases");
		boolean added = activity.setTarget(target);
		boolean contains = activity.containsTarget(target);

		Set<Symbol> targets = activity.getTargets();
		
		assertTrue("Expected target added successfully", added);
		assertTrue("Expected activity to contain target", contains);
		assertEquals("Expected singleton set", 1, targets.size());
	}
	
	@Test
	// covers targets.size() > 1
	public void testGetTargets_Multiple() {
		Activity activity = new Activity("Start Node");
		Activity target = new Activity("Test Cases");
		Activity target2 = new Activity("Implement Abstraction");
		activity.setTarget(target);
		activity.setTarget(target2);
		boolean contains = activity.containsTarget(target);
		boolean contains2 = activity.containsTarget(target2);

		Set<Symbol> targets = activity.getTargets();

		assertTrue("Expected activity to contain target", contains);
		assertTrue("Expected activity to contain target", contains2);
		assertEquals("Expected doubleton set", 2, targets.size());
	}
}
