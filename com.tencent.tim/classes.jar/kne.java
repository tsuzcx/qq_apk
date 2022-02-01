import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class kne
{
  public static int a(@NonNull AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramAdData.type)
    {
    default: 
      return 0;
    }
    if (!TextUtils.isEmpty(paramAdData.imgUrl)) {
      paramAdvertisementInfo.mSinglePicture = obs.a(paramAdData.imgUrl, 4);
    }
    return 2;
  }
  
  public static AdvertisementInfo a(AdData paramAdData)
  {
    Object localObject;
    if (paramAdData == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
      localAdvertisementInfo.mAdAdvertiseId = paramAdData.aZS;
      localAdvertisementInfo.mAdVideoUrl = paramAdData.videoUrl;
      localAdvertisementInfo.mAdAid = paramAdData.aid;
      localAdvertisementInfo.mAdTraceId = paramAdData.alJ;
      localAdvertisementInfo.mAdViewId = paramAdData.alI;
      localAdvertisementInfo.mAdProductId = paramAdData.productId;
      localAdvertisementInfo.mAdVia = paramAdData.via;
      localAdvertisementInfo.mAdNocoId = paramAdData.xF;
      localAdvertisementInfo.mAdApurl = paramAdData.alF;
      localAdvertisementInfo.mAdRl = paramAdData.alE;
      localAdvertisementInfo.mAdEffectUrl = paramAdData.alL;
      localAdvertisementInfo.mAdLandingPageReportUrl = paramAdData.alM;
      localAdvertisementInfo.mAdLandingPage = paramAdData.alN;
      localAdvertisementInfo.mAdCanvasJson = paramAdData.alO;
      localAdvertisementInfo.mAdDestType = paramAdData.aZT;
      localAdvertisementInfo.mOrigin = jzk.aFv;
      try
      {
        String str = paramAdData.mAdExt;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        localObject = new JSONObject((String)localObject);
        ((JSONObject)localObject).put("pkgurl", paramAdData.alQ);
        ((JSONObject)localObject).put("appname", paramAdData.appName);
        ((JSONObject)localObject).put("pkg_name", paramAdData.alP);
        localAdvertisementInfo.mAdExt = ((JSONObject)localObject).toString();
        localAdvertisementInfo.mAdAppDownLoadSchema = paramAdData.alR;
        localAdvertisementInfo.mAdCustomizedInvokeUrl = paramAdData.alS;
        localAdvertisementInfo.mChannelID = 2L;
        localAdvertisementInfo.mAdProductType = paramAdData.productType;
        localAdvertisementInfo.mADVideoAutoPlay = paramAdData.aZU;
        localAdvertisementInfo.mAlgorithmID = paramAdData.xG;
        localAdvertisementInfo.mAlgorithmGroup = paramAdData.xH;
        localAdvertisementInfo.mC2SSwitch = paramAdData.aZV;
        localAdvertisementInfo.mC2SClickUrl = paramAdData.lI;
        localAdvertisementInfo.mC2SExposureUrl = paramAdData.lJ;
        localAdvertisementInfo.miniProgramType = paramAdData.miniProgramType;
        localAdvertisementInfo.mPhoneComponetId = paramAdData.aZX;
        if (!kmx.d(paramAdData)) {}
      }
      catch (Exception localException3)
      {
        try
        {
          localObject = new JSONObject();
          if (!TextUtils.isEmpty(paramAdData.mAdExtInfo)) {
            localObject = new JSONObject(paramAdData.mAdExtInfo);
          }
          ((JSONObject)localObject).put("game_pkg_name", paramAdData.a.packageName);
          paramAdData.mAdExtInfo = ((JSONObject)localObject).toString();
          if (!TextUtils.isEmpty(paramAdData.mAdExtInfo)) {
            localAdvertisementInfo.mAdExtInfo = paramAdData.mAdExtInfo;
          }
        }
        catch (Exception localException3)
        {
          try
          {
            localObject = new JSONObject(paramAdData.mAdExtInfo);
            ((JSONObject)localObject).put("AdSource", paramAdData.baa);
            localAdvertisementInfo.mAdExtInfo = ((JSONObject)localObject).toString();
            if (!TextUtils.isEmpty(paramAdData.title)) {
              localAdvertisementInfo.mTitle = paramAdData.title;
            }
            localAdvertisementInfo.mAdvertisementExtInfo = new kkw(localAdvertisementInfo.mAdExtInfo);
            localAdvertisementInfo.mAdLocalSource = a(paramAdData, localAdvertisementInfo);
            if (!TextUtils.isEmpty(paramAdData.alT))
            {
              localAdvertisementInfo.mAdCorporateImageName = paramAdData.alT;
              localAdvertisementInfo.mAdCorporateLogo = paramAdData.alU;
              localAdvertisementInfo.mSubordinateProductId = paramAdData.channelId;
              localAdvertisementInfo.mPopFormH5Url = paramAdData.mPopFormH5Url;
              localAdvertisementInfo.mShowAdButton = paramAdData.mShowAdButton;
              localAdvertisementInfo.mAdJumpMode = paramAdData.aZZ;
            }
          }
          catch (Exception localException3)
          {
            try
            {
              for (;;)
              {
                if (!TextUtils.isEmpty(paramAdData.alD)) {
                  localAdvertisementInfo.mAdPosID = Long.valueOf(paramAdData.alD).longValue();
                }
                label538:
                localObject = localAdvertisementInfo;
                if (paramAdData.aC == null) {
                  break;
                }
                localAdvertisementInfo.processSoftDataInfo(paramAdData.aC);
                return localAdvertisementInfo;
                localException1 = localException1;
                if (QLog.isColorLevel())
                {
                  QLog.e("ReadInJoyBottomAdVideoUtil", 2, "adVideData.mAdExt error:" + localException1.getMessage());
                  continue;
                  localException2 = localException2;
                  localException2.printStackTrace();
                  continue;
                  localException3 = localException3;
                  if (QLog.isColorLevel()) {
                    QLog.e("ReadInJoyBottomAdVideoUtil", 2, "adVideData.mAdExtInfo error:" + localException3.getMessage());
                  }
                }
              }
              localAdvertisementInfo.mAdCorporateImageName = paramAdData.appName;
            }
            catch (Exception localException4)
            {
              break label538;
            }
          }
        }
      }
    }
  }
  
  public static void a(AdData paramAdData, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    if (localQQAppInterface != null) {
      jzk.a(localQQAppInterface, paramAdData, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kne
 * JD-Core Version:    0.7.0.1
 */