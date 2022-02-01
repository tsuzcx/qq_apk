package com.tencent.mobileqq.earlydownload.xmldata;

import affq;

public class PttSilkAndChangeVoiceSoData
  extends XmlData
{
  @affq(aje=true, save=true)
  public boolean amrV5So;
  @affq(aje=true, save=true)
  public boolean amrV7So;
  @affq(aje=true, save=true)
  public boolean amrV8So;
  @affq(aje=true, save=true)
  public boolean mipsSo;
  @affq(aje=true, save=true)
  public String version = "";
  @affq(aje=true, save=true)
  public boolean x86So;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.ptt.so.658";
  }
  
  public String getStrResName()
  {
    return "qq.android.ptt.so.658";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.PttSilkAndChangeVoiceSoData
 * JD-Core Version:    0.7.0.1
 */