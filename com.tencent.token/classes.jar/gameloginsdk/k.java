package gameloginsdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.token.arn;
import com.tencent.token.ks;

public class k
{
  static ks a;
  
  private static void a(int paramInt1, String paramString, int paramInt2)
  {
    ks localks = a;
    localks.a = paramInt1;
    localks.b = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      localks.c = paramInt2;
      return;
    }
    throw new RuntimeException("appVersion couldn't be null or empty");
  }
  
  public static boolean a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      arn.a(paramContext);
      paramContext = new ks(paramContext);
      a = paramContext;
      arn.a(paramContext, paramInt2);
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