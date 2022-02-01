package com.tencent.beacon.upload;

import android.support.annotation.NonNull;
import com.tencent.beacon.event.c.d;

@Deprecated
public class TunnelInfo
{
  private String appKey;
  private String channelID;
  private String version;
  
  public TunnelInfo(String paramString)
  {
    this(paramString, "", "");
  }
  
  public TunnelInfo(String paramString1, String paramString2)
  {
    this(paramString1, "", paramString2);
  }
  
  public TunnelInfo(@NonNull String paramString1, String paramString2, String paramString3)
  {
    this.appKey = paramString1;
    this.version = paramString2;
    this.channelID = d.a(paramString3);
  }
  
  public String getAppKey()
  {
    return this.appKey;
  }
  
  public String getChannelID()
  {
    return this.channelID;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public void setAppKey(String paramString)
  {
    this.appKey = paramString;
  }
  
  public void setChannelID(String paramString)
  {
    this.channelID = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.version = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.upload.TunnelInfo
 * JD-Core Version:    0.7.0.1
 */