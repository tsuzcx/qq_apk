package com.etrump.mixlayout;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

public class EtrumpJNI
{
  static
  {
    try
    {
      System.loadLibrary("vipfont");
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EtrumpJNI", 2, localThrowable.getMessage());
    }
  }
  
  public native void nativeCacheCommonUnichars();
  
  public native void nativeDoneEngine();
  
  public native int nativeDrawTextInRect(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int nativeDrawTextWithArray(String paramString, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  public native int nativeDrawTextWithBitmap(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3);
  
  public native void nativeEnablePreMultiplyColor(boolean paramBoolean);
  
  public native int nativeFontCreateFromFile(String paramString);
  
  public native int nativeFontCreateFromMemory(byte[] paramArrayOfByte);
  
  public native void nativeFontDelete(int paramInt);
  
  public native String nativeGetFontNameByLangId(int paramInt1, int paramInt2);
  
  public native int nativeInitEngine(int paramInt);
  
  public native int nativeIsPaintableChar(char paramChar);
  
  public native void nativeMemset(int[] paramArrayOfInt, int paramInt, byte paramByte);
  
  public native void nativeSetAlignment(int paramInt1, int paramInt2);
  
  public native void nativeSetCrochetWidth(int paramInt);
  
  public native void nativeSetEdgeColor(int paramInt);
  
  public native void nativeSetFontColor(int paramInt);
  
  public native void nativeSetFontSize(int paramInt);
  
  public native void nativeSetFontStyle(int paramInt);
  
  public native void nativeSetLineBreakMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void nativeSetShadowInfo(int paramInt1, int paramInt2, int paramInt3);
  
  public native boolean nativeSwitchFont(int paramInt);
  
  public native EtrumpLayoutLine nativeTextLayoutGetLine(int paramInt1, int paramInt2);
  
  public native int nativeTextLayoutGetLineHeight(int paramInt1, int paramInt2);
  
  public native int nativeTextLayoutGetLineRangeFrom(int paramInt1, int paramInt2);
  
  public native int nativeTextLayoutGetLineRangeTo(int paramInt1, int paramInt2);
  
  public native int nativeTextLayoutGetLineTotal(int paramInt);
  
  public native int nativeTextLayoutGetLineWidth(int paramInt1, int paramInt2);
  
  public native boolean nativeTextLayoutHasPreline(int paramInt);
  
  public native int nativeTextLayoutLock(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native void nativeTextLayoutUnlock(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.etrump.mixlayout.EtrumpJNI
 * JD-Core Version:    0.7.0.1
 */