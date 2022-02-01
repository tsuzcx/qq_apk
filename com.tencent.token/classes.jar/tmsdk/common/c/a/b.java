package tmsdk.common.c.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.token.aoy;

public final class b
  extends BroadcastReceiver
{
  public String a = null;
  public Runnable b = null;
  
  public b(aoy paramaoy) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
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
      aoy.a(this.c).post(this.b);
      this.c.a(paramContext);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.c.a.b
 * JD-Core Version:    0.7.0.1
 */