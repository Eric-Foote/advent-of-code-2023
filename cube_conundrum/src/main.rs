use std::fs::read_to_string;
use regex::Regex;
use std::collections::HashMap;

fn main() {

    const max_red: u32 = 12;
    const max_green: u32 = 13;
    const max_blue: u32 = 14;
    let mut result = Vec::new();
    //let mut table = HashMap::new();

    for line in read_to_string("resources/Testing.txt").unwrap().lines(){
        result.push(line.to_string())
    }

    println!("{:#?}", result);

    for (game_id,game) in result.iter().enumerate() {
        let subgame = game.split(";");
        let subgame = subgame.collect::<Vec<_>>();
        for (i,subgames) in subgame.iter().enumerate(){
            let re = Regex::new(r"Game \d:").unwrap();
            let subgames = &re.replace_all(subgames,"");
            let value = subgames.split(",");
            for v in value {
                let v = v.trim_start();
                let Some((key,value)) = v.split_once(" ") else {break;};
                println!("Key:{}\nValue:{}",key,value);

                }
            }
        }
    }

