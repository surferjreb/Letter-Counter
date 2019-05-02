

import java.util.ArrayList;
import java.util.HashMap;

public class WordCount {
    private static WordCount word_instance = null;
    private ArrayList<String> letters;
    private HashMap<String , String> letterChart;
    private String words;

    public static WordCount getInstance(String word){
        if(word_instance == null) {
            word_instance = new WordCount(word);
        }
        else{
            word_instance = new WordCount(word);
        }

        return word_instance;
    }
//-----------------------------------------------
    private WordCount(String words){
        this.words = words.strip().toLowerCase().replaceAll("[^a-zA-Z]", "");
        letters = new ArrayList<>();
        letterChart = new HashMap<>();
        setLetterBarChart();

    }//End constructor
//-----------------------------------------------
    private void setLettersList(){
        int maxIndex = words.length();
        if(letters.isEmpty()){
            for(int i = 0; i < maxIndex; i++){
                letters.add(String.valueOf(words.charAt(i)));
            }
        }
        else{
            letters.clear();
            for(int i = 0; i < maxIndex; i++){
                letters.add(String.valueOf(words.charAt(i)));
            }
        }

    }
//-----------------------------------------------
    private String getLetterCount(String letter){
        StringBuilder counter = new StringBuilder();
        String count;

        for(int i = 0; i < letters.size(); i++){

                if(letter.equals(letters.get(i))){
                    counter.append("*");
                }
        }
        count = counter.toString();
        return count;
    }
//-----------------------------------------------
    private void setLetterBarChart(){
        setLettersList();
        for(int i = 0; i < letters.size(); i ++){
            String letter = letters.get(i);
            String count = getLetterCount(letter);
            checkLetterList(letter, count);
        }
    }//end of set
//----------------------------------------------
    public void displayLetterChart(){

        for(String letter : letterChart.keySet()){

            String value = letterChart.get(letter);
            System.out.println(letter + " " + value);
        }
    }//end of display
//----------------------------------------------
    public void displayLetters(){
        for(String letter: letterChart.keySet()){
            System.out.println(letter);
        }
    }//displays the list
//----------------------------------------------
    private void checkLetterList(String letter, String count){
        while(!letterChart.containsKey(letter)){
            letterChart.put(letter, count);

        }

    }
//----------------------------------------------
    public String getLetterOccurrence(String myLetter){
        String temp = "";

        for(String letter: letterChart.keySet()){
            if(myLetter.equals(letter)){
                temp = myLetter + letterChart.get(letter);
                return temp;
            }

        }
        return temp;
    }
//----------------------------------------------
    public void getSingleOccurrenceLetters(){
        for(String letter : letterChart.keySet()){
            String count = letterChart.get(letter);
            if(count.length() < 2){
                System.out.println(letter);
            }
        }

    }
//----------------------------------------------
    public void getRecurringLetters(){
        for(String letter : letterChart.keySet()){
            String count = letterChart.get(letter);
            if(count.length() >= 2){
                System.out.println(letter);
            }
        }
    }


}//end class
