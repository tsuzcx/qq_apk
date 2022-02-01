package com.tencent.qqmail.popularize.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.popularize.model.Popularize;

class PopularizeBannerView$1
  implements View.OnClickListener
{
  PopularizeBannerView$1(PopularizeBannerView paramPopularizeBannerView, int paramInt, Popularize paramPopularize) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.getOnBannerClickListener() != null) {
      this.this$0.getOnBannerClickListener().onItemClick(this.val$position, this.val$popularize, paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeBannerView.1
 * JD-Core Version:    0.7.0.1
 */