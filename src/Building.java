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
        mElevators = createElevators();
    }

    public void setElevators(List<Elevator> elevators) {
        mElevators = elevators;
    }

    public int getNumberOfFloors() {
        return mNumberOfFloors;
    }

    public void update(int time) {

    }

    public World getWorld() {
        return mWorld;
    }

    private List<Elevator> createElevators() {

        List<Elevator> elevators;
        Util.print("Введите количество лифтов");
        int numberOfElevators = Util.scanInt();
        if (numberOfElevators < 1) {
            Util.print("Количество лифтов задано неверно");
            System.exit(1);
        }

        Util.print("Ведите время посадки/высадки пассажиров");
        int landingTime = Util.scanInt();
        if (landingTime < 1) {
            Util.print("Время посадки не может быть меньше 1");
            System.exit(1);
        }

        elevators = new ArrayList<Elevator>(numberOfElevators);
        Util.print("Введите максимальное число людей, которое вмещает лифт");
        int maxPeople = Util.scanInt();
        if (maxPeople < 1) {
            Util.print("Максимальное количество людей не может быть меньше 1");
            System.exit(1);
        }

        for (int i = 0; i < numberOfElevators; i++) {
            Elevator elevator = new Elevator(this, maxPeople, landingTime);
            elevators.add(elevator);
        }

        return elevators;
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
