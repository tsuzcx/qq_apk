package com.tencent.ttpic.util;

public class PTFaceLogUtil
{
  private static PTFaceLogInterface mPtFaceLog = null;
  
  public static void e(String paramString1, String paramString2)
  {
    if (mPtFaceLog != null) {
      mPtFaceLog.e(paramString1, paramString2, true);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (mPtFaceLog != null) {
      mPtFaceLog.i(paramString1, paramString2, true);
    }
  }
  
  public static void setPtFaceLog(PTFaceLogInterface paramPTFaceLogInterface)
  {
    mPtFaceLog = paramPTFaceLogInterface;
  }
  
  public static abstract interface PTFaceLogInterface
  {
    public abstract void e(String paramString1, String paramString2, boolean paramBoolean);
    
    public abstract void i(String paramString1, String paramString2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.PTFaceLogUtil
 * JD-Core Version:    0.7.0.1
 */