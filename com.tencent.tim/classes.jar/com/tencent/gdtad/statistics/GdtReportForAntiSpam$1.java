package com.tencent.gdtad.statistics;

import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import tkw;

public final class GdtReportForAntiSpam$1
  implements Runnable
{
  public GdtReportForAntiSpam$1(byte[] paramArrayOfByte) {}
  
  public void run()
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl("https://rpt.gdt.qq.com/mqq_log");
    localParams.method = "POST";
    localParams.contentType = "application/json";
    localParams.requestData = this.val$data;
    if (!localParams.canSend())
    {
      tkw.e("GdtReportForAntiSpam", "reportAntiSpamForClick error");
      return;
    }
    AdHttp.send(localParams);
    tkw.i("GdtReportForAntiSpam", String.format("reportAntiSpamForClick responseCode:%d durationMillis:%d", new Object[] { Integer.valueOf(localParams.responseCode), Long.valueOf(localParams.durationMillis) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtReportForAntiSpam.1
 * JD-Core Version:    0.7.0.1
 */