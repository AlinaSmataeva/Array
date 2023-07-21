package src;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Array<T extends Number> {
    private final T[] array;

    public Array(int size) {
        array = (T[]) new Number[size];
    }

    public void addElement(T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = value;
                return;
            }
        }
        throw new IllegalStateException("src.Array is full, cannot add more elements.");
    }

    public void doubleElements() {
        for (int i = 0; i < array.length; i++) {
            array[i] = switch (array[i]) {
                case Integer in -> (T) Integer.valueOf(2 * in.intValue());
                case Double in -> (T) Double.valueOf(2 * in.doubleValue());
                case Long in -> (T) Long.valueOf(2 * in.longValue());
                case Short in -> (T) Integer.valueOf(2 * in.shortValue());
                case Byte in -> (T) Integer.valueOf(2 * in.byteValue());
                case Float in -> (T) Float.valueOf(2 * in.floatValue());
                default -> throw new UnsupportedOperationException("Doubling is not supported for this data type.");
            };
        }
    }

    public void editElement(int index, T value) {
        if (index >= 0 && index < array.length) {
            array[index] = value;
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    public Optional<Integer> findElement(T value) {
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], value)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    public T[] getArray() {
        return array;
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Array<?> array1)) return false;
        return Arrays.equals(getArray(), array1.getArray());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getArray());
    }

    @Override
    public String toString() {
        return "Array{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
