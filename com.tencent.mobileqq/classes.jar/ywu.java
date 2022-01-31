import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class ywu
  implements yxe
{
  public boolean a(ywk paramywk, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramywk != null) {}
    for (paramVarArgs = paramywk.a(); (paramywk == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      yxp.d("GdtDeviceJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("deviceId", yys.a(paramVarArgs));
    }
    catch (JSONException localJSONException)
    {
      try
      {
        for (;;)
        {
          paramywk.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramywk != null) {
            paramString = paramywk.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getDeviceId", paramString);
          return true;
          localJSONException = localJSONException;
          yxp.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", localJSONException);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          yxp.d("GdtDeviceJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywu
 * JD-Core Version:    0.7.0.1
 */