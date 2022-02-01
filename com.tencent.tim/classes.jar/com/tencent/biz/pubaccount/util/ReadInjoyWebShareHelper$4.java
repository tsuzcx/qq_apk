package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.util.Map;
import odm;
import odp;
import odq;
import skj;

public class ReadInjoyWebShareHelper$4
  implements Runnable
{
  public ReadInjoyWebShareHelper$4(odm paramodm, boolean paramBoolean1, Map paramMap, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    Object localObject = odm.a(this.this$0).getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return;
    }
    odm.c(this.this$0);
    if (this.this$0.a == null)
    {
      this.this$0.a = new odp(this);
      WxShareHelperFromReadInjoy.a().a(this.this$0.a);
    }
    this.this$0.Qt = String.valueOf(System.currentTimeMillis());
    localObject = (Bitmap)this.eI.remove("image");
    if ((this.ava) && (this.awy))
    {
      WxShareHelperFromReadInjoy.a().c(this.this$0.Qt, this.val$title, (Bitmap)localObject, this.val$desc, this.ake, this.val$miniProgramPath);
      return;
    }
    this.this$0.c.g(new odq(this, (Bitmap)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.4
 * JD-Core Version:    0.7.0.1
 */