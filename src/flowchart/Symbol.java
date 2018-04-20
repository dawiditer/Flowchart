package flowchart;

import java.util.Set;
// TODO: the client should only be able to create symbols via the flowcharts
/**
 * Represents a symbol in a flowchart.
 * 
 * <p>There are different types of flowcharts where each type has its own 
 * set of boxes and notations. This interface allows for the implementation
 * of different types of symbols.
 * 
 * @author dawiditer
 *
 */
interface Symbol {
	/** Returns the title associated with this symbol */
	public String getTitle();
	/**
	 * Returns all the symbol targets from this
	 *  
	 * @return a set of symbols from source, an empty set
	 *     if source has no targets.
	 */
	public Set<Symbol> getTargets();
}
