public class Area {
    private int _height;
    private int _width;
    private int _counter;

    private int _columnCounter = 1;

    public Area(int heigth, int width) {
        _height = heigth;
        _width = width;
    }

    public void Step() {
        _counter++;
        if(_counter % _width == 0) {
            _columnCounter++;
        }
    }

    public boolean IsWestBlocked() {
        return _columnCounter == 0;
    }

    public boolean IsEastBlocked() {
        return _columnCounter == _width;
    }

    public boolean HasEndReached() {
        return _counter == _width*_height;
    }
}
