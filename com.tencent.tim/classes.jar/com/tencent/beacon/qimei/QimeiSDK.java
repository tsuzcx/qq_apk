package com.tencent.beacon.qimei;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QimeiSDK
  implements com.tencent.beacon.a.a.d
{
  public static final String TAG = "[Qimei]";
  private static volatile QimeiSDK instance;
  private String appKey;
  private String beaconId = "";
  private Context mContext;
  private String oaID = "";
  private String omgID = "";
  private final List<IAsyncQimeiListener> qimeiListeners = Collections.synchronizedList(new ArrayList(3));
  
  public static QimeiSDK getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QimeiSDK();
      }
      return instance;
    }
    finally {}
  }
  
  /* Error */
  private boolean isInit()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 58	com/tencent/beacon/qimei/QimeiSDK:mContext	Landroid/content/Context;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +9 -> 19
    //   13: iconst_1
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: ldc 60
    //   21: iconst_0
    //   22: anewarray 4	java/lang/Object
    //   25: invokestatic 66	com/tencent/beacon/base/util/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: goto -13 -> 15
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	QimeiSDK
    //   1	17	1	bool	boolean
    //   8	2	2	localContext	Context
    //   31	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	31	finally
    //   19	28	31	finally
  }
  
  private boolean isUpdateQimei()
  {
    boolean bool = false;
    Qimei localQimei = getQimei();
    if ((localQimei == null) || (localQimei.isEmpty())) {
      bool = true;
    }
    do
    {
      return bool;
      if ((e.c()) || (e.a()))
      {
        com.tencent.beacon.base.util.c.d("[qimei] isQIMEIReqZeroPeak or Qimei disable", new Object[0]);
        return false;
      }
    } while ((!e.b()) && (!com.tencent.beacon.a.c.b.h()));
    return true;
  }
  
  public String getAppKey()
  {
    try
    {
      String str = this.appKey;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public String getBeaconIdInfo()
  {
    try
    {
      if (TextUtils.isEmpty(this.beaconId)) {
        this.beaconId = com.tencent.beacon.b.a.a(Build.VERSION.SDK_INT);
      }
      String str = this.beaconId;
      return str;
    }
    finally {}
  }
  
  public Context getContext()
  {
    try
    {
      Context localContext = this.mContext;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public String getOAID()
  {
    return "";
  }
  
  public String getOmgID()
  {
    return this.omgID;
  }
  
  public Qimei getQimei()
  {
    if (com.tencent.beacon.a.c.c.d().c() == null) {
      return null;
    }
    return a.a().b();
  }
  
  public void getQimei(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    try
    {
      com.tencent.beacon.a.b.a.a().a(new d(this, paramIAsyncQimeiListener));
      return;
    }
    finally
    {
      paramIAsyncQimeiListener = finally;
      throw paramIAsyncQimeiListener;
    }
  }
  
  /* Error */
  @Deprecated
  public String getQimeiInternal()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 152	com/tencent/beacon/qimei/QimeiSDK:isInit	()Z
    //   6: ifne +10 -> 16
    //   9: ldc 40
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: invokestatic 133	com/tencent/beacon/qimei/a:a	()Lcom/tencent/beacon/qimei/a;
    //   19: invokevirtual 135	com/tencent/beacon/qimei/a:b	()Lcom/tencent/beacon/qimei/Qimei;
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 155	com/tencent/beacon/qimei/Qimei:getQimeiOld	()Ljava/lang/String;
    //   27: invokestatic 105	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifne +11 -> 41
    //   33: aload_1
    //   34: invokevirtual 155	com/tencent/beacon/qimei/Qimei:getQimeiOld	()Ljava/lang/String;
    //   37: astore_1
    //   38: goto -26 -> 12
    //   41: ldc 40
    //   43: astore_1
    //   44: goto -32 -> 12
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	QimeiSDK
    //   11	33	1	localObject1	Object
    //   47	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	47	finally
    //   16	38	47	finally
  }
  
  public QimeiSDK init(Context paramContext)
  {
    try
    {
      if (!isInit())
      {
        com.tencent.beacon.base.util.c.a("[Qimei]", "QimeiSDK init!", new Object[0]);
        this.mContext = paramContext;
        com.tencent.beacon.a.a.b.a().a(1, this);
        boolean bool = isUpdateQimei();
        com.tencent.beacon.base.util.c.a("[Qimei]", "isUpdate Qimei: %s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          com.tencent.beacon.a.b.a.a().a(new c(paramContext));
        }
      }
      return this;
    }
    finally {}
  }
  
  public void logQimeiCallbackError(Throwable paramThrowable)
  {
    com.tencent.beacon.base.util.c.b("[qimei] onQimeiDispatch error!", new Object[] { paramThrowable.getMessage() });
    com.tencent.beacon.base.util.c.a(paramThrowable);
    com.tencent.beacon.a.b.d.b().a("514", "QimeiDispatch error", paramThrowable);
  }
  
  @WorkerThread
  public void onEvent(com.tencent.beacon.a.a.c arg1)
  {
    if (???.a == 1)
    {
      synchronized (this.qimeiListeners)
      {
        Qimei localQimei = a.a().b();
        if ((localQimei != null) && (localQimei.isEmpty())) {
          return;
        }
        Iterator localIterator = this.qimeiListeners.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            IAsyncQimeiListener localIAsyncQimeiListener = (IAsyncQimeiListener)localIterator.next();
            try
            {
              localIAsyncQimeiListener.onQimeiDispatch(localQimei);
            }
            catch (Throwable localThrowable)
            {
              logQimeiCallbackError(localThrowable);
            }
          }
        }
      }
      this.qimeiListeners.clear();
    }
  }
  
  public QimeiSDK setAppKey(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.appKey = paramString;
    }
    return this;
  }
  
  public QimeiSDK setLogAble(boolean paramBoolean)
  {
    try
    {
      com.tencent.beacon.base.util.c.a(paramBoolean);
      com.tencent.beacon.base.util.c.b(paramBoolean);
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public void setOAID(String paramString) {}
  
  public QimeiSDK setOmgId(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.omgID = paramString;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.qimei.QimeiSDK
 * JD-Core Version:    0.7.0.1
 */