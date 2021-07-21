package zoo.model;

import zoo.Zoo;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new ZooImpl();
        ParserCommand parser = new ParserCommand();

        while(true) {
            parser.writeCommand();
        }
    }
}
