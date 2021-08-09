package util;

import java.lang.reflect.InvocationTargetException;

public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;
    public BasicGenerator (Class<T> type) {
        this.type = type;
    }
    @Override
    public T next() {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
    public static <T> Generator<T> create (Class<T> type) {
        return new BasicGenerator<>(type);
    }
}
