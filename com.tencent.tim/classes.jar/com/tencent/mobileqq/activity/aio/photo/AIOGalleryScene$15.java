package com.tencent.mobileqq.activity.aio.photo;

import ahwy;
import android.net.Uri;
import java.io.File;
import java.util.ArrayList;
import xsk;

public class AIOGalleryScene$15
  implements Runnable
{
  public AIOGalleryScene$15(xsk paramxsk, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (ahwy.a().aof()) {}
    while ((this.this$0.mFilePath == null) || (!this.this$0.mFilePath.equals(this.R.getPath()))) {
      return;
    }
    Uri localUri = Uri.parse("file://" + this.R.getAbsolutePath());
    xsk.a(this.this$0, localUri, this.qL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.15
 * JD-Core Version:    0.7.0.1
 */