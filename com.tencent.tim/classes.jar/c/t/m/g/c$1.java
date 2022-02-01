package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class c$1
  extends BroadcastReceiver
{
  c$1(c paramc) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = 0L;
    if ((paramIntent == null) || (!"android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))) {
      return;
    }
    for (;;)
    {
      try
      {
        boolean bool = paramIntent.getBooleanExtra("noConnectivity", false);
        if (ai.a()) {
          ai.a(3, "DC_Pro", "intent:" + paramIntent + ",", null);
        }
        if (bool) {
          break;
        }
        ai.a(c.a(this.a), 107, 2000L);
        if (c.b(this.a) == null) {
          break;
        }
        paramContext = c.b(this.a);
        if (2000L < 0L)
        {
          paramContext.a(1004, l);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        return;
      }
      l = 2000L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.c.1
 * JD-Core Version:    0.7.0.1
 */