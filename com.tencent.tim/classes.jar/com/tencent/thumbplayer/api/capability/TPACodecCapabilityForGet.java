package com.tencent.thumbplayer.api.capability;

public class TPACodecCapabilityForGet
{
  private int maxBitrate;
  private int maxChannels;
  private int maxLevel;
  private int maxProfile;
  private int maxSamplerate;
  
  public TPACodecCapabilityForGet(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.maxSamplerate = paramInt1;
    this.maxChannels = paramInt2;
    this.maxBitrate = paramInt3;
    this.maxProfile = paramInt4;
    this.maxLevel = paramInt5;
  }
  
  public int getMaxBitrate()
  {
    return this.maxBitrate;
  }
  
  public int getMaxChannels()
  {
    return this.maxChannels;
  }
  
  public int getMaxLevel()
  {
    return this.maxLevel;
  }
  
  public int getMaxProfile()
  {
    return this.maxProfile;
  }
  
  public int getMaxSamplerate()
  {
    return this.maxSamplerate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.capability.TPACodecCapabilityForGet
 * JD-Core Version:    0.7.0.1
 */