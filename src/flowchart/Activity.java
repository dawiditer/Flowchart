package flowchart;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/**
 * Mutable type representing an activity symbol.
 * <p>An activity symbol is any box in a flowchart that's not
 * a decision symbol. 
 * 
 * <p>It may be generally assumed that an Activity has 
 * only one source Symbol and one target Symbol, but this
 * implementation assumes certain representations where an Activity
 * can have multiple sources and targets.
 * @author dawiditer
 *
 */
class Activity implements Symbol {
	private final String title;
	private final Set<Symbol> targets = new HashSet<>();
	
	// Abstraction Function
	//   represents an activity box in a flowchart that can be
	//   a start, end or generic Symbol.
	//
	// Representation Invariant
	//	 - title is a non-null non-empty String such that 
	//	 the first and last characters are not whitespaces.
	//	 - all symbols in targets must be non-null, distinct and must have this activity as a source
	//
	// Safety from Exposure
	//	 - All fields are private and final.
	//	 - getter function returns a read-only reference, clients cannot
	//	 directly modify the set.
	/**
	 * Initializes an activity instance
	 * @param title non-null non-empty case-insensitive String.
	 */
	public Activity(final String title) {
		this.title = title.trim();
		checkRep();
	}
	
	private void checkRep() {
		assert title != null && title.equals(title.trim());
		assert !containsNullPointer(targets);
	}
	private boolean containsNullPointer(final Set<Symbol> symbols) {
		for (Symbol symbol: symbols) {
			if (symbol == null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Sets a symbol as a direct target from this source symbol
	 * 
	 * @param target non-null Symbol having this as source symbol
	 * @return true if Symbol has been set as target from this
	 *    or if Symbol already existed as a target, false otherwise
	 */
	public boolean setTarget(final Symbol target) {
		assert target != null;
		boolean added = targets.add(target) || targets.contains(target);
		
		return added;
	}
	/** Returns true if this contains target as a target symbol */
	public boolean containsTarget(final Symbol target) {
		return targets.contains(target);
	}
	@Override public String getTitle() {
		return title;
	}
	@Override public Set<Symbol> getTargets() {
		return Collections.unmodifiableSet(targets);
	}

}
