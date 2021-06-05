# HyperSkill-Bulls-And-Cows
# Stage 6/7
# Description

Some players need a challenge, so let's make the secret code in the game harder to guess. Add support for more than 10 symbols by adding letters. Now, the secret code can contain the numbers 0-9 and the lowercase Latin characters a-z. The new maximum length for the code is 36. Note that the length of the secret word may not match the number of possible characters in the secret code, so you should request t input twice: once for the secret code length and once for the number of possible characters.

Also, since a secret code is not a number anymore, the symbol 0 should be allowed as the first character in a secret code.
Objectives

In this step, your program should:

    Ask for the length of the secret code.
    Ask for the range of possible characters in the secret code.
    Generate a secret code using numbers and characters. This time, you should also print the secret code using * characters and print which characters were used to generate the secret code.
    Function as a fully playable game.

Example

The greater-than symbol followed by a space > represents the user input. Note that it's not part of the input.

Input the length of the secret code:
> 4 <br>
Input the number of possible symbols in the code:<br>
> 16<br>
The secret is prepared: **** (0-9, a-f).<br>
Okay, let's start a game!<br>
Turn 1:<br>
> 1a34<br>
Grade: 1 bull and 1 cow <br>
Turn 2:<br>
> b354<br>
Grade: 2 bulls and 1 cow<br>
Turn 3:<br>
> 93b4<br>
Grade: 4 bulls<br>
Congratulations! You guessed the secret code.<br>
