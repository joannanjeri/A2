import exceptions.EmptyPCollectionException;
import exceptions.IndexOutOfBoundsException;
import interfaces.StackI;

public class Stack<E> implements StackI<E> {
    /**
     * This class implements a stack interface by internally maintaining a PList.
     * All the operations must be O(1)
     *
     */
    private PList<E> list;

    public Stack () {
        list = new EmptyPList<>();
    }

    // Constant time operations

    public boolean isEmpty () {
        return list.isEmpty();
        //return false; // TODO: replace this line with your code
    } // O(1)

    public int size () {
        return list.size();
        //return 0; // TODO: replace this line with your code
    } // O(1)
    public void push (E element) {
        list = list.addFront(element);
        // TODO: replace this line with your code
    } // O(1)
    public E pop() throws EmptyPCollectionException { // O(1)
        try {
            E element = list.get(0);
            list = list.remove(0);
            return element;
        } catch (IndexOutOfBoundsException e) {
            throw new EmptyPCollectionException();
        }
        //return null; // TODO: replace this line with your code
    }
}
