package com.tencent.qqmail.utilities.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Iterator;

final class ShareUtil$5
  implements Runnable
{
  ShareUtil$5(ArrayList paramArrayList, Context paramContext, ShareUtil.ShareCallback paramShareCallback) {}
  
  public void run()
  {
    Iterator localIterator = this.val$paths.iterator();
    while (localIterator.hasNext())
    {
      Bitmap localBitmap = BitmapFactory.decodeFile((String)localIterator.next());
      ImageUtil.saveToGallery(this.val$context, localBitmap);
    }
    Threads.runOnMainThread(new ShareUtil.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.share.ShareUtil.5
 * JD-Core Version:    0.7.0.1
 */