package com.tencent.biz.subscribe.widget;

import android.graphics.Bitmap;
import arhz;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;
import siu;

public class SubscribeShareHelper$3
  implements Runnable
{
  public SubscribeShareHelper$3(siu paramsiu, Map paramMap, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    if ((siu.a(this.this$0) != null) && (siu.a(this.this$0).isShowing())) {
      siu.a(this.this$0).dismiss();
    }
    siu.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Bitmap localBitmap = (Bitmap)this.eI.remove("image");
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str1 = siu.a(this.this$0);
    String str2 = this.val$title;
    String str3 = this.val$desc;
    String str4 = this.rc;
    if (this.val$shareType == 4) {}
    for (int i = 0;; i = 1)
    {
      localWXShareHelper.a(str1, str2, localBitmap, str3, str4, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.3
 * JD-Core Version:    0.7.0.1
 */