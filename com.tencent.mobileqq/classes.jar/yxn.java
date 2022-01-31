import android.os.Build.VERSION;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONException;
import org.json.JSONObject;

class yxn
  implements yxh
{
  public boolean a(ywn paramywn, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramywn != null) {}
    for (paramVarArgs = paramywn.a(); (paramywn == null) || (paramVarArgs == null); paramVarArgs = null)
    {
      yxs.d("GdtOSVersionJsCall", "handleJsCallRequest error");
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
          paramywn.callJs(paramString, new String[] { localJSONObject.toString() });
          paramString = localObject;
          if (paramywn != null) {
            paramString = paramywn.a();
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
 * Qualified Name:     yxn
 * JD-Core Version:    0.7.0.1
 */