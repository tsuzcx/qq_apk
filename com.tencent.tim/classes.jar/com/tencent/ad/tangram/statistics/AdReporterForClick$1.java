package com.tencent.ad.tangram.statistics;

import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;

final class AdReporterForClick$1
  implements Runnable
{
  AdReporterForClick$1(String paramString) {}
  
  public void run()
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl(this.val$url);
    localParams.method = "GET";
    AdHttp.send(localParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdReporterForClick.1
 * JD-Core Version:    0.7.0.1
 */