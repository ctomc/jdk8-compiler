/**
 * @author Tomaz Cerar (c) 2016 Red Hat Inc.
 */
public class Option {
    interface ValueParser<T> {
        T parseValue(String string, ClassLoader classLoader) throws IllegalArgumentException;
    }

    static <T> Option.ValueParser<T> getEnumParser(final Class<T> enumType) {
        return new ValueParser<T>() {
            public T parseValue(final String string, final ClassLoader classLoader) throws IllegalArgumentException {
                return enumType.cast(Enum.valueOf(enumType.asSubclass(Enum.class), string.trim()));
            }
        };
    }
}
