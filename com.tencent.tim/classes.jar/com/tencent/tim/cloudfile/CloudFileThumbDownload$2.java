package com.tencent.tim.cloudfile;

import android.graphics.BitmapFactory.Options;
import aqhu;
import aths;
import auef;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class CloudFileThumbDownload$2
  implements Runnable
{
  public CloudFileThumbDownload$2(aths paramaths, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if ((this.d.imgHeight <= 0) || (this.d.imgWidth <= 0))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      aqhu.d(this.d.strLargeThumPath, localOptions);
      if (aths.aX(localOptions.outWidth, localOptions.outHeight)) {
        auef.M(this.d);
      }
      return;
    }
    auef.M(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileThumbDownload.2
 * JD-Core Version:    0.7.0.1
 */