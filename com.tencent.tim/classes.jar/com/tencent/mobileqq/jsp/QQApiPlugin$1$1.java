package com.tencent.mobileqq.jsp;

import aiju;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import ocp;
import org.json.JSONException;
import org.json.JSONObject;

class QQApiPlugin$1$1
  implements Runnable
{
  QQApiPlugin$1$1(QQApiPlugin.1 param1, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Activity localActivity = this.a.this$0.mRuntime.getActivity();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    do
    {
      do
      {
        return;
        try
        {
          if (!"1".equals(this.a.amz)) {
            break;
          }
          this.a.this$0.a(this.a.aE, this.a.amz, this.a.val$title, this.a.val$desc, this.apR, this.apS, this.a.apQ, this.bOr);
          ocp.c(1002, this.a.ake, this.a.bOn, this.a.bOo, this.a.bOp);
          return;
        }
        catch (JSONException localJSONException) {}
      } while (!QLog.isColorLevel());
      QLog.d("QQApi", 2, "shareMsg error: " + localJSONException.toString());
      return;
      if ((!"2".equals(this.a.amz)) && (!"3".equals(this.a.amz))) {
        break;
      }
      this.a.this$0.a(this.a.aE, this.a.amz, this.a.val$title, this.a.val$desc, this.apR, this.apS, this.a.apQ, this.bOr, this.a.ddD);
      if ("2".equals(this.a.amz)) {
        ocp.c(1003, this.a.ake, this.a.bOn, this.a.bOo, this.a.bOp);
      }
    } while (!"3".equals(this.a.amz));
    ocp.c(1004, this.a.ake, this.a.bOn, this.a.bOo, this.a.bOp);
    return;
    if ("4".equals(this.a.amz))
    {
      this.a.this$0.k(this.a.val$title, this.a.val$desc, this.apR, this.apS);
      ocp.c(1005, this.a.ake, this.a.bOn, this.a.bOo, this.a.bOp);
      return;
    }
    if ("5".equals(this.a.amz))
    {
      this.a.this$0.e(this.a.val$title, this.a.val$desc, this.apR, this.apS, 6);
      return;
    }
    if ("6".equals(this.a.amz))
    {
      this.a.this$0.e(this.a.val$title, this.a.val$desc, this.apR, this.apS, 7);
      return;
    }
    if ((!TextUtils.isEmpty(this.a.bOq)) && (this.a.aE.has("is_tribe_short_video")) && (this.a.bOq.equals("true")))
    {
      this.a.this$0.b(this.a.aE, this.a.amz, this.a.val$title, this.a.val$desc, this.a.ake, this.a.akc, this.a.apQ, this.a.bOm, this.a.ddE);
      return;
    }
    this.a.this$0.c(this.a.aE, this.a.amz, this.a.val$title, this.a.val$desc, this.apR, this.apS, this.a.apQ, this.bOr, this.a.ddE);
    ocp.c(1001, this.a.ake, this.a.bOn, this.a.bOo, this.a.bOp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQApiPlugin.1.1
 * JD-Core Version:    0.7.0.1
 */