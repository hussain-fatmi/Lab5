package model.players;

import java.util.ArrayList;
import java.util.Iterator;

class PlayerCollectionIterator implements Iterator<GamePlayer>{

	/**
	 * An ArrayList of GamePlayers in the game
	 */
	private ArrayList<GamePlayer> Collection = new ArrayList<GamePlayer>();
	
	/**
	 * The index in the Collection we are currently at
	 */
    private int currentIndex = 0;
	
	public PlayerCollectionIterator(ArrayList<GamePlayer> Collection) {
		this.Collection = Collection;
	}

	/**
     * Checks if there is a next GamePlayer in the collection
     * @return true if there is a next GamePlayer, false otherwise
     */
    @Override
    public boolean hasNext() {
        return currentIndex < Collection.size() && Collection.get(currentIndex) != null;
    }
    
    /**
     * Gets the next GamePlayer in the collection
     * @return the next GamePlayer
     */
    @Override
    public GamePlayer next() {
        return Collection.get(currentIndex++);
    }
    
    /**
     * Removes the current GamePlayer from the collection
     */
    @Override
    public void remove() {
        Collection.remove(currentIndex);
    }
}
