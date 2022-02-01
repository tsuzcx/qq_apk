package com.tencent.thumbplayer.core.common;

public final class TPDrm
{
  private static final String TAG = "TPDrm";
  private static boolean mIsLibLoaded;
  
  static
  {
    try
    {
      TPNativeLibraryLoader.loadLibIfNeeded(null);
      mIsLibLoaded = true;
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      TPNativeLog.printLog(4, localUnsupportedOperationException.getMessage());
      mIsLibLoaded = false;
    }
  }
  
  public static int[] getDRMCapabilities()
    throws TPNativeLibraryException
  {
    if (!isLibLoaded()) {
      throw new TPNativeLibraryException("Failed to load native library.");
    }
    try
    {
      int[] arrayOfInt1 = native_getDRMCapabilities();
      int[] arrayOfInt2 = arrayOfInt1;
      if (arrayOfInt1 == null) {
        arrayOfInt2 = new int[0];
      }
      return arrayOfInt2;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.toString());
      throw new TPNativeLibraryException("Failed to call native func.");
    }
  }
  
  private static boolean isLibLoaded()
  {
    return mIsLibLoaded;
  }
  
  static native int[] native_getDRMCapabilities();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPDrm
 * JD-Core Version:    0.7.0.1
 */