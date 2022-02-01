package com.tencent.qqmail.activity.media;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MeidaBigBucketSelectActivity$7
  implements View.OnClickListener
{
  MeidaBigBucketSelectActivity$7(MeidaBigBucketSelectActivity paramMeidaBigBucketSelectActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onButtonBackClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MeidaBigBucketSelectActivity.7
 * JD-Core Version:    0.7.0.1
 */