import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private String RoomDesc;
    private int up, down, right, left;
    private int RoomID;
    private Boolean RoomVisited;
  //  private HashMap<String,Items> roomInventory;
  //  private HashMap<String,Puzzle> roomPuzzle;

    public Room() {
        this.RoomDesc = RoomDesc;
        this.up = -1;
        this.down = -1;
        this.right = -1;
        this.left = -1;
        this.RoomID = RoomID;
        this.RoomVisited = RoomVisited;
     //   this.roomInventory = roomInventory;
     //   this.roomPuzzle = roomPuzzle;
    }

    public String getRoomDesc() {
        return RoomDesc;
    }

    public int getUp() {
        return this.up;
    }

    public int getDown() {
        return this.down;
    }

    public int getRight() {
        return this.right;
    }

    public int getLeft() {
        return this.left;
    }

    public int getRoomID() {
        return RoomID;
    }

    public Boolean getRoomVisited() {
        return RoomVisited;
    }

    public void setRoomDesc(String roomDesc) {
        RoomDesc = roomDesc;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public void setRoomVisited(Boolean roomVisited) {
        RoomVisited = roomVisited;
    }

/*
    public HashMap<String, Items> getRoomInventory(){
        return roomInventory;
    }

    protected void addItem(String itemName, Items item){
        roomInventory.put(itemName, item);
    }

    public HashMap <String, Puzzle> getRoomPuzzle() {
        return roomPuzzle;
    }
    protected void addPuzzle(String PuzzleQ, Puzzle puzzle){
        roomPuzzle.put(PuzzleQ, puzzle);
    }

*/
    @Override
    public String toString() {
        return "Room{" +
                "RoomDesc='" + RoomDesc + '\'' +
                ", up=" + up +
                ", down=" + down +
                ", right=" + right +
                ", left=" + left +
                ", RoomID=" + RoomID +
                ", RoomVisited=" + RoomVisited +
                '}';
    }
}
