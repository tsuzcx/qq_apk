package com.tencent.moai.nativepages;

import android.view.Window;
import android.widget.ImageView;
import com.tencent.moai.nativepages.view.PagesScrollView;

class AdLandingPagesUI$6$1
  implements AdLandingPagesPreviewAnimation.ICallback
{
  AdLandingPagesUI$6$1(AdLandingPagesUI.6 param6) {}
  
  public void onAnimationEnd()
  {
    AdLandingPagesUI.access$500(this.this$1.this$0).setVisibility(0);
    AdLandingPagesUI.access$600(this.this$1.this$0).setVisibility(0);
    AdLandingPagesUI.access$700(this.this$1.this$0).setVisibility(0);
    this.this$1.this$0.getWindow().setFlags(1024, 1024);
    this.this$1.this$0.setRequestedOrientation(1);
    AdLandingPagesUI.access$300(this.this$1.this$0);
    AdLandingPagesUI.access$800(this.this$1.this$0).post(new AdLandingPagesUI.6.1.1(this));
  }
  
  public void onAnimationStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesUI.6.1
 * JD-Core Version:    0.7.0.1
 */