package com.wjh.course;

import java.util.Scanner;

public class Hanoi_4Test {
    static int count;
    static int m = 0;
    static int minValue = 0;

    public static void main(String[] args) {
        Hanoi_4Test hanoi_4Test = new Hanoi_4Test();
        int count = 0;
        char a = 'A';
        char b = 'B';
        char c = 'C';
        char d = 'D';
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int min = Integer.MAX_VALUE;

//        for (int m = 1; m < n; m++) {
//            hanoi_4Test.hanoi4(n, m, a, b, c, d);
//            if (count < min) {
//                min = count;
//                minValue = m;
//                count = 0;
//            }
//        }
        //count = m/n;
//        System.out.println("********");
//        System.out.println(count);
//        System.out.println(minValue);
        hanoi_4Test.hanoi4(n,1,a,b,c,d);


    }


    public void hanoi4(int n, int m, char a, char b, char c, char d) {
        if (n == 0)
            return;
        hanoi4(m, m/2, a, b, d, c);
        hanoi_3(n - m, a, b, d);
        hanoi4(m, m/2, c, a, b, d);

//        hanoi4(n/2, a, b, d, c);
//        hanoi_3(n-(n/2), a, b, d);
//        hanoi4(n/2, c,a, b, d);

    }

    public void hanoi_3(int n, char a, char b, char c) {
        if (n == 0)
            return;
        hanoi_3(n - 1, a, c, b);
        move(n, a, c);
        hanoi_3(n - 1, b, a, c);
    }

    public  void move(int n, char a, char c) {

        System.out.println("第" + (++count) + "次移动:" + a + "--->" + c);
    }
}

