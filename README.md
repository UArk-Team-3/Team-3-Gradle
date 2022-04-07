# Software-Engineering-Team-3-Gradle
 The Gradle build implementation of our project

# How to Run 

In order to run our project locally go to \app\build\libs\ and download "app.jar", then run "javac -jar app.jar" in the same directory as the "app.jar" executable. Dependencies are included in the executable so you shouldn't have to make any additional declarations.

To build the project locally download and install Gradle to your machine and add it to your PATH environment. From there in your cloned Team-3-Gradle directory you can run "gradle build" and "gradle run" in order to build and run our program. 

## Using gradlew

The project can also be run without the installation of gradle by using the standalone gradlew script included in the main directory of the repository. It will be built automatically with `gradlew build` before running.

### Batch

```batch
gradlew run
```

### Bash

```bash
./gradlew run
```

> Note: Depending on the IDE that's being used, this may result in obfuscated output printing to the terminal, so best practice would be to run the command from outside of the IDE being used.
