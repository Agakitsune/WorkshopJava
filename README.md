# workshopJavaApp

## What is Java and what is it used for

Java is a programming language and a platform. Java is a high level, robust, object-oriented and secure programming language.

Java was developed by Sun Microsystems (which is now the subsidiary of Oracle) in the year 1995. James Gosling is known as the father of Java. Before Java, its name was Oak. Since Oak was already a registered company, so James Gosling and his team changed the name from Oak to Java.

*Learn more about Java history at https://www.javatpoint.com/history-of-java*

Platform: Any hardware or software environment in which a program runs, is known as a platform. Since Java has a runtime environment (JRE) and API, it is called a platform.

Java is an object-oriented programming language. Everything in Java is an object. Object-oriented means we organize our software as a combination of different types of objects that incorporate both data and behavior.

Basic concepts of OOPs are:
* Object
* Class
* Inheritance
* Polymorphism
* Abstraction
* Encapsulation

This workshop will not cover all of theses concepts, but feel free to check them out after this workshop !

*Learn more about Java features at : https://www.javatpoint.com/features-of-java*

## Prerequisites

To learn Java, you must have the basic knowledge of C/C++ programming language.

First check if java is installed

```bash
java -version
```

if an error occured, check the `install.md` file

Now that we have the JDK (Java Development Kit; required only for development, coding) and JRE (Java Runtime Environment; required to run Java code and applications) installed, we can now start programming in java.

## Basics of java 

First, we will learn how to write a simple java program;
To create a simple Java program, you need to create a class that contains the main method.

### Step 1 : Creating a program

Create a file named `SimpleApp.java` and add a Java class that contains the main function.
Make it so the main function prints "Hello World!" on the standard output.

By convention, the main function is `public static` and takes a `String args[]` as its argument.
You can make it so it returns `void` or an `int`

The `println` function is contained inside `System.out` class


### Step 2 : Compiling and running the program

Now that we have created a .java file with a class that contains a main function, we can now compile and run it.

To compile a java program we can use the `javac` command (The c in javac means "compiler").

```bash
javac SimpleApp.java
```

We can also use the wildcard symbol to get all the files in a directory

```bash
javac *.java
```

By doing this, a `SimpleApp.class` file has been generated.
Basically, this file contains all the data of the original file as well as the compiled code in machine language.
It's an equivalent to .o or .obj file in C/C++

(*Java is a heavily object oriented language, so it is expected from an application to contain multiple .class files containing a single class.*)

To run the program we can use the `java` command followed by a class containing a main function.

```bash
java SimpleApp
```

It won't work if we put the file extension as argument. It will be like if we write

```bash
java SimpleApp.class.class
```

Note that I said *a class containing a main function* because it's totally possible for an application to conrain mulple classes containing a main function.

The expected output should be :

```text
Hello World!!
```

## Simple Application in java

Now that you know how to run a java program we will now create a desktop application using the JavaFX library.
The prerequisites for creating this application are `maven` and `IntelliJ Idea IDE`.
If you do not have theses, check the `install.md` file.

Under this directory you will notice the following *standard project structure*.

```text
WorkshopJava-app
|-- pom.xml
`-- src
    |-- main
    |   `-- java
    `-- test
        `-- java
```

The `src/main/java` directory contains the project source code, the `src/test/java` directory contains the test source, and the `pom.xml` file is the project's Project Object Model, or POM.

The `pom.xml` file is the core of a project's configuration in Maven.
It is a single configuration file that contains the majority of information required to build a project in just the way you want.
The POM is huge and can be daunting in its complexity, but it is not necessary to understand all of the intricacies just yet to use it effectively.

Add theses lines to your `pom.xml` to load FXGL

```xml
    <dependencies>
        <dependency>
            <groupId>com.github.almasb</groupId>
            <artifactId>fxgl</artifactId>
            <version>17.2</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.0.2</version>
                <configuration>
                    <release>17</release>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

### Creating a Java Application using FXGL

FXGL is a JavaFX Game Development Framework

*(Learn more about it : https://github.com/AlmasB/FXGL)*


#### Step 1 Create the application

**In the App.java file, add the following line to import FXGL application class :**

```java
import com.almasb.fxgl.app.GameApplication;
```

**Make the `App` class inherit from `GameApplication`**

In Java, we use the `entends` keyword to make a class inherit from another class.

**Then, override the `initSettings` method. This method take a `GameSettings` class as arguments.**

In Java, we use the `@Override` keyword to override an inherited method.

```java
    @Override
    public void Do_something(int nb) { ... }
