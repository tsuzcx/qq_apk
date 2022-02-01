package com.tencent.mobileqq.earlydownload.xmldata;

import afey;
import affq;

public class JpegSoData
  extends XmlData
{
  @affq(aje=true, save=false)
  public String SO_MD5;
  
  public String getSharedPreferencesName()
  {
    return "early_" + afey.ur();
  }
  
  public String getStrResName()
  {
    return afey.ur();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.JpegSoData
 * JD-Core Version:    0.7.0.1
 */