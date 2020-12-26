package Lesson1.HW;

import java.util.Random;

public class Wall extends Obstacle {
    private int elevation;

    public Wall(int elevation) {
        this.elevation = elevation;
    }

    public int getElevation() {
        return elevation;
    }

    @Override
    protected boolean action(JumpRun jumpRun) {
        System.out.println("Стена высотой " + this.elevation);

        jumpRun.jump();

        if (getElevation() <= jumpRun.getHeight()) {
            System.out.println("Перепрыгнуть получилось");

            return true;
        } else {
            System.out.println("Перепрыгнуть не получилось");

            return false;
        }
    }
}
