package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		head = new LLNode <E> (null);
		tail = new LLNode <E> (null);
		size = 0;
		head.next = tail;
		tail.prev = head;

		tail.next = null;
		head.prev = null;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if (element == null)
		{
			throw new NullPointerException("null obj");
		}
		
		LLNode<E> tmp = new LLNode <E> (element);
		
		tmp.next = tail;        // insert in tail
		tmp.prev = tail.prev;
		tail.prev.next = tmp;
		tail.prev = tmp;
		size++;
		
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if ( (index >= size) || (index < 0) )
		{
			throw new IndexOutOfBoundsException("the index is out of bounds");
		}
		
		LLNode<E>  it = head.next;
		for(int i = 0; i < index; i++)
		{
			it = it.next;
		}
		
		if (it == null)
		{
			throw new NullPointerException("null obj");
		}
		
		return it.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if ( ( index > size)  || (index < 0 ) )
		{
			throw new IndexOutOfBoundsException("the index is out of bounds");
		}
		
		if (element == null)
		{
			throw new NullPointerException("null obj");
		}
		
		LLNode<E>  it = head.next;
		for(int i = 0; i < index ; i++)
		{
			it = it.next;
		}
		
		if (it == null)
		{
			throw new NullPointerException("null obj");
		}
		
		LLNode<E> newNode = new LLNode <E> (element);
		
		newNode.next = it;
		newNode.prev = it.prev;
		it.prev.next = newNode;
		it.prev = newNode;	
		
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if ( (index >= size) || (index < 0 ) )
		{
			throw new IndexOutOfBoundsException("the index is out of bounds");
		}
		
		LLNode<E>  it = head.next;
		for(int i = 0; i < index ; i++)
		{
			it = it.next;
		}
		
		if (it == null)
		{
			throw new NullPointerException("null obj");
		}
		
		it.prev.next = it.next;
		it.next.prev = it.prev;
		
		size--;
		
		return it.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if ( (index >= size) || (index < 0) )
		{
			throw new IndexOutOfBoundsException("the index is out of bounds");
		}
		
		if (element == null)
		{
			throw new NullPointerException("null obj");
		}
		
		LLNode<E>  it = head.next;
		for(int i = 0; i < index ; i++)
		{
			it = it.next;
		}
		
		E dataOld = it.data;
		it.data = element;
		
		return dataOld;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// cstr
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode() 
	{
		this.data = null;
		this.prev = null;
		this.next = null;
	}
}
