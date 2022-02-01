package com.facebook.stetho.server;

import com.facebook.stetho.common.ProcessUtil;

public class AddressNameHelper
{
  private static final String PREFIX = "stetho_";
  
  public static String createCustomAddress(String paramString)
  {
    return "stetho_" + ProcessUtil.getProcessName() + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.AddressNameHelper
 * JD-Core Version:    0.7.0.1
 */