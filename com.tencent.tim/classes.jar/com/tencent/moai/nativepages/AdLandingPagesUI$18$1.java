package com.tencent.moai.nativepages;

import android.widget.ImageView;
import com.tencent.moai.nativepages.util.Threads;

class AdLandingPagesUI$18$1
  implements AdLandingPagesPreviewAnimation.ICallback
{
  AdLandingPagesUI$18$1(AdLandingPagesUI.18 param18) {}
  
  public void onAnimationEnd()
  {
    Threads.runOnMainThread(new AdLandingPagesUI.18.1.1(this));
  }
  
  public void onAnimationStart()
  {
    AdLandingPagesUI.access$500(this.this$1.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesUI.18.1
 * JD-Core Version:    0.7.0.1
 */