package com.tencent.mobileqq.earlydownload.xmldata;

import affq;

public class QavImageData
  extends XmlData
{
  @affq(aje=false, save=true)
  public boolean autoDownload;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.qav.image2";
  }
  
  public String getStrResName()
  {
    return "qq.android.qav.image2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QavImageData
 * JD-Core Version:    0.7.0.1
 */