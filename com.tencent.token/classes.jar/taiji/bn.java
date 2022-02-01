package taiji;

import android.util.Log;

public class bn
{
  private static boolean a = false;
  
  public static void a(String paramString1, String paramString2)
  {
    if (a()) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a()) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a()) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a()) {
      Log.w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.bn
 * JD-Core Version:    0.7.0.1
 */