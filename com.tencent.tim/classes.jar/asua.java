import NS_MINI_INTERFACE.INTERFACE.StReportExecuteRsp;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class asua
  implements MiniAppSSOCmdHelper.MiniAppCmdCallback<INTERFACE.StReportExecuteRsp>
{
  asua(astt paramastt, AsyncResult paramAsyncResult) {}
  
  public void onReceived(boolean paramBoolean, INTERFACE.StReportExecuteRsp paramStReportExecuteRsp)
  {
    JSONObject localJSONObject;
    if (this.val$listener != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("response", paramStReportExecuteRsp);
      this.val$listener.onReceiveResult(paramBoolean, localJSONObject);
      return;
    }
    catch (Throwable paramStReportExecuteRsp)
    {
      for (;;)
      {
        QLog.e("ChannelProxyImpl", 1, "tianshuRequestAdv", paramStReportExecuteRsp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asua
 * JD-Core Version:    0.7.0.1
 */