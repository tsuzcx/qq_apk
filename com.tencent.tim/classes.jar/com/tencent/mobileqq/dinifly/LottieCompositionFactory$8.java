package com.tencent.mobileqq.dinifly;

import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

final class LottieCompositionFactory$8
  implements Callable<LottieResult<LottieComposition>>
{
  LottieCompositionFactory$8(ZipInputStream paramZipInputStream, String paramString) {}
  
  public LottieResult<LottieComposition> call()
  {
    return LottieCompositionFactory.fromZipStreamSync(this.val$inputStream, this.val$cacheKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory.8
 * JD-Core Version:    0.7.0.1
 */