package com.tencent.qqmail.activity.media;

import android.os.Handler;
import android.os.Message;

class ImageAttachBucketSelectActivity$23
  extends Handler
{
  ImageAttachBucketSelectActivity$23(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      return;
    case 0: 
      paramMessage = (ImageAttachBucketSelectActivity.SeqDownloadInfo)paramMessage.obj;
      ImageAttachBucketSelectActivity.access$3600(this.this$0, new ImageAttachBucketSelectActivity.23.1(this, paramMessage));
      return;
    }
    paramMessage = (ImageAttachBucketSelectActivity.SeqDownloadInfo)paramMessage.obj;
    ImageAttachBucketSelectActivity.access$3700(this.this$0, new ImageAttachBucketSelectActivity.23.2(this, paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.23
 * JD-Core Version:    0.7.0.1
 */