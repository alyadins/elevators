/**
 * Created by lexer on 16.10.14.
 */
public class Elevator {

    //params
    private int mMaxPeople;

    //state params
    private int mCurrentFloor;
    private int mNextFloor;
    private int mCurrentNumberOfPeople;


    public Elevator(int maxPeople) {
        this.mMaxPeople = maxPeople;
    }
}
