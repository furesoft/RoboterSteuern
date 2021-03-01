public class RoofBuilder implements IRobotBuilder {
    private final ROBOTER _rob;
    private WELT _welt;

    private boolean _isInitialized;
    private BuilderManager _manager;

    public RoofBuilder(ROBOTER rob) {
        this._rob = rob;
    }

    @Override
    public void init(WELT world, BuilderManager manager) {
        _isInitialized = true;
        _welt = world;

        _manager = manager;
    }

    @Override
    public void step() {
        if(_isInitialized) {
            _rob.Hinlegen("rot");
        }
    }
}