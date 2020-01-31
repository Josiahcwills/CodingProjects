import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Game {
    ArrayList<Room> roomList = new ArrayList<>();
    ArrayList<Monster> monsterList = new ArrayList<>();
    ArrayList<Items> itemList = new ArrayList<>();
    HashMap<String, Puzzle> puzzleList = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        boolean restart = true;
        while(restart) {
            Game game = new Game();
            game.readRoom();
            game.readItem();
            game.readPuzzle();
            game.readMonster();
            restart = game.playGame();
        }
    }
//reads roomfile
    private void readRoom() throws FileNotFoundException {
        FileReader br = new FileReader("Rooms.txt");
        Scanner scanner = new Scanner(br);
        while (scanner.hasNextLine()) {
            Room room = new Room();
            scanner.useDelimiter("@");
            room.setRoomID(Integer.parseInt(scanner.next()));
            String str = scanner.next() + "\n" + scanner.next() + "\n" + scanner.next();
            room.setRoomDesc(str);
            String str1 = scanner.next();
            if (!str.equals("-1")) {
                room.setUp(Integer.parseInt(str1));
            }
            String str2 = scanner.next();
            if (!str2.equals("-1")) {
                room.setDown(Integer.parseInt(str2));
            }
            String str3 = scanner.next();
            if (!str3.equals("-1")) {
                room.setRight(Integer.parseInt(str3));
            }
            String str4 = scanner.next();
            if (!str4.equals("-1")) {
                room.setLeft(Integer.parseInt(str4));
            }
            room.setRoomVisited(Boolean.parseBoolean(scanner.next()));
            scanner.nextLine();
            roomList.add(room);
        }
        scanner.close();
    }
//readMonsterfile
    private void readMonster() throws FileNotFoundException {
        FileReader br = new FileReader("Monster.txt");
        Scanner scanner = new Scanner(br);
        while (scanner.hasNextLine()) {
            Monster monster = new Monster();
            scanner.useDelimiter("@");
            monster.setMonsterID(Integer.parseInt(scanner.next()));
            String str = scanner.next();
            monster.setMonsterName(str);
            String str1 = scanner.next();
            monster.setMonsterDesc(str1);
            monster.setMonsterHP(Integer.parseInt(scanner.next()));
            monster.setMonsterAtk(Integer.parseInt(scanner.next()));
            monsterList.add(monster);
            scanner.nextLine();
        }
        scanner.close();
    }
//read itemfile
    private void readItem() throws FileNotFoundException {
        FileReader br = new FileReader("Items.txt");
        Scanner scanner = new Scanner(br);
        while (scanner.hasNextLine()) {
            Items items = new Items();
            scanner.useDelimiter("@");
            items.setItemName(scanner.next());
            items.setItemDesc(scanner.next());
            items.setItemAtk(Integer.parseInt(scanner.next()));
            items.setItemHeal(Integer.parseInt(scanner.next()));
            items.setItemDef(Integer.parseInt(scanner.next()));
            itemList.add(items);
            scanner.nextLine();
        }
        scanner.close();
    }

    private void readPuzzle() throws FileNotFoundException {
        FileReader br = new FileReader("Puzzle.txt");
        Scanner scanner = new Scanner(br);
        while (scanner.hasNextLine()) {
            Puzzle puzzle = new Puzzle();
            scanner.useDelimiter("@");
            puzzle.setPuzzleQ(scanner.next());
            puzzle.setPuzzleA(scanner.next());
            puzzleList.put(puzzle.getPuzzleA(), puzzle);
            scanner.nextLine();
        }
        scanner.close();
    }

