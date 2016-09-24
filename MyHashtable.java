/*
 * Alex Thoennes
 * 
 * Dr. Bishop
 * 
 * Assignment 3
 */
public class MyHashtable
{
	public static void main(String [] args)
	{
		Hashtable hash = new Hashtable();
		hash.insert(1);
		hash.insert(5);
		hash.insert(28);
		hash.delete(5);
		hash.insert(15);
		hash.insert(8);
		hash.dumpHash();
		hash.delete(1);
		hash.insert(18);
		hash.insert(25);
		hash.delete(33);
		hash.dumpHash();
	}
}