package com.tencent.thumbplayer.api.capability;

public class TPACodecCapabilityForSet
{
  private int level;
  private int lowerboundBitrate;
  private int lowerboundChannels;
  private int lowerboundSamplerate;
  private int profile;
  private int upperboundBitrate;
  private int upperboundChannels;
  private int upperboundSamplerate;
  
  public TPACodecCapabilityForSet(int paramInt1, int paramInt2, int paramInt3)
  {
    this.upperboundSamplerate = paramInt1;
    this.upperboundChannels = paramInt2;
    this.upperboundBitrate = paramInt3;
    this.lowerboundSamplerate = 0;
    this.lowerboundChannels = 0;
    this.lowerboundBitrate = 0;
    this.profile = 0;
    this.level = 0;
  }
  
  public TPACodecCapabilityForSet(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.upperboundSamplerate = paramInt1;
    this.upperboundChannels = paramInt2;
    this.upperboundBitrate = paramInt3;
    this.lowerboundSamplerate = paramInt4;
    this.lowerboundChannels = paramInt5;
    this.lowerboundBitrate = paramInt6;
    this.profile = paramInt7;
    this.level = paramInt8;
  }
  
  public int getLevelForSet()
  {
    return this.level;
  }
  
  public int getLowerboundBitrate()
  {
    return this.lowerboundBitrate;
  }
  
  public int getLowerboundChannels()
  {
    return this.lowerboundChannels;
  }
  
  public int getLowerboundSamplerate()
  {
    return this.lowerboundSamplerate;
  }
  
  public int getProfileForSet()
  {
    return this.profile;
  }
  
  public int getUpperboundBitrate()
  {
    return this.upperboundBitrate;
  }
  
  public int getUpperboundChannels()
  {
    return this.upperboundChannels;
  }
  
  public int getUpperboundSamplerate()
  {
    return this.upperboundSamplerate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.capability.TPACodecCapabilityForSet
 * JD-Core Version:    0.7.0.1
 */