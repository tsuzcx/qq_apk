package com.tencent.mobileqq.earlydownload.xmldata;

import affq;

public class MiniScanDecodeSoData
  extends XmlData
{
  @affq(aje=true, save=true)
  public boolean block_user_download;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.minidecode.so_v8.2.0";
  }
  
  public String getStrResName()
  {
    return "qq.android.minidecode.so_v8.2.0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.MiniScanDecodeSoData
 * JD-Core Version:    0.7.0.1
 */