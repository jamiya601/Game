package game;

public class World {
	public static Room buildWorld() {
		Room livingRoom = new Room("You are in the living room.");
		Room bedroom = new Room("You are in the bedroom.");
		Room patio = new Room("You are in the patio.");
		Room kitchen = new Room("You are in the kitchen.");
		Room attic = new Room("You are in the attic");
		
		Item flashDrive = new Item("A flash drive.");
		Item remote = new Item("A remote.");
		Item waterCan = new Item("A water can.");
		Item key = new Item("A key.");
		
		key.setName("key");
		waterCan.setName("water can");
		remote.setName("remote");
		flashDrive.setName("flash drive");
		
		
		livingRoom.addExit('e', bedroom);
		livingRoom.addExit('n', patio);
		livingRoom.addExit('w', kitchen);
		livingRoom.addExit('u', attic);
		bedroom.addExit('w', livingRoom);
		kitchen.addExit('e', livingRoom);
		patio.addExit('s', livingRoom);
		attic.addExit('d', livingRoom);
		
		kitchen.addItem("water can", waterCan);
		bedroom.addItem("remote", remote);
		patio.addItem("flash drive", flashDrive);
		livingRoom.addItem("key", key);
		
		return livingRoom;	
	}
}
