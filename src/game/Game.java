package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Game {
	
	public static List<Item> inventory = new ArrayList<>();
	public static Room currentRoom;
	public static HashMap<String, String> descriptions = new HashMap<String, String>();
	public static HashMap<String, Room> roomObjects = new HashMap<String, Room>();
	public static Scanner scan = new Scanner(System.in);
	

	public static void main(String[] args) {
		Game game = new Game();
		game.loadDescriptions("Descriptions.txt");
		
		for(String room : game.descriptions.keySet()) {
			System.out.println(room + ": " + game.descriptions.get(room));
		}
		runGame();
	}
	
	public void loadDescriptions(String file) {
		try {
			Scanner input = new Scanner(new File(file));
			while(input.hasNextLine()) {
				Thread.sleep(1000);
				String line = input.nextLine();
				System.out.println(line);
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (InterruptedException ex) {
			System.out.println("File interrupted!");
		}
	}
	
	public static void saveGame(String fileName) {
		File f = new File(fileName);
		try { 
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream stream = new ObjectOutputStream(fos); 
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(roomObjects);
			stream.close();
			System.out.println("Game saved to " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File: " + fileName + " not found");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
	
	public static void loadGame(String fileName) {
		File f = new File(fileName);
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream stream = new ObjectInputStream(fis);
			currentRoom = (Room) stream.readObject();
			inventory = (List<Item>) stream.readObject();
			roomObjects = (HashMap<String, Room>) stream.readObject();
			stream.close();
			System.out.println("Game successfully loaded: " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File: " + fileName + " not found.");
			System.exit(0);
		} catch (IOException ex) {
			System.out.println("Error");
		} catch (ClassNotFoundException ex) {
			System.out.println("Class not found.");
		}
	}
	
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
	
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static Item getInvItemName(String itemName) { // method returns item that's in player's inventory
		for(Item item : inventory) { // if item in inventory
			if(item.getName().equals(itemName)) { // if name equals the item name
				return item;
			}
		}
		return null;
	}
	
	public static void runGame() { // runs the game
		Room currentRoom = World.buildWorld();
		
		Item key = new Item("A key, to unlock an item.");
		currentRoom.addItem("key", key);
		
		String command;
		do {
			System.out.println(currentRoom);
			System.out.print("Where do you want to go? ");
			command = scan.nextLine();
			String[] words = command.split(" ");
			
			switch(words[0]) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				Room followingRoom = currentRoom.getExit(command.charAt(0));
				
				if(followingRoom.getLock()) { // checks if following room is locked 
					System.out.println("This room is locked."); // prints out the room is locked
				} else {
					currentRoom = followingRoom;
				}
				break;
				
			case "x": // exits game
				System.out.println("Bye!");
				break;
				
			case "save":
				saveGame("saveGame.dat");
				break;
				
			case "load":
				loadGame("saveGame.dat");
				break;
				
			case "use":
				if(words.length == 2) { // "look" and item's name
					String name = words[1]; // item's name 
					Item item = currentRoom.getItem(name); // check if the room have the item
					if(item != null) {
						item.use(); // uses item in current room
					} else {
						System.out.println("There's no item to use.");
					}
				}
				break;
				
			case "open":
				if(words.length == 2) {
					String name = words[1];
					Item item = currentRoom.getItem(name); // if item is in current room
					if (item != null) {
						item.open(); // opens item in current room
					} else {
						System.out.println("There's no item to open.");
					}
				}
				break;
				
			case "take": // takes an item in the room and add it to your inventory and removes it from the room
				if(words.length == 2) { // "take" and item's name
					String name = words[1]; // item's name
					Item item = currentRoom.getItem(name);
					if(item != null) {
					inventory.add(item); // adds item to inventory
					currentRoom.removeItem(name); // removes item from the current room
					System.out.println("A " + name + " have been added to your inventory.");
					} else {
						System.out.println("There's no item here.");
					}
				}
				break;
				
			case "talk":
				if(words.length == 2) {
					String name = words[1];
					NPC npc = currentRoom.getNPC(name);
					if(npc != null) {
						npc.talk();
					} else {
						System.out.println("Name doesn't exist");
					}
				
				} else {
					System.out.println("Who?");
				}
				break;
				
			case "i": // checks if inventory is empty, if not, prints out items in your inventory
				if(command.equals("i")) {
					if(inventory.isEmpty()) {
					System.out.println("There is nothing in your inventory.");
					}
					else {
					System.out.println("Inventory: ");
					for(Item i1 : inventory) {
						System.out.println(i1);
					}
					}
				}
				break;
				
			case "look": // to look at an item in the room
				if(words.length == 2) { // "look" and item's name
					String name = words[1]; // item's name
					Item item = null; // Item is set to null
					item = currentRoom.getItem(name); // check if the room have the item
					if(item == null) { // checks inventory if item not in the room
						for(Item checkInventory : inventory) {
							if(checkInventory.getName().equals(name)) {
								item = checkInventory;
								break;
							}
						}
					}
					if(item != null) { // prints description of item if item is found in the room
						System.out.println("There is: " + item.getDescription());
					} else {
						System.out.println(name + " is not here or in your inventory.");
					}
				}
				break;
				
			default:
				System.out.println("Invalid input");
			}
			
		} while(!command.equals("x"));
		
		scan.close();		
	}
	
}
