import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import org.json.JSONObject;

public class txa
{
  public static AdvertisementInfo a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {
      return null;
    }
    AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
    localAdvertisementInfo.mAdAdvertiseId = paramVideoAdInfo.jdField_g_of_type_Long;
    localAdvertisementInfo.mAdVideoUrl = paramVideoAdInfo.s;
    localAdvertisementInfo.mAdAid = paramVideoAdInfo.e;
    localAdvertisementInfo.mAdTraceId = paramVideoAdInfo.jdField_h_of_type_JavaLangString;
    localAdvertisementInfo.mAdViewId = paramVideoAdInfo.m;
    localAdvertisementInfo.mAdProductId = paramVideoAdInfo.i;
    localAdvertisementInfo.mAdVia = paramVideoAdInfo.t;
    localAdvertisementInfo.mAdNocoId = paramVideoAdInfo.jdField_h_of_type_Long;
    localAdvertisementInfo.mAdApurl = paramVideoAdInfo.jdField_g_of_type_JavaLangString;
    localAdvertisementInfo.mAdRl = paramVideoAdInfo.f;
    localAdvertisementInfo.mAdEffectUrl = paramVideoAdInfo.A;
    localAdvertisementInfo.mAdLandingPageReportUrl = paramVideoAdInfo.z;
    localAdvertisementInfo.mAdLandingPage = paramVideoAdInfo.j;
    localAdvertisementInfo.mAdCanvasJson = paramVideoAdInfo.y;
    localAdvertisementInfo.mAdDestType = paramVideoAdInfo.jdField_n_of_type_Int;
    localAdvertisementInfo.mAdExt = paramVideoAdInfo.r;
    localAdvertisementInfo.mOrigin = obb.P;
    localAdvertisementInfo.mAdAppDownLoadSchema = paramVideoAdInfo.x;
    localAdvertisementInfo.mAdCustomizedInvokeUrl = paramVideoAdInfo.jdField_n_of_type_JavaLangString;
    localAdvertisementInfo.mChannelID = 3L;
    localAdvertisementInfo.mAdProductType = paramVideoAdInfo.c;
    localAdvertisementInfo.mAdJumpMode = paramVideoAdInfo.l;
    localAdvertisementInfo.mAdPosID = paramVideoAdInfo.jdField_b_of_type_Long;
    if (paramVideoAdInfo.v != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramVideoAdInfo.v);
      if (localJSONObject.has("mini_program_type")) {
        localAdvertisementInfo.miniProgramType = localJSONObject.optInt("mini_program_type");
      }
      localAdvertisementInfo.mAdExtInfo = paramVideoAdInfo.v;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    localAdvertisementInfo.mPopFormH5Url = paramVideoAdInfo.C;
    localAdvertisementInfo.mShowAdButton = paramVideoAdInfo.jdField_b_of_type_Boolean;
    localAdvertisementInfo.processAdExt(paramVideoAdInfo.r);
    return localAdvertisementInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     txa
 * JD-Core Version:    0.7.0.1
 */