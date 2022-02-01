package com.tencent.beacon.event.immediate;

import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.call.f;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.event.EventBean;
import com.tencent.beacon.pack.AbstractResponseCommon;
import com.tencent.beacon.pack.ResponsePackageV2;
import com.tencent.beacon.pack.a;
import java.util.Date;

public class BeaconImmediateReportCallback
  implements f<BeaconTransferResult>
{
  private com.tencent.beacon.event.d a;
  private EventBean b;
  private String c;
  private long d;
  
  public BeaconImmediateReportCallback(com.tencent.beacon.event.d paramd, EventBean paramEventBean, String paramString)
  {
    this.a = paramd;
    this.b = paramEventBean;
    this.c = paramString;
    this.d = new Date().getTime();
  }
  
  private void a(com.tencent.beacon.base.net.d paramd)
  {
    c.a("[BeaconImmediateReportCallback]", paramd.toString(), new Object[0]);
    com.tencent.beacon.a.b.d.b().a(paramd.b, paramd.d, paramd.e);
    this.a.a(this.b, this.c);
  }
  
  public void onResponse(BeaconTransferResult paramBeaconTransferResult)
  {
    if (paramBeaconTransferResult == null)
    {
      a(new com.tencent.beacon.base.net.d(RequestType.LONG_CONNECTION.name(), "462", -1, "response fail! result is null"));
      return;
    }
    if ((paramBeaconTransferResult.getCode() == 0) && (paramBeaconTransferResult.getBizCode() == 0)) {}
    for (int i = 1;; i = 0)
    {
      c.a("[BeaconImmediateReportCallback]", "result=%s, eventName=%s , logID=%s", new Object[] { paramBeaconTransferResult.toString(), this.b.getEventCode(), this.c });
      if (i != 0) {
        break;
      }
      localObject = c.c("response fail! result = %s", new Object[] { paramBeaconTransferResult.toString() });
      a(new com.tencent.beacon.base.net.d(RequestType.LONG_CONNECTION.name(), "463", paramBeaconTransferResult.getCode(), (String)localObject));
      return;
    }
    Object localObject = paramBeaconTransferResult.getBizBuffer();
    ResponsePackageV2 localResponsePackageV2 = new ResponsePackageV2();
    try
    {
      localResponsePackageV2.readFrom(new a((byte[])localObject));
      com.tencent.beacon.base.net.b.d.a(this.d, localResponsePackageV2.serverTime, localResponsePackageV2.srcGatewayIp);
      return;
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
      a(new com.tencent.beacon.base.net.d(RequestType.LONG_CONNECTION.name(), "463", paramBeaconTransferResult.getCode(), localThrowable.getMessage(), localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.immediate.BeaconImmediateReportCallback
 * JD-Core Version:    0.7.0.1
 */