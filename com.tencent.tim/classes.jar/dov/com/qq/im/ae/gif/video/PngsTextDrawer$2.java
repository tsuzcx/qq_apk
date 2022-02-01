package dov.com.qq.im.ae.gif.video;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import awtg;
import axdm;
import axfu;
import axfu.a;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PngsTextDrawer$2
  implements Runnable
{
  public PngsTextDrawer$2(axfu paramaxfu, axfu.a parama) {}
  
  public void run()
  {
    String str1 = axfu.a(this.this$0) + System.currentTimeMillis();
    String str2;
    try
    {
      new File(str1).mkdirs();
      axfu.a(this.this$0).draw();
      Bitmap localBitmap1 = axfu.a(this.this$0).aT();
      Iterator localIterator = axfu.a(this.this$0, axfu.b(this.this$0)).iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label334;
        }
        str2 = (String)localIterator.next();
        Bitmap localBitmap2 = awtg.d(str2, axfu.a(this.this$0), axfu.b(this.this$0), true);
        if (localBitmap2 == null) {
          break;
        }
        new Canvas(localBitmap2).drawBitmap(localBitmap1, axfu.c(this.this$0), axfu.d(this.this$0), new Paint());
        str2 = new File(str2).getName();
        awtg.H(str1 + File.separator + str2, localBitmap2);
        localBitmap2.recycle();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d(axfu.access$600(), 4, "start add text exception, msg = " + localException.getMessage());
      if (this.b != null) {
        this.b.cZr();
      }
    }
    QLog.d(axfu.access$600(), 4, new Object[] { "draw frame but bitmap == null, png path = ", str2 });
    label334:
    for (int i = 0;; i = 1)
    {
      axfu.a(this.this$0).release();
      if (this.b == null) {
        break;
      }
      if (i != 0)
      {
        this.b.acv(localException);
        return;
      }
      this.b.cZr();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsTextDrawer.2
 * JD-Core Version:    0.7.0.1
 */