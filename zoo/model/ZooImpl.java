package zoo.model;

import zoo.InhibitionLog;
import zoo.Zoo;

import java.util.*;

public class ZooImpl implements Zoo {
    private InhibitionLog logLeon;
    private InhibitionLog logGiraffe;
    private InhibitionLog logSquirrel;
    private InhibitionLog logPenguin;

    protected List<InhibitionLog> history = new ArrayList<>();
    protected HashMap<String, CageImpl> animalsInZoo = new HashMap<>();

    private Condition conditionForCageOne = new ConditionImpl(Species.LEON);
    private Condition conditionForCageTwo = new ConditionImpl(Species.GIRAFFE);
    private Condition conditionForCageThree = new ConditionImpl(Species.SQUIRREL);
    private Condition conditionForCageFour = new ConditionImpl(Species.PENGUIN);

    private CageImpl cageOne = new CageImpl(1, 12.0, conditionForCageOne, true);
    private CageImpl cageTwo = new CageImpl(2, 150.0, conditionForCageTwo, true);
    private CageImpl cageThree = new CageImpl(3, 10.0, conditionForCageThree, true);
    private CageImpl cageFour = new CageImpl(4, 100.0, conditionForCageFour, true);


    @Override
    public void checkInAnimal(Animal animal) {
        if(animal.getSpecies() == Species.LEON && cageOne.isVacantCage()) {
            cageOne.setVacantCage(false);
            logLeon = new InhibitionLog(new Date(), null, animal.getSpecies(), animal.getName());
            history.add(logLeon);
            animalsInZoo.put(animal.getName(), cageOne);

            System.out.printf("Your animal %s is added to the zoo \n", animal.toString());
        }
        else if(animal.getSpecies() == Species.LEON && !cageOne.isVacantCage()) {
            System.out.println("The zoo cannot accept your animal");
        }

        if(animal.getSpecies() == Species.GIRAFFE && cageTwo.isVacantCage()) {
            cageTwo.setVacantCage(false);
            logGiraffe = new InhibitionLog(new Date(), null, animal.getSpecies(), animal.getName());
            history.add(logGiraffe);
            animalsInZoo.put(animal.getName(), cageTwo);
            System.out.printf("Your animal %s is added to the zoo \n", animal.toString());
        }
        else if(animal.getSpecies() == Species.GIRAFFE && !cageTwo.isVacantCage()) {
            System.out.println("The zoo cannot accept your animal");
        }

        if(animal.getSpecies() == Species.SQUIRREL && cageThree.isVacantCage()) {
            cageThree.setVacantCage(false);
            logSquirrel = new InhibitionLog(new Date(), null, animal.getSpecies(), animal.getName());
            history.add(logSquirrel);
            animalsInZoo.put(animal.getName(), cageThree);
            System.out.printf("Your animal %s is added to the zoo \n", animal.toString());
        }
        else if(animal.getSpecies() == Species.SQUIRREL && !cageThree.isVacantCage()) {
            System.out.println("The zoo cannot accept your animal");
        }

        if(animal.getSpecies() == Species.PENGUIN && cageFour.isVacantCage()) {
            cageFour.setVacantCage(false);
            logPenguin = new InhibitionLog(new Date(), null, animal.getSpecies(), animal.getName());
            history.add(logPenguin);
            animalsInZoo.put(animal.getName(), cageFour);
            System.out.printf("Your animal %s is added to the zoo \n", animal.toString());
        }
        else if(animal.getSpecies() == Species.PENGUIN && !cageFour.isVacantCage()) {
            System.out.println("The zoo cannot accept your animal");
        }


    }

    @Override
    public void checkOutAnimal(Animal animal) {
        Iterator<String> iterator = animalsInZoo.keySet().iterator();
        String key;
        while(iterator.hasNext()) {
            key = iterator.next();
            if(animal.getName().equals(key) && !animalsInZoo.get(key).isVacantCage()) {
               switch(animalsInZoo.get(key).getNumber()) {
                   case 1 : logLeon = new InhibitionLog(logLeon.getCheckInDate(), new Date(), animal.getSpecies(), animal.getName());
                   animalsInZoo.get(key).setVacantCage(true);
                   history.add(logLeon);
                   animalsInZoo.remove(key);
                   System.out.printf("Your animal %s is removed from the zoo \n", animal.toString());
                        break;

                   case 2 : logGiraffe = new InhibitionLog(logGiraffe.getCheckInDate(), new Date(), animal.getSpecies(), animal.getName());
                       animalsInZoo.get(key).setVacantCage(true);
                       history.add(logGiraffe);
                       animalsInZoo.remove(key);
                       System.out.printf("Your animal %s is removed from the zoo \n", animal.toString());
                       break;

                   case 3 : logSquirrel = new InhibitionLog(logSquirrel.getCheckInDate(), new Date(), animal.getSpecies(), animal.getName());
                       animalsInZoo.get(key).setVacantCage(true);
                       history.add(logSquirrel);
                       animalsInZoo.remove(key);
                       System.out.printf("Your animal %s is removed from the zoo \n", animal.toString());
                       break;

                   case 4 : logPenguin = new InhibitionLog(logPenguin.getCheckInDate(), new Date(), animal.getSpecies(), animal.getName());
                       animalsInZoo.get(key).setVacantCage(true);
                       history.add(logPenguin);
                       animalsInZoo.remove(key);
                       System.out.printf("Your animal %s is removed from the zoo \n", animal.toString());
                       break;
                   default : System.out.println("Animal name not found in the zoo!");
               }
            }
            else {
                System.out.println("Animal name not found in the zoo!");
            }
        }


    }

    @Override
    public List<InhibitionLog> getHistory() {
        return null;
    }

}
