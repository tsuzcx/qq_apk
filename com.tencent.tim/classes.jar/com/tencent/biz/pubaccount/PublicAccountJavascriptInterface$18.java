package com.tencent.biz.pubaccount;

import com.tencent.common.app.AppInterface;
import ocp;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountJavascriptInterface$18
  implements Runnable
{
  PublicAccountJavascriptInterface$18(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, AppInterface paramAppInterface, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    boolean bool = ocp.c(this.b, this.VD);
    try
    {
      this.R.put("follow", bool);
      this.this$0.callJs(this.val$callback, new String[] { "{ret:0, response:" + this.R.toString() + "}" });
      return;
    }
    catch (JSONException localJSONException)
    {
      this.this$0.callJs(this.val$callback, new String[] { "{ret:-2, response:" + this.R.toString() + "}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.18
 * JD-Core Version:    0.7.0.1
 */