package moai.core.utilities.deviceutil;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

public class AppInfos
{
  public static String getLauncherClassName(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.addCategory("android.intent.category.LAUNCHER");
    ResolveInfo localResolveInfo = localPackageManager.resolveActivity(localIntent, 65536);
    paramContext = localResolveInfo;
    if (localResolveInfo == null) {
      paramContext = localPackageManager.resolveActivity(localIntent, 0);
    }
    return paramContext.activityInfo.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.deviceutil.AppInfos
 * JD-Core Version:    0.7.0.1
 */