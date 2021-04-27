package com.wjh.course;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CountNums {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Map<Character, Integer> map = getCount(num);
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        FileWriter fw = new FileWriter(new File("output.txt"),false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Map.Entry<Character,Integer> entry : entries ){
            System.out.println(entry.getKey()+"---->"+entry.getValue());
            bw.write(entry.getKey()+":"+entry.getValue());
            bw.newLine();
        }
        bw.close();
    }

    private static Map<Character, Integer> getCount(int num) {

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 1; i < num + 1; i++) {
            if (i < 10) {
                map.put((char) (i+'0'), count + 1);
            } else {
                String s = String.valueOf(i);
                char[] chars = s.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    if (map.containsKey(chars[j])) {
                        count = map.get(chars[j]);
                        map.put(chars[j], ++count);
                    }else {
                        map.put( chars[j],++count);
                    }
                    count = 0;
                }
            }
        }
        return map;

    }
}
