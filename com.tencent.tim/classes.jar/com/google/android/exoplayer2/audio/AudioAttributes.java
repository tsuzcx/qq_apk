package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;

public final class AudioAttributes
{
  public static final AudioAttributes DEFAULT = new Builder().build();
  private android.media.AudioAttributes audioAttributesV21;
  public final int contentType;
  public final int flags;
  public final int usage;
  
  private AudioAttributes(int paramInt1, int paramInt2, int paramInt3)
  {
    this.contentType = paramInt1;
    this.flags = paramInt2;
    this.usage = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (AudioAttributes)paramObject;
    } while ((this.contentType == paramObject.contentType) && (this.flags == paramObject.flags) && (this.usage == paramObject.usage));
    return false;
  }
  
  @TargetApi(21)
  android.media.AudioAttributes getAudioAttributesV21()
  {
    if (this.audioAttributesV21 == null) {
      this.audioAttributesV21 = new android.media.AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.usage).build();
    }
    return this.audioAttributesV21;
  }
  
  public int hashCode()
  {
    return ((this.contentType + 527) * 31 + this.flags) * 31 + this.usage;
  }
  
  public static final class Builder
  {
    private int contentType = 0;
    private int flags = 0;
    private int usage = 1;
    
    public AudioAttributes build()
    {
      return new AudioAttributes(this.contentType, this.flags, this.usage, null);
    }
    
    public Builder setContentType(int paramInt)
    {
      this.contentType = paramInt;
      return this;
    }
    
    public Builder setFlags(int paramInt)
    {
      this.flags = paramInt;
      return this;
    }
    
    public Builder setUsage(int paramInt)
    {
      this.usage = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioAttributes
 * JD-Core Version:    0.7.0.1
 */