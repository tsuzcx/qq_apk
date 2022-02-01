package com.tencent.mobileqq.activity;

import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.widget.PullToZoomListView;

class LikeRankingListActivity$7
  implements Runnable
{
  LikeRankingListActivity$7(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void run()
  {
    if (this.this$0.mCoverUrl == null) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestHeight = this.this$0.mCoverHeight;
    localURLDrawableOptions.mRequestWidth = this.this$0.mCoverWidth;
    this.this$0.qp.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.this$0.qp.setImageDrawable(URLDrawable.getDrawable(this.this$0.mCoverUrl, localURLDrawableOptions));
    this.this$0.a.Wi(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.7
 * JD-Core Version:    0.7.0.1
 */