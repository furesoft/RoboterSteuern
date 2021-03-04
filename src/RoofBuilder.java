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
        _rob = RobotManager.get(0);

        _welt = world;
        _manager = manager;
        _rob.SprunghoeheSetzen(100);

         _isInitialized = true;

         _rob.Schritt();
         _rob.RechtsDrehen();
         _rob.Schritt();
         _rob.LinksDrehen();
         _rob.Schritt();
    }

    @Override
    public void step() {
        if(_isInitialized) {
            if(_rob.IstZiegel("blau")) {
                _rob.Aufheben();
                _rob.Hinlegen("rot");
                _rob.RechtsDrehen();
                _rob.Schritt();
                _rob.RechtsDrehen();
            }

            _rob.Schritt();
        }
    }
}