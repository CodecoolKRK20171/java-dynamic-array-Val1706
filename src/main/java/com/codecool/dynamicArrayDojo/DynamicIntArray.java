package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {

    private int[] array;
    private int size;

    public DynamicIntArray(int size) {
        this.array = new int[size];
        this.size = size;
    }

    public DynamicIntArray() {
        this.array = new int[0];
        this.size = array.length;
    }

    public void add(int value) {

        size++;
        int[] temp = this.array;
        this.array = new int[size];
        for (int i = 0; i < temp.length; i++) {
            this.array[i] = temp[i];
        }
        this.array[size - 1] = value;
    }

    public void remove(int number) {

        boolean valueInArray = false;

        for (int numb: this.array) {
            if (numb == number){
                valueInArray = true;
            }
        }
        if (!valueInArray) throw new ArrayIndexOutOfBoundsException();

        int arraySize = this.array.length - 1;
        int[] newArray = new int[arraySize];

        int pointer = 0;
        for (int i = 0; i < this.array.length; i++) {

            if (this.array[i] != number) {
                newArray[pointer] = this.array[i];
                pointer++;
            }
        }

        this.array = newArray;
    }

    public void insert(int index, int number) {

        int newSize = this.size + 1;
        int lastIndex = newSize - 1;

        int[] newArray = new int[newSize];

        if (index <= this.size) {

            int pointer = 0;
            for (int i = 0; i < newSize; i++) {
                if (i == index) {
                    newArray[i] = number;
                } else {
                    newArray[i] = this.array[pointer];
                    pointer++;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                newArray[i] = this.array[i];
            }
            newArray[lastIndex] = number;
        }
        this.array = newArray;
        this.size = newSize;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public String toString() {

        String toReturn = "";
        for (int i: this.array) {
            toReturn += " " + i;
        }
        return toReturn;
    }
}
