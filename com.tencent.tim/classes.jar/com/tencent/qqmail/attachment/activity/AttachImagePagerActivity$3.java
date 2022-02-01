package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AttachImagePagerActivity$3
  implements View.OnClickListener
{
  AttachImagePagerActivity$3(AttachImagePagerActivity paramAttachImagePagerActivity) {}
  
  public void onClick(View paramView)
  {
    AttachImagePagerActivity.access$100(this.this$0, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.AttachImagePagerActivity.3
 * JD-Core Version:    0.7.0.1
 */