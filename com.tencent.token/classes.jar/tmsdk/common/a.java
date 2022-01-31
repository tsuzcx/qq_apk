package tmsdk.common;

import android.content.Context;
import com.tencent.token.f;
import tmsdk.common.a.b;
import tmsdk.common.d.a.b.g;
import tmsdk.common.d.a.b.r;

public class a
{
  public static int a;
  private static Context b = null;
  
  public static Context a()
  {
    return b;
  }
  
  public static String a(String paramString)
  {
    return null;
  }
  
  public static void a(int paramInt, Class paramClass) {}
  
  public static void a(Context paramContext)
  {
    b = paramContext.getApplicationContext();
  }
  
  public static void a(g paramg, int paramInt)
  {
    a = paramInt;
    ((r)b.a(r.class)).a(paramg, false);
  }
  
  public static int b(String paramString)
  {
    if ("build".equals(paramString)) {
      return a;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.a
 * JD-Core Version:    0.7.0.1
 */