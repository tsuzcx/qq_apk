package com.tencent.beacon.event;

import com.tencent.beacon.base.util.c;
import com.tencent.beacon.event.immediate.BeaconImmediateReportCallback;
import com.tencent.beacon.event.immediate.IBeaconImmediateReport;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.pack.AbstractJceStruct;
import com.tencent.beacon.pack.RequestPackageV2;

class b
  implements Runnable
{
  b(d paramd, EventBean paramEventBean, String paramString) {}
  
  public void run()
  {
    try
    {
      RequestPackageV2 localRequestPackageV2 = com.tencent.beacon.event.c.d.a(this.a);
      BeaconReport.getInstance().getImmediateReport().reportImmediate(d.a(this.c, localRequestPackageV2.toByteArray(), this.a.getEventType()), new BeaconImmediateReportCallback(this.c, this.a, this.b));
      return;
    }
    catch (Throwable localThrowable)
    {
      c.b("[immediate] report error!", new Object[0]);
      c.a(localThrowable);
      this.c.a(this.a, this.b);
      com.tencent.beacon.a.b.d.b().a("515", "immediate report error!", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.b
 * JD-Core Version:    0.7.0.1
 */