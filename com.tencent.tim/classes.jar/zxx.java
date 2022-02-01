import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.PublicQuickPayManager.1;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class zxx
  implements Manager
{
  private aqlh b;
  private QQAppInterface f;
  public Context mContext;
  
  public zxx(QQAppInterface paramQQAppInterface)
  {
    this.f = paramQQAppInterface;
    this.mContext = BaseApplication.getContext();
  }
  
  private void a(zxx.a parama, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (parama != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("retCode", paramInt);
      localBundle.putString("retMsg", paramString1);
      localBundle.putString("payTime", paramString2);
      localBundle.putString("orderId", paramString3);
      parama.bL(localBundle);
    }
  }
  
  public boolean a(String paramString, JSONObject paramJSONObject, zxx.a parama)
  {
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PublicQuickPayManager", 2, "jsonParams=" + paramJSONObject + ", puin=" + paramString);
      }
      return false;
    }
    if (!((aaai)this.f.getManager(245)).iH(paramString))
    {
      showDialog();
      a(parama, -4, "auth failed!", null, null);
      return false;
    }
    String str1 = paramJSONObject.optString("appId");
    paramString = paramJSONObject.optString("orderId");
    Object localObject = paramJSONObject.optString("expireTime");
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", str1);
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      if (Long.parseLong((String)localObject) <= NetConnInfoCenter.getServerTimeMillis() / 1000L)
      {
        showDialog();
        a(parama, -6, "expireTime overdue", null, null);
        return false;
      }
      parama = new PublicQuickPayManager.1(this, new Handler(), parama, paramString);
      localBundle.putParcelable("_qwallet_payresult_receiver", parama);
      paramString = "";
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("tokenId", paramJSONObject.optString("tokenId"));
        String str2 = paramJSONObject.optString("bargainor_id", "0");
        paramJSONObject = paramJSONObject.optString("channel", "other");
        ((JSONObject)localObject).put("appInfo", "appid#" + str1 + "|bargainor_id#" + str2 + "|channel#" + paramJSONObject);
        paramJSONObject = ((JSONObject)localObject).toString();
        paramString = paramJSONObject;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          paramJSONObject.printStackTrace();
        }
      }
      localBundle.putString("payparmas_json", paramString);
      localBundle.putInt("payparmas_paytype", 9);
      localBundle.putLong("vacreport_key_seq", VACDReportUtil.a(null, "qqwallet", "publicpaymsg.pay.result", "payinvoke", null, 0, null));
      localBundle.putInt("pay_requestcode", 9);
      PayBridgeActivity.newPay(this.f, BaseActivity.sTopActivity, parama, 9, localBundle);
      if (QLog.isColorLevel()) {
        QLog.e("PublicQuickPayManager", 2, "open OpenPayActivity success");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PublicQuickPayManager", 2, "publicQuickPay parameters parse error");
    }
    showDialog();
    a(parama, -4, "params parse error", null, null);
    return false;
  }
  
  public void onDestroy() {}
  
  public void showDialog()
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    this.b = aqha.a(this.mContext, acfp.m(2131710246), "", acfp.m(2131710247), new zxy(this), null, null);
    this.b.show();
  }
  
  public static abstract interface a
  {
    public abstract void bL(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zxx
 * JD-Core Version:    0.7.0.1
 */