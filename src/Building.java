import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lexer on 16.10.14.
 */
public class Building {

    private int mNumberOfFloors;
    private List<Elevator> mElevators;
    private World mWorld;

    public Building(World world, int numberOfFloors) {
        this.mWorld = world;
        this.mNumberOfFloors = numberOfFloors;
    }

    public void setElevators(List<Elevator> elevators) {
        mElevators = elevators;
    }

    public int getNumberOfFloors() {
        return mNumberOfFloors;
    }

    public void update(int time) {

        processRequests();

        updateElevators(time);
    }

    public World getWorld() {
        return mWorld;
    }

    private void processRequests() {
            Elevator elevator = getFreeElevator();
            if (elevator == null) {
                return;
            }
    }

    private void updateElevators(int time) {
        for (Elevator elevator : mElevators) {
            elevator.update(time);
        }
    }

    private Elevator getFreeElevator() {

        for (Elevator elevator : mElevators) {
            if (elevator.isFree()) {
                return elevator;
            }
        }

        return null;
    }

    private class HumanComparator implements Comparator<Human> {

        @Override
        public int compare(Human o1, Human o2) {
            int h1FromFloor = o1.getCurrentFloor();
            int h1ToFloor = o1.getNecessaryFloor();
            int h2FromFloor = o2.getCurrentFloor();
            int h2ToFloor = o2.getNecessaryFloor();
            if (h1FromFloor != h2FromFloor) {
                return h1FromFloor - h2FromFloor;
            } else {
                return h1ToFloor - h2ToFloor;
            }
        }
    }
}
