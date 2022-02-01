package wf7;

import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import java.io.File;

public class gq
{
  public static Object T(String paramString)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return gt.a("android.content.pm.PackageParser", null);
      }
      paramString = gt.a("android.content.pm.PackageParser", new Object[] { paramString });
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Object a(Object paramObject, File paramFile, String paramString, DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 21) {
        return gt.a(paramObject, "parsePackage", new Object[] { paramFile, Integer.valueOf(paramInt) });
      }
      paramObject = gt.a(paramObject, "parsePackage", new Object[] { paramFile, paramString, paramDisplayMetrics, Integer.valueOf(paramInt) });
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.gq
 * JD-Core Version:    0.7.0.1
 */