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
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.CommentItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.CommentItemShowDispatcher.a;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.CommentItemShowDispatcher.b;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class kmt
{
  public static int aJN = 86400;
  public static int aJO = 10;
  
  public static int a(ReadInJoyCommentListView paramReadInJoyCommentListView)
  {
    paramReadInJoyCommentListView = paramReadInJoyCommentListView.getAdapter();
    int k = 0;
    int i = 0;
    int j = k;
    if ((paramReadInJoyCommentListView instanceof auts))
    {
      paramReadInJoyCommentListView = ((auts)paramReadInJoyCommentListView).getWrappedAdapter();
      j = k;
      if ((paramReadInJoyCommentListView instanceof nlc))
      {
        paramReadInJoyCommentListView = ((nlc)paramReadInJoyCommentListView).bh().iterator();
        j = i;
        if (paramReadInJoyCommentListView.hasNext())
        {
          BaseAdapter localBaseAdapter = (BaseAdapter)paramReadInJoyCommentListView.next();
          if (!(localBaseAdapter instanceof nle)) {
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
  
  public static long a(Container paramContainer, AdvertisementInfo paramAdvertisementInfo)
  {
    return 0L;
  }
  
  public static String a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return "";
    }
    kky localkky = paramAdvertisementInfo.mCommentAdParams;
    if ((!TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl)) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdViewId))) {}
    for (int i = 1;; i = 0)
    {
      int j;
      if (localkky != null) {
        j = localkky.aJM;
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
                localObject3 = kjs.a((oidb_0x885.AdInfo)localObject3);
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
                  if ((TextUtils.isEmpty(((VideoInfo.GameAdComData)localObject1).Xk)) || (TextUtils.isEmpty(((VideoInfo.GameAdComData)localObject1).WX))) {
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
  
  public static JSONObject a(VafContext paramVafContext, ktm paramktm, boolean paramBoolean)
    throws JSONException
  {
    BaseCommentData localBaseCommentData = paramktm.a;
    if ((localBaseCommentData == null) || (localBaseCommentData.commentContent == null) || (paramktm.p == null) || (localBaseCommentData.advertisementInfo == null)) {}
    AdvertisementInfo localAdvertisementInfo;
    kky localkky;
    do
    {
      return null;
      localAdvertisementInfo = localBaseCommentData.advertisementInfo;
      localkky = localAdvertisementInfo.mCommentAdParams;
    } while (localkky == null);
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
      if ((!localBaseCommentData.isAuthorReply()) || (!TextUtils.isEmpty(localBaseCommentData.userTitle))) {
        localJSONObject.put("comment_describe", localBaseCommentData.userTitle);
      }
      localObject = localAdvertisementInfo.mAdCorporateImageName;
      paramVafContext = (VafContext)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramVafContext = ksz.B(localBaseCommentData.nickName, 10);
      }
      localObject = paramVafContext;
      if (paramVafContext == null) {
        localObject = acfp.m(2131710705);
      }
      localJSONObject.put("nickname", localObject);
      localJSONObject.put("commentModel", paramktm);
      if (((localBaseCommentData instanceof CommentData)) && (localBaseCommentData.isAwesome())) {
        localJSONObject.put("awsome_postmark_img", "awsome_postmark");
      }
      if ((paramktm.AA()) && (paramBoolean)) {
        localJSONObject.put("comment_model", paramktm);
      }
      long l2 = localkky.sn;
      long l1 = l2;
      if (l2 == 0L) {
        l1 = System.currentTimeMillis() / 1000L;
      }
      localJSONObject.put("time", kxl.c(l1, true));
      if (localBaseCommentData.medalInfo != null) {
        kxm.a(localJSONObject, localBaseCommentData.medalInfo);
      }
      int j = 0;
      if (!localBaseCommentData.isAd) {
        break label739;
      }
      i = j;
      if (!TextUtils.isEmpty(localAdvertisementInfo.mAdVideoUrl))
      {
        i = j;
        if (!TextUtils.isEmpty(localAdvertisementInfo.mAdViewId)) {
          i = 1;
        }
      }
      if (localkky.aJM != 1) {
        break label676;
      }
      if (i == 0) {
        break label662;
      }
      localObject = "url_big_video";
      paramVafContext = localAdvertisementInfo.mAdVideoUrl;
      label455:
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
          break label732;
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
      if (zQ()) {
        localJSONObject.put("id_comment_tail_3_dot", new JSONObject());
      }
      if (localkky.agd) {
        localJSONObject.put("like_commentModel", paramktm);
      }
      localJSONObject.put("id_comment_ad_tag_center_dot", new JSONObject());
      if (localkky.age) {
        localJSONObject.put("article_model", localAdvertisementInfo);
      }
      QLog.d("CommentAdUtils", 2, "comment data json str : " + localJSONObject.toString());
      return localJSONObject;
      localJSONObject.put("avator_url", localAdvertisementInfo.mAdCorporateLogo + " . ");
      break;
      label662:
      localObject = "url_big_image";
      paramVafContext = localAdvertisementInfo.mAdImg;
      break label455;
      label676:
      if (i != 0) {
        localObject = "url_small_video";
      }
      for (paramVafContext = localAdvertisementInfo.mAdVideoUrl;; paramVafContext = localAdvertisementInfo.mAdImg)
      {
        localJSONObject.put("id_comment_cell_small_ad_container", new JSONObject());
        break;
        localObject = "url_small_image";
      }
      label732:
      label739:
      paramVafContext = "";
      localObject = "url_big_image";
    }
  }
  
  public static oidb_cmd0xc46.ReqAdvertisePara a(int paramInt1, int paramInt2, int paramInt3, jys paramjys)
  {
    int i = 0;
    Object localObject1 = new tlm.a();
    ((tlm.a)localObject1).aJy = "ce2d9f";
    Object localObject2 = tlm.a(BaseApplication.getContext(), (tlm.a)localObject1);
    if (localObject2 != null) {}
    for (localObject1 = ((tlm.b)localObject2).b;; localObject1 = null)
    {
      oidb_cmd0xc46.ReqAdvertisePara localReqAdvertisePara = new oidb_cmd0xc46.ReqAdvertisePara();
      localReqAdvertisePara.uint64_channel_id.set(95555552L, true);
      localReqAdvertisePara.uint64_last_time.set(0L);
      oidb_cmd0xc46.PhoneInfo localPhoneInfo = new oidb_cmd0xc46.PhoneInfo();
      if ((localObject2 != null) && (((tlm.b)localObject2).b != null) && (((tlm.b)localObject2).b.muid != null) && (((tlm.b)localObject2).b.muid_type != null))
      {
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(((tlm.b)localObject2).b.muid.get()));
        localPhoneInfo.uint32_muid_type.set(((tlm.b)localObject2).b.muid_type.get());
      }
      localObject2 = kms.it();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localPhoneInfo.string_imei.set((String)localObject2);
      }
      int j = jxp.na();
      localPhoneInfo.uint32_conn.set(j);
      try
      {
        j = aqgz.LU();
        i = j;
      }
      catch (Exception localException)
      {
        label204:
        break label204;
      }
      localPhoneInfo.uint32_carrier.set(i);
      localObject2 = aqgz.getDeviceOSVersion();
      localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = aqgz.getQQVersion();
      localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      i = AppSetting.getAppId();
      localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      localObject2 = cz.f(cz.s());
      localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localPhoneInfo.uint32_os_type.set(2);
      localPhoneInfo.uint64_func_flag.set(1L);
      localPhoneInfo.bytes_ads_context.set(ByteStringMicro.copyFromUtf8(jzk.cZ()));
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
      localPhoneInfo.bytes_wx_ver.set(ByteStringMicro.copyFrom(kms.T(BaseApplication.getContext()).getBytes()));
      localReqAdvertisePara.msg_phone_info.set(localPhoneInfo, true);
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("adPosType", paramInt1);
        ((JSONObject)localObject1).put("adStartPos", paramInt2);
        ((JSONObject)localObject1).put("adCommentPageSize", paramInt3);
        if ((paramjys != null) && (paramjys.yO()))
        {
          ((JSONObject)localObject1).put("MaterialId", paramjys.aEw);
          ((JSONObject)localObject1).put("RepeatedReqFlag", paramjys.aEx);
          ((JSONObject)localObject1).put("KdPos", paramjys.aEy);
          ((JSONObject)localObject1).put("adPosId", paramjys.re);
        }
        ((JSONObject)localObject1).put("adRequestFlag", 0);
        ((JSONObject)localObject1).put("commentAdsFlag", 1);
        if (zP()) {
          ((JSONObject)localObject1).put("archieveCommentAdLimit", 1);
        }
        localReqAdvertisePara.bytes_ad_user_info.set(ByteStringMicro.copyFromUtf8(((JSONObject)localObject1).toString()));
      }
      catch (JSONException paramjys)
      {
        for (;;)
        {
          paramjys.printStackTrace();
        }
      }
      paramjys = new oidb_cmd0xc46.AdReqInfo();
      paramjys.uint64_ad_channel_id.set(95555552);
      localReqAdvertisePara.msg_ad_req_info.set(paramjys);
      return localReqAdvertisePara;
    }
  }
  
  public static void a(Context paramContext, long paramLong, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      if (knk.w(paramAdvertisementInfo))
      {
        knk.a(paramContext, paramAdvertisementInfo);
        return;
      }
    } while (knd.f(paramAdvertisementInfo) == 1);
    if (knd.j(paramAdvertisementInfo))
    {
      ods.h(paramContext, paramAdvertisementInfo.mPopFormH5Url, paramAdvertisementInfo.mAdRl, paramAdvertisementInfo.mAdTraceId);
      jzk.a(new kku.a().a(paramContext).a(jzk.aFu).b(jzk.aFZ).a(paramAdvertisementInfo).a());
      return;
    }
    kks localkks = new kks();
    if (paramAdvertisementInfo.clickPos == 8) {
      localkks.afZ = true;
    }
    localkks.sl = paramLong;
    ods.a((Activity)paramContext, paramAdvertisementInfo, null, (int)paramAdvertisementInfo.mChannelID, true, localkks);
  }
  
  public static void a(Context paramContext, Container paramContainer, ktm paramktm, int paramInt)
  {
    if ((paramktm == null) || (paramktm.a == null) || (paramktm.a.advertisementInfo == null)) {
      return;
    }
    paramktm = paramktm.a.advertisementInfo;
    paramktm.setClickPos(paramInt);
    a(paramContext, a(paramContainer, paramktm), paramktm);
    a(paramContainer, paramktm);
  }
  
  public static void a(ReadInJoyCommentListView paramReadInJoyCommentListView)
  {
    paramReadInJoyCommentListView.setOnScrollListener(new kmu());
  }
  
  public static void a(BaseCommentData paramBaseCommentData)
  {
    if ((paramBaseCommentData != null) && (paramBaseCommentData.isAd) && (paramBaseCommentData.advertisementInfo != null)) {
      b(paramBaseCommentData.advertisementInfo);
    }
  }
  
  public static void a(Container paramContainer, AdvertisementInfo paramAdvertisementInfo) {}
  
  public static void a(QQAppInterface paramQQAppInterface, CommentItemShowDispatcher paramCommentItemShowDispatcher, int paramInt, List<ktm> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject = (ktm)paramList.get(i);
        if ((((ktm)localObject).a != null) && (((ktm)localObject).a.isAd))
        {
          localArrayList.add(new CommentItemShowDispatcher.a(i, Long.valueOf(0L), (ktm)localObject));
          localObject = new kmv(paramCommentItemShowDispatcher, i, paramQQAppInterface, (ktm)localObject);
          paramCommentItemShowDispatcher.a(paramInt + i, (CommentItemShowDispatcher.b)localObject);
          paramCommentItemShowDispatcher.b(paramInt + i, (CommentItemShowDispatcher.b)localObject);
        }
        i += 1;
      }
    }
    paramCommentItemShowDispatcher.bU(localArrayList);
  }
  
  public static void a(kte paramkte, ktm paramktm, int paramInt, View paramView)
  {
    if ((paramkte != null) && (paramktm != null) && (paramView != null) && (paramktm.a != null) && (paramktm.a.isAd) && (paramktm.a.advertisementInfo != null))
    {
      paramktm = paramktm.a.advertisementInfo;
      ((Container)paramView).getVirtualView().findViewBaseByName(a(paramktm));
      ViewBase localViewBase = ((Container)paramView).getVirtualView().findViewBaseByName("id_view_AdDownloadView");
      if ((localViewBase instanceof koh))
      {
        ((koh)localViewBase).a(paramkte);
        if ((!zQ()) && (paramkte.getVafContext() != null) && (paramkte.getVafContext().getContext() != null)) {
          localViewBase.getComLayoutParams().mLayoutMarginRight = wja.dp2px(16.0F, paramkte.getVafContext().getContext().getResources());
        }
      }
      paramView.setTag(2131381960, paramktm);
    }
  }
  
  public static boolean a(ktm paramktm)
  {
    return (paramktm != null) && (paramktm.a != null) && (paramktm.a.isAd);
  }
  
  public static void aEA()
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
  
  public static void aEB()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSystemSharedPreferences("comment_ad_tag", 0).edit();
    localEditor.putInt(str + "_" + "comment_ad_exposure_count", 0);
    localEditor.apply();
  }
  
  public static void aEC()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject = BaseApplicationImpl.getApplication().getSystemSharedPreferences("comment_ad_tag", 0);
    int i = ((SharedPreferences)localObject).getInt(str + "_" + "comment_ad_exposure_count", 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(str + "_" + "comment_ad_exposure_count", i + 1);
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  public static void b(AdvertisementInfo paramAdvertisementInfo)
  {
    jzk.a(new kku.a().a(BaseApplication.getContext()).a(jzk.aES).b(jzk.aFv).a(paramAdvertisementInfo).d(4000).a());
  }
  
  public static long cf()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return BaseApplicationImpl.getApplication().getSystemSharedPreferences("comment_ad_tag", 0).getLong(str + "_" + "comment_ad_first_show_time", 0L);
  }
  
  public static void doOnDestroy() {}
  
  public static int nq()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return BaseApplicationImpl.getApplication().getSystemSharedPreferences("comment_ad_tag", 0).getInt(str + "_" + "comment_ad_exposure_count", 0);
  }
  
  public static int p(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return 0;
        paramString = ktr.a(paramString);
      } while (paramString == null);
      if (paramInt == 2) {
        return paramString.nJ();
      }
    } while ((paramInt != 3) && (paramInt != 1));
    return paramString.nK();
  }
  
  public static boolean zP()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = cf();
    if ((l2 == 0L) || (l1 - l2 < aJN * 1000)) {
      return nq() >= aJO;
    }
    aEA();
    aEB();
    return true;
  }
  
  public static boolean zQ()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(306);
    if (localAladdinConfig != null) {
      return localAladdinConfig.getIntegerFromString("support_comment_ad_feedback", 0) == 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmt
 * JD-Core Version:    0.7.0.1
 */