package se.johan;

import java.util.Arrays;
import java.util.Collections;

public class ArrayUtilExample {

    public static void main(String[] args) {
        ex8();
    }

    //Sorting Arrays using pre-made method Arrays.sort
    public static void ex1() {
        String[] names = {"Simon", "erik", "Ulf", "Fredrik", "Jonas", "Kent", "Marcus", "Martina"};
        System.out.println(Arrays.toString(names));

        // Arrays.sort(names); //Will sort like we did in ex4 - Sorting with capital letters first, hence 'erik' comes last
        // Arrays.sort(names, String.CASE_INSENSITIVE_ORDER); // Will ignore capital letters and sort alphabetically.
        Arrays.sort(names, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER)); // Sorts in reverse order

        System.out.println(Arrays.toString(names));

    }

    // binarySearch method
    public static void ex2() {
        int[] numbers = {700, 900, 200, 4555, 34500, 445000, 6000000};
        Arrays.sort(numbers); // binarySearch only works on sorted numbers
        // {200, 700, 900. 4555, 34500, 445000, 6000000
        int index = Arrays.binarySearch(numbers, 900);  // search for numbers that are 200
        //int index = Arrays.binarySearch(numbers, 100);  // does not exist, will return negative number
        System.out.println("index = " + index); // Output = 2, because it's in the third element
        if (index < 0) { // Since a number that doesn't exist will return a negative value..
            System.out.println("Data not found!"); // ..we will print the following
        } else { // positive number or zero
            System.out.println(numbers[index]); // Will print the actual number, 900 in this case
        }
    }

    // Expand existing array
    public static void ex3() {

        int[] numbers = {10, 20, 30, 40};
        int newElement = 50; // We want to add this element to 'numbers'
        int[] newArray = Arrays.copyOf(numbers, numbers.length + 1); // {10, 20, 30, 40, 0} Added one more value, 0 for now
        newArray[newArray.length - 1] = 50; // [10, 20, 30, 40, 50] replaced last one 0 with 50
        System.out.println(Arrays.toString(newArray)); // Output [10, 20, 30, 40, 50]


    }

    public static void addName(String newName) {
        // todo : we will do this in the workshop

    }

    // Arrays.copyOf
    public static void ex4() {
        char[] letters = {'J', 'A', 'V', 'A'};
        // letters[0] ='L'; <- If this is put here instead it will modify it before it gets copied, so it will show for
        // both referenceToOriginalArray and copyOfTheOriginalArray


        char[] referenceToOriginalArray = letters; // {'J', 'A', 'V', 'A'}
        char[] copyOfTheOriginalArray = Arrays.copyOf(letters, letters.length); // {'J', 'A', 'V', 'A'} but this is a copy in memory

        letters[0] = 'L'; //This will change the referenceToOriginalArray, but since copyOfTheOriginalArray
        // is a copy of original 'letters' it will not change because it is stored in the memory separate.

        System.out.println("referenceToOriginalArray " + Arrays.toString(referenceToOriginalArray));
        System.out.println("copyOfTheOriginalArray = " + Arrays.toString(copyOfTheOriginalArray));


    }
    // Combining arrays with Arrays.copyOf
    public static void ex5(){
        String[] names = {"Fredrik"};
        String[] moreNames = {"Erik", "Ulf", "Simon", "Kent"};
        names = arrayConcat(names,moreNames); //[Fredrik, Erik, Ulf, Simon, Kent]
    }
    public static String[] arrayConcat(String[] source, String[] elementsToAdd){
        String[] combined = Arrays.copyOf(source, source.length + elementsToAdd.length);
        for(int i= source.length, j=0; i<combined.length; i++, j++){
            combined[i] = elementsToAdd[j];
        }
        return combined;
    }
    //Arrays.copyOfRange()
    public static void ex6(){
        int[] numbers = {1,2,3,4,5,6,7,8,9};

        int startIndex = 2;             //Position we want to start from, INCLUSIVE
        int endIndex = numbers.length;  //Position we want to end at, EXCLUSIVE

        // range = {3,4,5,6,7,8,9}
        int[] range = Arrays.copyOfRange( numbers, startIndex, endIndex);

    }
    //Arrays.fill()
    public static void ex7(){
        char[] letters = new char[10]; // Create 10 elements in the array
        Arrays.fill(letters, 'X'); // make them all X [X,X,X,X,X,X,X,X,X,X]
        System.out.println(letters);
    }
    //Arrays.toString()
    public static void ex8(){
        //If yo want to turn an array into a String you can use the Arrays.toString() method
        // If you don't use it you will only get the memory address of the array back.
        String[] javaPrinciples = {
                "1. DRY - Don't Repeat Yourself",
                "2. KISS - Keep It Simple Stupid"
        };
            //Ljava.lang.String;@12db9742
        System.out.println(javaPrinciples);

        // ["1. DRY - Don't Repeat Yourself", "2. KISS - Keep It Simple Stupid"]
        System.out.println(Arrays.toString(javaPrinciples));
    }

}
