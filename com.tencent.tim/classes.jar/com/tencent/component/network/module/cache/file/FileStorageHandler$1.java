package com.tencent.component.network.module.cache.file;

import android.content.Context;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;
import java.util.Collection;
import java.util.Iterator;

class FileStorageHandler$1
  implements ThreadPool.Job<Object>
{
  FileStorageHandler$1(FileStorageHandler paramFileStorageHandler, boolean paramBoolean, Context paramContext) {}
  
  public Object run(ThreadPool.JobContext paramJobContext)
  {
    paramJobContext.setMode(1);
    paramJobContext = FileStorageHandler.access$000(this.this$0).collect();
    int i;
    int j;
    if (paramJobContext != null)
    {
      paramJobContext = paramJobContext.iterator();
      i = 0;
      j = 0;
      while (paramJobContext.hasNext())
      {
        FileCacheService localFileCacheService = (FileCacheService)paramJobContext.next();
        int k = localFileCacheService.getCapacity(this.val$externalStorage);
        int m = localFileCacheService.getSize(this.val$externalStorage);
        int n = FileStorageHandler.access$100(this.this$0, k, m);
        localFileCacheService.clear(this.val$externalStorage, n);
        if (QDLog.isInfoEnable()) {
          QDLog.i("downloader", "clear cache service:" + localFileCacheService + ": remain=" + n);
        }
        j += m;
        i += k;
      }
      if (i > 0) {
        break label186;
      }
    }
    label186:
    for (float f = 3.4028235E+38F;; f = j / i)
    {
      if (f < 0.1F) {
        FileStorageHandler.access$200(this.this$0, this.val$context);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.cache.file.FileStorageHandler.1
 * JD-Core Version:    0.7.0.1
 */