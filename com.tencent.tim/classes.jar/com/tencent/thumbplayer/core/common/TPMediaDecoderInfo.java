package com.tencent.thumbplayer.core.common;

import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.os.Build.VERSION;
import android.util.Range;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public final class TPMediaDecoderInfo
  implements Serializable
{
  private static final int DEFAULT_MAX_BITRATE = 960000;
  private static final int DEFAULT_MAX_CHANNELNUM = 2;
  private static final int DEFAULT_MAX_HEIGHT = 720;
  private static final int DEFAULT_MAX_SAMPLERATE = 48000;
  private static final int DEFAULT_MAX_WIDTH = 1280;
  private static final int DEFAULT_MIN_BITRATE = 8000;
  private static final String TAG = "TPCodecUtils";
  private boolean adaptiveDec;
  private int[] colorFormats;
  private String decMimeType;
  private String decName;
  private int maxBitRate;
  private int maxChannels;
  private int maxFrameRate;
  private int maxHeight;
  private int maxLumaFrameRate;
  private int maxLumaHeight;
  private int maxLumaWidth;
  private int maxSampleRate;
  private int maxSupportedInstances;
  private int maxWidth;
  private DecoderProfileLevel[] profileLevels;
  private boolean secureDec;
  private boolean softwareAudioDec;
  private boolean softwareVideoDec;
  private boolean tunnelingDec;
  
  public TPMediaDecoderInfo(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    reset();
    this.decName = paramString2;
    this.decMimeType = paramString1;
    if ((isVideo()) && (isVideoSoftwareOnly(paramString2)))
    {
      bool1 = true;
      this.softwareVideoDec = bool1;
      if ((!isAudio()) || (!isAudioSoftwareOnly(paramString2))) {
        break label226;
      }
      bool1 = true;
      label63:
      this.softwareAudioDec = bool1;
      if ((paramCodecCapabilities == null) || (!isAdaptive(paramCodecCapabilities))) {
        break label232;
      }
      bool1 = true;
      label84:
      this.adaptiveDec = bool1;
      if ((paramCodecCapabilities == null) || (!isTunneling(paramCodecCapabilities))) {
        break label238;
      }
      bool1 = true;
      label105:
      this.tunnelingDec = bool1;
      if ((paramCodecCapabilities == null) || (!isSecure(paramCodecCapabilities))) {
        break label244;
      }
    }
    label226:
    label232:
    label238:
    label244:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.secureDec = bool1;
      if ((paramCodecCapabilities == null) || (paramCodecCapabilities.profileLevels == null) || (paramCodecCapabilities.profileLevels.length <= 0)) {
        break label387;
      }
      paramString2 = new ArrayList();
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = paramCodecCapabilities.profileLevels;
      int j = arrayOfCodecProfileLevel.length;
      int i = 0;
      while (i < j)
      {
        MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = arrayOfCodecProfileLevel[i];
        paramString2.add(new DecoderProfileLevel(localCodecProfileLevel.profile, localCodecProfileLevel.level));
        i += 1;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label63;
      bool1 = false;
      break label84;
      bool1 = false;
      break label105;
    }
    this.profileLevels = ((DecoderProfileLevel[])paramString2.toArray(new DecoderProfileLevel[paramString2.size()]));
    if ((paramCodecCapabilities != null) && (paramCodecCapabilities.colorFormats != null) && (paramCodecCapabilities.colorFormats.length > 0))
    {
      this.colorFormats = Arrays.copyOf(paramCodecCapabilities.colorFormats, paramCodecCapabilities.colorFormats.length);
      label303:
      this.maxSupportedInstances = getMaxSupportedInstances(paramCodecCapabilities);
      if (Build.VERSION.SDK_INT >= 21)
      {
        if ((!paramString1.contains("video")) || (paramCodecCapabilities == null)) {
          break label408;
        }
        paramString1 = paramCodecCapabilities.getVideoCapabilities();
        if (paramString1 != null)
        {
          this.maxWidth = getMaxWidth(paramString1);
          this.maxHeight = getMaxHeight(paramString1);
          this.maxLumaFrameRate = getMaxSupportedFrameRate(paramString1);
          this.maxFrameRate = ((Integer)paramString1.getSupportedFrameRates().getUpper()).intValue();
        }
      }
    }
    label387:
    label408:
    do
    {
      do
      {
        return;
        this.profileLevels = new DecoderProfileLevel[0];
        break;
        this.colorFormats = new int[0];
        break label303;
      } while ((!paramString1.contains("audio")) || (paramCodecCapabilities == null));
      paramString1 = paramCodecCapabilities.getAudioCapabilities();
    } while (paramString1 == null);
    this.maxSampleRate = getMaxSampleRate(paramString1);
    this.maxBitRate = getMaxBitRate(paramString1);
    this.maxChannels = getMaxChannels(paramString1);
  }
  
  private int getMaxBitRate(MediaCodecInfo.AudioCapabilities paramAudioCapabilities)
  {
    if (paramAudioCapabilities != null) {}
    for (paramAudioCapabilities = paramAudioCapabilities.getBitrateRange();; paramAudioCapabilities = new Range(Integer.valueOf(8000), Integer.valueOf(960000))) {
      return ((Integer)paramAudioCapabilities.getUpper()).intValue();
    }
  }
  
  private int getMaxChannels(MediaCodecInfo.AudioCapabilities paramAudioCapabilities)
  {
    if (paramAudioCapabilities != null) {
      return paramAudioCapabilities.getMaxInputChannelCount();
    }
    return 2;
  }
  
  private int getMaxHeight(MediaCodecInfo.VideoCapabilities paramVideoCapabilities)
  {
    if (paramVideoCapabilities != null) {}
    for (paramVideoCapabilities = paramVideoCapabilities.getSupportedHeights();; paramVideoCapabilities = new Range(Integer.valueOf(0), Integer.valueOf(720))) {
      return ((Integer)paramVideoCapabilities.getUpper()).intValue();
    }
  }
  
  private int getMaxSampleRate(MediaCodecInfo.AudioCapabilities paramAudioCapabilities)
  {
    if (paramAudioCapabilities != null) {}
    for (paramAudioCapabilities = paramAudioCapabilities.getSupportedSampleRateRanges(); paramAudioCapabilities != null; paramAudioCapabilities = null) {
      return ((Integer)paramAudioCapabilities[(paramAudioCapabilities.length - 1)].getUpper()).intValue();
    }
    return 48000;
  }
  
  private final int getMaxSupportedFrameRate(MediaCodecInfo.VideoCapabilities paramVideoCapabilities)
  {
    if (paramVideoCapabilities == null) {
      return 30;
    }
    this.maxLumaWidth = ((Integer)paramVideoCapabilities.getSupportedWidthsFor(this.maxHeight).getUpper()).intValue();
    this.maxLumaHeight = ((Integer)paramVideoCapabilities.getSupportedHeightsFor(this.maxWidth).getUpper()).intValue();
    return ((Double)paramVideoCapabilities.getSupportedFrameRatesFor(this.maxWidth, this.maxLumaHeight).getUpper()).intValue();
  }
  
  private int getMaxSupportedInstances(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    if ((paramCodecCapabilities == null) || (Build.VERSION.SDK_INT < 23)) {
      return 1;
    }
    return paramCodecCapabilities.getMaxSupportedInstances();
  }
  
  private int getMaxWidth(MediaCodecInfo.VideoCapabilities paramVideoCapabilities)
  {
    if (paramVideoCapabilities != null) {}
    for (paramVideoCapabilities = paramVideoCapabilities.getSupportedWidths();; paramVideoCapabilities = new Range(Integer.valueOf(0), Integer.valueOf(1280))) {
      return ((Integer)paramVideoCapabilities.getUpper()).intValue();
    }
  }
  
  private boolean isAdaptive(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (Build.VERSION.SDK_INT >= 19) && (paramCodecCapabilities.isFeatureSupported("adaptive-playback"));
  }
  
  private boolean isAudioSoftwareOnly(String paramString)
  {
    if (paramString == null) {}
    for (paramString = ""; (paramString.startsWith("omx.google.")) || (paramString.startsWith("c2.android.")) || (paramString.startsWith("c2.google.")); paramString = paramString.toLowerCase()) {
      return true;
    }
    return false;
  }
  
  private boolean isSecure(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (Build.VERSION.SDK_INT >= 21) && (paramCodecCapabilities.isFeatureSupported("secure-playback"));
  }
  
  private boolean isTunneling(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (Build.VERSION.SDK_INT >= 21) && (paramCodecCapabilities.isFeatureSupported("tunneled-playback"));
  }
  
  private boolean isVideoSoftwareOnly(String paramString)
  {
    if (paramString == null) {}
    for (paramString = ""; (paramString.startsWith("omx.google.")) || (paramString.startsWith("omx.ffmpeg.")) || ((paramString.startsWith("omx.sec.")) && (paramString.contains(".sw."))) || (paramString.equals("omx.qcom.video.decoder.hevcswvdec")) || ((paramString.startsWith("omx.qti.video.decoder")) && (paramString.contains("sw"))) || (paramString.startsWith("c2.android.")) || (paramString.startsWith("c2.google.")); paramString = paramString.toLowerCase()) {
      return true;
    }
    return false;
  }
  
  private void reset()
  {
    this.decName = "";
    this.decMimeType = "";
    this.softwareVideoDec = false;
    this.softwareVideoDec = false;
    this.adaptiveDec = false;
    this.tunnelingDec = false;
    this.secureDec = false;
    this.profileLevels = null;
    this.colorFormats = null;
    this.maxSupportedInstances = 0;
    this.maxLumaFrameRate = 30;
    this.maxFrameRate = 30;
    this.maxWidth = 1280;
    this.maxHeight = 720;
    this.maxLumaWidth = 1280;
    this.maxLumaHeight = 720;
    this.maxSampleRate = 48000;
    this.maxBitRate = 960000;
    this.maxChannels = 2;
  }
  
  public int[] getColorFormats()
  {
    return this.colorFormats;
  }
  
  public int getDecoderLumaHeight()
  {
    return this.maxLumaHeight;
  }
  
  public int getDecoderLumaWidth()
  {
    return this.maxLumaWidth;
  }
  
  public int getDecoderMaxFrameRate()
  {
    return this.maxFrameRate;
  }
  
  public int getDecoderMaxFrameRateForMaxLuma()
  {
    return this.maxLumaFrameRate;
  }
  
  public int getDecoderMaxHeight()
  {
    return this.maxHeight;
  }
  
  public int getDecoderMaxWidth()
  {
    return this.maxWidth;
  }
  
  public String getDecoderMimeType()
  {
    return this.decMimeType;
  }
  
  public String getDecoderName()
  {
    return this.decName;
  }
  
  public int getMaxAudioBitRate()
  {
    return this.maxBitRate;
  }
  
  public int getMaxAudioChannels()
  {
    return this.maxChannels;
  }
  
  public int getMaxAudioSampleRate()
  {
    return this.maxSampleRate;
  }
  
  public DecoderProfileLevel getMaxProfileLevel()
  {
    Object localObject = new DecoderProfileLevel(0, 0);
    DecoderProfileLevel[] arrayOfDecoderProfileLevel = this.profileLevels;
    int k = arrayOfDecoderProfileLevel.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      DecoderProfileLevel localDecoderProfileLevel = arrayOfDecoderProfileLevel[j];
      if (localDecoderProfileLevel.level < i) {
        break label66;
      }
      i = localDecoderProfileLevel.level;
      localObject = localDecoderProfileLevel;
    }
    label66:
    for (;;)
    {
      j += 1;
      break;
      return localObject;
    }
  }
  
  public int getMaxSupportedInstances()
  {
    return this.maxSupportedInstances;
  }
  
  public DecoderProfileLevel[] getProfileLevels()
  {
    return this.profileLevels;
  }
  
  public boolean isAudio()
  {
    if (this.decMimeType == null) {
      return false;
    }
    return this.decMimeType.startsWith("audio/");
  }
  
  public boolean isAudioSofwareDecoder()
  {
    return this.softwareAudioDec;
  }
  
  public boolean isSecureDecoder()
  {
    return this.secureDec;
  }
  
  public boolean isVideo()
  {
    if (this.decMimeType == null) {
      return false;
    }
    return this.decMimeType.startsWith("video/");
  }
  
  public boolean isVideoSofwareDecoder()
  {
    return this.softwareVideoDec;
  }
  
  final class DecoderProfileLevel
    implements Serializable
  {
    public int level;
    public int profile;
    
    public DecoderProfileLevel(int paramInt1, int paramInt2)
    {
      this.profile = paramInt1;
      this.level = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPMediaDecoderInfo
 * JD-Core Version:    0.7.0.1
 */