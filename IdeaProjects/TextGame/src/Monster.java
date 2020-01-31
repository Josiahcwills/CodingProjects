public class Monster {
    private int monsterID;
    private String monsterName;
    private String monsterDesc;
    private int monsterHP;
    private int monsterAtk;

    public Monster() {
        this.monsterID = monsterID;
        this.monsterName = monsterName;
        this.monsterDesc = monsterDesc;
        this.monsterHP = monsterHP;
        this.monsterAtk = monsterAtk;
    }
    public int getMonsterID() {
        return monsterID;
    }

    public void setMonsterID(int monsterID) {
        this.monsterID = monsterID;
    }
    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getMonsterDesc() {
        return monsterDesc;
    }

    public void setMonsterDesc(String monsterDesc) {
        this.monsterDesc = monsterDesc;
    }

    public int getMonsterHP() {
        return monsterHP;
    }

    public void setMonsterHP(int monsterHP) {
        this.monsterHP = monsterHP;
    }

    public int getMonsterAtk() {
        return monsterAtk;
    }

    public void setMonsterAtk(int monsterAtk) {
        this.monsterAtk = monsterAtk;
    }



    @Override
    public String toString() {
        return "Monster{" +
                "monsterName='" + monsterName + '\'' +
                ", monsterDesc='" + monsterDesc + '\'' +
                ", monsterHP=" + monsterHP +
                ", monsterAtk=" + monsterAtk +
                ", monsterID=" + monsterID +
                '}';
    }
}

