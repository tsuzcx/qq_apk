import java.util.HashMap;

public class gis
{
  private static HashMap a = new HashMap();
  
  public static String a(long paramLong)
  {
    try
    {
      String str = (String)a.get(String.valueOf(paramLong));
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      a.remove(String.valueOf(paramLong));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(long paramLong, String paramString)
  {
    try
    {
      a.put(String.valueOf(paramLong), paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gis
 * JD-Core Version:    0.7.0.1
 */