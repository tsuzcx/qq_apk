package com.tencent.qqmail.activity.readmail;

import android.graphics.Bitmap;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.screenshot.ScreenshotWatcher.ScreenshotCallback;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;

class ReadMailFragment$7
  implements ScreenshotWatcher.ScreenshotCallback
{
  ReadMailFragment$7(ReadMailFragment paramReadMailFragment) {}
  
  public void onScreenshot()
  {
    Bitmap localBitmap;
    String str;
    if (ReadMailFragment.access$2300(this.this$0) != null)
    {
      localBitmap = ImageUtil.captureWebViewVisibleArea(ReadMailFragment.access$2300(this.this$0).getWebView());
      str = FileUtil.getWebviewScreenshotDir();
      if (str != null) {}
    }
    else
    {
      return;
    }
    Threads.runInBackground(new ReadMailFragment.7.1(this, localBitmap, str + System.currentTimeMillis() + ".jpg"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.7
 * JD-Core Version:    0.7.0.1
 */