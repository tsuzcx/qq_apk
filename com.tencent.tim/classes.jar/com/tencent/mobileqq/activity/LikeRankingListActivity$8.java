package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import auvn;
import com.tencent.widget.PullToZoomListView;

class LikeRankingListActivity$8
  implements Runnable
{
  LikeRankingListActivity$8(LikeRankingListActivity paramLikeRankingListActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    auvn localauvn = new auvn(this.this$0, this.val$bitmap, this.this$0.qp.getWidth(), this.this$0.qp.getHeight());
    this.this$0.qp.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.this$0.qp.setImageDrawable(localauvn);
    localauvn.start();
    this.this$0.a.Wi(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.8
 * JD-Core Version:    0.7.0.1
 */