package cooperation.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
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
import hzo;
import hzp;
import hzq;
import hzs;
import hzt;
import hzu;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import mqq.manager.Manager;

public abstract class IPluginManager
  extends RemotePluginManager.Stub
  implements Manager
{
  public static final int a = 950604;
  private static PluginManagerHelper.OnPluginManagerLoadedListener jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener;
  private static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public static final boolean a = false;
  
  public static IPluginManager a(QQAppInterface paramQQAppInterface)
  {
    return new PluginManagerV2(paramQQAppInterface);
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
    Object localObject = BaseApplicationImpl.a.a();
    if (!(localObject instanceof QQAppInterface))
    {
      f(paramActivity, paramPluginParams);
      return;
    }
    if (paramPluginParams.jdField_a_of_type_AndroidAppDialog != null) {
      new SplashDialogWrapper(paramActivity, paramPluginParams.jdField_a_of_type_AndroidAppDialog, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString, paramPluginParams.jdField_a_of_type_Boolean, paramPluginParams.jdField_c_of_type_Int).show();
    }
    ((IPluginManager)((QQAppInterface)localObject).getManager(24)).a(paramActivity, paramPluginParams, new hzo());
  }
  
  public static void a(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    Object localObject = PluginInstaller.a(paramContext, paramPluginParams.jdField_b_of_type_JavaLangString);
    if (localObject != null) {}
    try
    {
      paramPluginParams.jdField_c_of_type_JavaLangString = ((File)localObject).getCanonicalPath();
      label21:
      localObject = BaseApplicationImpl.a.a();
      if (!(localObject instanceof QQAppInterface))
      {
        c(paramContext, paramPluginParams);
        return;
      }
      ((IPluginManager)((QQAppInterface)localObject).getManager(24)).a(paramContext, paramPluginParams, new hzs());
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
      localObject = BaseApplicationImpl.a.a();
      if (!(localObject instanceof QQAppInterface))
      {
        d(paramContext, paramPluginParams);
        return;
      }
      ((IPluginManager)((QQAppInterface)localObject).getManager(24)).a(paramContext, paramPluginParams, new hzt());
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
      hzu localhzu = (hzu)jdField_a_of_type_JavaUtilHashMap.get(paramPluginParams.jdField_b_of_type_JavaLangString);
      if (localhzu == null)
      {
        localhzu = new hzu(paramPluginParams.jdField_a_of_type_JavaLangString, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString);
        jdField_a_of_type_JavaUtilHashMap.put(paramPluginParams.jdField_b_of_type_JavaLangString, localhzu);
        localhzu.a(paramActivity, paramPluginParams);
        localhzu.execute(new Void[0]);
        return;
      }
      localhzu.a(paramActivity, paramPluginParams);
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
  
  private static void e(Activity paramActivity, IPluginManager.PluginParams paramPluginParams)
  {
    paramActivity.runOnUiThread(new hzp(paramPluginParams, paramActivity, paramActivity));
  }
  
  private static void e(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      hzu localhzu = (hzu)jdField_a_of_type_JavaUtilHashMap.get(paramPluginParams.jdField_b_of_type_JavaLangString);
      if (localhzu == null)
      {
        localhzu = new hzu(paramPluginParams.jdField_a_of_type_JavaLangString, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString);
        jdField_a_of_type_JavaUtilHashMap.put(paramPluginParams.jdField_b_of_type_JavaLangString, localhzu);
        localhzu.a(paramContext, paramPluginParams);
        localhzu.execute(new Void[0]);
        return;
      }
      localhzu.a(paramContext, paramPluginParams);
    }
  }
  
  private static void f(Activity paramActivity, IPluginManager.PluginParams paramPluginParams)
  {
    jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener = new hzq(paramPluginParams, paramActivity);
    PluginManagerHelper.getPluginInterface(paramActivity, jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerHelper$OnPluginManagerLoadedListener);
  }
  
  private static void f(Context paramContext, IPluginManager.PluginParams paramPluginParams)
  {
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      hzu localhzu = (hzu)jdField_a_of_type_JavaUtilHashMap.get(paramPluginParams.jdField_b_of_type_JavaLangString);
      if (localhzu == null)
      {
        localhzu = new hzu(paramPluginParams.jdField_a_of_type_JavaLangString, paramPluginParams.d, paramPluginParams.jdField_b_of_type_JavaLangString);
        jdField_a_of_type_JavaUtilHashMap.put(paramPluginParams.jdField_b_of_type_JavaLangString, localhzu);
        localhzu.b(paramContext, paramPluginParams);
        localhzu.execute(new Void[0]);
        return;
      }
      localhzu.b(paramContext, paramPluginParams);
    }
  }
  
  public abstract PluginInfo a(String paramString);
  
  public abstract void a();
  
  public abstract void a(Context paramContext, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener);
  
  public abstract void a(Context paramContext, PluginInfo paramPluginInfo, IPluginManager.PluginParams paramPluginParams, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, boolean paramBoolean, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean a(String paramString, IPluginManager.OnQueryPluginListener paramOnQueryPluginListener);
  
  public abstract void cancelInstall(String paramString);
  
  public abstract void installPlugin(String paramString, OnPluginInstallListener paramOnPluginInstallListener);
  
  public abstract boolean isPlugininstalled(String paramString);
  
  public abstract boolean isReady();
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.plugin.IPluginManager
 * JD-Core Version:    0.7.0.1
 */