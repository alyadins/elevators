/**
 * Created by lexer on 16.10.14.
 */
public class Elevator {

    //params
    private int mMaxPeople;

    //state params
    private int mCurrentFloor = 0;
    private int mNextFloor;
    private int mCurrentNumberOfPeople;
    private int mLandingTime;


    public Elevator(int maxPeople, int landingTime) {
        this.mMaxPeople = maxPeople;
        this.mLandingTime = landingTime;
    }
}
