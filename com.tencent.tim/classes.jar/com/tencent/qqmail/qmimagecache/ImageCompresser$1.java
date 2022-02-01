package com.tencent.qqmail.qmimagecache;

import android.graphics.Bitmap;
import com.tencent.qqmail.model.mail.watcher.CompressImageWatcher;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import java.io.FileOutputStream;
import org.apache.commons.lang3.StringUtils;

class ImageCompresser$1
  implements Runnable
{
  ImageCompresser$1(ImageCompresser paramImageCompresser, ImageCompresser.CompressRequest paramCompressRequest) {}
  
  public void run()
  {
    Bitmap localBitmap;
    String str;
    if (this.val$request.sampleSizeType > 1)
    {
      localBitmap = ImageCompresser.access$000(this.this$0, this.val$request);
      str = ImageCompresser.access$100(this.this$0, this.val$request.src, this.val$request.sampleSizeType);
      if (StringUtils.isBlank(this.val$request.destPath)) {
        break label218;
      }
    }
    for (;;)
    {
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(this.val$request.destPath);
        localBitmap.compress(ImageCompresser.DEFAULT_COMPRESS_FORMAT, 70, localFileOutputStream);
        localFileOutputStream.close();
        ImageCompresser.access$302(this.this$0, ImageCompresser.access$300(this.this$0) - this.val$request.size);
        if (ImageCompresser.access$300(this.this$0) < 0L) {
          ImageCompresser.access$302(this.this$0, 0L);
        }
        if (localBitmap != null) {
          localBitmap.recycle();
        }
        if (this.val$request.callback != null) {
          this.val$request.callback.onSuccess(this.val$request.src, ImageCompresser.access$200(this.this$0).getCompressImagePath(str));
        }
        this.this$0.startCompress();
        return;
        localBitmap = ImageUtil.memSafeScaleImage(this.val$request.sourcePath, 1, ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Origin.ordinal());
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      label218:
      ImageCompresser.access$200(this.this$0).compressImage(str, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.ImageCompresser.1
 * JD-Core Version:    0.7.0.1
 */