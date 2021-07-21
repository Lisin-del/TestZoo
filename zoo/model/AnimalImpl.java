package zoo.model;

public class AnimalImpl implements Animal {
    private Species species;
    private String name;

    public AnimalImpl(Species species, String name) {
        this.species = species;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Species getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return "AnimalImpl{" + "species=" + species + ", name='" + name + '\'' + '}';
    }
}
