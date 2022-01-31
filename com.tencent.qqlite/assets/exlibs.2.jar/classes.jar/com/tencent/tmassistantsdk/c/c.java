package com.tencent.tmassistantsdk.c;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.b.a;
import com.tencent.tmassistantsdk.f.f;
import com.tencent.tmassistantsdk.f.k;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogRequest;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogResponse;

public final class c
  extends com.tencent.tmassistantsdk.d.b
{
  private b b = null;
  
  protected final void a(JceStruct paramJceStruct, int paramInt)
  {
    if (paramJceStruct == null) {
      return;
    }
    if ((this.b != null) && (paramInt == 0))
    {
      if ((paramJceStruct instanceof ReportLogResponse))
      {
        if (((ReportLogResponse)paramJceStruct).ret == 0)
        {
          this.b.a(true);
          return;
        }
        this.b.a(false);
        return;
      }
      k.b("LogReportHttpRequest", "response isn't instanceof ReportLogResponse !");
      return;
    }
    k.b("LogReportHttpRequest", "mListener is null !");
  }
  
  public final void a(b paramb)
  {
    this.b = paramb;
  }
  
  public final boolean a(byte paramByte, com.tencent.tmassistantsdk.e.c.b paramb)
  {
    if (paramb == null) {
      return false;
    }
    String str = f.b(f.a().b());
    int i = f.c(f.a().b());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.c.c
 * JD-Core Version:    0.7.0.1
 */