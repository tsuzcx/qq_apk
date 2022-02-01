package com.tencent.beacon.event.b;

import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.EventType;
import java.util.Map;

public class a
  extends c
{
  protected BeaconEvent a(BeaconEvent paramBeaconEvent)
  {
    Object localObject = paramBeaconEvent.getType();
    if ((localObject == EventType.DT_REALTIME) || (localObject == EventType.DT_NORMAL))
    {
      localObject = paramBeaconEvent.getParams();
      e locale = e.l();
      f localf = f.e();
      ((Map)localObject).put("dt_imei2", "" + localf.c());
      ((Map)localObject).put("dt_meid", "" + localf.g());
      ((Map)localObject).put("dt_mf", "" + locale.o());
      paramBeaconEvent.setParams((Map)localObject);
    }
    return paramBeaconEvent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.b.a
 * JD-Core Version:    0.7.0.1
 */