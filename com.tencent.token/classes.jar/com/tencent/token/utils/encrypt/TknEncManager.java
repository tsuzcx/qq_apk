package com.tencent.token.utils.encrypt;

import android.content.Context;
import com.tencent.token.global.RqdApplication;

public class TknEncManager
{
  private static TknEncManager a = null;
  
  static
  {
    System.loadLibrary("secure");
  }
  
  private TknEncManager()
  {
    initEncKey(RqdApplication.i(), 2131361935);
  }
  
  public static TknEncManager a()
  {
    if (a == null) {
      a = new TknEncManager();
    }
    return a;
  }
  
  private native void initEncKey(Context paramContext, int paramInt);
  
  public native byte[] decInitCode(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.TknEncManager
 * JD-Core Version:    0.7.0.1
 */