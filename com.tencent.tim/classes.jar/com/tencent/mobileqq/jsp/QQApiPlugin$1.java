package com.tencent.mobileqq.jsp;

import aiju;
import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import java.util.HashMap;
import jqc;
import org.json.JSONObject;

public class QQApiPlugin$1
  implements Runnable
{
  public QQApiPlugin$1(aiju paramaiju, HashMap paramHashMap, String paramString1, String paramString2, String paramString3, String paramString4, JSONObject paramJSONObject, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt1, String paramString11, int paramInt2, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject2 = jqc.b(this.eI);
    Object localObject1 = (String)((HashMap)localObject2).get("share_url");
    if (localObject1 == null) {
      localObject1 = this.ake;
    }
    for (;;)
    {
      String str1 = (String)((HashMap)localObject2).get("image_url");
      if (str1 == null) {
        str1 = this.akc;
      }
      for (;;)
      {
        String str2 = (String)((HashMap)localObject2).get("flash_url");
        localObject2 = str2;
        if (str2 == null) {
          localObject2 = this.bOm;
        }
        localObject1 = new QQApiPlugin.1.1(this, (String)localObject1, str1, (String)localObject2);
        if (this.val$activity.getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
        {
          this.val$activity.runOnUiThread((Runnable)localObject1);
          return;
        }
        this.this$0.mRuntime.a().runOnUiThread((Runnable)localObject1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */