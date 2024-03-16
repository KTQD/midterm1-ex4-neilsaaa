
public class Main {
    public static void main(String[] args){
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};



        MySumThread thread1 = new MySumThread(numbers);
        MyMaxThread thread2 = new MyMaxThread(numbers);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        Phần tử lớn nhất trong mảng là: 9
//        Tổng của các phần tử trong mảng là: 321
        System.out.println("Phần tử lớn nhất trong mảng là: " + thread2.getMax());

        System.out.println("Tổng của các phần tử trong mảng là: " + thread1.getSum());


    }
}






class MySumThread extends Thread {
    public int[] arr;

    public int sum;

    public MySumThread(int[] arr) {
        this.arr = arr;

    }

    @Override
    public void run() {
        sum=0;

        for (int i = 0; i <arr.length ; i++) {
            sum = sum+arr[i];
        }
    }

    public int getSum() {
        return sum;
    }
}

class MyMaxThread extends Thread {
    public int[] arr;

    public int max;

    public MyMaxThread(int[] arr) {
        this.arr = arr;

    }

    @Override
    public void run() {
        max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
    }

    public int getMax() {
        return max;
    }
}
