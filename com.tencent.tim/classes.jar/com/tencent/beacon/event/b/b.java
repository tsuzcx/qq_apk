package com.tencent.beacon.event.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.a.a.d;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.event.c.g;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.EventType;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.qimei.Qimei;
import com.tencent.beacon.qimei.QimeiSDK;
import com.tencent.beacon.qimei.a;
import java.util.HashMap;
import java.util.Map;

public class b
  extends c
  implements d
{
  private boolean b = false;
  private String c;
  
  public b()
  {
    com.tencent.beacon.a.a.b.a().a(2, this);
  }
  
  private boolean c(BeaconEvent paramBeaconEvent)
  {
    return (paramBeaconEvent.getType() == EventType.IMMEDIATE_WNS) || (paramBeaconEvent.getType() == EventType.IMMEDIATE_MSF);
  }
  
  BeaconEvent a(BeaconEvent paramBeaconEvent)
  {
    if ((this.b) && (!com.tencent.beacon.base.util.b.a(paramBeaconEvent.getCode()))) {
      return paramBeaconEvent;
    }
    Object localObject1 = com.tencent.beacon.a.c.c.d();
    Context localContext = ((com.tencent.beacon.a.c.c)localObject1).c();
    Map localMap = paramBeaconEvent.getParams();
    Object localObject2 = a.a().b();
    if ((localObject2 != null) && (!((Qimei)localObject2).isEmpty())) {
      localMap.putAll(((Qimei)localObject2).getQimeiMap());
    }
    localMap.put("A143", QimeiSDK.getInstance().getOmgID());
    localMap.put("A144", f.e().i());
    localMap.put("A19", e.l().q());
    localMap.put("QQ", com.tencent.beacon.a.c.b.c());
    localMap.put("A95", "" + com.tencent.beacon.a.c.b.a());
    localMap.put("A141", QimeiSDK.getInstance().getBeaconIdInfo());
    localMap.put("A23", ((com.tencent.beacon.a.c.c)localObject1).a());
    localMap.put("A48", com.tencent.beacon.a.c.c.d().e());
    localObject2 = paramBeaconEvent.getAppKey();
    EventModule localEventModule = (EventModule)((com.tencent.beacon.a.c.c)localObject1).a(ModuleName.EVENT);
    localMap.put("A1", localEventModule.b((String)localObject2));
    localMap.put("A99", paramBeaconEvent.getLogidPrefix());
    localMap.put("A72", ((com.tencent.beacon.a.c.c)localObject1).i());
    localMap.put("A159", e.l().E());
    localMap.put("A34", String.valueOf(com.tencent.beacon.base.util.b.c()));
    if (c(paramBeaconEvent)) {}
    for (localObject1 = "Y";; localObject1 = "N")
    {
      localMap.put("A156", localObject1);
      if (!localMap.containsKey("A88"))
      {
        if (TextUtils.isEmpty(this.c)) {
          this.c = com.tencent.beacon.a.c.b.a(localContext);
        }
        localMap.put("A88", this.c);
      }
      localMap.put("A100", g.a(localContext, (String)localObject2).a(paramBeaconEvent.getCode(), paramBeaconEvent.getType()));
      localObject1 = localEventModule.a((String)localObject2);
      if (localObject1 != null) {
        localMap.putAll((Map)localObject1);
      }
      paramBeaconEvent.setParams(localMap);
      return paramBeaconEvent;
    }
  }
  
  public void onEvent(com.tencent.beacon.a.a.c paramc)
  {
    if (paramc.a != 2) {}
    do
    {
      return;
      paramc = (HashMap)paramc.b.get("d_m");
    } while (paramc == null);
    this.b = com.tencent.beacon.base.util.b.a((String)paramc.get("tidyEF"), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.b.b
 * JD-Core Version:    0.7.0.1
 */