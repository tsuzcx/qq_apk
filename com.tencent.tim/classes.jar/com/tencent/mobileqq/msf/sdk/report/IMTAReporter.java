package com.tencent.mobileqq.msf.sdk.report;

import java.util.Properties;

public abstract interface IMTAReporter
{
  public abstract void initMtaConfig(String paramString1, String paramString2);
  
  public abstract boolean isMtaSupported();
  
  public abstract void reportKVEvent(String paramString, Properties paramProperties);
  
  public abstract void reportTimeKVEvent(String paramString, Properties paramProperties, int paramInt);
  
  public abstract void trackBeginPage(String paramString);
  
  public abstract void trackEndPage(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.report.IMTAReporter
 * JD-Core Version:    0.7.0.1
 */