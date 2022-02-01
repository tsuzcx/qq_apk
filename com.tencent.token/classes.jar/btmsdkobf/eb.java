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
    if (nZ == null) {
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
      }
    }
    return nZ;
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
    //   8: ifne +72 -> 80
    //   11: aload_1
    //   12: ldc 64
    //   14: invokevirtual 70	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 72	android/net/ConnectivityManager
    //   20: invokevirtual 76	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +16 -> 41
    //   28: aload_3
    //   29: invokevirtual 82	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   32: astore_3
    //   33: aload_0
    //   34: aload_3
    //   35: putfield 40	btmsdkobf/eb:nX	Landroid/net/NetworkInfo$State;
    //   38: goto +10 -> 48
    //   41: getstatic 38	android/net/NetworkInfo$State:DISCONNECTED	Landroid/net/NetworkInfo$State;
    //   44: astore_3
    //   45: goto -12 -> 33
    //   48: new 84	android/content/IntentFilter
    //   51: dup
    //   52: invokespecial 85	android/content/IntentFilter:<init>	()V
    //   55: astore_3
    //   56: aload_3
    //   57: ldc 87
    //   59: invokevirtual 91	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   62: aload_3
    //   63: ldc 92
    //   65: invokevirtual 96	android/content/IntentFilter:setPriority	(I)V
    //   68: aload_1
    //   69: aload_0
    //   70: aload_3
    //   71: invokevirtual 100	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   74: pop
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 62	btmsdkobf/eb:gm	Z
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    //   88: astore_3
    //   89: goto -41 -> 48
    //   92: astore_1
    //   93: goto -13 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	eb
    //   0	96	1	paramContext	Context
    //   6	2	2	bool	boolean
    //   23	48	3	localObject	Object
    //   88	1	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	7	83	finally
    //   11	24	83	finally
    //   28	33	83	finally
    //   33	38	83	finally
    //   41	45	83	finally
    //   48	68	83	finally
    //   68	80	83	finally
    //   11	24	88	java/lang/Throwable
    //   28	33	88	java/lang/Throwable
    //   33	38	88	java/lang/Throwable
    //   41	45	88	java/lang/Throwable
    //   68	80	92	java/lang/Throwable
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
      NetworkInfo.State localState = ((NetworkInfo)paramIntent.getParcelable("networkInfo")).getState();
      ee localee;
      if (localState == NetworkInfo.State.CONNECTED) {
        if (this.nX.compareTo(NetworkInfo.State.DISCONNECTED) == 0)
        {
          localee = ee.cT();
          paramContext = new Runnable()
          {
            public void run()
            {
              synchronized (eb.a(eb.this))
              {
                LinkedList localLinkedList = (LinkedList)eb.a(eb.this).clone();
                if (localLinkedList != null)
                {
                  ??? = localLinkedList.iterator();
                  while (((Iterator)???).hasNext()) {
                    ((eb.a)((Iterator)???).next()).O();
                  }
                }
                return;
              }
            }
          };
        }
      }
      for (paramIntent = "monitor_toConnected";; paramIntent = "monitor_toDisconnected")
      {
        localee.addUrgentTask(paramContext, paramIntent);
        do
        {
          this.nX = localState;
          return;
          if (localState != NetworkInfo.State.DISCONNECTED) {
            break;
          }
        } while (this.nX.compareTo(NetworkInfo.State.CONNECTED) != 0);
        localee = ee.cT();
        paramContext = new Runnable()
        {
          public void run()
          {
            synchronized (eb.a(eb.this))
            {
              LinkedList localLinkedList = (LinkedList)eb.a(eb.this).clone();
              if (localLinkedList != null)
              {
                ??? = localLinkedList.iterator();
                while (((Iterator)???).hasNext()) {
                  ((eb.a)((Iterator)???).next()).P();
                }
              }
              return;
            }
          }
        };
      }
    }
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