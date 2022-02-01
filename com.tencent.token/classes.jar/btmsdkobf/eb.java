package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedList;

public class eb
  extends BroadcastReceiver
{
  private static Object lock = new Object();
  private static eb nZ;
  private boolean gm;
  private NetworkInfo.State nX = NetworkInfo.State.DISCONNECTED;
  private LinkedList<a> nY = new LinkedList();
  
  public static eb k(Context paramContext)
  {
    if (nZ == null) {}
    synchronized (lock)
    {
      if (nZ == null)
      {
        if (paramContext == null) {
          return null;
        }
        nZ = new eb();
        nZ.l(paramContext);
      }
      return nZ;
    }
  }
  
  private void l(Context paramContext)
  {
    m(paramContext);
  }
  
  /* Error */
  private void m(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	btmsdkobf/eb:gm	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +60 -> 68
    //   11: aload_1
    //   12: ldc 64
    //   14: invokevirtual 70	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 72	android/net/ConnectivityManager
    //   20: invokevirtual 76	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +46 -> 71
    //   28: aload_0
    //   29: aload_3
    //   30: invokevirtual 82	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   33: putfield 40	btmsdkobf/eb:nX	Landroid/net/NetworkInfo$State;
    //   36: new 84	android/content/IntentFilter
    //   39: dup
    //   40: invokespecial 85	android/content/IntentFilter:<init>	()V
    //   43: astore_3
    //   44: aload_3
    //   45: ldc 87
    //   47: invokevirtual 91	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   50: aload_3
    //   51: ldc 92
    //   53: invokevirtual 96	android/content/IntentFilter:setPriority	(I)V
    //   56: aload_1
    //   57: aload_0
    //   58: aload_3
    //   59: invokevirtual 100	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   62: pop
    //   63: aload_0
    //   64: iconst_1
    //   65: putfield 62	btmsdkobf/eb:gm	Z
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: aload_0
    //   72: getstatic 38	android/net/NetworkInfo$State:DISCONNECTED	Landroid/net/NetworkInfo$State;
    //   75: putfield 40	btmsdkobf/eb:nX	Landroid/net/NetworkInfo$State;
    //   78: goto -42 -> 36
    //   81: astore_3
    //   82: goto -46 -> 36
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    //   90: astore_1
    //   91: goto -23 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	eb
    //   0	94	1	paramContext	Context
    //   6	2	2	bool	boolean
    //   23	36	3	localObject	Object
    //   81	1	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   11	24	81	java/lang/Throwable
    //   28	36	81	java/lang/Throwable
    //   71	78	81	java/lang/Throwable
    //   2	7	85	finally
    //   11	24	85	finally
    //   28	36	85	finally
    //   36	56	85	finally
    //   56	68	85	finally
    //   71	78	85	finally
    //   56	68	90	java/lang/Throwable
  }
  
  public void a(a parama)
  {
    synchronized (this.nY)
    {
      this.nY.add(parama);
      return;
    }
  }
  
  public void b(a parama)
  {
    synchronized (this.nY)
    {
      this.nY.remove(parama);
      return;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getExtras();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      paramContext = ((NetworkInfo)paramIntent.getParcelable("networkInfo")).getState();
      if (paramContext != NetworkInfo.State.CONNECTED) {
        break label74;
      }
      if (this.nX.compareTo(NetworkInfo.State.DISCONNECTED) == 0) {
        ee.cT().addUrgentTask(new Runnable()
        {
          public void run()
          {
            synchronized (eb.a(eb.this))
            {
              LinkedList localLinkedList = (LinkedList)eb.a(eb.this).clone();
              if (localLinkedList != null)
              {
                ??? = localLinkedList.iterator();
                if (((Iterator)???).hasNext()) {
                  ((eb.a)((Iterator)???).next()).O();
                }
              }
            }
          }
        }, "monitor_toConnected");
      }
      this.nX = paramContext;
    }
    label74:
    while (paramContext != NetworkInfo.State.DISCONNECTED) {
      return;
    }
    if (this.nX.compareTo(NetworkInfo.State.CONNECTED) == 0) {
      ee.cT().addUrgentTask(new Runnable()
      {
        public void run()
        {
          synchronized (eb.a(eb.this))
          {
            LinkedList localLinkedList = (LinkedList)eb.a(eb.this).clone();
            if (localLinkedList != null)
            {
              ??? = localLinkedList.iterator();
              if (((Iterator)???).hasNext()) {
                ((eb.a)((Iterator)???).next()).P();
              }
            }
          }
        }
      }, "monitor_toDisconnected");
    }
    this.nX = paramContext;
  }
  
  public static abstract interface a
  {
    public abstract void O();
    
    public abstract void P();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.eb
 * JD-Core Version:    0.7.0.1
 */