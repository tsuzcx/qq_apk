import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class aqlq
{
  private static String cud;
  private static final String[] hU = { "com.android.launcher.permission.READ_SETTINGS", "com.android.launcher2.permission.READ_SETTINGS", "com.android.launcher3.permission.READ_SETTINGS", "com.google.android.launcher.permission.READ_SETTINGS", "com.huawei.android.launcher.permission.READ_SETTINGS", "com.huawei.launcher2.permission.READ_SETTINGS", "com.huawei.launcher3.permission.READ_SETTINGS", "com.bbk.launcher2.permission.READ_SETTINGS", "com.huaqin.launcherEx.permission.READ_SETTINGS", "com.htc.launcher.permission.READ_SETTINGS", "com.htc.launcher.settings", "com.oppo.launcher.permission.READ_SETTINGS", "com.meizu.android.launcher.permission.READ_SETTINGS", "com.meizu.launcher2.permission.READ_SETTINGS", "com.meizu.android.launcher3.permission.READ_SETTINGS", "com.lenovo.launcher.permission.READ_SETTINGS", "com.ebproductions.android.launcher.permission.READ_SETTINGS", "com.android.mylauncher.permission.READ_SETTINGS", "com.sec.android.app.twlauncher.settings.READ_SETTINGS", "com.fede.launcher.permission.READ_SETTINGS", "net.qihoo.launcher.permission.READ_SETTINGS", "com.qihoo360.launcher.permission.READ_SETTINGS", "com.lge.launcher.permission.READ_SETTINGS", "org.adw.launcher.permission.READ_SETTINGS", "telecom.mdesk.permission.READ_SETTINGS" };
  
  private static String a(Context paramContext, String[] paramArrayOfString)
  {
    try
    {
      paramContext = alkx.a(paramContext.getPackageManager(), 10);
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ProviderInfo[] arrayOfProviderInfo = ((PackageInfo)paramContext.next()).providers;
          if (arrayOfProviderInfo != null)
          {
            int k = arrayOfProviderInfo.length;
            int i = 0;
            while (i < k)
            {
              ProviderInfo localProviderInfo = arrayOfProviderInfo[i];
              if (localProviderInfo != null)
              {
                int m = paramArrayOfString.length;
                int j = 0;
                while (j < m)
                {
                  if (paramArrayOfString[j].equals(localProviderInfo.readPermission))
                  {
                    paramContext = localProviderInfo.authority;
                    return paramContext;
                  }
                  j += 1;
                }
              }
              i += 1;
            }
          }
        }
      }
      return null;
    }
    catch (RuntimeException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static String bh(Context paramContext)
  {
    if (cud == null)
    {
      cud = a(paramContext, hU);
      if (cud == null) {
        break label88;
      }
    }
    label88:
    for (cud = "content://" + cud + "/favorites?notify=true";; cud = "empty")
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.shortcut", 2, "getShortcutUri.shortcutUri=" + cud);
      }
      return cud;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqlq
 * JD-Core Version:    0.7.0.1
 */