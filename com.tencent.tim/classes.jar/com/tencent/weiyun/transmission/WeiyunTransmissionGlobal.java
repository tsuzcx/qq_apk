package com.tencent.weiyun.transmission;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager.WifiLock;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.db.OfflineFileHelper;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.transmission.upload.UploadType;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.uploader.xplatform.UploadNative;
import com.tencent.weiyun.utils.ILog;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class WeiyunTransmissionGlobal
{
  private static final Lock LOCK = new ReentrantLock();
  private static final String TAG = "WeiyunTransmissionGlobal";
  private static Singleton<WeiyunTransmissionGlobal, Void> sInstance = new WeiyunTransmissionGlobal.1();
  private AppInfo mAppInfo;
  private Application mContext;
  private HostInterface mHostInterface;
  private UploadManager mUploadManager;
  private PowerManager.WakeLock mWakeLock = null;
  private WifiManager.WifiLock mWifiLock = null;
  
  public static WeiyunTransmissionGlobal getInstance()
  {
    return (WeiyunTransmissionGlobal)sInstance.get(null);
  }
  
  /* Error */
  public void acquireWakeLockIfNot()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: getstatic 43	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:LOCK	Ljava/util/concurrent/locks/Lock;
    //   5: astore_2
    //   6: aload_2
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 52	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnonnull +25 -> 39
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 73	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mContext	Landroid/app/Application;
    //   22: ldc 75
    //   24: invokevirtual 81	android/app/Application:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   27: checkcast 83	android/os/PowerManager
    //   30: iconst_1
    //   31: ldc 19
    //   33: invokevirtual 87	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   36: putfield 52	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   39: aload_0
    //   40: getfield 52	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   43: ifnull +40 -> 83
    //   46: aload_0
    //   47: getfield 52	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   50: invokevirtual 92	android/os/PowerManager$WakeLock:acquire	()V
    //   53: ldc 19
    //   55: new 94	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   62: ldc 97
    //   64: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_0
    //   68: getfield 52	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   71: invokevirtual 105	android/os/PowerManager$WakeLock:isHeld	()Z
    //   74: invokevirtual 108	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   77: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 118	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   87: astore_3
    //   88: aload_3
    //   89: ifnonnull +37 -> 126
    //   92: aload_0
    //   93: getfield 73	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mContext	Landroid/app/Application;
    //   96: ldc 120
    //   98: invokevirtual 81	android/app/Application:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   101: checkcast 122	android/net/wifi/WifiManager
    //   104: astore_3
    //   105: getstatic 128	android/os/Build$VERSION:SDK_INT	I
    //   108: bipush 12
    //   110: if_icmplt +5 -> 115
    //   113: iconst_3
    //   114: istore_1
    //   115: aload_0
    //   116: aload_3
    //   117: iload_1
    //   118: ldc 19
    //   120: invokevirtual 132	android/net/wifi/WifiManager:createWifiLock	(ILjava/lang/String;)Landroid/net/wifi/WifiManager$WifiLock;
    //   123: putfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   126: aload_0
    //   127: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   130: astore_3
    //   131: aload_3
    //   132: ifnull +40 -> 172
    //   135: aload_0
    //   136: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   139: invokevirtual 135	android/net/wifi/WifiManager$WifiLock:acquire	()V
    //   142: ldc 19
    //   144: new 94	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   151: ldc 137
    //   153: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   160: invokevirtual 138	android/net/wifi/WifiManager$WifiLock:isHeld	()Z
    //   163: invokevirtual 108	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   166: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 118	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_2
    //   173: monitorexit
    //   174: return
    //   175: astore_3
    //   176: aload_0
    //   177: aconst_null
    //   178: putfield 52	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   181: ldc 19
    //   183: ldc 140
    //   185: invokestatic 118	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: goto -149 -> 39
    //   191: astore_3
    //   192: aload_2
    //   193: monitorexit
    //   194: aload_3
    //   195: athrow
    //   196: astore_3
    //   197: aload_0
    //   198: aconst_null
    //   199: putfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   202: ldc 19
    //   204: ldc 142
    //   206: invokestatic 118	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: goto -83 -> 126
    //   212: astore_3
    //   213: ldc 19
    //   215: new 94	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   222: ldc 144
    //   224: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_0
    //   228: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   231: invokevirtual 138	android/net/wifi/WifiManager$WifiLock:isHeld	()Z
    //   234: invokevirtual 108	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   237: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 118	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto -71 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	WeiyunTransmissionGlobal
    //   1	117	1	i	int
    //   5	188	2	localLock	Lock
    //   12	120	3	localObject1	Object
    //   175	1	3	localThrowable1	java.lang.Throwable
    //   191	4	3	localObject2	Object
    //   196	1	3	localThrowable2	java.lang.Throwable
    //   212	1	3	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   17	39	175	java/lang/Throwable
    //   8	13	191	finally
    //   17	39	191	finally
    //   39	83	191	finally
    //   83	88	191	finally
    //   92	105	191	finally
    //   105	113	191	finally
    //   115	126	191	finally
    //   126	131	191	finally
    //   135	172	191	finally
    //   172	174	191	finally
    //   176	188	191	finally
    //   192	194	191	finally
    //   197	209	191	finally
    //   213	243	191	finally
    //   92	105	196	java/lang/Throwable
    //   105	113	196	java/lang/Throwable
    //   115	126	196	java/lang/Throwable
    //   135	172	212	java/lang/Throwable
  }
  
  public AppInfo getAppInfo()
  {
    return this.mAppInfo;
  }
  
  public Application getApplication()
  {
    return this.mContext;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public HostInterface getHostInterface()
  {
    return this.mHostInterface;
  }
  
  public List<String> getOfflinePath(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return new ArrayList(0);
    }
    return OfflineFileHelper.getOfflineFilePath(paramString1, paramString2, paramString3);
  }
  
  public UploadManager getUploadManager()
  {
    if (this.mUploadManager == null) {
      throw new IllegalStateException("Please call WeiyunLiteGlobal.initTransmission(...) in advance.");
    }
    return this.mUploadManager;
  }
  
  public void initTransmission(AppInfo paramAppInfo, Application paramApplication, HostInterface paramHostInterface, ILog paramILog)
  {
    if ((paramAppInfo == null) || (paramApplication == null) || (paramHostInterface == null)) {
      try
      {
        throw new IllegalArgumentException("The params appInfo, context and hostInterface should be no-null.");
      }
      finally {}
    }
    this.mAppInfo = paramAppInfo;
    this.mContext = paramApplication;
    this.mHostInterface = paramHostInterface;
    TsLog.setLog(paramILog);
    NetworkUtils.setNetworkInfoProvider(new WeiyunTransmissionGlobal.2(this));
    WeiyunTransmissionStatus.getInstance().initGlobalStatus(paramApplication);
    this.mUploadManager = UploadManager.getInstance();
    this.mUploadManager.init();
  }
  
  public boolean isNativeUpload()
  {
    return UploadNative.getInstance().isLoaded();
  }
  
  /* Error */
  public void releaseWakeLockIfExist()
  {
    // Byte code:
    //   0: getstatic 43	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:LOCK	Ljava/util/concurrent/locks/Lock;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 52	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +40 -> 52
    //   15: aload_0
    //   16: getfield 52	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   19: invokevirtual 236	android/os/PowerManager$WakeLock:release	()V
    //   22: ldc 19
    //   24: new 94	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   31: ldc 238
    //   33: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 52	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   40: invokevirtual 105	android/os/PowerManager$WakeLock:isHeld	()Z
    //   43: invokevirtual 108	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 118	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   56: astore_2
    //   57: aload_2
    //   58: ifnull +40 -> 98
    //   61: aload_0
    //   62: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   65: invokevirtual 239	android/net/wifi/WifiManager$WifiLock:release	()V
    //   68: ldc 19
    //   70: new 94	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   77: ldc 241
    //   79: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   86: invokevirtual 138	android/net/wifi/WifiManager$WifiLock:isHeld	()Z
    //   89: invokevirtual 108	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   92: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 118	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_1
    //   99: monitorexit
    //   100: return
    //   101: astore_2
    //   102: ldc 19
    //   104: new 94	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   111: ldc 243
    //   113: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: getfield 52	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWakeLock	Landroid/os/PowerManager$WakeLock;
    //   120: invokevirtual 105	android/os/PowerManager$WakeLock:isHeld	()Z
    //   123: invokevirtual 108	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   126: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 118	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -80 -> 52
    //   135: astore_2
    //   136: aload_1
    //   137: monitorexit
    //   138: aload_2
    //   139: athrow
    //   140: astore_2
    //   141: ldc 19
    //   143: new 94	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   150: ldc 245
    //   152: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_0
    //   156: getfield 54	com/tencent/weiyun/transmission/WeiyunTransmissionGlobal:mWifiLock	Landroid/net/wifi/WifiManager$WifiLock;
    //   159: invokevirtual 138	android/net/wifi/WifiManager$WifiLock:isHeld	()Z
    //   162: invokevirtual 108	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   165: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 118	com/tencent/weiyun/transmission/utils/TsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: goto -73 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	WeiyunTransmissionGlobal
    //   3	134	1	localLock	Lock
    //   10	48	2	localObject1	Object
    //   101	1	2	localThrowable1	java.lang.Throwable
    //   135	4	2	localObject2	Object
    //   140	1	2	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   15	52	101	java/lang/Throwable
    //   6	11	135	finally
    //   15	52	135	finally
    //   52	57	135	finally
    //   61	98	135	finally
    //   98	100	135	finally
    //   102	132	135	finally
    //   136	138	135	finally
    //   141	171	135	finally
    //   61	98	140	java/lang/Throwable
  }
  
  public static final class AppInfo
  {
    public String appName;
    public String channelName;
    public boolean isLocal = false;
    public boolean isRdm = false;
    public String qua;
    public int versionCode;
    public String versionName;
    public int wnsAppId;
    
    public AppInfo(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4)
    {
      this.qua = paramString1;
      this.wnsAppId = paramInt1;
      this.appName = paramString2;
      this.versionName = paramString3;
      this.versionCode = paramInt2;
      this.channelName = paramString4;
    }
  }
  
  public static abstract interface HostInterface
  {
    public abstract void fetchUploadServerInfo(UploadFile paramUploadFile, UploadType paramUploadType, WeiyunTransmissionGlobal.UploadServerInfoCallback paramUploadServerInfoCallback);
    
    public abstract int getCurrentIsp();
    
    public abstract String getCurrentUid();
    
    public abstract long getCurrentUin();
    
    public abstract NetworkInfo getRecentNetworkInfo();
    
    public abstract SharedPreferences getSharedPreferences(String paramString, int paramInt);
  }
  
  public static abstract interface UploadServerInfoCallback
  {
    public abstract void onResult(UploadFile paramUploadFile, boolean paramBoolean, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.transmission.WeiyunTransmissionGlobal
 * JD-Core Version:    0.7.0.1
 */