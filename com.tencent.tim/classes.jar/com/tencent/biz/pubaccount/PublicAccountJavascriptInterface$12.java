package com.tencent.biz.pubaccount;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountJavascriptInterface$12
  extends Thread
{
  PublicAccountJavascriptInterface$12(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.val$jsonParams);
      String str2 = localJSONObject.optString("callid");
      String str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2.replace("\\", "\\\\").replace("'", "\\'");
      }
      this.R.put("callid", str1);
      str1 = localJSONObject.optString("url");
      if (!TextUtils.isEmpty(str1))
      {
        this.this$0.callJs(this.val$callback, new String[] { "{ret:1, response:" + this.R.toString() + "}" });
        str1 = PublicAccountJavascriptInterface.access$500(str1);
        if (str1 != null)
        {
          str1 = str1.replace("\\", "\\\\").replace("'", "\\'");
          this.R.put("data", str1);
          this.this$0.callJs(this.val$callback, new String[] { "{ret:0, response:" + this.R.toString() + "}" });
          return;
        }
        this.this$0.callJs(this.val$callback, new String[] { "{ret:-10, response:" + this.R.toString() + "}" });
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      this.this$0.callJs(this.val$callback, new String[] { "{ret:-2, response:" + this.R.toString() + "}" });
      return;
    }
    this.this$0.callJs(this.val$callback, new String[] { "{ret:-4, response:" + this.R.toString() + "}" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountJavascriptInterface.12
 * JD-Core Version:    0.7.0.1
 */