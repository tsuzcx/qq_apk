import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdExperimentInitUtil;", "", "()V", "initExperiment", "", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "initVideoGuide", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tvw
{
  public static final tvw a = new tvw();
  
  private final void b(AdvertisementInfo paramAdvertisementInfo)
  {
    trw localtrw = paramAdvertisementInfo.adExperimentData;
    paramAdvertisementInfo = paramAdvertisementInfo.mAdExtInfo;
    if (!TextUtils.isEmpty((CharSequence)paramAdvertisementInfo))
    {
      Object localObject = new JSONObject(paramAdvertisementInfo).opt("video_guide");
      paramAdvertisementInfo = localObject;
      if (!(localObject instanceof JSONObject)) {
        paramAdvertisementInfo = null;
      }
      paramAdvertisementInfo = (JSONObject)paramAdvertisementInfo;
      if (paramAdvertisementInfo != null) {
        localtrw.a(new try(paramAdvertisementInfo.optInt("second_state_time", -1), paramAdvertisementInfo.optInt("third_state_time", -1)));
      }
    }
  }
  
  public final void a(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null) {
      a.b(paramAdvertisementInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvw
 * JD-Core Version:    0.7.0.1
 */