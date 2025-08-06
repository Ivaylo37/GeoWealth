package controller;

import service.WordService;
import util.DictionaryLoader;

import java.util.List;
import java.util.Set;

public class MainController {

    public void run() {
        try {
            System.out.println("Loading dictionary...");
            long loadStart = System.nanoTime();

            Set<String> dictionary = DictionaryLoader.loadDictionary();

            long loadEnd = System.nanoTime();
            System.out.printf("Dictionary loaded. Word count: %d (%.2f ms)%n",
                    dictionary.size(), (loadEnd - loadStart) / 1_000_000.0);

            WordService service = new WordService(dictionary);

            System.out.println("Searching for reducible words...");
            long startTime = System.nanoTime();

            List<String> result = service.findReducibleWords();

            long endTime = System.nanoTime();
            double durationMs = (endTime - startTime) / 1_000_000.0;

            System.out.printf("Found %d reducible 9-letter words in %.2f ms.%n",
                    result.size(), durationMs);

        } catch (Exception e) {
            System.err.println("Fatal error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
