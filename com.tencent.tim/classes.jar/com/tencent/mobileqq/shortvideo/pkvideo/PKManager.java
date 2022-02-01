package com.tencent.mobileqq.shortvideo.pkvideo;

import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder;

public class PKManager
{
  HWVideoDecoder leftDecoder;
  HWVideoDecoder rightDecoder;
  
  public PKManager(HWVideoDecoder paramHWVideoDecoder1, HWVideoDecoder paramHWVideoDecoder2)
  {
    this.leftDecoder = paramHWVideoDecoder1;
    paramHWVideoDecoder1.setPKManager(this);
    if (paramHWVideoDecoder2 != null)
    {
      this.rightDecoder = paramHWVideoDecoder2;
      paramHWVideoDecoder2.setPKManager(this);
    }
  }
  
  public long getSyncDecodeTimeUs()
  {
    if (this.rightDecoder == null) {
      return this.leftDecoder.getProgress();
    }
    return Math.min(this.rightDecoder.getProgress(), this.leftDecoder.getProgress());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.pkvideo.PKManager
 * JD-Core Version:    0.7.0.1
 */