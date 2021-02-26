public class RoboterSteuern {
    private static WELT myWelt;
    private static IRobotBuilder _ceilingBuilder;

    public static void main(String[] args) {
        //Todo: haus bauen
        myWelt = new WELT(6, 6 ,10);
        _ceilingBuilder = new CeilingBuilder();

        buildCeiling();
    }

    private static void buildCeiling() {
        _ceilingBuilder.Init(myWelt);

        while(true) {
            _ceilingBuilder.Step();
        }
    }
}