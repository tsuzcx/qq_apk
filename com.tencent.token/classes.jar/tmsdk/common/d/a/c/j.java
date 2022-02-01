package tmsdk.common.d.a.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.token.ara;
import com.tencent.token.arb;
import com.tencent.token.ke;
import com.tencent.token.kf;
import java.util.LinkedList;

public class j
  extends BroadcastReceiver
{
  private static j d = new j();
  public LinkedList a = new LinkedList();
  private boolean b;
  private NetworkInfo.State c = NetworkInfo.State.UNKNOWN;
  
  public static j a()
  {
    return d;
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      if (!this.b)
      {
        this.b = true;
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
  
  public final void b(Context paramContext)
  {
    try
    {
      if (this.b)
      {
        paramContext.unregisterReceiver(this);
        this.b = false;
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
      if (paramContext == NetworkInfo.State.CONNECTED)
      {
        if (this.c.compareTo(NetworkInfo.State.DISCONNECTED) == 0)
        {
          ke.a();
          kf.a(new ara(this), "无网络 -> 有网络");
        }
        this.c = paramContext;
        return;
      }
      if (paramContext == NetworkInfo.State.DISCONNECTED)
      {
        if (this.c.compareTo(NetworkInfo.State.CONNECTED) == 0)
        {
          ke.a();
          kf.a(new arb(this), "有网络 -> 无网络");
        }
        this.c = paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.c.j
 * JD-Core Version:    0.7.0.1
 */