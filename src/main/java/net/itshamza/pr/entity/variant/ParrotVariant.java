package net.itshamza.pr.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum ParrotVariant {
    RED_MACAW(0),
    BLUE_MACAW(1),
    LOVEBIRD(2),
    AFRICAN_GREY(3),
    COCKATOO(4);

    private static final ParrotVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ParrotVariant::getId)).toArray(ParrotVariant[]::new);
    private final int id;

    ParrotVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ParrotVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
