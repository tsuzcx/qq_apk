package com.tencent.mobileqq.troop.utils;

import java.io.File;
import java.util.Map;

public class TroopFileTransferManager$TaskGenThumbnail
  extends TroopFileTransferManager.Task
{
  public int f = 0;
  
  public TroopFileTransferManager$TaskGenThumbnail(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    super(paramTroopFileTransferManager, paramItem, 1);
    this.f = paramInt;
  }
  
  public void run()
  {
    for (;;)
    {
      Object localObject3;
      synchronized (this.b)
      {
        if (this.a.Status == 12) {
          return;
        }
        String str = this.a.getThumbnailFile(this.b.g, this.f);
        localObject3 = str + ".ttmp";
        boolean bool = TroopFileUtils.a(this.a.LocalFile, (String)localObject3, this.f);
        ??? = this.b;
        if (bool) {
          try
          {
            localObject3 = new File((String)localObject3);
            ((File)localObject3).renameTo(new File(str));
            ((File)localObject3).deleteOnExit();
            if (this.f != 128) {
              break label313;
            }
            this.a.ThumbnailDownloading_Small = false;
            this.b.a(this.a, 128);
            this.a.StatusUpdateTimeMs = 0L;
            if (this.b.b.containsKey(this.a.Id)) {
              this.b.a(this.a);
            }
            return;
          }
          finally {}
        }
      }
      new File((String)localObject3).delete();
      if ((this.a.FilePath != null) && (!new File(this.a.LocalFile).exists()))
      {
        this.b.a(this.a, this.f, false);
        return;
      }
      if (this.f == 128)
      {
        this.a.ThumbnailFileTimeMS_Small = 0L;
      }
      else if (this.f == 640)
      {
        this.a.ThumbnailFileTimeMS_Large = 0L;
        continue;
        label313:
        if (this.f == 640)
        {
          this.a.ThumbnailDownloading_Large = false;
          this.b.a(this.a, 640);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskGenThumbnail
 * JD-Core Version:    0.7.0.1
 */