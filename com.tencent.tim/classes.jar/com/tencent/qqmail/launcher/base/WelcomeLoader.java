package com.tencent.qqmail.launcher.base;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.moai.downloader.DownloadManager;
import com.tencent.moai.downloader.GlobalConfig;
import com.tencent.moai.nativepages.NativePageManager;
import com.tencent.qqmail.GesturePasswordManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.MailServiceManager;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.QMSpamTypeManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.nativepages.NativePageAppOperationDelegate;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.QMPathManager;
import com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.receiver.QMIPCBroadcastManager;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.widget.WidgetHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class WelcomeLoader
{
  private static final String TAG = "WelcomeLoader";
  private static WelcomeLoader instance = new WelcomeLoader();
  private ArrayList<Callback> callbacks = new ArrayList();
  private boolean finish = false;
  
  private void finishPreload()
  {
    this.finish = true;
    int j = this.callbacks.size();
    int i = 0;
    while (i < j)
    {
      Callback localCallback = (Callback)this.callbacks.get(i);
      if (localCallback != null) {
        localCallback.finish();
      }
      i += 1;
    }
    this.callbacks.clear();
  }
  
  public static WelcomeLoader getInstance()
  {
    return instance;
  }
  
  private Object getReturn(Method paramMethod)
  {
    paramMethod = paramMethod.getReturnType();
    if (paramMethod == Integer.TYPE) {
      return Integer.valueOf(0);
    }
    if (paramMethod == Boolean.TYPE) {
      return Boolean.valueOf(true);
    }
    return null;
  }
  
  private boolean initEnabledHardwareAccelerate()
  {
    String[] arrayOfString = QMApplicationContext.sharedInstance().getString(2131692809).split(",");
    if (Build.VERSION.SDK_INT == 16)
    {
      j = arrayOfString.length;
      i = 0;
      if (i >= j) {
        break label71;
      }
      str = arrayOfString[i];
      if (!Build.MODEL.startsWith(str)) {}
    }
    while ((BrandUtil.isSamsung()) && (Build.VERSION.SDK_INT == 18)) {
      for (;;)
      {
        int j;
        int i;
        String str;
        return false;
        i += 1;
      }
    }
    label71:
    return true;
  }
  
  private void preload()
  {
    this.finish = false;
    QMLog.log(4, "WelcomeLoader", "Start preload");
    long l1 = System.currentTimeMillis();
    QMMailManager.init();
    Threads.runInBackground(new WelcomeLoader.3(this), 3000L);
    NativePageManager.getInstance().setContext(QMApplicationContext.sharedInstance());
    NativePageManager.getInstance().setBaseCachePath(FileUtil.getNativePagesDir());
    NativePageManager.getInstance().setAppOperationDelegate(new NativePageAppOperationDelegate());
    AccountManager.init();
    QMApplicationContext.enableAccelerating = initEnabledHardwareAccelerate();
    QMPrivateProtocolManager.sharedInstance().registerGeneralCallback();
    RsaEncryption.setPublicKey(QMApplicationContext.sharedInstance());
    QMSpamTypeManager.init();
    WidgetHelper.preInitWidget();
    if (!FileUtil.hasSdcard()) {
      QMSettingManager.sharedInstance().setShowMailListAvatar(false);
    }
    Threads.runInBackground(new WelcomeLoader.4(this), 5000L);
    Threads.runInBackground(new WelcomeLoader.5(this), 5000L);
    Threads.runInBackground(new WelcomeLoader.6(this), 3000L);
    MailServiceManager.initLocalDomainConfig();
    Threads.runInBackground(new WelcomeLoader.7(this), 5000L);
    Threads.runOnMainThread(new WelcomeLoader.8(this));
    Threads.runInBackground(new WelcomeLoader.9(this), 3000L);
    Threads.runInBackground(new WelcomeLoader.10(this), 3000L);
    QMPathManager.init();
    QMIPCBroadcastManager.init();
    if (SharedPreferenceUtil.isGesturePswEnabled()) {
      GesturePasswordManager.getInstance().setGesturePwdPassed(false);
    }
    long l2 = QMApplicationContext.sharedInstance().getVid();
    String str = QMApplicationContext.sharedInstance().getVidPwd();
    if ((l2 == 0L) || (TextUtils.isEmpty(str))) {
      QMApplicationContext.sharedInstance().initVid();
    }
    QMLog.log(4, "WelcomeLoader", "Preload used time " + (System.currentTimeMillis() - l1));
    Threads.runOnMainThread(new WelcomeLoader.11(this));
  }
  
  public void initDownloadManager()
  {
    DownloadManager localDownloadManager = DownloadManager.createInstance(QMApplicationContext.sharedInstance());
    localDownloadManager.setLogDelegate(new WelcomeLoader.12(this));
    localDownloadManager.setDefaultTmpFileDir(FileUtil.getDownloadTmpFileDir());
    localDownloadManager.setMaxThreadSize(GlobalConfig.MAX_THREAD_SIZE);
    localDownloadManager.setMaxThreadTaskSize(GlobalConfig.MAX_THREAD_TASK_SIZE);
  }
  
  public boolean isFinish()
  {
    return this.finish;
  }
  
  public void preloadInBackground()
  {
    Threads.runInBackground(new WelcomeLoader.2(this));
  }
  
  public void proxyAM()
  {
    try
    {
      Object localObject1 = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(null);
      Field localField = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
      localField.setAccessible(true);
      Object localObject2 = localField.get(localObject1);
      Class localClass = Class.forName("android.app.IActivityManager");
      ClassLoader localClassLoader = QMApplicationContext.sharedInstance().getClassLoader();
      localObject2 = new WelcomeLoader.13(this, localObject2);
      localField.set(localObject1, Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, (InvocationHandler)localObject2));
      QMLog.log(4, "WelcomeLoader", "proxyAM done");
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.log(5, "WelcomeLoader", "proxyAM", localThrowable);
    }
  }
  
  @MainThread
  public void registerCallback(@NonNull Callback paramCallback)
  {
    Threads.runOnMainThread(new WelcomeLoader.1(this, paramCallback));
  }
  
  public static abstract interface Callback
  {
    public abstract void finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.base.WelcomeLoader
 * JD-Core Version:    0.7.0.1
 */