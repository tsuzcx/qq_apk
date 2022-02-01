import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.ROMUtil;

public class aqin
{
  public static Intent d(Context paramContext)
  {
    if (("MIUI".equals(ROMUtil.getRomName())) && (Build.VERSION.SDK_INT > 19)) {
      return h(paramContext);
    }
    if (("SMARTISAN".equals(ROMUtil.getRomName())) || ("360".equals(ROMUtil.getRomName()))) {
      return g(paramContext);
    }
    return f(paramContext);
  }
  
  public static Intent f(Context paramContext)
  {
    Intent localIntent;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localIntent = new Intent();
      localIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      localIntent.putExtra("android.provider.extra.APP_PACKAGE", paramContext.getPackageName());
      localIntent.putExtra("android.provider.extra.CHANNEL_ID", paramContext.getApplicationInfo().uid);
      return localIntent;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localIntent = new Intent();
      localIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
      localIntent.putExtra("app_package", paramContext.getPackageName());
      localIntent.putExtra("app_uid", paramContext.getApplicationInfo().uid);
      return localIntent;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return g(paramContext);
    }
    return g(paramContext);
  }
  
  public static Intent g(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.parse("package:" + paramContext.getPackageName()));
    return localIntent;
  }
  
  public static Intent h(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return g(paramContext);
    }
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setClassName("com.android.settings", "com.android.settings.Settings$NotificationFilterActivity");
    localIntent.putExtra("appName", paramContext.getResources().getString(paramContext.getApplicationInfo().labelRes));
    localIntent.putExtra("packageName", paramContext.getPackageName());
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqin
 * JD-Core Version:    0.7.0.1
 */