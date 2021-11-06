package model.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.lang.Iterable;;

public class PlayerCollection implements Iterable<GamePlayer>{
	
	private ArrayList<GamePlayer> Collection = new ArrayList<GamePlayer>();
	
	public void add(GamePlayer player) {
		this.Collection.add(player);
		this.sort();
	}
	
	public void sort() {
		Collections.sort(Collection);
	}
	
	public GamePlayer get(String name) {
		for(GamePlayer player : Collection) {
			if(player.playerName.equalsIgnoreCase(name)) {
				return player;
			}
		}
		return null;
	}

	@Override
	public Iterator<GamePlayer> iterator() {
		Iterator<GamePlayer> it = new Iterator<GamePlayer>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < Collection.size() && Collection.get(currentIndex) != null;
            }

            @Override
            public GamePlayer next() {
                return Collection.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
	}
}
