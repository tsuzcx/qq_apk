package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Handler;
import java.util.LinkedList;

public class cz
  extends BroadcastReceiver
{
  private static Object kg = new Object();
  private static cz ki = null;
  private long jZ = 0L;
  private boolean ka = false;
  private NetworkInfo.State kb = NetworkInfo.State.UNKNOWN;
  private String kc = null;
  private String kd = null;
  private LinkedList ke = new LinkedList();
  private LinkedList kf = new LinkedList();
  private Object kh = new Object();
  private Handler mHandler = new gn(this, cx.getLooper());
  
  private void a(Intent paramIntent)
  {
    synchronized (this.kh)
    {
      if ((this.jZ > 0L) && (System.currentTimeMillis() - this.jZ <= 2000L))
      {
        eh.e("SharkNetworkReceiver", "[conn_monitor]doOnRecv(), ignore for just register: " + (System.currentTimeMillis() - this.jZ));
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null) {}
      }
      else
      {
        cr.bq().br();
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 5000L);
      }
    }
    Object localObject2 = (NetworkInfo)paramIntent.getParcelable("networkInfo");
    if (localObject2 == null) {
      return;
    }
    paramIntent = ((NetworkInfo)localObject2).getState();
    String str = ((NetworkInfo)localObject2).getTypeName();
    localObject2 = ((NetworkInfo)localObject2).getSubtypeName();
    eh.f("SharkNetworkReceiver", "[conn_monitor]doOnRecv(), Sate: " + this.kb + " -> " + paramIntent);
    eh.f("SharkNetworkReceiver", "[conn_monitor]doOnRecv(), type: " + this.kc + " -> " + str);
    eh.f("SharkNetworkReceiver", "[conn_monitor]doOnRecv(), subType: " + this.kd + " -> " + (String)localObject2);
    if (paramIntent == NetworkInfo.State.CONNECTED) {
      if (this.kb != NetworkInfo.State.CONNECTED) {
        bU();
      }
    }
    for (;;)
    {
      this.kb = paramIntent;
      this.kc = str;
      this.kd = ((String)localObject2);
      return;
      if ((paramIntent == NetworkInfo.State.DISCONNECTED) && (this.kb != NetworkInfo.State.DISCONNECTED)) {
        bT();
      }
    }
  }
  
  public static cz bS()
  {
    if (ki == null) {}
    synchronized (kg)
    {
      if (ki == null) {
        ki = new cz();
      }
      ki.bV();
      return ki;
    }
  }
  
  private void bT()
  {
    ee.cT().addUrgentTask(new gp(this), "network_disconnected");
  }
  
  private void bU()
  {
    ee.cT().addUrgentTask(new gq(this), "network_connected");
  }
  
  private void bV()
  {
    try
    {
      Context localContext = bc.n();
      if (localContext != null) {
        h(localContext);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      eh.h("SharkNetworkReceiver", "[conn_monitor]checkInit(), registerConnectivityIfNeed() failed: " + localThrowable);
    }
  }
  
  private void bc()
  {
    ee.cT().addUrgentTask(new go(this), "network_change");
  }
  
  /* Error */
  private void h(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	btmsdkobf/cz:ka	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +110 -> 118
    //   11: invokestatic 246	com/tmsdk/base/utils/NetworkUtil:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull +105 -> 121
    //   19: aload_0
    //   20: aload_3
    //   21: invokevirtual 148	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   24: putfield 47	btmsdkobf/cz:kb	Landroid/net/NetworkInfo$State;
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 151	android/net/NetworkInfo:getTypeName	()Ljava/lang/String;
    //   32: putfield 49	btmsdkobf/cz:kc	Ljava/lang/String;
    //   35: aload_0
    //   36: aload_3
    //   37: invokevirtual 154	android/net/NetworkInfo:getSubtypeName	()Ljava/lang/String;
    //   40: putfield 51	btmsdkobf/cz:kd	Ljava/lang/String;
    //   43: ldc 85
    //   45: new 87	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   52: ldc 248
    //   54: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_0
    //   58: getfield 47	btmsdkobf/cz:kb	Landroid/net/NetworkInfo$State;
    //   61: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 107	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: new 250	android/content/IntentFilter
    //   73: dup
    //   74: invokespecial 251	android/content/IntentFilter:<init>	()V
    //   77: astore_3
    //   78: aload_3
    //   79: ldc 253
    //   81: invokevirtual 257	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   84: aload_3
    //   85: ldc_w 258
    //   88: invokevirtual 261	android/content/IntentFilter:setPriority	(I)V
    //   91: aload_1
    //   92: aload_0
    //   93: aload_3
    //   94: invokevirtual 267	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   97: pop
    //   98: aload_0
    //   99: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   102: putfield 38	btmsdkobf/cz:jZ	J
    //   105: aload_0
    //   106: iconst_1
    //   107: putfield 40	btmsdkobf/cz:ka	Z
    //   110: ldc 85
    //   112: ldc_w 269
    //   115: invokestatic 164	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_0
    //   119: monitorexit
    //   120: return
    //   121: aload_0
    //   122: getstatic 177	android/net/NetworkInfo$State:DISCONNECTED	Landroid/net/NetworkInfo$State;
    //   125: putfield 47	btmsdkobf/cz:kb	Landroid/net/NetworkInfo$State;
    //   128: ldc 85
    //   130: new 87	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 271
    //   140: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: getfield 47	btmsdkobf/cz:kb	Landroid/net/NetworkInfo$State;
    //   147: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 107	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto -86 -> 70
    //   159: astore_3
    //   160: ldc 85
    //   162: new 87	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 273
    //   172: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_3
    //   176: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 232	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: goto -115 -> 70
    //   188: astore_1
    //   189: aload_0
    //   190: monitorexit
    //   191: aload_1
    //   192: athrow
    //   193: astore_1
    //   194: ldc 85
    //   196: new 87	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 275
    //   206: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_1
    //   210: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 232	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: goto -101 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	cz
    //   0	222	1	paramContext	Context
    //   6	2	2	bool	boolean
    //   14	80	3	localObject	Object
    //   159	17	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   11	15	159	java/lang/Exception
    //   19	70	159	java/lang/Exception
    //   121	156	159	java/lang/Exception
    //   2	7	188	finally
    //   11	15	188	finally
    //   19	70	188	finally
    //   70	118	188	finally
    //   121	156	188	finally
    //   160	185	188	finally
    //   194	219	188	finally
    //   70	118	193	java/lang/Throwable
  }
  
  public void a(cz.a parama)
  {
    if (parama == null) {
      return;
    }
    synchronized (this.ke)
    {
      if (!this.ke.contains(parama)) {
        this.ke.add(parama);
      }
      return;
    }
  }
  
  public void a(cz.b paramb)
  {
    if (paramb == null) {
      return;
    }
    synchronized (this.kf)
    {
      if (!this.kf.contains(paramb)) {
        this.kf.add(paramb);
      }
      return;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
      eh.e("SharkNetworkReceiver", "[conn_monitor]doOnRecv(), action: " + paramContext);
    } while (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext));
    this.mHandler.post(new gr(this, paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cz
 * JD-Core Version:    0.7.0.1
 */