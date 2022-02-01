package com.tencent.tim.cloudfile;

import android.graphics.BitmapFactory.Options;
import aqhu;
import aths;
import auef;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class CloudFileThumbDownload$3
  implements Runnable
{
  public CloudFileThumbDownload$3(aths paramaths, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if ((this.d.imgHeight <= 0) || (this.d.imgWidth <= 0))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      aqhu.d(this.d.strMiddleThumPath, localOptions);
      if (aths.aX(localOptions.outWidth, localOptions.outHeight)) {
        auef.N(this.d);
      }
      return;
    }
    auef.N(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileThumbDownload.3
 * JD-Core Version:    0.7.0.1
 */