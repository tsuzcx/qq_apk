import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RewardedVideoAdPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.proxyimpl.AdProxyImpl.f;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener;
import org.json.JSONException;
import org.json.JSONObject;

public class astr
  implements AdProxy.ICmdListener
{
  public astr(AdProxyImpl.f paramf) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int j = 1;
    QLog.i("AdProxyImpl", 1, "onCmdListener");
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.b.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null) {
        this.b.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
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
          break label326;
        }
        if (new JSONObject(paramJSONObject).optInt("ret", -1) != 102006) {
          break label167;
        }
        QLog.e("AdProxyImpl", 1, "mockAdJson failed ret == 102006");
        if (this.b.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener == null) {
          continue;
        }
        this.b.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
        return;
      }
      catch (JSONException paramJSONObject) {}
      if (this.b.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null)
      {
        this.b.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
        return;
        label167:
        str = AdProxyImpl.a(this.b.this$0, paramJSONObject);
        paramJSONObject = null;
        if (!TextUtils.isEmpty(str)) {
          paramJSONObject = AdProxyImpl.a(this.b.this$0, str);
        }
        if (paramJSONObject != null)
        {
          paramJSONObject = new GdtAd(paramJSONObject);
          if (paramJSONObject.isValid())
          {
            tgh.a().a(paramJSONObject);
            AdProxyImpl.f localf = this.b;
            i = j;
            if (this.b.mDeviceOrientation == 90) {
              i = 0;
            }
            localf.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData = RewardedVideoAdPlugin.mockMVPageData(paramJSONObject, str, i);
            if (this.b.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoPageData != null)
            {
              if (this.b.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null) {
                this.b.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onADLoad();
              }
              AdProxyImpl.a(this.b.this$0, str, this.b.mAdType);
            }
          }
        }
        else
        {
          QLog.e("AdProxyImpl", 1, "adInfo is null");
          return;
          label326:
          j = PluginConst.AdConst.getRetCodeByServerResult(i);
          if (j != -1) {
            i = j;
          }
          while (this.b.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener != null)
          {
            this.b.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IRewardVideoAdListener.onError(i, str);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     astr
 * JD-Core Version:    0.7.0.1
 */