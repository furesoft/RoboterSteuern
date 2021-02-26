public class CeilingBuilder implements  IRobotBuilder {
    private ROBOTER _rob;
    private WELT _welt;

    @Override
    public void Init(WELT world) {
        _rob = new ROBOTER(world);
        _welt = world;

        _rob.LinksDrehen();
    }


    @Override
    public void Step() {
         if(_rob.IstBlickNorden()) {
            if(!_rob.IstWand()) {
                if(_rob.IstZiegel()) {
                    _rob.Schritt();
                }
                else {
                    _rob.Hinlegen("grün");
                    _rob.Schritt();

                    return;
                }
            }
            else if(_rob.IstWand()) {
                return;
            }
        }
        else if(_rob.IstWand()) {
            if(_rob.IstBlickOsten()) {
                _rob.RechtsDrehen();
                _rob.Hinlegen("grün");
                _rob.Schritt();
                _rob.RechtsDrehen();
            }
            else if(_rob.IstBlickWesten()) {
                _rob.LinksDrehen();

                if(_rob.IstBlickSueden() && _rob.IstWand()) {
                    _rob.RechtsDrehen();
                    _rob.RechtsDrehen();
                }

                _rob.Hinlegen("grün");
                _rob.Schritt();
                _rob.LinksDrehen();

                if(_rob.IstWand()) {
                    _rob.RechtsDrehen();
                }
            }
        }
        else {
            _rob.Hinlegen("grün");
            _rob.Schritt();
        }
    }
}
