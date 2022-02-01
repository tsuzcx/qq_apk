package com.tencent.mobileqq.richmediabrowser.view;

import ahwy;
import amea;
import android.net.Uri;
import java.io.File;
import java.util.ArrayList;

public class AIOPictureView$3
  implements Runnable
{
  public AIOPictureView$3(amea paramamea, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (ahwy.a().aof()) {}
    while ((this.this$0.mFilePath == null) || (!this.this$0.mFilePath.equals(this.R.getPath()))) {
      return;
    }
    Uri localUri = Uri.parse("file://" + this.R.getAbsolutePath());
    amea.a(this.this$0, localUri, this.qL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.3
 * JD-Core Version:    0.7.0.1
 */