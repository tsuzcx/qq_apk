package com.tencent.mobileqq.activity.richmedia;

import aauq;
import aaut;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import awcr;
import awed;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class EditLocalVideoActivity$18
  implements Runnable
{
  EditLocalVideoActivity$18(EditLocalVideoActivity paramEditLocalVideoActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = this.this$0.getResources().getDisplayMetrics().widthPixels / 6;
    float f = this.Lt * 1.0F / this.Lu;
    int k;
    int n;
    int m;
    int j;
    if (f <= 1.0F)
    {
      k = (int)(i / f);
      n = (k - i) / 2;
      m = 0;
      j = i;
      if (!TextUtils.isEmpty(EditLocalVideoActivity.b(this.this$0))) {
        break label121;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "initFramesBar, mTrimVideoPath is null");
      }
      EditLocalVideoActivity.a(this.this$0).sendEmptyMessage(1001);
    }
    for (;;)
    {
      return;
      j = (int)(f * i);
      m = (j - i) / 2;
      n = 0;
      k = i;
      break;
      label121:
      if (!EditLocalVideoActivity.WK())
      {
        i = aaut.a(EditLocalVideoActivity.b(this.this$0), j, k, m, n, i, i);
        if (QLog.isColorLevel()) {
          QLog.d("EditLocalVideoActivity", 2, "init, status1=" + i + ", dstWidth=" + j + ", dstHeight=" + k);
        }
        if (i != 0)
        {
          awed.ad(String.valueOf(EditLocalVideoActivity.b(this.this$0)), "qzone_video_trim", "2", null);
          EditLocalVideoActivity.a(this.this$0).sendEmptyMessage(1001);
          return;
        }
      }
      EditLocalVideoActivity.a(this.this$0).init(EditLocalVideoActivity.b(this.this$0), EditLocalVideoActivity.b(this.this$0));
      if (EditLocalVideoActivity.c(this.this$0) == 0) {
        EditLocalVideoActivity.b(this.this$0, (int)EditLocalVideoActivity.a(this.this$0).aT());
      }
      if (EditLocalVideoActivity.d(this.this$0) == 0) {
        EditLocalVideoActivity.c(this.this$0, (int)EditLocalVideoActivity.a(this.this$0).aU());
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "mStartTime=" + EditLocalVideoActivity.c(this.this$0) + ", mEndTime=" + EditLocalVideoActivity.d(this.this$0));
      }
      EditLocalVideoActivity.a(this.this$0).setPlayDuration(EditLocalVideoActivity.c(this.this$0), EditLocalVideoActivity.d(this.this$0) - EditLocalVideoActivity.c(this.this$0));
      EditLocalVideoActivity.a(this.this$0).sendEmptyMessage(1100);
      if (!EditLocalVideoActivity.WK())
      {
        if (TextUtils.isEmpty(EditLocalVideoActivity.b(this.this$0))) {}
        for (i = -999;; i = aaut.g(EditLocalVideoActivity.b(this.this$0), this.Lt, this.Lu))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EditLocalVideoActivity", 2, "init, status0=" + i);
          }
          if (i == 0) {
            break;
          }
          awed.ad(String.valueOf(EditLocalVideoActivity.b(this.this$0)), "qzone_video_trim", "3", null);
          EditLocalVideoActivity.a(this.this$0).sendEmptyMessage(1000);
          return;
        }
      }
      try
      {
        Object localObject;
        Bitmap localBitmap;
        if (EditLocalVideoActivity.WK())
        {
          localObject = new MediaMetadataRetriever();
          ((MediaMetadataRetriever)localObject).setDataSource(EditLocalVideoActivity.b(this.this$0));
          localBitmap = ((MediaMetadataRetriever)localObject).getFrameAtTime(EditLocalVideoActivity.c(this.this$0) * 1000, 3);
          ((MediaMetadataRetriever)localObject).release();
        }
        while (localBitmap != null)
        {
          localObject = aauq.JD + File.separator + System.currentTimeMillis() + ".jpg";
          if (!awcr.saveBitmapToFile(localBitmap, (String)localObject, Bitmap.CompressFormat.JPEG, 90, true)) {
            break;
          }
          EditLocalVideoActivity.a(this.this$0).obtainMessage(1102, localObject).sendToTarget();
          return;
          localBitmap = aaut.a(0L, 1000L);
        }
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.18
 * JD-Core Version:    0.7.0.1
 */