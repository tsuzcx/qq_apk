package com.tencent.mobileqq.earlydownload.xmldata;

import affq;

public class PttTransitonAnimData
  extends XmlData
{
  @affq(aje=false, save=true)
  public boolean autoDownload;
  public boolean isUserClick = true;
  
  public String getSharedPreferencesName()
  {
    return "early_ptt.transition.anim.res.zip";
  }
  
  public String getStrResName()
  {
    return "ptt.transition.anim.res.zip";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.PttTransitonAnimData
 * JD-Core Version:    0.7.0.1
 */