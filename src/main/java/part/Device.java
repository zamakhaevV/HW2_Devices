package part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Device {
    private final Logger log = LoggerFactory.getLogger(Device.class);
    private Integer id;
    private String name;
    private Map<Integer, Component> components;
    private Status status;

    public Device(Integer id, String name, Map<Integer, Component> components) {
        this.id = id;
        this.name = name;
        this.components = components;
        this.status = Status.NORMAL;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setComponents(HashMap<Integer, Component> components) {
        this.components = components;
    }

    public Map<Integer, Component> getComponents() {
        return components;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void update() {
        int numberOfHalf = components.size() / 2;
        int numberOfBroken = 0;
        for(Map.Entry<Integer, Component> entry : components.entrySet()) {
            Component component = entry.getValue();
            Boolean status = component.getStatus();
            if (!status) {
                ++numberOfBroken;
            }
        }

        Status newStatus;
        if (numberOfBroken == 0) {
            newStatus = Status.NORMAL;
        } else if (numberOfBroken > numberOfHalf) {
            newStatus = Status.ERROR;
        } else {
            newStatus = Status.WARNING;
        }

        if (status != newStatus) {
            status = newStatus;
            log.info(String.format("Device id = %d, name = %s changed its state to %s", id, name, status));
        }
    }

    @Override
    public String toString() {
        String str = "";

        str += "Device info:\n";
        str += String.format("--- id = %d\n", id);
        str += String.format("--- name = %s\n", name);
        str += String.format("--- status = %s\n", status);
        str += "--- components = {\n";

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Component> entry : components.entrySet()) {
            sb.append(entry.getValue().toString());
            sb.append(",\n");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("}");

        return str + sb.toString();
    }
}
