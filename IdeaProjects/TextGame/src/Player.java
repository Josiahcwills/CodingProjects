import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Player {
    private String inspect;
    private ArrayList<Items> playerInventory = new ArrayList<>();
    private Items playerEquip;
    private Items playerUnequip;
    private int playerHP = 50;
    private int playerAtk = 1;
    private int playerDef = 0;

    public Player() {
        this.inspect = inspect;
        this.playerInventory = playerInventory;
        this.playerEquip = playerEquip;
        this.playerEquip = playerUnequip;
        this.playerHP = playerHP;
        this.playerAtk = playerAtk;
        this.playerDef = playerDef;
    }

    public String getInspect() {
        return inspect;
    }

    public void setInspect(String inspect) {
        this.inspect = inspect;
    }

    public int getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(int playerHP) {
        this.playerHP = playerHP;
    }

    public int getPlayerAtk() {
        return playerAtk;
    }

    public void setPlayerAtk(int playerAtk) {
        this.playerAtk = playerAtk;
    }

    public void setPlayerInventory(ArrayList<Items> playerInventory) {
        this.playerInventory = playerInventory;
    }

    public int getPlayerDef() {
        return playerDef;
    }

    public void setPlayerDef(int playerDef) {
        this.playerDef = playerDef;
    }

    public void setPlayerEquip(Items playerEquip) {
        getPlayerInventory().remove(playerEquip);
        if(!Objects.isNull(playerEquip)){

        }
        else{

        }
        this.playerEquip = playerEquip;
    }

    public Items getPlayerEquip(){
        return playerEquip;
    }

    public Items getPlayerUnequip() {
        return playerUnequip;
    }

    public void setPlayerUnequip(Items playerUnequip) {
        getPlayerInventory().add(playerEquip);
        this.playerUnequip = playerUnequip;
    }

    public ArrayList<Items> getPlayerInventory(){
        return playerInventory;
    }

    @Override
    public String toString() {
        return "Player{" +
                "inspect='" + inspect + '\'' +
                ", playerInventory=" + playerInventory +
                ", playerEquip=" + playerEquip +
                ", playerUnequip=" + playerUnequip +
                ", playerHP=" + playerHP +
                ", playerAtk=" + playerAtk +
                ", playerDef=" + playerDef +
                '}';
    }
}
