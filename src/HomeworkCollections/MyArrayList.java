package HomeworkCollections;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T> {
    private T[] elements;
    private int size;


    @SuppressWarnings("unchecked")
    public MyArrayList() {
        elements = (T[]) new Object[0];
    }


    /**
     * Adding element to last position in list
     *
     * @param element Element for adding
     */
    public void add(T element) {
        add(size, element);
    }

    /**
     * Adding element into list at the specified index
     *
     * @param index   Specified index
     * @param element Element for adding
     */
    public void add(int index, T element) {
        if (elements.length >= index)
            expand();

        System.arraycopy(elements, index,
                elements, index + 1,
                size - index);

        elements[index] = element;
        size++;
    }

    /**
     * Receiving element from specified index
     *
     * @param index Index of element
     * @return Requested element
     */
    public T get(int index) {
        if (elements.length >= index) {
            return elements[index];
        }

        throw new IndexOutOfBoundsException();
    }

    /**
     * Receiving index of specified element
     *
     * @param element Specified element
     * @return Index of element. -1 if element not found
     */
    public int indexOf(T element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) continue;
            if (elements[i].equals(element))
                return i;
        }
        return -1;
    }

    /**
     * Remove element from list, if contains
     *
     * @param element Removable element
     */
    public void remove(T element) {
        var index = indexOf(element);
        if (index == -1) return;

        remove(index);
    }

    /**
     * Remove element from specified index
     *
     * @param index Index of removable element
     */
    @SuppressWarnings("unchecked")
    public void remove(int index) {
        if (elements.length == 0) return;
        T[] updated = (T[]) new Object[elements.length - 1];

        if (index >= 0)
            System.arraycopy(elements, 0, updated, 0, index);

        if (size - (index + 1) >= 0)
            System.arraycopy(elements, index + 1, updated, index, size - (index + 1));

        elements = updated;
        size = updated.length;
    }

    /**
     * Remove all elements from collection
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        elements = (T[]) new Object[0];
        size = 0;
    }


    /**
     * Sort collection by specified comparator
     *
     * @param comparator
     */
    public void sort(Comparator<T> comparator) {
        quickSortComparator(elements, 0, elements.length - 1, comparator);
    }

    /**
     * Sort collection if elements implements Comparable interface
     */
    public void sort() {
        if (elements.length == 0) return;

        if (elements[0] instanceof Comparable) {
            quickSortComparable(elements, 0, elements.length - 1);
        }

        //        else {
        //         throw ExecutionControl.NotImplementedException("ArrayList of elements, which not implement Comparable interface");
        //        }
    }


    private void quickSortComparator(T[] arr, int low, int high, Comparator<T> c) {
        if (low < high) {
            int index = sortingComparator(arr, low, high, c);

            quickSortComparator(arr, low, index - 1, c);
            quickSortComparator(arr, index + 1, high, c);
        }
    }

    private int sortingComparator(T[] arr, int low, int high, Comparator<T> c) {
        var middleIndex = low + (high - low) / 2;
        var reference = arr[middleIndex];

        T temp = arr[middleIndex];
        arr[middleIndex] = arr[high];
        arr[high] = temp;

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (c.compare(arr[j], reference) <= 0) {
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    private void quickSortComparable(T[] arr, int low, int high) {
        if (low < high) {
            int index = sortingComparable(arr, low, high);

            quickSortComparable(arr, low, index - 1);
            quickSortComparable(arr, index + 1, high);
        }
    }

    @SuppressWarnings("unchecked")
    private int sortingComparable(T[] arr, int low, int high) {
        var middleIndex = low + (high - low) / 2;
        var reference = arr[middleIndex];

        T temp = arr[middleIndex];
        arr[middleIndex] = arr[high];
        arr[high] = temp;

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            var comparingElement = (Comparable<T>) arr[j];
            if (comparingElement.compareTo(reference) <= 0) {
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    /**
     * Represent storaging elements in text view
     *
     * @return Represent text
     */
    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    private void expand() {
        var newSize = elements.length + 1;
        elements = Arrays.copyOf(elements, newSize);
    }
}
