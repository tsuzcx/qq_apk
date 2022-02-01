package com.tencent.thumbplayer.adapter.strategy.utils;

import com.tencent.thumbplayer.adapter.TPPlaybackInfo;
import com.tencent.thumbplayer.core.common.TPNativeLibraryException;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.TPLogUtil;

public class TPStrategyUtils
{
  private static final String TAG = "TPStrategyUtils";
  
  public static boolean enablePlayBySystemPlayer(TPPlaybackInfo paramTPPlaybackInfo)
  {
    if (paramTPPlaybackInfo.getVideoCodedId() == 0) {
      return true;
    }
    return isSupportMediaCodec(paramTPPlaybackInfo);
  }
  
  public static boolean enablePlayByThumbPlayer(TPPlaybackInfo paramTPPlaybackInfo)
  {
    if (paramTPPlaybackInfo == null) {}
    while ((paramTPPlaybackInfo.getVideoCodedId() == 0) || (isSupportFFmpegCodec(paramTPPlaybackInfo)) || (isSupportMediaCodec(paramTPPlaybackInfo))) {
      return true;
    }
    return false;
  }
  
  public static boolean isSupportFFmpegCodec(TPPlaybackInfo paramTPPlaybackInfo)
  {
    try
    {
      boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(101, TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, paramTPPlaybackInfo.getVideoCodedId()), (int)paramTPPlaybackInfo.getWidth(), (int)paramTPPlaybackInfo.getHeight(), paramTPPlaybackInfo.getVideoProfile(), paramTPPlaybackInfo.getVideoLevel());
      return bool;
    }
    catch (TPNativeLibraryException paramTPPlaybackInfo)
    {
      TPLogUtil.e("TPStrategyUtils", paramTPPlaybackInfo);
    }
    return false;
  }
  
  public static boolean isSupportMediaCodec(TPPlaybackInfo paramTPPlaybackInfo)
  {
    try
    {
      boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(102, TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, paramTPPlaybackInfo.getVideoCodedId()), (int)paramTPPlaybackInfo.getWidth(), (int)paramTPPlaybackInfo.getHeight(), paramTPPlaybackInfo.getVideoProfile(), paramTPPlaybackInfo.getVideoLevel());
      return bool;
    }
    catch (TPNativeLibraryException paramTPPlaybackInfo)
    {
      TPLogUtil.e("TPStrategyUtils", paramTPPlaybackInfo);
    }
    return false;
  }
  
  public static boolean isSystemPlayerEnable()
  {
    return true;
  }
  
  public static boolean isTVPlatform()
  {
    return false;
  }
  
  public static boolean isThumbPlayerEnable()
  {
    return TPNativeLibraryLoader.isLibLoaded();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPStrategyUtils
 * JD-Core Version:    0.7.0.1
 */