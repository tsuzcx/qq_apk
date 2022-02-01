package cooperation.qzone.networkedmodule;

import android.content.Context;
import android.text.TextUtils;
import avwd;
import avwe;
import avwe.a;
import avwf;
import avwj;
import avwk;
import awcs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QzoneModuleManager
{
  private static final int DISABLE_MODULE = 1;
  private static final int ENABLE_MODULE = 0;
  private static final String TAG = "QzoneModuleManager";
  private static volatile QzoneModuleManager sModuleManager;
  public volatile boolean hasLoadNewMapSDK;
  public volatile boolean hasLoadOldMapSDK;
  private volatile boolean hasSetVersionNum;
  avwf mDownloadManager = new avwf(BaseApplicationImpl.getApplication());
  private volatile boolean mHasStartedUpdateTask;
  public Object mLock = new Object();
  private Map<String, Boolean> mModueLoadState = new ConcurrentHashMap();
  private int mNextModuleIndex;
  
  public static QzoneModuleManager getInstance()
  {
    if (sModuleManager == null) {}
    try
    {
      if (sModuleManager == null) {
        sModuleManager = new QzoneModuleManager();
      }
      return sModuleManager;
    }
    finally {}
  }
  
  private boolean securityCheck(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "qzone_module_disable", 0) == 1)
      {
        QLog.e("QzoneModuleManager", 1, "loadModule error: networked module is disabled");
        return false;
      }
      if (avwd.aLK())
      {
        QLog.w("QzoneModuleManager", 1, "loadModule error:device is in the blacklist.");
        return false;
      }
    } while (!QzoneModuleConst.isLoadAccordingToCrashCount(paramString));
    return true;
  }
  
  public void abortDownloadModule(String paramString)
  {
    this.mDownloadManager.abortDownloadModule(paramString);
  }
  
  public void cancelDownloadModule(String paramString)
  {
    this.mDownloadManager.cancelDownloadModule(paramString);
  }
  
  public boolean checkIfNeedUpdate(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("moduleId is null or empty.");
    }
    avwe.a locala = avwe.a().a(paramString);
    if (locala != null)
    {
      if ((!locala.aLL()) && (isModuleDownloaded(paramString)))
      {
        QLog.i("QzoneModuleManager", 2, "checkIfNeedUpdate: " + paramString + ",no new configs");
        return false;
      }
      return true;
    }
    QLog.w("QzoneModuleManager", 2, "checkIfNeedUpdate: record is null," + paramString);
    return false;
  }
  
  public boolean downloadModule(String paramString, ModuleDownloadListener paramModuleDownloadListener)
  {
    paramString = avwe.a().a(paramString);
    if (paramString == null) {
      return false;
    }
    return this.mDownloadManager.a(paramString.b(), paramModuleDownloadListener);
  }
  
  public String getModuleFilePath(String paramString)
  {
    avwe.a locala = avwe.a().a(paramString);
    paramString = "";
    if (locala != null) {
      paramString = QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), locala);
    }
    return paramString;
  }
  
  public boolean hasStartedUpdateTask()
  {
    return this.mHasStartedUpdateTask;
  }
  
  public boolean isModuleDownloaded(String paramString)
  {
    paramString = avwe.a().a(paramString);
    if (paramString != null)
    {
      File localFile = new File(QzoneModuleConst.getModuleSavePath(BaseApplicationImpl.getApplication(), paramString));
      if ((localFile.exists()) && (paramString.aAA != 0L) && (paramString.aAA == localFile.length())) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public boolean isModuleLoaded(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +24 -> 30
    //   9: aload_0
    //   10: getfield 37	cooperation/qzone/networkedmodule/QzoneModuleManager:mModueLoadState	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 204 2 0
    //   19: checkcast 206	java/lang/Boolean
    //   22: invokevirtual 209	java/lang/Boolean:booleanValue	()Z
    //   25: istore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_2
    //   29: ireturn
    //   30: iconst_0
    //   31: istore_2
    //   32: goto -6 -> 26
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	QzoneModuleManager
    //   0	40	1	paramString	String
    //   25	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  public boolean loadLibraryById(String paramString)
  {
    paramString = getModuleFilePath(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        System.load(paramString);
        return true;
      }
      catch (Throwable paramString)
      {
        QLog.e("QzoneModuleManager", 1, "catch an exception:", paramString);
      }
    }
    return false;
  }
  
  boolean loadModule(avwe.a parama, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    if (parama == null)
    {
      QLog.e("QzoneModuleManager", 1, "record is null");
      return false;
    }
    String str1 = parama.mModuleId;
    if (this.mModueLoadState.containsKey(str1)) {
      return ((Boolean)this.mModueLoadState.get(str1)).booleanValue();
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    String str2 = QzoneModuleConst.getModuleSavePath(localBaseApplicationImpl, parama);
    synchronized (this.mLock)
    {
      if (this.mModueLoadState.containsKey(str1))
      {
        paramBoolean = ((Boolean)this.mModueLoadState.get(str1)).booleanValue();
        return paramBoolean;
      }
    }
    paramBoolean = avwj.a(str2, localBaseApplicationImpl.getApplicationContext(), paramClassLoader, parama.cOi, parama, paramBoolean);
    this.mModueLoadState.put(str1, Boolean.valueOf(paramBoolean));
    return paramBoolean;
  }
  
  public boolean loadModule(File arg1)
  {
    if (!???.exists())
    {
      QLog.e("QzoneModuleManager", 1, ???.getAbsolutePath() + " is not exist.");
      return false;
    }
    String str1 = ???.getAbsolutePath();
    String str3 = ???.getName();
    if (this.mModueLoadState.containsKey(str3)) {
      return ((Boolean)this.mModueLoadState.get(str3)).booleanValue();
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    avwe.a locala = new avwe.a(str3, ???.getName(), "", "", "", "", "", 0, 0L, null);
    synchronized (this.mLock)
    {
      if (this.mModueLoadState.containsKey(str3))
      {
        bool = ((Boolean)this.mModueLoadState.get(str3)).booleanValue();
        return bool;
      }
    }
    boolean bool = avwj.a(str2, localBaseApplicationImpl.getApplicationContext(), getClass().getClassLoader(), locala.cOi, locala);
    this.mModueLoadState.put(str3, Boolean.valueOf(bool));
    return bool;
  }
  
  public boolean loadModule(String paramString, ClassLoader paramClassLoader, boolean paramBoolean1, boolean paramBoolean2)
  {
    avwe.a locala = avwe.a().a(paramString);
    if (locala == null)
    {
      QLog.e("QzoneModuleManager", 1, "loadModule error: can't find information about " + paramString + ",please ensure is do exist");
      return false;
    }
    if (!securityCheck(paramString))
    {
      QLog.e("QzoneModuleManager", 1, "securityCheck: reject");
      return false;
    }
    if (paramBoolean1) {
      return loadModule2QQClassLoader(locala);
    }
    return loadModule(locala, paramClassLoader, paramBoolean2);
  }
  
  boolean loadModule2QQClassLoader(avwe.a parama)
  {
    if (parama == null)
    {
      QLog.e("QzoneModuleManager", 1, "record is null");
      return false;
    }
    String str1 = parama.mModuleId;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (awcs.tL(awcs.getCurProcessName(localBaseApplicationImpl)))
    {
      QLog.e("QzoneModuleManager", 1, "-------try to load module into MainClassLoader in QQ process.This shouldn't happen,please ensure this is really what you want...");
      return false;
    }
    if (this.mModueLoadState.containsKey(str1)) {
      return ((Boolean)this.mModueLoadState.get(str1)).booleanValue();
    }
    String str2 = QzoneModuleConst.getModuleSavePath(localBaseApplicationImpl, parama);
    synchronized (this.mLock)
    {
      if (this.mModueLoadState.containsKey(str1))
      {
        bool = ((Boolean)this.mModueLoadState.get(str1)).booleanValue();
        return bool;
      }
    }
    boolean bool = avwj.a(str2, localBaseApplicationImpl.getApplicationContext(), parama.cOi, parama);
    this.mModueLoadState.put(str1, Boolean.valueOf(bool));
    if ((bool) && (!this.hasSetVersionNum)) {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QzoneModuleManager.2(this));
    }
    return bool;
  }
  
  public boolean loadModuleAsQQPatch(String paramString)
  {
    avwe.a locala = avwe.a().a(paramString);
    if (locala == null)
    {
      QLog.e("QzoneModuleManager", 1, "loadModule error: can't find information about " + paramString + ",please ensure is do exist");
      return false;
    }
    if (!securityCheck(paramString))
    {
      QLog.e("QzoneModuleManager", 1, "securityCheck: reject");
      return false;
    }
    return loadModule2QQClassLoader(locala);
  }
  
  public boolean loadModuleAsQzonePatch(String paramString, ClassLoader paramClassLoader)
  {
    avwe.a locala = avwe.a().a(paramString);
    if (locala == null)
    {
      QLog.e("QzoneModuleManager", 1, "loadModule error: can't find information about " + paramString + ",please ensure is do exist");
      return false;
    }
    if (!securityCheck(paramString))
    {
      QLog.e("QzoneModuleManager", 1, "securityCheck: reject");
      return false;
    }
    return loadModule(locala, paramClassLoader, true);
  }
  
  public void updateAllModules()
  {
    if (this.mHasStartedUpdateTask) {}
    for (;;)
    {
      return;
      this.mHasStartedUpdateTask = true;
      QLog.i("QzoneModuleManager", 1, "start to updateAllModules.");
      avwk localavwk = new avwk(this);
      while (this.mNextModuleIndex < QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD.size())
      {
        String str = (String)QzoneModuleConst.QZONE_MODULES_PREDOWNLOAD.get(this.mNextModuleIndex);
        if (checkIfNeedUpdate(str))
        {
          updateModule(str, localavwk);
          return;
        }
        this.mNextModuleIndex += 1;
      }
    }
  }
  
  public void updateModule(String paramString, ModuleDownloadListener paramModuleDownloadListener)
  {
    if (!checkIfNeedUpdate(paramString)) {
      return;
    }
    QLog.i("QzoneModuleManager", 1, "updateModule: " + paramString);
    downloadModule(paramString, paramModuleDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleManager
 * JD-Core Version:    0.7.0.1
 */