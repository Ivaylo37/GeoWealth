package service;

import java.util.*;


public class WordService {

    private final Set<String> dictionary;
    private final Set<String> validSingleLetters = Set.of("A", "I");
    private final Map<String, Boolean> memory = new HashMap<>();

    public WordService(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> findReducibleWords() {
        List<String> result = new ArrayList<>();

        for (String word : dictionary) {
            if (word.length() == 9 && isReducible(word)) {
                result.add(word);
            }
        }

        return result;
    }


    private boolean isReducible(String word) {
        word = word.toUpperCase();

        if (memory.containsKey(word)) {
            return memory.get(word);
        }

        if (!dictionary.contains(word)) {
            memory.put(word, false);
            return false;
        }

        if (word.length() == 1) {
            boolean isValid = validSingleLetters.contains(word);
            memory.put(word, isValid);
            return isValid;
        }

        for (int i = 0; i < word.length(); i++) {
            String reduced = (word.substring(0, i) + word.substring(i + 1)).toUpperCase();

            if (isReducible(reduced)) {
                memory.put(word, true);
                return true;
            }
        }

        memory.put(word, false);
        return false;
    }
}
