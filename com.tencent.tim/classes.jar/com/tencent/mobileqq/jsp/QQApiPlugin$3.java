package com.tencent.mobileqq.jsp;

import aiju;
import aijv;
import aijw;
import aijx;
import android.app.Activity;
import android.graphics.Bitmap;
import arhz;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;
import skj;

public class QQApiPlugin$3
  implements Runnable
{
  public QQApiPlugin$3(aiju paramaiju, String paramString1, String paramString2, int paramInt, Map paramMap, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    int j = 0;
    int i = 0;
    Object localObject = this.this$0.mRuntime.getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return;
    }
    if (this.this$0.m == null) {
      this.this$0.bQ((Activity)localObject);
    }
    if ((this.this$0.m != null) && (this.this$0.m.isShowing())) {
      this.this$0.m.dismiss();
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a == null)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a = new aijv(this);
      WXShareHelper.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
    }
    if ((this.ddD == 1) && (this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$a == null))
    {
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$a = new aijw(this);
      WxShareHelperFromReadInjoy.a().a(this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$a);
    }
    this.this$0.Qt = String.valueOf(System.currentTimeMillis());
    localObject = (Bitmap)this.eI.remove("image");
    if ("audio".equals(this.apQ))
    {
      localWXShareHelper = WXShareHelper.a();
      str1 = this.this$0.Qt;
      str2 = this.val$title;
      str3 = this.val$desc;
      str4 = this.ake;
      if ("2".equals(this.amz)) {}
      for (;;)
      {
        localWXShareHelper.a(str1, str2, (Bitmap)localObject, str3, str4, i, this.bOm);
        return;
        i = 1;
      }
    }
    if (this.ddD == 1)
    {
      this.this$0.c.g(new aijx(this, (Bitmap)localObject));
      return;
    }
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str1 = this.this$0.Qt;
    String str2 = this.val$title;
    String str3 = this.val$desc;
    String str4 = this.ake;
    if ("2".equals(this.amz)) {}
    for (i = j;; i = 1)
    {
      localWXShareHelper.a(str1, str2, (Bitmap)localObject, str3, str4, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQApiPlugin.3
 * JD-Core Version:    0.7.0.1
 */