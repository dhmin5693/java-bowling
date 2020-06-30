package bowling.domain.frame;

import bowling.domain.status.Status;

public class Pins {
    private int downPin;

    private Pins(int downPin) {
        this.downPin = downPin;
    }

    public static Pins init() {
        return new Pins(0);
    }

    public Status bowl(int downPin) {
        validateRange(this.downPin + downPin);
        Status status = Status.makeStatus(this.downPin, downPin);

        this.downPin += downPin;
        return status;
    }

    public Status firstBowl(int downPin) {
        validateRange(downPin);

        this.downPin = downPin;
        return Status.makeStatus(this.downPin);
    }

    public int getDownPin() {
        return downPin;
    }

    private void validateRange(int downPin) {
        if (downPin < 0 || downPin > 10) {
            throw new IllegalArgumentException("투구 값이 유효 범위가 아닙니다.");
        }

    }



}
