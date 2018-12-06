import java.io.*;
import javafx.scene.paint.Color;


public class PrintJobThread extends Thread
{
	StringBuffer file;
	int uid;
	PrintJobThread(String filename, int userId)
	{
		file = new StringBuffer(filename);
		uid = userId;
	}
	
	@Override
	public void run()
	{
		FileInfo info = Main.disk_manager.getFileInfo(file);
		Disk disk = Main.disk[info.diskNumber];
		Main.u[uid].setFill(Color.RED);

		int printID = Main.printer_allocation.request();
		Printer printer = Main.printers[printID];

		Main.p[printID].setFill(Color.RED);
		System.out.println("Printing "+ file.toString() + " to printer number "+(printID+1));
		Main.data[uid][printID+2].setStroke(Color.BLACK);

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
		System.out.println("Printed "+ file.toString() + " to printer number "+(printID+1));
		Main.p[printID].setFill(Color.GREEN);
		Main.u[uid].setFill(Color.GREEN);
		Main.data[uid][printID+2].setStroke(Color.WHITE);
		Main.printer_allocation.release(printID);
	}
}