package com.tencent.qqmail.activity.readmail;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;

class ReadMailFragment$7$1
  implements Runnable
{
  ReadMailFragment$7$1(ReadMailFragment.7 param7, Bitmap paramBitmap, String paramString) {}
  
  public void run()
  {
    if (ImageUtil.writeBitmapToLocation(this.val$webviewScreenShotBmp, Bitmap.CompressFormat.JPEG, 100, this.val$screenShotImageFileName)) {
      this.this$1.this$0.popupScreenShotBubble(this.val$screenShotImageFileName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.7.1
 * JD-Core Version:    0.7.0.1
 */