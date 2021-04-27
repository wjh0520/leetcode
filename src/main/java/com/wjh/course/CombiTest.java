package com.wjh.course;

/**
 * 组合问题
 */
public class CombiTest {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] flag = new int[5];
        CombiTest combiTest = new CombiTest();
        combiTest.combi(arr,flag,0,5);

    }

    public void combi(int[] arr,int[] flag,int a,int b){
        if (a == b){
            for (int i = 0; i < b; i++) {
                if (flag[i] ==1 ){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        flag[a] = 1;
        combi(arr,flag,a+1,b);
        flag[a] = 0;
        combi(arr,flag,a+1,b);

    }
}
