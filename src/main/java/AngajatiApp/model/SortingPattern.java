package AngajatiApp.model;

import java.util.Comparator;

public interface SortingPattern<Entity> extends Comparator<Entity> {
    public int compare(Entity o1, Entity o2);
}