//playGame
    private boolean playGame(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean gameOn = true;
        Player player = new Player();
        int curRoom = roomList.get(0).getRoomID();
        int curHP = player.getPlayerHP();
        int curAtk = player.getPlayerAtk();
        int curDef = player.getPlayerDef();
        int curMHP = monsterList.get(0).getMonsterHP();
        int curMAtk = monsterList.get(0).getMonsterAtk();
        boolean visited;
        System.out.println("For instructions remember to use the HELP command");
        System.out.println(roomList.get(0).getRoomDesc());
        System.out.println("Not visited");
        roomList.get(0).setRoomVisited(true);
        do {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("North")) {
                if (roomList.get(curRoom).getUp() != -1) {
                    curRoom = roomList.get(curRoom).getUp() - 1;
                    System.out.println(roomList.get(curRoom).getRoomDesc());
                    visited = roomList.get(curRoom).getRoomVisited();
                    if (!visited) {
                        System.out.println("Not visited");
                        roomList.get(curRoom).setRoomVisited(true);
                    } else {
                        System.out.println("Visited");
                    }
                } else {
                    System.out.println("There is no room in this direction.");
                }
            }
            if (input.equalsIgnoreCase("South")) {
                if (roomList.get(curRoom).getDown() != -1) {
                    curRoom = roomList.get(curRoom).getDown() - 1;
                    System.out.println(roomList.get(curRoom).getRoomDesc());
                    visited = roomList.get(curRoom).getRoomVisited();
                    if (!visited) {
                        System.out.println("Not visited");
                        roomList.get(curRoom).setRoomVisited(true);
                    } else {
                        System.out.println("Visited");
                    }
                } else {
                    System.out.println("There is no room in this direction.");
                }
            }
            if (input.equalsIgnoreCase("East")) {
                if (roomList.get(curRoom).getRight() != -1) {
                    curRoom = roomList.get(curRoom).getRight() - 1;
                    System.out.println(roomList.get(curRoom).getRoomDesc());
                    visited = roomList.get(curRoom).getRoomVisited();
                    if (!visited) {
                        System.out.println("Not visited");
                        roomList.get(curRoom).setRoomVisited(true);
                    } else {
                        System.out.println("Visited");
                    }
                } else {
                    System.out.println("There is no room in this direction.");
                }
            }
            if (input.equalsIgnoreCase("West")) {
                if (roomList.get(curRoom).getLeft() != -1) {
                    curRoom = roomList.get(curRoom).getLeft() - 1;
                    System.out.println(roomList.get(curRoom).getRoomDesc());
                    visited = roomList.get(curRoom).getRoomVisited();
                    if (!visited) {
                        System.out.println("Not visited");
                        roomList.get(curRoom).setRoomVisited(true);
                    } else {
                        System.out.println("Visited");
                    }
                } else {
                    System.out.println("There is no room in this direction.");
                }
            }
            if (input.equalsIgnoreCase("Solve")) {
                if (puzzleList == null) {
                    System.out.println("This puzzle no longer exits");
                } else if (curRoom == 5) {
                    System.out.println(puzzleList.get("Human").getPuzzleQ());
                    int i = 0;
                    while (i < 3) {
                        String input1 = scanner.nextLine();
                        if (input1.equalsIgnoreCase(puzzleList.get("Human").getPuzzleA())) {
                            System.out.println("Puzzle solved!");
                            puzzleList = null;
                            break;
                        } else if (!input1.equalsIgnoreCase(puzzleList.get("Human").getPuzzleA())) {
                            System.out.println("Wrong answer");
                            if (i == 2) {
                                System.out.println("You've failed the test");
                                puzzleList = null;
                            }
                        }
                        i++;
                    }

                }
            }
            //Looks around
            if (input.equalsIgnoreCase("Look")) {
                if (curRoom == 0) {
                    if (player.getPlayerInventory().contains(itemList.get(0))) {
                        System.out.println("There is no item");
                    } else {
                        System.out.println("There is a " + itemList.get(0).getItemName() + " on the ground.");
                    }
                } else if (curRoom == 1) {
                    if (player.getPlayerInventory().contains(itemList.get(1))) {
                        System.out.println("There is no item here");
                    } else {
                        System.out.println("There is a " + itemList.get(1).getItemName() + " on the ground.");
                    }
                } else if (curRoom == 2) {
                    if (player.getPlayerInventory().contains(itemList.get(2))) {
                        System.out.println("There is no item here");
                    } else {
                        System.out.println("There is a " + itemList.get(2).getItemName() + " on the ground.");
                    }
                } else if (curRoom == 4) {
                    if (monsterList == null) {
                        System.out.println("The monster has been slain. What a fierce beast it was...");
                    } else {
                        System.out.println("Looks like a " + monsterList.get(0).getMonsterDesc() + " is drawing near");
                    }
                } else if (curRoom == 5) {
                    if (puzzleList == null) {
                        System.out.println("The puzzle no longer exists");
                    } else {
                        System.out.println("Looks like a puzzle is here: " + puzzleList.get("Human").getPuzzleQ());
                    }
                } else {
                    System.out.println("There is nothing here");
                }
            }
            //pickup
            if (input.equalsIgnoreCase("Pickup")) {
                if (curRoom == 0) {
                    if (player.getPlayerInventory().contains(itemList.get(0))) {
                        System.out.println("There is no item here");
                    } else {
                        System.out.println("There is a " + itemList.get(0).getItemName() + " on the ground.");
                        System.out.println("You picked an item");
                        player.getPlayerInventory().add(itemList.get(0));
                        for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                            System.out.println(player.getPlayerInventory().get(i));
                        }
                    }
                } else if (curRoom == 1) {
                    if (player.getPlayerInventory().contains(itemList.get(1))) {
                        System.out.println("There is no item here");
                    } else {
                        System.out.println("There is a " + itemList.get(1).getItemName() + " on the ground.");
                        System.out.println("You picked up the item");
                        player.getPlayerInventory().add(itemList.get(1));
                        for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                            System.out.println(player.getPlayerInventory().get(i));
                        }
                    }

                } else if (curRoom == 2) {
                    if (player.getPlayerInventory().contains(itemList.get(2))) {
                        System.out.println("There is no item here");
                    } else {
                        System.out.println("There is a " + itemList.get(2).getItemName() + " on the ground.");
                        System.out.println("You picked up the item");
                        player.getPlayerInventory().add(itemList.get(2));
                        for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                            System.out.println(player.getPlayerInventory().get(i));
                        }
                    }
                } else {
                    System.out.println("There is nothing here");
                }
            }
            if (input.equalsIgnoreCase("bag")) {
                for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                    System.out.println(player.getPlayerInventory().get(i));
                }
            }
            if (input.equalsIgnoreCase("Equip")) {
                for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                    System.out.println(player.getPlayerInventory().get(i));
                }
                System.out.println("What would you like to Equip?");
                String input2 = scanner.nextLine();
                if (input2.equalsIgnoreCase("shield")) {
                    if (player.getPlayerInventory().contains(itemList.get(1))) {
                        curDef = player.getPlayerDef() + itemList.get(1).getItemDef();
                        System.out.println(itemList.get(1).getItemName() + " has been equipped!");
                        System.out.println("Def: " + curDef);
                    } else if(!player.getPlayerInventory().contains(itemList.get(1))) {
                        System.out.println("You are not carrying this item");
                    }
                }if (input2.equalsIgnoreCase("sword")) {
                    if (player.getPlayerInventory().contains(itemList.get(0))) {
                        curAtk = player.getPlayerAtk() + itemList.get(0).getItemAtk();
                        System.out.println(itemList.get(0).getItemName() + " has been equipped!");
                        System.out.println("Atk: " + curAtk);
                    } else if (!player.getPlayerInventory().contains(itemList.get(0))) {
                        System.out.println("You are not carrying this item");
                    }
                }
            }
            if (input.equalsIgnoreCase("Unequip")) {
                for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                    System.out.println(player.getPlayerInventory().get(i));
                }
                System.out.println("What would you like to unequip?");
                String input2 = scanner.nextLine();
                if (input2.equalsIgnoreCase("shield")) {
                    if (curDef == 0) {
                        System.out.println("You do not have anything equipped");
                    } else {
                        curDef = curDef - player.getPlayerInventory().get(1).getItemDef();
                        System.out.println(itemList.get(1).getItemName() + " has been unequipped!");
                        System.out.println("Def: " + curDef);
                    }
                } else {
                    System.out.println("This item cannot be equipped");
                }
                if (input2.equalsIgnoreCase("sword")) {
                    if (curAtk == 1) {
                        System.out.println("You do not have anything equipped");
                    } else {
                        curAtk = curAtk - player.getPlayerInventory().get(0).getItemAtk();
                        System.out.println(itemList.get(0).getItemName() + " has been unequipped!");
                        System.out.println("Atk: " + curAtk);
                    }
                } else {
                    System.out.println("This item is not equippable");
                }
            }
            if (input.equalsIgnoreCase("Heal")) {
                for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                    System.out.println(player.getPlayerInventory().get(i));
                }
                System.out.println("Please pick an item to heal with");
                String input2 = scanner.nextLine();
                if (input2.equalsIgnoreCase("potion")) {
                    if (player.getPlayerInventory().contains(itemList.get(2))) {
                        curHP = curHP + itemList.get(2).getItemHeal();
                        System.out.println("Hero's: " + curHP);
                    } else if (!player.getPlayerInventory().contains(itemList.get(2))) {
                        System.out.println("This item is not in inventory");
                    }

                } else {
                    System.out.println("You cannot heal with this item");
                }
            }

            if (input.equalsIgnoreCase("Drop")) {
                System.out.println("What would you like to drop?");
                for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                    System.out.println(player.getPlayerInventory().get(i));
                }
                String input2 = scanner.nextLine();
                if (input2.equalsIgnoreCase("Sword")) {
                    if (player.getPlayerInventory().contains(itemList.get(0))) {
                        player.getPlayerInventory().remove(itemList.get(0));
                        System.out.println(itemList.get(0).getItemName() + " has been dropped");
                        for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                            System.out.println(player.getPlayerInventory().get(i));
                        }
                    } else {
                        System.out.println("You do not have this item");
                    }
                }
                if (input2.equalsIgnoreCase("shield")) {
                    if (player.getPlayerInventory().contains(itemList.get(1))) {
                        player.getPlayerInventory().remove(itemList.get(1));
                        System.out.println(itemList.get(1).getItemName() + " has been dropped");
                        for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                            System.out.println(player.getPlayerInventory().get(i));
                        }
                    } else {
                        System.out.println("You do not have this item");
                    }
                }
                if (input2.equalsIgnoreCase("potion")) {
                    if (player.getPlayerInventory().contains(itemList.get(2))) {
                        player.getPlayerInventory().remove(itemList.get(2));
                        System.out.println(itemList.get(2).getItemName() + " has been dropped");
                        for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                            System.out.println(player.getPlayerInventory().get(i));
                        }
                    } else {
                        System.out.println("You do not have this item");
                    }
                }
            }
            if (input.equalsIgnoreCase("Fight")) {
                if (monsterList == null) {
                    System.out.println("The monster has been slain. What a fierce beast it was...");
                } else if (curRoom == monsterList.get(0).getMonsterID()) {
                    System.out.println("Hero's stats:   | " + monsterList.get(0).getMonsterName() + " stats:");
                    System.out.println("HP:  " + curHP + "         | HP: " + curMHP);
                    System.out.println("Atk: " + curAtk + "          | Atk: " + curMAtk);
                    System.out.println("Def: " + curDef + "          |");
                    System.out.println("The " + monsterList.get(0).getMonsterName() + " stares at you hungrily. What would you like to do?");
                    System.out.println("-----------------------------------------");
                    System.out.println("|ATTACK| |HEAL| |BAG| |EQUIP| |UNEQUIP|");
                    while (gameOn) {
                        int randomInteger = random.nextInt(10);
                        String input1 = scanner.nextLine();
                        if (input1.equalsIgnoreCase("Attack")) {
                            if (randomInteger > 5) {
                                curHP = curHP - ((curMAtk * 2) - curDef);
                                curMHP = curMHP - curAtk;
                                System.out.println("The " + monsterList.get(0).getMonsterName() + " unleashes a terrible roar and fires flaming breath at you. It's a critical hit! The "+ monsterList.get(0).getMonsterName() + " inflicts " + ((curMAtk*2) - curDef) + " damage");
                                System.out.println("Your attack inflicts " + curAtk + " damage");
                                System.out.println("Hero's stats:   | " + monsterList.get(0).getMonsterName() + " stats:");
                                System.out.println("HP:  " + curHP + "         | HP: " + curMHP);
                                System.out.println("Atk: " + curAtk + "          | Atk: " + curMAtk);
                                System.out.println("Def: " + curDef + "          |");
                                System.out.println("-----------------------------------------");
                                System.out.println("|ATTACK| |HEAL| |BAG| |EQUIP| |UNEQUIP|");
                                if (curMHP <= 0) {
                                    System.out.println("The Hero has won! " + "\n" + "Hero's HP: " + curHP);
                                    monsterList = null;
                                    break;
                                } else if (curHP <= 0) {
                                    System.out.println("The Hero has died " + "\n" + "GAME OVER");
                                    System.out.println("If you are having trouble defeating the " + monsterList.get(0).getMonsterName() + " you might want to look for protective gear" + "\n" + "and healing items!");
                                    System.out.println("Would you like to try again? Type Yes to continue or NO to quit");
                                    String reply = scanner.nextLine();
                                    if (reply.equalsIgnoreCase("Yes")) {
                                        return true;
                                    }
                                    if(reply.equalsIgnoreCase("No")){
                                        gameOn = false;
                                    }
                                }
                            } else {
                                curHP = curHP - (curMAtk - curDef);
                                curMHP = curMHP - curAtk;
                                System.out.println("The " + monsterList.get(0).getMonsterName() + " lunges forward and attacks with it's sharp claws. The " + monsterList.get(0).getMonsterName() + " inflicts " + (curMAtk - curDef) + " damage");
                                System.out.println("Your attack inflicts " + curAtk + " damage");
                                System.out.println("Hero's stats:   | " + monsterList.get(0).getMonsterName() + " stats:");
                                System.out.println("HP:  " + curHP + "         | HP: " + curMHP);
                                System.out.println("Atk: " + curAtk + "          | Def: " + curMAtk);
                                System.out.println("Def: " + curDef + "          |");
                                System.out.println("-----------------------------------------");
                                System.out.println("|ATTACK| |HEAL| |BAG| |EQUIP| |UNEQUIP|");
                                if (curMHP <= 0) {
                                    System.out.println("The Hero has won! " + "\n" + "Hero's remaining HP: " + curHP);
                                    monsterList = null;
                                    break;
                                } else if (curHP <= 0) {
                                    System.out.println("The Hero has died " + "\n" + "GAME OVER");
                                    //gameOn = false;
                                    System.out.println("If you are having trouble defeating the " + monsterList.get(0).getMonsterName() + " you might want to look for protective gear" + "\n" + "and healing items!");
                                    System.out.println("Would you like to try again? Type Yes to continue or NO to quit");
                                    String reply = scanner.nextLine();
                                    if (reply.equalsIgnoreCase("Yes")) {
                                        return true;
                                    }
                                    if(reply.equalsIgnoreCase("No")){
                                        gameOn = false;
                                    }
                                }
                            }
                        }
                        if(input1.equalsIgnoreCase("Heal")){
                            for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                                System.out.println(player.getPlayerInventory().get(i));
                            }
                            System.out.println("Please pick an item to heal with");
                            String input2 = scanner.nextLine();
                            if (input2.equalsIgnoreCase("potion")) {
                                if (player.getPlayerInventory().contains(itemList.get(2))) {
                                    if (randomInteger > 5) {
                                        curHP = curHP - ((curMAtk * 2)- curDef);
                                        curHP = curHP + itemList.get(2).getItemHeal();
                                        curMHP = curMHP;
                                        System.out.println("The " + monsterList.get(0).getMonsterName() + " unleashes a terrible roar and fires flaming breath at you. It's a critical hit! The " + monsterList.get(0).getMonsterName() + " inflicts " + ((curMAtk*2) - curDef) + " damage");
                                        System.out.println("You recover " + itemList.get(2).getItemHeal() + " HP");
                                        System.out.println("Hero's stats:   | " + monsterList.get(0).getMonsterName() + " stats:");
                                        System.out.println("HP:  " + curHP + "         | HP: " + curMHP);
                                        System.out.println("Atk: " + curAtk + "          | Def: " + curMAtk);
                                        System.out.println("Def: " + curDef + "          |");
                                        System.out.println("-----------------------------------------");
                                        System.out.println("|ATTACK| |HEAL| |BAG| |EQUIP| |UNEQUIP|");
                                        if (curHP <= 0) {
                                            System.out.println("The Hero has died " + "\n" + "GAME OVER");
                                            System.out.println("If you are having trouble defeating the " + monsterList.get(0).getMonsterName() + " you might want to look for protective gear!");
                                            System.out.println("Would you like to try again? Type Yes to continue or NO to quit");
                                            String reply = scanner.nextLine();
                                            if (reply.equalsIgnoreCase("Yes")) {
                                                return true;
                                            }
                                            if(reply.equalsIgnoreCase("No")){
                                                gameOn = false;
                                            }
                                        }
                                    } else if (randomInteger <= 5) {
                                        curHP = curHP - (curMAtk - curDef);
                                        curHP = curHP + itemList.get(2).getItemHeal();
                                        curMHP = curMHP;
                                        System.out.println("The " + monsterList.get(0).getMonsterName() + " lunges forward and attacks with it's sharp claws. The " + monsterList.get(0).getMonsterName() + " inflicts " + (curMAtk - curDef) + " damage");
                                        System.out.println("You recover " + itemList.get(2).getItemHeal() + " HP!");
                                        System.out.println("Hero's stats:   | " + monsterList.get(0).getMonsterName() + " stats:");
                                        System.out.println("HP:  " + curHP + "         | HP: " + curMHP);
                                        System.out.println("Atk: " + curAtk + "          | Def: " + curMAtk);
                                        System.out.println("Def: " + curDef + "          |");
                                        System.out.println("-----------------------------------------");
                                        System.out.println("|ATTACK| |HEAL| |BAG| |EQUIP| |UNEQUIP|");
                                        if (curHP <= 0) {
                                            System.out.println("The Hero has died " + "\n" + "GAME OVER");
                                            System.out.println("If you are having trouble defeating the " + monsterList.get(0).getMonsterName() + " you might want to look for protective gear!");
                                            System.out.println("Would you like to try again? Type Yes to continue or NO to quit");
                                            String reply = scanner.nextLine();
                                            if (reply.equalsIgnoreCase("Yes")) {
                                                return true;
                                            }
                                            if(reply.equalsIgnoreCase("No")){
                                                gameOn = false;
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("You cannot heal. The " + itemList.get(2).getItemName() + " is not in your inventory");
                                }
                            }else{
                                System.out.println("You cannot heal with this item");
                            }
                            }
                             else if (input1.equalsIgnoreCase("bag")) {
                            for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                                System.out.println(player.getPlayerInventory().get(i));
                            }
                        } else if (input1.equalsIgnoreCase("Equip")) {
                            for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                                System.out.println(player.getPlayerInventory().get(i));
                            }
                            System.out.println("What would you like to Equip?");
                            String input2 = scanner.nextLine();
                              if (input2.equalsIgnoreCase("shield")) {
                                if (player.getPlayerInventory().contains(itemList.get(1))) {
                                    curDef = player.getPlayerDef() + itemList.get(1).getItemDef();
                                    System.out.println(itemList.get(1).getItemName() + " has been equipped!");
                                    System.out.println("Def: " + curDef);
                                } else {
                                    System.out.println("You are not carrying this item");
                                }
                            }
                            if (input2.equalsIgnoreCase("sword")) {
                                if (player.getPlayerInventory().contains(itemList.get(0))) {
                                    curAtk = player.getPlayerAtk() + itemList.get(0).getItemAtk();
                                    System.out.println(itemList.get(0).getItemName() + " has been equipped!");
                                    System.out.println("Atk: " + curAtk);
                                } else {
                                    System.out.println("You are not carrying this item");
                                }
                            }
                        }
                        else if (input1.equalsIgnoreCase("Unequip")) {
                            for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                                System.out.println(player.getPlayerInventory().get(i));
                            }
                            System.out.println("What would you like to unequip?");
                            String input2 = scanner.nextLine();
                            if (input2.equalsIgnoreCase("shield")) {
                                if (curDef == 0) {
                                    System.out.println("You do not have anything equipped");
                                } else {
                                    curDef = curDef - player.getPlayerInventory().get(1).getItemDef();
                                    System.out.println(itemList.get(1).getItemName() + " has been unequipped!");
                                    System.out.println("Def: " + curDef);
                                }
                            }
                            if (input2.equalsIgnoreCase("sword")) {
                                if (curAtk == 1) {
                                    System.out.println("You do not have anything equipped");
                                } else {
                                    curAtk = curAtk - player.getPlayerInventory().get(0).getItemAtk();
                                    System.out.println(itemList.get(0).getItemName() + " has been unequipped!");
                                    System.out.println("Atk: " + curAtk);
                                }
                            }
                        }

                    }
                } else {
                    System.out.println("There are no monsters here...");
                }
            }
            if (input.equalsIgnoreCase("Help")) {
                System.out.println("Navigation = North, South, West, East " + "\n" + "Search Room = Look " + "\n" + "Picking up an item = Pickup" + "\n" + "Open inventory = bag" + "\n" + "Equip item = Equip" + "\n" + "Un-equip item = Unequip" + "\n" + "Use Healing item = Heal" + "\n" + "Drop an item = Drop" + "\n" + "to solve a puzzle = Solve" + "\n" + "To fight a monster = Fight" + "\n" + "End Game = Quit" + "\n" + "When choosing items remember to choose by item name!");
            }

            if (input.equalsIgnoreCase("quit")) {
                gameOn = false;
            }

        } while (gameOn);
        return false;
    }
}

