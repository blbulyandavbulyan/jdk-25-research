package flexibleconstructors.abstractmethod;

public class EntityJdk25 extends AbstractEntity {
    //this will work because of flexible constructor bodies 🎉
    private final String someArgument;

    public EntityJdk25(int id, String someArgument) {
        //setting the argument before invoking super, makes getDisplayName work correctly
        this.someArgument = someArgument;
        super(id);
    }

    @Override
    protected String getDisplayedName() {
        return someArgument;
    }

    static void main() {
        EntityJdk25 entity = new EntityJdk25(1, "Something goes here");
        System.out.println(entity.getDescription());
    }
}
