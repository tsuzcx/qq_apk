package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.model.ImageData;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnDownloadInfo;

class ImagePagerFragment$5$2$1
  implements Runnable
{
  ImagePagerFragment$5$2$1(ImagePagerFragment.5.2 param2, String paramString) {}
  
  public void run()
  {
    FtnDownloadInfo localFtnDownloadInfo = new FtnDownloadInfo(ImagePagerFragment.access$100(this.this$2.this$1.this$0).getFid(), this.val$storePath, ImagePagerFragment.access$100(this.this$2.this$1.this$0).getCreateTime(), Long.valueOf(ImagePagerFragment.access$100(this.this$2.this$1.this$0).getSize()).longValue());
    FtnManager.sharedInstance().insertDownloadInfo(localFtnDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerFragment.5.2.1
 * JD-Core Version:    0.7.0.1
 */