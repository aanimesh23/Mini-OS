import java.util.*;

class DirectoryManager
{
	Hashtable<StringBuffer, FileInfo> T = new Hashtable<StringBuffer, FileInfo>();
	void enter(StringBuffer key, FileInfo file)
	{
		T.put(key, file);
	}
	FileInfo lookup(StringBuffer key)
	{
		return T.get(key);
	}
	void print()
	{
		System.out.println(T);
	}
}

