package flowchart;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * A flowchart abstraction that represents the steps as boxes 
 * of various kinds, and their order by connecting the boxes. 
 * 
 * <p>This interface makes a number of assumptions:
 * - A flowchart is made by combining 2 or more flowcharts. This implies
 *   that at it's simplest, a flowchart is a box.
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
public interface Flowchart {
	// TODO: strengthen the preconditions. The client is being asked for a lot.
	// TODO: design for extensibility and contraction
	// TODO: add methods to remove symbols
	// Flowchart = Start(label:String) + Activity(label:String) + Decision(label:String) + End(label:String)
	public static Flowchart instantiate(final String label) {
		throw new RuntimeException("unimplemented");
	}
	/**
	 * Sets or resets an activity as the start symbol.
	 * 
	 * <p>A start can only be an activity symbol, having
	 * no source symbols. Creates an activity symbol if it doesn't exist.
	 * 
	 * <p>If {@code reset} is {@code true}, a successful call to this
	 * method resets the current start symbol to {@code start}. 
	 * A call to this method is ineffective if {@code reset} is {@code false}
	 * and a start already exists.
	 *  
	 * @param start Flowchart representing an activity symbol.
	 * @param reset boolean that determines if the current start should be reset.
	 * @return the current start symbol:
	 *     - {@code start} is returned if it has been set as the start.
     *     - the previous start is returned if {@code reset} is set to {@code false}.
	 * @throws IllegalArgumentException if {@code start} is not an activity
     *       or if {@code start} is a source to at least one target.
	 * @see #setStartIfAbsent(Flowchart)
	 */
	public Flowchart setStart(final Flowchart start, final boolean reset);
	/**
	 * Sets an activity as the start symbol if none has been set.
	 * 
	 * <p>If a start symbol already exists, this method is ineffective and
	 * its call is similar to:
	 * 		{@code setStart(start, false)}
	 * 
	 * @param start Flowchart representing an activity symbol.
	 * @return the current start symbol which is {@code start}
	 *    if none existed.
	 * @throws IllegalArgumentException if {@code start} is not an activity
     *       or if {@code start} is a source to at least one target.
	 */
	public Flowchart setStartIfAbsent(final Flowchart start);
	/**
	 * Sets an activity as the end symbol.
	 * 
	 * <p>An end symbol cannot have targets and cannot be a decision
	 * symbol. Creates an activity symbol if it doesn't exist
	 * 
	 * <p>If {@code reset} is {@code true}, a successful call to this
	 * method resets the current end symbol to {@code end}. 
	 * A call to this method is ineffective if {@code reset} is {@code false}
	 * and an end symbol already exists.
	 * 
	 * @param end Flowchart representing an activity symbol.
	 * @param reset boolean that determines if the current end should be reset.
	 * @return the current end symbol:
	 *     - {@code end} is returned if it has been set as the end symbol.
     *     - the previous end is returned if {@code reset} is set to {@code false}
	 * @throws IllegalArgumentException if {@code end} is not an activity
     *       or if {@code end} is a target to at least one source.
	 * @see #setEndIfAbsent(Flowchart)
	 */
	public Flowchart setEnd(final Flowchart end, final boolean reset);
	/**
	 * Sets an activity as the end symbol if none has been set.
	 * 
	 * <p>If an end symbol already exists, this method is ineffective and
	 * its call is similar to:
	 * 		setEnd(start, false)
	 * 
	 * @param end Flowchart representing an activity symbol.
	 * @return the current end symbol which is {@code end}
	 *    if none existed.
	 * @throws IllegalArgumentException if {@code end} is not an activity
     *       or if {@code end} is a target to at least one source.
	 */
	public Flowchart setEndIfAbsent(final Flowchart end);
	/**
	 * Returns the label of the symbol that has been set as start.
	 * 
	 * @return Flowchart representing the activity that has been set
	 *    as the start symbol.
	 * @throws NoSuchElementException if no start symbol exists
	 */
	public Flowchart getStart();

	/**
	 * Returns the label of the symbol that has been set as end.
	 * 
	 * @return Flowchart representing the activity that has been set 
	 * 	  as the end symbol.
	 * @throws NoSuchElementException if no end symbol exists
	 */
	public Flowchart getEnd();
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
	 * @param source Flowchart representing symbol having zero or more targets.
	 * @return a list of target symbols from {@code source} such that:
	 * 		list.size() == 1 if source is an activity
	 * 		list.size() == 2 if source is a decision
	 */
	public List<Flowchart> getTargets(final Flowchart source);
	/**
	 * Returns all the source symbols to a target
	 * 
	 * @param target Flowchart representing symbol having zero or more sources
	 * @return a list of symbols to target, an empty list
	 *     if {@code target} has no sources.
	 */
	public List<Flowchart> getSources(final Flowchart target);
	/**
	 * Connects a source symbol to a target symbol
	 * 
	 * <p>This effectively creates the symbols if they don't exist.
	 * Since an activity can only have one target, a successful call to this method resets
	 * the current {@code source}-{@code target} connection if it exists
	 * 
	 * @param source Flowchart representing an activity symbol that's not an end activity.
	 * @param target Flowchart representing a symbol that's not a start activity.
	 * @return the new Flowchart made from connecting {@code source} to {@code target},
	 *     or {@code null} if connection was unsuccessful.
	 * @throws IllegalArgumentException if {@code source} is not an activity symbol.
	 * @see #connectActivityIfAbsent(Flowchart, Flowchart)
	 */
	public Flowchart connectActivity(final Flowchart source, final Flowchart target);

