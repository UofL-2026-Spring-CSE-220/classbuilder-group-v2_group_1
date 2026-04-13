[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/v7c9ACaT)
# Assignment

This project will provide an opportunity to implement class builder design patterns in Java. This assignment will provide exposure to the following concepts:

* Static methods for utility classes
* Method chaining for builder design patterns
* Unit testing with JUnit
* GitHub workflow autograder
* Enum classes for type safety and readability
* Throwing exceptions for error handling
* Git tags for version control 
* Java Record classes for immutable data structures
* Encapsulation of data
* Usage of `this` keyword for method chaining and clarity

## Project Manager Statement

As the project manager for the small software company contracted to build software for an university, we need to implement a class builder design pattern for our records.  Also, our student record class does not organize information effectively, so we need to refactor the class to encapsulate data better. Specifically, all dates and human personal info should be encapsulated in their own classes.
## Acceptance Criteria

In order to receive full credit for this assignment you must implement the acceptance criteria listed below.

* You do not need to create any extra files.  You will need to modify some of the existing files in the project.
* Some files will be partially implemented. Some classes will have a runnable `main` method for you to reference.
* The `StudentRecord` class must be refactored to use a builder design pattern.
* The `StudentRecord` class must be refactored to also use the encapsulation classes for dates and human personal information.
* The human personal information (name, date of birth, etc.) for the student and parent must be encapsulated in a separate record class with a builder design pattern.
* The date information (enrollment date, birthdate, etc.) must be encapsulated in a separate record class with a builder design pattern.
* All error strings must be defined in an enum class for type safety and readability.
* All error handling must be done with illegal argument exceptions.
* The workflow autograder will not simply run on push. You must create a git tag and push the tag to trigger the autograder workflow.
* A sample file called `main_output.txt` is provided to show the expected output of the `main` method in the `Main` class.  Your implementation of the `main` method must produce the same output as the sample file.
* A sample file called `DateRecord_main_output.txt` is provided to show the expected output of the `main` method in the `DateRecord` class.  Your implementation of the `main` method in the `DateRecord` class must produce the same output as the sample file.
* A sample file called `PersonInfo_main_output.txt` is provided to show the expected output of the `main` method in the `PersonInfo` class.  Your implementation of the `main` method in the `PersonInfo` class must produce the same output as the sample file.
* Analyze the code in `main` method of the `Main` class. Do not change any code in `main` method of the `Main` class.  Your refactoring implementations should align with the code in the `main` method of the `Main` class.  If your implementation does not align with the code in the `main` method of the `Main` class, you will not receive full credit for this assignment.

## Grading Criteria

This assignment is worth 100 points.  Below is a general outline of how points will be assigned for this assignment.

* 10 points for accepting the assignment
* 20 points for making the first commit
* 70 points for passing ALL unit tests on the GitHub workflow autograder

No partial credit will be awarded for any of the categories above.  As a result there are only 4 possible scores for this assignment: 0, 10, 30, or 100.  The only way to receive a score of 100 is to meet all of the acceptance criteria listed above.  You must use git tags to trigger the autograder workflow on GitHub.
