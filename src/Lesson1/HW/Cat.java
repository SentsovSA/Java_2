package Lesson1.HW;

public class Cat implements JumpRun, Participating {
    protected String name;
    protected int distance;
    protected int height;

    public Cat(String name, int distance, int height) {
        this.name = name;
        this.distance = distance;
        this.height = height;
    }

    @Override
    public void run() {
        System.out.println("Котя " + this.name + " может пробежать " + this.getDistance());
    }

    @Override
    public void jump() {
        System.out.println("Котя " + this.name + " может прыгнуть на " + this.getHeight());
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
