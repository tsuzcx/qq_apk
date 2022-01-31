package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class im
  extends BroadcastReceiver
{
  public String a = null;
  public Runnable b = null;
  
  im(dv paramdv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      return;
      eg.f("cccccc", "action:" + paramContext);
    } while ((!this.a.equals(paramContext)) || (this.b == null));
    ee.cT().addTask(new in(this, paramContext), "AlarmerTaskReceiver");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.im
 * JD-Core Version:    0.7.0.1
 */