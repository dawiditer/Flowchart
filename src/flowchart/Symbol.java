package flowchart;

import java.util.List;
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
public interface Symbol {
	/** Returns the title associated with this symbol */
	public String getTitle();
	/**
	 * Returns all the symbol sources to this
	 * 
	 * @param target symbol having zero or more sources
	 * @return a list of symbols to target, an empty list
	 *     if target has no sources.
	 */
	public List<Symbol> getSources();
	/**
	 * Returns all the symbol targets from this
	 *  
	 * @return a list of symbols from source, an empty list
	 *     if source has no targets.
	 */
	public List<Symbol> getTargets();
}
