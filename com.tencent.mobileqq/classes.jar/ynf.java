import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class ynf
  implements ynl
{
  public boolean a(ymw paramymw, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramymw != null) {}
    for (paramVarArgs = paramymw.a(); (paramymw == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      yny.d("GdtCarrierJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("carrier", ypb.a(paramVarArgs));
    }
    catch (JSONException localJSONException)
    {
      try
      {
        for (;;)
        {
          paramymw.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramymw != null) {
            paramString = paramymw.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getCarrier", paramString);
          return true;
          localJSONException = localJSONException;
          yny.d("GdtCarrierJsCallHandler", "handleJsCallRequest error", localJSONException);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          yny.d("GdtCarrierJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ynf
 * JD-Core Version:    0.7.0.1
 */