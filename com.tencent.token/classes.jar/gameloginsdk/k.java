package gameloginsdk;

import android.content.Context;
import c.a.b.a.b;
import tmsdk.common.a;

public class k
{
  static b a;
  
  private static void a(int paramInt1, String paramString, int paramInt2)
  {
    a.a(paramInt1, paramString, paramInt2);
  }
  
  public static boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      a.a(paramContext);
      a = new b(paramContext);
      a.a(a, paramInt2);
      a(paramInt1, paramString, paramInt2);
      return true;
    }
    catch (UnsatisfiedLinkError paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.k
 * JD-Core Version:    0.7.0.1
 */