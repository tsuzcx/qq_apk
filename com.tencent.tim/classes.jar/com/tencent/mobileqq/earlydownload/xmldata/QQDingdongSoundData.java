package com.tencent.mobileqq.earlydownload.xmldata;

import affq;

public class QQDingdongSoundData
  extends XmlData
{
  @affq(aje=false, save=true)
  public boolean autoDownload;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.dingdong.ring";
  }
  
  public String getStrResName()
  {
    return "qq.android.dingdong.ring";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QQDingdongSoundData
 * JD-Core Version:    0.7.0.1
 */