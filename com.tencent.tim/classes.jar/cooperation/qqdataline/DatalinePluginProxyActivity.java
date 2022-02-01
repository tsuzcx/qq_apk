package cooperation.qqdataline;

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
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import java.util.Iterator;
import java.util.List;

public class DatalinePluginProxyActivity
  extends PluginProxyActivity
{
  private static Class<? extends PluginProxyActivity> a(Intent paramIntent, String paramString)
  {
    if ((paramString != null) && (paramString.equals("com.qqdataline.activity.LiteWifiphotoActivity"))) {
      paramIntent.setFlags(paramIntent.getFlags() | 0x20000000);
    }
    if ((paramIntent.getFlags() & 0x20000000) != 0) {
      return SingleTop.class;
    }
    return DatalinePluginProxyActivity.class;
  }
  
  public static void a(Activity paramActivity, String paramString1, Intent paramIntent, String paramString2, int paramInt, arhz paramarhz)
  {
    paramIntent.putExtra("userQqResources", 2);
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "qqdataline.apk";
    locald.mPluginName = PluginInfo.cKB;
    locald.mUin = paramString1;
    locald.cKu = paramString2;
    locald.K = a(paramIntent, paramString2);
    locald.mIntent = paramIntent;
    locald.mRequestCode = paramInt;
    locald.mDialog = paramarhz;
    locald.mTimeOut = 10000;
    locald.cKv = null;
    avfw.a(paramActivity, locald);
  }
  
  public static boolean cJ(Context paramContext)
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
      if ("com.tencent.mobileqq:dataline".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  public String getPluginID()
  {
    return "qqdataline.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    if (paramString.equals("com.qqdataline.activity.LiteWifiphotoActivity")) {
      return SingleTop.class;
    }
    return super.getProxyActivity(paramString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!TextUtils.isEmpty(this.mCreateErrorInfo)) {
      if (paramBundle == null) {
        break label65;
      }
    }
    for (;;)
    {
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      StringBuffer localStringBuffer = new StringBuffer("[插件Activity启动] ");
      localStringBuffer.append(paramBundle).append(" ").append(this.mCreateErrorInfo);
      QLog.e("qqdataline", 1, localStringBuffer.toString());
      return;
      label65:
      paramBundle = getIntent().getExtras();
    }
  }
  
  public static class SingleTop
    extends DatalinePluginProxyActivity
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqdataline.DatalinePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */