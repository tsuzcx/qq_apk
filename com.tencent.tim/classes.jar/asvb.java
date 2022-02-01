import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import org.json.JSONException;
import org.json.JSONObject;

class asvb
  extends SosoInterface.a
{
  asvb(asuz paramasuz, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, boolean paramBoolean5, boolean paramBoolean6, AsyncResult paramAsyncResult)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.a;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if ((this.val$isWgs84) && (paramSosoLbsInfo.cf != 0.0D) && (paramSosoLbsInfo.cg != 0.0D))
        {
          localJSONObject.put("latitude", paramSosoLbsInfo.cf);
          localJSONObject.put("longitude", paramSosoLbsInfo.cg);
        }
        for (;;)
        {
          localJSONObject.put("speed", paramSosoLbsInfo.speed);
          localJSONObject.put("accuracy", paramSosoLbsInfo.accuracy);
          if (this.val$needAltitude) {
            localJSONObject.put("altitude", paramSosoLbsInfo.altitude);
          }
          localJSONObject.put("verticalAccuracy", 0.0D);
          localJSONObject.put("horizontalAccuracy", paramSosoLbsInfo.accuracy);
          this.val$asyncResult.onReceiveResult(true, localJSONObject);
          return;
          localJSONObject.put("latitude", paramSosoLbsInfo.cd);
          localJSONObject.put("longitude", paramSosoLbsInfo.ce);
        }
        paramSosoLbsInfo = new JSONObject();
      }
      catch (JSONException paramSosoLbsInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MiniAppProxyImpl", 2, paramSosoLbsInfo, new Object[0]);
        }
        this.val$asyncResult.onReceiveResult(false, new JSONObject());
        return;
      }
    }
    try
    {
      paramSosoLbsInfo.put("errCode", paramInt);
      this.val$asyncResult.onReceiveResult(false, paramSosoLbsInfo);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("MiniAppProxyImpl", 1, "getLocationJsonObject exception:", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvb
 * JD-Core Version:    0.7.0.1
 */