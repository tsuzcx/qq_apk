package com.tencent.biz.pubaccount.readinjoy.drawable;

import android.support.v4.util.LruCache;
import com.tencent.mobileqq.dinifly.LottieComposition;
import java.io.File;
import lae;
import lah;

public class ReadInJoyLottieDrawable$3
  implements Runnable
{
  public ReadInJoyLottieDrawable$3(lae paramlae, File paramFile, File[] paramArrayOfFile) {}
  
  public void run()
  {
    LottieComposition localLottieComposition = (LottieComposition)lae.a().get(this.C.getAbsolutePath());
    if (localLottieComposition != null)
    {
      lah locallah = new lah(this);
      this.this$0.setImageAssetDelegate(locallah);
      this.this$0.setComposition(localLottieComposition);
      this.this$0.loop(true);
      this.this$0.playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.3
 * JD-Core Version:    0.7.0.1
 */