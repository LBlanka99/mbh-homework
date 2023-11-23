# Passphrase Validator
<a name="readme-top"></a>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About the project</a>
      <ul>
        <li><a href="#rules">Rules</a></li>
        <li><a href="#tests">Tests</a></li>
      </ul>
    </li>
    <li>
      <a href="#built-with">Built with</a>
    </li>
    <li>
      <a href="#getting-started">Getting started</a>
		 <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#how-to-start-the-project">How to start the project</a></li>
     </ul>
    </li>
  </ol>
</details>

## About the project
This project implements a password validation system using passphrases instead of traditional passwords. Passphrases consist of words separated by spaces and end with a punctuation mark (? or ! or .).

The program reads password phrases from an input file (input.txt), counts the number of correct password phrases, and outputs the result to the console.

### Rules
The program validates passphrases based on the following criteria:
- consists of more than one word
- ends with exactly one punctuation mark (? or ! or .)
- does not contain duplicate words
- words contain only lowercase English alphabet characters
- only contains spaces between words, and even then exactly one

There is an atomic validator for each rule and each validator checks the correctness of the password only according to its own responsibility.

(The order of the validators does not matter, the result is always the same, albeit there are more logical orders. For example it is recommended to check for unnecessary spaces before checking the number of words, or to check the ending punctuation before searching for duplicate words.)

### Tests
The project contains also some tests to cover different cases for each passphrase validator and the input checker. They ensure that the validators correctly identify valid and invalid passphrases according to the specified rules.

You can find the tests in the "src/test/java" directory.

## Built with
  * [![Java][java]][java-url] 
  * [![IntelliJ IDEA][intelliJ]][intelliJ-url]

## Getting started

### Prerequisites
- Java Development Kit (JDK) - <a href="https://www.oracle.com/java/technologies/downloads/">Download JDK here</a>

### How to start the project
1. Clone the project repository to your local machine:
   ```sh
   git clone git@github.com:LBlanka99/mbh-homework.git
   ```
2. Open the project in your preferred IDE
3. Run the project:
   - find the main class in "src/main/java/com/blanka/passwordchecker/Application.java"
   - right-click on the file and select "Run 'Application.main()'"

  
### How to run the project in terminal
1. Clone the project repository to your local machine:
   ```sh
   git clone git@github.com:LBlanka99/mbh-homework.git
   ```
2. Open terminal and navigate to the directory where you cloned the project:
   ```sh
   cd /path/to/the/mbh-homework
   ```
3. Compile all specified Java source files and place the resulting bytecode files into the out/ directory:
   ```sh
   javac -d out/ src/main/java/com/blanka/passwordchecker/Application.java src/main/java/com/blanka/passwordchecker/data/TxtReader.java src/main/java/com/blanka/passwordchecker/logic/CorrectPasswordCalculator.java src/main/java/com/blanka/passwordchecker/logic/inputchecker/InputChecker.java src/main/java/com/blanka/passwordchecker/logic/rules/*.java src/main/java/com/blanka/passwordchecker/ui/Screen.java
   ```
4. Execute the program:
   ```sh
   java -cp out com.blanka.passwordchecker.Application
   ```

<!-- MARKDOWN LINKS -->
[java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[java-url]: https://www.java.com/en/
[intelliJ]: https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white
[intelliJ-url]: https://www.jetbrains.com/idea/
