/**
 * Created by lexer on 16.10.14.
 */
public class Human {

    private boolean mIsNeedElevator;
    private int mCurrentFloor = 0;
    private int mNecessaryFloor;
    private boolean mIsRequestAccepted;

    public Human(int currentFloor, int necessaryFloor, boolean isNeedElevator, int callElevatorTime) {
        this.mCurrentFloor = currentFloor;
        this.mNecessaryFloor = necessaryFloor;
        this.mIsNeedElevator = isNeedElevator;
    }


    public boolean isNeedElevator() {
        return mIsNeedElevator;
    }

    public boolean isWantToLeaveBuilding() {
        return !mIsNeedElevator && mCurrentFloor == 0;
    }

    public void setCurrentFloor(int floor) {
        mCurrentFloor = floor;
    }

    public int getCurrentFloor() {
        return mCurrentFloor;
    }

    public void setNecessaryFloor(int floor) {
        mNecessaryFloor = floor;
    }

    public int getNecessaryFloor() {
        return mNecessaryFloor;
    }

    public void setNeedElevetor(boolean isNeedElevator) {
        mIsNeedElevator = isNeedElevator;
    }
}
