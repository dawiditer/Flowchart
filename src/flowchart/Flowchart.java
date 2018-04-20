package flowchart;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * A flowchart representation that shows the steps as boxes 
 * of various kinds, and their order by connecting the boxes with arrows. 
 * The representation models a solution model to a 
 * given problem.
 * The two types of boxes in this flowchart are:
 *   a processing step, called an activity
 *   a decision
 * 
 * Boxes in this interface are referred as symbols.
 * @author dawiditer
 * @see Symbol
 *
 */
// TODO: use an RDT
public interface Flowchart {
	// TODO: design for extensibility and contraction
	public Activity createActivity(final String title);
	/**
	 * Adds a decision symbol to this flowchart
	 * 
	 * @param title non-null non-empty case-insensitive String
	 *     representing the title of the decision symbol.
	 * @return the decision symbol created having title.
	 * @throws IllegalArgumentException if a symbol having the title
	 *     already exists.
	 */
	public Decision createDecision(final String title);
	/**
	 * Returns all the symbol targets from a source
	 *  
	 * @param source symbol having zero or more targets.
	 * @return a list of symbols from source, an empty list
	 *     if source has no targets.
	 */
	/**
	 * Sets a Symbol as the start.
	 * 
	 * <p>A start symbol cannot be a decision symbol. 
	 * If no start symbol is set, an activity added having no sources 
	 * is set as the start.
	 * 
	 * @param start non-null activity Symbol.
	 * @return true if start is an activity symbol and has been set 
	 *     as the start symbol, false otherwise.
	 */
	public boolean setStart(final Activity start);
	/**
	 * Sets a Symbol as the end.
	 * 
	 * <p>An end symbol cannot have targets and cannot be a decision
	 * symbol. 
	 * 
	 * @param end non-null activity symbol
	 * @return true if end is an activity symbol and has been set
	 *    as the end symbol, false otherwise.
	 */
	public boolean setEnd(final Activity end);
	/**
	 * Returns the Symbol that has been set as start.
	 * 
	 * @return a reference to the symbol that's set as the start
	 *    symbol.
	 * @throws NoSuchElementException if no start symbol has been set
	 */
	public Activity getStart();

	/**
	 * Returns the Symbol that has been set as end.
	 * 
	 * @return a reference to the symbol that's set as the end
	 *    symbol.
	 * @throws NoSuchElementException if no end symbol has been set
	 */
	public Activity getEnd();
	/**
	 * Adds an activity symbol to this flowchart
	 * 
	 * @param title non-null non-empty case-insensitive String
	 *     representing the title of the activity symbol.
	 * @return the activity symbol created having title.
	 * @throws IllegalArgumentException if a symbol having the title
	 *     already exists.
	 */
	public List<Symbol> getTargets(final Symbol source);
	/**
	 * Returns all the symbol sources to a target
	 * 
	 * @param target symbol having zero or more sources
	 * @return a list of symbols to target, an empty list
	 *     if target has no sources.
	 */
	public List<Symbol> getSources(final Symbol target);
	/**
	 * Connects a source symbol to a target symbol
	 * 
	 * @param source non-null symbol.
	 * @param target non-null symbol not set as an end symbol.
	 * @return true if source has been connected to target or if
	 *     the source to target connection had already been established,
	 *     false otherwise.
	 */
	public boolean connectSymbols(final Symbol source, final Symbol target);
	/**
	 * Connects a decision symbol to its corresponding yes/no branches.
	 * 
	 * @param source non-null decision symbol
	 * @param yesBranch non-null symbol connected to the 'yes' path of a decision
	 *     symbol.
	 * @param noBranch non-null symbol connected to the 'no' path of a decision
	 *     symbol.
	 * @return true if source has been connected to yesBranch and noBranch or
	 *     if the connection had already been established, false otherwise.
	 */
	public boolean connectDecision(
			final Decision source, 
			final Symbol yesBranch, 
			final Symbol noBranch); 
}
