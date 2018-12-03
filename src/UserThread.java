import java.io.*;

public class UserThread extends Thread
{
	final int id;
	final File file;
	StringBuffer line;
	StringBuffer fileName;
	int disk_number;

	public UserThread(int i)
	{
		id = i;
		String temp = System.getProperty("user.dir");
    	file = new File(temp + "/inputs/USER" + id);
		line = new StringBuffer();
	}

	public void run()
	{
		try
		{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String l = null;
			while((l = br.readLine()) != null)
			{
				line.setLength(0);
				line.append(l);
				
				if(line.toString().startsWith(".save"))
				{
					fileName = new StringBuffer(line.substring(6));
					disk_number = Main.disk_allocation.request();
					System.out.println("Saving file "+fileName.toString()+" to disk "+(disk_number + 1));
				}
				else if(line.toString().startsWith(".print"))
				{
					PrintJobThread pjt = new PrintJobThread(line.substring(7));
					pjt.start();
				}
				else if(line.toString().startsWith(".end"))
				{
					System.out.println("Saved file to "+fileName.toString()+" to disk "+(disk_number + 1));
					fileName = null;
					Main.disk_allocation.release(disk_number);
				}
				else if(fileName != null)
				{
					Disk disk = Main.disk[disk_number];
					FileInfo info = Main.disk_manager.getFileInfo(fileName);
					if(info == null) 
					{
                        info = new FileInfo();
                        info.diskNumber = disk_number;
                        info.fileLength = 1;
                        info.startingSector = Main.disk_manager.getFreeSector(disk_number);
                        Main.disk_manager.createFile(fileName, info);
                        disk.write(info.startingSector,line);
                        System.out.println("Writing " + line);
                        Thread.sleep(200);
                    }
                    else 
                    {
                        int nextFreeSector = Main.disk_manager.getFreeSector(disk_number);
                        info.fileLength = info.fileLength+1;
                        disk.write(nextFreeSector,line);
                        System.out.println("Writing " + line);
                        Thread.sleep(200 );
                    }
				}
				
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
