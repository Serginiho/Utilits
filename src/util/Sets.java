package util;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static <T extends Enum<T>> Set<T> union(Set<T> a, Set<T> b) {
        if (a instanceof EnumSet && b instanceof EnumSet) {
            EnumSet<T> result = ((EnumSet<T>) a).clone();
            result.addAll(b);
            return result;
        } else {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
            return result;
        }
    }
    public static <T extends Enum<T>>
    Set<T> intersection(Set<T> a, Set<T> b) {
        if (a instanceof EnumSet && b instanceof EnumSet) {
            EnumSet<T> result = ((EnumSet<T>) a).clone();
            result.retainAll(b);
            return result;
        } else {
            Set<T> result = new HashSet<>(a);
            result.retainAll(b);
            return result;
        }
    }
    // Subtract subset from superset:
    public static <T extends Enum<T>> Set<T>
    difference(Set<T> superset, Set<T> subset) {
        if (superset instanceof EnumSet && subset instanceof EnumSet) {
            EnumSet<T> result = ((EnumSet<T>) superset).clone();
            result.removeAll(subset);
            return result;
        } else {
            Set<T> result = new HashSet<>(superset);
            result.removeAll(subset);
            return result;
        }
    }
    // Reflexive--everything not in the intersection:
    public static <T extends Enum<T>> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}
