package com.tencent.qqmail.utilities.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.thread.Threads;

final class ShareUtil$4
  implements Runnable
{
  ShareUtil$4(String paramString, Context paramContext, ShareUtil.ShareCallback paramShareCallback) {}
  
  public void run()
  {
    Bitmap localBitmap = BitmapFactory.decodeFile(this.val$path);
    ImageUtil.saveToGallery(this.val$context, localBitmap);
    Threads.runOnMainThread(new ShareUtil.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.share.ShareUtil.4
 * JD-Core Version:    0.7.0.1
 */