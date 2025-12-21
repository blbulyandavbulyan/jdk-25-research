package flexibleconstructors.heavyinitialization;

import java.util.UUID;

public class Owner extends AbstractOwner {
    public Owner(String name, String type, String dependencyName) {
        //note that if Dependency has more arguments, it becomes even more scuffed without a builder
        super(name, constructDependency(type, dependencyName));
    }

    private static Dependency constructDependency(String type, String dependencyName) {
        Dependency dependency = new Dependency();
        dependency.setName(dependencyName);
        dependency.setType(type);
        dependency.setUuid(UUID.randomUUID());
        return dependency;
    }
}
