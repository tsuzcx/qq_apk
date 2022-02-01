package com.tencent.qqmail.activity.media;

import android.os.Handler;
import android.os.Message;
import com.tencent.qqmail.download.loader.TinyImageSeqLoader.Listener;

class ImageAttachBucketSelectActivity$21
  implements TinyImageSeqLoader.Listener
{
  ImageAttachBucketSelectActivity$21(ImageAttachBucketSelectActivity paramImageAttachBucketSelectActivity, int paramInt) {}
  
  public void onBefore()
  {
    ImageAttachBucketSelectActivity.SeqDownloadInfo localSeqDownloadInfo = new ImageAttachBucketSelectActivity.SeqDownloadInfo();
    localSeqDownloadInfo.totalCount = this.val$totalCount;
    localSeqDownloadInfo.currentCount = 0;
    Message localMessage = new Message();
    localMessage.obj = localSeqDownloadInfo;
    localMessage.what = 2;
    ImageAttachBucketSelectActivity.access$3300(this.this$0).sendMessage(localMessage);
  }
  
  public void onChangeNext(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramString2 = new ImageAttachBucketSelectActivity.SeqDownloadInfo();
    paramString2.totalCount = this.val$totalCount;
    paramString2.currentCount = paramInt1;
    paramString2.successCount = paramInt2;
    paramString2.failCount = paramInt3;
    paramString2.key = paramString1;
    paramString2.downSuccess = paramBoolean;
    paramString1 = new Message();
    paramString1.obj = paramString2;
    paramString1.what = 0;
    ImageAttachBucketSelectActivity.access$3300(this.this$0).sendMessage(paramString1);
  }
  
  public void onComplete(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ImageAttachBucketSelectActivity.SeqDownloadInfo localSeqDownloadInfo = new ImageAttachBucketSelectActivity.SeqDownloadInfo();
    localSeqDownloadInfo.totalCount = this.val$totalCount;
    localSeqDownloadInfo.currentCount = (paramInt1 + paramInt2);
    localSeqDownloadInfo.successCount = paramInt1;
    localSeqDownloadInfo.failCount = paramInt2;
    localSeqDownloadInfo.filePath = paramString;
    localSeqDownloadInfo.errCode = paramInt4;
    paramString = new Message();
    paramString.obj = localSeqDownloadInfo;
    paramString.what = 0;
    ImageAttachBucketSelectActivity.access$3300(this.this$0).sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.21
 * JD-Core Version:    0.7.0.1
 */