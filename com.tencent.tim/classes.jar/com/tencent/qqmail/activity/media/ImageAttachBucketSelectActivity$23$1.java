package com.tencent.qqmail.activity.media;

import com.tencent.qqmail.utilities.ui.QMTips;

class ImageAttachBucketSelectActivity$23$1
  implements Runnable
{
  ImageAttachBucketSelectActivity$23$1(ImageAttachBucketSelectActivity.23 param23, ImageAttachBucketSelectActivity.SeqDownloadInfo paramSeqDownloadInfo) {}
  
  public void run()
  {
    Object localObject = this.val$info;
    int i = ImageAttachBucketSelectActivity.SeqDownloadInfo.lastCount;
    for (;;)
    {
      if (i < this.val$info.currentCount)
      {
        localObject = this.this$1.this$0.getString(2131690585);
        localObject = (String)localObject + (i + 1) + "/" + this.val$info.totalCount;
        ImageAttachBucketSelectActivity.access$3400(this.this$1.this$0).updateLoadingInfo((String)localObject);
        try
        {
          Thread.sleep(150L);
          i += 1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    ImageAttachBucketSelectActivity.SeqDownloadInfo.lastCount = this.val$info.currentCount;
    if ((this.val$info.currentCount == this.val$info.totalCount) || (this.val$info.currentCount > this.val$info.totalCount))
    {
      if (this.val$info.successCount != this.val$info.totalCount) {
        break label211;
      }
      ImageAttachBucketSelectActivity.access$3400(this.this$1.this$0).showSuccess(2131690581);
    }
    for (;;)
    {
      ImageAttachBucketSelectActivity.SeqDownloadInfo.lastCount = 0;
      if (ImageAttachBucketSelectActivity.access$3500(this.this$1.this$0) != null) {
        ImageAttachBucketSelectActivity.access$3500(this.this$1.this$0).removeImageSeqLoader();
      }
      return;
      label211:
      String str1 = this.this$1.this$0.getString(2131690580);
      String str2 = this.this$1.this$0.getString(2131690579);
      ImageAttachBucketSelectActivity.access$3400(this.this$1.this$0).showSuccess(str1 + this.val$info.successCount + str2 + this.val$info.failCount);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.23.1
 * JD-Core Version:    0.7.0.1
 */