import android.os.Build.VERSION;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class yxk
  implements yxe
{
  public boolean a(ywk paramywk, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramywk != null) {}
    for (paramVarArgs = paramywk.a(); (paramywk == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      yxp.d("GdtOSVersionJsCall", "handleJsCallRequest error");
      return true;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("osVersion", Build.VERSION.RELEASE);
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
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramVarArgs, false, "getOSVersion", paramString);
          return true;
          localJSONException = localJSONException;
          localJSONException.printStackTrace();
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yxk
 * JD-Core Version:    0.7.0.1
 */