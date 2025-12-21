package flexibleconstructors.heavyinitialization;

import java.util.UUID;

public class Dependency {
    private UUID uuid;
    private String name;
    private String type;

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
