import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.1;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.3;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class arbl
{
  public static final LruCache<String, arbl> H = new LruCache(8);
  public static final AtomicInteger ck = new AtomicInteger(1);
  public final jml authConfig;
  public String businessId;
  public final CopyOnWriteArrayList<arbl.a> callbacks = new CopyOnWriteArrayList();
  public final AtomicInteger cj = new AtomicInteger(0);
  public final AtomicInteger state = new AtomicInteger(1);
  
  arbl(String paramString)
  {
    this.businessId = paramString;
    this.authConfig = jml.a();
  }
  
  /* Error */
  public static arbl a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +8 -> 19
    //   14: ldc 2
    //   16: monitorexit
    //   17: aload_2
    //   18: areturn
    //   19: aload_0
    //   20: ldc 69
    //   22: invokevirtual 75	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   25: ifne +12 -> 37
    //   28: aload_0
    //   29: ldc 77
    //   31: invokevirtual 75	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   34: ifeq -20 -> 14
    //   37: ldc 79
    //   39: astore_2
    //   40: aload_0
    //   41: invokestatic 85	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   44: astore_3
    //   45: aload_2
    //   46: astore_0
    //   47: aload_3
    //   48: invokevirtual 89	android/net/Uri:isHierarchical	()Z
    //   51: ifeq +10 -> 61
    //   54: aload_3
    //   55: ldc 91
    //   57: invokevirtual 95	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_0
    //   61: aload_0
    //   62: invokestatic 98	arbl:b	(Ljava/lang/String;)Larbl;
    //   65: astore_2
    //   66: goto -52 -> 14
    //   69: astore_0
    //   70: aload_0
    //   71: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   74: aload_2
    //   75: astore_0
    //   76: goto -15 -> 61
    //   79: astore_0
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramString	String
    //   9	2	1	bool	boolean
    //   1	74	2	localObject	Object
    //   44	11	3	localUri	android.net.Uri
    // Exception table:
    //   from	to	target	type
    //   40	45	69	java/lang/Exception
    //   47	61	69	java/lang/Exception
    //   5	10	79	finally
    //   19	28	79	finally
    //   28	37	79	finally
    //   40	45	79	finally
    //   47	61	79	finally
    //   61	66	79	finally
    //   70	74	79	finally
  }
  
  public static arbl b(String paramString)
  {
    Object localObject = null;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        arbl localarbl = (arbl)H.get(paramString);
        localObject = localarbl;
        if (localarbl == null)
        {
          localObject = new arbl(paramString);
          H.put(paramString, localObject);
        }
      }
      return localObject;
    }
    finally {}
  }
  
  public void a(arbl.a parama, String paramString)
  {
    if ((this.state.get() == 3) && (parama != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserOfflineHandler", 2, "now offline bid is ready, " + this.businessId + ", mode is " + this.cj.get());
      }
      parama.onCheckOfflineFinish(this.cj.get());
    }
    do
    {
      return;
      if ((parama != null) && (!this.callbacks.contains(parama))) {
        this.callbacks.add(parama);
      }
      parama = new SwiftBrowserOfflineHandler.1(this, paramString);
    } while (!this.state.compareAndSet(1, 2));
    if (QLog.isColorLevel()) {
      QLog.i("SwiftBrowserOfflineHandler", 2, "post thread to check offline, bid = " + this.businessId);
    }
    ThreadManager.postImmediately(parama, new arbn(this), false);
  }
  
  public void egY()
  {
    this.state.compareAndSet(2, 3);
    new Handler(Looper.getMainLooper()).post(new SwiftBrowserOfflineHandler.3(this));
  }
  
  public void egZ()
  {
    Object localObject1;
    Object localObject2;
    String str2;
    String str1;
    int i;
    int j;
    if (ck.compareAndSet(1, 2))
    {
      localObject1 = this.authConfig.H("ex_offline", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(",");
        localObject2 = Build.BRAND;
        str2 = Build.MODEL;
        str1 = Build.VERSION.RELEASE;
        localObject2 = new StringBuffer((String)localObject2);
        ((StringBuffer)localObject2).append(" ").append(str2);
        str2 = ((StringBuffer)localObject2).toString().toLowerCase();
        str1 = (" " + str1).toLowerCase();
        i = 0;
        j = localObject1.length;
      }
    }
    else
    {
      while (i < j)
      {
        localObject2 = localObject1[i].toLowerCase();
        if ((((String)localObject2).contains(str2)) && (str1.startsWith((String)localObject2)))
        {
          QLog.e("SwiftBrowserOfflineHandler", 1, "*****offline can not use!!! " + str1);
          ck.compareAndSet(2, 4);
          return;
        }
        i += 1;
      }
    }
    ck.compareAndSet(2, 3);
  }
  
  public boolean isReady()
  {
    return this.state.get() == 3;
  }
  
  public void reset()
  {
    QLog.w("SwiftBrowserOfflineHandler", 1, "now reset bid cache! " + this.businessId);
    this.cj.set(0);
    this.state.set(1);
  }
  
  public static abstract interface a
  {
    public abstract void onCheckOfflineFinish(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arbl
 * JD-Core Version:    0.7.0.1
 */