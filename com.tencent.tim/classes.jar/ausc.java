import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public final class ausc
{
  public static boolean bb(Context paramContext, String paramString)
  {
    try
    {
      getPackageInfo(paramContext, paramString);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
    throws PackageManager.NameNotFoundException
  {
    return paramContext.getPackageManager().getPackageInfo(paramString, 0);
  }
  
  public static int w(Context paramContext, String paramString)
    throws PackageManager.NameNotFoundException
  {
    return getPackageInfo(paramContext, paramString).versionCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ausc
 * JD-Core Version:    0.7.0.1
 */