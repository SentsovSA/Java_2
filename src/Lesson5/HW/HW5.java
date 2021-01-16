package Lesson5.HW;

public class HW5 {
    static final int SIZE = 10000000;
    static final int H = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {

        HW5 hw5 = new HW5();

        oneThread();

        twoThread();
    }

    private static void oneThread() {
        float arr[] = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Однопоточный режим: " + (System.currentTimeMillis() - a));
    }

    private static void twoThread() throws InterruptedException {
        float[] arr = new float[SIZE];

        float[] a1 = new float[H];

        float[] a2 = new float[H];


        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        new Thread(() -> {
            System.arraycopy(arr, 0, a1, 0, H);
            for (int i = 0; i < H; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a1, 0, arr, 0, H);
        }).start();

        new Thread(() -> {
            System.arraycopy(arr, H, a2, 0, H);
            for (int i = 0; i < H; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a2, 0, arr, H, H);
        }).start();

      try {
           Thread.sleep(800);
       } catch (InterruptedException e) {
           e.printStackTrace();
      }

        System.out.println("Двухпоточный режим: " + (System.currentTimeMillis() - a));

    }


}


