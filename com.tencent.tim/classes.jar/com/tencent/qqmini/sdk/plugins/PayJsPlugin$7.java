package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.PayResponse;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$7
  implements PayProxy.IPayResultCallBack
{
  PayJsPlugin$7(PayJsPlugin paramPayJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onPayCallBack(PayProxy.PayResponse paramPayResponse)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resultCode", paramPayResponse.getResultCode());
      label19:
      if ((paramPayResponse.getResultCode() == 0) && (paramPayResponse.getPayState() == 0)) {
        PayJsPlugin.access$900(this.this$0, this.val$req, localJSONObject);
      }
      for (;;)
      {
        QMLog.i("PayJsPlugin", "handleMidasMonthCardPay onPayCallBack, , resultCode = " + paramPayResponse.getResultCode() + ", resultMsg = " + paramPayResponse.getResultMsg() + "extendInfo = " + paramPayResponse.getExtendInfo());
        return;
        if ((paramPayResponse.getResultCode() == 2) || (paramPayResponse.getPayState() == 1))
        {
          PayJsPlugin.access$000(this.this$0, this.val$req, localJSONObject);
        }
        else
        {
          String str = paramPayResponse.getResultMsg();
          PayJsPlugin.access$700(this.this$0, this.val$req, localJSONObject, str);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      break label19;
    }
  }
  
  public void payNeedLogin()
  {
    QMLog.e("PayJsPlugin", "handleMidasMonthCardPay payNeedLogin");
    PayJsPlugin.access$700(this.this$0, this.val$req, null, "payNeedLogin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */