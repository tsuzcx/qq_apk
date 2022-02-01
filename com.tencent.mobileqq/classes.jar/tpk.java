import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.PosAdInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.RspBody;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.AdReqInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.PhoneInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqAdvertisePara;

public class tpk
{
  public static int a;
  private static HashSet<tpm> a;
  public static int b;
  
  static
  {
    jdField_a_of_type_Int = 86400;
    b = 10;
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public static int a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return BaseApplicationImpl.getApplication().getSystemSharedPreferences("comment_ad_tag", 0).getInt(str + "_" + "comment_ad_exposure_count", 0);
  }
  
  public static int a(ReadInJoyCommentListView paramReadInJoyCommentListView)
  {
    paramReadInJoyCommentListView = paramReadInJoyCommentListView.getAdapter();
    int k = 0;
    int i = 0;
    int j = k;
    if ((paramReadInJoyCommentListView instanceof blmb))
    {
      paramReadInJoyCommentListView = ((blmb)paramReadInJoyCommentListView).getWrappedAdapter();
      j = k;
      if ((paramReadInJoyCommentListView instanceof sol))
      {
        paramReadInJoyCommentListView = ((sol)paramReadInJoyCommentListView).a().iterator();
        j = i;
        if (paramReadInJoyCommentListView.hasNext())
        {
          BaseAdapter localBaseAdapter = (BaseAdapter)paramReadInJoyCommentListView.next();
          if (!(localBaseAdapter instanceof sop)) {
            break label89;
          }
          i = localBaseAdapter.getCount();
        }
      }
    }
    label89:
    for (;;)
    {
      break;
      return j;
    }
  }
  
