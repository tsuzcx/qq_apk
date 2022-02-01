package com.tencent.beacon.module;

import android.os.Build;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconEvent.Builder;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventType;

class StatModule$1
  implements Runnable
{
  StatModule$1(StatModule paramStatModule) {}
  
  public void run()
  {
    e locale = e.l();
    f localf = f.e();
    BeaconEvent.Builder localBuilder = BeaconEvent.builder().withParams("A9", Build.BRAND).withParams("A10", localf.h()).withParams("A11", locale.g()).withParams("A12", locale.n()).withParams("A13", locale.z()).withParams("A14", locale.w() + "m").withParams("A15", locale.t() + "m").withParams("A16", locale.h()).withParams("A17", locale.u()).withParams("A18", "").withParams("A20", localf.j()).withParams("A30", locale.x() + "m").withParams("A19", locale.q()).withParams("A52", "" + locale.y()).withParams("A53", "" + locale.e() + "m").withParams("A54", "" + locale.r()).withParams("A55", locale.f());
    if (locale.D())
    {
      localObject = "Y";
      localBuilder = localBuilder.withParams("A56", (String)localObject).withParams("A57", locale.A());
      if (!locale.m()) {
        break label398;
      }
    }
    label398:
    for (Object localObject = "Y";; localObject = "N")
    {
      localObject = localBuilder.withParams("A58", (String)localObject).withParams("A59", locale.k() + "m").withParams("A69", localf.k()).withParams("A82", locale.v()).withType(EventType.REALTIME).withCode("rqd_model").build();
      BeaconReport.getInstance().report((BeaconEvent)localObject);
      return;
      localObject = "N";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.module.StatModule.1
 * JD-Core Version:    0.7.0.1
 */