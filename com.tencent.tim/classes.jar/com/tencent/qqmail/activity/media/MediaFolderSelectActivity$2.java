package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MediaFolderSelectActivity$2
  implements View.OnClickListener
{
  MediaFolderSelectActivity$2(MediaFolderSelectActivity paramMediaFolderSelectActivity) {}
  
  public void onClick(View paramView)
  {
    MediaFolderSelectActivity.access$000(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaFolderSelectActivity.2
 * JD-Core Version:    0.7.0.1
 */