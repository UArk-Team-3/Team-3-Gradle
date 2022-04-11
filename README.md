# Software-Engineering-Team-3-Gradle
 The Gradle build implementation of our project

# How to Run 

In order to run our project locally go to \app\build\libs\ and download "app.jar", then run "javac -jar app.jar" in the same directory as the "app.jar" executable. Dependencies are included in the executable so you shouldn't have to make any additional declarations.

To build the project locally download and install Gradle to your machine and add it to your PATH environment. From there in your cloned Team-3-Gradle directory you can run "gradle build" and "gradle run" in order to build and run our program. 

## Using gradlew

The project can also be run without the installation of gradle by using the standalone gradlew script included in the main directory of the repository.

### Batch

```batch
gradlew build --console=plain
gradlew run --console=plain
```

### Bash

```bash
./gradlew build --console=plain
./gradlew run --console=plain
```

> Note: The option `--console=plain` makes sure that output from the application and output from the gradlew script dont overwrite each other.
