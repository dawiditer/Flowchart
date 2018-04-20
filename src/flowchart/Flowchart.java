package flowchart;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * A flowchart abstraction that represents the steps as boxes 
 * of various kinds, and their order by connecting the boxes. 
 * 
 * <p>This interface makes a number of assumptions:
 * - The are two types of boxes(symbols) in this flowchart are:
 *   	a processing step, called an activity
 *   	a decision
 * - An activity symbol can have only be a source to one target but can
 *   be a target to multiple source symbols. This assumption allows for 
 *   representation of sequential processes.
 * - A start symbol is an activity having no sources.
 * - An end symbol is an activity having no targets.
 * - A decision symbol has exactly 2 targets, a true branch and a false branch
 *   that connect to symbols based on a 'yes or no' choice.
 * - A decision symbol cannot be it's own target or it's own source. 
 * - All symbols between start and end must have at least one source. 
 *  
 * @author dawiditer
 *
 */
// TODO: use an RDT
public interface Flowchart {
	// TODO: design for extensibility and contraction
	// Flowchart = Activity(title:String) + Decision(title:String)
	/**
	 * Sets or resets an activity as the start symbol.
	 * 
	 * <p>A start can only be an activity symbol, having
	 * no source symbols. Creates an activity symbol if it doesn't exist
	 * 
	 * <p>If {@code reset} is true, a successful call to this
	 * method resets the current start symbol to {@code start}. 
	 * A call to this method is ineffective if {@code reset} is false
	 * and a start already exists.
	 *  
	 * @param start non-empty String label identifying an activity symbol.
	 * @param reset boolean that determines if the current start should be reset.
	 * @return true if start is an activity symbol and has been set 
	 *     as the start symbol, false otherwise.
	 * @see #setStartIfAbsent(String)
	 */
	public boolean setStart(final String start, final boolean reset);
	/**
	 * Sets an activity as the start symbol if none has been set.
	 * 
	 * <p>If a start symbol already exists, this method is ineffective and
	 * its call is similar to:
	 * 		setStart(start, false)
	 * 
	 * @param start non-empty String label identifying an activity symbol.
	 * @return true if start is an activity symbol and has been set 
	 *     as the start symbol, false otherwise.
	 */
	public boolean setStartIfAbsent(final String start);
	/**
	 * Sets an activity as the end symbol.
	 * 
	 * <p>An end symbol cannot have targets and cannot be a decision
	 * symbol. Creates an activity symbol if it doesn't exist
	 * 
	 * <p>If {@code reset} is true, a successful call to this
	 * method resets the current end symbol to {@code end}. 
	 * A call to this method is ineffective if {@code reset} is false
	 * and an end symbol already exists.
	 * 
	 * @param end String label identifying an activity symbol.
	 * @param reset boolean that determines if the current end should be reset.
	 * @return true if end is an activity symbol and has been set
	 *    as the end symbol, false otherwise.
	 * @see #setEndIfAbsent(String)
	 */
	public boolean setEnd(final String end, final boolean reset);
	/**
	 * Sets an activity as the end symbol if none has been set.
	 * 
	 * <p>If an end symbol already exists, this method is ineffective and
	 * its call is similar to:
	 * 		setEnd(start, false)
	 * 
	 * @param end non-empty String label identifying an activity symbol.
	 * @return true if end is an activity symbol and has been set 
	 *     as the end symbol, false otherwise.
	 */
	public boolean setEndIfAbsent(final String end);
	/**
	 * Returns the label of the symbol that has been set as start.
	 * 
	 * @return String label identifying the activity that has been set
	 *    as the start symbol.
	 * @throws NoSuchElementException if no start symbol exists
	 */
	public String getStart();

	/**
	 * Returns the label of the symbol that has been set as end.
	 * 
	 * @return String label identifying the activity that has been set 
	 * 	  as the end symbol.
	 * @throws NoSuchElementException if no end symbol exists
	 */
	public String getEnd();
	// TODO: better implementation that avoids the use of null
	// TODO: more cohesive implementation
	/**
	 * Returns all the target symbols from a source
	 * 
	 * <p>If the source is a decision symbol, the list returned 
	 * is such that the first item is the true branch(or null) and the last
	 * item is the false branch(or null). 
	 * 
	 * <p>If the source is an activity symbol, a singleton list is returned
	 * containing the target(or null).
	 * 
	 * @param source String label of symbol having zero or more targets.
	 * @return a list of target symbols from source such that:
	 * 		list.size() == 1 if source is an activity
	 * 		list.size() == 2 if source is a decision
	 */
	public List<String> getTargets(final String source);
	/**
	 * Returns all the source symbols to a target
	 * 
	 * @param target String label of symbol having zero or more sources
	 * @return a list of symbols to target, an empty list
	 *     if target has no sources.
	 */
	public List<String> getSources(final String target);
	/**
	 * Connects a source symbol to a target symbol
	 * 
	 * <p>This effectively creates the symbols if they don't exist.
	 * Since an activity can only have one target, a successful call to this method resets
	 * the current {@code source}-{@code target} connection if it exists
	 * 
	 * @param source non-empty String label of an activity symbol that's not an end activity.
	 * @param target non-empty String label of a symbol that's not a start activity.
	 * @return true if source has been connected to target,
	 *     false otherwise.
	 * @throws IllegalArgumentException if source is not an activity symbol.
	 * @see #connectActivity(String, String, boolean)
	 */
	public boolean connectActivity(final String source, final String target);

