import java.util.List;

/**
 * Created by lexer on 16.10.14.
 */
public class Request implements Comparable{


    private int mFromFloor;
    private int mToFloor;
    private int mCreationTime;
    private List<Human> mHumans;

    public Request(int fromFloor, int toFloor, int creationTime, List<Human> humans) {
        this.mFromFloor = fromFloor;
        this.mToFloor = toFloor;
        this.mCreationTime = creationTime;
        this.mHumans = humans;
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

    @Override
    public int compareTo(Object o) {
        Request cRequest = (Request) o;
        return getFromFloor() - cRequest.getFromFloor();
    }
}
