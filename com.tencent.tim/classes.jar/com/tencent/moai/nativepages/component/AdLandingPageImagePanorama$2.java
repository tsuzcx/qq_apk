package com.tencent.moai.nativepages.component;

import android.widget.ImageView;
import com.tencent.moai.nativepages.view.LockedHorizonScrollView;

class AdLandingPageImagePanorama$2
  implements Runnable
{
  AdLandingPageImagePanorama$2(AdLandingPageImagePanorama paramAdLandingPageImagePanorama, int paramInt) {}
  
  public void run()
  {
    int i = AdLandingPageImagePanorama.access$000(this.this$0).getMeasuredWidth();
    if (i > this.val$screenWidth)
    {
      AdLandingPageImagePanorama.access$102(this.this$0, (i - this.val$screenWidth) / 2);
      AdLandingPageImagePanorama.access$200(this.this$0).scrollBy(AdLandingPageImagePanorama.access$100(this.this$0), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.component.AdLandingPageImagePanorama.2
 * JD-Core Version:    0.7.0.1
 */