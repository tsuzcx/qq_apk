import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.5.1;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

public class asvh
  implements MiniAppCmdInterface
{
  asvh(asuz paramasuz, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.5.1(this));
      QLog.d("MiniAppProxyImpl", 2, "sendSetUserAppTopRequest, success to set top");
      return;
    }
    QLog.e("MiniAppProxyImpl", 1, "sendSetUserAppTopRequest, fail to set top");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvh
 * JD-Core Version:    0.7.0.1
 */