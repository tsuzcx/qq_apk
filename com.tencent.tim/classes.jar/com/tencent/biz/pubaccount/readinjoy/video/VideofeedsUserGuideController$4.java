package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import mzn;
import wja;

public class VideofeedsUserGuideController$4
  implements Runnable
{
  public VideofeedsUserGuideController$4(mzn parammzn) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = mzn.b(this.this$0);
    if (localTranslateAnimation != null)
    {
      mzn.a(this.this$0).setVisibility(0);
      mzn.a(this.this$0).findViewById(2131381403).setVisibility(0);
      mzn.a(this.this$0).findViewById(2131381397).setVisibility(0);
      mzn.a(this.this$0).findViewById(2131381398).setVisibility(0);
      mzn.a(this.this$0).bringToFront();
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)mzn.a(this.this$0).getLayoutParams();
      localMarginLayoutParams.setMargins(0, 0, 0, wja.dp2px(187.0F, mzn.a(this.this$0).getResources()));
      mzn.a(this.this$0).setLayoutParams(localMarginLayoutParams);
      mzn.a(this.this$0).startAnimation(localTranslateAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideofeedsUserGuideController.4
 * JD-Core Version:    0.7.0.1
 */