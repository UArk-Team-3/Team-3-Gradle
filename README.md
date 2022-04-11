# Software-Engineering-Team-3-Gradle
 The Gradle build implementation of our project

# How to Run 

In order to run our project locally go to \app\build\libs\ and download "app.jar", then run "java -jar app.jar" in the same directory as the "app.jar" executable. Dependencies are included in the executable so you shouldn't have to make any additional declarations. 

To build the project locally download and install Gradle to your machine and add it to your PATH environment. From there in your cloned Team-3-Gradle directory you can run "gradle build" and "gradle run" in order to build and run our program. 

## Network Traffic

Network traffic is recieved on port 7501. Inputs should be formatted as "#:#" where # is a number between 0-30 and indicates "# hit #". A valid input is one where the value on the left is between 0-14 and the value on the right is 15-30 or vice versa. Red team ID's are 15-30, where 15 is the first entry box listed on the entry screen. Green team ID's are 0-14 where 0 is the first entry box listed. If an invalid ID is passed it will not accept an action. The ID must be valid and the ID must match to an entry box. 

## Entry Screen

Each team has two text boxes for player information entry. The first box is for first and last name, the second box is for codename, the first three codenames for each team will be displayed on the action screen. The checkbox for each player entry must be checked in order for the name to be in the game.

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
