import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class twq
{
  private static int a(VideoAdInfo paramVideoAdInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "getExtValue pos->" + paramInt + " , VideoAdInfo:" + paramVideoAdInfo);
    }
    int i;
    if (paramVideoAdInfo == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = b(paramVideoAdInfo.v, paramInt);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdSwitchUtil", 2, "getExtValue pos->" + paramInt + " , value:" + j);
    return j;
  }
  
  public static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isFeedsAutoPlay->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    int i;
    if (paramAdvertisementInfo == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = b(paramAdvertisementInfo.mAdExtInfo, 2);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdSwitchUtil", 2, "isFeedsAutoPlay->value:" + j);
    return j;
  }
  
  public static int a(ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isWebBottomAutoPlay->BannerVideoAdData:" + paramProteusBannerVideoItemData);
    }
    int i;
    if (paramProteusBannerVideoItemData == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = a(paramProteusBannerVideoItemData.n, 3);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyAdSwitchUtil", 2, "isWebBottomAutoPlay->value:" + j);
    return j;
  }
  
  public static int a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "getSwitchInt(" + paramInt + ")->switchStr:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt <= 0)) {}
    do
    {
      return -1;
      try
      {
        paramInt = Integer.parseInt(paramString.substring(paramInt - 1, paramInt));
        return paramInt;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    paramString.printStackTrace();
    return -1;
  }
  
  private static int a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "getSwitchFromExtra(" + paramInt + ")->extraData:" + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      for (;;)
      {
        return -1;
        try
        {
          paramString2 = new JSONObject(paramString2);
          if (paramString2.has(paramString1))
          {
            paramString1 = paramString2.optString(paramString1);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyAdSwitchUtil", 2, "getSwitchFromExtra(" + paramInt + ")->switchs:" + paramString1);
            }
            paramInt = a(paramString1, paramInt);
            return paramInt;
          }
        }
        catch (Exception paramString1) {}
      }
    } while (!QLog.isColorLevel());
    paramString1.printStackTrace();
    return -1;
  }
  
  public static <T> T a(String paramString1, String paramString2, T paramT)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramT != null)) {
      try
      {
        paramString1 = new JSONObject(paramString1);
        if (paramString1.has(paramString2))
        {
          if ((paramT instanceof String)) {
            return paramString1.optString(paramString2, (String)paramT);
          }
          if ((paramT instanceof Integer)) {
            return Integer.valueOf(paramString1.optInt(paramString2, ((Integer)paramT).intValue()));
          }
          if ((paramT instanceof Double))
          {
            double d = paramString1.optDouble(paramString2, ((Double)paramT).doubleValue());
            return Double.valueOf(d);
          }
        }
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          paramString1.printStackTrace();
        }
      }
    }
    return paramT;
  }
  
  public static boolean a()
  {
    return bkwm.d();
  }
  
  public static boolean a(Context paramContext)
  {
    int i;
    if (bgoa.a() == 1)
    {
      i = 1;
      if (rwv.e() != 1) {
        break label40;
      }
    }
    label40:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0) || (!NetworkUtil.isNetworkAvailable(paramContext))) {
        break label45;
      }
      return true;
      i = 0;
      break;
    }
    label45:
    return false;
  }
  
  public static boolean a(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, 1) == 1;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isADVideoDownloadProgress->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 8);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isVideoFeedsAdButtonNewStyle->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isServerRspReport->AdvertisementInfo:" + paramAdvertisementInfo + " adInfo = " + paramVideoAdInfo);
    }
    if ((paramAdvertisementInfo == null) && (paramVideoAdInfo == null)) {
      return false;
    }
    int i = -1;
    if (paramAdvertisementInfo != null) {
      i = b(paramAdvertisementInfo.mAdExtInfo, 6);
    }
    if (paramVideoAdInfo != null) {
      i = b(paramVideoAdInfo.v, 6);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isServerRspReport->value:" + i);
    }
    if (i == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, ProteusBannerVideoItemData paramProteusBannerVideoItemData, Context paramContext, int paramInt)
  {
    if (((paramInt == 1) && (paramAdvertisementInfo == null)) || ((paramInt == 2) && (paramProteusBannerVideoItemData == null)) || ((paramInt == 3) && (paramAdvertisementInfo == null)) || ((paramAdvertisementInfo == null) && (paramProteusBannerVideoItemData == null))) {}
    label166:
    label184:
    do
    {
      return false;
      if (paramInt == 1) {
        paramInt = a(paramAdvertisementInfo);
      }
      for (;;)
      {
        paramAdvertisementInfo = pay.e();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyAdSwitchUtil", 2, " isADVideoAutoPlayFlag adFlag = " + paramInt + " kandianVideoAutoPlaySetting = " + paramAdvertisementInfo);
        }
        if (pay.e.equals(paramAdvertisementInfo)) {
          break;
        }
        if (!pay.c.equals(paramAdvertisementInfo)) {
          break label184;
        }
        if (paramInt == 0) {
          break;
        }
        if ((paramInt != 1) || (paramContext == null) || ((!rtp.a(paramContext)) && (!a(paramContext)))) {
          break label166;
        }
        return true;
        if (paramInt == 2)
        {
          paramInt = a(paramProteusBannerVideoItemData);
        }
        else
        {
          if (paramInt != 3) {
            break;
          }
          paramInt = b(paramAdvertisementInfo);
        }
      }
      if ((paramInt == 2) && (paramContext != null) && (NetworkUtil.isNetworkAvailable(paramContext))) {
        return true;
      }
    } while ((!pay.d.equals(paramAdvertisementInfo)) || (paramInt == 0));
    if ((paramInt == 1) && (paramContext != null) && ((rtp.a(paramContext)) || (a(paramContext)))) {
      return true;
    }
    if ((paramInt == 2) && (paramContext != null) && (rtp.a(paramContext))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(AdData paramAdData)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isNewExposureProtocol->adData:" + paramAdData);
    }
    if (paramAdData == null) {
      return false;
    }
    int i = -1;
    if (paramAdData != null) {
      i = a(paramAdData.n, 7);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(AdData paramAdData, boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isNewClickOrNegativeProtocol->adData:" + paramAdData);
    }
    if (paramAdData == null) {
      return false;
    }
    int i = -1;
    if (paramAdData != null)
    {
      if (!paramBoolean) {
        i = a(paramAdData.n, 13);
      }
    }
    else {
      if (i != 1) {
        break label81;
      }
    }
    label81:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      i = a(paramAdData.n, 14);
      break;
    }
  }
  
  public static boolean a(String paramString)
  {
    int i = b(paramString, 21);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isMobileAutoDownloadForBtn->value:" + i);
    }
    return i == 1;
  }
  
  public static int b(AdvertisementInfo paramAdvertisementInfo)
  {
    return a(paramAdvertisementInfo);
  }
  
  private static int b(String paramString, int paramInt)
  {
    return a("ad_switchs", paramString, paramInt);
  }
  
  public static boolean b(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, 1) == 2;
  }
  
  public static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isDirectPlay->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 10);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isDirectPlay->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean b(AdData paramAdData)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isDirectPlay->AdData:" + paramAdData);
    }
    if (paramAdData == null) {
      return false;
    }
    int i = a(paramAdData.n, 10);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isDirectPlay->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static int c(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "getFeedsAdStyle->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {}
    int i;
    do
    {
      return 0;
      i = b(paramAdvertisementInfo.mAdExtInfo, 4);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdSwitchUtil", 2, "getFeedsAdStyle->value:" + i);
      }
    } while (i == -1);
    return i;
  }
  
  public static boolean c(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, 5) == 1;
  }
  
  public static boolean c(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isAdjustAdExposure->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 17);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "SWITCH_POS_VIDEO_SWITCH->extValue:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean c(AdData paramAdData)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "enableCheckWebProcess->AdData:" + paramAdData);
    }
    if (paramAdData == null) {
      return false;
    }
    int i = a(paramAdData.n, 16);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "enableCheckWebProcess->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static int d(AdvertisementInfo paramAdvertisementInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "getVideoClickZoneSwitch->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {}
    int i;
    do
    {
      return 0;
      i = b(paramAdvertisementInfo.mAdExtInfo, 19);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdSwitchUtil", 2, "getVideoClickZoneSwitch->value:" + i);
      }
    } while (i == -1);
    return i;
  }
  
  public static boolean d(VideoAdInfo paramVideoAdInfo)
  {
    int i = a(paramVideoAdInfo, 8);
    if (paramVideoAdInfo != null)
    {
      paramVideoAdInfo = new StringBuilder().append("adInfo.name = ").append(paramVideoAdInfo.p).append(" showProgress = ");
      if (i != 1) {
        break label66;
      }
    }
    label66:
    for (boolean bool = true;; bool = false)
    {
      twp.a("isADVideoDownloadProgress", bool);
      if (i != 1) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static boolean d(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isAmsSubcribeEnable->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 15);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isAmsSubcribeEnable->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean d(AdData paramAdData)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isAmsSubcribeEnable->adData:" + paramAdData);
    }
    if (paramAdData == null) {
      return false;
    }
    int i = a(paramAdData.n, 15);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isAmsSubcribeEnable->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean e(VideoAdInfo paramVideoAdInfo)
  {
    int i = a(paramVideoAdInfo, 11);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "SWITCH_POS_VIDEO_CIRCLE->extValue:" + i);
    }
    return i == 1;
  }
  
  public static boolean e(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isTelephoneComponent->AdData:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 18);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "isTelephoneComponent->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean f(VideoAdInfo paramVideoAdInfo)
  {
    int i = a(paramVideoAdInfo, 12);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "SWITCH_POS_VIDEO_SWITCH->extValue:" + i);
    }
    return i == 1;
  }
  
  public static boolean f(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "enableCheckWebProcess->AdvertisementInfo:" + paramAdvertisementInfo);
    }
    if (paramAdvertisementInfo == null) {
      return false;
    }
    int i = b(paramAdvertisementInfo.mAdExtInfo, 16);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdSwitchUtil", 2, "enableCheckWebProcess->value:" + i);
    }
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean g(VideoAdInfo paramVideoAdInfo)
  {
    return a(paramVideoAdInfo, 20) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twq
 * JD-Core Version:    0.7.0.1
 */