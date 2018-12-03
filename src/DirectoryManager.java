import java.util.*;

class DirectoryManager
{
	Hashtable<String, FileInfo> T = new Hashtable<String, FileInfo>();
	void enter(StringBuffer key, FileInfo file)
	{
		String m = key.toString();
		T.put(m, file);

	}
	FileInfo lookup(StringBuffer key)
	{
		String m = key.toString();
		return T.get(m);
	}
	void print()
	{
		System.out.println(T);
	}
}

