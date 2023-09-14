import exceptions.EmptyPCollectionException;
import exceptions.IndexOutOfBoundsException;
import interfaces.DequeueI;

public class Dequeue<E> extends SlowQueue<E> implements DequeueI<E> {
    /**
     * This class extends a queue implementation with dual operations
     * that work from the other end
     *
     * The enqueueBack operation must be O(1)
     * The dequeueBack operation is O(n)
     *
     */
    public Dequeue () {
        super();
    }

    // Constant time operations
    public void enqueueBack (E element) {
        // TODO: implement this method
        list = list.addFront(element);
        //list = list.insertAtEnd(element);
    } // O(1)

    // Linear time operations
    public E dequeueBack () throws EmptyPCollectionException { // O(n)
        if (isEmpty()) {
            throw new EmptyPCollectionException();
        }

        int lastIndex = list.size() - 1;
        E element = null;

        for (int i = 0; i < lastIndex; i++) {
            try {
                element = list.get(i);
            } catch (IndexOutOfBoundsException ignored) {

            }
        }

        if (element != null) {
            try {
                list = list.remove(lastIndex);
            } catch (IndexOutOfBoundsException e) {
                throw new RuntimeException(e);
            }
            return element;
        } else {
            throw new EmptyPCollectionException();
        }

        //return null; // TODO: implement this method
    }

}
