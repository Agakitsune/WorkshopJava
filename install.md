# Install a java sdk on your machine

Java is a popular programming language that allows you run programs on many platforms, including Fedora. If you want to create Java programs, you need to install a JDK (Java Development Kit).

There are 2 main sdk for java

OpenJDK — an open-source implementation of the Java Platform, Standard Edition. This version is preferred, and included in Fedora.

Oracle Java SE — a free JDK from Oracle. This version is not open-source and we recommend that it only be used if OpenJDK is not sufficient.

To install OpenJDK from the Fedora repository run the following command to list available versions:

```bash
dnf search openjdk
```

But since doing this is too boring, just type the following command to install OpenJDK :

```bash
sudo dnf install java-17-openjdk-devel.x86_64
```

Wait for the installation to finish and... There we go! Now we're ready to program in Java!

# Install IntelliJ idea IDE and maven

## IntelliJ installation

IntelliJ IDEA Community Edition is a free and open-source edition of IntelliJ IDEA, the commercial Java IDE by JetBrains.
IntelliJ IDEA Community Edition provides all the tools you need for Java, Groovy, Kotlin, Scala, and Android.
It offers instant and clever code completion, on-the-fly code analysis, and reliable refactoring tools.

We will install IntelliJ Idea IDE from the snap store.

First, check if you have snap installed.

```bash
snap --version
```

Then, use the following command to install IntelliJ :

```bash
sudo snap install intellij-idea-community --classic
```
After the install, it should appear in your application list.

## maven installation
Apache Maven is a software project management and comprehension tool.
Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.
You can think of Maven as a CMake tool but for java projects.

Use the following command to install maven :

```bash
sudo dnf install maven-openjdk17.noarch
```
