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

    public List<Human> getHumans() {
        return mHumans;
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
            mBuilding.update(mCurrentTime);
        }
    }


    private void createNewPortionOfPeople(int time) {

        int numberOfNewPeople = mRandom.nextInt(PORTION_OF_PEOPLE);
        for (int i = 0; i < numberOfNewPeople; i++) {
            int wantedFloor = mRandom.nextInt(mBuilding.getNumberOfFloors() - 1) + 1;
            int fromFloor = mRandom.nextInt(mBuilding.getNumberOfFloors() - 1) + 1;
            Human human = new Human(fromFloor, wantedFloor, true, time);
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

        mBuilding = new Building(this, numberOfFloor);
        Util.print("Здание создано");
    }


}
