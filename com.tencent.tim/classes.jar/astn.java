import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.proxyimpl.AdProxyImpl.c;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBlockAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class astn
  implements AdProxy.ICmdListener
{
  public astn(AdProxyImpl.c paramc, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener != null) {
        this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
    }
    label264:
    label270:
    label474:
    do
    {
      do
      {
        int i;
        String str;
        int j;
        int k;
        do
        {
          return;
          for (;;)
          {
            try
            {
              for (;;)
              {
                i = paramJSONObject.getInt("retCode");
                str = paramJSONObject.getString("response");
                StringBuilder localStringBuilder = new StringBuilder().append("getBlockADInfo receive retCode= ").append(i).append(" adJson=");
                if ((str == null) || (str.length() <= 1024)) {
                  break label264;
                }
                paramJSONObject = str.substring(0, 1024);
                QLog.i("AdProxyImpl", 1, paramJSONObject);
                if (i != 0) {
                  break label474;
                }
                paramBoolean = TextUtils.isEmpty(str);
                if (paramBoolean) {
                  break label474;
                }
                try
                {
                  if (new JSONObject(str).optJSONArray("pos_ads_info").getJSONObject(0).optInt("ret", -1) == 0) {
                    break label270;
                  }
                  if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener == null) {
                    break;
                  }
                  this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
                  return;
                }
                catch (Throwable paramJSONObject)
                {
                  QLog.e("AdProxyImpl", 1, "check adsJson exception:", paramJSONObject);
                }
              }
              if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener == null) {
                break;
              }
              this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
              return;
            }
            catch (JSONException paramJSONObject)
            {
              QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
            }
            if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener == null) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
            return;
            paramJSONObject = str;
          }
          paramJSONObject = AdUtils.convertJson2GdtAds(str);
          this.a.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo.setAdMiniAppInfo(paramJSONObject);
          this.a.DR = BlockAdManager.getInstance().getReportUrlList(paramJSONObject);
          this.a.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView = BlockAdManager.getInstance().genarateBlockAdView(this.val$activity, this.a.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo);
          i = this.a.jdField_a_of_type_ComTencentMobileqqMinigameWidgetBlockAdView.getRealAdNum();
          j = this.a.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo.getRealWidth();
          k = this.a.jdField_a_of_type_ComTencentMobileqqMinigameDataBlockAdInfo.getRealHeight();
          if (i >= 1) {
            break;
          }
        } while (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener == null);
        this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1009, PluginConst.AdConst.ERROR_MSG_INVALID_POSITION);
        return;
        if (paramJSONObject != null)
        {
          if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener != null) {
            this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onADReceive(i, j, k);
          }
          AdProxyImpl.a(this.a.this$0, str, this.a.mAdType);
          return;
        }
      } while (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener == null);
      this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      return;
    } while (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener == null);
    this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBlockAdListener.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     astn
 * JD-Core Version:    0.7.0.1
 */