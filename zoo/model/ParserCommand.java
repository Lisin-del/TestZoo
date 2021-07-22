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


    public void writeCommand() {
        System.out.print("Enter your command: ");
        commandUser = in.nextLine();
        command = commandUser.split(split);


        if(command[0].equalsIgnoreCase("check-in")) {
            switch(command[1]) {
                case ("leon") : AnimalImpl animalLeon = new AnimalImpl(Species.LEON, command[2]);
                    checkInAnimal(animalLeon);
                    break;
                case("giraffe") : AnimalImpl animalGiraffe = new AnimalImpl(Species.GIRAFFE, command[2]);
                    checkInAnimal(animalGiraffe);
                    break;
                case("squirrel") : AnimalImpl animalSquirrel = new AnimalImpl(Species.SQUIRREL, command[2]);
                    checkInAnimal(animalSquirrel);
                    break;
                case("penguin") : AnimalImpl animalPenguin = new AnimalImpl(Species.PENGUIN, command[2]);
                    checkInAnimal(animalPenguin);
                    break;
                default : System.out.println("Animal type is not correct!");
                    break;
            }
        }
        else if(command[0].equalsIgnoreCase("check-out")) {
            AnimalImpl animal = new AnimalImpl(command[1]);
            checkOutAnimal(animal);
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

}
