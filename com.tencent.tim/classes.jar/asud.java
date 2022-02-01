import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import org.json.JSONObject;

class asud
  implements awms
{
  asud(astt paramastt, AsyncResult paramAsyncResult) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    JSONObject localJSONObject;
    if (this.val$asyncResult != null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("response", paramGetAdsRsp);
      this.val$asyncResult.onReceiveResult(paramBoolean, localJSONObject);
      return;
    }
    catch (Throwable paramGetAdsRsp)
    {
      for (;;)
      {
        QLog.e("ChannelProxyImpl", 1, "tianshuRequestAdv", paramGetAdsRsp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asud
 * JD-Core Version:    0.7.0.1
 */