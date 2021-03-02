Ветка соответствует уроку 1.8 курса 4.

В рамках этого урока были внесены следующие изменения в проект:
- добавлены поля mRoute, isRouteStarted в класс MainActivity
- изменена реализация метода onLocationResult()
- добавлены методы onResume(), onPause(), onStartRoute(), onStopRoute() в класс MainActivity
- создан новый пакет event с классами StartRouteEvent и StopRouteEvent
- изменена реализация метода startTimer() в классе CounterViewModel
- изменена реализация метода stopTimer() в классе CounterViewModel
