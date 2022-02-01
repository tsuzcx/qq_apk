package wf7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

class cs$1$1
  extends BroadcastReceiver
{
  cs$1$1(cs.1 param1) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = System.currentTimeMillis();
    if (paramIntent == null) {
      return;
    }
    bz.av().ax().post(new cs.1.1.1(this, paramIntent, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.cs.1.1
 * JD-Core Version:    0.7.0.1
 */