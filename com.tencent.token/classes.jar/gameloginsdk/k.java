package gameloginsdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.aot;
import com.tencent.token.kb;

public class k
{
  static kb a;
  
  private static void a(int paramInt1, String paramString, int paramInt2)
  {
    kb localkb = a;
    localkb.a = paramInt1;
    localkb.b = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localkb.c = paramInt2;
      return;
    }
    throw new RuntimeException("appVersion couldn't be null or empty");
  }
  
  public static boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      aot.a(paramContext);
      paramContext = new kb(paramContext);
      a = paramContext;
      aot.a(paramContext, paramInt2);
      a(paramInt1, paramString, paramInt2);
      return true;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      label30:
      break label30;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.k
 * JD-Core Version:    0.7.0.1
 */