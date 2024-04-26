package model;

public class Player {
    private String Name;
    private String Level;

    public void setName(String name) {
        Name= name;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public  String getPlayer(){
        return Name + "," + Level;
    }
}
