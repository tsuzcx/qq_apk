package com.tencent.mobileqq.magicface;

import android.content.pm.ApplicationInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class DecoderUtil
{
  public static boolean IS_LOAD_SUCESS;
  final String nativeLibraryDir = BaseApplicationImpl.getApplication().getApplicationInfo().nativeLibraryDir;
  
  static
  {
    try
    {
      System.loadLibrary("magicfaceDec");
      IS_LOAD_SUCESS = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      do
      {
        IS_LOAD_SUCESS = false;
      } while (!QLog.isColorLevel());
      QLog.e("DecoderUtil", 2, "Fail to load libmagicfaceDec.so.");
    }
  }
  
  public int createAlphaDecoder()
  {
    return createAlphaDecoder(this.nativeLibraryDir);
  }
  
  public native int createAlphaDecoder(String paramString);
  
  public int createVideoDecoder()
  {
    return createVideoDecoder(this.nativeLibraryDir);
  }
  
  public native int createVideoDecoder(String paramString);
  
  public native int decodeAlphaDecoder(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2);
  
  public native int decodeAlphaDecoderReturnYUV(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2);
  
  public native int decodeVideoDecoder(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2);
  
  public native int decodeVideoDecoderReturnYUV(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2);
  
  public native int getHeightAlphaDecoder();
  
  public native int getHeightVideoDecoder();
  
  public native int getWidthAlphaDecoder();
  
  public native int getWidthVideoDecoder();
  
  public native int releaseAlphaDecoder();
  
  public native int releaseVideoDecoder();
  
  public void testfunc1(byte[] paramArrayOfByte, long paramLong) {}
  
  public void testfunc2(byte paramByte, long paramLong) {}
  
  public void testfunc3() {}
  
  public void testfunc4(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.DecoderUtil
 * JD-Core Version:    0.7.0.1
 */