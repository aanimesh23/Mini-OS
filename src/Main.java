import java.io.*;
// import java.nio.file.Files;
// import java.nio.file.Path;
import java.util.List;


class Main
{
    private static final int NUMBER_OF_USERS = 4;
    private static final int NUMBER_OF_DISKS = 2;
    private static final int NUMBER_OF_PRINTERS = 3;

    public static final Disk[] disk = new Disk[NUMBER_OF_DISKS];
    public static final Printer[] printers = new Printer[NUMBER_OF_PRINTERS];
    public static final UserThread users[] = new UserThread[NUMBER_OF_USERS];

    public static final DiskManager disk_manager = new DiskManager(NUMBER_OF_DISKS);
    public static final ResourceManager disk_allocation = new ResourceManager(NUMBER_OF_DISKS);
    public static final ResourceManager printer_allocation = new ResourceManager(NUMBER_OF_PRINTERS);

    static {
        for(int i = 1; i <= disk.length; i++) {
            disk[i-1] = new Disk(15360,i);
        }
        for(int i = 1; i <= printers.length; i++) {
            printers[i-1] = new Printer(i);
        }
        for(int i = 1; i <= users.length; i++) {
            users[i-1] = new UserThread(i);
        }
    }

	public static void main(String[] args)
	{
        for(int i = 0; i < users.length; i++) {
            users[i].start();
        }

          
    }
}
