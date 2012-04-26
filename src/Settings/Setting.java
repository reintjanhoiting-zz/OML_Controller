package Settings;

import android.app.Application;

public class Setting extends Application{

	public void onCreate()
	{
		super.onCreate();

		// Initialize the singletons so their instances
		// are bound to the application process.
		initSingletons();
	}

	protected void initSingletons()
	{
		// Initialize the instance of MySingleton
		Singleton.initInstance();
		
		/**
		  	demo for calling singleton
		  	// Call a custom method in MySingleton
		 	MySingleton.getInstance().customSingletonMethod();
		
			// Read the value of a variable in MySingleton
			String singletonVar = MySingleton.getInstance().customVar;
		 */
	}

	public void customAppMethod()
	{
		// Custom application method
	}
}
