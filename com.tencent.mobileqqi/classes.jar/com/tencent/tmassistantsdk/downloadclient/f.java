package com.tencent.tmassistantsdk.downloadclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.tmassistantsdk.f.j;

public abstract class f
  implements ServiceConnection
{
  public static final String CONNTECTSTATE_CONNECTING = "CONNECTING";
  public static final String CONNTECTSTATE_FINISH = "FINISH";
  public static final String CONNTECTSTATE_INIT = "INIT";
  protected static final String TAG = "TMAssistantDownloadSDKClient";
  protected String connectState = "INIT";
  public String mClientKey;
  protected Context mContext;
  protected String mDwonloadServiceName = null;
  protected IInterface mServiceCallback = null;
  protected IInterface mServiceInterface = null;
  protected final Object mThreadlock = new Object();
  
  public f(Context paramContext, String paramString1, String paramString2)
  {
    this.mContext = paramContext;
    this.mClientKey = paramString1;
    this.mDwonloadServiceName = paramString2;
  }
  
  protected abstract Intent getBindServiceIntent();
  
  protected IInterface getServiceInterface()
  {
    if ((this.mContext != null) && (this.mContext.getMainLooper().getThread().getId() == Thread.currentThread().getId())) {
      throw new Exception("TMAssistantDownloadSDKClient must be called in other Thread(no MainThread)");
    }
    if (this.mServiceInterface == null)
    {
      initTMAssistantDownloadSDK();
      this.connectState = "CONNECTING";
    }
    synchronized (this.mThreadlock)
    {
      this.mThreadlock.wait(10000L);
      if (this.mServiceInterface == null) {
        throw new Exception("TMAssistantDownloadSDKClient ServiceInterface is null");
      }
    }
    return this.mServiceInterface;
  }
  
  public boolean initTMAssistantDownloadSDK()
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        String str = this.connectState;
        if (str != "INIT") {
          return bool1;
        }
        j.b("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK,clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",threadId:" + Thread.currentThread().getId());
        this.connectState = "INIT";
        if (this.mServiceInterface != null)
        {
          this.connectState = "FINISH";
          continue;
        }
        bool2 = false;
      }
      finally {}
      boolean bool2;
      boolean bool3 = false;
      bool1 = bool3;
      if (this.mContext == null) {
        continue;
      }
      Object localObject2 = this.mDwonloadServiceName;
      bool1 = bool3;
      if (localObject2 == null) {
        continue;
      }
      try
      {
        localObject2 = getBindServiceIntent();
        bool1 = this.mContext.bindService((Intent)localObject2, this, 1);
        j.b("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK bindResult:" + bool1);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          bool1 = bool2;
        }
      }
    }
  }
  
  protected abstract void onDownloadSDKServiceInvalid();
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    stubAsInterface(paramIBinder);
    this.connectState = "FINISH";
    synchronized (this.mThreadlock)
    {
      this.mThreadlock.notifyAll();
      j.b("TMAssistantDownloadSDKClient", "onServiceConnected,clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",IBinder:" + paramIBinder + ",threadId:" + Thread.currentThread().getId());
    }
  }
  
  /* Error */
  public void onServiceDisconnected(ComponentName arg1)
  {
    // Byte code:
    //   0: ldc 19
    //   2: new 95	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 161
    //   8: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 48	com/tencent/tmassistantsdk/downloadclient/f:mClientKey	Ljava/lang/String;
    //   15: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 122	com/tencent/tmassistantsdk/f/j:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: monitorenter
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 40	com/tencent/tmassistantsdk/downloadclient/f:mServiceInterface	Landroid/os/IInterface;
    //   31: aload_0
    //   32: ldc 16
    //   34: putfield 38	com/tencent/tmassistantsdk/downloadclient/f:connectState	Ljava/lang/String;
    //   37: aload_0
    //   38: getfield 44	com/tencent/tmassistantsdk/downloadclient/f:mThreadlock	Ljava/lang/Object;
    //   41: astore_1
    //   42: aload_1
    //   43: monitorenter
    //   44: aload_0
    //   45: getfield 44	com/tencent/tmassistantsdk/downloadclient/f:mThreadlock	Ljava/lang/Object;
    //   48: invokevirtual 148	java/lang/Object:notifyAll	()V
    //   51: aload_1
    //   52: monitorexit
    //   53: aload_0
    //   54: invokevirtual 157	com/tencent/tmassistantsdk/downloadclient/f:onDownloadSDKServiceInvalid	()V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore_2
    //   61: aload_1
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	f
    //   60	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   44	53	60	finally
    //   26	44	65	finally
    //   53	59	65	finally
    //   61	65	65	finally
  }
  
  protected abstract void registerServiceCallback();
  
  protected abstract void stubAsInterface(IBinder paramIBinder);
  
  /* Error */
  public void unInitTMAssistantDownloadSDK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 19
    //   4: new 95	java/lang/StringBuilder
    //   7: dup
    //   8: ldc 164
    //   10: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 48	com/tencent/tmassistantsdk/downloadclient/f:mClientKey	Ljava/lang/String;
    //   17: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 104
    //   22: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 40	com/tencent/tmassistantsdk/downloadclient/f:mServiceInterface	Landroid/os/IInterface;
    //   29: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: ldc 109
    //   34: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokestatic 74	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   40: invokevirtual 71	java/lang/Thread:getId	()J
    //   43: invokevirtual 112	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 122	com/tencent/tmassistantsdk/f/j:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 40	com/tencent/tmassistantsdk/downloadclient/f:mServiceInterface	Landroid/os/IInterface;
    //   56: ifnull +16 -> 72
    //   59: aload_0
    //   60: getfield 42	com/tencent/tmassistantsdk/downloadclient/f:mServiceCallback	Landroid/os/IInterface;
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 167	com/tencent/tmassistantsdk/downloadclient/f:unRegisterServiceCallback	()V
    //   72: aload_0
    //   73: getfield 46	com/tencent/tmassistantsdk/downloadclient/f:mContext	Landroid/content/Context;
    //   76: ifnull +22 -> 98
    //   79: aload_0
    //   80: ifnull +18 -> 98
    //   83: aload_0
    //   84: getfield 40	com/tencent/tmassistantsdk/downloadclient/f:mServiceInterface	Landroid/os/IInterface;
    //   87: ifnull +11 -> 98
    //   90: aload_0
    //   91: getfield 46	com/tencent/tmassistantsdk/downloadclient/f:mContext	Landroid/content/Context;
    //   94: aload_0
    //   95: invokevirtual 171	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 40	com/tencent/tmassistantsdk/downloadclient/f:mServiceInterface	Landroid/os/IInterface;
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 42	com/tencent/tmassistantsdk/downloadclient/f:mServiceCallback	Landroid/os/IInterface;
    //   108: aload_0
    //   109: ldc 16
    //   111: putfield 38	com/tencent/tmassistantsdk/downloadclient/f:connectState	Ljava/lang/String;
    //   114: aload_0
    //   115: monitorexit
    //   116: return
    //   117: astore_1
    //   118: goto -46 -> 72
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	f
    //   63	2	1	localIInterface	IInterface
    //   117	1	1	localRemoteException	RemoteException
    //   121	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   68	72	117	android/os/RemoteException
    //   2	64	121	finally
    //   68	72	121	finally
    //   72	79	121	finally
    //   83	98	121	finally
    //   98	114	121	finally
  }
  
  protected abstract void unRegisterServiceCallback();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.f
 * JD-Core Version:    0.7.0.1
 */