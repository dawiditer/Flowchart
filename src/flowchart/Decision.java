package flowchart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Represents a decision box in a flow chart
 * A decision box has two target symbols, a yes branch and a no branch.
 * @author dawiditer
 *
 */
class Decision implements Symbol {
	private final String title;
	private Symbol trueBranch = null;
	private Symbol falseBranch = null;
	
	// Abstraction Function
	//   represents a decision box having 2 branches, a yes branch
	//	 and a no branch.
	//
	// Representation Invariant
	//	- title is a non-empty String with no leading or trailing whitespaces
	//	- trueBranch != this, 
	//	  falseBranch != this,
	//	  trueBranch != falseBranch.
	//
	// Safety from Exposure
	//	- All fields are private
	//	- title is a final String hence guaranteed immutable
	//	- trueBranch and falseBranch are mutable references, but can only be mutated
	//	  via setter methods.
	
	public Decision(final String title) {
		this.title = title;
		checkRep();
	}
	private void checkRep() {
		assert title != null;
		assert trueBranch != this;
		assert falseBranch != this;
		assert falseBranch != trueBranch;
	}
	/**
	 * Sets a symbol as a branch from this decision symbol.
	 * 
	 * @param target non-null Symbol. Requires target != this.
	 * @param choice boolean that determines which branch target
	 * 		  belongs to.
	 * @return true if the target has been set on branch, false otherwise.
	 */
	public boolean setTarget(final Symbol target, final boolean choice) {
		assert target != null;
		if (choice && target != falseBranch) {
			trueBranch = target;
			checkRep();
			
			return true;
		} else if (!choice && target != trueBranch) {
			falseBranch = target;
			checkRep();
			
			return true;
		}
		return false;
	}
	// TODO: change from null values to NoSuchElementException
	/** Returns the target symbol connected via the true branch */
	public Symbol getTrueBranch() {
		return trueBranch;
	}
	/** Returns the target symbol connected via the true branch */
	public Symbol getFalseBranch() {
		return falseBranch;
	}
	/** Returns the target symbol connected via the specified branch */
	public Symbol getBranch(final boolean choice) {
		return choice ? trueBranch : falseBranch;
	}
	/** 
	 * Returns a doubleton list containing both branches.
	 * <p>The returned list is such that the first item is the true branch(or null if not specified)
	 * and the last item is the false branch(or null). 
	 * 
	 * <p>Consider using {@code getTargets} 
	 */
	public List<Symbol> getBranches() {
		return Arrays.asList(trueBranch, falseBranch);
	}
	@Override public String getTitle() {
		return title;
	}
	/** Returns only the branches that have been set, an empty set if no branch was set. */
	@Override public Set<Symbol> getTargets() {
		Set<Symbol> targets = new HashSet<>();
		for(Symbol symbol: getBranches()) {
			if(symbol == null) {
				continue;
			}
			targets.add(symbol);
		}
		
		return targets;
	}

}
