/**
 * Created by lexer on 16.10.14.
 */
public class Request implements Comparable{

    public enum Direction {
        UP, DOWN
    }

    private int mFromFloor;
    private int mToFloor;
    private int mCreationTime;
    private Direction mDirection;

    public Request(int fromFloor, int toFloor, int creationTime) {
        this.mFromFloor = fromFloor;
        this.mToFloor = toFloor;
        this.mCreationTime = creationTime;

        if (mFromFloor > mToFloor) {
            mDirection = Direction.DOWN;
        } else if (mFromFloor < mToFloor) {
            mDirection = Direction.UP;
        } else {
            throw new IllegalArgumentException("Этаж куда ехать. равен этажу откуда ехать");
        }
    }

    public void setFromFloor(int fromFloor) {
        this.mFromFloor = fromFloor;
    }

    public void setToFloor(int toFloor) {
        this.mToFloor = toFloor;
    }

    public int getFromFloor() {
        return mFromFloor;
    }

    public int getToFloor() {
        return mToFloor;
    }

    public Direction getDirection() {
        return mDirection;
    }

    @Override
    public int compareTo(Object o) {
        Request cRequest = (Request) o;
        return mFromFloor - cRequest.mFromFloor;
    }
}
