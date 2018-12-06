JFLAGS = -g -cp src
JC = javac
JVM = java
.SUFFIXES: .java .class
.java.class: 
	$(JC) $(JFLAGS) $*.java

CLASSES = \
 src/DirectoryManager.java \
 src/Disk.java \
 src/DiskManager.java \
 src/FileInfo.java \
 src/Main.java \
 src/Printer.java \
 src/PrintJobThread.java \
 src/ResourceManager.java \
 src/UserThread.java

MAIN = Main

default: classes run

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) -cp src $(MAIN)

clean: 
	$(RM) ./src/*.class
	$(RM) ./outputs/*
