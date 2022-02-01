package cooperation.qqpim;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import avfw;
import avfw.d;
import avli;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;

public class QQPimPluginProxyActivity
  extends PluginProxyActivity
{
  public static void a(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(avli.cLR), avli.cLO, QQPimPluginProxyActivity.class, paramDialog);
  }
  
  private static boolean a(Activity paramActivity, Intent paramIntent, String paramString1, String paramString2, Class<? extends Activity> paramClass, Dialog paramDialog)
  {
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", true);
    avfw.d locald = new avfw.d(1);
    locald.mPluginID = "qqpim_plugin.apk";
    locald.mPluginName = "QQ同步助手插件";
    locald.mUin = paramString1;
    locald.cKu = paramString2;
    locald.K = paramClass;
    locald.mIntent = paramIntent;
    locald.mRequestCode = -1;
    locald.mDialog = paramDialog;
    locald.mTimeOut = 30000;
    locald.cKv = null;
    locald.dmV = false;
    avfw.a(paramActivity, locald);
    if (QLog.isColorLevel()) {
      QLog.i(avli.TAG, 2, "QQPimPluginProxyActivity.openPluginActivityForResult() " + paramString2 + " IPluginManager.SUPPORT_NETWORKING " + true);
    }
    return true;
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, Dialog paramDialog)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    a(paramActivity, localIntent, paramBundle.getString(avli.cLR), avli.cLP, QQPimPluginProxyActivity.class, paramDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqpim.QQPimPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */