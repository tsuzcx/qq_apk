package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import java.util.Map;
import java.util.Properties;

public abstract interface BeaconInterface
{
  public abstract String getQIMEI();
  
  public abstract Properties getRequiredReportValue();
  
  public abstract boolean trackCustomKVEvent(String paramString, Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.BeaconInterface
 * JD-Core Version:    0.7.0.1
 */