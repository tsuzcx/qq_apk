package com.tencent.beacon.event.b;

import android.support.annotation.Nullable;
import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.event.c.a;
import com.tencent.beacon.event.open.BeaconEvent;

public abstract class c
{
  private c a;
  
  abstract BeaconEvent a(BeaconEvent paramBeaconEvent);
  
  public void a(c paramc)
  {
    this.a = paramc;
  }
  
  @Nullable
  public final EventBean b(BeaconEvent paramBeaconEvent)
  {
    paramBeaconEvent = a(paramBeaconEvent);
    c localc = this.a;
    if (localc != null) {
      return localc.b(paramBeaconEvent);
    }
    return a.a(paramBeaconEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.b.c
 * JD-Core Version:    0.7.0.1
 */