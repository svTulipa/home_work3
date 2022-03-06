package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private static char[][] map;
    private final static int MAP_SIZE = 3;
    private final static int DOTS_COUNT_TO_WIN = 3;
    private final static char DOT_X = 'x';
    private final static char DOT_O = 'O';
    private final static char DOT_EMPTY = '*';
    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        init();
        print();
        while (true) {
            humanTurn();
            print();
            if (checkWin(DOT_X)) {
                System.out.println("You WIN!");
                break;
            }
            if (checkDraw()) {
                System.out.println("Draw");
                break;
            }
            computerTurn();
            print();
            if (checkWin(DOT_O)) {
                System.out.println("Computer Win!");
                break;
            }
            if (checkDraw()) {
                System.out.println("Draw");
                break;
            }

        }
    }

    private static boolean checkWin(char dot) {
        int count = 0;
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if (map[i][j] == dot){
                    count++;
                } else {
                    break;
                }
            }
            if (count == 3){
                return true;
            }
            count = 0;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[j][i] == dot) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == 3){
                return true;
            }
            count = 0;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i][i] == dot) {
                count++;
            }
            if (count == 3){
                return true;
            }
        }
        count = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i][map.length - i - 1] == dot) {
                count++;
            }
            if (count == 3){
                return true;
            }
        }
        count = 0;
        return false;
    }

    private static boolean checkDraw(){
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if (map[i][j] == DOT_EMPTY){
                    return  false;
                }
            }
        }
        return true;
    }

    private static void computerTurn(){
        System.out.println("Computer turn");
        int x,y;
        do {
            x = random.nextInt(MAP_SIZE);
            y = random.nextInt(MAP_SIZE);
        } while (!cellValidation(x + 1, y + 1, DOT_O));
        map[x][y] = DOT_O;
    }

    private static void humanTurn(){
        int x,y;
        do {
            while (true){
                System.out.println("Please  input dots coordinate in format 'x y'");
                if (sc.hasNextInt()){
                    x = sc.nextInt();
                } else {
                    System.out.println("You input wrong X coordinate format");
                    sc.nextLine();
                    continue;
                }
                if (sc.hasNextInt()){
                    y = sc.nextInt();
                    break;
                } else {
                    System.out.println("You input wrong Y coordinate format");
                    sc.nextLine();
                }
            }
        } while (!cellValidation(x, y, DOT_X));
        map[x -1][y - 1] = DOT_X;
    }

   private  static  boolean cellValidation(int x, int y, char dot){
        if (x < 1 || x > MAP_SIZE || y < 1 || y >MAP_SIZE){
            System.out.println("Exit map sizes");
            return false;
        }
        boolean check = map[x - 1][y -1] == DOT_EMPTY;
        if (check){
            return check;
        } else {
            if ( dot == DOT_X){
                System.out.println("Cell is busy");
            }
            return false;
        }
    }

    private static void print(){
        for (int i = 0; i < map.length + 1; i++){
            if (i==0){
                System.out.print(" ");
            } else {
                System.out.print((i) + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < map.length; i++){
            System.out.print((i + 1)+ " ");
            for (int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void init(){
        map = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }
}
