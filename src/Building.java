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
        Collections.sort(mHumans, new HumanComparator());
    }

    public void update(int time) {
        updateRequests(time);

        processRequests();

        updateElevators(time);
    }



    private void updateRequests(int time) {
        int currentHuman = 0;
        while (currentHuman < mHumans.size()) {
            int sameRequests = 1;
            int fromFloor = mHumans.get(currentHuman).getCurrentFloor();
            int toFloor = mHumans.get(currentHuman).getNecessaryFloor();
            boolean isSame = false;
            int sameCounter = 0;
            do {
                Human h = mHumans.get(currentHuman + sameCounter + 1);
                if (h.getCurrentFloor() == fromFloor && h.getNecessaryFloor() == toFloor) {
                    isSame = true;
                    sameCounter++;
                } else {
                    isSame = false;
                }
            } while (isSame);

            List<Human> sameHumans = new ArrayList<Human>();
           //Request request = new Request(fromFloor, toFloor, time)
        }
    }

    private void processRequests() {

        for (Request request : mRequestsList) {
            Elevator elevator = getFreeElevator();
            if (elevator == null) {
                return;
            }

            elevator.processRequest(request);


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
