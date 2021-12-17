package parse;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.Random;

public class parse {
    

    private static Map<String, String> map;

    public static void read_file(){

        map = new HashMap<String, String>();

        try {
            File file = new File("parse.txt");
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] gline = data.split("::=");
                map.put(gline[0], gline[1]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            
        }
    }
  
	private static String Random(String x) {

		if(!map.containsKey(x)) {
			return x + " ";
		}
		
		String non_t = map.get(x);
		
		String[] sp = non_t.split("\\|+");
		 
		int Rand_Index = new Random().nextInt(sp.length);
        
		String choice = sp[Rand_Index];
		
		String[] token = choice.split("\\s+");
		
		StringBuilder result = new StringBuilder();
		for (String i : token) {
			result.append(Random(i));
		}
		
		return result.toString();
	}

	  private static String Random() {

		return Random("<s>");
	}
	
    public static void main(String[] args){

        read_file();
        String result = parse.Random();
        System.out.println(result);
    }
}