package src;

import src.Array;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Array<Integer> intArray = new Array<>(5);
        intArray.addElement(1);
        intArray.addElement(2);
        intArray.addElement(3);
        intArray.addElement(4);
        intArray.addElement(5);
        intArray.printArray();

        Array<Double> doubleArray = new Array<>(5);
        doubleArray.addElement(1.1);
        doubleArray.addElement(2.2);
        doubleArray.addElement(3.3);
        doubleArray.addElement(4.4);
        doubleArray.addElement(5.5);
        doubleArray.printArray();

        intArray.doubleElements();
        intArray.printArray();

        doubleArray.editElement(1, 4.4);
        doubleArray.printArray();

        Optional<Integer> index = intArray.findElement(6);
        if (index.isPresent()) {
            System.out.println("Value found at index: " + index.get());
        } else {
            System.out.println("Value not found.");
        }
    }
}
