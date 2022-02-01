package com.tencent.qqmail.attachment.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class ImagePagerActivity$13$1
  implements DialogInterface.OnDismissListener
{
  ImagePagerActivity$13$1(ImagePagerActivity.13 param13, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$tag.equals(this.this$1.val$renewTitle)) {
      ImagePagerActivity.access$2400(this.this$1.this$0);
    }
    while (!this.val$tag.equals(this.this$1.val$renewAllTitle)) {
      return;
    }
    ImagePagerActivity.access$2500(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerActivity.13.1
 * JD-Core Version:    0.7.0.1
 */