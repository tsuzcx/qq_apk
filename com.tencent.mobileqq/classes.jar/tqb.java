import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class tqb
{
  public static int a(@NonNull AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramAdData.jdField_r_of_type_Int)
    {
    default: 
      return 0;
    }
    if (!TextUtils.isEmpty(paramAdData.jdField_d_of_type_JavaLangString)) {
      paramAdvertisementInfo.mSinglePicture = tye.a(paramAdData.jdField_d_of_type_JavaLangString, 4);
    }
    return 2;
  }
  
  public static AdvertisementInfo a(AdData paramAdData)
  {
    tpx.a("ReadInJoyBottomAdVideoUtil", "start : " + System.currentTimeMillis());
    if (paramAdData == null) {
      return null;
    }
    if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      return paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    }
    AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
    localAdvertisementInfo.mAdAdvertiseId = paramAdData.jdField_c_of_type_Int;
    localAdvertisementInfo.mAdVideoUrl = paramAdData.o;
    localAdvertisementInfo.mAdAid = paramAdData.jdField_a_of_type_Long;
    localAdvertisementInfo.mAdTraceId = paramAdData.jdField_m_of_type_JavaLangString;
    localAdvertisementInfo.mAdViewId = paramAdData.l;
    localAdvertisementInfo.mAdProductId = paramAdData.jdField_r_of_type_JavaLangString;
    localAdvertisementInfo.mAdVia = paramAdData.s;
    localAdvertisementInfo.mAdNocoId = paramAdData.jdField_c_of_type_Long;
    localAdvertisementInfo.mAdApurl = paramAdData.g;
    localAdvertisementInfo.mAdRl = paramAdData.jdField_e_of_type_JavaLangString;
    localAdvertisementInfo.mAdEffectUrl = paramAdData.p;
    localAdvertisementInfo.mAdLandingPageReportUrl = paramAdData.q;
    localAdvertisementInfo.mAdLandingPage = paramAdData.t;
    localAdvertisementInfo.mAdCanvasJson = paramAdData.u;
    localAdvertisementInfo.mAdDestType = paramAdData.jdField_d_of_type_Int;
    localAdvertisementInfo.mOrigin = nzq.M;
    localAdvertisementInfo.mAdAppDownLoadSchema = paramAdData.x;
    localAdvertisementInfo.mAdCustomizedInvokeUrl = paramAdData.y;
    localAdvertisementInfo.mChannelID = 2L;
    localAdvertisementInfo.mAdProductType = paramAdData.jdField_b_of_type_Int;
    localAdvertisementInfo.mADVideoAutoPlay = paramAdData.jdField_e_of_type_Int;
    localAdvertisementInfo.mAlgorithmID = paramAdData.jdField_d_of_type_Long;
    localAdvertisementInfo.mAlgorithmGroup = paramAdData.jdField_e_of_type_Long;
    localAdvertisementInfo.mC2SSwitch = paramAdData.f;
    localAdvertisementInfo.mC2SClickUrl = paramAdData.jdField_c_of_type_JavaUtilArrayList;
    localAdvertisementInfo.mC2SExposureUrl = paramAdData.jdField_d_of_type_JavaUtilArrayList;
    localAdvertisementInfo.miniProgramType = paramAdData.j;
    localAdvertisementInfo.mPhoneComponetId = paramAdData.k;
    if (paramAdData.jdField_a_of_type_Tlq != null) {
      localAdvertisementInfo.mAdBtnTxt = paramAdData.jdField_a_of_type_Tlq.l;
    }
    try
    {
      localAdvertisementInfo.mArticleID = Long.parseLong(paramAdData.E);
      a(localAdvertisementInfo, paramAdData);
      b(localAdvertisementInfo, paramAdData);
      c(localAdvertisementInfo, paramAdData);
      d(localAdvertisementInfo, paramAdData);
      if (!TextUtils.isEmpty(paramAdData.jdField_b_of_type_JavaLangString)) {
        localAdvertisementInfo.mTitle = paramAdData.jdField_b_of_type_JavaLangString;
      }
      localAdvertisementInfo.mAdvertisementExtInfo = new tly(localAdvertisementInfo.mAdExtInfo);
      localAdvertisementInfo.mAdLocalSource = a(paramAdData, localAdvertisementInfo);
      if (!TextUtils.isEmpty(paramAdData.A))
      {
        localAdvertisementInfo.mAdCorporateImageName = paramAdData.A;
        localAdvertisementInfo.mAdCorporateLogo = paramAdData.B;
        localAdvertisementInfo.mSubordinateProductId = paramAdData.z;
        localAdvertisementInfo.mPopFormH5Url = paramAdData.C;
        localAdvertisementInfo.mShowAdButton = paramAdData.jdField_c_of_type_Boolean;
        localAdvertisementInfo.mAdJumpMode = paramAdData.jdField_m_of_type_Int;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          if (!TextUtils.isEmpty(paramAdData.jdField_a_of_type_JavaLangString)) {
            localAdvertisementInfo.mAdPosID = Long.valueOf(paramAdData.jdField_a_of_type_JavaLangString).longValue();
          }
          label449:
          if (paramAdData.jdField_b_of_type_OrgJsonJSONObject != null)
          {
            localAdvertisementInfo.processSoftDataInfo(paramAdData.jdField_b_of_type_OrgJsonJSONObject);
            if ((localAdvertisementInfo.mAdvertisementSoftInfo != null) && (!TextUtils.isEmpty(localAdvertisementInfo.mAdvertisementSoftInfo.jdField_a_of_type_JavaLangString)))
            {
              localAdvertisementInfo.mSoftAdType = 2;
              if (!TextUtils.isEmpty(localAdvertisementInfo.mAdvertisementSoftInfo.D)) {
                localAdvertisementInfo.mAdBtnTxt = localAdvertisementInfo.mAdvertisementSoftInfo.D;
              }
              if (localAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1) {
                localAdvertisementInfo.mAdProductType = 12;
              }
            }
          }
          tpx.a("ReadInJoyBottomAdVideoUtil", "end : " + System.currentTimeMillis());
          paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = localAdvertisementInfo;
          return localAdvertisementInfo;
          localException1 = localException1;
          tpx.a("ReadInJoyBottomAdVideoUtil", "parse article_id error :" + localException1.getMessage());
        }
        localAdvertisementInfo.mAdCorporateImageName = paramAdData.i;
      }
      catch (Exception localException2)
      {
        break label449;
      }
    }
  }
  
  private static void a(VideoInfo.GameAdComData paramGameAdComData, tlq paramtlq)
  {
    String str;
    Object localObject;
    if ((paramtlq != null) && (paramGameAdComData != null))
    {
      paramGameAdComData.jdField_b_of_type_JavaLangString = String.valueOf(paramtlq.jdField_a_of_type_Int);
      paramGameAdComData.s = paramtlq.x;
      paramGameAdComData.jdField_d_of_type_JavaLangString = paramtlq.jdField_b_of_type_JavaLangString;
      paramGameAdComData.c = paramtlq.jdField_a_of_type_JavaLangString;
      paramGameAdComData.jdField_e_of_type_JavaLangString = paramtlq.c;
      paramGameAdComData.f = paramtlq.jdField_d_of_type_JavaLangString;
      paramGameAdComData.g = paramtlq.jdField_e_of_type_JavaLangString;
      paramGameAdComData.j = paramtlq.k;
      paramGameAdComData.k = paramtlq.f;
      paramGameAdComData.l = paramtlq.jdField_r_of_type_JavaLangString;
      paramGameAdComData.jdField_m_of_type_JavaLangString = paramtlq.q;
      paramGameAdComData.n = paramtlq.h;
      paramGameAdComData.o = paramtlq.i;
      paramGameAdComData.p = paramtlq.jdField_m_of_type_JavaLangString;
      paramGameAdComData.q = paramtlq.n;
      paramGameAdComData.jdField_r_of_type_JavaLangString = paramtlq.g;
      paramGameAdComData.v = paramtlq.l;
      paramGameAdComData.y = paramtlq.s;
      paramGameAdComData.x = paramtlq.t;
      paramGameAdComData.z = paramtlq.u;
      paramGameAdComData.A = paramtlq.v;
      paramGameAdComData.w = paramtlq.w;
      if (paramtlq.jdField_a_of_type_Tls != null)
      {
        str = paramGameAdComData.u;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      ((JSONObject)localObject).put("sActivityId", paramtlq.jdField_a_of_type_Tls.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject).put("sGiftName", paramtlq.jdField_a_of_type_Tls.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("sNeedRole", paramtlq.jdField_a_of_type_Tls.h);
      ((JSONObject)localObject).put("iGiftId", paramtlq.jdField_a_of_type_Tls.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("gift_icon", paramtlq.jdField_a_of_type_Tls.c);
      ((JSONObject)localObject).put("gift_desc", paramtlq.jdField_a_of_type_Tls.g);
      ((JSONObject)localObject).put("bag_item_icon_1", paramtlq.jdField_a_of_type_Tls.jdField_d_of_type_JavaLangString);
      ((JSONObject)localObject).put("bag_item_icon_2", paramtlq.jdField_a_of_type_Tls.jdField_e_of_type_JavaLangString);
      ((JSONObject)localObject).put("bag_item_icon_3", paramtlq.jdField_a_of_type_Tls.f);
      paramGameAdComData.u = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          str = paramGameAdComData.t;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localObject = new JSONObject((String)localObject);
          ((JSONObject)localObject).put("sGameDownloadUrl", paramtlq.p);
          ((JSONObject)localObject).put("lGameSize", paramtlq.q);
          paramGameAdComData.t = ((JSONObject)localObject).toString();
          return;
        }
        catch (Exception paramGameAdComData)
        {
          tpx.a("parse download info", paramGameAdComData.getMessage());
        }
        localException = localException;
        tpx.a("parse gift info", localException.getMessage());
      }
    }
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    try
    {
      String str = paramAdData.L;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localObject = new JSONObject((String)localObject);
      ((JSONObject)localObject).put("pkgurl", paramAdData.w);
      ((JSONObject)localObject).put("appname", paramAdData.i);
      ((JSONObject)localObject).put("pkg_name", paramAdData.v);
      paramAdvertisementInfo.mAdExt = ((JSONObject)localObject).toString();
      return;
    }
    catch (Exception paramAdvertisementInfo)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReadInJoyBottomAdVideoUtil", 2, "adData.mAdExt error:" + paramAdvertisementInfo.getMessage());
    }
  }
  
  public static boolean a(View paramView)
  {
    if (paramView == null) {}
    double d;
    do
    {
      return false;
      int i = paramView.getHeight();
      Rect localRect = new Rect();
      paramView.getLocalVisibleRect(localRect);
      d = localRect.height() * 1.0F / i;
    } while ((d < 0.5D) || (d <= 0.800000011920929D));
    return true;
  }
  
  private static void b(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    if (!TextUtils.isEmpty(paramAdData.M))
    {
      paramAdvertisementInfo.mAdExtInfo = paramAdData.M;
      try
      {
        localJSONObject = new JSONObject(paramAdData.M);
        localJSONObject.put("AdSource", paramAdData.n);
        if (tpp.e(paramAdData)) {
          localJSONObject.put("game_button_type", 2);
        }
        for (;;)
        {
          if (paramAdData.jdField_a_of_type_Tlq != null)
          {
            localJSONObject.put("game_pkg_name", paramAdData.jdField_a_of_type_Tlq.jdField_b_of_type_JavaLangString);
            localJSONObject.put("game_adtag", paramAdData.jdField_a_of_type_Tlq.o);
            localJSONObject.put("game_app_id", paramAdData.jdField_a_of_type_Tlq.jdField_e_of_type_JavaLangString);
            localJSONObject.put("game_app_name", paramAdData.jdField_a_of_type_Tlq.jdField_a_of_type_JavaLangString);
            localJSONObject.put("game_apk_url", paramAdData.jdField_a_of_type_Tlq.p);
          }
          paramAdvertisementInfo.mAdExtInfo = localJSONObject.toString();
          return;
          if (!tpp.c(paramAdData)) {
            break;
          }
          localJSONObject.put("game_button_type", 3);
        }
      }
      catch (Exception paramAdvertisementInfo)
      {
        JSONObject localJSONObject;
        while (QLog.isColorLevel())
        {
          QLog.e("ReadInJoyBottomAdVideoUtil", 2, "adData.mAdExtInfo error:" + paramAdvertisementInfo.getMessage());
          return;
          if (tpp.d(paramAdData)) {
            localJSONObject.put("game_button_type", 1);
          } else if (tpp.f(paramAdData)) {
            localJSONObject.put("game_button_type", 4);
          }
        }
      }
    }
  }
  
  private static void c(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    Object localObject;
    if (tpp.a(paramAdData))
    {
      String str = paramAdvertisementInfo.mAdExt;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      localObject = new VideoInfo.GameAdComData(paramAdData.F, (JSONObject)localObject);
      a((VideoInfo.GameAdComData)localObject, paramAdData.jdField_a_of_type_Tlq);
      paramAdvertisementInfo.gameAdComData = ((VideoInfo.GameAdComData)localObject);
      paramAdvertisementInfo.mSoftAdType = 1;
      if (paramAdvertisementInfo.gameAdComData.s.equals("2")) {
        paramAdvertisementInfo.mAdProductType = 12;
      }
      return;
    }
    catch (Exception paramAdvertisementInfo) {}
  }
  
  private static void d(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    paramAdvertisementInfo.mBusiJson = new JSONObject();
    try
    {
      paramAdvertisementInfo.mBusiJson.put("article_id", paramAdData.E);
      paramAdvertisementInfo.mBusiJson.put("rowkey", paramAdData.F);
      if ((!TextUtils.isEmpty(paramAdData.G)) && (!paramAdData.G.contains("%"))) {
        paramAdvertisementInfo.mBusiJson.put("tags", paramAdData.G);
      }
      if (tpp.a(paramAdData))
      {
        paramAdvertisementInfo.mBusiJson.put("game_component_type", paramAdData.jdField_a_of_type_Tlq.x);
        paramAdvertisementInfo.mBusiJson.put("game_pkg", paramAdData.jdField_a_of_type_Tlq.jdField_b_of_type_JavaLangString);
      }
      if (paramAdData.jdField_a_of_type_OrgJsonJSONObject != null) {
        paramAdvertisementInfo.mBusiJson.put("article_ad_ext", paramAdData.jdField_a_of_type_OrgJsonJSONObject.toString());
      }
      return;
    }
    catch (Exception paramAdvertisementInfo)
    {
      tpx.a("fillBusiJson", paramAdvertisementInfo.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqb
 * JD-Core Version:    0.7.0.1
 */