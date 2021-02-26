import java.awt.*;

public class RoboterSteuern {


    public static void main(String[] args) {
        //Todo: haus bauen
        WELT myWelt = new WELT(6, 6 ,25);
        ROBOTER myRob1 = new ROBOTER(myWelt);

        InitRobot(myRob1, 4);

        ROBOTER myRob3 = new ROBOTER(myWelt);

        InitRobot(myRob3, 2);

        ROBOTER myRob2 = new ROBOTER(myWelt);

        InitRobot(myRob2, 0);

        Thread t1 = new Thread(new RoboterThread(myRob1), "robo1");
        Thread t2 = new Thread(new RoboterThread(myRob2), "robo2");
        Thread t3 = new Thread(new RoboterThread(myRob3), "robo3");

        t1.start();
        t2.start();
        t3.start();

    }

    private static void InitRobot(ROBOTER robot, int startPos) {
        robot.SprunghoeheSetzen(20);
        robot.LinksDrehen();

        for (int i = 0; i < startPos; i++) {
            robot.Schritt();
        }

        robot.RechtsDrehen();
    }
}