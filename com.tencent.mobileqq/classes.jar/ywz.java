import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;

public class ywz
  implements yxh
{
  public boolean a(ywn paramywn, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    wxu localwxu = wxu.a();
    localwxu.a();
    localwxu.j(new yxa(this, paramywn, paramString, paramVarArgs, localwxu));
    if (paramywn != null) {}
    for (paramString = paramywn.a();; paramString = null)
    {
      paramVarArgs = localObject;
      if (paramywn != null) {
        paramVarArgs = paramywn.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "getUserInfo", paramVarArgs);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywz
 * JD-Core Version:    0.7.0.1
 */