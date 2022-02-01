package com.tencent.qqmail.popularize.view;

import android.view.View;
import com.tencent.qqmail.animation.PopularizeCancelAnimator;
import com.tencent.qqmail.popularize.model.Popularize;

class PopularizeBanner$2
  implements PopularizeBannerView.OnBannerItemCancelListener
{
  PopularizeBanner$2(PopularizeBanner paramPopularizeBanner) {}
  
  public void onCancel(int paramInt, Popularize paramPopularize, View paramView)
  {
    PopularizeUIHelper.handleCancel(paramPopularize);
    PopularizeBannerView localPopularizeBannerView = PopularizeBanner.access$100(this.this$0);
    PopularizeBanner.2.1 local1 = new PopularizeBanner.2.1(this);
    PopularizeCancelAnimator.animateRemoval(localPopularizeBannerView, new int[] { paramInt }, local1);
    if (PopularizeBanner.access$400(this.this$0) != null) {
      PopularizeBanner.access$400(this.this$0).onCancel(paramInt, paramPopularize, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeBanner.2
 * JD-Core Version:    0.7.0.1
 */