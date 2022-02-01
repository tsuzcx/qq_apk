package com.tencent.qqmail.popularize.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PopularizeBannerItemView$1
  implements View.OnClickListener
{
  PopularizeBannerItemView$1(PopularizeBannerItemView paramPopularizeBannerItemView, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.val$onImageClickListener != null) {
      this.val$onImageClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeBannerItemView.1
 * JD-Core Version:    0.7.0.1
 */