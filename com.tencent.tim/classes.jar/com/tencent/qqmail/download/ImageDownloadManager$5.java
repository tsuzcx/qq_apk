package com.tencent.qqmail.download;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.qmimagecache.ImageCompresser;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import org.apache.commons.lang3.StringUtils;

class ImageDownloadManager$5
  implements Runnable
{
  ImageDownloadManager$5(ImageDownloadManager paramImageDownloadManager, String paramString1, ImageCompresser paramImageCompresser, String paramString2, int paramInt, DownloadInfo paramDownloadInfo, String paramString3) {}
  
  public void run()
  {
    if (!StringUtils.isBlank(this.val$compressPath))
    {
      Bitmap localBitmap = ImageUtil.memSafeScaleImage(this.val$compressPath, 1, ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Origin.ordinal());
      this.val$imageCompresser.addBitmapToMemCache(this.val$url, localBitmap, this.val$compressSizeType);
      Threads.runOnMainThread(new ImageDownloadManager.5.1(this, localBitmap));
      return;
    }
    ImageDownloadManager.access$400(this.this$0, this.val$url, this.val$compressSizeType, this.val$info.getImageDownloadListener());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.5
 * JD-Core Version:    0.7.0.1
 */