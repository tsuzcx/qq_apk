package com.tencent.tim.cloudfile;

import ahav;
import aqhq;
import aths;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class CloudFileThumbDownload$1
  implements Runnable
{
  public CloudFileThumbDownload$1(aths paramaths, FileManagerEntity paramFileManagerEntity, String paramString, int paramInt) {}
  
  public void run()
  {
    if (aqhq.fileExistsAndNotEmpty(this.b.strLargeThumPath)) {
      return;
    }
    ahav.J(this.b);
    if (aqhq.fileExistsAndNotEmpty(this.b.strLargeThumPath))
    {
      if (!this.fe.equals(this.b.strLargeThumPath))
      {
        aqhq.copyFile(this.b.strLargeThumPath, this.fe);
        this.b.strLargeThumPath = this.fe;
        this.b.strThumbPath = this.fe;
      }
      aths.a(this.this$0, this.b, this.val$size, 0, "");
      return;
    }
    this.b.strLargeThumPath = this.fe;
    this.b.strThumbPath = this.fe;
    aths.a(this.this$0, this.b, this.fe, this.val$size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileThumbDownload.1
 * JD-Core Version:    0.7.0.1
 */