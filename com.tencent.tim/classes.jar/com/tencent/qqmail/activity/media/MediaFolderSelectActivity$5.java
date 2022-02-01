package com.tencent.qqmail.activity.media;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MediaFolderSelectActivity$5
  implements AbsListView.OnScrollListener
{
  MediaFolderSelectActivity$5(MediaFolderSelectActivity paramMediaFolderSelectActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((MediaFolderSelectActivity.access$800(this.this$0) != paramInt1) || (MediaFolderSelectActivity.access$900(this.this$0) != paramInt2))
    {
      MediaFolderSelectActivity.access$702(this.this$0, true);
      MediaFolderSelectActivity.access$802(this.this$0, paramInt1);
      MediaFolderSelectActivity.access$902(this.this$0, paramInt2);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((paramInt == 0) || (paramInt == 1))
    {
      MediaFolderSelectActivity.access$600(this.this$0).setCanLoadImage(true);
      if (MediaFolderSelectActivity.access$700(this.this$0))
      {
        MediaFolderSelectActivity.access$702(this.this$0, false);
        MediaFolderSelectActivity.access$600(this.this$0).notifyDataSetChanged();
      }
      return;
    }
    MediaFolderSelectActivity.access$600(this.this$0).setCanLoadImage(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaFolderSelectActivity.5
 * JD-Core Version:    0.7.0.1
 */