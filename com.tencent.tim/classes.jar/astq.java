import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.proxyimpl.AdProxyImpl.e;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.InterstitialADLisener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class astq
  implements AdProxy.ICmdListener
{
  public astq(AdProxyImpl.e parame, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int j = 0;
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.a.a != null) {
        this.a.a.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          i = paramJSONObject.getInt("retCode");
          localObject = paramJSONObject.getString("errMsg");
          paramJSONObject = paramJSONObject.getString("response");
          if ((i != 0) || (TextUtils.isEmpty(paramJSONObject))) {
            break label334;
          }
          localObject = new JSONObject(paramJSONObject).optJSONArray("pos_ads_info").getJSONObject(0);
          if (((JSONObject)localObject).optInt("ret", -1) == 0) {
            break label171;
          }
          if (this.a.a != null)
          {
            this.a.a.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
            return;
          }
        }
        catch (JSONException paramJSONObject)
        {
          QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
        }
      }
    } while (this.a.a == null);
    this.a.a.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
    return;
    label171:
    Object localObject = ((JSONObject)localObject).getJSONArray("ads_info").getJSONObject(0);
    GdtInterstitialParams localGdtInterstitialParams = new GdtInterstitialParams();
    localGdtInterstitialParams.a = AdProxyImpl.e.a(this.a, (JSONObject)localObject);
    if (this.a.mDeviceOrientation == 90) {}
    for (int i = j;; i = 1)
    {
      localGdtInterstitialParams.orientation = i;
      localGdtInterstitialParams.aOZ = true;
      this.a.c = new thm(this.val$activity, localGdtInterstitialParams);
      if (this.a.c != null)
      {
        if (this.a.a != null) {
          this.a.a.onLoad();
        }
        AdProxyImpl.a(this.a.this$0, paramJSONObject, this.a.mAdType);
        return;
      }
      if (this.a.a == null) {
        break;
      }
      this.a.a.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      return;
      label334:
      j = PluginConst.AdConst.getRetCodeByServerResult(i);
      if (j != -1) {
        i = j;
      }
      while (this.a.a != null)
      {
        this.a.a.onError(i, (String)localObject);
        return;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     astq
 * JD-Core Version:    0.7.0.1
 */