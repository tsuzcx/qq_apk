package com.tencent.qqmail.download;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class ImageDownloadManager$2$2
  implements Runnable
{
  ImageDownloadManager$2$2(ImageDownloadManager.2 param2, long paramLong, Bitmap paramBitmap, File paramFile) {}
  
  public void run()
  {
    synchronized (ImageDownloadManager.access$200(this.this$1.this$0))
    {
      Object localObject1 = (ArrayList)ImageDownloadManager.access$200(this.this$1.this$0).get(Long.valueOf(this.val$id));
      if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
        break label126;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject1).hasNext()) {
        ((ImageDownloadListener)((Iterator)localObject1).next()).onSuccessInMainThread(this.this$1.val$info.getUrl(), this.val$bitmap, this.val$file.getAbsolutePath());
      }
    }
    ImageDownloadManager.access$200(this.this$1.this$0).remove(Long.valueOf(this.val$id));
    label126:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.2.2
 * JD-Core Version:    0.7.0.1
 */