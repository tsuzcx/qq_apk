package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MediaBucketGridActivity$2
  implements View.OnClickListener
{
  MediaBucketGridActivity$2(MediaBucketGridActivity paramMediaBucketGridActivity) {}
  
  public void onClick(View paramView)
  {
    MediaBucketGridActivity.access$100(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaBucketGridActivity.2
 * JD-Core Version:    0.7.0.1
 */