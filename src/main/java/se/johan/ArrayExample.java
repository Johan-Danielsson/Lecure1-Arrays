package se.johan;


public class ArrayExample {

    public static void main(String[] args) {
        // syntax: datatype[] arrayName;
        int[] numbers;
        numbers = new int[3]; // [0 , 0 , 0 ] Primitive data type returns 0 as default value

        int[] numbersArr = new int[]{2, 4, 6, 8}; // 4 elements with value 2,4,6,8
        int[] numberArrShortenedSyntax = {2, 4, 6, 8}; // 4 elements with value 2,4,6,8 - Both are the same

        String[] stringsArray = new String[3]; // [null , null , null] - for String that is an object = null
        char[] letters = {'J', 'A', 'V', 'A'};

        ex6();
    }

    // Accessing  Array elements
    public static void ex1() {
        String[] names = new String[3]; // [null , null , null]
        System.out.println("Total names = " + names.length);

        names[0] = "Fredrik"; // index 0 ( the first one) [Fredrik , null , null]
        names[names.length - 1] = "Jonas"; // Index number 2 [Fredrik , null , Jonas]

        System.out.println(names[0]); // Output = Fredrik
        System.out.println(names[1]); // Output = Null
        System.out.println(names[2]); // Output = Jonas
        // System.out.println(names[10]); will return out of bounds error, because doesn't exist
    }

    public static void ex2() {
        int[] numbers = {5, 2, 3, 4, 7};
        // iterating through the array using an indexed based for loop
        for (int i = 0; i < numbers.length; i++) { //i means 'index'
            // if (numbers[i] == 3) would be looking for the number 3, not the index. (Looks for the value)
            if (i == 2) { //index 2
                numbers[i] = 3000; //replace index 2, 3rd number with 3000

            }
            System.out.println("numbers [" + i + "]=" + numbers[i]);
        }
        System.out.println("-------------");
        // Iterating through the array using for Enhanced loop or for-each loop
        for (int number : numbers) {
            System.out.println(number); // Will also output the numbers
            //For-each is good when we just need to read the index, not access/change the elements

        }


    }

    // Expand the array
    public static void ex3() {

        int[] originalArray = {2, 5, 8, 1, 9}; // 5 elements
        for (int element : originalArray) {
            System.out.print(element + " ");
        }
        System.out.println(); //move to the next line

        int[] newArray = new int[originalArray.length + 1]; // [0,0,0,0,0,0] Adds new array with one more element from originalArray
        //index for-loop
        for (int i = 0; i < originalArray.length; i++) {
            newArray[i] = originalArray[i]; // adding value 0,1,2,3,4 from original [2,5,8,1,9,0]
        }

        newArray[newArray.length - 1] = 7; // added 7 to the index of newArray to the last element [2,5,8,1,9,7]
        for (int element : newArray) {
            System.out.print(element + " "); // we expanded with one element creating a new array
        }
        System.out.println(); //move to the next line

    }

    // Sorting Arrays
    public static void ex4() {
        int[] numbers = {5, 2, 3, 4, 7};
        // [5, 2, 3, 4, 7] compare 0 to 1, 5 to 2, then 5 with 3, then 5 with 4. Lastly 7 is bigger so we don't swap
        // To make it look like this [2, 3, 4, 5, 7]

        // iterating over each element of the array
        for (int i = 0; i < numbers.length; i++) {

            //inner loop to iterate over the remaining elements in the array, starting from the next element after 'i'
            for (int j = i + 1; j < numbers.length; j++) { //compare the first value against the others, that's why '1' and not '0'
                // {2, 5, 3, 4, 7} -> Then we compare 5 with 3,4,7
                // {2, 3, 5, 4, 7}
                // {2, 3, 4, 5, 7}
                if (numbers[i] > numbers[j]) { // 5 > 2 = true
                    int tmpVariable = numbers[i]; //save 5 to tmpVariable
                    numbers[i] = numbers[j];
                    numbers[j] = tmpVariable;

                } //if statement

            } // for j

        }       //for i
        for (int number : numbers) {
            System.out.print(number + " ");
        }

    } //ex4

    // Find the largest number
    public static void ex5(){
        int[] numbers = {2, 3, 5, 4, 7};
        int maxNumber = 5; // The first number in the Array // 5
        for (int i = 1 ; i< numbers.length; i++){ // goes through the Array, checking initial maxNumber against next
            if (numbers[i] > maxNumber){
                maxNumber = numbers[i]; // If this number is greater than 5, make it the new maxNumber
            }
        }
        System.out.println("maxNumber = " + maxNumber);
    }

    // Two dimensional Arrays
    public static void ex6(){
        //  O   X   O
        //  O   X   X
        //  X   O   X

        String[][] board = new String[3][3];
        //  column  [0]     [1]     [2]
        // row[0]   O        X      O
        // row[1]  null    null    null
        // row[2]  null    null    null

        board[0][0] = "O";
        board[0][1] = "X";
        board[0][2] = "O";

        board[1][0] = "O";
        board[1][1] = "X";
        board[1][2] = "X";

        board[2][0] = "X";
        board[2][1] = "O";
        board[2][2] = "X";

        for (int i = 0 ; i< board.length; i++){ // iterate row, then move to next
            for (int j = 0; j < board[i].length ; j++){ // iterate columns, then move to next
                System.out.print(board[i][j] + "\t"); // \t = seven spaces
            }
            System.out.println("\n"); // \n new line
        }

    }

}