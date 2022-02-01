package com.tencent.mobileqq.activity.qwallet.emoj;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class EmojiRedPackPreviewFragment$1
  implements OnCompositionLoadedListener
{
  EmojiRedPackPreviewFragment$1(EmojiRedPackPreviewFragment paramEmojiRedPackPreviewFragment) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    localLottieDrawable.playAnimation();
    if (this.this$0.imgLottie != null) {
      this.this$0.imgLottie.setImageDrawable(localLottieDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiRedPackPreviewFragment.1
 * JD-Core Version:    0.7.0.1
 */