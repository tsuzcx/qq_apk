package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class bb
  extends BroadcastReceiver
{
  final ap a;
  boolean b;
  
  public bb(ap paramap)
  {
    this.a = paramap;
  }
  
  public final void a()
  {
    if (!this.b) {
      return;
    }
    this.b = false;
    try
    {
      this.a.a.unregisterReceiver(this);
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      if (paramIntent.getBooleanExtra("noConnectivity", false))
      {
        this.a.b(Integer.valueOf(-1));
        return;
      }
      if (cd.b(paramContext))
      {
        this.a.b(Integer.valueOf(1));
        return;
      }
      this.a.b(Integer.valueOf(0));
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.bb
 * JD-Core Version:    0.7.0.1
 */