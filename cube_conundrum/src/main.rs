use std::fs::read_to_string;
use regex::Regex;

fn main() {

    const max_red: u32 = 12;
    const max_green: u32 = 13;
    const max_blue: u32 = 14;
    let mut result = Vec::new();

    for line in read_to_string("resources/Testing.txt").unwrap().lines(){
        result.push(line.to_string())
    }

    println!("{:#?}", result);

    for (game_id,game) in result.iter().enumerate() {
        let subgame = game.split(";");
        let subgame = subgame.collect::<Vec<_>>();
        for (i,subgames) in subgame.iter().enumerate(){
            let subgames = subgames.replace("Game","");
            let colour = subgames.split(", ");
            for c in colour {
                let re = Regex::new(r" \d:").unwrap();
                let c = &re.replace_all(c, "");
                println!{"{:#?}", c}

                }
            }
        }
    }

