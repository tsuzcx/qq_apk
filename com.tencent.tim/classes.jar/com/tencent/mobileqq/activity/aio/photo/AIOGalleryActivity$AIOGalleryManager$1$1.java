package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.qphone.base.util.QLog;
import xse;
import xsk;
import xtp;

public class AIOGalleryActivity$AIOGalleryManager$1$1
  implements Runnable
{
  public AIOGalleryActivity$AIOGalleryManager$1$1(xse paramxse, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    if (AIOGalleryActivity.a.a(this.a.a) != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("peak_pgjpeg", 4, "IAIOImageProviderCallBack.notifyImageResult():isPart " + this.biB);
      }
      ((xsk)AIOGalleryActivity.a.b(this.a.a)).b(this.val$id, this.bWI, this.val$type, this.val$result, this.aWc, this.biB);
    }
    if (this.a.a.b != null) {
      ((xtp)this.a.a.b).e(this.val$id, this.bWI, this.val$type, this.val$result, this.aWc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity.AIOGalleryManager.1.1
 * JD-Core Version:    0.7.0.1
 */