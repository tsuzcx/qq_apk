package com.tencent.qqmail.activity.media;

import android.os.Handler;
import android.os.Message;
import com.tencent.qqmail.utilities.ui.QMTips;

class ImageAttachBucketSelectActivity$22
  extends Handler
{
  ImageAttachBucketSelectActivity$22(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.this$0.getTips().showSuccess(this.this$0.getString(2131718941));
      return;
    case 1: 
      this.this$0.getTips().showError(this.this$0.getString(2131694072));
      return;
    case 3: 
      this.this$0.getTips().showError(this.this$0.getString(2131694053));
      return;
    case 2: 
      this.this$0.getTips().showSuccess(this.this$0.getString(2131718940));
      return;
    }
    this.this$0.getTips().showError(this.this$0.getString(2131718938));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.22
 * JD-Core Version:    0.7.0.1
 */