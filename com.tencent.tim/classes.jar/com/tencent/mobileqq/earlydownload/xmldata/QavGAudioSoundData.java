package com.tencent.mobileqq.earlydownload.xmldata;

import affq;

public class QavGAudioSoundData
  extends XmlData
{
  @affq(aje=false, save=true)
  public boolean autoDownload;
  
  public String getSharedPreferencesName()
  {
    return "early_qq.android.qav.muteaudio";
  }
  
  public String getStrResName()
  {
    return "qq.android.qav.muteaudio";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.xmldata.QavGAudioSoundData
 * JD-Core Version:    0.7.0.1
 */