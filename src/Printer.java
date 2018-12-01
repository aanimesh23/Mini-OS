import java.io.*;

public class Printer
{
	final File file;
	int id;
	public Printer(int i)
	{
		id = i;
		String temp = System.getProperty("user.dir");
    	file = new File(temp + "/outputs/PRINTER" + id);
	}

	public void print(StringBuffer l)
	{
		try
		{
			if(file.exists())
			{
				file.createNewFile();
			}
			FileWriter f = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write(l.toString());
			bw.newLine();
			bw.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
