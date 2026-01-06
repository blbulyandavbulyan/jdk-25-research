package flexibleconstructors.heavyinitialization.solution;

import flexibleconstructors.heavyinitialization.AbstractOwner;
import flexibleconstructors.heavyinitialization.Dependency;

import java.util.UUID;

public class OwnerJdk25 extends AbstractOwner {
    public OwnerJdk25(String name, String type, String dependencyName) {
        //don't need builder, or static method, we can just do it right here
        Dependency dependency = new Dependency();
        dependency.setUuid(UUID.randomUUID());
        dependency.setType(type);
        dependency.setName(dependencyName);
        super(name, dependency);
    }
}
