public class RoboterThread implements  Runnable {
    ROBOTER _robot;

    public RoboterThread(ROBOTER robot) {
        _robot = robot;
    }

    public void run() {
        BuildBlock(_robot);
    }

    private  void BuildBlock(ROBOTER robot) {
        for(int tower = 0; tower < 12*5; tower++) {
            robot.Hinlegen("gelb");
            robot.Schritt();

            if(robot.IstWand()) {
                if(tower % 5 == 0) {
                    robot.RechtsDrehen();
                }
                else {
                    robot.LinksDrehen();
                }

                robot.Hinlegen("gelb");
                robot.Schritt();

                if(tower % 5 == 0) {
                    robot.RechtsDrehen();
                }
                else {
                    robot.LinksDrehen();
                }
            }
        }

        String name = Thread.currentThread().getName();
        if (name == "robo1") {
            for (int i = 0; i < 12; i++) {
                robot.Hinlegen("rot");
                robot.Schritt();

                if(i == 3 || i == 6 || i == 10) {
                    robot.RechtsDrehen();
                }
            }
        }
    }
}