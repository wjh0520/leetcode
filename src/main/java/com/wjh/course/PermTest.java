package com.wjh.course;

public class PermTest {


    public static void main(String[] args) {
        PermTest permTest = new PermTest();
        int[] arr = {1,2,3,4,5};
        permTest.perm(arr,0,4);
    }
    
    
    
    public void perm(int[] arr, int k, int m) {
        if (k == m){
            for (int i = 0; i <= m; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }else {
            for (int i = k; i <=m ; i++) {
                swap(arr,k,i);
                perm(arr,k+1,m);
                swap(arr,k,i);
            }
        }   
    }

    public void swap(int[] arr, int k, int m){
        int temp = arr[k];
        arr[k] = arr[m];
        arr[m] = temp;
    }
}

