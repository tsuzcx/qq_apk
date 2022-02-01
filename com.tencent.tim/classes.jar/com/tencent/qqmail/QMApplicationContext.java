package com.tencent.qqmail;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.webkit.WebView;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.moai.database.sqlite.CursorWindow;
import com.tencent.moai.database.sqlite.SQLiteCursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.launcher.base.WelcomeLoader;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.model.task.QMTaskSQLiteHelper;
import com.tencent.qqmail.monitor.QMMemoryMonitor;
import com.tencent.qqmail.notificationshortcut.NotificationShortCutManager;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.protocol.ProtocolServiceNative;
import com.tencent.qqmail.protocol.UMA.VerifyCodeAnswer;
import com.tencent.qqmail.utilities.QMSoChecker;
import com.tencent.qqmail.utilities.deviceid.DeviceId;
import com.tencent.qqmail.utilities.log.LogPathManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.processutil.ProcessUtils;
import com.tencent.qqmail.utilities.qmbroadcastreceiver.QMAlarmBroadCast;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.wetest.WeTestConfig;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import moai.log.MLogManager;
import org.apache.commons.io.FileUtils;

public class QMApplicationContext
  extends ContextWrapper
{
  private static final String START_UP_SP_NAME = "qmapplication_start_up_info";
  public static final String TAG = "QMApplicationContext";
  private static QMApplicationContext _instance = null;
  public static boolean enableAccelerating = true;
  public final Application application;
  private boolean bFixProcess = false;
  private boolean bMainProcess = false;
  private boolean bPushProcess = false;
  private boolean bToolsProcess = false;
  private boolean bUninstallProcess = false;
  private boolean isRegistering = false;
  private boolean isStartCrashed = false;
  private boolean isUploadContinue = false;
  private final ArrayList<LowMemoryListener> mLowMemoryListener = new ArrayList();
  public long mOnCreateBegin;
  
  public QMApplicationContext(Application paramApplication)
  {
    super(paramApplication);
    _instance = this;
    this.application = paramApplication;
  }
  
  private Resources createResources(Context paramContext, AssetManager paramAssetManager)
  {
    return new Resources(paramAssetManager, paramContext.getResources().getDisplayMetrics(), paramContext.getResources().getConfiguration());
  }
  
  private Resources createResources(Context paramContext, String[] paramArrayOfString)
  {
    int i = 0;
    try
    {
      Object localObject = Class.forName("android.content.res.AssetManager");
      AssetManager localAssetManager = (AssetManager)((Class)localObject).getConstructor(new Class[0]).newInstance(new Object[0]);
      localObject = ((Class)localObject).getDeclaredMethod("addAssetPath", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      int j = paramArrayOfString.length;
      while (i < j)
      {
        ((Method)localObject).invoke(localAssetManager, new Object[] { paramArrayOfString[i] });
        i += 1;
      }
      paramArrayOfString = createResources(paramContext, localAssetManager);
      paramContext.printStackTrace();
    }
    catch (Exception paramContext)
    {
      try
      {
        paramArrayOfString.getDisplayMetrics().setTo(paramContext.getResources().getDisplayMetrics());
        return paramArrayOfString;
      }
      catch (Exception paramContext)
      {
        break label116;
      }
      paramContext = paramContext;
      paramArrayOfString = null;
    }
    label116:
    return paramArrayOfString;
  }
  
  private File extendFileByAccount(String paramString)
  {
    Object localObject = currentUin();
    paramString = paramString + File.separator + (String)localObject;
    localObject = new File(paramString);
    try
    {
      FileUtils.forceMkdir((File)localObject);
      Log.i("QMApplicationContext", "Extended " + paramString);
      return localObject;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      QMLog.log(4, "QMApplicationContext", "extendFileByAccount fail " + paramString);
    }
    return null;
  }
  
  private String fetchProcessInfo()
  {
    String str = ProcessUtils.getProcessName(this);
    if (str != null)
    {
      if (!str.endsWith(":Push")) {
        break label25;
      }
      this.bPushProcess = true;
    }
    label25:
    do
    {
      return str;
      if (str.endsWith(":Uninstall"))
      {
        this.bUninstallProcess = true;
        return str;
      }
      if (str.endsWith(":Tools"))
      {
        this.bToolsProcess = true;
        return str;
      }
      if (str.endsWith(":Fix"))
      {
        this.bFixProcess = true;
        return str;
      }
      if (str.equals(getPackageName()))
      {
        this.bMainProcess = true;
        return str;
      }
    } while (!str.endsWith(":mail"));
    this.bMainProcess = true;
    return str;
  }
  
  private void initBaseComponent()
  {
    LogPathManager.init(this);
    String str = fetchProcessInfo();
    int i = str.indexOf(':');
    if (i < 0) {}
    for (str = "M";; str = str.substring(i + 1))
    {
      MLogManager.init(str);
      QMLog.log(4, "QMApplicationContext", "process start, process: " + str + ", baseVersion: " + AppConfig.getSystemVersion() + ", patchVersion: " + AppConfig.getPatchVersion() + ", codeVersion: " + AppConfig.getCodeVersion() + ", gitSha: " + "67b9588");
      return;
    }
  }
  
  private void initFixProcess()
  {
    QMLog.log(4, "QMApplicationContext", "initFixProcess");
  }
  
  private void initMainProcess()
  {
    QMLog.log(4, "QMApplicationContext", "initMainProcess");
    ProtocolServiceNative.preloadSo();
    WelcomeLoader.getInstance().preloadInBackground();
    QMTaskManager localQMTaskManager = QMTaskManager.sharedInstance(1);
    localQMTaskManager.setSQLite(QMTaskSQLiteHelper.sharedInstance());
    localQMTaskManager.getTaskList();
    localQMTaskManager.revertAllTask();
    if (AppConfig.isCovtest())
    {
      QMLog.log(4, "QMApplicationContext", "start uploadcovtest");
      startPeriodicUploadCovtest();
    }
    QMLog.log(4, "QMApplicationContext", "finish initMainProcess");
  }
  
  private void initOssLog()
  {
    Threads.runInBackground(new QMApplicationContext.5(this));
  }
  
  private void initPushProcess()
  {
    QMLog.log(4, "QMApplicationContext", "initPushProcess");
    QMSoChecker.doCheck();
    NotificationShortCutManager.ensure(this);
  }
  
  private void initSQLiteDatabase()
  {
    QMLog.initSQLiteLogger();
    SQLiteDatabase.load(this);
    CursorWindow.setDefaultSize(4096);
    SQLiteCursor.setOnCursorWindowGrowListener(new QMApplicationContext.2(this));
  }
  
  private boolean isRegisteringVid()
  {
    return this.isRegistering;
  }
  
  private void logOnCreate(long paramLong)
  {
    Threads.runInBackground(new QMApplicationContext.3(this, paramLong));
  }
  
  private void registerVid()
  {
    CloudProtocolInfo localCloudProtocolInfo = new CloudProtocolInfo();
    localCloudProtocolInfo.device_id_ = CloudProtocolHelper.getDeviceId();
    localCloudProtocolInfo.device_info_ = CloudProtocolHelper.getDeviceInfo();
    localCloudProtocolInfo.verify_code_answer_ = new VerifyCodeAnswer();
    setRegisteringVid(true);
    QMLog.log(4, "QMApplicationContext", "registerVid");
    CloudProtocolService.Register(localCloudProtocolInfo, new QMApplicationContext.1(this));
  }
  
  private void setRegisteringVid(boolean paramBoolean)
  {
    this.isRegistering = paramBoolean;
  }
  
  public static QMApplicationContext sharedInstance()
  {
    if (_instance == null) {
      throw new IllegalStateException("not init");
    }
    return _instance;
  }
  
  public void addLowMemoryListener(LowMemoryListener paramLowMemoryListener)
  {
    synchronized (this.mLowMemoryListener)
    {
      this.mLowMemoryListener.add(paramLowMemoryListener);
      return;
    }
  }
  
  public void alarmForWebpush() {}
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public void cancelAlarmForWebpush() {}
  
  public String currentUin()
  {
    String str = QMAppInterface.sharedInstance().getUin() + "";
    QMLog.log(4, "QMApplicationContext", "currentUin " + str);
    return str;
  }
  
  public File getCacheDir()
  {
    File localFile2 = extendFileByAccount(super.getCacheDir().getAbsolutePath());
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = super.getCacheDir();
    }
    return localFile1;
  }
  
  public File getDataDir()
  {
    Log.i("QMApplicationContext", "getDataDir");
    File localFile2 = extendFileByAccount(super.getDataDir().getAbsolutePath());
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = super.getDataDir();
    }
    return localFile1;
  }
  
  public File getDir(String paramString, int paramInt)
  {
    File localFile2 = extendFileByAccount(super.getDir(paramString, paramInt).getAbsolutePath());
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = super.getDir(paramString, paramInt);
    }
    return localFile1;
  }
  
  public File getFilesDir()
  {
    File localFile2 = extendFileByAccount(super.getFilesDir().getAbsolutePath());
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = super.getFilesDir();
    }
    return localFile1;
  }
  
  public String getFromAssets(String paramString)
  {
    localObject1 = null;
    String str = null;
    try
    {
      paramString = getResources().getAssets().open(paramString);
      str = paramString;
      localObject1 = paramString;
      Object localObject2 = new byte[paramString.available()];
      str = paramString;
      localObject1 = paramString;
      paramString.read((byte[])localObject2);
      str = paramString;
      localObject1 = paramString;
      localObject2 = new String((byte[])localObject2);
      if (paramString != null) {}
      try
      {
        paramString.close();
        return localObject2;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return localObject2;
      }
      try
      {
        ((InputStream)localObject1).close();
        throw paramString;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
    catch (Exception paramString)
    {
      localObject1 = str;
      paramString.printStackTrace();
      if (str != null) {}
      try
      {
        str.close();
        return "";
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return "";
      }
    }
    finally
    {
      if (localObject1 == null) {}
    }
  }
  
  public String getSessionKeyPath()
  {
    return getFilesDir().getAbsolutePath() + File.separator + "sessionkey";
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return super.getSharedPreferences(paramString, paramInt);
  }
  
  public Object getSystemService(String paramString)
  {
    return super.getSystemService(paramString);
  }
  
  public long getVid()
  {
    try
    {
      long l = QMSharedPreferenceManager.getInstance().getVid();
      if (l == 0L)
      {
        QMLog.log(4, "QMApplicationContext", "get vid null, init");
        initVid();
      }
      return l;
    }
    finally {}
  }
  
  public String getVidPwd()
  {
    String str = QMSharedPreferenceManager.getInstance().getVidPwd();
    if (TextUtils.isEmpty(str)) {
      QMLog.log(4, "QMApplicationContext", "get vid pwd null, not init");
    }
    return str;
  }
  
  public void initVid()
  {
    long l = QMSharedPreferenceManager.getInstance().getVid();
    String str = QMSharedPreferenceManager.getInstance().getVidPwd();
    QMLog.log(4, "QMApplicationContext", "initVid : " + l + ";" + str);
    if ((QMNetworkUtils.isNetworkConnected()) && ((l == 0L) || (str.equals(""))) && (!isRegisteringVid()) && (!isStartCrashed())) {
      registerVid();
    }
  }
  
  public boolean isFtnUploadContinue()
  {
    return this.isUploadContinue;
  }
  
  public boolean isMainProcess()
  {
    return this.bMainProcess;
  }
  
  public boolean isPushProcess()
  {
    return this.bPushProcess;
  }
  
  public boolean isStartCrashed()
  {
    return this.isStartCrashed;
  }
  
  public boolean isToolsProcess()
  {
    return this.bToolsProcess;
  }
  
  public void logVisibleWelcome(long paramLong)
  {
    Threads.runInBackground(new QMApplicationContext.4(this, paramLong));
  }
  
  @SuppressLint({"NewApi"})
  public void onCreate()
  {
    this.mOnCreateBegin = SystemClock.uptimeMillis();
    _instance = this;
    long l = System.currentTimeMillis();
    initBaseComponent();
    initOssLog();
    DeviceId.init(this);
    initSQLiteDatabase();
    WelcomeLoader.getInstance().initDownloadManager();
    if (this.bPushProcess) {
      initPushProcess();
    }
    for (;;)
    {
      if (this.bMainProcess) {
        logOnCreate(SystemClock.uptimeMillis() - this.mOnCreateBegin);
      }
      Log.i("QMApplicationContext", "onCreate costed time " + (System.currentTimeMillis() - l));
      if ((WeTestConfig.autoLoginQQ()) && (this.bMainProcess) && (Build.VERSION.SDK_INT >= 19) && ((getApplicationInfo().flags & 0x2) != 0)) {
        WebView.setWebContentsDebuggingEnabled(true);
      }
      return;
      if (this.bUninstallProcess) {
        QMLog.log(4, "QMApplicationContext", "UninstallProcess oncreate");
      } else if (this.bMainProcess) {
        initMainProcess();
      } else if (this.bToolsProcess) {
        QMLog.log(4, "QMApplicationContext", "ToolsProcess onCreate");
      } else if (this.bFixProcess) {
        initFixProcess();
      }
    }
  }
  
  public void onLowMemory()
  {
    QMLog.log(4, "QMApplicationContext", "lowMemory");
    QMMemoryMonitor.sharedInstance().mark("onLowMemory");
    synchronized (this.mLowMemoryListener)
    {
      LowMemoryListener[] arrayOfLowMemoryListener = new LowMemoryListener[this.mLowMemoryListener.size()];
      this.mLowMemoryListener.toArray(arrayOfLowMemoryListener);
      int j = arrayOfLowMemoryListener.length;
      int i = 0;
      if (i < j)
      {
        arrayOfLowMemoryListener[i].onRelease();
        i += 1;
      }
    }
  }
  
  public void removeLowMemoryListener(LowMemoryListener paramLowMemoryListener)
  {
    synchronized (this.mLowMemoryListener)
    {
      this.mLowMemoryListener.remove(paramLowMemoryListener);
      return;
    }
  }
  
  public void setFtnUploadContinue(boolean paramBoolean)
  {
    this.isUploadContinue = paramBoolean;
  }
  
  public void setStartCrashed(boolean paramBoolean)
  {
    this.isStartCrashed = paramBoolean;
  }
  
  public void startPeriodicUploadCovtest()
  {
    Threads.runInBackgroundRepeatly(new QMApplicationContext.6(this), 600000L, 600000L);
  }
  
  public static abstract interface LowMemoryListener
  {
    public abstract void onRelease();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMApplicationContext
 * JD-Core Version:    0.7.0.1
 */