package com.tencent.qqmail.popularize.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.popularize.model.Popularize;

class PopularizeBannerView$2
  implements View.OnClickListener
{
  PopularizeBannerView$2(PopularizeBannerView paramPopularizeBannerView, int paramInt, Popularize paramPopularize) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.getOnBannerCancelListener() != null) {
      this.this$0.getOnBannerCancelListener().onCancel(this.val$position, this.val$popularize, paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeBannerView.2
 * JD-Core Version:    0.7.0.1
 */