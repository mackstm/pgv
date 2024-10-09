package es.ies.puerto.model;

import java.util.Objects;

public class Monster extends Thread{
    private String monsterName;

    public Monster() {}

    public Monster(String name) {
        this.monsterName = name;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    @Override
    public String toString() {
        return "Monster [monsterName=" + monsterName + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(monsterName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Monster other = (Monster) obj;
        return Objects.equals(monsterName, other.monsterName);
    }

    
}
