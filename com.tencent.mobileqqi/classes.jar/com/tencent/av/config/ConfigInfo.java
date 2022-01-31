package com.tencent.av.config;

import android.content.Context;

public class ConfigInfo
{
  private static ConfigInfo instance = null;
  private Context m_context = null;
  
  public ConfigInfo()
  {
    try
    {
      init();
      cacheMethodIds();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static native void cacheMethodIds();
  
  private native void init();
  
  public static ConfigInfo instance()
  {
    if (instance == null) {
      instance = new ConfigInfo();
    }
    return instance;
  }
  
  public byte[] GetConfigInfoFromFile()
  {
    return Common.a(this.m_context, "VideoConfigInfo");
  }
  
  public void WriteConfigInfoToFile(byte[] paramArrayOfByte) {}
  
  public void init(Context paramContext)
  {
    this.m_context = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */