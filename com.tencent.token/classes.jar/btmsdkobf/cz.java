package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
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
  private LinkedList<a> ke = new LinkedList();
  private LinkedList<b> kf = new LinkedList();
  private Object kh = new Object();
  private Handler mHandler = new Handler(cx.getLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      cz.a(cz.this);
    }
  };
  
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
    ee.cT().addUrgentTask(new Runnable()
    {
      public void run()
      {
        eh.e("SharkNetworkReceiver", "[conn_monitor]handleChange2DisConnected(), 有网络 -> 无网络");
        synchronized (cz.c(cz.this))
        {
          Object localObject2 = (LinkedList)cz.c(cz.this).clone();
          ??? = ((LinkedList)localObject2).iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (cz.a)((Iterator)???).next();
            if (localObject2 != null) {
              ((cz.a)localObject2).onDisconnected();
            }
          }
        }
      }
    }, "network_disconnected");
  }
  
  private void bU()
  {
    ee.cT().addUrgentTask(new Runnable()
    {
      public void run()
      {
        eh.e("SharkNetworkReceiver", "[conn_monitor]handleChange2Connected(), 无网络 -> 有网络");
        ??? = cg.bb();
        Object localObject2 = new StringBuilder().append("[conn_monitor][ip_list]handleChange2Connected(), notify hiplist first: ");
        boolean bool;
        if (??? != null) {
          bool = true;
        }
        for (;;)
        {
          eh.e("SharkNetworkReceiver", bool);
          if (??? != null) {
            ((cg)???).bc();
          }
          synchronized (cz.c(cz.this))
          {
            localObject2 = (LinkedList)cz.c(cz.this).clone();
            ??? = ((LinkedList)localObject2).iterator();
            while (((Iterator)???).hasNext())
            {
              localObject2 = (cz.a)((Iterator)???).next();
              if (localObject2 != null)
              {
                ((cz.a)localObject2).onConnected();
                continue;
                bool = false;
              }
            }
          }
        }
      }
    }, "network_connected");
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
    ee.cT().addUrgentTask(new Runnable()
    {
      public void run()
      {
        eh.e("SharkNetworkReceiver", "[conn_monitor]handleNetworkChange()");
        synchronized (cz.b(cz.this))
        {
          Object localObject2 = (LinkedList)cz.b(cz.this).clone();
          ??? = ((LinkedList)localObject2).iterator();
          while (((Iterator)???).hasNext())
          {
            localObject2 = (cz.b)((Iterator)???).next();
            if (localObject2 != null) {
              ((cz.b)localObject2).bz();
            }
          }
        }
      }
    }, "network_change");
  }
  
  /* Error */
  private void h(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	btmsdkobf/cz:ka	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +112 -> 120
    //   11: invokestatic 254	com/tmsdk/base/utils/NetworkUtil:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnull +107 -> 123
    //   19: aload_0
    //   20: aload_3
    //   21: invokevirtual 163	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   24: putfield 65	btmsdkobf/cz:kb	Landroid/net/NetworkInfo$State;
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 166	android/net/NetworkInfo:getTypeName	()Ljava/lang/String;
    //   32: putfield 67	btmsdkobf/cz:kc	Ljava/lang/String;
    //   35: aload_0
    //   36: aload_3
    //   37: invokevirtual 169	android/net/NetworkInfo:getSubtypeName	()Ljava/lang/String;
    //   40: putfield 69	btmsdkobf/cz:kd	Ljava/lang/String;
    //   43: ldc 100
    //   45: new 102	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 256
    //   55: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 65	btmsdkobf/cz:kb	Landroid/net/NetworkInfo$State;
    //   62: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 122	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: new 258	android/content/IntentFilter
    //   74: dup
    //   75: invokespecial 259	android/content/IntentFilter:<init>	()V
    //   78: astore_3
    //   79: aload_3
    //   80: ldc_w 261
    //   83: invokevirtual 265	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   86: aload_3
    //   87: ldc_w 266
    //   90: invokevirtual 269	android/content/IntentFilter:setPriority	(I)V
    //   93: aload_1
    //   94: aload_0
    //   95: aload_3
    //   96: invokevirtual 275	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   99: pop
    //   100: aload_0
    //   101: invokestatic 96	java/lang/System:currentTimeMillis	()J
    //   104: putfield 56	btmsdkobf/cz:jZ	J
    //   107: aload_0
    //   108: iconst_1
    //   109: putfield 58	btmsdkobf/cz:ka	Z
    //   112: ldc 100
    //   114: ldc_w 277
    //   117: invokestatic 179	btmsdkobf/eh:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: monitorexit
    //   122: return
    //   123: aload_0
    //   124: getstatic 192	android/net/NetworkInfo$State:DISCONNECTED	Landroid/net/NetworkInfo$State;
    //   127: putfield 65	btmsdkobf/cz:kb	Landroid/net/NetworkInfo$State;
    //   130: ldc 100
    //   132: new 102	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 279
    //   142: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_0
    //   146: getfield 65	btmsdkobf/cz:kb	Landroid/net/NetworkInfo$State;
    //   149: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 122	btmsdkobf/eh:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: goto -87 -> 71
    //   161: astore_3
    //   162: ldc 100
    //   164: new 102	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 281
    //   174: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_3
    //   178: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 242	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: goto -116 -> 71
    //   190: astore_1
    //   191: aload_0
    //   192: monitorexit
    //   193: aload_1
    //   194: athrow
    //   195: astore_1
    //   196: ldc 100
    //   198: new 102	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 283
    //   208: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_1
    //   212: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 242	btmsdkobf/eh:h	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: goto -101 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	cz
    //   0	224	1	paramContext	Context
    //   6	2	2	bool	boolean
    //   14	82	3	localObject	Object
    //   161	17	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   11	15	161	java/lang/Exception
    //   19	71	161	java/lang/Exception
    //   123	158	161	java/lang/Exception
    //   2	7	190	finally
    //   11	15	190	finally
    //   19	71	190	finally
    //   71	120	190	finally
    //   123	158	190	finally
    //   162	187	190	finally
    //   196	221	190	finally
    //   71	120	195	java/lang/Throwable
  }
  
  public void a(a parama)
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
  
  public void a(b paramb)
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
  
  public void onReceive(Context paramContext, final Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
      eh.e("SharkNetworkReceiver", "[conn_monitor]doOnRecv(), action: " + paramContext);
    } while (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext));
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (bc.m()) {
          cz.a(cz.this, paramIntent);
        }
      }
    });
  }
  
  public static abstract interface a
  {
    public abstract void onConnected();
    
    public abstract void onDisconnected();
  }
  
  public static abstract interface b
  {
    public abstract void bz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cz
 * JD-Core Version:    0.7.0.1
 */