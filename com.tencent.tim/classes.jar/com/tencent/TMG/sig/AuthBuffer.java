package com.tencent.TMG.sig;

public class AuthBuffer
{
  private static boolean mIsSoLoaded = false;
  private static AuthBuffer sAuthBuffer;
  
  public static AuthBuffer getInstance()
  {
    if (sAuthBuffer == null) {}
    try
    {
      if (sAuthBuffer == null)
      {
        loadSo();
        if (mIsSoLoaded) {
          sAuthBuffer = new AuthBuffer();
        }
      }
      return sAuthBuffer;
    }
    finally {}
  }
  
  private static void loadSo()
  {
    if (!mIsSoLoaded) {}
    try
    {
      System.loadLibrary("stlport_shared");
      System.loadLibrary("qav_authbuff");
      mIsSoLoaded = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      mIsSoLoaded = false;
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public native byte[] genAuthBuffer(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4, int paramInt5);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.sig.AuthBuffer
 * JD-Core Version:    0.7.0.1
 */