/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int sizeBefore = list1.size();
		int b = list1.get(1);
		int a = list1.remove(0);
		int sizeAfter = list1.size();
		
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		assertEquals("Remove: check size is correct ", sizeBefore, sizeAfter + 1);
		assertEquals("Remove: check new first value ", (Integer) b, list1.get(0));
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		int size = list1.size();
		list1.add(size, 33);
		int newSize = list1.size();
		assertEquals("AddEnd: check the size ", size + 1, newSize);
		assertEquals("AddEnd: check the value ", (Integer) 33, list1.get(size));
		
		try {
			list1.add(newSize + 1, 34);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		int size = list1.size();
		list1.remove(0);
		int sizeAfter = list1.size();
		assertEquals("Size: check new first value ", size, sizeAfter +1);
		
		for (int i = 0; i < sizeAfter; i++)
		{
			list1.remove(0);
		}
		
		assertEquals("Size: check new first value ", 0, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		list1.add(1, 20);
		list1.remove(0);
		assertEquals("Add at index: check new first value ", (Integer) 20, list1.get(0));
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    int a = list1.set(0, 66);
	    list1.add(1, a);
	    assertEquals("Test set: check new first value ", list1.get(0), (Integer) 66);
	    int b =  list1.get(1) + 1;
	    assertEquals("Test set: check new first value ", list1.get(0), (Integer) b);
	    
	    try {
			list1.set(1, null);
			fail("Null value");
		}
		catch (NullPointerException e) {
		}
	}
	
}
