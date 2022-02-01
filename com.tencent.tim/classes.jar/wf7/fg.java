package wf7;

import alla;
import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

public class fg
{
  public static int G(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return -1;
      if ((paramString.startsWith("46000")) || (paramString.startsWith("46002")) || (paramString.startsWith("46007"))) {
        return 0;
      }
      if (paramString.startsWith("46001")) {
        return 1;
      }
    } while (!paramString.startsWith("46003"));
    return 2;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String k(Context paramContext)
  {
    try
    {
      paramContext = alla.e((TelephonyManager)paramContext.getSystemService("phone"));
      Object localObject = paramContext;
      if (paramContext == null) {
        localObject = "000000000000000";
      }
      return localObject;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  public static int l(Context paramContext)
  {
    return G(k(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.fg
 * JD-Core Version:    0.7.0.1
 */