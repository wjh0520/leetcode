package com.wjh.course;

public class Hanoi_3Tst {

    static int count = 0;

    public static void main(String[] args) {
        Hanoi_3Tst hanoi3Tst = new Hanoi_3Tst();
        char a = 'A';
        char b = 'B';
        char c = 'C';
        hanoi3Tst.hanoi_3(3,a,b,c);
    }


    public void hanoi_3(int n,char a,char b,char c) {
        if (n==0)
            return;
        hanoi_3(n-1,a,c,b);
        move(n,a,c);
        hanoi_3(n-1,b,a,c);
    }

    public void move(int n, char a, char c) {

        System.out.println("第"+(++count)+"次移动:"+"第"+n+"个圆盘移动："+a+"--->"+c);
    }

}

