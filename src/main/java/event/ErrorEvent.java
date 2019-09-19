package event;

public class ErrorEvent extends Event {
    public ErrorEvent(Integer deviceId, Integer componentId) {
        super(deviceId, componentId);
    }

    @Override
    public boolean getType() {
        return false;
    }

}
