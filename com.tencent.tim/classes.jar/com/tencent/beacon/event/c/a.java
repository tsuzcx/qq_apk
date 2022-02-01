package com.tencent.beacon.event.c;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.beacon.a.c.c;
import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.event.open.BeaconEvent;
import java.util.Map;

public final class a
{
  @Nullable
  public static EventBean a(BeaconEvent paramBeaconEvent)
  {
    Object localObject = com.tencent.beacon.base.net.b.d.a(paramBeaconEvent.getCode(), paramBeaconEvent.getParams());
    if (localObject == null) {
      return null;
    }
    EventBean localEventBean = new EventBean();
    String str = paramBeaconEvent.getCode();
    localEventBean.setEventCode(str);
    localEventBean.setAppKey(paramBeaconEvent.getAppKey());
    localEventBean.setApn(com.tencent.beacon.base.net.b.d.c());
    localEventBean.setSrcIp(c.d().b());
    localEventBean.setEventCode(str);
    localEventBean.setValueType(0);
    localEventBean.setEventValue((Map)localObject);
    localObject = (String)paramBeaconEvent.getParams().get("A34");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localEventBean.setEventTime(Long.parseLong((String)localObject));
    }
    localEventBean.setEventResult(paramBeaconEvent.isSucceed());
    localEventBean.setEventType(d.a(paramBeaconEvent.getType()));
    localEventBean.setReserved("");
    return localEventBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.c.a
 * JD-Core Version:    0.7.0.1
 */