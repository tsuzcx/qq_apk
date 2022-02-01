import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.proxyimpl.AdProxyImpl.d;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBoxADLisener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asto
  implements AdProxy.ICmdListener
{
  public asto(AdProxyImpl.d paramd, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.a.a != null) {
        this.a.a.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
    }
    for (;;)
    {
      return;
      int i;
      String str;
      try
      {
        i = paramJSONObject.getInt("retCode");
        str = paramJSONObject.getString("errMsg");
        paramJSONObject = paramJSONObject.getString("response");
        if ((i != 0) || (TextUtils.isEmpty(paramJSONObject))) {
          break label283;
        }
        if (new JSONObject(paramJSONObject).optJSONArray("pos_ads_info").getJSONObject(0).optInt("ret", -1) == 0) {
          break label164;
        }
        if (this.a.a == null) {
          continue;
        }
        this.a.a.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
      }
      if (this.a.a != null)
      {
        this.a.a.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        return;
        label164:
        this.a.b = tgo.a(this.val$activity).a(new GdtAdBoxData(paramJSONObject)).a(new astp(this)).a();
        if (this.a.b != null)
        {
          if (this.a.a != null) {
            this.a.a.onLoad();
          }
          AdProxyImpl.a(this.a.this$0, paramJSONObject, this.a.mAdType);
          return;
        }
        if (this.a.a != null)
        {
          this.a.a.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          return;
          label283:
          int j = PluginConst.AdConst.getRetCodeByServerResult(i);
          if (j != -1) {
            i = j;
          }
          while (this.a.a != null)
          {
            this.a.a.onError(i, str);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asto
 * JD-Core Version:    0.7.0.1
 */