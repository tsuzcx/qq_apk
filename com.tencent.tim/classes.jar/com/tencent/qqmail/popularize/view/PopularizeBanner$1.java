package com.tencent.qqmail.popularize.view;

import android.content.Context;
import android.view.View;
import com.tencent.qqmail.popularize.model.Popularize;

class PopularizeBanner$1
  implements PopularizeBannerView.OnBannerItemClickListener
{
  PopularizeBanner$1(PopularizeBanner paramPopularizeBanner, Context paramContext) {}
  
  public void onItemClick(int paramInt, Popularize paramPopularize, View paramView)
  {
    PopularizeUIHelper.handleActionAndGotoLink(this.val$context, paramPopularize);
    if (PopularizeBanner.access$000(this.this$0) != null) {
      PopularizeBanner.access$000(this.this$0).onItemClick(paramInt, paramPopularize, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeBanner.1
 * JD-Core Version:    0.7.0.1
 */