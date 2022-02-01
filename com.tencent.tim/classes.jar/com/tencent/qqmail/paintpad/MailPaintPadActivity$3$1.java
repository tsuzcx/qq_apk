package com.tencent.qqmail.paintpad;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.thread.Threads;

class MailPaintPadActivity$3$1
  implements Runnable
{
  MailPaintPadActivity$3$1(MailPaintPadActivity.3 param3) {}
  
  public void run()
  {
    MailPaintPadActivity.access$002(this.this$1.this$0, FileUtil.getWebviewScreenshotDir() + "screenshot_paintpad_" + System.currentTimeMillis() + ".jpg");
    if (Boolean.valueOf(ImageUtil.writeBitmapToLocation(MailPaintPadActivity.access$100(this.this$1.this$0), Bitmap.CompressFormat.JPEG, 100, MailPaintPadActivity.access$000(this.this$1.this$0))).booleanValue()) {
      Threads.runOnMainThread(new MailPaintPadActivity.3.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.paintpad.MailPaintPadActivity.3.1
 * JD-Core Version:    0.7.0.1
 */