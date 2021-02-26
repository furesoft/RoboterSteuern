public class RoboterSteuern {
    private static WELT myWelt;


    public static void main(String[] args) {
        //Todo: haus bauen
        myWelt = new WELT(8, 8 ,10);

        BuilderManager manager = new BuilderManager(myWelt);

        IRobotBuilder ceilingBuilder = new CeilingBuilder();
        manager.add(ceilingBuilder);

        IRobotBuilder houseBuilder = new HouseBuilder(5,5);
        manager.add(houseBuilder);

        manager.spawn(0);
        manager.run();
    }
}