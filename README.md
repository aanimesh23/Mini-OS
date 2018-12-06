# Mini-OS

Directory Description

141OS/
	-src/
		- DirectoryManager.java
		- Disk.java
		- DiskManager.java
		- FileInfo.java
		- Main.java
		- Printer.java
		- PrintJobThread.java
		- ResourceManager.java
		- UserThread.java
	- inputs/
		- USER1
		- USER2
		- USER3
		- USER4
	- outputs/
		- PRINTER1
		- PRINTER2
		- PRINTER3
	- resources/
		- christmas.png
		- disk.png
		- printer.png
		- user3.png
	- Makefile
	- README.md


The program starts running when the Makefile in run in the 141OS/ folder. This is done by calling

	$ make

This compiles all the java files to binary and runs the Main executable. Main executable creates static objects of Disk, Printer, UserThread. It also statically makes an object for DiskManager, and 2 objects of ResourceManager, which are used to allocate resources like disks and printers.

Main also implements the entire GUI, and creates objects for different lines, shapes and images in JavaFX. 
In the public static void main(String[] args) function, GUI is launched, and when the start button is clicked the UserThreads are started to execute.


Class Name
:- Role and Relationships


DirectoryManager.java
Initializes a Hashtable which stores filename(string) as the key and data type FileInfo as the value.
It also defines defines functions to lookup and add to Hashtable.

Disk.java
Takes in a Disk number and writes or reads a particular sector on the disk
Initializes a Disk with 1024 Sectors, with a total capacity defined by the User.

DiskManager.java
It helps add files to Directory manager and lookup files.
This is done using synchronized functions. It also keeps track of which is the next empty sector in the specified disk. 
As the name suggests it helps manage the disk and retrieve information correctly.

FileInfo.java
Creates a datatype to store diskNumber, startingSector and fileLength for each file. 

Printer.java
Takes in a printer number and writes a line to the printer.

PrintJobThread.java
It is initialized with file name, and manges the printer to print the particular file.
Looks up file using DiskManager
Retrieves Disk Number from FileInfo
Requests a free printer from RescourceManager printer object.
Reads all line from the Disk at which the file is saved. And delays 200ms for each line.
Writes the entire file to the assigned printer and delays the thread for 2750ms for each line it writes.
Releases the requested printer to other threads. 

ResourceManager.java
Manages the number of resources initialized to it.
Allocates a resources with the request function and blocks others to access it.
Releases the allocated resources and available to other threads when not in use anymore.

UserJobThread.java
Reads USERi files to recognizes .save, .end and .print commands and also lines to be written to a file
At .save, thread requests a disk to write into
At .end thread releases the requested disk
At .print it creates a new thread by making a printjobthread object and prints the specified file
Otherwise it writes the lines to the open file created at .save
 

UserJobThread.java and PrintJobThread.java manage concurrency by the use of threads. They extend the Thread class and Threads can run concurrently in Java program, With the help of this we are able to initialize multiple threads which run and start concurrently. We also use synchronized functions in DiskManager and ResourceManager to help maintain mutual exclusiveness, that is only on thread is able to access this function at a moment and other threads have to wait for the function to be ideal to be able to access it and use it. 

Synchronized blocks in Java are marked with the synchronized keyword. A synchronized block in Java is synchronized on some object. All synchronized blocks synchronized on the same object can only have one thread executing inside them at the same time. All other threads attempting to enter the synchronized block are blocked until the thread inside the synchronized block exits the block.
