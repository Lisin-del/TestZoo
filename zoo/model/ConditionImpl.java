package zoo.model;

import java.util.ArrayList;
import java.util.List;

public class ConditionImpl implements Condition {
    private List<Species> isAvailableFor;

    public ConditionImpl(Species species) {
        this.isAvailableFor = new ArrayList<>();
        this.isAvailableFor.add(species);
    }

    @Override
    public List<Species> isAvailableFor() {
        return isAvailableFor;
    }
}
