package flexibleconstructors.abstractmethod;

public abstract class AbstractEntity {
    private final int id;
    private final String description;

    public AbstractEntity(int id) {
        this.id = id;
        this.description = "My displayed name: %s".formatted(getDisplayedName());
    }

    protected abstract String getDisplayedName();

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
