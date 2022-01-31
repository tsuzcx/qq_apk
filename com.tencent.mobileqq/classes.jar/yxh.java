import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import org.json.JSONObject;

class yxh
  implements yxe
{
  public boolean a(ywk paramywk, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramywk != null) {}
    for (;;)
    {
      try
      {
        paramVarArgs = paramywk.a();
        paramVarArgs = GdtLocationUtil.INSTANCE.getLocation(paramVarArgs);
        localJSONObject = new JSONObject();
        if (paramVarArgs == null) {
          continue;
        }
        localJSONObject.put("lat", paramVarArgs[0]);
        localJSONObject.put("lon", paramVarArgs[1]);
        paramywk.callJs(paramString, new String[] { localJSONObject.toString() });
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        continue;
        paramString = null;
        continue;
      }
      if (paramywk == null) {
        continue;
      }
      paramString = paramywk.a();
      paramVarArgs = localObject;
      if (paramywk != null) {
        paramVarArgs = paramywk.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "getLocation", paramVarArgs);
      return true;
      paramVarArgs = null;
      continue;
      localJSONObject.put("lat", JSONObject.NULL);
      localJSONObject.put("lon", JSONObject.NULL);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yxh
 * JD-Core Version:    0.7.0.1
 */