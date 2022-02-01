package com.tencent.moai.nativepages;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;

class AdLandingPagesPreviewAnimation$3
  extends ScaleAnimation
{
  AdLandingPagesPreviewAnimation$3(AdLandingPagesPreviewAnimation paramAdLandingPagesPreviewAnimation, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, View paramView, AdLandingPagesPreviewAnimation.ClipCallback paramClipCallback)
  {
    super(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    int n;
    int k;
    int i;
    int j;
    if ((AdLandingPagesPreviewAnimation.access$600(this.this$0) != 0) && (AdLandingPagesPreviewAnimation.access$700(this.this$0) != 0))
    {
      Rect localRect = new Rect();
      this.val$gallery.getGlobalVisibleRect(localRect);
      n = (localRect.right - localRect.left) / 2;
      k = (localRect.bottom - localRect.top + AdLandingPagesPreviewAnimation.access$800(this.this$0)) / 2;
      int i1 = (int)(((AdLandingPagesPreviewAnimation.access$600(this.this$0) - AdLandingPagesPreviewAnimation.access$900(this.this$0)) * (1.0F - paramFloat) + AdLandingPagesPreviewAnimation.access$900(this.this$0)) / (1.0F - (1.0F - AdLandingPagesPreviewAnimation.access$1000(this.this$0)) * paramFloat));
      int m = (int)(((AdLandingPagesPreviewAnimation.access$700(this.this$0) - AdLandingPagesPreviewAnimation.access$1100(this.this$0)) * (1.0F - paramFloat) + AdLandingPagesPreviewAnimation.access$1100(this.this$0)) / (1.0F - (1.0F - AdLandingPagesPreviewAnimation.access$1000(this.this$0)) * paramFloat));
      i = (int)(n - i1 / 2 + AdLandingPagesPreviewAnimation.access$1200(this.this$0) * paramFloat / (1.0F - (1.0F - AdLandingPagesPreviewAnimation.access$1000(this.this$0)) * paramFloat));
      j = (int)(k - m / 2 - AdLandingPagesPreviewAnimation.access$800(this.this$0) * (1.0F - paramFloat) / 2.0F + AdLandingPagesPreviewAnimation.access$1300(this.this$0) * paramFloat / (1.0F - (1.0F - AdLandingPagesPreviewAnimation.access$1000(this.this$0)) * paramFloat));
      n = (int)(n + i1 / 2 - AdLandingPagesPreviewAnimation.access$1400(this.this$0) * paramFloat / (1.0F - (1.0F - AdLandingPagesPreviewAnimation.access$1000(this.this$0)) * paramFloat));
      k = (int)(k + m / 2 - AdLandingPagesPreviewAnimation.access$1500(this.this$0) * paramFloat / (1.0F - (1.0F - AdLandingPagesPreviewAnimation.access$1000(this.this$0)) * paramFloat));
      if (Build.VERSION.SDK_INT < 21) {
        break label363;
      }
      this.val$gallery.setClipBounds(new Rect(i, j, n, k));
    }
    for (;;)
    {
      super.applyTransformation(paramFloat, paramTransformation);
      return;
      label363:
      if (Build.VERSION.SDK_INT >= 18) {
        if (this.val$clipCallback != null) {
          this.val$clipCallback.setClip(i, j, n, k);
        } else {
          this.val$gallery.setClipBounds(new Rect(i + this.val$gallery.getScrollX(), j, n + this.val$gallery.getScrollX(), k));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.AdLandingPagesPreviewAnimation.3
 * JD-Core Version:    0.7.0.1
 */