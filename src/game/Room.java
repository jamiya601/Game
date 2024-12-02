package game;

import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable {
	private boolean lock;
	private String name;
	
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	
	private HashMap<String, Item> items;
	private HashMap<String, NPC> npcs = new HashMap<>();
	
	public Room(String name) {
		this.name = name;
		items = new HashMap<>();
	}
	
	@Override
	public String toString() {
		String description = Game.descriptions.get(name);
		return description;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addExit(char dir, Room r) {
		if(dir == 'e') {
			east = r;
		} else if(dir == 'w') {
			west = r;
		} else if(dir == 'n') {
			north = r;
		} else if(dir == 's') {
			south = r;
		} else if(dir == 'u') {
			up = r;
		} else if(dir == 'd') {
			down = r;
		} 	
	}
	
	public Room getExit(char dir) {
		if(dir == 'e') {
			return east;
		} else if(dir == 'w') {
			return west;
		} else if(dir == 'n') {
			return north;
		} else if(dir == 's') {
			return south;
		} else if(dir == 'u') {
			return up;
		} else if(dir == 'd') {
			return down;
		} else {
			return null;
		}
	}
	
	public Item getItem(String name) {
		return items.get(name);
	}
	
	public void addItem(String name, Item item) {
		items.put(name, item);
	}
	
	public Item removeItem(String name) {
		return items.remove(name);
	}
	
	public boolean getLock() {
		return lock;
	}
	
	public void setLock(boolean l) {
		lock = l;
	}
	
	public void addNPC(String name, NPC npc) {
		npcs.put(name, npc);
	}
	
	public NPC getNPC(String name) {
		return npcs.get(name);
	}
	
	public NPC removeNPC(String name) {
		return npcs.remove(name);
	}
}



	

