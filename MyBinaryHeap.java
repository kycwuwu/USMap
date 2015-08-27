/**
 * COMS W3137
 * Assignment 5 Problem 1
 * Kylie Wu
 * kcw2141
 *
 * Implementation of a minHeap from the notes
 */
public class MyBinaryHeap
{
    private int currentSize;
    HeapTreeNode[] array;

    /**
     * Creates new heap
     * @param capacity the maximum number of elements it should hold
     */
    public MyBinaryHeap(int capacity)
    {
        currentSize = 0;
        array = new HeapTreeNode[capacity + 1];
    }

    /**
     * Adds node to the heap
     * @param x node to be added
     */
    public void insert(HeapTreeNode x)
    {
        int hole = ++currentSize;
        for(; hole > 1 && x.edge.distance < array[hole / 2].edge.distance; hole /= 2)
        {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }

    /**
     * Moves nodes to correct spots based on frequency
     * @param hole int representing the index of the hole
     */
    public void percolateDown(int hole)
    {
        int child;
        HeapTreeNode tmp = array[hole];

        for (; hole *  2 <= currentSize; hole = child)
        {
            child = hole * 2;
            if (child != currentSize && array[child + 1].edge.distance < array[child].edge.distance)
            {
                child ++;
            }
            if (array[child].edge.distance < tmp.edge.distance)
            {
                array[hole] = array[child];
            }
            else
            {
                break;
            }
        }
        array[hole] = tmp;
    }

    /**
     * Determines if the heap is empty
     * @return boolean true if heap is empty, otherwise false
     */
    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    /**
     * Finds the HuffmanNode with the smallest frequency
     * @return a HuffmanNode from the heap
     */
    public HeapTreeNode findMin()
    {
        if (isEmpty())
        {
            return null;
        }
        return array[1];
    }

    /**
     * Returns and deletes the HuffmanNode with the smallest frequency
     * @return smallest HuffmanNode
     */
    public HeapTreeNode deleteMin()
    {
        if (isEmpty())
        {
            return null;
        }
        HeapTreeNode min = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return min;
    }

    /**
     * Gets the current size of the heap
     * @return int representing heap size
     */
    public int getCurrentSize()
    {
        return currentSize;
    }
}