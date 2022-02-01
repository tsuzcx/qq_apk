import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import org.json.JSONObject;

public class knl
{
  public static AdvertisementInfo b(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {
      return null;
    }
    AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
    localAdvertisementInfo.mAdAdvertiseId = paramVideoAdInfo.mAdAdvertiseId;
    localAdvertisementInfo.mAdVideoUrl = paramVideoAdInfo.mVideoUrl;
    localAdvertisementInfo.mAdAid = paramVideoAdInfo.ru;
    localAdvertisementInfo.mAdTraceId = paramVideoAdInfo.We;
    localAdvertisementInfo.mAdViewId = paramVideoAdInfo.Wj;
    localAdvertisementInfo.mAdProductId = paramVideoAdInfo.Wf;
    localAdvertisementInfo.mAdVia = paramVideoAdInfo.mVia;
    localAdvertisementInfo.mAdNocoId = paramVideoAdInfo.mAdNocoId;
    localAdvertisementInfo.mAdApurl = paramVideoAdInfo.Wd;
    localAdvertisementInfo.mAdRl = paramVideoAdInfo.Wc;
    localAdvertisementInfo.mAdEffectUrl = paramVideoAdInfo.mAdEffectUrl;
    localAdvertisementInfo.mAdLandingPageReportUrl = paramVideoAdInfo.mAdLandingPageReportUrl;
    localAdvertisementInfo.mAdLandingPage = paramVideoAdInfo.Wg;
    localAdvertisementInfo.mAdCanvasJson = paramVideoAdInfo.mAdCanvasJson;
    localAdvertisementInfo.mAdDestType = paramVideoAdInfo.mAdDestType;
    localAdvertisementInfo.mAdExt = paramVideoAdInfo.Wo;
    localAdvertisementInfo.mOrigin = jzk.aFy;
    localAdvertisementInfo.mAdAppDownLoadSchema = paramVideoAdInfo.mAdAppDownLoadSchema;
    localAdvertisementInfo.mAdCustomizedInvokeUrl = paramVideoAdInfo.Wk;
    localAdvertisementInfo.mChannelID = 409409L;
    localAdvertisementInfo.mAdProductType = paramVideoAdInfo.aGV;
    localAdvertisementInfo.mAdJumpMode = paramVideoAdInfo.mAdJumpMode;
    localAdvertisementInfo.mAdPosID = paramVideoAdInfo.rt;
    if (paramVideoAdInfo.mAdExtInfo != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramVideoAdInfo.mAdExtInfo);
      if (localJSONObject.has("mini_program_type")) {
        localAdvertisementInfo.miniProgramType = localJSONObject.optInt("mini_program_type");
      }
      localAdvertisementInfo.mAdExtInfo = paramVideoAdInfo.mAdExtInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    localAdvertisementInfo.mPopFormH5Url = paramVideoAdInfo.mPopFormH5Url;
    localAdvertisementInfo.mShowAdButton = paramVideoAdInfo.mShowAdButton;
    localAdvertisementInfo.processAdExt(paramVideoAdInfo.Wo);
    return localAdvertisementInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knl
 * JD-Core Version:    0.7.0.1
 */