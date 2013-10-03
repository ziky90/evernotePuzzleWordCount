package evernotepuzzlewordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    private static int elements;
    private static List<Entry> words;
    private static HashMap<String, Integer> map = new HashMap<String, Integer>();
    private static int print;
    
    public static void main(String[] args) {
        try{
            readData();
        }catch(IOException e){
            e.printStackTrace();
        }
        printAndSort();
    }
    
    static void printAndSort(){
        
        Collections.sort(words);        
        
        for (int i = 0; i < print; i++) {
            System.out.println(words.get(i).getWord());
        }
    }
    
    
    static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        elements = Integer.parseInt(st.nextToken());
        words = new ArrayList<Entry>();
        String word;
        int index = 0;
        Entry current;
        for (int i = 0; i < elements; i++) {
            st = new StringTokenizer(br.readLine());
            word = st.nextToken();
            if(!map.containsKey(word)){
                words.add(new Entry(word, 1));
                map.put(word, index);
                index++;
            }else{
                current = words.get(map.get(word));
                current.setCount(current.getCount()+1);
            }          
        }
        st = new StringTokenizer(br.readLine());
        print = Integer.parseInt(st.nextToken());        
    }
    
    
    private static class Entry implements Comparable<Entry> {
        int count;
        String word;

        public Entry(String word, int count){
            this.count = count;
            this.word = word;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }
        
        
        
        @Override
        public int compareTo(Entry t) {
            if(t == null){
                return -1;
            }else{
                if(t.count > count){
                    return 1;
                }else if(t.count == count){
                    return -t.word.compareToIgnoreCase(word);
                }else{
                    return -1;
                }
        
            }
        }
        
    }
}
