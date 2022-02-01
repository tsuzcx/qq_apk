import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdHelper.MiniAppCmdCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONObject;

class astz
  implements MiniAppSSOCmdHelper.MiniAppCmdCallback<INTERFACE.StJudgeTimingRsp>
{
  astz(astt paramastt, AsyncResult paramAsyncResult) {}
  
  public void onReceived(boolean paramBoolean, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp)
  {
    JSONObject localJSONObject;
    if (this.val$listener != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("response", paramStJudgeTimingRsp);
      this.val$listener.onReceiveResult(paramBoolean, localJSONObject);
      return;
    }
    catch (Throwable paramStJudgeTimingRsp)
    {
      for (;;)
      {
        QLog.e("ChannelProxyImpl", 1, "tianshuRequestAdv", paramStJudgeTimingRsp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     astz
 * JD-Core Version:    0.7.0.1
 */