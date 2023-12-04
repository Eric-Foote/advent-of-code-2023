/* 											--- Day 1: Trebuchet?! ---
 * Something is wrong with global snow production, and you've been selected to take a look. The Elves have even given you a map; on it, they've used stars to mark the top fifty locations that are likely to be having problems.
 * You've been doing this long enough to know that to restore snow operations, you need to check all fifty stars by December 25th.
 * Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
 * You try to ask why they can't just use a weather machine ("not powerful enough") and where they're even sending you ("the sky") and why your map looks mostly blank ("you sure ask a lot of questions") and hang on did you just say the sky ("of course, where do you think snow comes from") when you realize that the Elves are already loading you into a trebuchet ("please hold still, we need to strap you in").
 * As they're making the final adjustments, they discover that their calibration document (your puzzle input) has been amended by a very young Elf who was apparently just excited to show off her art skills. Consequently, the Elves are having trouble reading the values on the document.
 * The newly-improved calibration document consists of lines of text; each line originally contained a specific calibration value that the Elves now need to recover. On each line, the calibration value can be found by combining the first digit and the last digit (in that order) to form a single two-digit number.

											For example:

											1abc2
											pqr3stu8vwx
											a1b2c3d4e5f
											treb7uchet

							In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.

 * Consider your entire calibration document. What is the sum of all of the calibration values?
 *
 *
 * The first half of this puzzle is complete! It provides one gold star: *
 * 											--- Part Two ---
 * Your calculation isn't quite right. It looks like some of the digits are actually spelled out with letters: one, two, three, four, five, six, seven, eight, and nine also count as valid "digits".
 * Equipped with this new information, you now need to find the real first and last digit on each line. 
 
  											For example:

											two1nine
											eightwothree
											abcone2threexyz
											xtwone3four
											4nineeightseven2
											zoneight234
											7pqrstsixteen

 * In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces 281.
 *
 * What is the sum of all of the calibration values?
/*

/* Author: Eric Foote
 * Code prompt comes from https://adventofcode.com/2023/day/1
 */

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Trebuchet
{
	public static void main (String[] args){
		ArrayList <String> input = new ArrayList <String>();
		String intermediateStep;
		int sum = 0;
		int left = 0;
		int right = 0;
		int value = 0;
		try{ // This block of code inputs the file but makes sure first that the file exists
			File file = new File("Testing2.txt");
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()){
				input.add(scan.nextLine());
			}
			} catch (Exception e){
			System.out.println("ERROR");
			e.printStackTrace();
			}
		for(int i = 0; i < input.size(); i++){
			String current = input.get(i);
			System.out.println(current);
			/*
			 * RIGHT HERE IS WHERE PART 2's WORK IS GOING TO HAVE TO BE DONE
			 */
			char[] currentArray = current.toCharArray(); // Takes each line of input and breaks it into an array of the individual characters
			for(int j = 0; j < currentArray.length; j++)
			{ // Iterate over each individual character
				if(Character.isDigit(currentArray[j]))
						{	if(left == 0) 
								left = Character.getNumericValue(currentArray[j]); // Extracts the numeric value of the character
							else
								right = Character.getNumericValue(currentArray[j]);
						}

			}
			if (right == 0) // This case is to make sure that if one character exists on the line
				right = left;
			intermediateStep = "" + left + right; // This is needed in order to glue the integers together
			value = Integer.parseInt(intermediateStep);
			sum += value;
			left = 0; // Resets the value for the next iteration of the loop
			right = 0;			
		}	
	System.out.println("The sum is " + sum);
	}
}
