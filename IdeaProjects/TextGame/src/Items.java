
public class Items {
    private String itemName;
    private String itemDesc;
    private int itemAtk;
    private int itemHeal;
    private int itemDef;

    public Items(){
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemAtk = itemAtk;
        this.itemHeal = itemHeal;
        this.itemDef = itemDef;

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public int getItemAtk() {
        return itemAtk;
    }

    public void setItemAtk(int itemAtk) {
        this.itemAtk = itemAtk;
    }

    public int getItemHeal() {
        return itemHeal;
    }

    public void setItemHeal(int itemHeal) {
        this.itemHeal = itemHeal;
    }

    public int getItemDef() {
        return itemDef;
    }

    public void setItemDef(int itemDef) {
        this.itemDef = itemDef;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemName='" + itemName + '\'' +
                ", itemDesc='" + itemDesc + '\'' +
                ", itemAtk=" + itemAtk +
                ", itemHeal=" + itemHeal +
                ", itemDef=" + itemDef +
                '}';
    }
}
