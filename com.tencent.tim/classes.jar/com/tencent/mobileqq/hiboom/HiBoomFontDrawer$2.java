package com.tencent.mobileqq.hiboom;

import ahxp;
import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.List;
import java.util.Vector;

public class HiBoomFontDrawer$2
  implements Runnable
{
  public HiBoomFontDrawer$2(ahxp paramahxp, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.val$imagePaths.size())
    {
      Bitmap localBitmap = ahxp.D((String)this.val$imagePaths.get(i));
      if (localBitmap != null) {
        BaseApplicationImpl.sImageCache.put(this.val$imagePaths.get(i), localBitmap);
      }
      for (;;)
      {
        i += 1;
        break;
        this.this$0.E.add(this.val$imagePaths.get(i));
      }
    }
    ahxp.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.2
 * JD-Core Version:    0.7.0.1
 */