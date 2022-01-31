import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONObject;

class ymv
  implements ynl
{
  public boolean a(ymw paramymw, String paramString, String... paramVarArgs)
  {
    String str = null;
    if (paramymw != null) {}
    for (paramString = paramymw.a();; paramString = null)
    {
      if (paramymw != null) {
        str = paramymw.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "doAdReport", str);
      try
      {
        paramymw = new JSONObject(paramVarArgs[0]);
        if (paramymw.getInt("reportType") == 1) {
          yoo.a(paramymw.getInt("convType"), paramymw.getString("traceId"), paramymw.getString("productId"));
        }
        return true;
      }
      catch (Exception paramymw)
      {
        paramymw.printStackTrace();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ymv
 * JD-Core Version:    0.7.0.1
 */