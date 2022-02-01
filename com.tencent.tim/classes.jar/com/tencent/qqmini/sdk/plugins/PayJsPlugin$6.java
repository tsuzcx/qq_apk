package com.tencent.qqmini.sdk.plugins;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_PAY.MiniAppMidasPay.StQueryStarCurrencyRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$6
  implements AsyncResult
{
  PayJsPlugin$6(PayJsPlugin paramPayJsPlugin, PayJsPlugin.IStarQueryListener paramIStarQueryListener) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.i("PayJsPlugin", "invokeMidasQuery receive isSuc= " + paramBoolean + " ret=" + paramJSONObject);
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("resultCode", -1);
        paramJSONObject.put("errMsg", "系统错误");
        if (this.val$listener != null) {
          this.val$listener.onResult(false, paramJSONObject);
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        QMLog.e("PayJsPlugin", "invokeMidasQuery JSONException ", paramJSONObject);
        return;
      }
      try
      {
        Object localObject = (MiniAppMidasPay.StQueryStarCurrencyRsp)paramJSONObject.get("response");
        int i = paramJSONObject.getInt("resultCode");
        String str = paramJSONObject.getString("errMsg");
        paramJSONObject = new JSONObject();
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject(new HashMap());
        localJSONObject1.put("attachInfo", ((MiniAppMidasPay.StQueryStarCurrencyRsp)localObject).extInfo.attachInfo.get());
        localJSONObject1.put("mapInfo", localJSONObject2);
        paramJSONObject.put("resultCode", i);
        paramJSONObject.put("errMsg", str);
        paramJSONObject.put("extInfo", localJSONObject1);
        paramJSONObject.put("rechargeNum", ((MiniAppMidasPay.StQueryStarCurrencyRsp)localObject).rechargeNum.get());
        paramJSONObject.put("remainder", ((MiniAppMidasPay.StQueryStarCurrencyRsp)localObject).remainder.get());
        localObject = ((MiniAppMidasPay.StQueryStarCurrencyRsp)localObject).offerid.get();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!QUAUtil.isQQApp())) {
          this.this$0.mRealOfferId = ((String)localObject);
        }
        QMLog.i("PayJsPlugin", "invokeMidasQuery receive isSuc= " + paramBoolean + " resObj=" + paramJSONObject.toString());
        if (this.val$listener != null)
        {
          this.val$listener.onResult(true, paramJSONObject);
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        QMLog.e("PayJsPlugin", "invokeMidasQuery failed", paramJSONObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */