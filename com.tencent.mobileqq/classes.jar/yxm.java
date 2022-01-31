import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class yxm
  implements yxe
{
  public boolean a(ywk paramywk, String paramString, String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      yxp.b("GdtPreLoaderJsCallHandler", paramVarArgs.toString());
      paramVarArgs = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(yxo.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramVarArgs.getJSONObject("adInfo"))));
      ysu.a().a(paramVarArgs);
      paramywk.callJs(paramString, null);
      if (paramywk != null)
      {
        paramString = paramywk.a();
        if (paramywk == null) {
          break label99;
        }
      }
      label99:
      for (paramywk = paramywk.a();; paramywk = null)
      {
        AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, true, "preLoadAfterAdLoaded", paramywk, paramVarArgs);
        return true;
        paramString = null;
        break;
      }
      return true;
    }
    catch (Throwable paramywk)
    {
      paramywk.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yxm
 * JD-Core Version:    0.7.0.1
 */