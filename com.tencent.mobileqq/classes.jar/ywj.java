import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONObject;

class ywj
  implements yxe
{
  public boolean a(ywk paramywk, String paramString, String... paramVarArgs)
  {
    String str = null;
    if (paramywk != null) {}
    for (paramString = paramywk.a();; paramString = null)
    {
      if (paramywk != null) {
        str = paramywk.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "doAdReport", str);
      try
      {
        paramywk = new JSONObject(paramVarArgs[0]);
        if (paramywk.getInt("reportType") == 1) {
          yye.a(paramywk.getInt("convType"), paramywk.getString("traceId"), paramywk.getString("productId"));
        }
        return true;
      }
      catch (Exception paramywk)
      {
        paramywk.printStackTrace();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywj
 * JD-Core Version:    0.7.0.1
 */