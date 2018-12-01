import java.io.*;

public class PrintJobThread extends Thread
{
	StringBuffer file;
	PrintJobThread(String filename)
	{
		file = new StringBuffer(filename);
	}
	
	@Override
	public void run()
	{
		FileInfo info = Main.disk_manager.getFileInfo(file);
		Disk disk = Main.disk[info.diskNumber];

		int printID = Main.printer_allocation.request();
		Printer printer = Main.printers[printID];

		System.out.println("Printing "+ file.toString() + " to printer number "+printID);

		for(int i = 0; i < info.fileLength; i++)
		{
			StringBuffer line = new StringBuffer();
			line.setLength(0);
			//reading line rn

			try
			{
				disk.read(info.startingSector + i, line);
				Thread.sleep(200);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			//Writing to printer
			try
			{
				printer.print(line);
				Thread.sleep(2750);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Printed "+ file.toString() + " to printer number "+printID);
		Main.printer_allocation.release(printID);
	}
}