/**
 * Created by lexer on 16.10.14.
 */
public class Elevator {

    enum State {
        MOVING_TO_HUMAN,
        MOVING_WITH_HUMAN,
        WAIT,
        EMBARKATION
    }

    //params
    private int mMaxPeople;

    //state params
    private int mCurrentFloor = 0;
    private int mCurrentNumberOfPeople;
    private int mEmbarkationTime;
    private int mCurrentEmbarkationTime = 0;

    private Request mRequest;

    private boolean mIsDisembarkation = false;

    private State mState = State.WAIT;

    public Elevator(int maxPeople, int embarkationTime) {
        this.mMaxPeople = maxPeople;
        this.mEmbarkationTime = embarkationTime;
    }

    public boolean isFree() {
        return mState.equals(State.WAIT);
    }

    public void processRequest(Request request) {
        mRequest = request;
        mState = State.MOVING_TO_HUMAN;
    }

    public void update(int time) {
        switch (mState) {
            case MOVING_TO_HUMAN:
                if (move()) {
                    mState = State.EMBARKATION;
                    mIsDisembarkation = false;
                }
                break;
            case MOVING_WITH_HUMAN:
                if (move()) {
                    mState = State.EMBARKATION;
                    mIsDisembarkation = true;
                }
                break;
            case WAIT:
                break;
            case EMBARKATION:
                updateEmbarkationTime();
                break;
        }
    }

    /*
      True if we already on needed floor
      False if we moving
   */
    private boolean move() {
        if (mCurrentFloor > mRequest.getFromFloor()) {
            moveUp();
            return false;
        } else if (mCurrentFloor < mRequest.getFromFloor()) {
            moveDown();
            return false;
        } return true;
    }

    private void moveUp() {
        mCurrentFloor++;
    }

    private void moveDown() {
        mCurrentFloor--;
    }

    private void updateEmbarkationTime() {
        mCurrentEmbarkationTime++;
        if (mCurrentEmbarkationTime >= mEmbarkationTime) {
            if (!mIsDisembarkation) {
                mState = State.MOVING_WITH_HUMAN;
            } else {
                mState = State.WAIT;
            }

            mCurrentEmbarkationTime = 0;
        }
    }
}
