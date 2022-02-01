import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper.2;
import cooperation.qqfav.QfavHelper.4;
import cooperation.qqfav.QfavHelper.AsyncFavoritesProvider.1;
import cooperation.qqfav.QfavPluginProxyActivity;
import cooperation.qqfav.QfavPluginProxyReceiver;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class avja
{
  private static SharedPreferences ai;
  private static final AtomicBoolean eF = new AtomicBoolean(false);
  
  public static boolean W(ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForArkApp)paramChatMessage;
    return (paramChatMessage != null) && ((aeii.bxC.equals(paramChatMessage.ark_app_message.appName)) || ("com.tencent.structmsg".equals(paramChatMessage.ark_app_message.appName)));
  }
  
  public static FileManagerEntity a(Bundle paramBundle, String paramString, int paramInt)
  {
    if (paramBundle == null) {
      return null;
    }
    String str1 = paramBundle.getString("key_fav_file_forward_cid");
    String str2 = paramBundle.getString("key_fav_file_forward_uuid");
    byte[] arrayOfByte = paramBundle.getByteArray("key_fav_file_forward_md5");
    String str3 = paramBundle.getString("key_fav_file_forward_name");
    long l = paramBundle.getLong("key_fav_file_forward_file_size", 0L);
    paramBundle = paramBundle.getString("forward_filepath");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (arrayOfByte == null)) {
      return null;
    }
    return ahav.a(str1, str2, paramBundle, str3, l, aqhs.bytes2HexStr(arrayOfByte), paramString, paramInt);
  }
  
  public static void a(Context paramContext, OnPluginInstallListener paramOnPluginInstallListener)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getApplication();
    }
    try
    {
      new QfavHelper.4((Context)localObject, paramOnPluginInstallListener).start();
      return;
    }
    catch (Throwable paramContext)
    {
      do
      {
        paramContext.printStackTrace();
      } while (paramOnPluginInstallListener == null);
      try
      {
        paramOnPluginInstallListener.onInstallError("qqfav.apk", -1);
        return;
      }
      catch (RemoteException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    a(paramContext, paramString1, paramBoolean1, paramString2, paramBoolean2, 2131693408);
  }
  
  @TargetApi(9)
  public static void a(Context paramContext, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    QQToast localQQToast = new QQToast(paramContext);
    localQQToast.setDuration(2000);
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }
    if (paramBoolean1)
    {
      localQQToast.setType(2);
      localQQToast.setToastIcon(QQToast.getIconRes(2));
      localQQToast.setToastMsg(paramInt);
      if (!l(paramContext).getBoolean("pref_first_collection_" + str, true)) {}
    }
    for (;;)
    {
      try
      {
        paramString2 = paramContext.getString(2131693449);
        if (!paramBoolean2) {
          continue;
        }
        paramString1 = paramContext.getString(2131693444);
        paramString1 = aqha.a(paramContext, 230, paramString2, paramString1, 2131721058, 2131693447, new avjb(), null);
        if (paramContext != BaseApplicationImpl.getContext()) {
          break label636;
        }
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        if (Build.VERSION.SDK_INT < 26) {
          continue;
        }
        paramString1.getWindow().setType(2038);
        paramInt = 1;
        int j = 1;
        int i = j;
        if (paramInt != 0)
        {
          i = j;
          if (Build.VERSION.SDK_INT >= 23)
          {
            i = j;
            if (!Settings.canDrawOverlays(paramContext)) {
              i = 0;
            }
          }
        }
        if ((paramInt == 0) || (i != 0)) {
          continue;
        }
        paramString1 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        paramString1.addFlags(268435456);
        BaseApplicationImpl.getApplication().startActivity(paramString1);
      }
      catch (Throwable paramString1)
      {
        QLog.e("qqfav", 1, "First collection guide error. Uin=" + str + ", flag=" + l(paramContext).getBoolean(new StringBuilder().append("pref_first_collection_").append(str).toString(), true));
        continue;
        l(paramContext).edit().putBoolean("pref_first_collection_" + str, false).apply();
        continue;
      }
      localQQToast.show(paramContext.getResources().getDimensionPixelSize(2131299627) - (int)(5.0F * paramContext.getResources().getDisplayMetrics().density));
      return;
      paramString1 = paramContext.getString(2131693448);
      continue;
      if (Build.VERSION.SDK_INT > 24)
      {
        paramString1.getWindow().setType(2003);
        paramInt = 1;
      }
      else
      {
        paramString1.getWindow().setType(2005);
        paramInt = 0;
        continue;
        paramString1.getWindow().setType(2003);
        paramInt = 1;
        continue;
        paramString1.setMessageCount(null).show();
        if (9 > Build.VERSION.SDK_INT)
        {
          l(paramContext).edit().putBoolean("pref_first_collection_" + str, false).commit();
          if (QLog.isColorLevel()) {
            QLog.d("qqfav", 2, "First collection guide shown. Uin=" + str + ", flag=" + l(paramContext).getBoolean(new StringBuilder().append("pref_first_collection_").append(str).toString(), true));
          }
        }
        else
        {
          localQQToast.setType(1);
          localQQToast.setToastIcon(QQToast.getIconRes(1));
          if (paramString2 == null)
          {
            localQQToast.setToastMsg(2131693409);
          }
          else
          {
            localQQToast.setToastMsg(paramString2);
            continue;
            label636:
            paramInt = 0;
          }
        }
      }
    }
  }
  
  public static boolean a(Activity paramActivity, String paramString, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 7);
    return QfavPluginProxyActivity.a(paramActivity, paramString, localIntent, -1);
  }
  
  public static boolean a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    paramIntent.setFlags(paramIntent.getFlags() & 0xFBFFFFFF & 0xDFFFFFFF);
    return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
  }
  
  public static boolean a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    if (paramIntent == null) {}
    for (paramIntent = new Intent();; paramIntent = new Intent(paramIntent))
    {
      paramIntent.putExtra("nOperation", 2);
      paramIntent.putExtra("bShowProgress", paramBoolean);
      paramIntent.putExtra("begin", System.currentTimeMillis());
      avjj.ZS(paramString);
      if (!avjh.a().isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.d("qqfav", 2, "openPluginActivityForResult need pending data." + paramIntent.toString());
        }
        byte[] arrayOfByte = avjh.a().aK();
        if ((arrayOfByte == null) && (QLog.isColorLevel())) {
          QLog.d("qqfav", 2, "openPluginActivityForResult pending data error.");
        }
        paramIntent.putExtra("pendingData", arrayOfByte);
      }
      return QfavPluginProxyActivity.a(paramActivity, paramString, paramIntent, paramInt);
    }
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 9);
    localIntent.putExtra("lId", paramLong1);
    localIntent.putExtra("custom_fav_id", paramLong1);
    localIntent.putExtra("moveToGroupAction", true);
    localIntent.putExtra("custom_group_id", paramLong2);
    localIntent.putExtra("mov_to_group", true);
    localIntent.putExtra("custom_without_callback", true);
    return QfavPluginProxyActivity.a(paramContext, paramString, localIntent, -1);
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 6);
    localIntent.putExtra("lId", paramLong);
    localIntent.putExtra("backUpFavData", paramArrayOfByte);
    return QfavPluginProxyActivity.a(paramContext, paramString, localIntent, -1);
  }
  
  public static Object b(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    for (;;)
    {
      try
      {
        Class localClass = Class.forName(paramString);
        if (localClass == null) {
          QLog.i("qqfavQfavHelper#createInstance", 1, "className =" + paramString + ",cls == null");
        }
        paramArrayOfClass = localClass.getDeclaredConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
        if (paramArrayOfClass != null) {
          break;
        }
        QLog.i("qqfavQfavHelper#createInstance", 4, "className =" + paramString + ",retObj == null");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localObject = getClassLoader();
        if (localObject != null)
        {
          localObject = ((ClassLoader)localObject).loadClass(paramString);
          continue;
        }
      }
      catch (Exception paramString)
      {
        QLog.i("qqfavQfavHelper#createInstance", 1, "Exception =" + QLog.getStackTraceString(paramString));
        return null;
      }
      Object localObject = null;
    }
    return paramArrayOfClass;
  }
  
  public static AppRuntime b(BaseApplicationImpl paramBaseApplicationImpl)
  {
    return (AppRuntime)b("com.qqfav.QfavAppInterface", new Class[] { BaseApplicationImpl.class, String.class }, new Object[] { paramBaseApplicationImpl, "qqfav" });
  }
  
  public static byte[] b(boolean paramBoolean)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("bPublicAccount", paramBoolean);
      localObject = ((JSONObject)localObject).toString().getBytes();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.i("qqfav", 2, "publicAccountLinkBizData: JSONException error");
    }
    return null;
  }
  
  public static boolean bN(boolean paramBoolean)
  {
    if (eF.get()) {
      return true;
    }
    Object localObject2 = new QfavHelper.2();
    if (paramBoolean) {}
    synchronized (eF)
    {
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getApplication(), new avjc((Runnable)localObject2));
      localObject2 = eF;
      if (??? == localObject2) {}
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqfav", 2, "wait(sPluginInstalled) qqfav.apk");
        }
        eF.wait(5000L);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "qqfav.apk, sPluginInstalled = " + eF);
      }
      return eF.get();
      ??? = localObject2;
    }
  }
  
  public static boolean c(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 3);
    return QfavPluginProxyActivity.a(paramActivity, paramString, localIntent, -1);
  }
  
  public static boolean cK(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localRunningAppProcessInfo.processName != null) && (localRunningAppProcessInfo.processName.endsWith(":qqfav"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean d(Context paramContext, String paramString, long paramLong)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("nOperation", 6);
    localIntent.putExtra("lId", paramLong);
    return QfavPluginProxyActivity.a(paramContext, paramString, localIntent, -1);
  }
  
  public static ClassLoader getClassLoader()
  {
    Object localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    try
    {
      localObject = PluginStatic.getOrCreateClassLoader((Context)localObject, "qqfav.apk");
      QLog.i("qqfavQfavHelper#getClassLoader", 1, "Exception =" + QLog.getStackTraceString(localException1));
    }
    catch (Exception localException1)
    {
      try
      {
        BasicClassTypeUtil.setClassLoader(true, (ClassLoader)localObject);
        return localObject;
      }
      catch (Exception localException2)
      {
        break label24;
      }
      localException1 = localException1;
      localObject = null;
    }
    label24:
    return localObject;
  }
  
  public static SharedPreferences l(Context paramContext)
  {
    try
    {
      if (ai == null) {
        ai = paramContext.getSharedPreferences("shared_prefs_qfav", 4);
      }
      paramContext = ai;
      return paramContext;
    }
    finally {}
  }
  
  public static void u(AppRuntime paramAppRuntime)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    int i;
    if (Build.VERSION.SDK_INT > 10)
    {
      i = 4;
      if (!((BaseApplicationImpl)localObject).getSharedPreferences("QfavNeedReupload", i).getBoolean(paramAppRuntime.getAccount() + "QfavNeedReupload", false)) {
        break label112;
      }
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "reuploadQfavItems: flag=true");
      }
      localObject = new Intent("com.tencent.mobileqq.ACTION_QFAVIPC_BROADCAST");
      ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
      ((Intent)localObject).putExtra("nOperation", 5);
      QfavPluginProxyReceiver.d(paramAppRuntime, (Intent)localObject);
    }
    label112:
    while (!QLog.isColorLevel())
    {
      return;
      i = 0;
      break;
    }
    QLog.i("qqfav", 2, "reuploadQfavItems: flag=false");
  }
  
  public static abstract class a
    extends OnPluginInstallListener.Stub
  {
    public Bundle bK;
    
    public a(Bundle paramBundle)
    {
      this.bK = paramBundle;
    }
    
    public void execute()
    {
      avja.a(BaseApplication.getContext(), this);
    }
    
    public abstract void l(boolean paramBoolean, Bundle paramBundle);
    
    public void onInstallBegin(String paramString)
      throws RemoteException
    {}
    
    public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
      throws RemoteException
    {}
    
    public void onInstallError(String paramString, int paramInt)
      throws RemoteException
    {
      l(false, this.bK);
    }
    
    public void onInstallFinish(String paramString)
      throws RemoteException
    {
      ThreadManager.getSubThreadHandler().post(new QfavHelper.AsyncFavoritesProvider.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avja
 * JD-Core Version:    0.7.0.1
 */