import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;

public class yni
  implements ynl
{
  public boolean a(ymw paramymw, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    wis localwis = wis.a();
    localwis.a();
    localwis.j(new ynj(this, paramymw, paramString, paramVarArgs, localwis));
    if (paramymw != null) {}
    for (paramString = paramymw.a();; paramString = null)
    {
      paramVarArgs = localObject;
      if (paramymw != null) {
        paramVarArgs = paramymw.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "getUserInfo", paramVarArgs);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yni
 * JD-Core Version:    0.7.0.1
 */