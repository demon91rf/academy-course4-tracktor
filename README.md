Ветка соответствует уроку 1.5 курса 4.

В рамках этого урока были внесены следующие изменения в проект:
- добавлена зависимость com.google.android.gms:play-services-maps:15.0.1 в build.gradle(Module)
- добавлена вёрстка для фрагмента в res/layout/activity_main.xml
- имплементированы интерфейсы GoogleMap.OnMyLocationButtonClickListener,GoogleMap.OnMyLocationClickListener, OnMapReadyCallback в MainActivity и реализуем их
- изменена реализация метода initMap()
- проинициализирован фрагмент внутри метода onCreate()
