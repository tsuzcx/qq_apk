import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class tkt
  implements tkm
{
  private WeakReference<tjs> dA;
  private Map<Long, String> map = new ConcurrentHashMap();
  
  public static GdtMotiveVideoPageData a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt)
  {
    Object localObject2 = null;
    GdtAd localGdtAd = new GdtAd(paramAdInfo);
    if ((localGdtAd != null) && (localGdtAd.info != null))
    {
      GdtMotiveVideoPageData localGdtMotiveVideoPageData = new GdtMotiveVideoPageData();
      localGdtMotiveVideoPageData.productType = localGdtAd.getProductType();
      localGdtMotiveVideoPageData.vSize = localGdtAd.getCreativeSize();
      localGdtMotiveVideoPageData.screenOrientation = paramInt;
      localGdtMotiveVideoPageData.adId = localGdtAd.getAdvertiserId();
      localGdtMotiveVideoPageData.vid = localGdtAd.getTencent_video_id();
      localGdtMotiveVideoPageData.url = localGdtAd.getVideoUrl();
      tkw.e("GdtOpenMvPageHandler", "VideoUrl " + localGdtMotiveVideoPageData.url);
      Object localObject1;
      if (localGdtAd.getImageData() == null)
      {
        localObject1 = "";
        localGdtMotiveVideoPageData.previewImgUrl = ((String)localObject1);
        localGdtMotiveVideoPageData.bannerImgName = localGdtAd.getAdvertiser_corporate_image_name();
        localGdtMotiveVideoPageData.bannerBaseInfoText = localGdtAd.getText();
        localGdtMotiveVideoPageData.bannerLogo = localGdtAd.getAdvertiser_corporate_logo();
        localGdtMotiveVideoPageData.exposureUrl = localGdtAd.getUrlForImpression();
        localGdtMotiveVideoPageData.appScore = Double.valueOf(localGdtAd.getAppScore()).doubleValue();
        localGdtMotiveVideoPageData.downloadNum = localGdtAd.getAppDownloadNum();
        localGdtMotiveVideoPageData.style = localGdtAd.getStyle();
        localObject1 = localObject2;
        if (paramAdInfo != null) {
          localObject1 = tkv.pbToJson(paramAdInfo);
        }
        if (localObject1 != null) {
          break label259;
        }
      }
      label259:
      for (paramAdInfo = "";; paramAdInfo = localObject1.toString())
      {
        localGdtMotiveVideoPageData.adsContent = paramAdInfo;
        localGdtMotiveVideoPageData.processId = BaseApplicationImpl.sProcessId;
        return localGdtMotiveVideoPageData;
        localObject1 = localGdtAd.getImageData().url;
        break;
      }
    }
    QLog.e("GdtOpenMvPageHandler", 1, "createMVPageData error " + paramAdInfo + " portrait " + paramInt);
    return null;
  }
  
  public static int ez(int paramInt)
  {
    int i = 1;
    if (1 == paramInt) {
      i = 0;
    }
    while (2 != paramInt) {
      return i;
    }
    return 8;
  }
  
  public long a(long paramLong, String paramString1, String paramString2)
  {
    return ((paramLong >>> 32 ^ paramLong) * 31L + paramString1.hashCode()) * 31L + paramString2.hashCode();
  }
  
  public boolean a(tjs paramtjs, String paramString, String... paramVarArgs)
  {
    k = 0;
    i = 0;
    if (paramtjs != null) {}
    for (Activity localActivity = paramtjs.getActivity(); (paramtjs == null) || (localActivity == null); localActivity = null)
    {
      tkw.e("GdtOpenMvPageHandler", "GdtOpenMvPageHandler error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        j = paramVarArgs.optInt("orientation");
        i = k;
      }
      catch (Throwable paramVarArgs)
      {
        try
        {
          Object localObject = paramVarArgs.optString("adInfo");
          i = k;
          k = paramVarArgs.optInt("rewardTime", 0);
          i = k;
          paramVarArgs = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject((String)localObject)));
          i = k;
          k = j;
          j = i;
          localObject = a(paramVarArgs, ez(k));
          if (localObject == null) {
            break;
          }
          this.map.put(Long.valueOf(a(((GdtMotiveVideoPageData)localObject).adId, ((GdtMotiveVideoPageData)localObject).url, ((GdtMotiveVideoPageData)localObject).adsContent)), paramString);
          this.dA = new WeakReference(paramtjs);
          paramVarArgs = localActivity.getIntent().getStringExtra("big_brother_ref_source_key");
          paramString = paramVarArgs;
          if (TextUtils.isEmpty(paramVarArgs)) {
            paramString = localActivity.getIntent().getStringExtra("big_brother_source_key");
          }
          ((GdtMotiveVideoPageData)localObject).refId = paramString;
          if (j > 0) {
            ((GdtMotiveVideoPageData)localObject).setVideoCountDown(j);
          }
          GdtMotiveVideoFragment.c(paramtjs.getActivity(), GdtMotiveVideoFragment.class, (GdtMotiveVideoPageData)localObject);
          return true;
        }
        catch (Throwable paramVarArgs)
        {
          for (;;)
          {
            k = j;
            int j = i;
            i = k;
          }
        }
        paramVarArgs = paramVarArgs;
        j = 0;
      }
      QLog.e("GdtOpenMvPageHandler", 1, "GdtOpenMvPageHandler e2", paramVarArgs);
      paramVarArgs = null;
      k = i;
    }
  }
  
  public void b(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString1, String paramString2, String paramString3)
  {
    String str;
    JSONObject localJSONObject;
    if (paramGdtMotiveVideoPageData != null)
    {
      str = (String)this.map.get(Long.valueOf(a(paramGdtMotiveVideoPageData.adId, paramGdtMotiveVideoPageData.url, paramGdtMotiveVideoPageData.adsContent)));
      if (str != null)
      {
        this.map.remove(paramGdtMotiveVideoPageData);
        if (this.dA != null)
        {
          paramGdtMotiveVideoPageData = (tjs)this.dA.get();
          if (paramGdtMotiveVideoPageData != null)
          {
            QLog.w("GdtOpenMvPageHandler", 1, "callResultFunc2Web elapsedtime " + paramString1 + " totaltime " + paramString2 + " isEnd " + paramString3);
            localJSONObject = new JSONObject();
          }
        }
      }
    }
    try
    {
      localJSONObject.put("elapsedTime", paramString1);
      localJSONObject.put("totalTime", paramString2);
      localJSONObject.put("isEnd", paramString3);
      paramGdtMotiveVideoPageData.callJs(str, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tkt
 * JD-Core Version:    0.7.0.1
 */