package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class DictionaryLoader {

    private static final String DICTIONARY_URL = "https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt";

    public static Set<String> loadDictionary() {
        Set<String> dictionary = new HashSet<>();
        try {
            URL url = new URL(DICTIONARY_URL);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                dictionary.add(line.trim().toUpperCase());
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error loading dictionary: " + e.getMessage());
        }

        dictionary.add("A");
        dictionary.add("I");
        return dictionary;
    }
}
