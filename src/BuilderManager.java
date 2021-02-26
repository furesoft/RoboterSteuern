import java.util.ArrayList;

public class BuilderManager {
    private ArrayList<IRobotBuilder> _builders = new ArrayList<>();
    WELT _world;

    public BuilderManager(WELT world) {
        _world = world;
    }

    public void add(IRobotBuilder builder) {
        _builders.add(builder);
    }

    public void spawn(int index) {
        _builders.get(index).init(_world, this);
    }

    public void run() {
        while(true) {
            for(IRobotBuilder builder : _builders) {
                builder.step();
            }
        }
    }
}
