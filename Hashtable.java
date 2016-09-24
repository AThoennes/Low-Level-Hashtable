public class Hashtable implements HashtableInterface
{
	// array of linked lists (array indices are the buckets)
	LinkedList[] buckets;
	
	/**
	 * deault constructor
	 */
	public Hashtable()
	{
		buckets = new LinkedList[10];
		
		for (int a = 0; a < buckets.length; a++)
		{
			buckets[a] = (LinkedList) null;
		}
	}
	
	/**
	 * takes in an int and returns the value
	 * modded by the array length
	 * 
	 * @param num
	 * @return
	 */
	public int hash(int num)
	{
		return num % buckets.length;
	}

	/**
	 * inserts the user specified value
	 */
	public void insert(int value) 
	{
		int spot = hash(value);
		
		LinkedList temp;
		
		// if there is nothing in the bucket
		if (buckets[spot] ==  null)
		{
			// add a new list
			buckets[spot] = new LinkedList(value);
		}
		// if there is something in the bucket
		else
		{
			// retireve it
			temp = buckets[spot];
			
			// until you hit the end
			while (temp.next != null)
			{
				// move forward
				temp = temp.next;
			}
			
			// when you do hit the end, add a new list
			temp.next = new LinkedList(value);
		}
	}

	/**
	 * deletes the user specified value
	 */
	public void delete(int value) 
	{		
		int spot = hash(value);
		
		LinkedList current = buckets[spot];
		
		LinkedList temp = current;
		
		// check if current value is null
		if (buckets[spot] != null)
		{
			// next check if the current value is the one being sought
			if (current.value == value)
			{
				buckets[spot] = buckets[spot].next;
			}
			else
			{
				// walk the list until you find the right value
				while (current.value != value)
				{
					if (current.next != null)
					{
						temp = current;
						current = current.next;
					}
					else
					{
						System.out.println("ERROR: Element not found!");
						break;
					}
				}
				
				// assuming the value was put into the table
				if (current.value == value)
				{
					temp.next = current.next;
				}
				else
				{
					// this is only printed if you have
					// walked the list and have not found
					// the element you want to delete
					System.out.println("ERROR: Element not found!");
				}
			}
		}
		else
		{
			System.out.println("ERROR: Nothing to delete!");
		}
	}

	public void dumpHash() 
	{
		System.out.println("\nDumping hashtable");
		
		LinkedList list;
		
		for (int i = 0; i < buckets.length; i++)
		{
			list = buckets[i];
			
			System.out.print(i + " = ");
			
			// as long as there is something else
			while (list != null)
			{
				System.out.print(list.value + "     ");
				
				// move forward
				list = list.next;
			}
			
			// last two print statements help with formatting
			// and readability 
			System.out.print("\n");
		}
		System.out.println("\n\n");
	}
}
