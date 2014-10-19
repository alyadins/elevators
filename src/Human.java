/**
 * Created by lexer on 16.10.14.
 */
public class Human {

    private boolean mIsNeedElevator;
    private int mCurrentFloor = 0;
    private int mNecessaryFloor;
    private Request mRequest;
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

    public void setRequest(Request request) {
        mRequest = request;
    }

    public boolean isRequestAccepted() {
        return mIsRequestAccepted;
    }

    public void setRequestAccepted(boolean isAccepted) {
        mIsRequestAccepted = isAccepted;
    }

    public void clearRequest() {
        mRequest = null;
    }
}
