package flexibleconstructors.heavyinitialization;

public abstract class AbstractOwner {
    private final String name;
    private final Dependency dependency;

    public AbstractOwner(String name, Dependency dependency) {
        this.name = name;
        this.dependency = dependency;
    }

    public String getName() {
        return name;
    }

    public Dependency getSomeOtherEntity() {
        return dependency;
    }
}
