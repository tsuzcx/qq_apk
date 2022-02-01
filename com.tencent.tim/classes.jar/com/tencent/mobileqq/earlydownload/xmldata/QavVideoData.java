package com.tencent.mobileqq.earlydownload.xmldata;

import affq;

public class QavVideoData
  extends XmlData
{
  @affq(aje=false, save=true)
  public boolean autoDownload;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.qav.video";
  }
  
  public String getStrResName()
  {
    return "qq.android.qav.video";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QavVideoData
 * JD-Core Version:    0.7.0.1
 */