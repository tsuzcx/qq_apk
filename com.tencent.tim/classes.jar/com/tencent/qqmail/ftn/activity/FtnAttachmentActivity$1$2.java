package com.tencent.qqmail.ftn.activity;

import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;

class FtnAttachmentActivity$1$2
  implements Runnable
{
  FtnAttachmentActivity$1$2(FtnAttachmentActivity.1 param1) {}
  
  public void run()
  {
    if (QMNetworkUtils.isNetworkConnected())
    {
      FtnAttachmentActivity.access$600(this.this$1.this$0, this.this$1.this$0.getString(2131697132));
      return;
    }
    FtnAttachmentActivity.access$600(this.this$1.this$0, this.this$1.this$0.getString(2131697131));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnAttachmentActivity.1.2
 * JD-Core Version:    0.7.0.1
 */