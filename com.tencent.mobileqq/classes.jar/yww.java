import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class yww
  implements yxh
{
  public boolean a(ywn paramywn, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramywn != null) {}
    for (paramVarArgs = paramywn.a(); (paramywn == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      yxs.d("GdtCarrierJsCallHandler", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("carrier", yyv.a(paramVarArgs));
    }
    catch (JSONException localJSONException)
    {
      try
      {
        for (;;)
        {
          paramywn.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramywn != null) {
            paramString = paramywn.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getCarrier", paramString);
          return true;
          localJSONException = localJSONException;
          yxs.d("GdtCarrierJsCallHandler", "handleJsCallRequest error", localJSONException);
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          yxs.d("GdtCarrierJsCallHandler", "handleJsCallRequest error", paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yww
 * JD-Core Version:    0.7.0.1
 */