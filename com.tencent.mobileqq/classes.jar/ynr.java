import android.os.Build.VERSION;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class ynr
  implements ynl
{
  public boolean a(ymw paramymw, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramymw != null) {}
    for (paramVarArgs = paramymw.a(); (paramymw == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      yny.d("GdtOSVersionJsCall", "handleJsCallRequest error");
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
          paramymw.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramymw != null) {
            paramString = paramymw.a();
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
 * Qualified Name:     ynr
 * JD-Core Version:    0.7.0.1
 */