```

**Change the settings so that the window's dimensions are set to 800x600 and the title is `WorkshopJava`**

In you app's main method, call the `launch` method with the main's arguments a parameters. 

Now we can launch the application :

```bash
mvn compile
```
This command will (as you've guessed) compile the project based on the infos in the `pom.xml` file.
The outpur program is find by default in the `/target/` directory.
If there is an error during compilation, call the Workshop guy.

```bash
mvn package
```
This command will create a `.jar` file (an executable java file)

We can also use 

```bash
mvn exec:java
```
To execute the program.

Or you can simply run your program from IntelliJ Idea IDE.

#### Step 2 Adding an entity

In your App class, add an `Entity` named `player`;

**Override the `initGame` method and use it to assign a value to your `player` entity.**

*InitGame is where you set up all the stuff that needs to be ready before the game starts.*

we can use the `FXGL.entitybuilder` function to create an entity

```java
FXGL.entityBuilder()
    .at(pos_x, pos_y)
    .view(new Rectangle(25, 25, Color.BLUE))
    .buildAndAttach();
```

`buildAndAttach` is for creating and adding entities to a scene.

Now if we run our program we can see our entity as a blue rectangle.

#### Step 3 Adding inputs

To add input we must override the `initInput` method

To add an input, we can use the `FXGL.onKeyDown` method

```java
FXGL.onKeyDown(KeyCode.SPACE, () -> {
    Do_something();
});
```

**Add inputs so that your player can move in all four directions.**


#### Step 4 Adding an ennemy entity

Now that we have a player, we also need an enemy.

**Add an ennemy entity with a red rectangle**

#### Step 4.1 Adding a factory

To create multiple enemies, we can create a factory.

**Create a new java class named `Factory` that implements the `EntityFactory` interface**

In this class, add a `newEnemy` method that takes `SpawnData` as parameters and returns an `Entity`.

Add `@Spawns("enemy")` to make it easier to create an entity.

replace `buildAndAttach` by `build` or else the entity won't show when we spawn it.

```java
    @Spawns("enemy")
    public Entity newEnemy(SpawnData data) {

        return FXGL.entityBuilder(data)
                .view("...")
                .build();
    }
```

Now, to actually spawn an enemy, we can use the `FXGL.spawn()` method.

Give it the entity name as string as first argument and his `x` and `y` pos for second and third args.


#### Step 5 Add a UI

**Now, override the `InitUI` method and add a new `Text` element.**

We can use the `FXGL.getGameScene().addUINode()` method to add the text to the scene.

You can use the member methods `setTranslateX()` and `setTranslateY()` to move the position of the text.


#### Step 6 Add game variables

**Now, override the `initGameVars` method**

```java
@Override
protected void initGameVars(Map<String, Object> vars) {
    vars.put("pixelsMoved", 0);
}
```

Now, you can update the inputs so it calls the `FXGL.inc()` method with the name of your game variable as first arg and a value to increment as second argument (*+1* for example).


In the initUI method, add this line to bind your game variable with the text :

```java
textPixels.textProperty().bind(FXGL.getWorldProperties().intProperty("pixelsMoved").asString());
```

`textPixels` being the name of your Text variable

#### Step 7 Adding some textures

Using rectangles to represent entities is fun, but it's better when they have different textures to differentiate them easier.

Create `assets/textures/` subdirectories in the `ressources/` directory.

We add our images here so when we simply specify the name of the image, FXGL will automatically search for it in this folder.

**Replace the player's texture by your image by modifying the `.view()` method**

You can do it for your ennemies too.

#### Step 8 Adding components to an entity

Any game object that you can think of (player, coin, power-up, wall, etc...) is an entity.
By itself an entity is nothing but a generic object.
Components allow us to shape that entity to be anything we like.

To add components to an entity, we can either call the `with()` method when we create the entity or call the `addComponent()` method directly on the entity.

We can also remove a component by calling the `removeComponent()` with the component class you want to remove as parameters.

**Add a `ProjectileComponent` to your player entity. One for each direction when we press the corresponding input.**

ProjectileComponent does just like you think. It rotates your entity and make it move automatically in a direction.
To set the direction, we pass a `Point2D(x, y)` as parameters. The second parameter is to specify the speed in px/sec *(I guess)*


**Here, you can find other components you can add to entities : https://www.javadoc.io/doc/com.github.almasb/fxgl/0.5.0/com/almasb/fxgl/extra/entity/components/package-summary.html !**


#### Step 9 Adding collision between entities

There is a few steps before adding a collision system to our application.

First, we will create an enum to make this step easier.

**Create an enum `EntityType`**

When creating an entity, add the `.type()` method with an EntityType as parameter.

Then, change the `view()` method to `viewWithBBox()`. This will generate a bounding box that match the size of te entity.

Finally, add a `CollidableComponent` to the entity.


Now it's time to add some physics to our application.

First we need to override the `initPhysics()` method in our Application.

Call the `onCollisionBegin()` method in it.

```Java
onCollisionBegin(EntityType.BOSS, EntityType.BASE, (boss2, base13) -> {
    Do_something(boss2, base13);
});
```

### To go even further

Now you have the basics to create your own game application with FXGL.

That's basically it for this workshop. I mean... Yeah...

Feel free to customize your application or even check other features of FXGL at https://github.com/AlmasB/FXGL/wiki/FXGL-11 !

You can add some cool features such as **Adding audio and video**, **Adding sprite animations**, **Adding time-specific actions**, **Build a level using Tiled map editor** and much more !


