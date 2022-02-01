package com.tencent.qqmail.activity.media;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.timer.TextChangeTimer;
import java.util.List;

class MediaBucketGridActivity$8
  implements AbsListView.OnScrollListener
{
  MediaBucketGridActivity$8(MediaBucketGridActivity paramMediaBucketGridActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((MediaBucketGridActivity.access$1500(this.this$0)) || (MediaBucketGridActivity.access$1800(this.this$0) != paramInt1) || (MediaBucketGridActivity.access$1900(this.this$0) != paramInt2))
    {
      MediaBucketGridActivity.access$1402(this.this$0, true);
      MediaBucketGridActivity.access$1802(this.this$0, paramInt1);
      MediaBucketGridActivity.access$1902(this.this$0, paramInt2);
      if ((MediaBucketGridActivity.access$2000(this.this$0)) && (MediaBucketGridActivity.access$2100(this.this$0) != null) && (MediaBucketGridActivity.access$2100(this.this$0).size() != 0))
      {
        paramAbsListView = (MediaItemInfo)MediaBucketGridActivity.access$700(this.this$0).getItem(MediaBucketGridActivity.access$1800(this.this$0));
        MediaBucketGridActivity.access$2200(this.this$0, paramAbsListView.getModifyDate());
      }
      MediaBucketGridActivity.access$2002(this.this$0, true);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((paramInt == 0) || (paramInt == 1))
    {
      MediaBucketGridActivity.access$700(this.this$0).setCanLoadImage(true);
      if (MediaBucketGridActivity.access$1400(this.this$0))
      {
        MediaBucketGridActivity.access$1402(this.this$0, false);
        MediaBucketGridActivity.access$700(this.this$0).notifyDataSetChanged();
      }
      if (paramInt == 1) {
        MediaBucketGridActivity.access$1502(this.this$0, true);
      }
      if (paramInt == 0)
      {
        MediaBucketGridActivity.access$1700(this.this$0).startTextChangedTimer(MediaBucketGridActivity.access$1600(this.this$0));
        MediaBucketGridActivity.access$1502(this.this$0, false);
      }
      return;
    }
    MediaBucketGridActivity.access$1502(this.this$0, true);
    MediaBucketGridActivity.access$700(this.this$0).setCanLoadImage(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaBucketGridActivity.8
 * JD-Core Version:    0.7.0.1
 */