package com.datastructure;

/**
 * Segment Tree operations like construction, query and update
 *
 * An array representation of tree is used to represent Segment Trees.
 * For each node at index i, the left child is at index (2*i)+ 1, right child at (2*i) +2 and the parent is at ⌊(i-1)/ 2⌋
 *
 * Height of the segment tree will be log(n)/log(2)
 *
 * The memory will be 2 * (2 ^ ⌈log(n)/log(2)⌉) - 1
 *
 */
public class SegmentTree {

    int[] treeNodes; //Array stores the segment tree nodes

    /**
     * Constructor to construct segment tree from given array.
     * This constructor  allocates memory for segment tree and calls
     * constructSegmentTreeUtil() to fill the allocated memory.
     */
    SegmentTree(int[] arr, int n) {

        //Allocate memory for segment tree
        //Height of segment tree
        int heightTree = (int) Math.ceil(Math.log(n) / Math.log(2));

        //Maximum size of segment tree
        int maxSize = 2 * (int) Math.pow(2, heightTree) - 1;

        treeNodes = new int[maxSize];

        constructSegmentTreeUtil(arr, 0, n - 1, 0);
    }


    /**
     * A utility method to get the middle index from corner indices.
     */
    int getMidIndex(int start, int end) {
        return start + (end - start) / 2;
    }


    /**
     * A recursive function to get the sum of values in given range
     * of the array. The following are parameters for this function.
     *
     * treeNodes    --> Pointer to segment tree
     *
     * currentNodeIndex    --> Index of current node in the segment tree.
     * Initially 0 is passed as root is always at index 0.
     *
     * startIndex & endIndex  --> Starting and ending indices of the segment represented
     * by current node, i.e., treeNodes[startIndex]
     *
     * queryStart & queryEnd  --> Starting and ending indices of query range
     *
     */
    int getSumUtil(int startIndex, int endIndex, int queryStart, int queryEnd, int currentNodeIndex) {

        // If segment of this node is part of given range, then
        // return the sum of the segment.
        if (queryStart <= startIndex && queryEnd >= endIndex)
            return treeNodes[currentNodeIndex];

        // If segment of this node is outside the given range
        // return 0
        if (endIndex < queryStart || startIndex > queryEnd)
            return 0;

        // If a part of this segment overlaps with the given range
        int mid = getMidIndex(startIndex, endIndex);

        // Both the combination of left child and right child are computed recursively.
        return getSumUtil(startIndex, mid, queryStart, queryEnd, 2 * currentNodeIndex + 1) +
                getSumUtil(mid + 1, endIndex, queryStart, queryEnd, 2 * currentNodeIndex + 2);
    }


    /**
     * A recursive function to update the nodes which have the given
     * index in their range. The following parameters are
     *
     * treeNodes, startIndex, endIndex, currentNodeIndex  --> Same as the parameters from getSumUtil()
     *
     * updateIndex   --> index of the element to be updated. This index is in input array.
     *
     * difference   --> Value to be added to all elements which have updateIndex in range.
     */
    void updateValueUtil(int startIndex, int endIndex, int updateIndex, int difference, int currentNodeIndex) {

        // Base Case: If the input index lies outside the range of
        // this segment
        if (updateIndex < startIndex || updateIndex > endIndex)
            return;


        treeNodes[currentNodeIndex] = treeNodes[currentNodeIndex] + difference;

        // If the input index is in the range of this node, then update the
        // value of the node and its children
        if (startIndex != endIndex) {
            int mid = getMidIndex(startIndex, endIndex);

            updateValueUtil(startIndex, mid, updateIndex, difference, 2 * currentNodeIndex + 1);
            updateValueUtil(mid + 1, endIndex, updateIndex, difference, 2 * currentNodeIndex + 2);
        }
    }


    /**
     * The function to update a value in the input array and segment tree.
     * It uses updateValueUtil() to update the value in the segment tree.
     */
    void updateValue(int[] arr, int n, int i, int newValue) {

        //Check for erronoue input index
        if (i < 0 || i > n - 1) {
            System.err.println("Invalid Input");
            return;
        }

        // Get the difference between the new value and the old value
        int difference = newValue - arr[i];

        // Update the value in array
        arr[i] = newValue;

        // Update the value of nodes in the segment tree
        updateValueUtil(0, n - 1, i, difference, 0);
    }

    /**
     * Return sum of elements from index "queryStart" to "queryEnd"
     * It mainly uses the method getSumUtil()
     */
    int getSum(int n, int queryStart, int queryEnd) {

        // Check the erronous input values
        if (queryStart < 0 || queryEnd > n - 1 || queryStart > queryEnd) {
            System.err.println("Invalid input");
            return -1;
        }

        return getSumUtil(0, n - 1, queryStart, queryEnd, 0);
    }

    /**
     * A recursive function that constructs segment tree for array[startIndex, .., endIndex]
     *
     */
    int constructSegmentTreeUtil(int[] arr, int startIndex, int endIndex, int currentNodeIndex) {

        // If there is one element in array, store it in the current node
        // of segment tree and return
        if (startIndex == endIndex) {
            treeNodes[currentNodeIndex] = arr[startIndex];
            return arr[startIndex];
        }

        // If there are more than one elements, the recur for left
        // and right subtrees and store the sum of values in this node
        int mid = getMidIndex(startIndex, endIndex);

        treeNodes[currentNodeIndex] = constructSegmentTreeUtil(arr, startIndex, mid, currentNodeIndex * 2 + 1) +
                                      constructSegmentTreeUtil(arr, mid + 1, endIndex, currentNodeIndex * 2 + 2);

        return treeNodes[currentNodeIndex];
    }


    // Driver program to test above functions
    public static void main(String args[])
    {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;

        // Build segment tree from given array
        SegmentTree  tree = new SegmentTree(arr, n);

        // Print sum of values in array from index 1 to 3
        System.out.println("Sum of values in given range = " +
                tree.getSum(n, 1, 3));

        // Update: set arr[1] = 10 and update corresponding segment
        // tree nodes
        tree.updateValue(arr, n, 1, 10);

        // Find sum after the value is updated
        System.out.println("Updated sum of values in given range = " +
                tree.getSum(n, 1, 3));
    }
}
