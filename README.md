# Java-школа
## Домашнее задание №2
Имеется набор устройств Device. Каждый device имеет id (Integer), name (String), набор компонентов Component и status (для статуса устройства предусмотрено три значения: normal, warning, error).

Component имеет id (Integer), name, status (Boolean). Status true означает что компонент работает исправно, а false – что компонент сломан.

Нужно хранить в какой-либо структуре данных набор всех устройств (Device) системы, должна быть возможность получить все данные об устройстве по его Id.
 
В систему на вход поступает набор событий Event. События могут быть разных типов ErrorEvent, RestoreEvent.

ErrorEvent содержит поля:
Integer deviceId
Integer componentId
 
RestoreEvent содержит поля:
Integer deviceId
Integer componentId

Считать, что на вход подается очередь сообщений Event. Программа обрабатывает каждое сообщение из этой очереди последовательно. Событие ErrorEvent говорит о том что компонент componentId у устройства deviceId сломался. Событие RestoreEvent говорит о том что компонент componentId у устройства deviceId восстановил свою работу.
 
Если все компоненты устройства работают, устройство в статусе Normal.

Если хотя бы одна компонента устройства не работает, устройство в статусе Warning.

Если более половины компонент устройства не работает, устройство в статусе Error.

При изменении состояния устройства (Device) нужно написать в лог следующее
“Устройство id = ?, name = ? изменило свое состояние на ?”.

### Для запуска:
$ java -jar .../target/devices-1.0-SNAPSHOT.jar

Количество устройств = 10,
Количество компонетнов устройств = 5,
Количество событий = 50
