package com.tencent.mobileqq.earlydownload.xmldata;

import affq;

public class AppleEmojiData
  extends XmlData
{
  @affq(aje=true, save=false)
  public String v7a_MD5;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.appleemoji";
  }
  
  public String getStrResName()
  {
    return "qq.android.appleemoji";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.AppleEmojiData
 * JD-Core Version:    0.7.0.1
 */