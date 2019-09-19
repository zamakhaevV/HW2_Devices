package handler;

import event.Event;
import part.Component;
import part.Device;

import java.util.Map;
import java.util.Queue;

public class EventHandler {
    private Queue<Event> events;
    private Map<Integer, Device> devices;

    public EventHandler(Queue<Event> events, Map<Integer, Device> devices) {
        this.events = events;
        this.devices = devices;
    }

    public Queue<Event> getEvents() {
        return events;
    }

    public void setEvents(Queue<Event> events) {
        this.events = events;
    }

    public Map<Integer, Device> getDevices() {
        return devices;
    }

    public void setDevices(Map<Integer, Device> devices) {
        this.devices = devices;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void addEvents(Queue<Event> events) {
        this.events.addAll(events);
    }

    public void handleEvents() {
        while (!events.isEmpty()) {
            Event event = events.poll();
            Boolean type = event.getType();
            Integer deviceId = event.getDeviceId();
            Integer componentId = event.getComponentId();
            Device device = devices.get(deviceId);
            Map<Integer, Component> components = device.getComponents();
            Component component = components.get(componentId);
            component.setStatus(type);
            device.update();
        }
    }
}
