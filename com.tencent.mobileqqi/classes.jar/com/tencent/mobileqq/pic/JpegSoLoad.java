package com.tencent.mobileqq.pic;

public class JpegSoLoad
{
  public static final int FILE_NOT_FIND = -2;
  public static final int INVALID_PARAM = -1;
  public static final int LOAD_ERROR = -3;
  public static final int LOAD_SUCCESS = 0;
  
  public static int LoadJpegExtractedSo(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return -1;
    }
    try
    {
      System.loadLibrary(paramString);
      return i;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        i = -3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegSoLoad
 * JD-Core Version:    0.7.0.1
 */