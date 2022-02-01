package com.tencent.qqmail.attachment.activity;

import com.tencent.qqmail.attachment.model.ImageData;
import com.tencent.qqmail.download.AttachDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;

class ImagePagerFragment$1$1
  implements Runnable
{
  ImagePagerFragment$1$1(ImagePagerFragment.1 param1, ImagePagerActivity paramImagePagerActivity) {}
  
  public void run()
  {
    if (this.val$imagePage != null)
    {
      DownloadInfo localDownloadInfo = new DownloadInfo();
      localDownloadInfo.setAccountId(-1);
      localDownloadInfo.setUrl(ImagePagerFragment.access$100(this.this$1.this$0).getDownUrl());
      localDownloadInfo.setKey(ImagePagerFragment.access$100(this.this$1.this$0).getDownUrl());
      localDownloadInfo.setFileName(ImagePagerFragment.access$100(this.this$1.this$0).getName());
      localDownloadInfo.setFilePath("");
      localDownloadInfo.setIsNotify(false);
      localDownloadInfo.setDownloadType(1);
      localDownloadInfo.setAttachType(2);
      localDownloadInfo.setAttachDownloadListener(new ImagePagerFragment.1.1.1(this));
      AttachDownloadManager.shareInstance().fetchAttach(localDownloadInfo);
      return;
    }
    ImagePagerFragment.access$700(this.this$1.this$0, "imagePager null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ImagePagerFragment.1.1
 * JD-Core Version:    0.7.0.1
 */