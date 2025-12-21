package flexibleconstructors.abstractmethod;

public class Entity extends AbstractEntity {
    //this won't work, because someArgument will be null, and it is needed in super
    private final String someArgument;

    public Entity(int id, String someArgument) {
        super(id);
        this.someArgument = someArgument;
    }

    @Override
    protected String getDisplayedName() {
        return someArgument;
    }

    static void main() {
        Entity entity = new Entity(1, "Something goes here");
        System.out.println(entity.getDescription());
    }
}
