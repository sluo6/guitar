package synthesizer;

import java.util.ArrayList;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.introcs.StdDraw;

/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
public class GuitarHero {
	
	public static int arrayIndex(char[] keys, char key) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] == key) {
			return i;
			}
		}
	}
	
	
   

    public static void main(String[] args) {
    	
    	/*Create an array of GuitarStrings*/
    	ArrayList<GuitarString> keyboard = new ArrayList<GuitarString>(37);
    	char[] keys = {'q', '2', 'w', 'e', '4', 'r', '5', 't', 'y', '7', 'u', '8', 'i',
    			'9', 'o', 'p', '-', '[', '=', 'z', 'x', 'd', 'c', 'f', 'v', 'g', 'b', 'n',
    			'j', 'm', 'k', ',', '.', ';', '/', '"', ' '};
    	
    	for (int i = 0; i < 37; i++) {
    		keyboard.add(new GuitarString(440 * Math.pow(2.0, ((i - 24) * 12.0))));
    		keyboard.get(i).name = (char) keys[i];  		   	
    	}
        
        while (true) {
        	if (StdDraw.hasNextKeyTyped()) {
        		
        		char key = StdDraw.nextKeyTyped();
        		int index = arrayIndex(keys, key);
        		keyboard.get(index).pluck();
        		double sample = keyboard.get(index).sample();
        		StdAudio.play(sample);
        		keyboard.get(index).tic();
        		
        	}


        }
    }
}


