package com.tencent.qqmail.ftn.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class FtnAttachmentActivity$18$1
  implements DialogInterface.OnDismissListener
{
  FtnAttachmentActivity$18$1(FtnAttachmentActivity.18 param18, String paramString) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.val$tag.equals(this.this$1.val$renewTitle)) {
      FtnAttachmentActivity.access$3900(this.this$1.this$0);
    }
    while (!this.val$tag.equals(this.this$1.val$renewAllTitle)) {
      return;
    }
    FtnAttachmentActivity.access$4000(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.18.1
 * JD-Core Version:    0.7.0.1
 */