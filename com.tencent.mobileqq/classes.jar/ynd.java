import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class ynd
  implements ynl
{
  public boolean a(ymw paramymw, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    try
    {
      paramString = new JSONObject(paramVarArgs[0]);
      yny.a("GdtC2SJsCallHandler", paramString.toString());
      int i = paramString.optInt("operationType");
      int j = paramString.optInt("businessType");
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(ynv.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramString.getJSONObject("adInfo")));
      yof.a(i, j, localAdInfo);
      if (paramymw != null) {}
      for (paramString = paramymw.a();; paramString = null)
      {
        paramVarArgs = localObject;
        if (paramymw != null) {
          paramVarArgs = paramymw.a();
        }
        AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "c2sReport", paramVarArgs, new GdtAd(localAdInfo));
        return true;
      }
      return true;
    }
    catch (Exception paramymw)
    {
      yny.d("GdtC2SJsCallHandler", "handleJsCallRequest", paramymw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ynd
 * JD-Core Version:    0.7.0.1
 */