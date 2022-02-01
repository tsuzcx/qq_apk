package com.tencent.mobileqq.earlydownload.xmldata;

import affq;

public class QFlutterAppData
  extends XmlData
{
  @affq(aje=true, save=true)
  public String assetResMD5 = "";
  @affq(aje=true, save=true)
  public String libAppSoMD5 = "";
  @affq(aje=true, save=true)
  public String libSkinSoMD5 = "";
  
  public String getSharedPreferencesName()
  {
    return "early_qflutter_app_downloader_sp";
  }
  
  public String getStrResName()
  {
    return "qq.android.flutter.app.v8.3.6";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData
 * JD-Core Version:    0.7.0.1
 */