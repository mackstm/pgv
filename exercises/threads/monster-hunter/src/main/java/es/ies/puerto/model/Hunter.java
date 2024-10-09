package es.ies.puerto.model;

public class Hunter extends Thread{
    private String hunterName;
    
    public Hunter() {}

    public Hunter(String name) {
        this.hunterName = name;
    }

    public String getHunterName() {
        return hunterName;
    }

    public void setHunterName(String name) {
        this.hunterName = name;
    }

    @Override
    public String toString() {
        return "Hunter [name=" + hunterName + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hunterName == null) ? 0 : hunterName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Hunter other = (Hunter) obj;
        if (hunterName == null) {
            if (other.hunterName != null)
                return false;
        } else if (!hunterName.equals(other.hunterName))
            return false;
        return true;
    }

    
}
