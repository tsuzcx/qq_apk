import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import org.json.JSONObject;

class asvn
  implements MiniAppCmdInterface
{
  asvn(asvm paramasvm, String paramString, IJsService paramIJsService, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.i("MiniSDKClientQIPCModule", 2, "createUpdatableMsg receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("retCode");
      String str = paramJSONObject.optString("errMsg");
      paramJSONObject = new JSONObject();
      if (i == 0) {}
      try
      {
        paramJSONObject.put("retCode", i);
        paramJSONObject.put("errMsg", str);
        while (this.a != null)
        {
          this.a.evaluateCallbackJs(this.val$callbackId, paramJSONObject.toString());
          return;
          paramJSONObject.put("retCode", 2);
          paramJSONObject.put("errMsg", this.val$event + ":fail " + str + "(" + i + ")");
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
        QLog.d("MiniSDKClientQIPCModule", 1, "createUpdatableMsg error, null jsService");
        return;
      }
    }
    QLog.d("MiniSDKClientQIPCModule", 1, "createUpdatableMsg error, null ret");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvn
 * JD-Core Version:    0.7.0.1
 */