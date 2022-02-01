package com.tencent.mobileqq.activity.aio.photo;

import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import xsk;

public class AIOGalleryScene$20
  implements Runnable
{
  public AIOGalleryScene$20(xsk paramxsk, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    try
    {
      if (this.T != null)
      {
        Uri localUri = Uri.parse("file://" + this.T.getAbsolutePath());
        xsk.a(this.this$0, localUri, this.qL);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.i("AIOGalleryScene", 1, "add qr action sheet error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.20
 * JD-Core Version:    0.7.0.1
 */