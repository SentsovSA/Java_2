package Lesson1.HW;

import java.sql.SQLOutput;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random wallRandom = new Random();
        Random treadmillRandom = new Random();

        var wall = new Wall(wallRandom.nextInt(5));
        var treadmill = new Treadmill(treadmillRandom.nextInt(2000));

        JumpRun[] jumpRun = new JumpRun[3];
        jumpRun[0] = new Human("Игорь", 800, 2);
        jumpRun[1] = new Cat("Василий", 400, 1);
        jumpRun[2] = new Robot("RoboCop", 5000, 5);

        Obstacle[] obstacles = {wall, treadmill};



        for (int i = 0; i < jumpRun.length; i++) {
            boolean result = true;
            for (int j = 0; j < obstacles.length; j++){
                result = obstacles[j].action(jumpRun[i]);
                if (!result){
                    break;
                }
            }
            if(result){
                System.out.println("Всё получилось!");
            } else System.out.println("Не вышло!");
        }



    }
}

