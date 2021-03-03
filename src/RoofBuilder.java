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
        _isInitialized = true;

        _rob = RobotManager.get(1);
        _rob.SprunghoeheSetzen(50);

        _welt = world;
        _manager = manager;
    }

    @Override
    public void step() {
        if(_isInitialized) {
            if (_heightCounter <= _height) {
                _rob.Hinlegen("rot");
                _rob.Schritt();

                if (_rowCount * _columnCount == _counter) {
                    _rob.LinksDrehen();

                    while (!_rob.IstWand()) {
                        _rob.Schritt();

                        if (_rob.IstWand() && !_rob.IstBlickWesten()) {
                            _rob.LinksDrehen();
                        } else if (_rob.IstWand() && _rob.IstBlickWesten()) {
                            if (_heightCounter <= _height) {
                                _counter = 1;
                                _rob.RechtsDrehen();
                                _rob.RechtsDrehen();
                                _rob.Schritt();
                                _rob.RechtsDrehen();
                                if (_heightCounter != _height) {
                                    _rob.Hinlegen("rot");
                                } else {
                                    _manager.spawn(2);
                                }
                                _rob.Schritt();
                                _rob.LinksDrehen();

                                _heightCounter++;
                            }
                            return;
                        }
                    }
                }
                if (_counter % (_columnCount * 2) == 0) {
                    _rob.LinksDrehen();
                    _rob.Hinlegen("rot");
                    _rob.Schritt();
                    _rob.LinksDrehen();
                } else if (_counter % _columnCount == 0) {
                    _rob.RechtsDrehen();
                    _rob.Hinlegen("rot");
                    _rob.Schritt();
                    _rob.RechtsDrehen();
                }

                _counter++;
            }
        }
    }
}