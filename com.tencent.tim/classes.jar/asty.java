import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class asty
  implements EIPCResultCallback
{
  asty(astt paramastt, IMiniAppContext paramIMiniAppContext, String paramString, AsyncResult paramAsyncResult) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null) && (paramEIPCResult.data.getBoolean("hasCreateOrManageTroop")))
    {
      TroopApplicationListUtil.startTroopActivityAndAddTroopApplication(this.val$miniAppContext.getAttachedActivity(), this.val$appId, this.val$result);
      return;
    }
    try
    {
      paramEIPCResult = new JSONObject();
      paramEIPCResult.put("errMsg", "no group");
      this.val$result.onReceiveResult(false, paramEIPCResult);
      return;
    }
    catch (Exception paramEIPCResult)
    {
      QLog.e("ChannelProxyImpl", 1, "addGroupApp, exception: " + Log.getStackTraceString(paramEIPCResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asty
 * JD-Core Version:    0.7.0.1
 */