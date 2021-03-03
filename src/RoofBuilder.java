public class RoofBuilder implements IRobotBuilder {
    private ROBOTER _rob;
    private WELT _welt;

    private boolean _isInitialized;
    private BuilderManager _manager;

    private int _counter = 1;
    private int _heightCounter = 1;
    private int _rowCount;
    private int _columnCount = 1;
    private int _height = 1;

    @Override
    public void init(WELT world, BuilderManager manager) {
        _rob = RobotManager.get(1);

        _welt = world;
        _manager = manager;

         _isInitialized = true;
        _rob.RechtsDrehen();
        _rob.RechtsDrehen();
        _rob.Schritt();
        _rob.RechtsDrehen();
    }

    @Override
    public void step() {
        if(_isInitialized) {


        }
    }
}