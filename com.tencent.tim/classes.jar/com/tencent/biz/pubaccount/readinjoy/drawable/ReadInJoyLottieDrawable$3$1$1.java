package com.tencent.biz.pubaccount.readinjoy.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import lae;
import lah;

public class ReadInJoyLottieDrawable$3$1$1
  implements Runnable
{
  public ReadInJoyLottieDrawable$3$1$1(lah paramlah, String paramString) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(this.val$path);
      if (localBitmap != null) {
        lae.b().put(this.val$path, localBitmap);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyLottieDrawable", 2, "loadLottieAnimation path: " + this.val$path);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ReadInJoyLottieDrawable", 2, "loadLottieAnimation oom: " + this.val$path);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.3.1.1
 * JD-Core Version:    0.7.0.1
 */