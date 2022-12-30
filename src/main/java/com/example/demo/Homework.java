package com.example.demo;

import java.util.Scanner;

public class Homework {

    public static void main(String[] args) {

        CircularQueue queue = new CircularQueue(5);    // 程式以陣列大小=5 為例
        Scanner scanner = new Scanner(System.in);
        char choice = ' ';
        boolean loop = true;

        System.out.println("Enqueue->e,     Dequeue->d,     Add->a,     Sub->s,    List->l,    Front_item->f,    Exit->x");  // 選單

        while (loop) {
            System.out.print("請輸入你選擇的工作 : ");
            choice = scanner.next().charAt(0);

            switch (choice) {

                case 'e' :
                    System.out.print("請輸入數值 : ");
                    int value = scanner.nextInt();
                    try {
                        queue.addQueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'd' :
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出之元素為 : %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'a' :
                    try {
                        queue.sumQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 's' :
                    try {
                        queue.subQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'l' :
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'f' :
                    try {
                        int headQueue = queue.getHeadQueue();
                        System.out.printf("位於佇列Front端第一個元素為%d\n", headQueue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'x' :
                    scanner.close();
                    loop = false;
                    System.out.println("Bye Bye!");
                    break;

                default :
                    System.out.println("輸入錯誤! 請重新輸入><");

            }
        }
    }
}