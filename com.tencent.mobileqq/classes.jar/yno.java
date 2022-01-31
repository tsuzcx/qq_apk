import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import org.json.JSONObject;

class yno
  implements ynl
{
  public boolean a(ymw paramymw, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramymw != null) {}
    for (;;)
    {
      try
      {
        paramVarArgs = paramymw.a();
        paramVarArgs = GdtLocationUtil.INSTANCE.getLocation(paramVarArgs);
        localJSONObject = new JSONObject();
        if (paramVarArgs == null) {
          continue;
        }
        localJSONObject.put("lat", paramVarArgs[0]);
        localJSONObject.put("lon", paramVarArgs[1]);
        paramymw.callJs(paramString, new String[] { localJSONObject.toString() });
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        continue;
        paramString = null;
        continue;
      }
      if (paramymw == null) {
        continue;
      }
      paramString = paramymw.a();
      paramVarArgs = localObject;
      if (paramymw != null) {
        paramVarArgs = paramymw.a();
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
 * Qualified Name:     yno
 * JD-Core Version:    0.7.0.1
 */