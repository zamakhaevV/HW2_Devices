package event;

public abstract class Event {
    private Integer deviceId;
    private Integer componentId;

    Event(Integer deviceId, Integer componentId) {
        this.deviceId = deviceId;
        this.componentId = componentId;
    }

    public abstract boolean getType();

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setComponentId(Integer componentId) {
        this.componentId = componentId;
    }

    public Integer getComponentId() {
        return componentId;
    }
}
