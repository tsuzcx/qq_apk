package taiji;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public class ck
{
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        if (paramContext != null) {
          return true;
        }
      }
      catch (Throwable paramContext) {}
    }
    return false;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return null;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        if (paramContext != null)
        {
          paramContext = paramContext.versionName;
          return paramContext;
        }
      }
      catch (Throwable paramContext) {}
    }
    return null;
  }
  
  public static int c(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return 0;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        if (paramContext != null)
        {
          int i = paramContext.versionCode;
          return i;
        }
      }
      catch (Throwable paramContext) {}
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     taiji.ck
 * JD-Core Version:    0.7.0.1
 */