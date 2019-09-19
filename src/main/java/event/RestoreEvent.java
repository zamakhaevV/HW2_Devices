package event;

public class RestoreEvent extends Event {
    public RestoreEvent(Integer deviceId, Integer componentId) {
        super(deviceId, componentId);
    }

    @Override
    public boolean getType() {
        return true;
    }
}
