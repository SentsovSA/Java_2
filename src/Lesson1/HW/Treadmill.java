package Lesson1.HW;

import java.util.Random;

public class Treadmill extends Obstacle {
    protected int length;


    public Treadmill(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }


    @Override
    protected boolean action(JumpRun jumpRun) {
        System.out.println("Расстояние на дорожке: " + this.length);

        jumpRun.run();

        if (getLength() <= jumpRun.getDistance()) {
            System.out.println("Успешно пробежал");

            return true;
        } else {
            System.out.println("Пробежать не получилось");

            return false;
        }
    }
}
