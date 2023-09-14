import exceptions.EmptyPCollectionException;
import exceptions.IndexOutOfBoundsException;
import interfaces.QueueI;

public class SlowQueue<E> implements QueueI<E> {
    /**
     * This class implements a queue by internally maintaining a PList.
     *
     * The enqueue operation is O(n)
     * The dequeue operation must be O(1)
     *
     */
    protected PList<E> list;
    public SlowQueue() {
        list = new EmptyPList<>();
    }

    // Constant time operations

    public boolean isEmpty () {
        return list.isEmpty();
        //return false; // TODO: fix this
    } // O(1)

    public int size () {
        return list.size();
        //return 0; // TODO: fix this
    } // O(1)

    public E dequeue() throws EmptyPCollectionException { // O(1)
        try {
            E element = list.get(0);
            list = list.remove(0);
            return element;
        } catch (IndexOutOfBoundsException e) {
            throw new EmptyPCollectionException();
        }

      //return null; // TODO: fix this
    }

    // Linear time operations
    public void enqueue (E element) {
        list = list.addBack(element);
        //list = list.append(element);
        // TODO: fix this
    } // O(n)

}
