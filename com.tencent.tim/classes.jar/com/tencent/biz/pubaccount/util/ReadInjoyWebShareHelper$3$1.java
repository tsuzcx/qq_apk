package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import odm;
import org.json.JSONException;

class ReadInjoyWebShareHelper$3$1
  implements Runnable
{
  ReadInjoyWebShareHelper$3$1(ReadInjoyWebShareHelper.3 param3, String paramString1, String paramString2) {}
  
  public void run()
  {
    Activity localActivity = odm.a(this.a.this$0).getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    try
    {
      this.a.this$0.a(this.a.aE, this.a.val$title, this.a.val$desc, this.apR, this.apS, this.a.apQ, 13);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.3.1
 * JD-Core Version:    0.7.0.1
 */