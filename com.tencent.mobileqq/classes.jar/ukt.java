import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ukt
{
  public static int a(@NonNull AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramAdData.jdField_r_of_type_Int)
    {
    default: 
      return 0;
    }
    if (!TextUtils.isEmpty(paramAdData.jdField_d_of_type_JavaLangString)) {
      paramAdvertisementInfo.mSinglePicture = usq.a(paramAdData.jdField_d_of_type_JavaLangString, 4);
    }
    return 2;
  }
  
  public static AdvertisementInfo a(AdData paramAdData)
  {
    ukq.a("ReadInJoyBottomAdVideoUtil", "start : " + System.currentTimeMillis());
    if (paramAdData == null) {
      return null;
    }
    if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      return paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    }
    AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
    b(paramAdData, localAdvertisementInfo);
    a(localAdvertisementInfo, paramAdData);
    b(localAdvertisementInfo, paramAdData);
    c(localAdvertisementInfo, paramAdData);
    d(localAdvertisementInfo, paramAdData);
    localAdvertisementInfo.mAdvertisementExtInfo = new ufz(localAdvertisementInfo.mAdExtInfo);
    if (paramAdData.jdField_b_of_type_OrgJsonJSONObject != null) {
      a(paramAdData, localAdvertisementInfo);
    }
    localAdvertisementInfo.liujinReportUrl = paramAdData.O;
    localAdvertisementInfo.ticket = paramAdData.P;
    localAdvertisementInfo.amsNfbUrl = paramAdData.Q;
    localAdvertisementInfo.packageName = paramAdData.a();
    ukq.a("ReadInJoyBottomAdVideoUtil", "end : " + System.currentTimeMillis());
    if (ufc.a(paramAdData)) {
      localAdvertisementInfo.isBottomAd = true;
    }
    paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = localAdvertisementInfo;
    return localAdvertisementInfo;
  }
  
  private static void a(VideoInfo.GameAdComData paramGameAdComData, ufr paramufr)
  {
    String str;
    Object localObject;
    if ((paramufr != null) && (paramGameAdComData != null))
    {
      paramGameAdComData.jdField_b_of_type_JavaLangString = String.valueOf(paramufr.jdField_a_of_type_Int);
      paramGameAdComData.s = paramufr.x;
      paramGameAdComData.jdField_d_of_type_JavaLangString = paramufr.jdField_b_of_type_JavaLangString;
      paramGameAdComData.c = paramufr.jdField_a_of_type_JavaLangString;
      paramGameAdComData.jdField_e_of_type_JavaLangString = paramufr.c;
      paramGameAdComData.f = paramufr.jdField_d_of_type_JavaLangString;
      paramGameAdComData.g = paramufr.jdField_e_of_type_JavaLangString;
      paramGameAdComData.j = paramufr.k;
      paramGameAdComData.k = paramufr.f;
      paramGameAdComData.l = paramufr.jdField_r_of_type_JavaLangString;
      paramGameAdComData.jdField_m_of_type_JavaLangString = paramufr.q;
      paramGameAdComData.jdField_n_of_type_JavaLangString = paramufr.h;
      paramGameAdComData.o = paramufr.i;
      paramGameAdComData.p = paramufr.jdField_m_of_type_JavaLangString;
      paramGameAdComData.q = paramufr.jdField_n_of_type_JavaLangString;
      paramGameAdComData.jdField_r_of_type_JavaLangString = paramufr.g;
      paramGameAdComData.v = paramufr.l;
      paramGameAdComData.y = paramufr.s;
      paramGameAdComData.x = paramufr.t;
      paramGameAdComData.z = paramufr.u;
      paramGameAdComData.A = paramufr.v;
      paramGameAdComData.w = paramufr.w;
      if (paramufr.jdField_a_of_type_Uft != null)
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
      ((JSONObject)localObject).put("sActivityId", paramufr.jdField_a_of_type_Uft.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject).put("sGiftName", paramufr.jdField_a_of_type_Uft.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("sNeedRole", paramufr.jdField_a_of_type_Uft.h);
      ((JSONObject)localObject).put("iGiftId", paramufr.jdField_a_of_type_Uft.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("gift_icon", paramufr.jdField_a_of_type_Uft.c);
      ((JSONObject)localObject).put("gift_desc", paramufr.jdField_a_of_type_Uft.g);
      ((JSONObject)localObject).put("bag_item_icon_1", paramufr.jdField_a_of_type_Uft.jdField_d_of_type_JavaLangString);
      ((JSONObject)localObject).put("bag_item_icon_2", paramufr.jdField_a_of_type_Uft.jdField_e_of_type_JavaLangString);
      ((JSONObject)localObject).put("bag_item_icon_3", paramufr.jdField_a_of_type_Uft.f);
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
          ((JSONObject)localObject).put("sGameDownloadUrl", paramufr.p);
          ((JSONObject)localObject).put("lGameSize", paramufr.q);
          paramGameAdComData.t = ((JSONObject)localObject).toString();
          return;
        }
        catch (Exception paramGameAdComData)
        {
          ukq.a("parse download info", paramGameAdComData.getMessage());
        }
        localException = localException;
        ukq.a("parse gift info", localException.getMessage());
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
      if (!TextUtils.isEmpty(paramAdData.w)) {
        ((JSONObject)localObject).put("pkgurl", paramAdData.w);
      }
      if (!TextUtils.isEmpty(paramAdData.i)) {
        ((JSONObject)localObject).put("appname", paramAdData.i);
      }
      if (!TextUtils.isEmpty(paramAdData.v)) {
        ((JSONObject)localObject).put("pkg_name", paramAdData.v);
      }
      if (paramAdData.jdField_a_of_type_Ufq != null) {
        ((JSONObject)localObject).put("appid", paramAdData.jdField_a_of_type_Ufq.c);
      }
      paramAdvertisementInfo.mAdExt = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyBottomAdVideoUtil", 2, "adData.mAdExt error:" + localException.getMessage());
        }
      }
    }
    if ((paramAdData != null) && (paramAdData.jdField_a_of_type_Ufq != null)) {
      paramAdvertisementInfo.mAdDownloadApiUrl = paramAdData.jdField_a_of_type_Ufq.jdField_a_of_type_JavaLangString;
    }
  }
  
  private static void a(AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo.processSoftDataInfo(paramAdData.jdField_b_of_type_OrgJsonJSONObject);
    if ((paramAdvertisementInfo.mAdvertisementSoftInfo != null) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_a_of_type_JavaLangString)))
    {
      paramAdvertisementInfo.mSoftAdType = 2;
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.D)) {
        paramAdvertisementInfo.mAdBtnTxt = paramAdvertisementInfo.mAdvertisementSoftInfo.D;
      }
      if (paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1) {
        paramAdvertisementInfo.mAdProductType = 12;
      }
    }
  }
  
  public static boolean a(View paramView, Rect paramRect)
  {
    if (paramView == null) {}
    Rect localRect;
    double d;
    do
    {
      return false;
      localRect = paramRect;
      if (paramRect == null) {
        localRect = new Rect();
      }
      int i = paramView.getHeight();
      paramView.getLocalVisibleRect(localRect);
      d = localRect.height() * 1.0F / i;
    } while ((localRect.top < 0) || (d < 0.5D) || (d <= 0.800000011920929D));
    ukq.a("VideoPlayerWrapper_AD", "showpercentage = " + d);
    ukq.a("VideoPlayerWrapper_AD", " top = " + localRect.top + " bottom = " + localRect.bottom);
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
        localJSONObject.put("AdSource", paramAdData.jdField_n_of_type_Int);
        localJSONObject.put("ad_switchs", paramAdData.jdField_n_of_type_JavaLangString);
        localJSONObject.put("jump_type", paramAdData.R);
        if (uki.e(paramAdData)) {
          localJSONObject.put("game_button_type", 2);
        }
        for (;;)
        {
          if (paramAdData.jdField_a_of_type_Ufr != null)
          {
            localJSONObject.put("game_pkg_name", paramAdData.jdField_a_of_type_Ufr.jdField_b_of_type_JavaLangString);
            localJSONObject.put("game_adtag", paramAdData.jdField_a_of_type_Ufr.o);
            localJSONObject.put("game_app_id", paramAdData.jdField_a_of_type_Ufr.jdField_e_of_type_JavaLangString);
            localJSONObject.put("game_app_name", paramAdData.jdField_a_of_type_Ufr.jdField_a_of_type_JavaLangString);
            localJSONObject.put("game_apk_url", paramAdData.jdField_a_of_type_Ufr.p);
          }
          paramAdvertisementInfo.mAdExtInfo = localJSONObject.toString();
          return;
          if (!uki.c(paramAdData)) {
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
          if (uki.d(paramAdData)) {
            localJSONObject.put("game_button_type", 1);
          } else if (uki.f(paramAdData)) {
            localJSONObject.put("game_button_type", 4);
          }
        }
      }
    }
  }
  
  private static void b(AdData paramAdData, AdvertisementInfo paramAdvertisementInfo)
  {
    paramAdvertisementInfo.mAdAdvertiseId = paramAdData.jdField_c_of_type_Int;
    paramAdvertisementInfo.mAdVideoUrl = paramAdData.o;
    paramAdvertisementInfo.mAdAid = paramAdData.jdField_a_of_type_Long;
    paramAdvertisementInfo.mAdTraceId = paramAdData.jdField_m_of_type_JavaLangString;
    paramAdvertisementInfo.mAdViewId = paramAdData.l;
    paramAdvertisementInfo.mAdProductId = paramAdData.jdField_r_of_type_JavaLangString;
    paramAdvertisementInfo.mAdVia = paramAdData.s;
    paramAdvertisementInfo.mAdNocoId = paramAdData.jdField_c_of_type_Long;
    paramAdvertisementInfo.mAdApurl = paramAdData.g;
    paramAdvertisementInfo.mAdRl = paramAdData.jdField_e_of_type_JavaLangString;
    paramAdvertisementInfo.mAdEffectUrl = paramAdData.p;
    paramAdvertisementInfo.mAdLandingPageReportUrl = paramAdData.q;
    paramAdvertisementInfo.mAdLandingPage = paramAdData.t;
    paramAdvertisementInfo.mAdCanvasJson = paramAdData.u;
    paramAdvertisementInfo.mAdDestType = paramAdData.jdField_d_of_type_Int;
    paramAdvertisementInfo.mOrigin = 1;
    paramAdvertisementInfo.mAdAppDownLoadSchema = paramAdData.x;
    paramAdvertisementInfo.mAdCustomizedInvokeUrl = paramAdData.y;
    paramAdvertisementInfo.mChannelID = 2L;
    paramAdvertisementInfo.mAdProductType = paramAdData.jdField_b_of_type_Int;
    paramAdvertisementInfo.mADVideoAutoPlay = paramAdData.jdField_e_of_type_Int;
    paramAdvertisementInfo.mAlgorithmID = paramAdData.jdField_d_of_type_Long;
    paramAdvertisementInfo.mAlgorithmGroup = paramAdData.jdField_e_of_type_Long;
    paramAdvertisementInfo.mC2SSwitch = paramAdData.f;
    paramAdvertisementInfo.mC2SClickUrl = paramAdData.jdField_c_of_type_JavaUtilArrayList;
    paramAdvertisementInfo.mC2SExposureUrl = paramAdData.jdField_d_of_type_JavaUtilArrayList;
    paramAdvertisementInfo.miniProgramType = paramAdData.j;
    paramAdvertisementInfo.mPhoneComponetId = paramAdData.k;
    if (paramAdData.jdField_a_of_type_Ufr != null) {
      paramAdvertisementInfo.mAdBtnTxt = paramAdData.jdField_a_of_type_Ufr.l;
    }
    try
    {
      paramAdvertisementInfo.mArticleID = Long.parseLong(paramAdData.E);
      if (!TextUtils.isEmpty(paramAdData.jdField_b_of_type_JavaLangString)) {
        paramAdvertisementInfo.mTitle = paramAdData.jdField_b_of_type_JavaLangString;
      }
      paramAdvertisementInfo.mAdLocalSource = a(paramAdData, paramAdvertisementInfo);
      if (!TextUtils.isEmpty(paramAdData.A))
      {
        paramAdvertisementInfo.mAdCorporateImageName = paramAdData.A;
        paramAdvertisementInfo.mAdCorporateLogo = paramAdData.B;
        paramAdvertisementInfo.mSubordinateProductId = paramAdData.z;
        paramAdvertisementInfo.mPopFormH5Url = paramAdData.C;
        paramAdvertisementInfo.mShowAdButton = paramAdData.jdField_c_of_type_Boolean;
        paramAdvertisementInfo.mAdJumpMode = paramAdData.jdField_m_of_type_Int;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramAdData.jdField_a_of_type_JavaLangString)) {
            paramAdvertisementInfo.mAdPosID = Long.valueOf(paramAdData.jdField_a_of_type_JavaLangString).longValue();
          }
          return;
        }
        catch (Exception paramAdData) {}
        localException = localException;
        ukq.a("ReadInJoyBottomAdVideoUtil", "parse article_id error :" + localException.getMessage());
        continue;
        paramAdvertisementInfo.mAdCorporateImageName = paramAdData.i;
      }
    }
  }
  
  private static void c(AdvertisementInfo paramAdvertisementInfo, AdData paramAdData)
  {
    Object localObject;
    if (uki.a(paramAdData))
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
      a((VideoInfo.GameAdComData)localObject, paramAdData.jdField_a_of_type_Ufr);
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
      if (uki.a(paramAdData))
      {
        paramAdvertisementInfo.mBusiJson.put("game_component_type", paramAdData.jdField_a_of_type_Ufr.x);
        paramAdvertisementInfo.mBusiJson.put("game_pkg", paramAdData.jdField_a_of_type_Ufr.jdField_b_of_type_JavaLangString);
      }
      if (paramAdData.jdField_a_of_type_OrgJsonJSONObject != null) {
        paramAdvertisementInfo.mBusiJson.put("article_ad_ext", paramAdData.jdField_a_of_type_OrgJsonJSONObject.toString());
      }
      return;
    }
    catch (Exception paramAdvertisementInfo)
    {
      ukq.a("fillBusiJson", paramAdvertisementInfo.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukt
 * JD-Core Version:    0.7.0.1
 */