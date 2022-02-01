package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MediaBucketGridActivity$4
  implements View.OnClickListener
{
  MediaBucketGridActivity$4(MediaBucketGridActivity paramMediaBucketGridActivity) {}
  
  public void onClick(View paramView)
  {
    MediaBucketGridActivity.access$300(this.this$0, (AbsListView)this.this$0.findViewById(2131368833));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaBucketGridActivity.4
 * JD-Core Version:    0.7.0.1
 */