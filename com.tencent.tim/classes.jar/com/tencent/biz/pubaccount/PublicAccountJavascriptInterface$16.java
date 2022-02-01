package com.tencent.biz.pubaccount;

import org.json.JSONObject;

class PublicAccountJavascriptInterface$16
  implements Runnable
{
  PublicAccountJavascriptInterface$16(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    long l = PublicAccountJavascriptInterface.access$000();
    try
    {
      PublicAccountJavascriptInterface.access$102(l);
      if (PublicAccountJavascriptInterface.access$100() > 52428800L)
      {
        this.this$0.callJs(this.val$callback, new String[] { "{ret:-12, response:" + this.R.toString() + "}" });
        return;
      }
    }
    finally {}
    this.this$0.a(this.val$jsonParams, this.val$callback, this.R);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.16
 * JD-Core Version:    0.7.0.1
 */