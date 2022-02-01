package com.tencent.qqmail.activity.media;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.QMApplicationContext;

class MediaBucketGridAdapter$1
  implements View.OnClickListener
{
  MediaBucketGridAdapter$1(MediaBucketGridAdapter paramMediaBucketGridAdapter, int paramInt, CheckBox paramCheckBox) {}
  
  public void onClick(View paramView)
  {
    int i = this.val$position - this.this$0.getCameraCnt();
    if ((MediaBucketGridAdapter.access$100(this.this$0) != null) && (!MediaBucketGridAdapter.access$100(this.this$0).canCheck(i, MediaBucketGridAdapter.access$200(this.this$0)[i]))) {
      this.val$checkBox.setChecked(false);
    }
    View localView;
    boolean bool;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localView = (View)paramView.getTag();
      bool = this.this$0.toggleItem(i);
      if (MediaBucketGridAdapter.access$100(this.this$0) != null) {
        MediaBucketGridAdapter.access$100(this.this$0).onClick(i, bool);
      }
    } while (localView == null);
    Resources localResources = QMApplicationContext.sharedInstance().getResources();
    if (bool) {}
    for (i = 2131165966;; i = 2131167595)
    {
      localView.setBackgroundColor(localResources.getColor(i));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaBucketGridAdapter.1
 * JD-Core Version:    0.7.0.1
 */