import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class ywr
  implements yxe
{
  public boolean a(ywk paramywk, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    try
    {
      paramString = new JSONObject(paramVarArgs[0]);
      yxp.a("GdtC2SJsCallHandler", paramString.toString());
      int i = paramString.optInt("operationType");
      int j = paramString.optInt("businessType");
      qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(yxo.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramString.getJSONObject("adInfo")));
      yxv.a(i, j, localAdInfo);
      if (paramywk != null) {}
      for (paramString = paramywk.a();; paramString = null)
      {
        paramVarArgs = localObject;
        if (paramywk != null) {
          paramVarArgs = paramywk.a();
        }
        AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, false, "c2sReport", paramVarArgs, new GdtAd(localAdInfo));
        return true;
      }
      return true;
    }
    catch (Exception paramywk)
    {
      yxp.d("GdtC2SJsCallHandler", "handleJsCallRequest", paramywk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywr
 * JD-Core Version:    0.7.0.1
 */