package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import aqhu;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class RedTouchTextView$1
  implements Runnable
{
  RedTouchTextView$1(RedTouchTextView paramRedTouchTextView, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(this.this$0.getContext().getFilesDir(), this.val$imgUrl.hashCode() + "");
      Bitmap localBitmap;
      if (((File)localObject).exists())
      {
        localBitmap = this.this$0.b((File)localObject);
        localObject = localBitmap;
        if (this.dxu == 1) {
          localObject = aqhu.b(localBitmap, localBitmap.getWidth(), localBitmap.getWidth(), localBitmap.getHeight());
        }
        this.this$0.ft = new BitmapDrawable((Bitmap)localObject);
        this.this$0.dJJ();
        return;
      }
      if (!RedTouchTextView.a(this.this$0))
      {
        RedTouchTextView.a(this.this$0, true);
        if (HttpDownloadUtil.a(null, this.val$imgUrl, (File)localObject))
        {
          localBitmap = this.this$0.b((File)localObject);
          localObject = localBitmap;
          if (this.dxu == 1) {
            localObject = aqhu.b(localBitmap, localBitmap.getWidth(), localBitmap.getWidth(), localBitmap.getHeight());
          }
          this.this$0.ft = new BitmapDrawable((Bitmap)localObject);
          this.this$0.dJJ();
        }
        RedTouchTextView.a(this.this$0, false);
        return;
      }
    }
    catch (Exception localException)
    {
      RedTouchTextView.a(this.this$0, false);
      QLog.e("RedTouchTextView", 2, "currentIrregularDrawable exception" + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchTextView.1
 * JD-Core Version:    0.7.0.1
 */