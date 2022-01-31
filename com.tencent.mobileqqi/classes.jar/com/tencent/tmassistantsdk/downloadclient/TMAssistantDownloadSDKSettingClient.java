package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.tmassistantsdk.a.a;
import com.tencent.tmassistantsdk.a.d;
import com.tencent.tmassistantsdk.a.e;

public class TMAssistantDownloadSDKSettingClient
  extends f
{
  protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService";
  
  public TMAssistantDownloadSDKSettingClient(Context paramContext, String paramString)
  {
    super(paramContext, paramString, "com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService");
  }
  
  protected Intent getBindServiceIntent()
  {
    return new Intent(this.mContext, Class.forName(this.mDwonloadServiceName));
  }
  
  /* Error */
  public int getVersion()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 40	com/tencent/tmassistantsdk/downloadclient/f:getServiceInterface	()Landroid/os/IInterface;
    //   6: checkcast 42	com/tencent/tmassistantsdk/a/d
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +14 -> 25
    //   14: aload_2
    //   15: invokeinterface 45 1 0
    //   20: istore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: aload_0
    //   26: invokespecial 49	com/tencent/tmassistantsdk/downloadclient/f:initTMAssistantDownloadSDK	()Z
    //   29: pop
    //   30: iconst_0
    //   31: istore_1
    //   32: goto -11 -> 21
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	TMAssistantDownloadSDKSettingClient
    //   20	12	1	i	int
    //   9	6	2	locald	d
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	35	finally
    //   14	21	35	finally
    //   25	30	35	finally
  }
  
  /* Error */
  public boolean isAllDownloadFinished()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 40	com/tencent/tmassistantsdk/downloadclient/f:getServiceInterface	()Landroid/os/IInterface;
    //   6: checkcast 42	com/tencent/tmassistantsdk/a/d
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +14 -> 25
    //   14: aload_2
    //   15: invokeinterface 53 1 0
    //   20: istore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_1
    //   24: ireturn
    //   25: aload_0
    //   26: invokespecial 49	com/tencent/tmassistantsdk/downloadclient/f:initTMAssistantDownloadSDK	()Z
    //   29: pop
    //   30: iconst_0
    //   31: istore_1
    //   32: goto -11 -> 21
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	TMAssistantDownloadSDKSettingClient
    //   20	12	1	bool	boolean
    //   9	6	2	locald	d
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	35	finally
    //   14	21	35	finally
    //   25	30	35	finally
  }
  
  protected void onDownloadSDKServiceInvalid() {}
  
  protected void registerServiceCallback()
  {
    ((d)this.mServiceInterface).a(this.mClientKey, (a)this.mServiceCallback);
  }
  
  public void setDownloadSDKMaxTaskNum(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > 10)) {}
    for (;;)
    {
      return;
      try
      {
        d locald = (d)super.getServiceInterface();
        if (locald != null)
        {
          locald.a(paramInt);
          continue;
        }
      }
      finally {}
      super.initTMAssistantDownloadSDK();
    }
  }
  
  /* Error */
  public void setDownloadSDKWifiOnly(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 40	com/tencent/tmassistantsdk/downloadclient/f:getServiceInterface	()Landroid/os/IInterface;
    //   6: checkcast 42	com/tencent/tmassistantsdk/a/d
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +13 -> 24
    //   14: aload_2
    //   15: iload_1
    //   16: invokeinterface 79 2 0
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: invokespecial 49	com/tencent/tmassistantsdk/downloadclient/f:initTMAssistantDownloadSDK	()Z
    //   28: pop
    //   29: goto -8 -> 21
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	TMAssistantDownloadSDKSettingClient
    //   0	37	1	paramBoolean	boolean
    //   9	6	2	locald	d
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	32	finally
    //   14	21	32	finally
    //   24	29	32	finally
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    this.mServiceInterface = e.a(paramIBinder);
  }
  
  protected void unRegisterServiceCallback()
  {
    ((d)this.mServiceInterface).b(this.mClientKey, (a)this.mServiceCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKSettingClient
 * JD-Core Version:    0.7.0.1
 */