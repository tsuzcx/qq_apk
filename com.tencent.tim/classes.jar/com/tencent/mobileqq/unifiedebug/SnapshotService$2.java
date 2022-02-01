package com.tencent.mobileqq.unifiedebug;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class SnapshotService$2
  implements Runnable
{
  SnapshotService$2(SnapshotService paramSnapshotService, Bitmap paramBitmap, SnapshotService.a parama, SnapshotService.c paramc) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.access$000(), 2, "ScreenShot Finish Callback");
    }
    SnapshotService.a(this.this$0, this.val$bitmap, this.a, this.c);
    this.this$0.mHandler.post(new SnapshotService.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService.2
 * JD-Core Version:    0.7.0.1
 */