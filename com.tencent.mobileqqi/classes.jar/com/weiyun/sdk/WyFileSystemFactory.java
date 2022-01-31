package com.weiyun.sdk;

import com.weiyun.sdk.impl.WyFileSystem;

public class WyFileSystemFactory
{
  private static volatile IWyFileSystem sFileSystem;
  
  public static IWyFileSystem getWyFileSystem()
  {
    if (sFileSystem == null) {}
    try
    {
      if (sFileSystem == null) {
        sFileSystem = new WyFileSystem();
      }
      return sFileSystem;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.weiyun.sdk.WyFileSystemFactory
 * JD-Core Version:    0.7.0.1
 */