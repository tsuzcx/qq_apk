package com.tencent.thumbplayer.adapter.player;

import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;

public abstract interface ITPCapture
{
  public abstract void generateImageAsyncAtTime(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, TPCaptureCallBack paramTPCaptureCallBack);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.ITPCapture
 * JD-Core Version:    0.7.0.1
 */