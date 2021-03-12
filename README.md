Ветка соответствует уроку 2.3 курса 4.

В рамках этого урока были внесены следующие изменения в проект:

- FrameLayout изменён на ImageView в fr_result_detail.xml
- добавлен класс ScreenshotMaker в пакет util
- добавлено поле mScreenshotImage в класс ResultDetailsFragment 
- удалена имплементация интерфейса OnMapReadyCallback в класс ResultDetailsFragment
- удалены поля mMap и mRoute в классе ResultDetailsFragment
- изменена реализация метода onViewCreated в классе ResultDetailsFragment
- добавлен метод takeScreenshot в класс MainActivity
- изменена реализация метода onStopRoute в классе MainActivity
- изменена реализация метода start в классе ResultsActivity
- поле ROUTE_KEY изменено на SCREENSHOT_KEY в классе ResultsActivity

