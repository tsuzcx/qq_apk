import android.os.Bundle;
import com.tencent.mobileqq.WebSsoBody.WebSsoControlData;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class svg
  implements BusinessObserver
{
  svg(svd paramsvd, String paramString1, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
          localWebSsoResponseBody.mergeFrom(paramBundle);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("data", localWebSsoResponseBody.data.get());
          localJSONObject.put("retcode", localWebSsoResponseBody.ret.get());
          localJSONObject.put("cret", 0);
          this.a.callJs(this.val$callback, new String[] { localJSONObject.toString() });
          if (((WebSsoBody.WebSsoControlData)localWebSsoResponseBody.controlData.get()).frequency.has()) {
            this.a.minDuration = ((WebSsoBody.WebSsoControlData)localWebSsoResponseBody.controlData.get()).frequency.get();
          }
          if (((WebSsoBody.WebSsoControlData)localWebSsoResponseBody.controlData.get()).packageSize.has()) {
            this.a.maxSize = ((WebSsoBody.WebSsoControlData)localWebSsoResponseBody.controlData.get()).packageSize.get();
          }
          if (QLog.isDevelopLevel()) {
            QLog.i("SSOWebviewPlugin", 2, String.format("onReceive cmd=%s %b frequency=%d result=%s", new Object[] { this.val$cmd, Boolean.valueOf(((WebSsoBody.WebSsoControlData)localWebSsoResponseBody.controlData.get()).frequency.has()), Integer.valueOf(this.a.minDuration), localJSONObject }));
          }
        }
        if (!QLog.isColorLevel()) {
          break label385;
        }
        if (paramBundle == null) {
          break label386;
        }
        paramBoolean = true;
        QLog.i("SSOWebviewPlugin", 2, String.format("onReceive data!=null[%b]", new Object[] { Boolean.valueOf(paramBoolean) }));
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle = new JSONObject();
        try
        {
          paramBundle.put("cret", 2);
          this.a.callJs(this.val$callback, new String[] { paramBundle.toString() });
          return;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          continue;
        }
      }
      paramBundle = new JSONObject();
      paramBundle.put("cret", 1);
      this.a.callJs(this.val$callback, new String[] { paramBundle.toString() });
      return;
      label385:
      return;
      label386:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svg
 * JD-Core Version:    0.7.0.1
 */