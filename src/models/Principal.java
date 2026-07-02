package models;

public class Principal extends Teacher{
    private int experience = 0;

    public Principal(String name, Branch branch, int experience) {
        super(name, branch);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

}
