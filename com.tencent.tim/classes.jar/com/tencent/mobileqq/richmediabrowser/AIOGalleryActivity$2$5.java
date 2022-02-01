package com.tencent.mobileqq.richmediabrowser;

import amcg;
import amcv;
import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class AIOGalleryActivity$2$5
  implements Runnable
{
  public AIOGalleryActivity$2$5(amcg paramamcg, long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle) {}
  
  public void run()
  {
    if (AIOGalleryActivity.a(this.a.a) != null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("IAIOImageProviderCallBack", 4, "IAIOImageProviderCallBack.notifyVideoUrl");
      AIOGalleryActivity.a(this.a.a).a(this.val$id, this.bWI, this.val$type, this.val$path, this.cI, this.val$domain, this.b, this.val$fileType, this.val$bundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity.2.5
 * JD-Core Version:    0.7.0.1
 */