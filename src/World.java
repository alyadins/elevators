import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lexer on 16.10.14.
 */
public class World {

    private static final int TIME_OF_THE_WORLD = 20;
    private static final int CLOSE_TIME = 800;
    private static final int PORTION_OF_PEOPLE = 10;

    private final Random mRandom = new Random();
    private int mCurrentTime = 0;
    private Building mBuilding;
    private List<Human> mHumans;

    public World() {
        createBuilding();
        mHumans = new ArrayList<Human>();
        start();
    }

    /*
        Main loop
     */
    private void start() {

        for (mCurrentTime = 0; mCurrentTime < TIME_OF_THE_WORLD; mCurrentTime++){
            if (mCurrentTime < CLOSE_TIME) {
                createNewPortionOfPeople(mCurrentTime);
            }

            clearHumans();
            mBuilding.setHumans(mHumans);
            mBuilding.update(mCurrentTime);
        }
    }


    private void createNewPortionOfPeople(int time) {

        int numberOfNewPeople = mRandom.nextInt(PORTION_OF_PEOPLE);
        for (int i = 0; i < numberOfNewPeople; i++) {
            int wantedFloor = mRandom.nextInt(mBuilding.getNumberOfFloors() - 1) + 1;
            Human human = new Human(mRandom.nextInt(), wantedFloor, true, time);
            mHumans.add(human);
        }
    }


    /*
        Remove all humans who is on the zero floor and not need elevator
     */
    private void clearHumans() {

        List<Human> humansForRemove = new ArrayList<Human>();
        for (Human h : mHumans) {
            if (h.isWantToLeaveBuilding()) {
                humansForRemove.add(h);
            }
        }

        mHumans.removeAll(humansForRemove);
    }
    private void createBuilding() {

        Util.print("Введите количество этажей");
        int numberOfFloor = Util.scanInt();
        if (numberOfFloor < 2) {
            Util.print("Колличество этажей задано неверно");
            System.exit(1);
        }

        mBuilding = new Building(numberOfFloor);
        List<Elevator> elevators = createElevators();
        mBuilding.setElevators(elevators);
        Util.print("Здание создано");
    }

    private static List<Elevator> createElevators() {

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
            Elevator elevator = new Elevator(maxPeople, landingTime);
            elevators.add(elevator);
        }

        return elevators;
    }
}
