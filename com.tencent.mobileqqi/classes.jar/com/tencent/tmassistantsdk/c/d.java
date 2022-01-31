package com.tencent.tmassistantsdk.c;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.b.a;
import com.tencent.tmassistantsdk.e.c.b;
import com.tencent.tmassistantsdk.f.e;
import com.tencent.tmassistantsdk.f.j;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogRequest;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogResponse;

public final class d
  extends com.tencent.tmassistantsdk.d.d
{
  private c b = null;
  
  protected final void a(JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt)
  {
    if (paramJceStruct2 == null) {
      return;
    }
    if ((this.b != null) && (paramInt == 0))
    {
      if ((paramJceStruct2 instanceof ReportLogResponse))
      {
        if (((ReportLogResponse)paramJceStruct2).ret == 0)
        {
          this.b.a(true);
          return;
        }
        this.b.a(false);
        return;
      }
      j.b("LogReportHttpRequest", "response isn't instanceof ReportLogResponse !");
      return;
    }
    j.b("LogReportHttpRequest", "mListener is null !");
  }
  
  public final void a(c paramc)
  {
    this.b = paramc;
  }
  
  public final boolean a(byte paramByte, b paramb)
  {
    if (paramb == null) {
      return false;
    }
    String str = e.b(e.a().b());
    int i = e.c(e.a().b());
    paramb = paramb.b;
    ReportLogRequest localReportLogRequest = new ReportLogRequest();
    localReportLogRequest.logType = paramByte;
    localReportLogRequest.logData = a.a(paramb);
    localReportLogRequest.hostAppPackageName = str;
    localReportLogRequest.hostAppVersion = i;
    localReportLogRequest.hostUserId = "";
    return super.a((ReportLogRequest)localReportLogRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.c.d
 * JD-Core Version:    0.7.0.1
 */