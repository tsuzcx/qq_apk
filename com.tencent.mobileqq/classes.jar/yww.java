import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;

public class yww
  implements yxe
{
  public boolean a(ywk paramywk, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    wxr localwxr = wxr.a();
    localwxr.a();
    localwxr.j(new ywx(this, paramywk, paramString, paramVarArgs, localwxr));
    if (paramywk != null) {}
    for (paramString = paramywk.a();; paramString = null)
    {
      paramVarArgs = localObject;
      if (paramywk != null) {
        paramVarArgs = paramywk.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "getUserInfo", paramVarArgs);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yww
 * JD-Core Version:    0.7.0.1
 */