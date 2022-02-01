package cooperation.qzone;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.MenuItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import ibx;
import iby;
import java.util.Iterator;
import java.util.List;

public class QzonePluginProxyActivity
  extends PluginProxyActivity
{
  public static final String a = "com.qzone";
  public static boolean a = false;
  private static final String[] a;
  static final String jdField_b_of_type_JavaLangString = "QZone";
  public static boolean b = false;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "com.qzone.vip.QZoneOpenVIPActivity", "com.qzone.common.activities.QzoneAdaptVideoActivity", "com.qzone.cover.ui.activity.QZoneCoverPreviewActivity", "com.qzone.log.CrashNotificationActivity", "com.qzone.common.activities.NotificationActivity" };
  static final String c = "qzone_plugin.apk";
  public static final String d = "qzone_plugin_activity_name";
  public static final String e = "com.qzone.preview.service.PictureService";
  public static final String f = "com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS";
  public static final String g = "com.qzone.publish.service.PublishQueueService";
  private static final String h = "Crash_Count_In_CNFException";
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "com.qzone.preview.QzonePictureViewer", "com.qzone.preview.LocalPictureViewer" };
  }
  
  public static Intent a()
  {
    Intent localIntent = new Intent(BaseApplication.getContext(), QzonePluginPublishQueueProxyService.class);
    localIntent.putExtra("pluginsdk_launchService", "com.qzone.publish.service.PublishQueueService");
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.putExtra("pluginsdk_pluginName", "个人空间");
    localIntent.putExtra("pluginsdk_pluginLocation", a());
    return localIntent;
  }
  
  public static ClassLoader a(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qzone_plugin.apk");
  }
  
  public static String a()
  {
    return "qzone_plugin.apk";
  }
  
  static String a(Intent paramIntent)
  {
    return paramIntent.getStringExtra("qzone_plugin_activity_name");
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    a(paramActivity, paramString, paramIntent, paramInt, null);
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Object localObject;
    if (!a(paramActivity))
    {
      localObject = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131427376));
      ((QQProgressDialog)localObject).b(2131559318);
      ((QQProgressDialog)localObject).setOnDismissListener(new ibx(paramOnDismissListener));
    }
    for (paramOnDismissListener = (DialogInterface.OnDismissListener)localObject;; paramOnDismissListener = null)
    {
      localObject = a(paramIntent);
      Class localClass = iby.a();
      paramIntent.putExtra("userQqResources", 1);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
      localPluginParams.jdField_b_of_type_JavaLangString = "qzone_plugin.apk";
      localPluginParams.d = "QZone";
      localPluginParams.jdField_a_of_type_JavaLangString = paramString;
      localPluginParams.e = ((String)localObject);
      localPluginParams.jdField_a_of_type_JavaLangClass = localClass;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localPluginParams.jdField_b_of_type_Int = paramInt;
      localPluginParams.jdField_a_of_type_AndroidAppDialog = paramOnDismissListener;
      localPluginParams.c = 10000;
      localPluginParams.f = null;
      IPluginManager.a(paramActivity, localPluginParams);
      return;
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    paramIntent.putExtra("qzone_plugin_activity_name", paramString);
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putBoolean("cleartop", true);
    paramBundle.putBoolean("PhotoConst.IS_CALL_IN_PLUGIN", true);
    paramBundle.putString("PhotoConst.PLUGIN_NAME", "QZone");
    paramBundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    Intent localIntent = new Intent(paramQQAppInterface.a(), QzonePluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
    localPluginParams.jdField_b_of_type_JavaLangString = a();
    localPluginParams.d = "QQ空间";
    localPluginParams.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
    localPluginParams.e = "com.qzone.preview.service.PictureService";
    localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, "Start QZone Preload");
    }
    IPluginManager.b(paramQQAppInterface.a(), localPluginParams);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent(paramQQAppInterface.a(), QzonePluginProxyService.class);
    localIntent.putExtra("useSkinEngine", 1);
    localIntent.setAction("com.qzone.intent.action.PRELOAD_QUN_ALBUM_FEEDS");
    localIntent.putExtra("qunid", paramString);
    localIntent.putExtra("qzone_uin", paramQQAppInterface.a());
    paramString = new IPluginManager.PluginParams(0);
    paramString.jdField_b_of_type_JavaLangString = a();
    paramString.d = "QQ空间";
    paramString.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
    paramString.e = "com.qzone.preview.service.PictureService";
    paramString.jdField_a_of_type_AndroidContentIntent = localIntent;
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, "Start QZone QunAlbum Preload");
    }
    IPluginManager.b(paramQQAppInterface.a(), paramString);
  }
  
  private static boolean a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:qzone".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean b(String[] paramArrayOfString, String paramString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public String getPluginID()
  {
    return "qzone_plugin.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return iby.a(paramString);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!TextUtils.isEmpty(this.mCreateErrorInfo)) {
      if (paramBundle == null) {
        break label69;
      }
    }
    for (;;)
    {
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      StringBuffer localStringBuffer = new StringBuffer("[插件启动失败] ");
      localStringBuffer.append(paramBundle).append(" ").append(this.mCreateErrorInfo);
      QLog.e("QZLog", 1, localStringBuffer.toString());
      return;
      label69:
      paramBundle = getIntent().getExtras();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    paramMenuItem.getItemId();
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected boolean shouldHandleStartPluginFailed(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    label60:
    do
    {
      do
      {
        return false;
        if (QzoneConfig.a().a("QZoneSetting", "PluginPermissionErrorHandle", 1) != 0) {}
        int j;
        for (i = 1;; i = 0)
        {
          j = QzoneConfig.a().a("QZoneSetting", "PluginErrorHandleCount", -1);
          if (j != 0) {
            break label60;
          }
          if (i == 0) {
            break;
          }
          return super.shouldHandleStartPluginFailed(paramString);
        }
        paramString = paramString.toLowerCase();
        if (!paramString.contains("classnotfoundexception")) {
          break;
        }
        SharedPreferences localSharedPreferences = getSharedPreferences("QZ_setting", 0);
        int k = localSharedPreferences.getInt("Crash_Count_In_CNFException", 0);
        localSharedPreferences.edit().putInt("Crash_Count_In_CNFException", k + 1).commit();
        if (k == 0)
        {
          QLog.e("Plugin", 1, "kill process with first Exception:" + paramString);
          finish();
          Process.killProcess(Process.myPid());
        }
        for (;;)
        {
          return true;
          if ((j >= 0) && (k >= j)) {
            break;
          }
          QLog.e("Plugin", 1, "show dialog with non-first Exception:" + paramString);
          showNeedUninstanllAndInstallDialog();
        }
      } while (i == 0);
      return super.shouldHandleStartPluginFailed(paramString);
    } while (i == 0);
    return super.shouldHandleStartPluginFailed(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */