import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.jsbridge.GdtDeviceInfoJsCallHandler.1;
import java.lang.ref.WeakReference;

public class ywv
  implements yxe
{
  public boolean a(ywk paramywk, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    WeakReference localWeakReference = new WeakReference(paramywk);
    AdThreadManager.INSTANCE.post(new GdtDeviceInfoJsCallHandler.1(this, localWeakReference, paramVarArgs, paramString), 4);
    if (paramywk != null) {}
    for (paramString = paramywk.a();; paramString = null)
    {
      paramVarArgs = localObject;
      if (paramywk != null) {
        paramVarArgs = paramywk.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, true, "getDeviceInfo", paramVarArgs);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywv
 * JD-Core Version:    0.7.0.1
 */