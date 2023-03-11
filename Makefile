# This makefile provides a simple way to build the java programs

# Java compiler
JAVAC = javac

# Java interpreter
JAVA = java

# Flags for Java compiler
JFLAGS = -g

# Source directory
SRCDIR = src/main/java

# Output directory
OUTDIR = bin

# Java source files
SOURCES = $(wildcard $(SRCDIR)/*.java)

# Java class files
CLASSES = $(SOURCES:$(SRCDIR)/%.java=$(OUTDIR)/%.class)

# Default target
all: $(CLASSES)

# Compile Java source files
$(OUTDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) $(JFLAGS) -d $(OUTDIR) $<

# Run Java program
run: $(CLASSES)
	$(JAVA) -cp $(OUTDIR) Main

# Clean up object and class files
clean:
	rm -f $(OUTDIR)/*.class
