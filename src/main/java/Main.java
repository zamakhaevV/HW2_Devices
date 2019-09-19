import event.ErrorEvent;
import event.Event;
import event.RestoreEvent;
import handler.EventHandler;
import part.Component;
import part.Device;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Initialization
        Random random = new Random();

        int numberOfDevices = 10;
        int numberOfComponents = 5;
        int numberOfEvents = 50;

        Map<Integer, Device> devices = new HashMap<>();
        for (int i = 0; i < numberOfDevices; ++i) {
            String deviceName = String.format("device%d", i);

            Map<Integer, Component> components = new HashMap<>();
            for (int j = 0; j < numberOfComponents; ++j) {
                String componentName = String.format("component%d", j);
                Component component = new Component(j, componentName);
                components.put(j, component);
            }

            Device device = new Device(i, deviceName, components);
            devices.put(i, device);
        }

        Queue<Event> events = new LinkedList<>();
        for (int i = 1; i < numberOfEvents; ++i) {
            int deviceId = random.nextInt(numberOfDevices);
            int componentId = random.nextInt(numberOfComponents);
            Event event;
            if (i % 4 == 0) {
                event = new RestoreEvent(deviceId, componentId);
            } else {
                event = new ErrorEvent(deviceId, componentId);
            }
            events.add(event);
        }
        // End of initialization

        EventHandler eventHandler = new EventHandler(events, devices);
        eventHandler.handleEvents();
    }
}
