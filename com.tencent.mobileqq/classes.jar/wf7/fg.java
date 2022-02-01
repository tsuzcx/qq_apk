package wf7;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

public class fg
{
  public static int G(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    if ((!paramString.startsWith("46000")) && (!paramString.startsWith("46002")) && (!paramString.startsWith("46007")))
    {
      if (paramString.startsWith("46001")) {
        return 1;
      }
      if (paramString.startsWith("46003")) {
        return 2;
      }
      return -1;
    }
    return 0;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String k(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    }
    catch (Exception paramContext)
    {
      label16:
      Object localObject;
      break label16;
    }
    paramContext = null;
    localObject = paramContext;
    if (paramContext == null) {
      localObject = "000000000000000";
    }
    return localObject;
  }
  
  public static int l(Context paramContext)
  {
    return G(k(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fg
 * JD-Core Version:    0.7.0.1
 */