package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.os.Build;
import java.util.HashMap;

public class TPPlayerDecoderCapability
{
  private static String TAG = "TPPlayerDecoderCapability";
  private static boolean mIsLibLoaded;
  private long mNativeContext = 0L;
  
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
  
  private static native boolean _addACodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPACodecPropertyRange paramTPACodecPropertyRange);
  
  private static native boolean _addACodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPACodecPropertyRange paramTPACodecPropertyRange);
  
  private static native boolean _addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange);
  
  private static native boolean _addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange);
  
  private static native HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> _getDecoderMaxCapabilityMap(int paramInt);
  
  private static native boolean _isACodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  private static native boolean _isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public static boolean addACodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPACodecPropertyRange paramTPACodecPropertyRange)
    throws TPNativeLibraryException
  {
    if (!isLibLoaded()) {
      throw new TPNativeLibraryException("addACodecBlacklist: Failed to load native library.");
    }
    try
    {
      boolean bool = _addACodecBlacklist(paramInt1, paramInt2, paramTPACodecPropertyRange);
      return bool;
    }
    catch (Throwable paramTPACodecPropertyRange)
    {
      TPNativeLog.printLog(4, paramTPACodecPropertyRange.getMessage());
      throw new TPNativeLibraryException("Failed to call _addACodecBlacklist.");
    }
  }
  
  public static boolean addACodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPACodecPropertyRange paramTPACodecPropertyRange)
    throws TPNativeLibraryException
  {
    if (!isLibLoaded()) {
      throw new TPNativeLibraryException("addACodecWhitelist: Failed to load native library.");
    }
    try
    {
      boolean bool = _addACodecWhitelist(paramInt1, paramInt2, paramTPACodecPropertyRange);
      return bool;
    }
    catch (Throwable paramTPACodecPropertyRange)
    {
      TPNativeLog.printLog(4, paramTPACodecPropertyRange.getMessage());
      throw new TPNativeLibraryException("Failed to call _addVCodecWhitelist.");
    }
  }
  
  public static boolean addDRMLevel1Blacklist(int paramInt)
  {
    return TPCodecUtils.addDRMLevel1Blacklist(paramInt);
  }
  
  public static boolean addHDRBlackList(int paramInt, TPCodecCapability.TPHdrSupportVersionRange paramTPHdrSupportVersionRange)
  {
    return TPCodecUtils.addHDRBlackList(paramInt, Build.MODEL, paramTPHdrSupportVersionRange);
  }
  
  public static boolean addHDRWhiteList(int paramInt, TPCodecCapability.TPHdrSupportVersionRange paramTPHdrSupportVersionRange)
  {
    return TPCodecUtils.addHDRWhiteList(paramInt, Build.MODEL, paramTPHdrSupportVersionRange);
  }
  
  public static boolean addVCodecBlacklist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
    throws TPNativeLibraryException
  {
    if (!isLibLoaded()) {
      throw new TPNativeLibraryException("addVCodecBlacklist: Failed to load native library.");
    }
    try
    {
      boolean bool = _addVCodecBlacklist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
      return bool;
    }
    catch (Throwable paramTPVCodecPropertyRange)
    {
      TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
      throw new TPNativeLibraryException("Failed to call _addVCodecBlacklist.");
    }
  }
  
  public static boolean addVCodecWhitelist(int paramInt1, int paramInt2, TPCodecCapability.TPVCodecPropertyRange paramTPVCodecPropertyRange)
    throws TPNativeLibraryException
  {
    if (!isLibLoaded()) {
      throw new TPNativeLibraryException("addVCodecWhitelist :Failed to load native library.");
    }
    try
    {
      boolean bool = _addVCodecWhitelist(paramInt1, paramInt2, paramTPVCodecPropertyRange);
      return bool;
    }
    catch (Throwable paramTPVCodecPropertyRange)
    {
      TPNativeLog.printLog(4, paramTPVCodecPropertyRange.getMessage());
      throw new TPNativeLibraryException("Failed to call _addVCodecWhitelist.");
    }
  }
  
  public static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int paramInt)
    throws TPNativeLibraryException
  {
    if (!isLibLoaded()) {
      throw new TPNativeLibraryException("Failed to load native library.");
    }
    try
    {
      HashMap localHashMap = _getDecoderMaxCapabilityMap(paramInt);
      return localHashMap;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      throw new TPNativeLibraryException("Failed to call _getDecoderMaxCapabilityMap.");
    }
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      TPCodecUtils.init(paramContext, paramBoolean);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static boolean isACodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    throws TPNativeLibraryException
  {
    if (2 == paramInt1)
    {
      String str = "";
      switch (paramInt2)
      {
      }
      while (TPCodecUtils.isInMediaCodecWhiteList(str))
      {
        return true;
        str = "audio/aac";
        continue;
        str = "audio/flac";
        continue;
        str = "audio/ac3";
        continue;
        str = "audio/eac3";
        continue;
        str = "audio/dts";
      }
      if ((TPCodecUtils.isAMediaCodecBlackListModel()) || (TPCodecUtils.isBlackListType(str))) {
        return false;
      }
    }
    if (!isLibLoaded()) {
      throw new TPNativeLibraryException("Failed to load native library.");
    }
    try
    {
      boolean bool = _isACodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      throw new TPNativeLibraryException("Failed to call _isACodecCapabilitySupport.");
    }
  }
  
  public static boolean isDDPlusSupported()
  {
    return TPCodecUtils.isMediaCodecDDPlusSupported();
  }
  
  public static boolean isDolbyDSSupported()
  {
    return TPCodecUtils.isMediaCodecDolbyDSSupported();
  }
  
  public static boolean isHDRsupport(int paramInt1, int paramInt2, int paramInt3)
  {
    return TPCodecUtils.isHDRsupport(paramInt1, paramInt2, paramInt3);
  }
  
  private static boolean isLibLoaded()
  {
    return mIsLibLoaded;
  }
  
  public static boolean isVCodecCapabilitySupport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    throws TPNativeLibraryException
  {
    if (102 == paramInt1)
    {
      String str = "";
      switch (paramInt2)
      {
      }
      while (TPCodecUtils.isInMediaCodecWhiteList(str))
      {
        return true;
        str = "video/avc";
        continue;
        str = "video/hevc";
        continue;
        str = "video/av01";
        continue;
        str = "video/x-vnd.on2.vp9";
      }
      if ((TPCodecUtils.isVMediaCodecBlackListModel()) || (TPCodecUtils.isBlackListType(str))) {
        return false;
      }
    }
    if (!isLibLoaded()) {
      throw new TPNativeLibraryException("Failed to load native library.");
    }
    try
    {
      boolean bool = _isVCodecCapabilitySupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
      throw new TPNativeLibraryException("Failed to call _isVCodecCapabilitySupport.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPPlayerDecoderCapability
 * JD-Core Version:    0.7.0.1
 */