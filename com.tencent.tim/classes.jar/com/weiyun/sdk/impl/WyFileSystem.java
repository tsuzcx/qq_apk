package com.weiyun.sdk.impl;

import com.weiyun.sdk.IWyBizManager;
import com.weiyun.sdk.IWyCloudFileSystem;
import com.weiyun.sdk.IWyFileSystem;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.Thumbnail;
import com.weiyun.sdk.IWyFileSystem.ThumbnailType;
import com.weiyun.sdk.IWyFileSystem.WyCommand;
import com.weiyun.sdk.IWyTaskManager;
import com.weiyun.sdk.util.UtilsMisc;

public class WyFileSystem
  implements IWyFileSystem
{
  private static final String TAG = "WyFileSystem";
  private IWyBizManager mBizManager = new DefaultBizManager();
  private IWyCloudFileSystem mCloudFileSystem = new DefaultCloudFileSystem();
  private volatile boolean mStartup = false;
  private DefaultTaskManager mTaskManager = new DefaultTaskManager();
  private DefaultThumbnailLoader mThumbnailLoader = new DefaultThumbnailLoader();
  
  public void cancelAllThumbnailTask()
  {
    this.mThumbnailLoader.cancelAllThumbnailTask();
  }
  
  public IWyBizManager getBizManager()
  {
    return this.mBizManager;
  }
  
  public IWyCloudFileSystem getCloudFileSystem()
  {
    UtilsMisc.assertTrue(this.mStartup, "call startup first");
    return this.mCloudFileSystem;
  }
  
  public IWyFileSystem.WyCommand getOfflineFileThumbnail(String paramString, IWyFileSystem.ThumbnailType paramThumbnailType, int paramInt, Object paramObject, IWyFileSystem.IWyCallback<IWyFileSystem.Thumbnail> paramIWyCallback)
  {
    return this.mThumbnailLoader.getOfflineThumbnail(paramString, paramInt, paramThumbnailType, paramObject, paramIWyCallback);
  }
  
  public String getOfflineFileThumbnail(String paramString, IWyFileSystem.ThumbnailType paramThumbnailType)
  {
    return this.mThumbnailLoader.getOfflineThumbnail(paramString, paramThumbnailType);
  }
  
  public IWyTaskManager getTaskManager()
  {
    UtilsMisc.assertTrue(this.mStartup, "call startup first");
    return this.mTaskManager;
  }
  
  public IWyFileSystem.WyCommand getThumbnail(String paramString1, IWyFileSystem.ThumbnailType paramThumbnailType, String paramString2, long paramLong, Object paramObject, IWyFileSystem.IWyCallback<IWyFileSystem.Thumbnail> paramIWyCallback)
  {
    return this.mThumbnailLoader.getThumbnail(paramString1, paramThumbnailType, paramString2, paramLong, paramObject, paramIWyCallback);
  }
  
  public IWyFileSystem.WyCommand getThumbnail(String paramString1, IWyFileSystem.ThumbnailType paramThumbnailType, String paramString2, long paramLong, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, Object paramObject, IWyFileSystem.IWyCallback<IWyFileSystem.Thumbnail> paramIWyCallback)
  {
    return this.mThumbnailLoader.getThumbnail(paramString1, paramThumbnailType, paramString2, paramLong, paramString3, paramInt, paramString4, paramString5, paramString6, paramObject, paramIWyCallback);
  }
  
  public String getThumbnail(String paramString1, IWyFileSystem.ThumbnailType paramThumbnailType, String paramString2, long paramLong)
  {
    return this.mThumbnailLoader.getThumbnail(paramString1, paramThumbnailType, paramString2, paramLong);
  }
  
  /* Error */
  public void shutdown()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/weiyun/sdk/impl/WyFileSystem:mStartup	Z
    //   6: ifeq +55 -> 61
    //   9: aload_0
    //   10: getfield 41	com/weiyun/sdk/impl/WyFileSystem:mTaskManager	Lcom/weiyun/sdk/impl/DefaultTaskManager;
    //   13: invokevirtual 91	com/weiyun/sdk/impl/DefaultTaskManager:unInit	()V
    //   16: aload_0
    //   17: getfield 46	com/weiyun/sdk/impl/WyFileSystem:mThumbnailLoader	Lcom/weiyun/sdk/impl/DefaultThumbnailLoader;
    //   20: invokevirtual 92	com/weiyun/sdk/impl/DefaultThumbnailLoader:unInit	()V
    //   23: invokestatic 98	com/weiyun/sdk/context/SdkContext:getInstance	()Lcom/weiyun/sdk/context/SdkContext;
    //   26: invokevirtual 99	com/weiyun/sdk/context/SdkContext:unInit	()V
    //   29: ldc 10
    //   31: new 101	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   38: ldc 104
    //   40: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 121	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: iconst_0
    //   55: putfield 26	com/weiyun/sdk/impl/WyFileSystem:mStartup	Z
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: ldc 10
    //   63: ldc 123
    //   65: invokestatic 126	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: goto -10 -> 58
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	WyFileSystem
    //   71	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	58	71	finally
    //   61	68	71	finally
  }
  
  /* Error */
  public void startup(android.app.Application paramApplication, String paramString, com.weiyun.sdk.IWySender paramIWySender, com.weiyun.sdk.log.ILogger paramILogger, com.weiyun.sdk.WyConfiguration paramWyConfiguration)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/weiyun/sdk/impl/WyFileSystem:mStartup	Z
    //   6: ifeq +13 -> 19
    //   9: ldc 10
    //   11: ldc 130
    //   13: invokestatic 126	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: invokestatic 98	com/weiyun/sdk/context/SdkContext:getInstance	()Lcom/weiyun/sdk/context/SdkContext;
    //   22: aload_1
    //   23: invokestatic 134	com/weiyun/sdk/util/UtilsMisc:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast 136	android/content/Context
    //   29: invokevirtual 140	com/weiyun/sdk/context/SdkContext:setContext	(Landroid/content/Context;)V
    //   32: invokestatic 98	com/weiyun/sdk/context/SdkContext:getInstance	()Lcom/weiyun/sdk/context/SdkContext;
    //   35: aload_2
    //   36: invokestatic 134	com/weiyun/sdk/util/UtilsMisc:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   39: checkcast 142	java/lang/String
    //   42: aload_2
    //   43: invokestatic 148	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   46: invokevirtual 152	java/lang/Long:longValue	()J
    //   49: invokevirtual 156	com/weiyun/sdk/context/SdkContext:setAccount	(Ljava/lang/String;J)V
    //   52: invokestatic 98	com/weiyun/sdk/context/SdkContext:getInstance	()Lcom/weiyun/sdk/context/SdkContext;
    //   55: aload_3
    //   56: invokestatic 134	com/weiyun/sdk/util/UtilsMisc:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 158	com/weiyun/sdk/IWySender
    //   62: invokevirtual 162	com/weiyun/sdk/context/SdkContext:setSender	(Lcom/weiyun/sdk/IWySender;)V
    //   65: invokestatic 98	com/weiyun/sdk/context/SdkContext:getInstance	()Lcom/weiyun/sdk/context/SdkContext;
    //   68: aload 4
    //   70: invokestatic 134	com/weiyun/sdk/util/UtilsMisc:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 164	com/weiyun/sdk/log/ILogger
    //   76: invokevirtual 168	com/weiyun/sdk/context/SdkContext:setLogger	(Lcom/weiyun/sdk/log/ILogger;)V
    //   79: invokestatic 98	com/weiyun/sdk/context/SdkContext:getInstance	()Lcom/weiyun/sdk/context/SdkContext;
    //   82: aload 5
    //   84: invokestatic 134	com/weiyun/sdk/util/UtilsMisc:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   87: checkcast 170	com/weiyun/sdk/WyConfiguration
    //   90: invokevirtual 174	com/weiyun/sdk/context/SdkContext:setConfigure	(Lcom/weiyun/sdk/WyConfiguration;)V
    //   93: invokestatic 98	com/weiyun/sdk/context/SdkContext:getInstance	()Lcom/weiyun/sdk/context/SdkContext;
    //   96: invokevirtual 177	com/weiyun/sdk/context/SdkContext:init	()V
    //   99: ldc 10
    //   101: ldc 179
    //   103: iconst_3
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_3
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: aload 4
    //   115: aastore
    //   116: dup
    //   117: iconst_2
    //   118: aload 5
    //   120: aastore
    //   121: invokestatic 183	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   124: invokestatic 121	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_0
    //   128: getfield 41	com/weiyun/sdk/impl/WyFileSystem:mTaskManager	Lcom/weiyun/sdk/impl/DefaultTaskManager;
    //   131: aload 5
    //   133: invokevirtual 187	com/weiyun/sdk/WyConfiguration:getMaxTaskNum	()I
    //   136: aload 5
    //   138: invokevirtual 190	com/weiyun/sdk/WyConfiguration:getCachePath	()Ljava/lang/String;
    //   141: invokevirtual 193	com/weiyun/sdk/impl/DefaultTaskManager:init	(ILjava/lang/String;)V
    //   144: aload_0
    //   145: getfield 46	com/weiyun/sdk/impl/WyFileSystem:mThumbnailLoader	Lcom/weiyun/sdk/impl/DefaultThumbnailLoader;
    //   148: aload 5
    //   150: invokevirtual 190	com/weiyun/sdk/WyConfiguration:getCachePath	()Ljava/lang/String;
    //   153: invokevirtual 196	com/weiyun/sdk/impl/DefaultThumbnailLoader:init	(Ljava/lang/String;)V
    //   156: aload_0
    //   157: iconst_1
    //   158: putfield 26	com/weiyun/sdk/impl/WyFileSystem:mStartup	Z
    //   161: goto -145 -> 16
    //   164: astore_1
    //   165: aload_0
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	WyFileSystem
    //   0	169	1	paramApplication	android.app.Application
    //   0	169	2	paramString	String
    //   0	169	3	paramIWySender	com.weiyun.sdk.IWySender
    //   0	169	4	paramILogger	com.weiyun.sdk.log.ILogger
    //   0	169	5	paramWyConfiguration	com.weiyun.sdk.WyConfiguration
    // Exception table:
    //   from	to	target	type
    //   2	16	164	finally
    //   19	161	164	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.WyFileSystem
 * JD-Core Version:    0.7.0.1
 */