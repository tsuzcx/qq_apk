package com.tencent.mobileqq.dinifly;

import android.content.Context;
import com.tencent.mobileqq.dinifly.network.NetworkFetcher;
import java.util.concurrent.Callable;

final class LottieCompositionFactory$1
  implements Callable<LottieResult<LottieComposition>>
{
  LottieCompositionFactory$1(Context paramContext, String paramString) {}
  
  public LottieResult<LottieComposition> call()
  {
    return NetworkFetcher.fetchSync(this.val$context, this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory.1
 * JD-Core Version:    0.7.0.1
 */