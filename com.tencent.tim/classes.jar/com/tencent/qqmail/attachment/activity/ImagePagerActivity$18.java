package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;

class ImagePagerActivity$18
  implements View.OnClickListener
{
  ImagePagerActivity$18(ImagePagerActivity paramImagePagerActivity) {}
  
  public void onClick(View paramView)
  {
    ImagePagerActivity.access$4100(this.this$0, ((Integer)paramView.getTag()).intValue());
    ImagePagerActivity.access$1900(this.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.18
 * JD-Core Version:    0.7.0.1
 */