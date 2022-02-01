package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MediaFolderSelectActivity$3
  implements View.OnClickListener
{
  MediaFolderSelectActivity$3(MediaFolderSelectActivity paramMediaFolderSelectActivity) {}
  
  public void onClick(View paramView)
  {
    MediaFolderSelectActivity.access$100(this.this$0, (AbsListView)this.this$0.findViewById(2131368833));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaFolderSelectActivity.3
 * JD-Core Version:    0.7.0.1
 */