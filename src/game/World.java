package game;

public class World {
	public static Room buildWorld() {
		Room livingRoom = new Room("You are in the living room, a place to lounge around and watch television.");
		Room bedroom = new Room("You are in the bedroom, a place to get some rest.");
		Room patio = new Room("You are in the patio, An area to relax and unwind.");
		Room kitchen = new Room("You are in the kitchen, a place to cook.");
		Room attic = new Room("You are in the attic, some stuff are unknown up here.");
		
		Item flashDrive = new Item("A flash drive.");
		Item remote = new Item("A remote.");
		Item waterCan = new Item("A water can.");
		Item key = new Item("A key.");
		Item broom = new Item("A broom");
		Combination combination = new Combination();
		Safe safe = new Safe();
		Puppy puppy = new Puppy("puppy", "An adorable puppy!");
		Cat cat = new Cat("cat", "Mr. Whiskers!");
		
		key.setName("key");
		waterCan.setName("watercan");
		remote.setName("remote");
		flashDrive.setName("flashdrive");
		broom.setName("broom");
		combination.setName("combination");
		safe.setName("safe");
		
		livingRoom.addExit('e', bedroom);
		livingRoom.addExit('n', patio);
		livingRoom.addExit('w', kitchen);
		livingRoom.addExit('u', attic);
		bedroom.addExit('w', livingRoom);
		kitchen.addExit('e', livingRoom);
		patio.addExit('s', livingRoom);
		attic.addExit('d', livingRoom);
		
		kitchen.addItem("water can", waterCan);
		kitchen.addItem("broom", broom);
		bedroom.addItem("remote", remote);
		bedroom.addItem("safe" , safe);
		attic.addItem("combination", combination);
		patio.addItem("flash drive", flashDrive);
		patio.addItem("key", key);
		
		livingRoom.addNPC("puppy", puppy);
		bedroom.addNPC("cat", cat);
		
		return livingRoom;	
	}
}
