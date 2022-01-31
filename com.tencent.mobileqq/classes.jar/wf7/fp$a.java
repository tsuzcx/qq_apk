package wf7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class fp$a
  extends BroadcastReceiver
{
  private fp$a(fp paramfp) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.location.PROVIDERS_CHANGED".equals(paramIntent.getAction()))
    {
      if (dj.g(gv.dE())) {
        fp.g(this.ra);
      }
    }
    else {
      return;
    }
    fp.h(this.ra);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.fp.a
 * JD-Core Version:    0.7.0.1
 */