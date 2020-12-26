package Lesson1.HW;

public class Human implements Running, Jumping{
    @Override
    public void run() {
        System.out.println("Человек пробежал");
    }
}
