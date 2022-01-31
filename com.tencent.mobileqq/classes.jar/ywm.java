import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import org.json.JSONObject;

class ywm
  implements yxh
{
  public boolean a(ywn paramywn, String paramString, String... paramVarArgs)
  {
    String str = null;
    if (paramywn != null) {}
    for (paramString = paramywn.a();; paramString = null)
    {
      if (paramywn != null) {
        str = paramywn.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "doAdReport", str);
      try
      {
        paramywn = new JSONObject(paramVarArgs[0]);
        if (paramywn.getInt("reportType") == 1) {
          yyh.a(paramywn.getInt("convType"), paramywn.getString("traceId"), paramywn.getString("productId"));
        }
        return true;
      }
      catch (Exception paramywn)
      {
        paramywn.printStackTrace();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywm
 * JD-Core Version:    0.7.0.1
 */