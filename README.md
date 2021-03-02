Ветка соответствует уроку 1.6 курса 4.

В рамках этого урока были внесены следующие изменения в проект:
- добавлена зависимость com.google.android.gms:play-services-location:15.0.1 в build.gradle(Module)
- добавлены поля UPDATE_INTERVAL, UPDATE_FASTEST_INTERVAL, UPDATE_MIN_DISTANCE, DEFAULT_ZOOM, mFusedLocationClient, mLocationRequest, mLocationCallback в класс MainActivity
- реализуем метод onLocationResult
- инициализируем mFusedLocationClient в методе onCreate()
- инициализируем mLocationRequest в методе onCreate()
- изменяем реализацию метода initMap()

