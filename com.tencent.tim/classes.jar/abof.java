import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class abof
  implements tzd
{
  abof(aboc paramaboc, CmGameInitParams paramCmGameInitParams, long paramLong) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[onFailure], code:" + paramInt + ",msg:" + paramString);
    try
    {
      paramString = abmt.a();
      if (paramString != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", paramInt);
        localJSONObject.put("type", "failure");
        paramString.callbackFromRequest(this.Od, 0, "cs.xy_login.local", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void onPermission(int paramInt)
  {
    QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[onPermission], code:" + paramInt);
    if (this.d != null) {
      this.d.accessTokenRet = 2;
    }
    try
    {
      ApolloCmdChannel localApolloCmdChannel = abmt.a();
      if (localApolloCmdChannel != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", paramInt);
        localJSONObject.put("type", "unauthorized");
        localApolloCmdChannel.callbackFromRequest(this.Od, 0, "cs.xy_login.local", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, localThrowable, new Object[0]);
    }
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    try
    {
      ApolloCmdChannel localApolloCmdChannel = abmt.a();
      if (localApolloCmdChannel != null)
      {
        paramJSONObject.put("ret", 0);
        paramJSONObject.put("type", "success");
        aboc.a(this.this$0, paramJSONObject.optString("access_token"));
        localApolloCmdChannel.callbackFromRequest(this.Od, 0, "cs.xy_login.local", paramJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramJSONObject, new Object[0]);
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abof
 * JD-Core Version:    0.7.0.1
 */