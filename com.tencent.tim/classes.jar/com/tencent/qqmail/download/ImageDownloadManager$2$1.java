package com.tencent.qqmail.download;

import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class ImageDownloadManager$2$1
  implements Runnable
{
  ImageDownloadManager$2$1(ImageDownloadManager.2 param2, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    synchronized (ImageDownloadManager.access$200(this.this$1.this$0))
    {
      Object localObject1 = (ArrayList)ImageDownloadManager.access$200(this.this$1.this$0).get(Long.valueOf(this.val$id));
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        if (((Iterator)localObject1).hasNext()) {
          ((ImageDownloadListener)((Iterator)localObject1).next()).onProgressInMainThread(this.this$1.val$info.getUrl(), this.val$downloadSize, this.val$totalSize);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.download.ImageDownloadManager.2.1
 * JD-Core Version:    0.7.0.1
 */