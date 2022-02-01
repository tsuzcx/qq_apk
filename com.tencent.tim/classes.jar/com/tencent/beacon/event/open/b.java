package com.tencent.beacon.event.open;

import com.tencent.beacon.a.b.d;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.base.util.e;

class b
  implements Runnable
{
  b(BeaconReport paramBeaconReport) {}
  
  public void run()
  {
    try
    {
      BeaconReport.a(this.a);
      BeaconReport.b(this.a);
      BeaconReport.c(this.a);
      e.a(BeaconReport.d(this.a));
      c.a("BeaconReport", "App: %s start success!", new Object[] { BeaconReport.e(this.a) });
      return;
    }
    catch (Throwable localThrowable)
    {
      d.b().a("201", "sdk init error! msg:" + localThrowable.getMessage(), localThrowable);
      c.b("BeaconReport init error: " + localThrowable.getMessage(), new Object[0]);
      c.a(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.open.b
 * JD-Core Version:    0.7.0.1
 */