package com.weiyun.sdk.impl;

import com.weiyun.sdk.IWyTaskManager;
import com.weiyun.sdk.IWyTaskManager.Task;
import com.weiyun.sdk.job.schedule.WyTaskManager;

public class DefaultTaskManager
  implements IWyTaskManager
{
  protected volatile WyTaskManager mTaskManager;
  
  public IWyTaskManager.Task createDownloadTask(String paramString1, String paramString2, long paramLong1, long paramLong2, Object paramObject)
  {
    WyTaskManager localWyTaskManager = this.mTaskManager;
    if ((paramString1 == null) || (paramString2 == null) || (paramLong1 < 0L) || (localWyTaskManager == null)) {
      return null;
    }
    return localWyTaskManager.createDownloadTask(paramString1, paramString2, paramLong1, paramLong2, paramObject);
  }
  
  public IWyTaskManager.Task createUploadTask(String paramString, Object paramObject)
  {
    WyTaskManager localWyTaskManager = this.mTaskManager;
    if ((paramString == null) || (localWyTaskManager == null)) {
      return null;
    }
    return localWyTaskManager.createUploadTask(paramString, paramObject);
  }
  
  public IWyTaskManager.Task findDownloadTask(String paramString)
  {
    WyTaskManager localWyTaskManager = this.mTaskManager;
    if ((paramString == null) || (localWyTaskManager == null)) {
      return null;
    }
    return localWyTaskManager.findDownloadTask(paramString);
  }
  
  public IWyTaskManager.Task findUploadTask(String paramString)
  {
    WyTaskManager localWyTaskManager = this.mTaskManager;
    if ((paramString == null) || (localWyTaskManager == null)) {
      return null;
    }
    return localWyTaskManager.findUploadTask(paramString);
  }
  
  /* Error */
  public void init(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/weiyun/sdk/impl/DefaultTaskManager:mTaskManager	Lcom/weiyun/sdk/job/schedule/WyTaskManager;
    //   6: ifnonnull +57 -> 63
    //   9: iload_1
    //   10: ifle +65 -> 75
    //   13: aload_2
    //   14: astore_3
    //   15: aload_2
    //   16: bipush 47
    //   18: invokevirtual 40	java/lang/String:lastIndexOf	(I)I
    //   21: aload_2
    //   22: invokevirtual 44	java/lang/String:length	()I
    //   25: iconst_1
    //   26: isub
    //   27: if_icmpeq +23 -> 50
    //   30: new 46	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   37: aload_2
    //   38: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 53
    //   43: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore_3
    //   50: aload_0
    //   51: new 19	com/weiyun/sdk/job/schedule/WyTaskManager
    //   54: dup
    //   55: iload_1
    //   56: aload_3
    //   57: invokespecial 59	com/weiyun/sdk/job/schedule/WyTaskManager:<init>	(ILjava/lang/String;)V
    //   60: putfield 17	com/weiyun/sdk/impl/DefaultTaskManager:mTaskManager	Lcom/weiyun/sdk/job/schedule/WyTaskManager;
    //   63: invokestatic 65	com/weiyun/sdk/context/SdkContext:getInstance	()Lcom/weiyun/sdk/context/SdkContext;
    //   66: invokevirtual 69	com/weiyun/sdk/context/SdkContext:getContext	()Landroid/content/Context;
    //   69: invokestatic 75	com/weiyun/sdk/util/NetworkUtils:setContext	(Landroid/content/Context;)V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: iconst_1
    //   76: istore_1
    //   77: goto -64 -> 13
    //   80: astore_2
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_2
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	DefaultTaskManager
    //   0	85	1	paramInt	int
    //   0	85	2	paramString	String
    //   14	43	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	9	80	finally
    //   15	50	80	finally
    //   50	63	80	finally
    //   63	72	80	finally
  }
  
  public boolean submitTask(IWyTaskManager.Task paramTask)
  {
    WyTaskManager localWyTaskManager = this.mTaskManager;
    if ((paramTask == null) || (localWyTaskManager == null)) {
      return false;
    }
    return localWyTaskManager.submitTask(paramTask);
  }
  
  public void unInit()
  {
    try
    {
      WyTaskManager localWyTaskManager = this.mTaskManager;
      if (localWyTaskManager != null)
      {
        localWyTaskManager.shutdown();
        this.mTaskManager = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultTaskManager
 * JD-Core Version:    0.7.0.1
 */