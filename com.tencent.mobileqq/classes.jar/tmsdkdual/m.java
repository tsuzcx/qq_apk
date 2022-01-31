package tmsdkdual;

import android.util.Log;

public final class m
{
  private static boolean ad = false;
  
  public static void a(String paramString, Object paramObject)
  {
    if (ad) {
      Log.println(6, paramString, (String)paramObject);
    }
  }
  
  public static void b(String paramString, Object paramObject)
  {
    if (ad) {
      Log.println(4, paramString, (String)paramObject);
    }
  }
  
  public static void c(boolean paramBoolean)
  {
    ad = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     tmsdkdual.m
 * JD-Core Version:    0.7.0.1
 */