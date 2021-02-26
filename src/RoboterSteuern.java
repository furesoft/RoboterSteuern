import builders.CeilingBuilder;
import core.BuilderManager;

public class RoboterSteuern {
    private static WELT myWelt;


    public static void main(String[] args) {
        //Todo: haus bauen
        myWelt = new WELT(6, 6 ,10);


        BuilderManager manager = new BuilderManager(myWelt);

        IRobotBuilder ceilingBuilder = new CeilingBuilder();
        manager.add(ceilingBuilder);

        IRobotBuilder houseBuilder = new HouseBuilder();
        manager.add(houseBuilder);

        manager.spawn(0);
        manager.run();
    }
}