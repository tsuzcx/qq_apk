import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.unifiedebug.RemoteDebugReportMsg.RemoteLogReq;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class aqaa
{
  public QQAppInterface mApp;
  public BusinessObserver observer = new aqab(this);
  
  public aqaa(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public void a(long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    RemoteDebugReportMsg.RemoteLogReq localRemoteLogReq = new RemoteDebugReportMsg.RemoteLogReq();
    localRemoteLogReq.str_seq.set(String.valueOf(paramLong));
    localRemoteLogReq.str_data.set(b(paramInt, paramJSONObject));
    NewIntent localNewIntent = new NewIntent(this.mApp.getApp(), apzz.class);
    localNewIntent.putExtra("extra_cmd", "ClubDebugging.report");
    localNewIntent.putExtra("extra_data", localRemoteLogReq.toByteArray());
    localNewIntent.setObserver(this.observer);
    this.mApp.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedDebugReporter", 2, "reportStatus: seq=" + paramLong + ", statusCode=" + paramInt + ", data=" + paramJSONObject);
    }
  }
  
  public String b(int paramInt, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("status", paramInt);
      JSONObject localJSONObject1 = paramJSONObject;
      if (paramJSONObject == null) {
        localJSONObject1 = new JSONObject();
      }
      localJSONObject2.put("data", localJSONObject1);
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("UnifiedDebugReporter", 2, "reportStatus: exception=" + paramJSONObject.getMessage());
        }
      }
    }
    return localJSONObject2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqaa
 * JD-Core Version:    0.7.0.1
 */