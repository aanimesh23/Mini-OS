class Disk
{
	static final int NUM_SECTORS = 1024;
	StringBuffer sectors[];
	final int s_size;
	final int id;

	public Disk(int size, int index)
	{
		sectors = new StringBuffer[NUM_SECTORS];
		s_size = size / NUM_SECTORS;
		for(int i =0; i < NUM_SECTORS; i++)
		{
			sectors[i] = new StringBuffer(s_size);
		}
		id = index;
	}
	void write(int sector, StringBuffer data)
	{
		sectors[sector].setLength(0);
		sectors[sector].append(data);
	}
	void read(int sector, StringBuffer data)
	{
		data.append(sectors[sector]);
	}
	void print()
	{
		for(int i = 0; i < NUM_SECTORS; i++)
		{
			System.out.println(sectors[i].toString());
		}
	}
}

