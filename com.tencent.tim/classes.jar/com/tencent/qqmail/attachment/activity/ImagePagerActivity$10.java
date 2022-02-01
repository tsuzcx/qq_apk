package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.ftn.util.FtnDialogUtils;

class ImagePagerActivity$10
  implements View.OnClickListener
{
  ImagePagerActivity$10(ImagePagerActivity paramImagePagerActivity) {}
  
  public void onClick(View paramView)
  {
    ImagePagerActivity.access$1800(this.this$0, paramView);
    ImagePagerActivity.access$1902(this.this$0, FtnDialogUtils.createDeleteConfirmDialog(this.this$0, ImagePagerActivity.access$2000(this.this$0), ImagePagerActivity.access$2100(this.this$0)));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.10
 * JD-Core Version:    0.7.0.1
 */