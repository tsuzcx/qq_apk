package btmsdkobf;

import android.util.Log;

public class eh
{
  private static boolean of = false;
  
  private static void a(int paramInt, String paramString1, String paramString2)
  {
    if (!of) {
      return;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "(null)";
    }
    Log.println(paramInt, "TMSDK_SK_".concat(String.valueOf(paramString1)), str);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramThrowable.getMessage());
    a(6, paramString1, localStringBuilder.toString());
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramThrowable.getMessage());
    a(6, paramString1, localStringBuilder.toString());
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
  
  public static void i(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.eh
 * JD-Core Version:    0.7.0.1
 */