package model.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.lang.Iterable;;

/**
 * An iterable Collection of GamePlayers
 *
 */
public class PlayerCollection implements Iterable<GamePlayer>{
	
	/**
	 * An ArrayList of GamePlayers in the game
	 */
	private ArrayList<GamePlayer> Collection = new ArrayList<GamePlayer>();
	
	/**
	 * Adds a GamePlayer to the Collection
	 * @param player - the player to add to the collection
	 */
	public void add(GamePlayer player) {
		this.Collection.add(player);
		this.sort();
	}
	
	/**
	 * Removes a GamePlayer from the collection
	 * @param player - the player to remove from the collection
	 */
	public void remove(GamePlayer player) {
		Collection.remove(player);
	}
	
	/**
	 * Sorts the Collection of GamePlayers
	 */
	public void sort() {
		Collections.sort(Collection);
	}
	
	/**
	 * Returns the GamePlayer in the Collection with the specified name
	 * @param name - the name of the player to get
	 * @return the GamePlayer with the name (if it exists), otherwise null
	 */
	public GamePlayer get(String name) {
		for(GamePlayer player : Collection) {
			if(player.playerName.equalsIgnoreCase(name)) {
				return player;
			}
		}
		return null;
	}

	/**
	 * An iterator over the Collection of GamePlayers
	 */
	@Override
	public Iterator<GamePlayer> iterator() {
		Iterator<GamePlayer> it = new PlayerCollectionIterator(this.Collection);
		return it;
	}
}
