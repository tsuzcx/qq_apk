package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;
import nwg;

public class QShareUtils$1
  implements Runnable
{
  public QShareUtils$1(nwg paramnwg, Map paramMap, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7) {}
  
  public void run()
  {
    int i = 0;
    nwg.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Object localObject1 = (Bitmap)this.eI.remove("image");
    if (this.ava)
    {
      WxShareHelperFromReadInjoy.a().a(nwg.a(this.this$0), this.val$title, (Bitmap)localObject1, this.val$desc, this.ake, this.val$miniProgramPath, this.aoy);
      return;
    }
    if (((this.val$action == 9) && (this.aoz.contains("wx_friend"))) || ((this.val$action == 10) && (this.aoz.contains("wx_line"))))
    {
      localObject1 = WXShareHelper.a();
      localObject2 = this.aoA;
      if (this.val$action == 9) {}
      for (i = 0;; i = 1)
      {
        ((WXShareHelper)localObject1).ah((String)localObject2, i, nwg.a(this.this$0));
        return;
      }
    }
    Object localObject2 = WXShareHelper.a();
    String str1 = nwg.a(this.this$0);
    String str2 = this.val$title;
    String str3 = this.val$desc;
    String str4 = this.ake;
    if (this.val$action == 9) {}
    for (;;)
    {
      ((WXShareHelper)localObject2).a(str1, str2, (Bitmap)localObject1, str3, str4, i);
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils.1
 * JD-Core Version:    0.7.0.1
 */