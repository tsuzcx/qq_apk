package tmsdk.common.d.a.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.token.f;
import com.tencent.token.g;
import java.util.LinkedList;

public class j
  extends BroadcastReceiver
{
  private static j d = new j();
  private boolean a;
  private NetworkInfo.State b = NetworkInfo.State.UNKNOWN;
  private LinkedList c = new LinkedList();
  
  public static j a()
  {
    return d;
  }
  
  public void a(Context paramContext)
  {
    try
    {
      if (!this.a)
      {
        this.a = true;
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        localIntentFilter.setPriority(2147483647);
        paramContext.registerReceiver(this, localIntentFilter);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void a(m paramm)
  {
    synchronized (this.c)
    {
      new StringBuilder().append("添加网络监听 : ").append(paramm.getClass().getName()).toString();
      this.c.add(paramm);
      return;
    }
  }
  
  public void b(Context paramContext)
  {
    try
    {
      if (this.a)
      {
        paramContext.unregisterReceiver(this);
        this.a = false;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
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
      if (this.b.compareTo(NetworkInfo.State.DISCONNECTED) == 0) {
        f.a().a(new k(this), "无网络 -> 有网络");
      }
      this.b = paramContext;
    }
    label74:
    while (paramContext != NetworkInfo.State.DISCONNECTED) {
      return;
    }
    if (this.b.compareTo(NetworkInfo.State.CONNECTED) == 0) {
      f.a().a(new l(this), "有网络 -> 无网络");
    }
    this.b = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.j
 * JD-Core Version:    0.7.0.1
 */