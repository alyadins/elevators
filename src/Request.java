/**
 * Created by lexer on 16.10.14.
 */
public class Request {
    public enum Direction {
        UP, DOWN
    }

    private int mFromFloor;
    private int mToFloor;
    private Direction mDirection;

    public Request(int fromFloor, int toFloor) {
        this.mFromFloor = fromFloor;
        this.mToFloor = toFloor;

        if (mFromFloor > mToFloor) {
            mDirection = Direction.DOWN;
        } else if (mFromFloor < mToFloor) {
            mDirection = Direction.UP;
        } else {
            throw new IllegalArgumentException("Этаж куда ехать. равен этажу откуда ехать");
        }
    }
}
