package cooperation.qlink;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import ias;

public class QlinkPluginProxyActivity
  extends PluginProxyActivity
{
  private static final String a = "qlink_plugin.apk";
  private static final String b = "qlink_plugin_activity_name";
  
  public static ClassLoader a(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qlink_plugin.apk");
  }
  
  public static String a()
  {
    return "qlink_plugin.apk";
  }
  
  static String a(Intent paramIntent)
  {
    return paramIntent.getStringExtra("qlink_plugin_activity_name");
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    boolean bool = PluginUtils.isPluginInstalled(paramActivity, "qlink_plugin.apk", "603");
    if (QLog.isColorLevel()) {
      QLog.d("QlinkLog", 2, "launchPluingActivityForResult.isPluginInstalled end: " + bool);
    }
    Object localObject;
    if (!bool)
    {
      localObject = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131427376));
      ((QQProgressDialog)localObject).a(paramActivity.getString(2131559634));
      ((QQProgressDialog)localObject).setOnDismissListener(new ias(paramOnDismissListener));
    }
    for (paramOnDismissListener = (DialogInterface.OnDismissListener)localObject;; paramOnDismissListener = null)
    {
      paramIntent.putExtra("userQqResources", 1);
      localObject = new IPluginManager.PluginParams(0);
      ((IPluginManager.PluginParams)localObject).jdField_b_of_type_JavaLangString = "qlink_plugin.apk";
      ((IPluginManager.PluginParams)localObject).d = "近场传输";
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((IPluginManager.PluginParams)localObject).e = a(paramIntent);
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_JavaLangClass = QlinkPluginProxyActivity.class;
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidContentIntent = paramIntent;
      ((IPluginManager.PluginParams)localObject).jdField_b_of_type_Int = paramInt;
      ((IPluginManager.PluginParams)localObject).jdField_a_of_type_AndroidAppDialog = paramOnDismissListener;
      ((IPluginManager.PluginParams)localObject).c = 10000;
      ((IPluginManager.PluginParams)localObject).f = null;
      IPluginManager.a(paramActivity, (IPluginManager.PluginParams)localObject);
      return;
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("qlink_plugin_activity_name", paramString);
  }
  
  public String getPluginID()
  {
    return "qlink_plugin.apk";
  }
  
  protected void onCreate(Bundle paramBundle)
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
      StringBuffer localStringBuffer = new StringBuffer("[插件启动失败] ");
      localStringBuffer.append(paramBundle).append(" ").append(this.mCreateErrorInfo);
      QLog.e("QLinkLog", 1, localStringBuffer.toString());
      return;
      label65:
      paramBundle = getIntent().getExtras();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */