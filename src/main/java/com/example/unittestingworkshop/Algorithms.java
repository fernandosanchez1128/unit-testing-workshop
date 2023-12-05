package com.example.unittestingworkshop;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Algorithms {

    /**
     * Sorts an array of integers in ascending order using the merge sort algorithm.
     * <p>
     * The merge sort algorithm works by dividing the array into two halves,
     * recursively sorting each half, and then merging the sorted halves.
     * The method modifies the input array in-place.
     * </p>
     * @param array The array of integers to be sorted.
     */

    public static void mergeSort(int[] array) {
        if (array == null) {
            return;
        }

        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];

        // Llenar los subarrays izquierdo y derecho
        System.arraycopy(array, 0, leftArray, 0, mid);
        System.arraycopy(array, mid, rightArray, 0, array.length - mid);

        // Llamadas recursivas para ordenar los subarrays
        mergeSort(leftArray);
        mergeSort(rightArray);

        // Fusionar los subarrays ordenados
        merge(array, leftArray, rightArray);
    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int i = 0; // Índice para el subarray izquierdo
        int j = 0; // Índice para el subarray derecho
        int k = 0; // Índice para el array original

        // Combinar los elementos en orden ascendente
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copiar los elementos restantes del subarray izquierdo, si los hay
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        // Copiar los elementos restantes del subarray derecho, si los hay
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }


    /**
     * This method performs a binary search on a sorted array to find the index of a target element.
     *
     * @param arr    The sorted array in which the search is performed.
     * @param target The element to be searched for in the array.
     * @return The index of the target element in the array if found, or -1 if the element is not present.
     */
    public static int binarySearch(int arr[], int target) {
        if (arr == null) {
            return -1;
        }
        int left = 0, right = arr.length - 1;

        do {

            int mid = left + (right - left) / 2;

            // Check if the target is present at the middle
            if (arr[mid] == target)
                return mid;

            // If the target is greater, ignore the left half
            if (arr[mid] < target)
                left = mid + 1;

                // If the target is smaller, ignore the right half
            else
                right = mid - 1;
        } while (left < right);

        // Target not present in the array
        return -1;
    }


    /**
     * This method checks if a given string has any repeated characters.
     *
     * @param inputString The input string to be checked for repeated characters.
     * @return True if the input string has repeated characters, otherwise false.
     */
    public static boolean hasRepeatedCharacters(String inputString) {
        // Assuming ASCII characters, create an array to track character occurrences
        boolean[] seenCharacters = new boolean[81];

        // Iterate through each character in the string
        for (char ch : inputString.toCharArray()) {
            // If the character is already marked as seen, it's a repeat
            if (seenCharacters[(128 - ch)]) {
                return true;
            }
            // Otherwise, mark the character as seen
            seenCharacters[128 - ch] = true;
        }

        // If the loop completes without returning, there are no repeated characters
        return false;
    }


    /**
     * convert  a list of people to map using name as key
     *
     * @param people list of persons to convert to map
     * @return map of Person having name as the key
     */
    public static Map<String, Person> convertListOfPeopleToMap(List<Person> people) {

        return people.stream()
                .collect(toMap(Person::getName, person -> person));
    }

    static class Person {
        private String name;
        private String phone;

        public Person(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }
    }




}

