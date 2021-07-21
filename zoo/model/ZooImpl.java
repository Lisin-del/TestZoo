package zoo.model;

import zoo.InhibitionLog;
import zoo.Zoo;

import java.util.ArrayList;
import java.util.List;

public class ZooImpl implements Zoo {
    protected Animal animalLeon;
    protected List<InhibitionLog> history = new ArrayList<>();
    protected List<Animal> animals = new ArrayList<>();

    private Condition conditionForCageOne = new ConditionImpl(Species.LEON);
    private Condition conditionForCageTwo = new ConditionImpl(Species.GIRAFFE);
    private Condition conditionForCageThree = new ConditionImpl(Species.SQUIRREL);
    private Condition conditionForCageFour = new ConditionImpl(Species.PENGUIN);

    protected CageImpl cageOne = new CageImpl(1, 12.0, conditionForCageOne, true);
    protected CageImpl cageTwo = new CageImpl(2, 150.0, conditionForCageTwo, true);
    protected CageImpl cageThree = new CageImpl(3, 10.0, conditionForCageThree, true);
    protected CageImpl cageFour = new CageImpl(4, 100.0, conditionForCageFour, true);


    @Override
    public void checkInAnimal(Animal animal) {

    }

    @Override
    public void checkOutAnimal(Animal animal) {

    }

    @Override
    public List<InhibitionLog> getHistory() {
        return null;
    }

}
