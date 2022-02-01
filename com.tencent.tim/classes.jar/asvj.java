import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.7.1;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;

public class asvj
  implements EIPCResultCallback
{
  asvj(asuz paramasuz, MiniAppInfo paramMiniAppInfo) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    asuz.a(this.this$0).removeCallbacksAndMessages(Integer.valueOf(1000));
    if (paramEIPCResult != null)
    {
      QLog.d("MiniAppProxyImpl", 1, "onMoreClick onCallback code : " + paramEIPCResult.code);
      if (paramEIPCResult.code == 0)
      {
        paramEIPCResult = paramEIPCResult.data;
        int i = paramEIPCResult.getInt("topType");
        paramEIPCResult = paramEIPCResult.getIntegerArrayList("backHomeSceneList");
        if ((paramEIPCResult != null) && (paramEIPCResult.size() > 0))
        {
          asuz.a(this.this$0).clear();
          asuz.a(this.this$0).addAll(paramEIPCResult);
        }
        if (this.val$miniAppInfo != null) {
          this.val$miniAppInfo.topType = i;
        }
      }
    }
    AppBrandTask.runTaskOnUiThread(new MiniAppProxyImpl.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvj
 * JD-Core Version:    0.7.0.1
 */