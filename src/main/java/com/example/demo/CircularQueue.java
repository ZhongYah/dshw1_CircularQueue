package com.example.demo;
public class CircularQueue {

    private int length; // queue length
    private int front; // an index of before head queue
    private int rear; // the end of queue
    private int[] arr; // to store values
    private int temp3; // value of（sum or sub）

    CircularQueue(int length) {
        this.length = length;
        this.arr = new int[length];
//      this.front = 0;
//      this.rear = 0;
    }

    private boolean isFull() {
        return length == getCircularQueueNum();
    }

    private boolean isEmpty() {
        return front == rear;
    }


    public void addQueue(int value) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("佇列是滿的，無法執行Enqueue!");
        }
        // add data
        arr[rear % length] = value;
        if(getCircularQueueNum()<6) {
            rear++;
        }
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("佇列是空的，無法執行Enqueue!");
        }
        // get data
        int temp = arr[front % length];
        front++;
        return temp;
    }

    public int getHeadQueue() {
        if (isEmpty()) {
            throw new RuntimeException("佇列是空的");
        }
        return arr[front % length];
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("佇列是空的");
        }

//        System.out.print("目前佇列的內容(由 Front 至 Rear)為: ");              由 Front 至 Rear 寫法
//        for (int i = front; i < front + getCircularQueueNum(); i++) {
//            System.out.printf("%d\t", arr[i % length]);
//        }
//        System.out.print("\n");


        System.out.print("目前佇列的內容(由 Rear 至 Front)為: ");          //    由 Rear 至 Front 寫法
        for (int i = rear-1; i > rear - getCircularQueueNum()-1; i--) {
            System.out.printf("%d\t", arr[i % length]);
        }
        System.out.print("\n");
    }



    public int getCircularQueueNum() {
        int n; // current number of value in CircularQueue
        if (rear < front) {
            n = rear + length - front;
        } else {
            n = rear - front;
        }
        return n;
    }


    public int sumQueue() {
        if (getCircularQueueNum() <=1) {
            throw new RuntimeException("資料不足，不能相加");
        }
        else {
            int temp1 = arr[front % length];
            front++;
            int temp2 = arr[front % length];
            front++;
            temp3 = temp1 + temp2;
        }

        arr[rear % length] = temp3;
        rear++;
        return 0;
    }

    public int subQueue() {
        if (getCircularQueueNum() <=1) {
            throw new RuntimeException("資料不足，不能相減");
        }
        else  {
            int temp1 = arr[front % length];
            front++;
            int temp2 = arr[front % length];
            front++;
            temp3 = temp1 - temp2;
        }

        arr[rear % length] = temp3;
        rear++;
        return 0;
    }
}

