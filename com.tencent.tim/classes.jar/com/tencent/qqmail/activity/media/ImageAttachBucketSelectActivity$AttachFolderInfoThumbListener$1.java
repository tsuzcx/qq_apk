package com.tencent.qqmail.activity.media;

import com.tencent.qqmail.model.mail.watcher.CompressImageWatcher;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;

class ImageAttachBucketSelectActivity$AttachFolderInfoThumbListener$1
  implements CompressImageWatcher
{
  ImageAttachBucketSelectActivity$AttachFolderInfoThumbListener$1(ImageAttachBucketSelectActivity.AttachFolderInfoThumbListener paramAttachFolderInfoThumbListener, File paramFile) {}
  
  public void onError(String paramString1, String paramString2) {}
  
  public void onSuccess(String paramString1, String paramString2)
  {
    Threads.runOnMainThread(new ImageAttachBucketSelectActivity.AttachFolderInfoThumbListener.1.1(this, ImageUtil.memSafeScaleImage(this.val$image.getAbsolutePath(), 1, ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Origin.ordinal())));
  }
  
  public void onWait(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageAttachBucketSelectActivity.AttachFolderInfoThumbListener.1
 * JD-Core Version:    0.7.0.1
 */