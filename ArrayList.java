import java.util.Arrays;

public class ArrayList<T> implements ListInterface<T>

{

	private T[] list; // Array of list entries; ignore list[0]
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	// constructor
	public ArrayList(int initalCapacity) {
		if (initalCapacity < DEFAULT_CAPACITY) {
			initalCapacity = DEFAULT_CAPACITY;
		} else {
			checkCapacity(initalCapacity);
		}

		@SuppressWarnings("unchecked")
		T[] tempLists = (T[]) new Object[initalCapacity + 1];
		list = tempLists;
		numberOfEntries = 0;
		initialized = true;
	}

	// Doubles the capacity of the array list if it is full.
	// Precondition: checkInitialization has been called.
	private void ensureCapacity() {
		int capacity = list.length - 1;
		// make sense, the list.length gives the number of entry with item, the first
		// entry of a list is null
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity); // Is capacity too big?
			list = Arrays.copyOf(list, newCapacity + 1);
			// not sure what that + 1 is for, well now it seems to account for the first
			// entry, which points to null
			// apparently it's ok to call Arrays class from java library
			// first parameter is the list to be copied, second parameter is the new
			// capacity
		} // end if
	} // end ensureCapacity

	// Makes room for a new entry at newPosition.
	// Precondition: 1 <= newPosition <= numberOfEntries + 1;
	// numberOfEntries is list's length before addition;
	// checkInitialization has been called.
	private void makeRoom(int newPosition) {
		assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);

		int newIndex = newPosition;
		int lastIndex = numberOfEntries;

// Move each entry to next higher index, starting at end of
// list and continuing until the entry at newIndex is moved
		for (int index = lastIndex; index >= newIndex; index--)
			list[index + 1] = list[index];
	} // end makeRoom

	// Shifts entries that are beyond the entry to be removed to the
	// next lower position.
	// Precondition: 1 <= givenPosition < numberOfEntries;
	// numberOfEntries is list's length before removal;
	// checkInitialization has been called.
	private void removeGap(int givenPosition) {
		assert (givenPosition >= 1) && (givenPosition < numberOfEntries);

		int removedIndex = givenPosition;
		int lastIndex = numberOfEntries;

		for (int index = removedIndex; index < lastIndex; index++)
			list[index] = list[index + 1];
	} // end removeGap

	// Throws an exception if this object is not initialized.
	private void checkInitialization() {
		if (!initialized)
			throw new SecurityException("AList object is not initialized properly.");
	} // end checkInitialization

	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a list " + "whose capacity exceeds " + "allowed maximum.");
	}

	@Override
	public void add(T newEntry) {
		// TODO Auto-generated method stub
		checkInitialization();
		list[numberOfEntries + 1] = newEntry;
		numberOfEntries++;
		ensureCapacity();

	}

	// not pregiven
	@Override
	public void add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		checkInitialization();
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			if (newPosition <= numberOfEntries)
				makeRoom(newPosition);
			list[newPosition] = newEntry;
			numberOfEntries++;
			ensureCapacity();

		} else {
			throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds. ");
		}

	}

	@Override
	public T remove(int givenPosition) {
		// TODO Auto-generated method stub
		checkInitialization();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			T result = list[givenPosition];
			// get entry to be removed

			// move subsequent entries toward entry to be removed
			// unless it is last in list
			if (givenPosition < numberOfEntries) {
				// if givenposition == numberofentries, removegap() wont be performed,
				// occur when you want to remove the last entry of an array
				// list.legnth = numberOfEntries + 1
				// so numberOfentries is a index in the list, and wouldnt be out of bound
				removeGap(givenPosition);
			}
			numberOfEntries--;
			return result;
			// return reference to remove entry
		} else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation. ");

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		T[] tempLists = (T[]) new Object[DEFAULT_CAPACITY + 1];
		list = tempLists;
		numberOfEntries = 0;
		initialized = true;

	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		checkInitialization();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			T originalEntry = list[givenPosition];
			list[givenPosition] = newEntry;
			return originalEntry;
		} else
			throw new IndexOutOfBoundsException("Illegeal poition given to replace operation.");
	} // end replace

	// use to be getentry() that I override
	public T getEntry(int givenPosition) {
		// TODO Auto-generated method stub
		checkInitialization();
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			assert !isEmpty();
			return list[givenPosition];
		} else
			throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");

	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		checkInitialization();
		boolean found = false;
		int index = 1;
		while (!found && (index <= numberOfEntries)) {
			if (anEntry.equals(list[index])) {
//					 the .equals() interest me, does it apply to all generic???
				found = true;
			}
			index++;
		}
		return found;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numberOfEntries == 0;
	}

	// not pregiven
	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		checkInitialization();
		// just to check initalization, nothing to worry about

		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		// numberOfEntries is a private instance var
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = list[index + 1];
		}
		return result;
	} // end checkCapacity

 

}
