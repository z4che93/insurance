package src;

public class ContractualConditions {
    private int entryAge, duration;

    public ContractualConditions(int entryAge, int duration) {
        this.entryAge = entryAge;
        this.duration = duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getEntryAge() {
        return entryAge;
    }
    public int getDuration() {
        return duration;
    }
}