package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.content.Context;
import android.graphics.Bitmap;
import arhz;
import awit;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;
import kxm;
import mqq.app.MobileQQ;
import nng;
import nns;

public class FastWebShareUtils$3
  implements Runnable
{
  public FastWebShareUtils$3(nng paramnng, Map paramMap, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, AppInterface paramAppInterface, String paramString6, ArticleInfo paramArticleInfo, int paramInt) {}
  
  public void run()
  {
    int j = 1;
    int i = 1;
    if (nng.a(this.this$0).isShowing()) {
      nng.a(this.this$0).dismiss();
    }
    nng.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Object localObject1 = (Bitmap)this.eI.remove("image");
    Object localObject2;
    if (this.atA)
    {
      WxShareHelperFromReadInjoy.a().a(nng.a(this.this$0), this.val$title, (Bitmap)localObject1, this.val$desc, this.ake, this.Vu);
      localObject1 = this.val$appInterface.getApplication().getApplicationContext();
      localObject2 = this.val$from;
      if (!"2".equals(this.amz)) {
        break label303;
      }
    }
    label303:
    for (i = 4;; i = 5)
    {
      nng.a((Context)localObject1, (String)localObject2, i, this.d);
      nns.a(this.val$appInterface.getApplication().getApplicationContext(), this.val$appInterface, this.d, this.baw, -1, false);
      return;
      if (awit.y(kxm.getAppRuntime()) == 1)
      {
        localObject2 = WXShareHelper.a();
        str1 = nng.a(this.this$0);
        str2 = this.val$title;
        str3 = this.val$desc;
        str4 = this.ake;
        if ("2".equals(this.amz)) {
          i = 0;
        }
        ((WXShareHelper)localObject2).a(str1, str2, (Bitmap)localObject1, str3, str4, i);
        break;
      }
      localObject2 = WxShareHelperFromReadInjoy.a();
      String str1 = nng.a(this.this$0);
      String str2 = this.val$title;
      String str3 = this.val$desc;
      String str4 = this.ake;
      i = j;
      if ("2".equals(this.amz)) {
        i = 0;
      }
      ((WxShareHelperFromReadInjoy)localObject2).a(str1, str2, (Bitmap)localObject1, str3, str4, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils.3
 * JD-Core Version:    0.7.0.1
 */