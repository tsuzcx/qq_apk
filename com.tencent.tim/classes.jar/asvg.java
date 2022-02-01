import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.4.1;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class asvg
  implements EIPCResultCallback
{
  asvg(asuz paramasuz, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.code == -100))
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.4.1(this));
      return;
    }
    asuz.b(this.this$0, this.val$miniAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvg
 * JD-Core Version:    0.7.0.1
 */