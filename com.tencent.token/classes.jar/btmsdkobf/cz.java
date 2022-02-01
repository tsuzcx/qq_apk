package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tmsdk.base.utils.NetworkUtil;
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
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what != 1) {
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
        localObject2 = new StringBuilder("[conn_monitor]doOnRecv(), ignore for just register: ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - this.jZ);
        eh.e("SharkNetworkReceiver", ((StringBuilder)localObject2).toString());
      }
      else
      {
        cr.bq().br();
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 5000L);
      }
      paramIntent = paramIntent.getExtras();
      if (paramIntent == null) {
        return;
      }
      Object localObject3 = (NetworkInfo)paramIntent.getParcelable("networkInfo");
      if (localObject3 == null) {
        return;
      }
      paramIntent = ((NetworkInfo)localObject3).getState();
      Object localObject2 = ((NetworkInfo)localObject3).getTypeName();
      localObject3 = ((NetworkInfo)localObject3).getSubtypeName();
      StringBuilder localStringBuilder = new StringBuilder("[conn_monitor]doOnRecv(), Sate: ");
      localStringBuilder.append(this.kb);
      localStringBuilder.append(" -> ");
      localStringBuilder.append(paramIntent);
      eh.f("SharkNetworkReceiver", localStringBuilder.toString());
      localStringBuilder = new StringBuilder("[conn_monitor]doOnRecv(), type: ");
      localStringBuilder.append(this.kc);
      localStringBuilder.append(" -> ");
      localStringBuilder.append((String)localObject2);
      eh.f("SharkNetworkReceiver", localStringBuilder.toString());
      localStringBuilder = new StringBuilder("[conn_monitor]doOnRecv(), subType: ");
      localStringBuilder.append(this.kd);
      localStringBuilder.append(" -> ");
      localStringBuilder.append((String)localObject3);
      eh.f("SharkNetworkReceiver", localStringBuilder.toString());
      if (paramIntent == NetworkInfo.State.CONNECTED)
      {
        if (this.kb != NetworkInfo.State.CONNECTED) {
          bU();
        }
      }
      else if ((paramIntent == NetworkInfo.State.DISCONNECTED) && (this.kb != NetworkInfo.State.DISCONNECTED)) {
        bT();
      }
      this.kb = paramIntent;
      this.kc = ((String)localObject2);
      this.kd = ((String)localObject3);
      return;
    }
  }
  
  public static cz bS()
  {
    if (ki == null) {
      synchronized (kg)
      {
        if (ki == null) {
          ki = new cz();
        }
      }
    }
    ki.bV();
    return ki;
  }
  
  private void bT()
  {
    ee.cT().addUrgentTask(new Runnable()
    {
      public final void run()
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
          return;
        }
      }
    }, "network_disconnected");
  }
  
  private void bU()
  {
    ee.cT().addUrgentTask(new Runnable()
    {
      public final void run()
      {
        eh.e("SharkNetworkReceiver", "[conn_monitor]handleChange2Connected(), 无网络 -> 有网络");
        ??? = cg.bb();
        Object localObject2 = new StringBuilder("[conn_monitor][ip_list]handleChange2Connected(), notify hiplist first: ");
        boolean bool;
        if (??? != null) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject2).append(bool);
        eh.e("SharkNetworkReceiver", ((StringBuilder)localObject2).toString());
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
            if (localObject2 != null) {
              ((cz.a)localObject2).onConnected();
            }
          }
          return;
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
      eh.h("SharkNetworkReceiver", "[conn_monitor]checkInit(), registerConnectivityIfNeed() failed: ".concat(String.valueOf(localThrowable)));
    }
  }
  
  private void bc()
  {
    ee.cT().addUrgentTask(new Runnable()
    {
      public final void run()
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
          return;
        }
      }
    }, "network_change");
  }
  
  private void h(Context paramContext)
  {
    try
    {
      boolean bool = this.ka;
      if (!bool) {
        try
        {
          Object localObject = NetworkUtil.getActiveNetworkInfo();
          if (localObject != null)
          {
            this.kb = ((NetworkInfo)localObject).getState();
            this.kc = ((NetworkInfo)localObject).getTypeName();
            this.kd = ((NetworkInfo)localObject).getSubtypeName();
            localObject = new StringBuilder("[conn_monitor]registerConnectivRityIfNeed(), got mLastState: ");
            ((StringBuilder)localObject).append(this.kb);
          }
          for (localObject = ((StringBuilder)localObject).toString();; localObject = ((StringBuilder)localObject).toString())
          {
            eh.e("SharkNetworkReceiver", (String)localObject);
            break;
            this.kb = NetworkInfo.State.DISCONNECTED;
            localObject = new StringBuilder("[conn_monitor]registerConnectivRityIfNeed(), not got, set mLastState: ");
            ((StringBuilder)localObject).append(this.kb);
          }
        }
        catch (Exception localException)
        {
          eh.h("SharkNetworkReceiver", "[conn_monitor]getActiveNetworkInfo() failed: ".concat(String.valueOf(localException)));
          try
          {
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            localIntentFilter.setPriority(2147483647);
            paramContext.registerReceiver(this, localIntentFilter);
            this.jZ = System.currentTimeMillis();
            this.ka = true;
            eh.f("SharkNetworkReceiver", "[conn_monitor]registerConnectivityIfNeed() succ");
            return;
          }
          catch (Throwable paramContext)
          {
            eh.h("SharkNetworkReceiver", "[conn_monitor]registerConnectivityIfNeed() failed: ".concat(String.valueOf(paramContext)));
          }
        }
      }
      return;
    }
    finally {}
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
    if (paramIntent != null)
    {
      if (paramIntent.getAction() == null) {
        return;
      }
      paramContext = paramIntent.getAction();
      eh.e("SharkNetworkReceiver", "[conn_monitor]doOnRecv(), action: ".concat(String.valueOf(paramContext)));
      if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext)) {
        this.mHandler.post(new Runnable()
        {
          public final void run()
          {
            if (bc.m()) {
              cz.a(cz.this, paramIntent);
            }
          }
        });
      }
    }
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