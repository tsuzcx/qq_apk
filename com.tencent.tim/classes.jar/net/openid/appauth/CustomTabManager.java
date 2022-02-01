package net.openid.appauth;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class CustomTabManager
{
  private static final long CLIENT_WAIT_TIME = 1L;
  @NonNull
  private final AtomicReference<CustomTabsClient> mClient;
  @NonNull
  private final CountDownLatch mClientLatch;
  @Nullable
  private CustomTabsServiceConnection mConnection;
  @NonNull
  private final Context mContext;
  
  CustomTabManager(@NonNull Context paramContext)
  {
    this.mContext = paramContext;
    this.mClient = new AtomicReference();
    this.mClientLatch = new CountDownLatch(1);
  }
  
  private CustomTabsSession createSession()
  {
    try
    {
      this.mClientLatch.await(1L, TimeUnit.SECONDS);
      CustomTabsClient localCustomTabsClient = (CustomTabsClient)this.mClient.get();
      if (localCustomTabsClient != null) {
        return localCustomTabsClient.newSession(null);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Logger.info("Interrupted while waiting for browser connection", new Object[0]);
        this.mClientLatch.countDown();
      }
    }
    return null;
  }
  
  /* Error */
  public void bind(@NonNull java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	net/openid/appauth/CustomTabManager:mConnection	Landroid/support/customtabs/CustomTabsServiceConnection;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: new 85	net/openid/appauth/CustomTabManager$1
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 88	net/openid/appauth/CustomTabManager$1:<init>	(Lnet/openid/appauth/CustomTabManager;)V
    //   23: putfield 83	net/openid/appauth/CustomTabManager:mConnection	Landroid/support/customtabs/CustomTabsServiceConnection;
    //   26: aload_0
    //   27: getfield 26	net/openid/appauth/CustomTabManager:mContext	Landroid/content/Context;
    //   30: aload_1
    //   31: aload_0
    //   32: getfield 83	net/openid/appauth/CustomTabManager:mConnection	Landroid/support/customtabs/CustomTabsServiceConnection;
    //   35: invokestatic 92	android/support/customtabs/CustomTabsClient:bindCustomTabsService	(Landroid/content/Context;Ljava/lang/String;Landroid/support/customtabs/CustomTabsServiceConnection;)Z
    //   38: ifne -27 -> 11
    //   41: ldc 94
    //   43: iconst_0
    //   44: anewarray 4	java/lang/Object
    //   47: invokestatic 76	net/openid/appauth/Logger:info	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: aload_0
    //   51: getfield 38	net/openid/appauth/CustomTabManager:mClientLatch	Ljava/util/concurrent/CountDownLatch;
    //   54: invokevirtual 79	java/util/concurrent/CountDownLatch:countDown	()V
    //   57: goto -46 -> 11
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	CustomTabManager
    //   0	65	1	paramString	java.lang.String
    //   6	2	2	localCustomTabsServiceConnection	CustomTabsServiceConnection
    // Exception table:
    //   from	to	target	type
    //   2	7	60	finally
    //   14	57	60	finally
  }
  
  public CustomTabsIntent.Builder createCustomTabsIntentBuilder()
  {
    return new CustomTabsIntent.Builder(createSession());
  }
  
  /* Error */
  public void unbind()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	net/openid/appauth/CustomTabManager:mConnection	Landroid/support/customtabs/CustomTabsServiceConnection;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 26	net/openid/appauth/CustomTabManager:mContext	Landroid/content/Context;
    //   18: aload_0
    //   19: getfield 83	net/openid/appauth/CustomTabManager:mConnection	Landroid/support/customtabs/CustomTabsServiceConnection;
    //   22: invokevirtual 110	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   25: aload_0
    //   26: getfield 31	net/openid/appauth/CustomTabManager:mClient	Ljava/util/concurrent/atomic/AtomicReference;
    //   29: aconst_null
    //   30: invokevirtual 114	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   33: ldc 116
    //   35: iconst_0
    //   36: anewarray 4	java/lang/Object
    //   39: invokestatic 119	net/openid/appauth/Logger:debug	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: goto -31 -> 11
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	CustomTabManager
    //   6	2	1	localCustomTabsServiceConnection	CustomTabsServiceConnection
    //   45	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	45	finally
    //   14	42	45	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.CustomTabManager
 * JD-Core Version:    0.7.0.1
 */