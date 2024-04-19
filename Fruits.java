import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Fruits {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;
            int counter = 0;
            String longestWord = "";
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                System.out.println("В тексте " + wordsCounter(words) + " слов.");
                System.out.println("Самое длинное слово в тексте: " + longestWord(words, longestWord));
                fruitsCounter(words);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



//        fruitsCounter();

     }
    public static int wordsCounter(String[] words) {
        int counter = 0;
        for (String word : words) {
            counter += 1;
        }
        return counter;
    }

    public static String longestWord(String[] words, String longestWord) {
                for (String word : words) {
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
                return longestWord;
    }
    public static void fruitsCounter(String[] words) {
        Map <String, Integer> fruit = new HashMap<>();
                for (String word : words) {
                    if (fruit.containsKey(word)) {
                        fruit.put(word, fruit.get(word) + 1);
                    } else {
                        fruit.put(word, 1);
                    }
                }

        for (String word : fruit.keySet()) {
            System.out.println(word + " : " + fruit.get(word));
        }
    }
}