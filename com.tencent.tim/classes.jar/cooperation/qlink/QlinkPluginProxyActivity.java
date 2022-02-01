package cooperation.qlink;

import acfp;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import arhz;
import avfw;
import avfw.d;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import java.util.Iterator;
import java.util.List;

public class QlinkPluginProxyActivity
  extends PluginProxyActivity
{
  public static String FQ()
  {
    return "qlink_plugin.apk";
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, arhz paramarhz)
  {
    paramIntent.putExtra("userQqResources", 2);
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "qlink_plugin.apk";
    locald.mPluginName = PluginInfo.cKA;
    locald.mUin = paramString;
    locald.cKu = f(paramIntent);
    locald.K = QlinkPluginProxyActivity.class;
    locald.mIntent = paramIntent;
    locald.mRequestCode = paramInt;
    locald.mDialog = paramarhz;
    locald.mTimeOut = 10000;
    locald.cKv = null;
    avfw.a(paramActivity, locald);
  }
  
  public static ClassLoader b(Context paramContext)
    throws Exception
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qlink_plugin.apk");
  }
  
  public static boolean cI(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:qlink".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  static String f(Intent paramIntent)
  {
    return paramIntent.getStringExtra("qlink_plugin_activity_name");
  }
  
  public static void x(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("qlink_plugin_activity_name", paramString);
  }
  
  public String getPluginID()
  {
    return "qlink_plugin.apk";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!TextUtils.isEmpty(this.mCreateErrorInfo)) {
      if (paramBundle == null) {
        break label68;
      }
    }
    for (;;)
    {
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      StringBuffer localStringBuffer = new StringBuffer(acfp.m(2131711300));
      localStringBuffer.append(paramBundle).append(" ").append(this.mCreateErrorInfo);
      QLog.e("QLinkLog", 1, localStringBuffer.toString());
      return;
      label68:
      paramBundle = getIntent().getExtras();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */