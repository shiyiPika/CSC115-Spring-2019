public class PhoneNumberList
{
	private static final int INITIAL_SIZE = 2;

	private PhoneNumber[]	storage;
	private int		count;

	//
	// Purpose:
	//	Initialize a new instance of PhoneNumberList
	//
	public PhoneNumberList()
	{
		storage = new PhoneNumber[INITIAL_SIZE];
		count = 0;
	}

	//
	// Purpose:
	// 	return the element at position index
	//
	// Pre-Conditions:
	// 	for a PhoneNumberList x:
	//	index >= 0 AND
	//	index < x.size()
	//
	// Examples:
	//
	// If x is {"Work:5551212", "Home:4441212", "Cell:3331212"} then:
	//	x.get(0) returns "Work:5551212"
	//	x.get(1) returns "Home:4441212"
	//	the result of calling x.get(3) is undefined
	//
	public PhoneNumber get (int index)
	{
		// NOTE NOTE NOTE
		//
		// This line needs to be removed.  It is only
		// so the tester works.  You should NOT
		// allocate a new PhoneNumber in this method
		// return new PhoneNumber("WARNING", "fix this");

		int length = storage.length;

		if(index <0 || index >= length)
		{
			return new PhoneNumber("WARNING", "fix this");
		}
		else{
			return storage[index];
		}



	}

	//
	// Purpose:
	//	remove the element at position index
	//
	// Pre-Conditions:
	//	for a PhoneNumberList x:
	//		index >= 0 AND
	//		index < x.size()
	//
	// If x is {"Work:5551212", "Home:4441212", "Cell:3331212"} then
	//	after x.remove(0), x is {"Home:4441212", "Cell:3331212"}
	//
	public void remove (int index)
	{
		PhoneNumber[] new_storage= new PhoneNumber[storage.length];

		if(index ==count-1)
		{
			// for(int i=0;i<count-2;i++)
			// {
			// 	new_storage[i] = storage[i];
			// }
			// storage = new_storage;
			storage[index] = null;
		}
		else{
			for(int i = index; i < count -1; i++){
        	storage[i] = storage[i + 1];
      }
		}



		count--;




		
		
	}

	//
	// Purpose:
	//	return the number of elements in the list
	//
	// Returns:
	//	the number of elements in the list
	//
	// Examples:
	//
	// If x is {"Work:5551212", "Home:4441212"}
	//	x.size() returns 2
	// If x is {}
	//	x.size() returns 0
	//
	public int size()
	{
		// return -1;

		return count;
	}

	//
	// Purpose:
	//	add the phone number p to the list
	//
	// Comments:
	//
	//	The array you allocated to store PhoneNumbers might
	//	get full, but you are still required to add this
	//	PhoneNumber (until the JVM runs out of memory!)
	//
	//	This means that you should check to see if the array
	//	is currently full.  If it is, allocate a new array
	// 	that is twice as big, then copy the values over
	//	and update the storage reference to be the new array
	//	Finally, add the new PhoneNumber.
	//
	public void add (PhoneNumber p)
	{

		int current_length = storage.length;
		if(count==current_length)
		{
			PhoneNumber[] new_storage= new PhoneNumber[2*current_length];
			for(int i = 0; i<storage.length;i++)
			{
				new_storage[i] = storage[i];
			}
			new_storage[count] = p;
			storage = new_storage;
			
		}
		else{
			storage[count] = p;
		}
		

		count+=1;
	}

	//
	// Purpose:
	//	return the index where p is in the list, -1 otherwise
	//
	// Pre-Conditions:
	//	none
	//
	// Returns:
	//	position of p in the list - an integer between 0 and size() - 1
	//	-1 if p is not in the list
	//
	// Examples:
	//
	// If x is {"Work:5551212", "Home:4441212", "Cell:3331212"} then
	//
	//	PhoneNumber p = new PhoneNumber("5551212");
	//	PhoneNumber q = new PhoneNumber("3331212");
	//	PhoneNumber r = new PhoneNumber("1234567");
	//
	// 	x.find(p) returns 0
	//	x.find(q) returns 2
	//	x.find(r) returns -1
	//
	public int find (PhoneNumber p)
	{
		for(int i=0;i<count;i++)
		{
			if(storage[i].equals(p))
				return i;
		}
		return -1;
	}
}
