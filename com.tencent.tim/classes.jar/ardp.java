import java.lang.reflect.Method;

public class ardp
{
  public static Method getMethod(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static Class loadClass(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = paramClassLoader.loadClass(paramString);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      paramClassLoader.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardp
 * JD-Core Version:    0.7.0.1
 */