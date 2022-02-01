package wf7;

import android.content.Context;
import android.content.IntentFilter;

class cs$1
  implements Runnable
{
  cs$1(cs paramcs) {}
  
  public void run()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.setPriority(2147483647);
    cs.a(this.ic, new cs.1.1(this));
    try
    {
      bz.av().t().registerReceiver(cs.a(this.ic), localIntentFilter);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.cs.1
 * JD-Core Version:    0.7.0.1
 */