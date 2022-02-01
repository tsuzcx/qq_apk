package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.util.HashMap;
import jqc;
import odm;
import org.json.JSONObject;

public class ReadInjoyWebShareHelper$3
  implements Runnable
{
  public ReadInjoyWebShareHelper$3(odm paramodm, HashMap paramHashMap, String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    Object localObject2 = jqc.b(this.eI);
    Object localObject1 = (String)((HashMap)localObject2).get("share_url");
    if (localObject1 == null) {
      localObject1 = this.ake;
    }
    for (;;)
    {
      String str = (String)((HashMap)localObject2).get("image_url");
      localObject2 = str;
      if (str == null) {
        localObject2 = this.akc;
      }
      localObject1 = new ReadInjoyWebShareHelper.3.1(this, (String)localObject1, (String)localObject2);
      if (odm.a(this.this$0).getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
      {
        odm.a(this.this$0).runOnUiThread((Runnable)localObject1);
        return;
      }
      odm.a(this.this$0).a().runOnUiThread((Runnable)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.3
 * JD-Core Version:    0.7.0.1
 */