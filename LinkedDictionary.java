import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDictionary<K, V> implements DictionaryInterface<K, V> {
    private Node firstNode; // Reference to first node of chain
    private int numberOfEntries;

    public LinkedDictionary() {
        initializeDataFields();
    } // end default constructor

    // Same as in SortedLinkedDictionary.
    // Since iterators implement Iterator, methods must be public.
    private class KeyIterator implements Iterator<K> {
        private Node nextNode;

        private KeyIterator() {
            nextNode = firstNode;
        } // end default constructor

        public boolean hasNext() {
            return nextNode != null;
        } // end hasNext

        public K next() {
            K result;

            if (hasNext()) {
                result = nextNode.getKey();
                nextNode = nextNode.getNextNode();
            } else {
                throw new NoSuchElementException();
            } // end if

            return result;
        } // end next

        public void remove() {
            throw new UnsupportedOperationException();
        } // end remove
    } // end KeyIterator

    private class ValueIterator implements Iterator<V> {
        private Node nextNode;

        private ValueIterator() {
            nextNode = firstNode;
        } // end default constructor

        public boolean hasNext() {
            return nextNode != null;
        } // end hasNext

        public V next() {
            V result;

            if (hasNext()) {
                result = nextNode.getValue();
                nextNode = nextNode.getNextNode();
            } else {
                throw new NoSuchElementException();
                // only called after hasNext is confirmed, so throwing such exception is allowed
            } // end if

            return result;
        } // end next

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        } // end remove
    } // end ValueIterator

    private class Node {
        private K key;
        private V value;
        private Node next;

        private Node(K searchKey, V dataValue) {
            key = searchKey;
            value = dataValue;
            next = null;
        } // end constructor

        private Node(K searchKey, V dataValue, Node nextNode) {
            key = searchKey;
            value = dataValue;
            next = nextNode;
        } // end constructor

        private K getKey() {
            return key;
        } // end getKey

        private V getValue() {
            return value;
        } // end getValue

        private void setValue(V newValue) {
            value = newValue;
        } // end setValue

        private Node getNextNode() {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode) {
            next = nextNode;
        } // end setNextNode
    } // end Node

    /******************************************************************************/

    @Override
    public V add(K key, V value) {
        // TODO Auto-generated method stub
        V result = null;

        Node currentNode = firstNode;
        while ((currentNode != null) && !key.equals(currentNode.getKey())) {
            currentNode = currentNode.getNextNode();
        }
            // !key.equals(currentNode.getKey())
                // wonderful logic

        if (currentNode == null) {
            Node newNode = new Node(key, value);
            newNode.setNextNode(firstNode);
            firstNode = newNode;
            numberOfEntries++;
        } else {
            result = currentNode.getValue();
            currentNode.setValue(value);

        }

        return result;
    }

    @Override
    public V remove(K key) {
            // this logic is diffcult to visualize, I need to draw diagram I guess

        // TODO Auto-generated method stub
        V result = null;
        if (!isEmpty()) {
            Node currentNode = firstNode;
            Node nodeBefore = null;

            while ((currentNode != null) && !key.equals(currentNode.getKey())) {
                nodeBefore = currentNode;
                currentNode = currentNode.getNextNode();
            }
                // key.equals(currentNode.getKey())
                    // if equals, while loop stops

            if (currentNode != null) {
                    // key.equals(currentNode.getKey())
                        // this is for if key equals currentNode.getKey()
                Node nodeAfter = currentNode.getNextNode();

                if (nodeBefore == null)
                    firstNode = nodeAfter;
                else
                    nodeBefore.setNextNode(nodeAfter);

                result = currentNode.getValue();
                numberOfEntries--;
            }

        }

        return result;
    }

    @Override
    public V getValue(K key) {
        // TODO Auto-generated method stub
        V result = null;
        Node currentNode = firstNode;
        while ((currentNode != null) && !key.equals(currentNode.getKey())) {
            currentNode = currentNode.getNextNode();
        }
        if (currentNode != null) {
            result = currentNode.getValue();
        }
        return result;
    }

    @Override
    public boolean contains(K key) {
        // TODO Auto-generated method stub
        return getValue(key) != null;
    }

    @Override
    public Iterator<K> getKeyIterator() {
        // TODO Auto-generated method stub
        return new KeyIterator();
    }

    @Override
    public Iterator<V> getValueIterator() {
        // TODO Auto-generated method stub
        return new ValueIterator();
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return numberOfEntries == 0;
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return numberOfEntries;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

        initializeDataFields();

    }

    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    }

} // end LinkedDictionary
