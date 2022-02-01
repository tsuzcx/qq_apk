package com.tencent.mobileqq.richmediabrowser;

import amcg;
import amcv;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class AIOGalleryActivity$2$1
  implements Runnable
{
  public AIOGalleryActivity$2$1(amcg paramamcg, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    if (AIOGalleryActivity.a(this.a.a) != null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("IAIOImageProviderCallBack", 4, "IAIOImageProviderCallBack.notifyImageResult():isPart " + this.biB);
      AIOGalleryActivity.a(this.a.a).b(this.val$id, this.bWI, this.val$type, this.val$result, this.aWc, this.biB);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.1
 * JD-Core Version:    0.7.0.1
 */