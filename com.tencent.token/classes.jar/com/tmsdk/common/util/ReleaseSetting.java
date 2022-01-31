package com.tmsdk.common.util;

public class ReleaseSetting
{
  public static final String CHANNEL_NO = "111111";
  public static final boolean NEED_DeviceId = false;
  
  public static boolean isAllowAndroidID()
  {
    return true;
  }
  
  public static boolean isAllowImei()
  {
    return true;
  }
  
  public static boolean isAllowImsi()
  {
    return true;
  }
  
  public static boolean isAllowMac()
  {
    return true;
  }
  
  public static boolean isAllowOther()
  {
    return true;
  }
  
  public static boolean isCheckLicence()
  {
    return false;
  }
  
  public static boolean isJavaTCC()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.common.util.ReleaseSetting
 * JD-Core Version:    0.7.0.1
 */