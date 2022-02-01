package tmsdk.common.c.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

class b
  extends BroadcastReceiver
{
  public String a = null;
  public Runnable b = null;
  
  b(a parama) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    if (this.a.equals(paramContext))
    {
      if (this.b == null) {
        return;
      }
      a.a(this.c).post(this.b);
      this.c.a(paramContext);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.c.a.b
 * JD-Core Version:    0.7.0.1
 */