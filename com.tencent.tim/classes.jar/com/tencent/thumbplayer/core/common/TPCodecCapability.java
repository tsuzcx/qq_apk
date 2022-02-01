package com.tencent.thumbplayer.core.common;

import java.io.Serializable;

public abstract interface TPCodecCapability
{
  public static final int DEFAULT_FRAMERATE = 30;
  public static final int DEFAULT_INVALID_PARAMETER = -1;
  
  public static class TPACodecPropertyRange
    implements Serializable
  {
    public int level;
    public int lowerboundBitRate;
    public int lowerboundChannels;
    public int lowerboundSampleRate;
    public int profile;
    public int upperboundBitRate;
    public int upperboundChannels;
    public int upperboundSampleRate;
    
    public void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      this.upperboundSampleRate = paramInt1;
      this.upperboundChannels = paramInt2;
      this.upperboundBitRate = paramInt3;
      this.lowerboundSampleRate = paramInt4;
      this.lowerboundChannels = paramInt5;
      this.lowerboundBitRate = paramInt6;
      this.profile = paramInt7;
      this.level = paramInt8;
    }
  }
  
  public static class TPCodecMaxCapability
    implements Serializable
  {
    public int maxBitRate;
    public int maxChannels;
    public int maxFramerateFormaxLumaSamples;
    public int maxLevel;
    public int maxLumaSamples;
    public int maxProfile;
    public int maxSampleRate;
    
    @Deprecated
    TPCodecMaxCapability(int paramInt1, int paramInt2, int paramInt3)
    {
      this.maxLumaSamples = paramInt1;
      this.maxProfile = paramInt2;
      this.maxLevel = paramInt3;
      this.maxFramerateFormaxLumaSamples = 30;
      this.maxBitRate = -1;
      this.maxSampleRate = -1;
      this.maxChannels = -1;
    }
    
    TPCodecMaxCapability(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.maxLumaSamples = paramInt1;
      this.maxProfile = paramInt2;
      this.maxLevel = paramInt3;
      this.maxFramerateFormaxLumaSamples = paramInt4;
      this.maxBitRate = -1;
      this.maxSampleRate = -1;
      this.maxChannels = -1;
    }
    
    TPCodecMaxCapability(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.maxProfile = paramInt1;
      this.maxLevel = paramInt2;
      this.maxBitRate = paramInt4;
      this.maxSampleRate = paramInt3;
      this.maxChannels = paramInt5;
      this.maxLumaSamples = -1;
      this.maxFramerateFormaxLumaSamples = -1;
    }
  }
  
  public static class TPHdrSupportVersionRange
    implements Serializable
  {
    public int lowerboundPatchVersion;
    public int lowerboundSystemVersion;
    public int upperboundPatchVersion;
    public int upperboundSystemVersion;
    
    public TPHdrSupportVersionRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.upperboundSystemVersion = paramInt1;
      this.lowerboundSystemVersion = paramInt2;
      this.upperboundPatchVersion = paramInt3;
      this.lowerboundPatchVersion = paramInt4;
    }
  }
  
  public static class TPVCodecPropertyRange
    implements Serializable
  {
    public int level;
    public int lowerboundHeight;
    public int lowerboundWidth;
    public int profile;
    public int upperboundHeight;
    public int upperboundWidth;
    
    public void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.upperboundWidth = paramInt1;
      this.upperboundHeight = paramInt2;
      this.lowerboundWidth = paramInt3;
      this.lowerboundHeight = paramInt4;
      this.profile = paramInt5;
      this.level = paramInt6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPCodecCapability
 * JD-Core Version:    0.7.0.1
 */