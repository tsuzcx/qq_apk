package cooperation.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager.Stub;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.statistics.PluginStatisticsCollector;
import com.tencent.mobileqq.widget.QFavDownloadProgressDialog;
import fjr;
import fjs;
import fjt;
import fju;
import fjv;
import fjy;
import fjz;
import fka;
import fkb;
import fkc;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public abstract class IPluginManager
  extends RemotePluginManager.Stub
  implements Manager
{
  public static final int a = 220357;
  private static Dialog jdField_a_of_type_AndroidAppDialog = null;
  private static volatile PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private static PluginManagerHelper.OnPluginManagerLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener;
  private static QFavDownloadProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQFavDownloadProgressDialog = null;
  public static final String a = "E53452856ABF6D72B0F7C49C5D14EC6E";
  private static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public static final boolean a = false;
  public static final String b = "http://i.gtimg.cn/qqshow/admindata/comdata/vip_mobile_theme_lite_night/qqfav20150707.zip";
  
  private static Dialog a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    String str3 = paramContext.getResources().getString(paramInt1);
    Object localObject = paramContext.getResources().getString(paramInt2);
    String str2 = paramContext.getResources().getString(paramInt3);
    String str1 = paramContext.getResources().getString(paramInt4);
    if ((paramString != null) && (!"".equals(paramString))) {}
    for (paramString = String.format((String)localObject, new Object[] { paramString });; paramString = (String)localObject)
    {
      paramContext = new Dialog(paramContext, 2131624119);
      paramContext.setContentView(2130903135);
      localObject = (TextView)paramContext.findViewById(2131296915);
      if (localObject != null) {
        ((TextView)localObject).setText(str3);
      }
      localObject = (TextView)paramContext.findViewById(2131296470);
      if (localObject != null) {
        ((TextView)localObject).setText(paramString);
      }
      paramString = (TextView)paramContext.findViewById(2131296918);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setOnClickListener(paramOnClickListener1);
      }
      paramString = (TextView)paramContext.findViewById(2131296919);
      if (paramString != null)
      {
        paramString.setText(str1);
        paramString.setOnClickListener(paramOnClickListener2);
      }
      return paramContext;
    }
  }
  
  public static IPluginManager a(QQAppInterface paramQQAppInterface)
  {
    return new PluginManagerV2(paramQQAppInterface);
  }
  
  public static PluginInfo a()
  {
    PluginInfo localPluginInfo = new PluginInfo();
    localPluginInfo.mID = "qqfav.apk";
    localPluginInfo.mMD5 = "E53452856ABF6D72B0F7C49C5D14EC6E";
    localPluginInfo.mType = 0;
    localPluginInfo.mPackageName = "com.qqfav";
    localPluginInfo.mLength = 220357L;
    localPluginInfo.mCurVersion = 10000L;
    localPluginInfo.mState = 0;
    localPluginInfo.mUpdateType = 1;
    localPluginInfo.mURL = "http://i.gtimg.cn/qqshow/admindata/comdata/vip_mobile_theme_lite_night/qqfav20150707.zip";
    return localPluginInfo;
  }
  
  static File a(Context paramContext)
  {
    return paramContext.getDir("", 0);
  }
  
  public static void a(Activity paramActivity, IPluginManager.PluginParams paramPluginParams)
  {
    if (paramPluginParams.f != null)
    {
      localObject = Toast.makeText(paramActivity, paramPluginParams.f, 0);
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).show();
    }
    Object localObject = new fjr();
    if (paramPluginParams.jdField_a_of_type_AndroidAppDialog != null) {
      new SplashDialogWrapper(paramActivity, paramPluginParams.jdField_a_of_type_AndroidAppDialog, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_a_of_type_Boolean, paramPluginParams.jdField_c_of_type_Int).show();
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.a.a();
    if (!(localAppRuntime instanceof QQAppInterface))
    {
      c(paramActivity, paramPluginParams, (IPluginManager.OnPluginReadyListener)localObject);
      return;
    }
    ((IPluginManager)((QQAppInterface)localAppRuntime).getManager(25)).a(paramActivity, paramPluginParams, (IPluginManager.OnPluginReadyListener)localObject);
  }
  
  public static void a(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    Object localObject = PluginInstaller.a(paramContext, paramPluginParams.jdField_b_of_type_JavaLangString);
    if (localObject != null) {}
    try
    {
      paramPluginParams.jdField_c_of_type_JavaLangString = ((File)localObject).getCanonicalPath();
      label21:
      localObject = new fka();
      AppRuntime localAppRuntime = BaseApplicationImpl.a.a();
      if (!(localAppRuntime instanceof QQAppInterface))
      {
        c(paramContext, paramPluginParams, (IPluginManager.OnPluginReadyListener)localObject);
        return;
      }
      ((IPluginManager)((QQAppInterface)localAppRuntime).getManager(25)).a(paramContext, paramPluginParams, (IPluginManager.OnPluginReadyListener)localObject);
      return;
    }
    catch (IOException localIOException)
    {
      break label21;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.toLowerCase();
      if ((paramString1.contains("空间")) || (paramString1.contains("space"))) {
        Toast.makeText(BaseApplicationImpl.getContext(), "系统可用内存不足，" + paramString2 + "启动失败!", 0).show();
      }
    }
    else
    {
      return;
    }
    Toast.makeText(BaseApplicationImpl.getContext(), paramString2 + "启动失败!", 0).show();
  }
  
  static void a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        RemoteCommand localRemoteCommand = (RemoteCommand)paramList.get(i);
        if ((localRemoteCommand != null) && (!localPluginCommunicationHandler.containsCmd(localRemoteCommand.getCmd()))) {
          localPluginCommunicationHandler.register((RemoteCommand)paramList.get(i));
        }
        i += 1;
      }
    }
  }
  
  public static boolean a()
  {
    return PluginManagerV2.b();
  }
  
  public static boolean a(String paramString)
  {
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient != null) {
      return jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.isPluginInstalled(paramString);
    }
    return false;
  }
  
  private static QFavDownloadProgressDialog b(Context paramContext, String paramString)
  {
    paramContext = new QFavDownloadProgressDialog(paramContext);
    paramContext.a(new fjt(paramString, paramContext));
    return paramContext;
  }
  
  public static void b(Activity paramActivity, IPluginManager.PluginParams paramPluginParams)
  {
    a(paramPluginParams.jdField_a_of_type_JavaUtilList);
    try
    {
      if (TextUtils.isEmpty(paramPluginParams.jdField_c_of_type_JavaLangString)) {
        paramPluginParams.jdField_c_of_type_JavaLangString = PluginInstaller.a(paramActivity, paramPluginParams.jdField_b_of_type_JavaLangString).getCanonicalPath();
      }
      label32:
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.setClass(paramActivity, paramPluginParams.jdField_a_of_type_JavaLangClass);
      if (TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin")))
      {
        paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
        paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      }
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
      PluginProxyActivity.openActivityForResult(paramActivity, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_c_of_type_JavaLangString, paramPluginParams.e, paramPluginParams.jdField_a_of_type_AndroidContentIntent, paramPluginParams.jdField_b_of_type_Int);
      return;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public static void b(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    Object localObject = PluginInstaller.a(paramContext, paramPluginParams.jdField_b_of_type_JavaLangString);
    if (localObject != null) {}
    try
    {
      paramPluginParams.jdField_c_of_type_JavaLangString = ((File)localObject).getCanonicalPath();
      label21:
      localObject = new fkb();
      AppRuntime localAppRuntime = BaseApplicationImpl.a.a();
      if (!(localAppRuntime instanceof QQAppInterface))
      {
        c(paramContext, paramPluginParams, (IPluginManager.OnPluginReadyListener)localObject);
        return;
      }
      ((IPluginManager)((QQAppInterface)localAppRuntime).getManager(25)).a(paramContext, paramPluginParams, (IPluginManager.OnPluginReadyListener)localObject);
      return;
    }
    catch (IOException localIOException)
    {
      break label21;
    }
  }
  
  static void c(Activity paramActivity, IPluginManager.PluginParams paramPluginParams)
  {
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      fkc localfkc = (fkc)jdField_a_of_type_JavaUtilHashMap.get(paramPluginParams.jdField_b_of_type_JavaLangString);
      if (localfkc == null)
      {
        localfkc = new fkc(paramPluginParams.jdField_a_of_type_JavaLangString, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString);
        jdField_a_of_type_JavaUtilHashMap.put(paramPluginParams.jdField_b_of_type_JavaLangString, localfkc);
        localfkc.a(paramActivity, paramPluginParams);
        localfkc.execute(new Void[0]);
        return;
      }
      localfkc.a(paramActivity, paramPluginParams);
    }
  }
  
  public static void c(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    a(paramPluginParams.jdField_a_of_type_JavaUtilList);
    try
    {
      if (TextUtils.isEmpty(paramPluginParams.jdField_c_of_type_JavaLangString)) {
        paramPluginParams.jdField_c_of_type_JavaLangString = PluginInstaller.a(paramContext, paramPluginParams.jdField_b_of_type_JavaLangString).getCanonicalPath();
      }
      label32:
      if ((TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_JavaLangString)))
      {
        paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
        paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      }
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
      PluginProxyBroadcastReceiver.sendBroadcastReceiver(paramContext, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_c_of_type_JavaLangString, paramPluginParams.e, paramPluginParams.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  private static void c(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener != null) {
      return;
    }
    if ((jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient == null) || (!jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.useful()))
    {
      jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener = new fjs(paramContext, paramPluginParams, paramOnPluginReadyListener);
      PluginManagerHelper.getPluginInterface(paramContext, jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener);
      return;
    }
    d(paramContext, paramPluginParams, paramOnPluginReadyListener);
  }
  
  public static void d(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    a(paramPluginParams.jdField_a_of_type_JavaUtilList);
    try
    {
      if (TextUtils.isEmpty(paramPluginParams.jdField_c_of_type_JavaLangString)) {
        paramPluginParams.jdField_c_of_type_JavaLangString = PluginInstaller.a(paramContext, paramPluginParams.jdField_b_of_type_JavaLangString).getCanonicalPath();
      }
      label32:
      if ((TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin"))) && (!TextUtils.isEmpty(paramPluginParams.jdField_a_of_type_JavaLangString)))
      {
        paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("uin", paramPluginParams.jdField_a_of_type_JavaLangString);
        paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("qzone_uin", paramPluginParams.jdField_a_of_type_JavaLangString);
      }
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("pluginsdk_selfuin", paramPluginParams.jdField_a_of_type_JavaLangString);
      paramPluginParams.jdField_a_of_type_AndroidContentIntent.putExtra("clsUploader", PluginStatisticsCollector.class.getName());
      if (paramPluginParams.jdField_a_of_type_AndroidContentServiceConnection != null)
      {
        PluginProxyService.bindService(paramContext, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_c_of_type_JavaLangString, paramPluginParams.e, paramPluginParams.jdField_a_of_type_AndroidContentIntent, paramPluginParams.jdField_a_of_type_AndroidContentServiceConnection);
        return;
      }
      PluginProxyService.openService(paramContext, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_c_of_type_JavaLangString, paramPluginParams.e, paramPluginParams.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  private static void d(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener)
  {
    if (jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.isPluginInstalled(paramPluginParams.jdField_b_of_type_JavaLangString))
    {
      if (paramOnPluginReadyListener != null) {
        paramOnPluginReadyListener.a(true, paramContext, paramPluginParams);
      }
      return;
    }
    if (paramPluginParams.jdField_b_of_type_JavaLangString.equals("qqfav.apk"))
    {
      jdField_a_of_type_AndroidAppDialog = a(paramContext, 2131363265, 2131363270, 2131362790, 2131363447, (float)Math.round(21.014881134033203D) / 100.0F + "", new fju(), new fjv(paramContext, paramPluginParams, paramOnPluginReadyListener));
      jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new fjy());
      jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin(paramPluginParams.jdField_b_of_type_JavaLangString, new fjz(paramOnPluginReadyListener, paramContext, paramPluginParams));
  }
  
  private static void e(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      fkc localfkc = (fkc)jdField_a_of_type_JavaUtilHashMap.get(paramPluginParams.jdField_b_of_type_JavaLangString);
      if (localfkc == null)
      {
        localfkc = new fkc(paramPluginParams.jdField_a_of_type_JavaLangString, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString);
        jdField_a_of_type_JavaUtilHashMap.put(paramPluginParams.jdField_b_of_type_JavaLangString, localfkc);
        localfkc.a(paramContext, paramPluginParams);
        localfkc.execute(new Void[0]);
        return;
      }
      localfkc.a(paramContext, paramPluginParams);
    }
  }
  
  private static void f(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      fkc localfkc = (fkc)jdField_a_of_type_JavaUtilHashMap.get(paramPluginParams.jdField_b_of_type_JavaLangString);
      if (localfkc == null)
      {
        localfkc = new fkc(paramPluginParams.jdField_a_of_type_JavaLangString, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString);
        jdField_a_of_type_JavaUtilHashMap.put(paramPluginParams.jdField_b_of_type_JavaLangString, localfkc);
        localfkc.b(paramContext, paramPluginParams);
        localfkc.execute(new Void[0]);
        return;
      }
      localfkc.b(paramContext, paramPluginParams);
    }
  }
  
  public abstract PluginInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean a(String paramString, IPluginManager.OnQueryPluginListener paramOnQueryPluginListener);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.IPluginManager
 * JD-Core Version:    0.7.0.1
 */