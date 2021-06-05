# HyperSkill-Bulls-And-Cows
# Stage 7/7
# Description

There are a lot of error possibilities. What if someone enters an answer of the wrong length? Or the number of possible symbols is less than the length of the code? What if the answer contains invalid symbols? The game may crash before the secret number was guessed!

Let's handle errors like this. At this point, you can implement this without the try catch construction. Use the following rule of thumb: if you can avoid the exception-based logic, avoid it! If you use exceptions in normal situations, how would you deal with unusual (exceptional) situations? Now it may not seem that important, but when you need to find errors in more complex programs, this makes a difference.
Objectives

In this stage, your program should:

    Handle incorrect input.
    Print an error message that contains the word error. After that, don't ask for the numbers again, just finish the program.

Examples

The greater-than symbol followed by a space > represents the user input. Note that it's not part of the input.

Example 1

Input the length of the secret code:
> 6
Input the number of possible symbols in the code:
> 5
Error: it's not possible to generate a code with a length of 6 with 5 unique symbols.

Example 2

Input the length of the secret code:
> abc 0 -7
Error: "abc 0 -7" isn't a valid number.

Example 3

Input the length of the secret code:
> 6
Input the number of possible symbols in the code:
> 37
Error: maximum number of possible symbols in the code is 36 (0-9, a-z).

Example 4

Input the length of the secret code:
> 4 <br>
Input the number of possible symbols in the code: <br>
> 12 <br>
The secret is prepared: **** (0-9, a-b). <br>
Okay, let's start a game! <br>
Turn 1: <br>
> a234 <br>
Grade: 1 bull and 1 cow <br>
Turn 2: <br>
> 73b4 <br>
Grade: 2 bulls and 1 cow <br>
Turn 3: <br>
> 9374 <br>
Grade: 4 bulls <br>
Congratulations! You guessed the secret code. <br>
