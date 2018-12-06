class FileInfo
{
	int diskNumber;
	int startingSector;
	int fileLength;

	public void print()
	{
		System.out.println("Disk Number: "+ diskNumber + " Starts at "+ startingSector + "ends after "+fileLength + " blocks");
	}
}

