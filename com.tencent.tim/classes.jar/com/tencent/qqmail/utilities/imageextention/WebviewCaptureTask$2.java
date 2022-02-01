package com.tencent.qqmail.utilities.imageextention;

import android.graphics.Bitmap;
import com.tencent.qqmail.utilities.fileextention.FileUtil;

class WebviewCaptureTask$2
  implements Runnable
{
  WebviewCaptureTask$2(WebviewCaptureTask paramWebviewCaptureTask, Bitmap paramBitmap) {}
  
  public void run()
  {
    String str = WebviewCaptureTask.access$000(this.this$0, this.val$bitmap);
    if (str != null) {
      FileUtil.delFileBeforeCertianTime(str, 86400000L);
    }
    this.this$0.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.imageextention.WebviewCaptureTask.2
 * JD-Core Version:    0.7.0.1
 */