package synthesizer;

import java.util.ArrayList;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.introcs.StdDraw;

/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
public class GuitarHero {
	
	public static int arrayIndex(char[] keys, char key) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] == key) 
				return i;			
		}
		return -1;
	}
	
	public static double allSample(int n, ArrayList<GuitarString> keyboard) {
		double sample = 0;
		for (int i = 0; i < n; i++) {
			sample = sample + keyboard.get(i).sample();
		}
		return sample;
	}
	
	public static void ticAll(int n, ArrayList<GuitarString> keyboard) {
		for (int i = 0; i < n; i++) {
			keyboard.get(i).tic();
		}
	}
   

    public static void main(String[] args) {
    	
    	/*Create an array of GuitarStrings*/
    	ArrayList<GuitarString> keyboard = new ArrayList<GuitarString>(37);
    	
    	/*Create an array of corresponding keys*/
    	char[] keys = {'q', '2', 'w', 'e', '4', 'r', '5', 't', 'y', '7', 'u', '8', 'i',
    			'9', 'o', 'p', '-', '[', '=', 'z', 'x', 'd', 'c', 'f', 'v', 'g', 'b', 'n',
    			'j', 'm', 'k', ',', '.', ';', '/', '"', ' '};
    	
    	/*Instantiate GuitarString array, connect each frequency to a key*/
    	for (int i = 0; i < 37; i++) {
    		double stringFrequency = 440 * Math.pow(2.0, ((i-24) / 12.0));
    		keyboard.add(new GuitarString(stringFrequency));
    		keyboard.get(i).name = (char) keys[i];  		   	
    	}
        
        while (true) {
        	if (StdDraw.hasNextKeyTyped()) {
        		
        		char key = StdDraw.nextKeyTyped();
        		int index = arrayIndex(keys, key);        		
        		
        		if (index != -1) {
        			keyboard.get(index).pluck();
        			System.out.println(index);
            		System.out.println("frequency" + " " + keyboard.get(index).frequency);
        			System.out.println(keyboard.get(index).sample());
        		}
        	}
        		
        		double sample = allSample(37, keyboard);
        
        		StdAudio.play(sample);
        		ticAll(37, keyboard);
        		
        	}


        
    }
}
    



