package com.tencent.thumbplayer.api.capability;

import com.tencent.thumbplayer.adapter.player.thumbplayer.TPDrmCapability;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapAudioCodecType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapAudioDecoderType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapCodecType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapHdrType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapVideoDecoderType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.api.TPCommonEnum.TP_AUDIO_CODEC_TYPE;
import com.tencent.thumbplayer.api.TPCommonEnum.TP_AUDIO_DECODER_TYPE;
import com.tencent.thumbplayer.api.TPCommonEnum.TP_DRM_TYPE;
import com.tencent.thumbplayer.api.TPCommonEnum.TP_HDR_TYPE;
import com.tencent.thumbplayer.api.TPCommonEnum.TP_VIDEO_CODEC_TYPE;
import com.tencent.thumbplayer.api.TPCommonEnum.TP_VIDEO_DECODER_TYPE;
import com.tencent.thumbplayer.api.TPNativeException;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.common.TPCodecCapability.TPACodecPropertyRange;
import com.tencent.thumbplayer.core.common.TPCodecCapability.TPCodecMaxCapability;
import com.tencent.thumbplayer.core.common.TPCodecCapability.TPHdrSupportVersionRange;
import com.tencent.thumbplayer.core.common.TPCodecCapability.TPVCodecPropertyRange;
import com.tencent.thumbplayer.core.common.TPNativeLibraryException;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import java.util.HashMap;

