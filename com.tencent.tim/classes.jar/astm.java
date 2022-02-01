import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.AdProxyImpl;
import com.tencent.qqmini.proxyimpl.AdProxyImpl.b;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class astm
  implements AdProxy.ICmdListener
{
  public astm(AdProxyImpl.b paramb, Activity paramActivity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((!paramBoolean) || (paramJSONObject == null)) {
      if (this.a.a != null) {
        this.a.a.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
      }
    }
    label309:
    label320:
    label349:
    do
    {
      do
      {
        return;
        for (;;)
        {
          try
          {
            int i = paramJSONObject.getInt("retCode");
            paramJSONObject = paramJSONObject.getString("response");
            if ((i != 0) || (TextUtils.isEmpty(paramJSONObject))) {
              break label349;
            }
            String str = AdProxyImpl.a(this.a.this$0, paramJSONObject);
            paramJSONObject = null;
            if (!TextUtils.isEmpty(str)) {
              paramJSONObject = AdProxyImpl.a(this.a.this$0, str);
            }
            if (paramJSONObject == null) {
              break label309;
            }
            GdtAd localGdtAd = new GdtAd(paramJSONObject);
            tgh.a().a(localGdtAd);
            this.a.jH = paramJSONObject.report_info.exposure_url.get();
            this.a.axI = paramJSONObject.report_info.trace_info.aid.get();
            this.a.mGdtBannerView = AdProxyImpl.a(this.a.this$0, this.val$activity, paramJSONObject, this.a.mWidth, this.a.mHeight, this.a.miniAppContext);
            if (this.a.mGdtBannerView == null) {
              break label320;
            }
            if (this.a.a != null)
            {
              this.a.a.onADReceive();
              AdProxyImpl.a(this.a.this$0, this.a.miniAppContext, paramJSONObject);
            }
            AdProxyImpl.a(this.a.this$0, str, this.a.mAdType);
            return;
          }
          catch (JSONException paramJSONObject)
          {
            QLog.e("AdProxyImpl", 1, "loadAD, err", paramJSONObject);
          }
          if (this.a.a == null) {
            break;
          }
          this.a.a.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
          return;
          QLog.e("AdProxyImpl", 1, "adInfo is null");
        }
      } while (this.a.a == null);
      this.a.a.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
      return;
    } while (this.a.a == null);
    this.a.a.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     astm
 * JD-Core Version:    0.7.0.1
 */