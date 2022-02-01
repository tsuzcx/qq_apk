package com.huawei.hms.support.api.opendevice;

import android.app.PendingIntent;
import com.huawei.hms.support.api.client.Result;

public class OaidResult
  extends Result
{
  private String id;
  private boolean isTrackLimited;
  private PendingIntent settingIntent;
  
  public String getId()
  {
    return this.id;
  }
  
  public PendingIntent getSettingIntent()
  {
    return this.settingIntent;
  }
  
  public boolean isTrackLimited()
  {
    return this.isTrackLimited;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setSettingIntent(PendingIntent paramPendingIntent)
  {
    this.settingIntent = paramPendingIntent;
  }
  
  public void setTrackLimited(boolean paramBoolean)
  {
    this.isTrackLimited = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.opendevice.OaidResult
 * JD-Core Version:    0.7.0.1
 */