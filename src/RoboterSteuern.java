public class RoboterSteuern {
    private static WELT myWelt;


    public static void main(String[] args) {
        //Todo: haus bauen
        myWelt = new WELT(6, 6 ,10);
        IRobotBuilder ceilingBuilder = new CeilingBuilder();

        BuilderManager manager = new BuilderManager(myWelt);
        manager.add(ceilingBuilder);

        manager.spawn(0);
        manager.run();
    }
}