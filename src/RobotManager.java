import java.util.ArrayList;

public class RobotManager {
    private static ArrayList<ROBOTER> _roboters = new ArrayList<>();
    private static WELT _world;

    public static ROBOTER create() {
        var robot = new ROBOTER(_world);
        _roboters.add(robot);

        return robot;
    }

    public static void Init(WELT world) {
        _world = world;
    }

    public static ROBOTER get(int index) {
        return _roboters.get(index);
    }

}