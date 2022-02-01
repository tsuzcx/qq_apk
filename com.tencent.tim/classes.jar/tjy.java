import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class tjy
  implements tkm
{
  public boolean a(tjs paramtjs, String paramString, String... paramVarArgs)
  {
    try
    {
      paramtjs = new JSONObject(paramVarArgs[0]);
      tkw.d("GdtC2SJsCallHandler", paramtjs.toString());
      tlb.a(paramtjs.optInt("operationType"), paramtjs.optInt("businessType"), (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), paramtjs.getJSONObject("adInfo"))));
      return true;
    }
    catch (Exception paramtjs)
    {
      tkw.e("GdtC2SJsCallHandler", "handleJsCallRequest", paramtjs);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tjy
 * JD-Core Version:    0.7.0.1
 */