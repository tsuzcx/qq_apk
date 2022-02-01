package com.tencent.superplayer.capture;

import com.tencent.superplayer.api.ISPlayerImageGenerator;
import com.tencent.superplayer.api.ISPlayerImageGenerator.ImageGeneratorParams;
import com.tencent.superplayer.api.ISPlayerImageGenerator.Listener;
import com.tencent.thumbplayer.caputure.TPThumbCapture;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;

public class SPlayerImageGenerator
  implements ISPlayerImageGenerator
{
  private TPThumbCapture mTPThumbCapture;
  
  public SPlayerImageGenerator(String paramString)
  {
    this.mTPThumbCapture = new TPThumbCapture(paramString);
  }
  
  public void generateImageAsyncAtTime(long paramLong, ISPlayerImageGenerator.ImageGeneratorParams paramImageGeneratorParams, ISPlayerImageGenerator.Listener paramListener)
  {
    TPImageGeneratorParams localTPImageGeneratorParams = null;
    if (paramImageGeneratorParams != null)
    {
      localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = paramImageGeneratorParams.width;
      localTPImageGeneratorParams.height = paramImageGeneratorParams.height;
      localTPImageGeneratorParams.format = 37;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = paramImageGeneratorParams.requestedTimeMsToleranceAfter;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = paramImageGeneratorParams.requestedTimeMsToleranceBefore;
    }
    this.mTPThumbCapture.generateImageAsyncAtTime(paramLong, localTPImageGeneratorParams, new SPlayerImageGenerator.1(this, paramListener));
  }
  
  public void release()
  {
    this.mTPThumbCapture.release();
    this.mTPThumbCapture = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.capture.SPlayerImageGenerator
 * JD-Core Version:    0.7.0.1
 */