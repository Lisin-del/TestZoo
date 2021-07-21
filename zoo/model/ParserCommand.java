package zoo.model;

import zoo.InhibitionLog;

import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class ParserCommand extends ZooImpl {
    private Scanner in = new Scanner(System.in);
    private String commandUser;
    private String[] command;
    private String split = " ";
    private InhibitionLog logLeon;
    private String nameAnimal;

    public void writeCommand() {
        System.out.print("Enter your command: ");
        commandUser = in.nextLine();
        command = commandUser.split(split);


        if(command[0].equalsIgnoreCase("check-in")) {
            switch(command[1].toLowerCase()) {
                case ("leon") : leonAddProcessing();
                    break;
                case ("giraffe") : giraffeAddProcessing();
                    break;
                default : System.out.println("Your animal type is not correct!");
                    break;
            }
        }
        else if(command[0].equalsIgnoreCase("check-out")) {
            Iterator<Animal> iterator = animals.iterator();
            while(iterator.hasNext()) {
                Animal animal = iterator.next();
                if(animal.getName().equalsIgnoreCase(command[1])) {
                    Species species = animal.getSpecies();
                    System.out.println("Work");
//                    switch(species) {
//                        case LEON : leonRemoveProcessing();
//                        break;
//                    }
                }
            }

        }
        else if(command[0].equalsIgnoreCase("log")) {
            for(InhibitionLog i : history) {
                System.out.println(i.toString());
            }
        }
        else {
            System.out.println("Your command is not correct! See the list of commands.");
            System.out.println("Commands:\n" +
                    "[check-in] <animal type> <animal name> \n" +
                    "[check-out] <animal name> \n" +
                    "[log]");
        }





    }

    private void leonAddProcessing() {
        if(cageOne.isVacantCage()) {
            animalLeon = new AnimalImpl(Species.LEON, command[2]);
            cageOne.setVacantCage(false);

            logLeon = new InhibitionLog(new Date(), null, animalLeon.getSpecies(), animalLeon.getName());
            history.add(logLeon);

            System.out.printf("Your animal %s is added to the zoo \n", animalLeon.toString());
        }
        else if(!cageOne.isVacantCage()) {
            System.out.println("The zoo cannot accept your animal");
        }
    }

    private void leonRemoveProcessing() {
        if(!cageOne.isVacantCage()) {
            cageOne.setVacantCage(true);
            logLeon = new InhibitionLog(logLeon.getCheckInDate(), new Date(), animalLeon.getSpecies(), animalLeon.getName());
            history.add(logLeon);
        }
    }



    private void giraffeAddProcessing() {

    }




}
