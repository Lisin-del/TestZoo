package zoo.model;

public class CageImpl implements Cage {
    private int number;
    private double area;
    private Condition condition;
    private boolean isVacantCage;

    public CageImpl(int number, double area, Condition condition, boolean isVacantCage) {
        this.number = number;
        this.area = area;
        this.condition = condition;
        this.isVacantCage = isVacantCage;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public Condition getCondition() {
        return condition;
    }

    @Override
    public boolean isVacantCage() {
        return isVacantCage;
    }

    public void setVacantCage(boolean vacantCage) {
        isVacantCage = vacantCage;
    }

    @Override
    public String toString() {
        return "CageImpl{" +
                "number=" + number +
                ", area=" + area +
                ", condition=" + condition.isAvailableFor() +
                ", isVacantCage=" + isVacantCage +
                '}';
    }
}
