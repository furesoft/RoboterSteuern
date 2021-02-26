public class HouseBuilder implements  IRobotBuilder {
    private ROBOTER _rob;
    private WELT _welt;

    private boolean _isInitialized;
    private BuilderManager _manager;
    private int _counter = 1;
    private int _rowCount;
    private int _columnCount;

    public HouseBuilder(int rows, int columns) {
        _rowCount = rows;
        _columnCount = columns;
    }

    @Override
    public void init(WELT world, BuilderManager manager) {
        _isInitialized = true;

        _rob = new ROBOTER(world);
        _welt = world;

        _rob.LinksDrehen();
        _rob.Schritt();
        _rob.RechtsDrehen();
        _rob.Hinlegen("blau");
        _rob.Schritt();
        _rob.LinksDrehen();

        _manager = manager;
    }

    @Override
    public void step() {
        if(_isInitialized) {
            _rob.Hinlegen("blau");
            _rob.Schritt();

            if(_rowCount * _columnCount == _counter) {
                _rob.LinksDrehen();

                while(!_rob.IstWand()) {
                    _rob.Schritt();

                    if(_rob.IstWand() && !_rob.IstBlickWesten()) {
                        _rob.LinksDrehen();
                    }
                    else if(_rob.IstWand() && _rob.IstBlickWesten()) {
                        _counter = 1;
                        return;


                    }
                }
            }
            if(_counter % (_columnCount * 2) == 0) {
                _rob.LinksDrehen();
                _rob.Hinlegen("blau");
                _rob.Schritt();
                _rob.LinksDrehen();
            }
            else if(_counter % _columnCount == 0)
            {
                _rob.RechtsDrehen();
                _rob.Hinlegen("blau");
                _rob.Schritt();
                _rob.RechtsDrehen();
            }

            _counter++;
        }
    }
}
