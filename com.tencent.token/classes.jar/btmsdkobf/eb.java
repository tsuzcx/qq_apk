package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
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
          eb localeb = new eb();
          nZ = localeb;
          localeb.l(paramContext);
        }
      }
    }
    return nZ;
  }
  
  private void l(Context paramContext)
  {
    m(paramContext);
  }
  
  private void m(Context paramContext)
  {
    label33:
    label48:
    label83:
    try
    {
      boolean bool = this.gm;
      if (bool) {}
    }
    finally {}
    try
    {
      localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject != null)
      {
        localObject = ((NetworkInfo)localObject).getState();
        this.nX = ((NetworkInfo.State)localObject);
      }
      else
      {
        localObject = NetworkInfo.State.DISCONNECTED;
        break label33;
      }
    }
    catch (Throwable localThrowable)
    {
      break label48;
    }
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    ((IntentFilter)localObject).setPriority(2147483647);
    try
    {
      paramContext.registerReceiver(this, (IntentFilter)localObject);
      this.gm = true;
      return;
    }
    catch (Throwable paramContext)
    {
      break label83;
    }
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
      if (paramContext == NetworkInfo.State.CONNECTED)
      {
        if (this.nX.compareTo(NetworkInfo.State.DISCONNECTED) == 0) {
          ee.cT().addUrgentTask(new Runnable()
          {
            public final void run()
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
          }, "monitor_toConnected");
        }
        this.nX = paramContext;
        return;
      }
      if (paramContext == NetworkInfo.State.DISCONNECTED)
      {
        if (this.nX.compareTo(NetworkInfo.State.CONNECTED) == 0) {
          ee.cT().addUrgentTask(new Runnable()
          {
            public final void run()
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
          }, "monitor_toDisconnected");
        }
        this.nX = paramContext;
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