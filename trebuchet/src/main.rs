// Files have to be in the debug folder

// cargo run has to be used in the debug folder

use std::fs::read_to_string;

fn main() {
    let mut left = '0';
    let mut right = '0';
    let mut sum: u32 = 0;
    let mut result = Vec::new();

    for line in read_to_string("resources/input.txt").unwrap().lines() {
        result.push(line.to_string())
    }

    println!("{:#?}", result);

    for (i, _x) in result.iter().enumerate() {
        let resultant = &result[i]
            .replace("one", "o1e")
            .replace("two", "t2o")
            .replace("three", "t3e")
            .replace("four", "f4r")
            .replace("five", "f5e")
            .replace("six", "s6x")
            .replace("seven", "s7n")
            .replace("eight", "e8t")
            .replace("nine", "n9e");
        let chars: Vec<char> = resultant.chars().collect();
        for c in &chars {
            if c.is_numeric() {
                left = *c;
                break;
            }
        }
        for c in chars.iter().rev() {
            if c.is_numeric() {
                right = *c;
                break;
            }
        }

        let mut intermediate = String::from("");
        intermediate.push_str(&left.to_string());
        intermediate.push_str(&right.to_string());
        println!("{intermediate}");

        let intermediate_value: u32 = intermediate.trim().parse().unwrap();
        sum = sum + intermediate_value;
    }
    println!("{sum}");
}