	/**
	 * Connects a source symbol to a target symbol
	 * 
	 * <p>This effectively creates the symbols if they don't exist
	 * in the flowchart. 
	 * A successful call to this method is ineffective if a {@code source}-{@code target}
	 * connection exists prior to the call.
	 * 
	 * @param source non-empty String label of an activity symbol that's not an end activity.
	 * @param target non-empty String label of a symbol that's not a start activity.
	 * @return true if source has been connected to target,
	 *     false otherwise.
	 * @throws IllegalArgumentException if source is not an activity symbol.
	 */
	public boolean connectActivityIfAbsent(final String source, final String target);
	/**
	 * Connects a decision symbol to both yes and no branches.
	 * 
	 * <p>A decision symbol can only have 2 targets, yes and no branches.
	 * A successful call to this method resets any existing connections 
	 * prior to the call. To avoid resetting any connections, use 
	 * {@link #connectToYesBranch} and {@link #connectToNoBranch}.
	 * 
	 * <p>If a connection to either branches fails, the entire call becomes
	 * unsuccessful and returns false. Both connections must be established
	 * for the method call to become successful.
	 * 
	 * <p>Subsequent calls to this methods having the same arguments is such that:
	 *   connectDecision(source, yesBranch1, noBranch1) == connectDecision(source, yesBranch2, noBranch2)
	 * if yesBranch1 == yesBranch2 and noBranch1 == noBranch2. 
	 * 
	 * @param source non-empty String label of a decision symbol.
	 * @param yesBranch non-empty String label of a symbol connected 
	 * 	   to the 'yes' path of a decision symbol.
	 * @param noBranch non-null symbol connected to the 'no' path of a decision
	 *     symbol.
	 * @return true if source has been connected to both the
	 *     yesBranch and noBranch, false otherwise.
	 * @throws IllegalArgumentException if source is not a decision symbol.
	 */
	public boolean connectDecision(
			final String source, 
			final String yesBranch, 
			final String noBranch);
	/**
	 * Connects a decision symbol to a yes branch.
	 * 
	 * <p>{@code reset} determines if a prior connection should be reset if it
	 * existed before a call to this method. The call is ineffective
	 * if {@code reset} is false and a connection already exists.
	 * 
	 * <p>The method returns true if the {@code source} to {@code yesBranch} connection
	 * already exists regardless of {@code reset}.
	 * 
	 * @param source non-empty String label of a decision symbol.
	 * @param yesBranch non-empty String label of a symbol connected 
	 * 	   to the 'yes' path of a decision symbol.
	 * @param reset boolean that determines if the current connection should be reset.
	 * @return true if source has been successfully connected to yesBranch, false otherwise.
	 * @throws IllegalArgumentException if source is not a decision symbol.
	 */
	public boolean connectToYesBranch(
			final String source, 
			final String yesBranch, 
			final boolean reset);
	/**
	 * Connects a decision symbol to a yes branch.
	 * 
	 * <p>{@code reset} determines if a prior connection should be reset if it
	 * existed before a call to this method. The call is ineffective
	 * if {@code reset} is false and a connection already exists.
	 * 
	 * <p>The method returns true if the {@code source} to {@code noBranch} connection
	 * already exists regardless of {@code reset}.
	 * 
	 * @param source non-empty String label of a decision symbol.
	 * @param yesBranch non-empty String label of a symbol connected 
	 * 	   to the 'no' path of a decision symbol.
	 * @param reset boolean that determines if the current connection should be reset.
	 * @return true if source has been successfully connected to noBranch, false otherwise.
	 * @throws IllegalArgumentException if source is not a decision symbol.
	 */
	public boolean connectToNoBranch(
			final String source, 
			final String noBranch, 
			final boolean reset);
}
