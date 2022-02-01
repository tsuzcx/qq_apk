package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tmsdk.base.TMSDKBaseContext;
import com.tmsdk.base.TMSDKBaseContext.IReportListener;
import com.tmsdk.base.utils.NetworkUtil;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Random;

public class bn
{
  static Object gh = new Object();
  static volatile long gi = -1L;
  static volatile boolean gj = false;
  static a gk = null;
  private static LinkedList<TMSDKBaseContext.IReportListener> gl = new LinkedList();
  
  static boolean J()
  {
    long l4 = System.currentTimeMillis();
    long l3 = ec.cS().getLong("rs_rt", -1L);
    if (l3 < 0L)
    {
      ec.cS().putLong("rs_rt", l4);
      return false;
    }
    if (l4 > l3)
    {
      if (l4 - l3 >= 86400000L) {
        return true;
      }
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      int i = K();
      long l2 = localCalendar.getTimeInMillis() + i * 1000L;
      long l1 = l2;
      if (l2 > l4) {
        l1 = l2 - 86400000L;
      }
      if (l3 <= l1) {
        return true;
      }
    }
    else if (Math.abs(l4 - l3) >= 86400000L)
    {
      return true;
    }
    return false;
  }
  
  static int K()
  {
    int j = ec.cS().getInt("rs_tt", -1);
    int i = j;
    if (j <= 0)
    {
      i = d(1, 20);
      ec.cS().putInt("rs_tt", i);
    }
    return i;
  }
  
  public static void L()
  {
    synchronized (gh)
    {
      eg.e("ReportService", "checkPullReport");
      if ((J()) && (NetworkUtil.isNetworkConnected()))
      {
        ee.cT().addTask(new Runnable()
        {
          public final void run()
          {
            if (System.currentTimeMillis() - bn.gi < 600000L) {
              return;
            }
            bn.gi = System.currentTimeMillis();
            be.w();
            bn.N();
            ec.cS().putLong("rs_rt", System.currentTimeMillis());
            bc.setAutoConnectionSwitch(bc.n(), true);
          }
        }, "xxx");
        return;
      }
      eg.e("ReportService", "checkPullReport, isNeedReport or isNetworkConnected [false]");
      return;
    }
  }
  
  public static void M()
  {
    if (gk == null)
    {
      a locala = new a();
      gk = locala;
      locala.a(bc.n());
    }
  }
  
  /* Error */
  public static void N()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 40	btmsdkobf/bn:gl	Ljava/util/LinkedList;
    //   6: astore_0
    //   7: aload_0
    //   8: monitorenter
    //   9: getstatic 40	btmsdkobf/bn:gl	Ljava/util/LinkedList;
    //   12: invokevirtual 156	java/util/LinkedList:clone	()Ljava/lang/Object;
    //   15: checkcast 37	java/util/LinkedList
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: ifnull +40 -> 62
    //   25: aload_1
    //   26: invokevirtual 160	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   29: astore_0
    //   30: aload_0
    //   31: invokeinterface 165 1 0
    //   36: ifeq +26 -> 62
    //   39: aload_0
    //   40: invokeinterface 168 1 0
    //   45: checkcast 170	com/tmsdk/base/TMSDKBaseContext$IReportListener
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull -20 -> 30
    //   53: aload_1
    //   54: invokeinterface 173 1 0
    //   59: goto -29 -> 30
    //   62: ldc 2
    //   64: monitorexit
    //   65: return
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    //   71: astore_0
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    //   77: ldc 2
    //   79: monitorexit
    //   80: return
    //   81: astore_0
    //   82: goto -5 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   71	5	0	localObject2	Object
    //   81	1	0	localThrowable	java.lang.Throwable
    //   18	36	1	localObject3	Object
    //   66	4	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   9	21	66	finally
    //   67	69	66	finally
    //   3	9	71	finally
    //   25	30	71	finally
    //   30	49	71	finally
    //   53	59	71	finally
    //   69	71	71	finally
    //   3	9	81	java/lang/Throwable
    //   25	30	81	java/lang/Throwable
    //   30	49	81	java/lang/Throwable
    //   53	59	81	java/lang/Throwable
    //   69	71	81	java/lang/Throwable
  }
  
  public static void addReportListener(TMSDKBaseContext.IReportListener paramIReportListener)
  {
    synchronized (gl)
    {
      gl.add(paramIReportListener);
      return;
    }
  }
  
  static int d(int paramInt1, int paramInt2)
  {
    paramInt2 -= paramInt1;
    if (paramInt2 < 0) {
      return -1;
    }
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis() + System.identityHashCode(localRandom));
    double d1 = localRandom.nextDouble();
    double d2 = paramInt2;
    Double.isNaN(d2);
    return ((int)(d1 * d2) + paramInt1) * 3600 + (int)(localRandom.nextDouble() * 60.0D) * 60 + (int)(localRandom.nextDouble() * 60.0D);
  }
  
  public static void removeReportListener(TMSDKBaseContext.IReportListener paramIReportListener)
  {
    synchronized (gl)
    {
      gl.remove(paramIReportListener);
      return;
    }
  }
  
  static final class a
    extends BroadcastReceiver
    implements eb.a
  {
    public static boolean a = false;
    
    public final void O()
    {
      if (bc.m())
      {
        bn.L();
        if (NetworkUtil.isWifiConnected())
        {
          TMSDKBaseContext.aroundWifiReport();
          TMSDKBaseContext.wifiConnectRetReport();
        }
      }
    }
    
    public final void P() {}
    
    public final void a(Context paramContext)
    {
      try
      {
        if (!a)
        {
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("android.intent.action.USER_PRESENT");
          localIntentFilter.setPriority(2147483647);
          paramContext.registerReceiver(this, localIntentFilter);
          paramContext = eb.k(paramContext);
          if (paramContext != null) {
            paramContext.a(this);
          }
          a = true;
        }
        return;
      }
      finally {}
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {
        return;
      }
      int i;
      if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction())) {
        i = 3;
      } else {
        i = -1;
      }
      if ((i != -1) && (bc.m())) {
        bn.L();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bn
 * JD-Core Version:    0.7.0.1
 */