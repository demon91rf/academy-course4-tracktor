Ветка соответствует уроку 1.9 курса 4.

В рамках этого урока были внесены следующие изменения в проект:
- создан новый пакет api с классом DistanceMatrixResponse и интерфейсом DistanceMatrixApi
- создан новый пакет common с классом SingleFragmentActivity
- добавлены классы AddPositionToRouteEvent, GetFullRouteEvent, SetStartPositionToRouteEvent в пакет event
- изменена реализация класса StopRouteEvent
- созданы новые пакеты map и results в пакете ui
- классы CounterFragment и MainActivity перенесены в пакет map
- созданы классы ResultsActivity и ResultsDetailsFragment в пакете results
- создан новый пакет util c классами NetworkUtils и StringUtil
- изменены реализации методов onLocationResult(), onStartRoute(), onStopRoute() в классе MainActivity
- изменены реализации методов startTimer(), stopTimer(), onCleared() в классе CounterViewModel
- реализованы методы onGetFullRoute(), onAddPositionToRoute(), onSetStartPositionToRoute() в классе CounterViewModel
