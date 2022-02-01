package com.tencent.qqlive.tvkplayer;

import com.tencent.qqlive.tvkplayer.vinfo.ckey.BeaconInterface;
import java.util.Map;
import java.util.Properties;

final class TVideoMgr$1
  implements BeaconInterface
{
  public String getQIMEI()
  {
    return TVideoMgr.access$000();
  }
  
  public Properties getRequiredReportValue()
  {
    return null;
  }
  
  public boolean trackCustomKVEvent(String paramString, Map<String, String> paramMap)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.TVideoMgr.1
 * JD-Core Version:    0.7.0.1
 */