package com.tencent.biz.qqcircle.bizparts;

import android.graphics.Bitmap;
import arhz;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;
import oxh;

public class QCircleSharePart$3
  implements Runnable
{
  public QCircleSharePart$3(oxh paramoxh, Map paramMap, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    if ((oxh.a(this.this$0) != null) && (oxh.a(this.this$0).isShowing())) {
      oxh.a(this.this$0).dismiss();
    }
    oxh.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Bitmap localBitmap = (Bitmap)this.eI.remove("image");
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str1 = oxh.a(this.this$0);
    String str2 = this.val$title;
    String str3 = this.val$desc;
    String str4 = this.rc;
    if (this.val$shareType == 9) {}
    for (int i = 0;; i = 1)
    {
      localWXShareHelper.a(str1, str2, localBitmap, str3, str4, i);
      QLog.d("QCircleSharePart", 1, "shareToWeChat success");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleSharePart.3
 * JD-Core Version:    0.7.0.1
 */