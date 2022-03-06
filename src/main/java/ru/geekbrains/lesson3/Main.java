package ru.geekbrains.lesson3;

public class Main {
    public static void main (String[] args){
        numbArr();
        bigArr();
        someArr();
        rectArr();
        comeArr(13,6);
    }
    public static void numbArr(){
        int[] array = {1,1,0,0,1,0,1};
        for (int i = 0; i < array.length; i++){
          if (array[i] == 0){
              array[i] = 1;
          } else {
              array[i] = 0;
          }
        }
    }
    public static void bigArr(){
        int [] arr = new int[100];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
    }
    public static void someArr(){
        int[] arr = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6){
                arr[i] *= 2;
            }
        }
    }
    public static void rectArr(){
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (i == j){
                    arr[i][j] = 1;
                }
                if (j == arr[i].length - 1 - i){
                    arr[i][j] = 1;
              }
                System.out.print(arr[i][j] + " ");
            }
                System.out.println();
        }
    }
    public static int[] comeArr(int len, int initialValue){
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++){
            arr[i] = initialValue;
        }
        return arr;
    }
}
