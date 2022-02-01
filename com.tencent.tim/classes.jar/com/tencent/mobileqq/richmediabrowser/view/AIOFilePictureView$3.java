package com.tencent.mobileqq.richmediabrowser.view;

import amdr;
import android.net.Uri;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import java.io.File;
import java.util.ArrayList;

public class AIOFilePictureView$3
  implements Runnable
{
  public AIOFilePictureView$3(amdr paramamdr, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    try
    {
      if (this.T != null)
      {
        Uri localUri = Uri.parse("file://" + this.T.getAbsolutePath());
        amdr.a(this.this$0, localUri, this.qL);
      }
      return;
    }
    catch (Exception localException)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "add qr action sheet error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView.3
 * JD-Core Version:    0.7.0.1
 */