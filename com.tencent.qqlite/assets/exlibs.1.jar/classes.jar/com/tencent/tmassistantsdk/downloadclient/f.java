package com.tencent.tmassistantsdk.downloadclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.tmassistantsdk.f.k;

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
        k.b("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK,clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",threadId:" + Thread.currentThread().getId());
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
        k.b("TMAssistantDownloadSDKClient", " context:" + this.mContext.getClass().getName() + "  serviceName:" + ((Intent)localObject2).getAction());
        bool1 = this.mContext.bindService((Intent)localObject2, this, 1);
        k.b("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK bindResult:" + bool1);
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
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    stubAsInterface(paramIBinder);
    this.connectState = "FINISH";
    synchronized (this.mThreadlock)
    {
      this.mThreadlock.notifyAll();
      k.b("TMAssistantDownloadSDKClient", "onServiceConnected,clientKey:" + this.mClientKey + ",mServiceInterface:" + this.mServiceInterface + ",IBinder:" + paramIBinder + ",threadId:" + Thread.currentThread().getId() + ",componetName:" + paramComponentName);
    }
  }
  
  /* Error */
  public void onServiceDisconnected(ComponentName arg1)
  {
    // Byte code:
    //   0: ldc 19
    //   2: new 95	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 181
    //   8: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 48	com/tencent/tmassistantsdk/downloadclient/f:mClientKey	Ljava/lang/String;
    //   15: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 172
    //   20: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 122	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: monitorenter
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 40	com/tencent/tmassistantsdk/downloadclient/f:mServiceInterface	Landroid/os/IInterface;
    //   40: aload_0
    //   41: ldc 16
    //   43: putfield 38	com/tencent/tmassistantsdk/downloadclient/f:connectState	Ljava/lang/String;
    //   46: aload_0
    //   47: getfield 44	com/tencent/tmassistantsdk/downloadclient/f:mThreadlock	Ljava/lang/Object;
    //   50: astore_1
    //   51: aload_1
    //   52: monitorenter
    //   53: aload_0
    //   54: getfield 44	com/tencent/tmassistantsdk/downloadclient/f:mThreadlock	Ljava/lang/Object;
    //   57: invokevirtual 166	java/lang/Object:notifyAll	()V
    //   60: aload_1
    //   61: monitorexit
    //   62: aload_0
    //   63: invokevirtual 177	com/tencent/tmassistantsdk/downloadclient/f:onDownloadSDKServiceInvalid	()V
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: astore_2
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	f
    //   69	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   53	62	69	finally
    //   35	53	74	finally
    //   62	68	74	finally
    //   70	74	74	finally
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
    //   8: ldc 184
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
    //   49: invokestatic 122	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 40	com/tencent/tmassistantsdk/downloadclient/f:mServiceInterface	Landroid/os/IInterface;
    //   56: ifnull +16 -> 72
    //   59: aload_0
    //   60: getfield 42	com/tencent/tmassistantsdk/downloadclient/f:mServiceCallback	Landroid/os/IInterface;
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 187	com/tencent/tmassistantsdk/downloadclient/f:unRegisterServiceCallback	()V
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
    //   95: invokevirtual 191	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.f
 * JD-Core Version:    0.7.0.1
 */