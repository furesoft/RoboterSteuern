

public class RoofBuilder implements IRobotBuilder {
    private ROBOTER _rob;
    private WELT _welt;

    private boolean _isInitialized;
    private BuilderManager _manager;

    private int _counter = 1;

    @Override
    public void init(WELT world, BuilderManager manager) {
        _rob = RobotManager.get(0);

        _welt = world;
        _manager = manager;
        _rob.SprunghoeheSetzen(100);

         _rob.Schritt();
         _rob.RechtsDrehen();
         _rob.Schritt();
         _rob.LinksDrehen();
         _rob.Schritt();

        for(int x = 1; x < 4; x++) {
            _rob.Schritt();
        }

         _rob.Aufheben();
         _rob.Hinlegen("rot");
         _rob.Schritt();
         _rob.RechtsDrehen();
         _rob.Schritt();
         _rob.RechtsDrehen();

         _isInitialized = true;
    }

    @Override
    public void step() {
        if(_isInitialized) {
            if(_counter == 1) {
                for (int i = 0; i < 3; i++) {
                    _rob.Hinlegen("rot");
                    _rob.Schritt();
                }

                _rob.LinksDrehen();
                _rob.Hinlegen("rot");
                _rob.Schritt();
                _rob.LinksDrehen();

                for (int i = 0; i < 2; i++) {
                    _rob.Hinlegen("rot");
                    _rob.Schritt();
                }

                _rob.RechtsDrehen();
                _rob.Hinlegen("rot");
                _rob.Schritt();
                _rob.RechtsDrehen();

                for (int i = 0; i < 2; i++) {
                    _rob.Hinlegen("rot");
                    _rob.Schritt();
                }

                _rob.LinksDrehen();
                _rob.Hinlegen("rot");
                _rob.Schritt();
                _rob.LinksDrehen();

                for (int i = 0; i < 2; i++) {
                    _rob.Hinlegen("rot");
                    _rob.Schritt();
                }

                _counter++;
            }
            else if(_counter == 2) {
                _rob.LinksDrehen();
                _rob.Schritt();
                _rob.LinksDrehen();
                _rob.Hinlegen("rot");
                _rob.RechtsDrehen();
                _rob.Schritt();
                _rob.LinksDrehen();
                _rob.Hinlegen("rot");
                _rob.RechtsDrehen();
                _rob.RechtsDrehen();
                _rob.Schritt();
                _rob.Schritt();

                _counter++;
            }
            else {
                return;
            }

        }
    }
}