# Java compiler
JAVAC = javac

# Java compiler flags
JFLAGS = 

# Directory for source files
SRCDIR = .

# Directory for compiled .class files
BINDIR = .

# List of Java source files
SOURCES = $(wildcard $(SRCDIR)/*.java)

# List of class files
CLASSES = $(SOURCES:.java=.class)

# Main target (default)
all: $(CLASSES)

# Rule to compile .java files into .class files
%.class: %.java
	$(JAVAC) $(JFLAGS) $<

# Rule to clean compiled files
clean:
	rm -f $(BINDIR)/*.class
	find . -name '*~' -delete

.PHONY: all clean

