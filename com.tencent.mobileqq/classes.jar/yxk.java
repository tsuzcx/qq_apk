import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.qqproxy.GdtLocationUtil;
import org.json.JSONObject;

class yxk
  implements yxh
{
  public boolean a(ywn paramywn, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    if (paramywn != null) {}
    for (;;)
    {
      try
      {
        paramVarArgs = paramywn.a();
        paramVarArgs = GdtLocationUtil.INSTANCE.getLocation(paramVarArgs);
        localJSONObject = new JSONObject();
        if (paramVarArgs == null) {
          continue;
        }
        localJSONObject.put("lat", paramVarArgs[0]);
        localJSONObject.put("lon", paramVarArgs[1]);
        paramywn.callJs(paramString, new String[] { localJSONObject.toString() });
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        paramString.printStackTrace();
        continue;
        paramString = null;
        continue;
      }
      if (paramywn == null) {
        continue;
      }
      paramString = paramywn.a();
      paramVarArgs = localObject;
      if (paramywn != null) {
        paramVarArgs = paramywn.a();
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
 * Qualified Name:     yxk
 * JD-Core Version:    0.7.0.1
 */