  public static int a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return 0;
        paramString = otv.a(paramString);
      } while (paramString == null);
      if (paramInt == 2) {
        return paramString.b();
      }
    } while ((paramInt != 3) && (paramInt != 1));
    return paramString.c();
  }
  
  public static long a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return BaseApplicationImpl.getApplication().getSystemSharedPreferences("comment_ad_tag", 0).getLong(str + "_" + "comment_ad_first_show_time", 0L);
  }
  
  public static long a(Container paramContainer, AdvertisementInfo paramAdvertisementInfo)
  {
    paramContainer = a(paramContainer, paramAdvertisementInfo);
    if (paramContainer != null) {
      return paramContainer.a();
    }
    return 0L;
  }
  
  public static ReadInJoyArticleBottomVideoView a(Container paramContainer, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramContainer == null) || (paramAdvertisementInfo == null)) {
      return null;
    }
    paramAdvertisementInfo = paramAdvertisementInfo.mCommentAdParams;
    int i;
    if (paramAdvertisementInfo != null)
    {
      i = paramAdvertisementInfo.jdField_a_of_type_Int;
      if (i != 1) {
        break label58;
      }
    }
    label58:
    for (paramAdvertisementInfo = "id_ad_comment_big_video";; paramAdvertisementInfo = "id_ad_comment_small_video")
    {
      paramContainer = paramContainer.getVirtualView().findViewBaseByName(paramAdvertisementInfo);
      if (!(paramContainer instanceof ReadInJoyArticleBottomVideoView)) {
        break label64;
      }
      return (ReadInJoyArticleBottomVideoView)paramContainer;
      i = 1;
      break;
    }
    label64:
    return null;
  }
  
  public static String a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return "";
    }
    tma localtma = paramAdvertisementInfo.mCommentAdParams;
    if ((!TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl)) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdViewId))) {}
    for (int i = 1;; i = 0)
    {
      int j;
      if (localtma != null) {
        j = localtma.jdField_a_of_type_Int;
      }
      while (j == 1) {
        if (i != 0)
        {
          return "id_ad_comment_big_video";
          j = 1;
        }
        else
        {
          return "id_ad_comment_big_img";
        }
      }
      if (i != 0) {
        return "id_ad_comment_small_video";
      }
      return "id_ad_comment_small_img";
    }
  }
  
  public static ArrayList<AdvertisementInfo> a(byte[] paramArrayOfByte)
  {
    Object localObject3 = new oidb_0x885.RspBody();
    ArrayList localArrayList = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        ((oidb_0x885.RspBody)localObject3).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = localArrayList;
        if (((oidb_0x885.RspBody)localObject3).rpt_msg_pos_ad_info.has())
        {
          paramArrayOfByte = localArrayList;
          if (!((oidb_0x885.RspBody)localObject3).rpt_msg_pos_ad_info.get().isEmpty())
          {
            localObject3 = ((oidb_0x885.RspBody)localObject3).rpt_msg_pos_ad_info.get();
            QLog.d("CommentAdUtils", 2, "rspBody.rpt_msg_pos_ad_info posAdInfos size >>" + ((List)localObject3).size());
            paramArrayOfByte = localArrayList;
            if (((List)localObject3).size() > 0)
            {
              localArrayList = new ArrayList(((List)localObject3).size());
              try
              {
                paramArrayOfByte = ((List)localObject3).iterator();
                if (!paramArrayOfByte.hasNext()) {
                  continue;
                }
                Object localObject4 = (oidb_0x885.PosAdInfo)paramArrayOfByte.next();
                if ((!((oidb_0x885.PosAdInfo)localObject4).rpt_msg_ad_info.has()) || (((oidb_0x885.PosAdInfo)localObject4).rpt_msg_ad_info.isEmpty())) {
                  continue;
                }
                localObject3 = (oidb_0x885.AdInfo)((oidb_0x885.PosAdInfo)localObject4).rpt_msg_ad_info.get(0);
                localObject1 = ((oidb_0x885.AdInfo)localObject3).bytes_rowkey.get().toStringUtf8();
                localObject3 = tki.a((oidb_0x885.AdInfo)localObject3);
                int i = ((oidb_0x885.PosAdInfo)localObject4).enum_pos_layout.get();
                long l1 = ((oidb_0x885.PosAdInfo)localObject4).uint64_pos_id.get();
                long l2 = ((oidb_0x885.PosAdInfo)localObject4).is_auto_play.get();
                ((AdvertisementInfo)localObject3).mAdFetchTime = 0L;
                ((AdvertisementInfo)localObject3).mAdPosLayout = i;
                ((AdvertisementInfo)localObject3).mAdPosID = l1;
                ((AdvertisementInfo)localObject3).mADVideoAutoPlay = l2;
                ((AdvertisementInfo)localObject3).mRowKey = ((String)localObject1);
                ((AdvertisementInfo)localObject3).mChannelID = 95555552L;
                if (((AdvertisementInfo)localObject3).mSoftAdType != 1) {
                  continue;
                }
                localObject4 = ((AdvertisementInfo)localObject3).mAdExt;
                try
                {
                  localObject1 = new VideoInfo.GameAdComData((String)localObject1, new JSONObject((String)localObject4));
                  if ((TextUtils.isEmpty(((VideoInfo.GameAdComData)localObject1).s)) || (TextUtils.isEmpty(((VideoInfo.GameAdComData)localObject1).d))) {
                    continue;
                  }
                  ((AdvertisementInfo)localObject3).gameAdComData = ((VideoInfo.GameAdComData)localObject1);
                  localArrayList.add(localObject3);
                }
                catch (Exception localException2) {}
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("CommentAdUtils", 2, localException2.getMessage());
                continue;
                ((Exception)localObject2).printStackTrace();
              }
              catch (Exception paramArrayOfByte)
              {
                localObject2 = paramArrayOfByte;
                paramArrayOfByte = localArrayList;
              }
            }
          }
        }
      }
      catch (Exception localException1)
      {
        paramArrayOfByte = (byte[])localObject2;
        Object localObject2 = localException1;
        continue;
        return localException1;
      }
      return paramArrayOfByte;
      if (((AdvertisementInfo)localObject3).mAdPosID <= 0L) {
        ((AdvertisementInfo)localObject3).mAdPosID = 1L;
      }
      localArrayList.add(localObject3);
    }
  }
  
  public static JSONObject a(VafContext paramVafContext, otp paramotp, boolean paramBoolean)
  {
    BaseCommentData localBaseCommentData = paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    if ((localBaseCommentData == null) || (localBaseCommentData.commentContent == null) || (paramotp.jdField_a_of_type_JavaLangCharSequence == null) || (localBaseCommentData.advertisementInfo == null)) {}
    AdvertisementInfo localAdvertisementInfo;
    tma localtma;
    do
    {
      return null;
      localAdvertisementInfo = localBaseCommentData.advertisementInfo;
      localtma = localAdvertisementInfo.mCommentAdParams;
    } while (localtma == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_ad_cell");
    Object localObject;
    int i;
    if (TextUtils.isEmpty(localAdvertisementInfo.mAdCorporateLogo))
    {
      localJSONObject.put("avator_url", "default_comment_avatar");
      QLog.d("CommentAdUtils", 2, "getCommentDataJson | isStar " + localBaseCommentData.isStar() + " isApproved " + localBaseCommentData.isApproved());
      if (localBaseCommentData.isStar()) {
        localJSONObject.put("rij_comment_avatar_borders", "rij_comment_avatar_borders");
      }
      if (localBaseCommentData.isApproved()) {
        localJSONObject.put("rij_comment_v", "rij_comment_v");
      }
      if (localBaseCommentData.isAuthorReply()) {
        localJSONObject.put("author_header_flag_one", anzj.a(2131701114));
      }
      if (!TextUtils.isEmpty(localBaseCommentData.userTitle)) {
        localJSONObject.put("comment_describe", localBaseCommentData.userTitle);
      }
      localObject = localAdvertisementInfo.mAdCorporateImageName;
      paramVafContext = (VafContext)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramVafContext = osp.a(localBaseCommentData.nickName, 10);
      }
      localObject = paramVafContext;
      if (paramVafContext == null) {
        localObject = anzj.a(2131708169);
      }
      localJSONObject.put("nickname", localObject);
      localJSONObject.put("commentModel", paramotp);
      if (((localBaseCommentData instanceof CommentData)) && (localBaseCommentData.isAwesome())) {
        localJSONObject.put("awsome_postmark_img", "awsome_postmark");
      }
      if ((paramotp.a()) && (paramBoolean)) {
        localJSONObject.put("comment_model", paramotp);
      }
      long l2 = localtma.jdField_a_of_type_Long;
      long l1 = l2;
      if (l2 == 0L) {
        l1 = System.currentTimeMillis() / 1000L;
      }
      localJSONObject.put("time", ozr.a(l1, true));
      if (localBaseCommentData.medalInfo != null) {
        ozs.a(localJSONObject, localBaseCommentData.medalInfo);
      }
      int j = 0;
      if (!localBaseCommentData.isAd) {
        break label754;
      }
      i = j;
      if (!TextUtils.isEmpty(localAdvertisementInfo.mAdVideoUrl))
      {
        i = j;
        if (!TextUtils.isEmpty(localAdvertisementInfo.mAdViewId)) {
          i = 1;
        }
      }
      if (localtma.jdField_a_of_type_Int != 1) {
        break label691;
      }
      if (i == 0) {
        break label677;
      }
      localObject = "url_big_video";
      paramVafContext = localAdvertisementInfo.mAdVideoUrl;
      label470:
      localJSONObject.put("id_comment_cell_big_ad_container", new JSONObject());
    }
    for (;;)
    {
      localJSONObject.put((String)localObject, paramVafContext);
      try
      {
        paramVafContext = new JSONObject(localAdvertisementInfo.mAdExtInfo).optString("AdsIconText");
        paramBoolean = TextUtils.isEmpty(paramVafContext);
        if (paramBoolean) {
          break label747;
        }
      }
      catch (Exception paramVafContext)
      {
        for (;;)
        {
          paramVafContext = "广告";
          continue;
          paramVafContext = "广告";
        }
      }
      localJSONObject.put("ad_tag_text", paramVafContext);
      if (b()) {
        localJSONObject.put("id_comment_tail_3_dot", new JSONObject());
      }
      if (localtma.b) {
        localJSONObject.put("like_commentModel", paramotp);
      }
      localJSONObject.put("id_comment_ad_tag_center_dot", new JSONObject());
      if (localtma.c) {
        localJSONObject.put("article_model", localAdvertisementInfo);
      }
      QLog.d("CommentAdUtils", 2, "comment data json str : " + localJSONObject.toString());
      return localJSONObject;
      localJSONObject.put("avator_url", localAdvertisementInfo.mAdCorporateLogo + " . ");
      break;
      label677:
      localObject = "url_big_image";
      paramVafContext = localAdvertisementInfo.mAdImg;
      break label470;
      label691:
      if (i != 0) {
        localObject = "url_small_video";
      }
      for (paramVafContext = localAdvertisementInfo.mAdVideoUrl;; paramVafContext = localAdvertisementInfo.mAdImg)
      {
        localJSONObject.put("id_comment_cell_small_ad_container", new JSONObject());
        break;
        localObject = "url_small_image";
      }
      label747:
      label754:
      paramVafContext = "";
      localObject = "url_big_image";
    }
  }
  
  public static oidb_cmd0xc46.ReqAdvertisePara a(int paramInt1, int paramInt2, int paramInt3, nyp paramnyp)
  {
    int i = 0;
    Object localObject1 = new acwc();
    ((acwc)localObject1).a = "ce2d9f";
    Object localObject2 = acwb.a(BaseApplication.getContext(), (acwc)localObject1);
    if (localObject2 != null) {}
    for (localObject1 = ((acwd)localObject2).a;; localObject1 = null)
    {
      oidb_cmd0xc46.ReqAdvertisePara localReqAdvertisePara = new oidb_cmd0xc46.ReqAdvertisePara();
      localReqAdvertisePara.uint64_channel_id.set(95555552L, true);
      localReqAdvertisePara.uint64_last_time.set(0L);
      oidb_cmd0xc46.PhoneInfo localPhoneInfo = new oidb_cmd0xc46.PhoneInfo();
      if ((localObject2 != null) && (((acwd)localObject2).a != null) && (((acwd)localObject2).a.muid != null) && (((acwd)localObject2).a.muid_type != null))
      {
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(((acwd)localObject2).a.muid.get()));
        localPhoneInfo.uint32_muid_type.set(((acwd)localObject2).a.muid_type.get());
      }
      localObject2 = tpb.b();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localPhoneInfo.string_imei.set((String)localObject2);
      }
      int j = nwy.a();
      localPhoneInfo.uint32_conn.set(j);
      try
      {
        j = bhlo.e();
        i = j;
      }
      catch (Exception localException)
      {
        label204:
        break label204;
      }
      localPhoneInfo.uint32_carrier.set(i);
      localObject2 = bhlo.e();
      localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = bhlo.c();
      localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      i = AppSetting.a();
      localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      localObject2 = dw.a(dw.a());
      localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localPhoneInfo.uint32_os_type.set(2);
      localPhoneInfo.uint64_func_flag.set(1L);
      localPhoneInfo.bytes_ads_context.set(ByteStringMicro.copyFromUtf8(nzq.a()));
      localPhoneInfo.bytes_manufacturer.set(ByteStringMicro.copyFromUtf8(Build.BRAND));
      localPhoneInfo.bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(Build.MODEL));
      if (localObject1 != null)
      {
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.has()) {
          localPhoneInfo.string_qadid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.has()) {
          localPhoneInfo.string_androidid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.has()) {
          localPhoneInfo.string_mac.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.has()) {
          localPhoneInfo.string_oaid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.has()) {
          localPhoneInfo.string_taid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.has()) {
          localPhoneInfo.string_client_ipv4.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
        }
        if (QLog.isColorLevel()) {
          QLog.i("CommentAdUtils", 2, "makeReqAdvertisePara: deviceInfo: ma=" + localPhoneInfo.string_androidid.get() + ", mm=" + localPhoneInfo.string_mac.get() + ", oa=" + localPhoneInfo.string_oaid.get() + ", ta=" + localPhoneInfo.string_taid.get());
        }
      }
      localPhoneInfo.bytes_wx_ver.set(ByteStringMicro.copyFrom(tpb.a(BaseApplication.getContext()).getBytes()));
      localReqAdvertisePara.msg_phone_info.set(localPhoneInfo, true);
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("adPosType", paramInt1);
        ((JSONObject)localObject1).put("adStartPos", paramInt2);
        ((JSONObject)localObject1).put("adCommentPageSize", paramInt3);
        if ((paramnyp != null) && (paramnyp.a()))
        {
          ((JSONObject)localObject1).put("MaterialId", paramnyp.jdField_a_of_type_Int);
          ((JSONObject)localObject1).put("RepeatedReqFlag", paramnyp.b);
          ((JSONObject)localObject1).put("KdPos", paramnyp.c);
          ((JSONObject)localObject1).put("adPosId", paramnyp.jdField_a_of_type_Long);
        }
        ((JSONObject)localObject1).put("adRequestFlag", 0);
        ((JSONObject)localObject1).put("commentAdsFlag", 1);
        if (a()) {
          ((JSONObject)localObject1).put("archieveCommentAdLimit", 1);
        }
        localReqAdvertisePara.bytes_ad_user_info.set(ByteStringMicro.copyFromUtf8(((JSONObject)localObject1).toString()));
      }
      catch (JSONException paramnyp)
      {
        for (;;)
        {
          paramnyp.printStackTrace();
        }
      }
      paramnyp = new oidb_cmd0xc46.AdReqInfo();
      paramnyp.uint64_ad_channel_id.set(95555552);
      localReqAdvertisePara.msg_ad_req_info.set(paramnyp);
      return localReqAdvertisePara;
    }
  }
  
  public static void a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    long l = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences("comment_ad_tag", 0).edit();
    localEditor.putLong(str + "_" + "comment_ad_first_show_time", l);
    localEditor.apply();
    if (QLog.isColorLevel()) {
      QLog.d("CommentAdUtils", 2, "current uni won't show today : " + str + " at time: " + l);
    }
  }
  
  public static void a(int paramInt, AdvertisementInfo paramAdvertisementInfo, ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView)
  {
    if (paramReadInJoyArticleBottomVideoView == null) {
      return;
    }
    jdField_a_of_type_JavaUtilHashSet.add(new tpm(paramAdvertisementInfo, paramInt, paramReadInJoyArticleBottomVideoView));
  }
  
  public static void a(Context paramContext, long paramLong, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      if (tql.a(paramAdvertisementInfo))
      {
        tql.a(paramContext, paramAdvertisementInfo);
        return;
      }
    } while (tqa.a(paramAdvertisementInfo) == 1);
    if (tqa.d(paramAdvertisementInfo))
    {
      ubd.a(paramContext, paramAdvertisementInfo.mPopFormH5Url, paramAdvertisementInfo.mAdRl, paramAdvertisementInfo.mAdTraceId);
      nzq.a(new tlx().a(paramContext).a(nzq.L).b(nzq.aq).a(paramAdvertisementInfo).a());
      return;
    }
    tlt localtlt = new tlt();
    if (paramAdvertisementInfo.clickPos == 8) {
      localtlt.c = true;
    }
    localtlt.jdField_a_of_type_Long = paramLong;
    ubd.a((Activity)paramContext, paramAdvertisementInfo, null, (int)paramAdvertisementInfo.mChannelID, true, localtlt);
  }
  
  public static void a(Context paramContext, Container paramContainer, otp paramotp, int paramInt)
  {
    if ((paramotp == null) || (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.advertisementInfo == null)) {
      return;
    }
    paramotp = paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.advertisementInfo;
    paramotp.setClickPos(paramInt);
    a(paramContext, a(paramContainer, paramotp), paramotp);
    a(paramContainer, paramotp);
  }
  
  public static void a(ReadInJoyCommentListView paramReadInJoyCommentListView, sph paramsph)
  {
    paramReadInJoyCommentListView.setOnScrollListener(new tpl(paramReadInJoyCommentListView, paramsph));
  }
  
  public static void a(BaseCommentData paramBaseCommentData)
  {
    if ((paramBaseCommentData != null) && (paramBaseCommentData.isAd) && (paramBaseCommentData.advertisementInfo != null)) {
      a(paramBaseCommentData.advertisementInfo);
    }
  }
  
  public static void a(AdvertisementInfo paramAdvertisementInfo)
  {
    nzq.a(new tlx().a(BaseApplication.getContext()).a(nzq.j).b(nzq.M).a(paramAdvertisementInfo).d(4000).a());
  }
  
  public static void a(Container paramContainer, AdvertisementInfo paramAdvertisementInfo)
  {
    paramContainer = a(paramContainer, paramAdvertisementInfo);
    if (paramContainer != null) {
      paramContainer.q();
    }
  }
  
  public static void a(ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramReadInJoyArticleBottomVideoView == null)) {
      return;
    }
    paramReadInJoyArticleBottomVideoView.setVisibility(0);
    nzg localnzg = new nzg();
    localnzg.e = paramAdvertisementInfo.mAdImg;
    localnzg.d = paramAdvertisementInfo.mAdVideoUrl;
    ProteusBannerVideoItemData localProteusBannerVideoItemData = new ProteusBannerVideoItemData();
    localProteusBannerVideoItemData.jdField_f_of_type_Boolean = false;
    localProteusBannerVideoItemData.jdField_f_of_type_Long = paramAdvertisementInfo.mAdVideoFileSize;
    localProteusBannerVideoItemData.g = true;
    paramReadInJoyArticleBottomVideoView.a(localnzg, paramAdvertisementInfo, localProteusBannerVideoItemData, null);
  }
  
  public static void a(otd paramotd, otp paramotp, int paramInt, View paramView)
  {
    if ((paramotd != null) && (paramotp != null) && (paramView != null) && (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAd) && (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.advertisementInfo != null))
    {
      paramotp = paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.advertisementInfo;
      ViewBase localViewBase = ((Container)paramView).getVirtualView().findViewBaseByName(a(paramotp));
      if ((localViewBase instanceof ReadInJoyArticleBottomVideoView))
      {
        a((ReadInJoyArticleBottomVideoView)localViewBase, paramotp);
        a(paramInt, paramotp, (ReadInJoyArticleBottomVideoView)localViewBase);
      }
      localViewBase = ((Container)paramView).getVirtualView().findViewBaseByName("id_view_AdDownloadView");
      if ((localViewBase instanceof tse))
      {
        ((tse)localViewBase).a(paramotd);
        if ((!b()) && (paramotd.a() != null) && (paramotd.a().getContext() != null)) {
          localViewBase.getComLayoutParams().mLayoutMarginRight = agej.a(16.0F, paramotd.a().getContext().getResources());
        }
      }
      paramView.setTag(2131381109, paramotp);
    }
  }
  
  public static void a(sph paramsph, int paramInt, List<otp> paramList)
  {
    if ((paramInt == 0) && (paramsph != null)) {
      paramsph.a();
    }
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        otp localotp = (otp)paramList.get(i);
        if ((localotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (localotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAd))
        {
          spg localspg = new spg();
          localspg.jdField_a_of_type_Int = (i + paramInt);
          localspg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = localotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.advertisementInfo;
          localArrayList.add(localspg);
        }
        i += 1;
      }
    }
    if (localArrayList.size() > 0) {
      paramsph.a(localArrayList);
    }
  }
  
  public static boolean a()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = a();
    if ((l2 == 0L) || (l1 - l2 < jdField_a_of_type_Int * 1000)) {
      return a() >= b;
    }
    a();
    b();
    return true;
  }
  
  public static boolean a(otp paramotp)
  {
    return (paramotp != null) && (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAd);
  }
  
  public static void b()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences("comment_ad_tag", 0).edit();
    localEditor.putInt(str + "_" + "comment_ad_exposure_count", 0);
    localEditor.apply();
  }
  
  public static boolean b()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(306);
    if (localAladdinConfig != null) {
      return localAladdinConfig.getIntegerFromString("support_comment_ad_feedback", 0) == 1;
    }
    return false;
  }
  
  public static void c()
  {
    jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public static void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpk
 * JD-Core Version:    0.7.0.1
 */