	/**
	 * Connects a source symbol to a target symbol
	 * 
	 * <p>This effectively creates the symbols if they don't exist
	 * in the flowchart. 
	 * A successful call to this method is ineffective if a {@code source}-{@code target}
	 * connection exists prior to the call.
	 * 
	 * @param source Flowchart representing an activity symbol that's not an end activity.
	 * @param target Flowchart representing a symbol that's not a start activity.
	 * @return the new Flowchart made from connecting {@code source} to {@code target}
	 *     if no connection existed, or {@code null} if connection was unsuccessful.
	 * @throws IllegalArgumentException if {@code source} is not an activity symbol.
	 */
	public Flowchart connectActivityIfAbsent(final Flowchart source, final Flowchart target);
	/**
	 * Connects a decision symbol to both yes and no branches.
	 * 
	 * <p>A decision symbol can only have 2 targets, yes and no branches.
	 * A successful call to this method resets any existing connections 
	 * prior to the call. To avoid resetting any connections, use 
	 * {@link #connectToYesBranch} and {@link #connectToNoBranch}.
	 * 
	 * <p>If a connection to either branches fails, the entire connection becomes
	 * unsuccessful and returns false. Both connections must be established
	 * for the method call to yield a successful result.
	 * 
	 * <p>Subsequent calls to this method using the same arguments yields 
	 * the same result.  
	 * 
	 * @param source Flowchart representing a decision symbol.
	 * @param yesBranch Flowchart representing a symbol to connect 
	 * 	   to the 'yes' path of a decision symbol.
	 * @param noBranch Flowchart representing a symbol to connect 
	 *     to the 'no' path of a decision symbol.
	 * @return the Flowchart made from connecting {@code source} to {@code yesBranch}
	 *     and {@code noBranch}. Returns {@code null} if a connection to either branch fails.
	 * @throws IllegalArgumentException if {@code source} is not a decision symbol.
	 * @see #connectToYesBranch(Flowchart, Flowchart, boolean)
	 * @see #connectToNoBranch(Flowchart, Flowchart, boolean)
	 */
	public Flowchart connectDecision(
			final Flowchart source, 
			final Flowchart yesBranch, 
			final Flowchart noBranch);
	/**
	 * Connects a decision symbol to a yes branch.
	 * 
	 * <p>{@code reset} determines if a prior connection should be reset if it
	 * existed before a call to this method. The call is ineffective
	 * if {@code reset} is {@code false} and a connection already exists.
	 * 
	 * <p>The method returns true if the {@code source} to {@code yesBranch} connection
	 * already exists regardless of {@code reset}.
	 * 
	 * @param source Flowchart representing a decision symbol.
	 * @param yesBranch Flowchart representing a symbol to connect
	 * 	   to the 'yes' path of a decision symbol.
	 * @param reset boolean that determines if the current connection should be reset.
	 * @return the Flowchart made from connecting {@code source} to {@code yesBranch} or 
	 *     the current connection if it exists and {@code reset} is {@code false}
	 * @throws IllegalArgumentException if {@code source} is not a decision symbol.
	 */
	public Flowchart connectToYesBranch(
			final Flowchart source, 
			final Flowchart yesBranch, 
			final boolean reset);
	/**
	 * Connects a decision symbol to a yes branch.
	 * 
	 * <p>{@code reset} determines if a prior connection should be reset if it
	 * existed before a call to this method. The call is ineffective
	 * if {@code reset} is {@code false} and a connection already exists.
	 * 
	 * <p>The method returns true if the {@code source} to {@code noBranch} connection
	 * already exists regardless of {@code reset}.
	 * 
	 * @param source Flowchart representing a decision symbol.
	 * @param yesBranch Flowchart representing a symbol connected 
	 * 	   to the 'no' path of a decision symbol.
	 * @param reset boolean that determines if the current connection should be reset.
	 * @return the Flowchart made from connecting {@code source} to {@code noBranch} or 
	 *     the current connection if it exists and {@code reset} is {@code false}
	 * @throws IllegalArgumentException if {@code source} is not a decision symbol.
	 */
	public Flowchart connectToNoBranch(
			final Flowchart source, 
			final Flowchart noBranch, 
			final boolean reset);
}
