package com.tencent.biz.qqstory.takevideo.dancemachine;

import acfp;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import rfo;
import rfp;

public class VideoSharer$1
  implements Runnable
{
  public VideoSharer$1(rfo paramrfo, int paramInt) {}
  
  public void run()
  {
    int i;
    if (this.bqN == 0)
    {
      i = this.this$0.f(this.this$0.aAt, this.this$0.mShareUrl, this.this$0.bN);
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachinePKVideoSharer", 2, "[DanceMachine Share]  shareToSinaResult : " + i);
      }
      if (i != 0) {
        this.this$0.mContext.runOnUiThread(new VideoSharer.1.1(this, i));
      }
    }
    Bitmap localBitmap;
    do
    {
      for (;;)
      {
        return;
        Object localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.this$0.bN, (BitmapFactory.Options)localObject);
        if (((BitmapFactory.Options)localObject).outHeight == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DanceMachinePKVideoSharer", 2, "decode bitmap failed, outHeight == 0");
          }
        }
        else
        {
          i = ((BitmapFactory.Options)localObject).outHeight / 120;
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
          ((BitmapFactory.Options)localObject).inSampleSize = i;
          try
          {
            localObject = BitmapFactory.decodeFile(this.this$0.bN, (BitmapFactory.Options)localObject);
            if (localObject == null)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("DanceMachinePKVideoSharer", 2, "decode bitmap failed : iconBitmap is null");
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              localBitmap = null;
            }
            int j = localBitmap.getRowBytes();
            int k = localBitmap.getHeight();
            if (QLog.isColorLevel()) {
              QLog.d("DanceMachinePKVideoSharer", 2, "share to wechat bitmap ratio  : " + i + "   size : " + j * k / 1024 + "KB  fileSize : " + new File(this.this$0.bN).length());
            }
            if (rfo.a(this.this$0) == null) {
              rfo.a(this.this$0, new rfp(this, localBitmap));
            }
            if (this.bqN == 1)
            {
              WXShareHelper.a().d(String.valueOf(System.currentTimeMillis()), this.this$0.aAt, localBitmap, acfp.m(2131716451), this.this$0.mShareUrl);
              WXShareHelper.a().a(rfo.a(this.this$0));
              rfo.a(this.this$0, 1);
              return;
            }
          }
        }
      }
    } while (this.bqN != 2);
    WXShareHelper.a().c(String.valueOf(System.currentTimeMillis()), this.this$0.aAt, localBitmap, acfp.m(2131716448), this.this$0.mShareUrl);
    WXShareHelper.a().a(rfo.a(this.this$0));
    rfo.a(this.this$0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.dancemachine.VideoSharer.1
 * JD-Core Version:    0.7.0.1
 */