package com.tencent.biz.videostory.video;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.TMG.utils.QLog;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import sqr;

class FrameVideoHelper$1
  implements Runnable
{
  FrameVideoHelper$1(FrameVideoHelper paramFrameVideoHelper, long paramLong, FrameVideoHelper.a parama) {}
  
  public void run()
  {
    if (FrameVideoHelper.a(this.this$0) != -1L)
    {
      FrameVideoHelper.a(this.this$0, FrameVideoHelper.a(this.this$0));
      FrameVideoHelper.b(this.this$0, FrameVideoHelper.a(this.this$0));
    }
    FrameVideoHelper.a(this.this$0, new sqr(FrameVideoHelper.b(this.this$0), FrameVideoHelper.c(this.this$0)));
    int j = (int)Math.floor((FrameVideoHelper.d(this.this$0) - this.Dg) / FrameVideoHelper.e(this.this$0));
    long l2 = this.Dg;
    for (;;)
    {
      int i;
      try
      {
        FrameVideoHelper.a(this.this$0).gd(FrameVideoHelper.a(this.this$0));
        long l1 = 0L;
        localByteArrayOutputStream = new ByteArrayOutputStream();
        i = 0;
        if (i < j)
        {
          localObject = FrameVideoHelper.a(this.this$0).d(l2);
          l2 += FrameVideoHelper.e(this.this$0);
          if (localObject == null) {
            break label431;
          }
          ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, FrameVideoHelper.a(this.this$0), localByteArrayOutputStream);
          localObject = localByteArrayOutputStream.toByteArray();
          l1 += localObject.length;
          if (l1 < FrameVideoHelper.f(this.this$0)) {
            continue;
          }
          QLog.i("FrameVideoHelper", 0, "extract Frame out of limit readBytes:" + l1 + " | frameCount:" + i);
        }
        FrameVideoHelper.d(this.this$0, System.currentTimeMillis() - FrameVideoHelper.h(this.this$0));
        localByteArrayOutputStream.close();
        QLog.i("FrameVideoHelper", 0, "extract Frame cost time:" + FrameVideoHelper.i(this.this$0));
        if (this.a != null) {
          this.a.a(true, FrameVideoHelper.a(this.this$0), FrameVideoHelper.g(this.this$0));
        }
      }
      catch (Exception localException)
      {
        ByteArrayOutputStream localByteArrayOutputStream;
        Object localObject;
        localException.printStackTrace();
        this.a.a(false, FrameVideoHelper.a(this.this$0), FrameVideoHelper.g(this.this$0));
        continue;
      }
      FrameVideoHelper.a(this.this$0, false);
      return;
      FrameVideoHelper.c(this.this$0, FrameVideoHelper.g(this.this$0) + localObject.length);
      FrameVideoHelper.a(this.this$0).add(new FrameVideoHelper.FrameBuffer((byte[])localObject));
      localByteArrayOutputStream.reset();
      label431:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.FrameVideoHelper.1
 * JD-Core Version:    0.7.0.1
 */