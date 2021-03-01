public class RoofBuilder implements IRobotBuilder {
    private ROBOTER _rob;
    private WELT _welt;

    private boolean _isInitialized;
    private BuilderManager _manager;

    @Override
    public void init(WELT world, BuilderManager manager) {
        _isInitialized = true;
        _welt = world;
        _rob = RobotManager.get(1);

        _manager = manager;
    }
    private int _columnCount = 5;
    private int _counter = 1;

    @Override
    public void step() {
        if(_isInitialized) {
            if (_rob.IstBlickWesten()) {
                _rob.LinksDrehen();
                _rob.Hinlegen("rot");
                _rob.Schritt();
                _rob.LinksDrehen();
            } else if (_rob.IstBlickOsten()) {
                _rob.RechtsDrehen();
                _rob.Hinlegen("rot");
                _rob.Schritt();
                _rob.RechtsDrehen();
            }
            _rob.Hinlegen("rot");
            _rob.Schritt();

            _counter++;
        }
    }
}