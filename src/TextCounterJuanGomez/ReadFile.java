/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 09/21/2021
 */

package TextCounterJuanGomez;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadFile {

    private static String filePath = "/Users/amy/Documents/Valencia College/Fall 2021/Mobile Dev/Week 2/TextCounterJuanGomez/";
    private static String fileName = "poem.txt";


    public void getFile(){
        try{
            File file = new File(filePath + fileName);
            Scanner sc = new Scanner(file);
            HashMap<String, Integer> wordCountHolder = new HashMap<String, Integer>();
            AtomicInteger position = new AtomicInteger(1);

            while(sc.hasNext() ){

                String word = sc.next();
                // System.out.println("original string--> " + String.valueOf(word));
                word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                // System.out.println("clear string--> " + String.valueOf(word));
                if (wordCountHolder.containsKey(word)) {
                    wordCountHolder.put(word, wordCountHolder.get(word) + 1);
                } else {
                    wordCountHolder.put(word, 1);
                }

            }



            System.out.println("\n");
            System.out.println("   Word      Frecuency");
            System.out.println("______________________");
            wordCountHolder.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> {
                    System.out.println(position + ". " + k.getKey() + "        " + k.getValue());
                    position.getAndIncrement();
                });

        }catch(Exception e){
            System.out.println(e);

        }

    }
}
