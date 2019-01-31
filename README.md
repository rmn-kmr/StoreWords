# StoreWords
This sample app is based on Android new Architecture Components Like **Room, ViewModel and LiveData** . 

It Simply stores words into SQLite using Room layer.

![alt text](https://codelabs.developers.google.com/codelabs/android-training-livedata-viewmodel/img/25beb0344c741aaa.png)

## Room Database
Room is a database layer on top of an SQLite database. Room takes care of mundane tasks that you used to handle with a database helper class such as SQLiteOpenHelper.

	* Room uses the DAO to issue queries to its database.
	
	* By default, to avoid poor UI performance, Room doesn't allow you to issue database queries on the main thread. LiveData applies this rule by automatically running the query asynchronously on a background thread, when needed.

	* Room provides compile-time checks of SQLite statements.
	
	* Your Room class must be abstract and extend RoomDatabase.
	
	* Usually, you only need one instance of the Room database for the whole app.

## LiveData
LiveData, which is a lifecycle library class for data observation, can help your app respond to data changes. If you use a return value of type LiveData in your method description, Room generates all necessary code to update the LiveData when the database is updated.

## ViewModel
A ViewModel holds your app's UI data in a way that survives configuration changes. Separating your app's UI data from your Activity and Fragment classes lets you better follow the single responsibility principle: Your activities and fragments are responsible for drawing data to the screen, while your ViewModel is responsible for holding and processing all the data needed for the UI.
