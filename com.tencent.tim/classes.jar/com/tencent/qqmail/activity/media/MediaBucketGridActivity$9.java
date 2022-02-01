package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MediaBucketGridActivity$9
  implements View.OnClickListener
{
  MediaBucketGridActivity$9(MediaBucketGridActivity paramMediaBucketGridActivity) {}
  
  public void onClick(View paramView)
  {
    MediaBucketGridActivity.access$400(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaBucketGridActivity.9
 * JD-Core Version:    0.7.0.1
 */