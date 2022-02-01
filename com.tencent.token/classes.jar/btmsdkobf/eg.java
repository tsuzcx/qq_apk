package btmsdkobf;

import android.util.Log;

public final class eg
{
  private static boolean of = true;
  
  static void a(int paramInt, String paramString1, String paramString2)
  {
    if (!of) {
      return;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "(null)";
    }
    Log.println(paramInt, "TMSDK_".concat(String.valueOf(paramString1)), str);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2);
  }
  
  public static void f(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2);
  }
  
  public static void g(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2);
  }
  
  public static void h(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2);
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    of = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.eg
 * JD-Core Version:    0.7.0.1
 */