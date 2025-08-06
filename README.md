# GeoWealth - Word Reduction Challenge

## 📌 Problem

Find all **9-letter English words** that can be reduced down to a valid **1-letter word** (`A` or `I`)  
by removing one letter at a time — with **each intermediate word also being valid**.

Source dictionary:  
https://raw.githubusercontent.com/nikiiv/JavaCodingTestOne/master/scrabble-words.txt

## 🚀 Solution

- Loads the dictionary from URL
- Recursively reduces each 9-letter word
- Uses memoization for performance
- No parallelism (as per constraints)

## 🧪 Sample output

Loading dictionary...  
Dictionary loaded. Word count: 279500 (527.26 ms).  
Searching for reducible words...  
Found 775 reducible 9-letter words in 218.01 ms.  

## 🛠 How to run

```bash
javac -d out src/**/*.java
java -cp out Main
