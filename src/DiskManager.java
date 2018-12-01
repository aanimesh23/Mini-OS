public class DiskManager
{
	DirectoryManager dm;
	int[] freeSector;

	DiskManager(int n)
	{
		dm = new DirectoryManager();
		freeSector = new int[n];
	}
	public synchronized FileInfo getFileInfo(StringBuffer buffer) {
        return dm.lookup(buffer);
    }

    public synchronized void createFile(StringBuffer fileName, FileInfo info) {
        dm.enter(fileName, info);
    }
	public int getFreeSector(int i) {
        int free = freeSector[i];
        freeSector[i] += 1;
        return free;
    }
    public void print()
    {
    	dm.print();
    }
}