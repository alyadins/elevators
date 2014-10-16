/**
 * Created by lexer on 16.10.14.
 */
public class Human {

    private boolean mIsNeedElevator;
    private int mCallElevatorTime;
    private int mCurrentFloor = 0;
    private int mNecessaryFloor;

    public Human(int currentFloor, int necessaryFloor, boolean isNeedElevator, int callElevatorTime) {
        this.mCurrentFloor = currentFloor;
        this.mNecessaryFloor = necessaryFloor;
        this.mIsNeedElevator = isNeedElevator;
        this.mCallElevatorTime = callElevatorTime;
    }


    public boolean isNeedElevator() {
        return mIsNeedElevator;
    }
}
