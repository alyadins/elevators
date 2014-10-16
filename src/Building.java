import java.util.ArrayList;
import java.util.List;

/**
 * Created by lexer on 16.10.14.
 */
public class Building {

    private int mNumberOfFloors;
    private List<Elevator> mElevators;

    private List<Request> mRequestsList = new ArrayList<Request>();
    private List<Human> mHumans;

    public Building(int numberOfFloors) {
        this.mNumberOfFloors = numberOfFloors;
    }

    public void setElevators(List<Elevator> elevators) {
        mElevators = elevators;
    }

    public int getNumberOfFloors() {
        return mNumberOfFloors;
    }

    public void setHumans(List<Human> humans) {
        this.mHumans = humans;
    }

    public void update(int time) {

    }
}
