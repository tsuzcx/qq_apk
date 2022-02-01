package com.tencent.mobileqq.videoplatform;

import android.content.Context;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerSDKMgr.ILogListener;
import com.tencent.superplayer.api.SuperPlayerSdkOption;
import com.tencent.thumbplayer.api.ITPModuleLoader;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoPlaySDKManager
{
  public static final int BIZID = 20160518;
  public static final int ERR_CODE_FILE_EXPIRED = 14011001;
  public static final int ERR_VIDEO_FILE_DAMAGED = 11022003;
  private static final int PLATFORM_ID = 170303;
  private static final String TAG = "[VideoPlatForm]VideoPlaySDKManager";
  private static volatile VideoPlaySDKManager mInstance;
  private boolean mIsSoLoadSuc;
  private CopyOnWriteArraySet<SDKInitListener> mSDKInstalledListenerSet = new CopyOnWriteArraySet();
  private AtomicInteger mState = new AtomicInteger(0);
  
  private ITPModuleLoader buildLoader()
  {
    return new VideoPlaySDKManager.3(this);
  }
  
  private SuperPlayerSDKMgr.ILogListener buildLogListener()
  {
    return new VideoPlaySDKManager.2(this);
  }
  
  public static VideoPlaySDKManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new VideoPlaySDKManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  private void initSDK(Context paramContext, SuperPlayerSdkOption paramSuperPlayerSdkOption)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      SuperPlayerSDKMgr.setLibLoader(buildLoader());
      SuperPlayerSDKMgr.initSDK(paramContext, 170303, paramContext.getApplicationContext().getExternalCacheDir() + "/superplayer", paramSuperPlayerSdkOption);
      SuperPlayerSDKMgr.setOnLogListener(buildLogListener());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e("[VideoPlatForm]VideoPlaySDKManager", 1, "setLibLoader err.", localException);
      }
    }
  }
  
  public void addSDKInstalledListener(SDKInitListener paramSDKInitListener)
  {
    if (paramSDKInitListener != null) {
      this.mSDKInstalledListenerSet.add(paramSDKInitListener);
    }
  }
  
  public void initSDKAsync(Context paramContext, SDKInitListener paramSDKInitListener)
  {
    try
    {
      initSDKAsync(paramContext, SuperPlayerSdkOption.option(), paramSDKInitListener);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public void initSDKAsync(Context paramContext, SuperPlayerSdkOption paramSuperPlayerSdkOption, SDKInitListener paramSDKInitListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_3
    //   4: invokevirtual 146	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:addSDKInstalledListener	(Lcom/tencent/mobileqq/videoplatform/SDKInitListener;)V
    //   7: aload_0
    //   8: getfield 37	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   11: invokevirtual 150	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   14: iconst_1
    //   15: if_icmpeq +21 -> 36
    //   18: aload_0
    //   19: getfield 37	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   22: invokevirtual 150	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   25: iconst_2
    //   26: if_icmpne +55 -> 81
    //   29: aload_0
    //   30: invokevirtual 154	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:isSoLoadSuc	()Z
    //   33: ifeq +48 -> 81
    //   36: invokestatic 157	com/tencent/mobileqq/videoplatform/util/LogUtil:isColorLevel	()Z
    //   39: ifeq +39 -> 78
    //   42: ldc 17
    //   44: iconst_2
    //   45: new 86	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   52: ldc 159
    //   54: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_0
    //   58: getfield 37	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   61: invokevirtual 150	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   64: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: ldc 164
    //   69: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 168	com/tencent/mobileqq/videoplatform/util/LogUtil:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: aload_0
    //   82: getfield 37	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   85: iconst_1
    //   86: invokevirtual 171	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   89: new 173	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager$1
    //   92: dup
    //   93: aload_0
    //   94: aload_1
    //   95: aload_2
    //   96: invokespecial 175	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager$1:<init>	(Lcom/tencent/mobileqq/videoplatform/VideoPlaySDKManager;Landroid/content/Context;Lcom/tencent/superplayer/api/SuperPlayerSdkOption;)V
    //   99: invokestatic 181	com/tencent/mobileqq/videoplatform/util/LoadSoUtil:loadSo	(Lcom/tencent/mobileqq/videoplatform/api/LoadSoCallback;)V
    //   102: goto -24 -> 78
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	VideoPlaySDKManager
    //   0	110	1	paramContext	Context
    //   0	110	2	paramSuperPlayerSdkOption	SuperPlayerSdkOption
    //   0	110	3	paramSDKInitListener	SDKInitListener
    // Exception table:
    //   from	to	target	type
    //   2	36	105	finally
    //   36	78	105	finally
    //   81	102	105	finally
  }
  
  /* Error */
  public boolean isSDKReady()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 150	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: istore_1
    //   10: iload_1
    //   11: iconst_2
    //   12: if_icmpne +9 -> 21
    //   15: iconst_1
    //   16: istore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_2
    //   23: goto -6 -> 17
    //   26: astore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	VideoPlaySDKManager
    //   9	4	1	i	int
    //   16	7	2	bool	boolean
    //   26	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	26	finally
  }
  
  public boolean isSoLoadSuc()
  {
    return this.mIsSoLoadSuc;
  }
  
  public void removeSDKInstalledListener(SDKInitListener paramSDKInitListener)
  {
    this.mSDKInstalledListenerSet.remove(paramSDKInitListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlaySDKManager
 * JD-Core Version:    0.7.0.1
 */