public class TPCapability
{
  public static boolean addACodecBlacklist(@TPCommonEnum.TP_AUDIO_DECODER_TYPE int paramInt1, @TPCommonEnum.TP_AUDIO_CODEC_TYPE int paramInt2, TPACodecCapabilityForSet paramTPACodecCapabilityForSet)
    throws TPNativeException
  {
    TPCodecCapability.TPACodecPropertyRange localTPACodecPropertyRange = new TPCodecCapability.TPACodecPropertyRange();
    localTPACodecPropertyRange.set(paramTPACodecCapabilityForSet.getUpperboundSamplerate(), paramTPACodecCapabilityForSet.getUpperboundChannels(), paramTPACodecCapabilityForSet.getUpperboundBitrate(), paramTPACodecCapabilityForSet.getLowerboundSamplerate(), paramTPACodecCapabilityForSet.getLowerboundChannels(), paramTPACodecCapabilityForSet.getLowerboundBitrate(), paramTPACodecCapabilityForSet.getProfileForSet(), paramTPACodecCapabilityForSet.getLevelForSet());
    try
    {
      boolean bool = TPThumbplayerCapabilityHelper.addACodecBlacklist(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapAudioDecoderType.class, paramInt1), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapAudioCodecType.class, paramInt2), localTPACodecPropertyRange);
      return bool;
    }
    catch (TPNativeLibraryException paramTPACodecCapabilityForSet)
    {
      throw new TPNativeException(paramTPACodecCapabilityForSet);
    }
  }
  
  public static boolean addACodecWhitelist(@TPCommonEnum.TP_AUDIO_DECODER_TYPE int paramInt1, @TPCommonEnum.TP_AUDIO_CODEC_TYPE int paramInt2, TPACodecCapabilityForSet paramTPACodecCapabilityForSet)
    throws TPNativeException
  {
    TPCodecCapability.TPACodecPropertyRange localTPACodecPropertyRange = new TPCodecCapability.TPACodecPropertyRange();
    localTPACodecPropertyRange.set(paramTPACodecCapabilityForSet.getUpperboundSamplerate(), paramTPACodecCapabilityForSet.getUpperboundChannels(), paramTPACodecCapabilityForSet.getUpperboundBitrate(), paramTPACodecCapabilityForSet.getLowerboundSamplerate(), paramTPACodecCapabilityForSet.getLowerboundChannels(), paramTPACodecCapabilityForSet.getLowerboundBitrate(), paramTPACodecCapabilityForSet.getProfileForSet(), paramTPACodecCapabilityForSet.getLevelForSet());
    try
    {
      boolean bool = TPThumbplayerCapabilityHelper.addACodecWhitelist(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapAudioDecoderType.class, paramInt1), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapAudioCodecType.class, paramInt2), localTPACodecPropertyRange);
      return bool;
    }
    catch (TPNativeLibraryException paramTPACodecCapabilityForSet)
    {
      throw new TPNativeException(paramTPACodecCapabilityForSet);
    }
  }
  
  public static boolean addDRMLevel1Blacklist(@TPCommonEnum.TP_DRM_TYPE int paramInt)
  {
    return TPThumbplayerCapabilityHelper.addDRMLevel1Blacklist(paramInt);
  }
  
  public static boolean addHDRBlackList(@TPCommonEnum.TP_HDR_TYPE int paramInt, TPHDRVersionRange paramTPHDRVersionRange)
  {
    paramTPHDRVersionRange = new TPCodecCapability.TPHdrSupportVersionRange(paramTPHDRVersionRange.upperboundSystemVersion, paramTPHDRVersionRange.lowerboundSystemVersion, paramTPHDRVersionRange.upperboundPatchVersion, paramTPHDRVersionRange.lowerboundPatchVersion);
    return TPThumbplayerCapabilityHelper.addHDRBlackList(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapHdrType.class, paramInt), paramTPHDRVersionRange);
  }
  
  public static boolean addHDRWhiteList(@TPCommonEnum.TP_HDR_TYPE int paramInt, TPHDRVersionRange paramTPHDRVersionRange)
  {
    paramTPHDRVersionRange = new TPCodecCapability.TPHdrSupportVersionRange(paramTPHDRVersionRange.upperboundSystemVersion, paramTPHDRVersionRange.lowerboundSystemVersion, paramTPHDRVersionRange.upperboundPatchVersion, paramTPHDRVersionRange.lowerboundPatchVersion);
    return TPThumbplayerCapabilityHelper.addHDRWhiteList(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapHdrType.class, paramInt), paramTPHDRVersionRange);
  }
  
  public static boolean addVCodecBlacklist(@TPCommonEnum.TP_VIDEO_DECODER_TYPE int paramInt1, @TPCommonEnum.TP_VIDEO_CODEC_TYPE int paramInt2, TPVCodecCapabilityForSet paramTPVCodecCapabilityForSet)
    throws TPNativeException
  {
    TPCodecCapability.TPVCodecPropertyRange localTPVCodecPropertyRange = new TPCodecCapability.TPVCodecPropertyRange();
    localTPVCodecPropertyRange.set(paramTPVCodecCapabilityForSet.getUpperboundWidth(), paramTPVCodecCapabilityForSet.getUpperboundHeight(), paramTPVCodecCapabilityForSet.getLowerboundWidth(), paramTPVCodecCapabilityForSet.getLowerboundHeight(), paramTPVCodecCapabilityForSet.getProfile(), paramTPVCodecCapabilityForSet.getLevel());
    try
    {
      boolean bool = TPThumbplayerCapabilityHelper.addVCodecBlacklist(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapVideoDecoderType.class, paramInt1), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, paramInt2), localTPVCodecPropertyRange);
      return bool;
    }
    catch (TPNativeLibraryException paramTPVCodecCapabilityForSet)
    {
      throw new TPNativeException(paramTPVCodecCapabilityForSet);
    }
  }
  
  public static boolean addVCodecWhitelist(@TPCommonEnum.TP_VIDEO_DECODER_TYPE int paramInt1, @TPCommonEnum.TP_VIDEO_CODEC_TYPE int paramInt2, TPVCodecCapabilityForSet paramTPVCodecCapabilityForSet)
    throws TPNativeException
  {
    TPCodecCapability.TPVCodecPropertyRange localTPVCodecPropertyRange = new TPCodecCapability.TPVCodecPropertyRange();
    localTPVCodecPropertyRange.set(paramTPVCodecCapabilityForSet.getUpperboundWidth(), paramTPVCodecCapabilityForSet.getUpperboundHeight(), paramTPVCodecCapabilityForSet.getLowerboundWidth(), paramTPVCodecCapabilityForSet.getLowerboundHeight(), paramTPVCodecCapabilityForSet.getProfile(), paramTPVCodecCapabilityForSet.getLevel());
    try
    {
      boolean bool = TPThumbplayerCapabilityHelper.addVCodecWhitelist(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapVideoDecoderType.class, paramInt1), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, paramInt2), localTPVCodecPropertyRange);
      return bool;
    }
    catch (TPNativeLibraryException paramTPVCodecCapabilityForSet)
    {
      throw new TPNativeException(paramTPVCodecCapabilityForSet);
    }
  }
  
  public static int[] getDRMCapabilities()
  {
    return TPDrmCapability.getDRMCapabilities();
  }
  
  public static TPVCodecCapabilityForGet getThumbPlayerVCodecMaxCapability(@TPCommonEnum.TP_VIDEO_CODEC_TYPE int paramInt)
    throws TPNativeException
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return TPVCodecCapabilityForGet.mDefaultVCodecCapability;
    }
    try
    {
      TPCodecCapability.TPCodecMaxCapability localTPCodecMaxCapability = TPThumbplayerCapabilityHelper.getVCodecMaxCapability(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, paramInt));
      if (localTPCodecMaxCapability == null) {
        return TPVCodecCapabilityForGet.mDefaultVCodecCapability;
      }
    }
    catch (TPNativeLibraryException localTPNativeLibraryException)
    {
      throw new TPNativeException(localTPNativeLibraryException);
    }
    return new TPVCodecCapabilityForGet(localTPNativeLibraryException.maxLumaSamples, localTPNativeLibraryException.maxProfile, localTPNativeLibraryException.maxLevel, localTPNativeLibraryException.maxFramerateFormaxLumaSamples);
  }
  
  public static TPVCodecCapabilityForGet getThumbPlayerVCodecTypeMaxCapability(@TPCommonEnum.TP_VIDEO_CODEC_TYPE int paramInt1, @TPCommonEnum.TP_VIDEO_DECODER_TYPE int paramInt2)
    throws TPNativeException
  {
    if (!TPNativeLibraryLoader.isLibLoaded()) {
      return TPVCodecCapabilityForGet.mDefaultVCodecCapability;
    }
    try
    {
      HashMap localHashMap = TPThumbplayerCapabilityHelper.getVCodecDecoderMaxCapabilityMap(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapVideoDecoderType.class, paramInt2));
      paramInt1 = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, paramInt1);
      if ((localHashMap == null) || (localHashMap.isEmpty())) {
        return TPVCodecCapabilityForGet.mDefaultVCodecCapability;
      }
    }
    catch (TPNativeLibraryException localTPNativeLibraryException)
    {
      throw new TPNativeException(localTPNativeLibraryException);
    }
    TPCodecCapability.TPCodecMaxCapability localTPCodecMaxCapability = (TPCodecCapability.TPCodecMaxCapability)localTPNativeLibraryException.get(Integer.valueOf(paramInt1));
    if (localTPCodecMaxCapability == null) {
      return TPVCodecCapabilityForGet.mDefaultVCodecCapability;
    }
    return new TPVCodecCapabilityForGet(localTPCodecMaxCapability.maxLumaSamples, localTPCodecMaxCapability.maxProfile, localTPCodecMaxCapability.maxLevel, localTPCodecMaxCapability.maxFramerateFormaxLumaSamples);
  }
  
  public static boolean isACodecCapabilityCanSupport(@TPCommonEnum.TP_AUDIO_CODEC_TYPE int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    throws TPNativeException
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return false;
    }
    try
    {
      boolean bool = TPThumbplayerCapabilityHelper.isACodecCapabilityCanSupport(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      return bool;
    }
    catch (TPNativeLibraryException localTPNativeLibraryException)
    {
      throw new TPNativeException(localTPNativeLibraryException);
    }
  }
  
  public static boolean isDDPlusSupported()
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return false;
    }
    return TPThumbplayerCapabilityHelper.isDDPlusSupported();
  }
  
  public static boolean isDDSupported()
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return false;
    }
    return TPThumbplayerCapabilityHelper.isDDSupported();
  }
  
  public static boolean isDRMsupport(@TPCommonEnum.TP_DRM_TYPE int paramInt)
  {
    return TPDrmCapability.isDRMSupport(paramInt);
  }
  
  public static boolean isDolbyDSSupported()
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return false;
    }
    return TPThumbplayerCapabilityHelper.isDolbyDSSupported();
  }
  
  public static boolean isDolbyVisionSupported()
  {
    return false;
  }
  
  public static boolean isHDRsupport(@TPCommonEnum.TP_HDR_TYPE int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return false;
    }
    return TPThumbplayerCapabilityHelper.isHDRsupport(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapHdrType.class, paramInt1), paramInt2, paramInt3);
  }
  
  public static boolean isVCodecCapabilityCanSupport(@TPCommonEnum.TP_VIDEO_CODEC_TYPE int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    throws TPNativeException
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return false;
    }
    try
    {
      boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilityCanSupport(paramInt1, paramInt2, paramInt3, 0, 0, paramInt6);
      return bool;
    }
    catch (TPNativeLibraryException localTPNativeLibraryException)
    {
      throw new TPNativeException(localTPNativeLibraryException);
    }
  }
  
  public static boolean isVCodecCapabilityCanSupport(@TPCommonEnum.TP_VIDEO_CODEC_TYPE int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    throws TPNativeException
  {
    if (!TPPlayerMgr.isThumbPlayerEnable()) {
      return false;
    }
    try
    {
      boolean bool = TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(paramInt2, paramInt1, paramInt3, paramInt4, 0, 0, paramInt7);
      return bool;
    }
    catch (TPNativeLibraryException localTPNativeLibraryException)
    {
      throw new TPNativeException(localTPNativeLibraryException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.capability.TPCapability
 * JD-Core Version:    0.7.0.1
 */