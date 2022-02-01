package com.tencent.qqmail.activity.media;

import com.tencent.qqmail.utilities.ui.QMTips;

class ImageAttachBucketSelectActivity$23$2
  implements Runnable
{
  ImageAttachBucketSelectActivity$23$2(ImageAttachBucketSelectActivity.23 param23, ImageAttachBucketSelectActivity.SeqDownloadInfo paramSeqDownloadInfo) {}
  
  public void run()
  {
    String str = this.this$1.this$0.getString(2131690585);
    str = str + this.val$info.currentCount + "/" + this.val$info.totalCount;
    ImageAttachBucketSelectActivity.access$3400(this.this$1.this$0).showLoading(str);
    ImageAttachBucketSelectActivity.SeqDownloadInfo.lastCount = this.val$info.currentCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.23.2
 * JD-Core Version:    0.7.0.1
 */