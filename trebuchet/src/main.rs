// Files have to be in the debug folder

// cargo run has to be used in the debug folder

use std::fs::read_to_string;

fn main() {

    let mut result = Vec::new();

    for line in read_to_string("Testing.txt").unwrap().lines(){
        result.push(line.to_string())
    }

    println!("{:#?}", result);



}
