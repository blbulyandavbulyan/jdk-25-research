import patternmatching.decomposingrecords.RawDog;
import patternmatching.decomposingrecords.User;

void main(String[] args) {
    Object entity = createEntity(args.length == 1 && Boolean.parseBoolean(args[0]));
    // I know that you can use interfaces for this example, which makes it really silly, but I don't want to do that
    System.out.println("Decomposing with switch:");
    decomposeWithSwitch(entity);
    System.out.println("Decomposing with if:");
    decomposeWithIf(entity);
}

private void decomposeWithIf(Object entity) {
    if (entity instanceof RawDog(_, Long id, _)) {
        System.out.printf("Today only raw dog is available, here is the id: %d\n", id);
    } else if (entity instanceof User(_, var id)) {
        System.out.printf("This is user: %d\n", id);
    } else {
        System.out.println("I should not been reached");
    }
}

private static void decomposeWithSwitch(Object entity) {
    switch (entity) {
        case null -> System.out.println("I've shouldn't have happened");
        case User(_, var id) -> { //Too bad that I have to know the order of fields there, I thought that it could just figure them out by "name"
            System.out.printf("Oh, this was user, here is the id: %d\n", id);
        }
        case RawDog(_, var id, _) -> {
            System.out.printf("Today only raw dog is available, here is the id: %d\n", id);
        }
        default -> System.out.println("I'm also impossible");
    }
}

private Object createEntity(boolean b) {
    if (b) {
        return new RawDog("Spike", 1L, 12L);
    }
    return new User("Bob", 2L);
}