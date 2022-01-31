import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
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

public class yns
  implements ynl
{
  private WeakReference<ymw> jdField_a_of_type_JavaLangRefWeakReference;
  private Map<Long, String> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private static int a(int paramInt)
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
  
  private GdtMotiveVideoPageData a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, int paramInt)
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
      yny.d("GdtOpenMvPageHandler", "VideoUrl " + localGdtMotiveVideoPageData.url);
      if ((!TextUtils.isEmpty(localGdtMotiveVideoPageData.url)) && (localGdtMotiveVideoPageData.url.startsWith("https://"))) {
        localGdtMotiveVideoPageData.url = localGdtMotiveVideoPageData.url.replaceFirst("https://", "http://");
      }
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
          localObject1 = ynv.a(paramAdInfo);
        }
        if (localObject1 != null) {
          break label302;
        }
      }
      label302:
      for (paramAdInfo = "";; paramAdInfo = localObject1.toString())
      {
        localGdtMotiveVideoPageData.adsContent = paramAdInfo;
        localGdtMotiveVideoPageData.processId = BaseApplicationImpl.sProcessId;
        return localGdtMotiveVideoPageData;
        localObject1 = localGdtAd.getImageData().a;
        break;
      }
    }
    QLog.e("GdtOpenMvPageHandler", 1, "createMVPageData error " + paramAdInfo + " portrait " + paramInt);
    return null;
  }
  
  public long a(long paramLong, String paramString1, String paramString2)
  {
    return ((paramLong >>> 32 ^ paramLong) * 31L + paramString1.hashCode()) * 31L + paramString2.hashCode();
  }
  
  public void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString1, String paramString2, String paramString3)
  {
    String str;
    JSONObject localJSONObject;
    if (paramGdtMotiveVideoPageData != null)
    {
      str = (String)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(a(paramGdtMotiveVideoPageData.adId, paramGdtMotiveVideoPageData.url, paramGdtMotiveVideoPageData.adsContent)));
      if (str != null)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramGdtMotiveVideoPageData);
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          paramGdtMotiveVideoPageData = (ymw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
  
  public boolean a(ymw paramymw, String paramString, String... paramVarArgs)
  {
    Object localObject2 = null;
    k = 0;
    j = 0;
    if (paramymw != null) {}
    for (Object localObject1 = paramymw.a(); (paramymw == null) || (localObject1 == null); localObject1 = null)
    {
      yny.d("GdtOpenMvPageHandler", "GdtOpenMvPageHandler error");
      return true;
    }
    for (;;)
    {
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        i = paramVarArgs.optInt("orientation");
        j = k;
        String str;
        GdtMotiveVideoPageData localGdtMotiveVideoPageData;
        QLog.e("GdtOpenMvPageHandler", 1, "GdtOpenMvPageHandler e2", paramVarArgs);
      }
      catch (Throwable paramVarArgs)
      {
        try
        {
          str = paramVarArgs.optString("adInfo");
          j = k;
          k = paramVarArgs.optInt("rewardTime", 0);
          j = k;
          paramVarArgs = (qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(ynv.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(str)));
          localGdtMotiveVideoPageData = a(paramVarArgs, a(i));
          if (localGdtMotiveVideoPageData != null)
          {
            this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(a(localGdtMotiveVideoPageData.adId, localGdtMotiveVideoPageData.url, localGdtMotiveVideoPageData.adsContent)), paramString);
            this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramymw);
            str = ((Activity)localObject1).getIntent().getStringExtra("big_brother_ref_source_key");
            paramString = str;
            if (TextUtils.isEmpty(str)) {
              paramString = ((Activity)localObject1).getIntent().getStringExtra("big_brother_source_key");
            }
            localGdtMotiveVideoPageData.refId = paramString;
            if (k > 0) {
              localGdtMotiveVideoPageData.setVideoCountDown(k);
            }
            GdtMotiveVideoFragment.b(paramymw.a(), GdtMotiveVideoFragment.class, localGdtMotiveVideoPageData);
          }
          if (paramymw == null) {
            break label322;
          }
          paramString = paramymw.a();
          localObject1 = localObject2;
          if (paramymw != null) {
            localObject1 = paramymw.a();
          }
          AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, true, "openMotiveVideoAd", (String)localObject1, new GdtAd(paramVarArgs));
          return true;
        }
        catch (Throwable paramVarArgs)
        {
          for (;;)
          {
            k = i;
            int i = j;
            j = k;
          }
        }
        paramVarArgs = paramVarArgs;
        i = 0;
      }
      paramVarArgs = null;
      k = i;
      i = j;
      continue;
      label322:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yns
 * JD-Core Version:    0.7.0.1
 */