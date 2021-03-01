public class RoboterSteuern {

    public static void main(String[] args) {
        var myWelt = new WELT(8, 8 ,10);

        BuilderManager manager = new BuilderManager(myWelt);
        RobotManager.Init(myWelt);

        var ceilingBuilder = new CeilingBuilder();
        manager.add(ceilingBuilder);

        var houseBuilder = new HouseBuilder(5,5, 5);
        manager.add(houseBuilder);

        var roofBuilder = new RoofBuilder();
        manager.add(roofBuilder);

        manager.spawn(0);
        manager.run();
    }
}