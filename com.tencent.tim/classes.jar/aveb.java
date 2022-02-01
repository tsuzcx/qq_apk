import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicProxyActivity;
import cooperation.comic.VipProxyPreLoadComicProcess;
import cooperation.comic.utils.QQComicPluginBridge.1;
import cooperation.plugin.PluginInfo;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Observer;
import mqq.app.AppRuntime;

public class aveb
{
  public static avdl a;
  public static avdp a;
  public static avdz a;
  public static avef a;
  public static volatile boolean dmO;
  private static final Object mLock = new Object();
  
  public static boolean a(Activity paramActivity, Intent paramIntent, String paramString, ahyh paramahyh)
  {
    if ((!dmO) || (paramActivity == null) || (paramIntent == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramIntent.putExtra("big_brother_source_key", "biz_src_zz_bodong");
    if ((paramActivity instanceof BasePluginActivity))
    {
      paramActivity.startActivity(paramIntent);
      return true;
    }
    paramIntent.putExtra("userQqResources", 2);
    paramIntent.putExtra("useSkinEngine", false);
    paramIntent.putExtra("params_remote_connect_at_launch", true);
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "comic_plugin.apk";
    locald.mPluginName = "comic_plugin";
    locald.mUin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    locald.cKu = paramString;
    locald.K = VipComicProxyActivity.e(paramString);
    locald.mIntent = paramIntent;
    locald.mTimeOut = 10000;
    locald.a = paramahyh;
    avfw.a(paramActivity, locald);
    return true;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, boolean paramBoolean, aveb.b arg2)
  {
    boolean bool = false;
    if (p(paramAppRuntime))
    {
      dmO = true;
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic is ready");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        paramAppRuntime = (avfw)paramAppRuntime.getManager(27);
        if (paramAppRuntime != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQComicPluginBridge", 2, "PluginManager is NOT ready");
      return false;
      ThreadManager.executeOnNetWorkThread(new QQComicPluginBridge.1(paramAppRuntime, ???));
    } while (!paramBoolean);
    PluginInfo localPluginInfo = paramAppRuntime.b("comic_plugin.apk");
    if ((localPluginInfo != null) && (localPluginInfo.mState != 4)) {}
    for (;;)
    {
      synchronized (mLock)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicPluginBridge", 2, "QQComic is waiting for installation");
        }
        try
        {
          mLock.wait();
          if (QLog.isColorLevel()) {
            QLog.d("QQComicPluginBridge", 2, "QQComic installation is finished");
          }
          paramAppRuntime = paramAppRuntime.b("comic_plugin.apk");
          if ((paramAppRuntime != null) && (paramAppRuntime.mState == 4))
          {
            paramBoolean = true;
            dmO = paramBoolean;
            if (QLog.isColorLevel())
            {
              ??? = new StringBuilder().append("QQComic is ");
              if (!dmO) {
                break label229;
              }
              paramAppRuntime = "installed";
              QLog.d("QQComicPluginBridge", 2, paramAppRuntime);
            }
            return dmO;
          }
        }
        catch (InterruptedException localInterruptedException) {}
      }
      paramBoolean = false;
      continue;
      label229:
      paramAppRuntime = "NOT installed";
    }
  }
  
  public static avdq b(WebViewPlugin.a parama, avdm paramavdm)
  {
    if (jdField_a_of_type_Avdp == null) {
      return null;
    }
    return jdField_a_of_type_Avdp.a(parama, paramavdm);
  }
  
  public static void ei(Intent paramIntent)
  {
    boolean bool7 = false;
    int i = 0;
    boolean bool5 = true;
    if (paramIntent == null) {
      return;
    }
    String str = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.comic_plugin_profile.name(), "");
    if (QLog.isColorLevel()) {
      QLog.d("QQComicPluginBridge", 2, "parseDPC config = " + str);
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        arrayOfInteger = new Integer[7];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        arrayOfInteger[2] = Integer.valueOf(1);
        if (DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.e()) >= arrayOfInteger.length)
        {
          i = arrayOfInteger[0].intValue();
          if (i == 1) {
            bool1 = true;
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          boolean bool6;
          try
          {
            i = arrayOfInteger[1].intValue();
            if (i == 1) {
              bool2 = true;
            }
          }
          catch (Exception localException2)
          {
            Integer[] arrayOfInteger;
            int j;
            bool2 = true;
            bool3 = bool1;
            i = 0;
            bool1 = false;
            bool4 = false;
            continue;
          }
          try
          {
            i = arrayOfInteger[2].intValue();
            if (i == 1) {
              bool3 = true;
            }
          }
          catch (Exception localException3)
          {
            bool5 = true;
            bool3 = bool1;
            i = 0;
            bool4 = bool2;
            bool1 = false;
            bool2 = bool5;
            continue;
          }
          try
          {
            i = arrayOfInteger[3].intValue();
            if (i == 1) {
              bool4 = true;
            }
          }
          catch (Exception localException4)
          {
            bool6 = false;
            bool4 = bool1;
            bool5 = bool2;
            i = 0;
            bool1 = bool6;
            bool2 = bool3;
            bool3 = bool4;
            bool4 = bool5;
            continue;
          }
          try
          {
            i = arrayOfInteger[5].intValue();
          }
          catch (Exception localException5)
          {
            bool5 = bool1;
            bool6 = bool2;
            i = 0;
            bool1 = bool4;
            bool2 = bool3;
            bool3 = bool5;
            bool4 = bool6;
            continue;
          }
          try
          {
            j = arrayOfInteger[6].intValue();
            if (j == 1)
            {
              bool6 = bool4;
              bool7 = bool3;
              bool4 = bool2;
              bool3 = bool1;
              bool2 = bool7;
              bool1 = bool6;
              paramIntent.putExtra("isSetHardWareLayerForWebview", bool4);
              paramIntent.putExtra("isHandleNavigationBar", bool2);
              paramIntent.putExtra("isCloseHardAcc", bool1);
              paramIntent.putExtra("bitDepthFlag", i);
              paramIntent.putExtra("skipBitmapReuse", bool5);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("QQComicDebug", 2, "parseDPC isPreloadInMiddlePage = " + bool3 + " , isSetHardWareLayerForWebview = " + bool4 + " , isHandleNavigationBar = " + bool2 + " , isCloseHardAcc = " + bool1 + " , bitDepthFlag = " + i + " , skipBitmapReuse = " + bool5);
              return;
              bool1 = false;
              continue;
              bool2 = false;
              continue;
              bool3 = false;
              continue;
              bool4 = false;
              continue;
            }
            bool5 = false;
            continue;
            localException1 = localException1;
            bool2 = true;
            bool3 = false;
            bool4 = false;
            bool1 = false;
            i = 0;
          }
          catch (Exception localException6)
          {
            bool5 = bool1;
            bool6 = bool2;
            bool1 = bool4;
            bool2 = bool3;
            bool3 = bool5;
            bool4 = bool6;
          }
        }
        localException1.printStackTrace();
        bool5 = bool7;
        continue;
        bool1 = false;
        bool2 = true;
        bool3 = false;
        bool4 = false;
        bool5 = false;
        continue;
      }
      boolean bool1 = false;
      boolean bool2 = true;
      boolean bool3 = false;
      boolean bool4 = false;
      i = 0;
      bool5 = bool7;
    }
  }
  
  public static void gl(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "load plugin start");
    }
    if (!QIPCServerHelper.getInstance().isModuleRunning("comic_plugin.apk")) {
      VasWebviewUtil.reportVasStatus("qqcomic", "launch_plugin_action", "0", 0, 201);
    }
    Intent localIntent = new Intent(paramContext, VipProxyPreLoadComicProcess.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("sendTime", SystemClock.elapsedRealtime());
    avea.a(BaseApplicationImpl.getApplication().getRuntime(), 1, 1, 0L);
    ei(localIntent);
    if ((aqqj.aB() instanceof Serializable)) {
      localIntent.putExtra("urlMap", (Serializable)aqqj.aB());
    }
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "comic_plugin.apk";
    locald.mPluginName = "comic_plugin";
    locald.mUin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    locald.cKu = "com.qqcomic.app.VipPreloadComicProcess";
    locald.mIntent = localIntent;
    avfw.b(paramContext, locald);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "load plugin end");
    }
  }
  
  public static void h(Observer paramObserver)
  {
    if (jdField_a_of_type_Avef == null) {
      jdField_a_of_type_Avef = new avef();
    }
    for (;;)
    {
      jdField_a_of_type_Avef.addObserver(paramObserver);
      return;
      jdField_a_of_type_Avef.deleteObservers();
    }
  }
  
  public static boolean p(AppRuntime paramAppRuntime)
  {
    boolean bool = false;
    if (dmO)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicPluginBridge", 2, "QQComic is ready");
      }
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (!(paramAppRuntime instanceof QQAppInterface))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQComicPluginBridge", 2, "Not in main process, QQComic is NOT installed");
          }
          return dmO;
        }
        paramAppRuntime = (avfw)paramAppRuntime.getManager(27);
        if (paramAppRuntime != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQComicPluginBridge", 2, "PluginManager is NOT ready");
      return false;
      paramAppRuntime = paramAppRuntime.b("comic_plugin.apk");
      if (paramAppRuntime != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQComicPluginBridge", 2, "QQComic is NOT found");
    return false;
    if (paramAppRuntime.mState == 4) {}
    for (bool = true;; bool = false)
    {
      dmO = bool;
      return dmO;
    }
  }
  
  public static abstract interface a
  {
    public abstract void et(int paramInt, String paramString);
  }
  
  public static class b
  {
    public aveb.a a;
    public long awO;
    public long azu;
    public int mErrCode = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aveb
 * JD-Core Version:    0.7.0.1
 */