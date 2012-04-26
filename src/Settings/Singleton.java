package Settings;

public class Singleton {
	private static Singleton instance;

	public String customVar;
	public String IpAdress;
	public String Port;
	public boolean Cam;
	public boolean Admin;
		
	public static void initInstance()
	{
		if (instance == null)
		{
			// Create the instance
			instance = new Singleton();
		}
	}

	public static Singleton getInstance()
	{
		// Return the instance
		return instance;
	}

	private Singleton()
	{
		// Constructor hidden because this is a singleton
	}

	public void customSingletonMethod()
	{
		// Custom method
	}
}
