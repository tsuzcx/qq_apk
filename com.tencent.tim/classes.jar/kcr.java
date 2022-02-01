import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.AdTagInfo;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import com.tencent.biz.pubaccount.VideoInfo.DownloadBarInfo;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;
import com.tencent.biz.pubaccount.VideoInfo.EntranceDownloadInfo;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;
import com.tencent.biz.pubaccount.VideoInfo.LikeActionDownloadBar;
import com.tencent.biz.pubaccount.VideoInfo.SoftAdDownloadBarInfo;
import com.tencent.biz.pubaccount.VideoInfo.TopBarInfo;
import com.tencent.biz.pubaccount.VideoInfo.a;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler.1;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler.2;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler.3;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler.4;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.WeishiRedDotInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AccountVInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AdVideoPos;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.AppAdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ArticleSummary;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ChannelInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.DisLikeInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.DownloadBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ECommerceEntranceInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.EntranceDownloadInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ExposeArticleInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsIdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.FeedsInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.InnerMsg;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.InterruptedWeishiAd;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.LikeDownloadBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PhoneInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PkgInstallInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PosAdInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqAdvertisePara;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.SoftAdDownloadBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.TopBarInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UGCFeedsInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UGCVideoInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UrlJumpInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.UserExposeArticle;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.VideoColumnInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.VideoFloatInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdReqInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdTagInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.GameComponentInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class kcr
  extends accg
{
  private int aHx;
  private String[] pkgList = { "com.tencent.reading", "com.tencent.rijvideo", "com.tencent.weishi" };
  private SimpleDateFormat q;
  private long rG;
  
  public kcr(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public kcr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private VideoInfo.ECommerceEntranceInfo a(oidb_0x6cf.InterruptedWeishiAd paramInterruptedWeishiAd, oidb_0x6cf.RspBody paramRspBody)
  {
    VideoInfo.ECommerceEntranceInfo localECommerceEntranceInfo2;
    if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.has())
    {
      localECommerceEntranceInfo2 = new VideoInfo.ECommerceEntranceInfo();
      localECommerceEntranceInfo2.title = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_title);
      localECommerceEntranceInfo2.subTitle = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_subtitle);
      localECommerceEntranceInfo2.WU = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_thumbnail_url);
      localECommerceEntranceInfo2.WV = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_link_icon_url);
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_jump_type.has()) {
        localECommerceEntranceInfo2.jumpType = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_jump_type.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_ecommerce_id.has()) {
        localECommerceEntranceInfo2.videoSource = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_ecommerce_id.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_display_count_ver.has()) {
        localECommerceEntranceInfo2.aHn = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_display_count_ver.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.has()) {
        localECommerceEntranceInfo2.aHp = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.get();
      }
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_session_max_display_count.has()) {
        localECommerceEntranceInfo2.aHo = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_session_max_display_count.get();
      }
      localECommerceEntranceInfo2.jumpUrl = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_jump_url);
      localECommerceEntranceInfo2.WT = a(paramInterruptedWeishiAd.msg_ecommerce_entrance_info.bytes_common_data);
      localECommerceEntranceInfo2.style = paramInterruptedWeishiAd.msg_ecommerce_entrance_info.uint32_style.get();
      localECommerceEntranceInfo1 = localECommerceEntranceInfo2;
      if (paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.has())
      {
        localECommerceEntranceInfo2.b = new UrlJumpInfo();
        localECommerceEntranceInfo2.b.jumpType = ((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).uint32_jump_type.get();
        localECommerceEntranceInfo2.b.aiM = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_bundle);
        localECommerceEntranceInfo2.b.jumpSchema = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_schema);
        localECommerceEntranceInfo2.b.jumpUrl = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_url);
        localECommerceEntranceInfo2.b.aiN = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_clipboard_info);
        localECommerceEntranceInfo2.WR = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_open_wording);
        localECommerceEntranceInfo2.WQ = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_download_wording);
        localECommerceEntranceInfo2.subTitle = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_desc);
        localECommerceEntranceInfo2.WU = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_icon_url);
        localECommerceEntranceInfo2.title = a(((oidb_0x6cf.AppAdInfo)paramInterruptedWeishiAd.msg_ecommerce_entrance_info.appInfo.get()).bytes_name);
      }
    }
    for (VideoInfo.ECommerceEntranceInfo localECommerceEntranceInfo1 = localECommerceEntranceInfo2;; localECommerceEntranceInfo1 = null)
    {
      int i;
      if ((localECommerceEntranceInfo1 != null) && (paramRspBody.msg_ecommerce_entrance_config.has()) && (paramRspBody.msg_ecommerce_entrance_config.get() != null))
      {
        if (paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.has()) {
          localECommerceEntranceInfo1.playTime = paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.get();
        }
        paramInterruptedWeishiAd = a(paramRspBody.msg_ecommerce_entrance_config.bytes_show_positon);
        if (!TextUtils.isEmpty(paramInterruptedWeishiAd))
        {
          paramInterruptedWeishiAd = paramInterruptedWeishiAd.split(",");
          if ((paramInterruptedWeishiAd != null) && (paramInterruptedWeishiAd.length > 0))
          {
            localECommerceEntranceInfo1.da = new int[paramInterruptedWeishiAd.length];
            i = 0;
          }
        }
      }
      for (;;)
      {
        if (i < paramInterruptedWeishiAd.length) {}
        try
        {
          localECommerceEntranceInfo1.da[i] = Integer.parseInt(paramInterruptedWeishiAd[i]);
          label685:
          i += 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "get commerceEntranceInfo in config: " + localECommerceEntranceInfo1.toString());
          }
          return localECommerceEntranceInfo1;
        }
        catch (Exception paramRspBody)
        {
          break label685;
        }
      }
    }
  }
  
  private VideoInfo a(oidb_0x6cf.ArticleSummary paramArticleSummary, oidb_0x6cf.RspBody paramRspBody)
    throws Exception
  {
    boolean bool2 = true;
    int j = 0;
    VideoInfo localVideoInfo = b(paramArticleSummary, paramRspBody);
    boolean bool1;
    if (localVideoInfo != null)
    {
      if ((TextUtils.isEmpty(localVideoInfo.title)) && (QLog.isColorLevel())) {
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "req_article_summary getRecommendList 获取原文章标题, NULL ERROR");
      }
      if ((paramArticleSummary.bytes_inner_id.has()) && (paramArticleSummary.bytes_inner_id.get() != null)) {
        localVideoInfo.Wz = paramArticleSummary.bytes_inner_id.get().toStringUtf8();
      }
      if (paramArticleSummary.uint64_article_id.has()) {
        localVideoInfo.rz = paramArticleSummary.uint64_article_id.get();
      }
      if (paramRspBody.msg_interrupted_ad_weishi.has())
      {
        paramRspBody = (oidb_0x6cf.InterruptedWeishiAd)paramRspBody.msg_interrupted_ad_weishi.get();
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = new VideoInfo.InterruptedWeishiAd();
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.adUrl = a(paramRspBody.bytes_ad_url);
        paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
        if (paramRspBody.uint32_is_show_in_play_end.has()) {
          if (paramRspBody.uint32_is_show_in_play_end.get() == 1) {
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      paramArticleSummary.adO = bool1;
      paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
      label218:
      int i;
      if (paramRspBody.uint32_is_show_in_switch.has()) {
        if (paramRspBody.uint32_is_show_in_switch.get() == 1)
        {
          bool1 = bool2;
          paramArticleSummary.adN = bool1;
          paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
          if (!paramRspBody.uint32_show_after_play_time.has()) {
            break label349;
          }
          i = paramRspBody.uint32_show_after_play_time.get();
          label248:
          paramArticleSummary.aHs = i;
          paramArticleSummary = a(paramRspBody.bytes_show_positon);
          if (paramArticleSummary == null) {
            break label354;
          }
          paramArticleSummary = paramArticleSummary.split(",");
          label273:
          if ((paramArticleSummary == null) || (paramArticleSummary.length <= 0)) {
            break label359;
          }
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.db = new int[paramArticleSummary.length];
          i = 0;
          label296:
          if (i >= paramArticleSummary.length) {
            break label359;
          }
        }
      }
      try
      {
        localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.db[i] = Integer.parseInt(paramArticleSummary[i]);
        label318:
        i += 1;
        break label296;
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        bool1 = false;
        break label218;
        bool1 = false;
        break label218;
        label349:
        i = -1;
        break label248;
        label354:
        paramArticleSummary = null;
        break label273;
        label359:
        paramArticleSummary = localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
        i = j;
        if (paramRspBody.uint32_interrupted_ad_type.has()) {
          i = paramRspBody.uint32_interrupted_ad_type.get();
        }
        paramArticleSummary.type = i;
        if (paramRspBody.appInfo.has())
        {
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.WQ = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_app_download_wording);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.WR = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_app_open_wording);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.appName = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_name);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.appIconUrl = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_icon_url);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.b = new UrlJumpInfo();
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.b.jumpType = ((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).uint32_jump_type.get();
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.b.aiM = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_bundle);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.b.jumpSchema = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_schema);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.b.jumpUrl = a(((oidb_0x6cf.AppAdInfo)paramRspBody.appInfo.get()).bytes_jump_url);
        }
        return localVideoInfo;
      }
      catch (Exception localException)
      {
        break label318;
      }
    }
  }
  
  private String a(PBBytesField paramPBBytesField)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  private void a(Object paramObject, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, ArrayList<oidb_0x885.AdTagInfo> paramArrayList, int paramInt4, int paramInt5, int paramInt6, int paramInt7, ArrayList<VideoInfo> paramArrayList2)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    if (paramVideoInfo.Wz == null) {
      paramVideoInfo.Wz = "";
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  articleId = " + paramVideoInfo.Wz + ", secondVideoArticleID = " + paramString1 + ", type = " + paramInt1 + ",polymericTopicId = " + paramLong2);
    }
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    Object localObject = ByteStringMicro.copyFromUtf8(paramVideoInfo.Wz);
    localReqBody.bytes_inner_id.set((ByteStringMicro)localObject);
    localReqBody.uint64_uin.set(paramLong1);
    localReqBody.uint32_req_source.set(paramInt1);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString1);
      localReqBody.rpt_bytes_redo_inner_id.add(paramString1);
    }
    if (paramLong2 != -1L) {
      localReqBody.uint32_req_topic_id.set((int)paramLong2);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString2);
      localReqBody.bytes_req_web.set(paramString1);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = ByteStringMicro.copyFromUtf8(paramString3);
      localReqBody.bytes_cookie.set(paramString1);
    }
    paramString2 = new oidb_0x6cf.ReqAdvertisePara();
    paramString2.msg_phone_info.set(kms.a());
    paramString2.uint64_last_time.set(this.rG);
    paramString1 = new oidb_0x6cf.VideoFloatInfo();
    paramString1.uint32_ad_support.set(1);
    if ((paramArrayList1 == null) || (paramArrayList1.size() <= 0)) {
      paramString1.uint32_info_num.set(0);
    }
    label415:
    boolean bool;
    for (;;)
    {
      paramString2.msg_video_float_info.set(paramString1);
      paramString3 = new oidb_0x885.AdReqInfo();
      paramString3.uint64_ad_channel_id.set(0L);
      paramString3.int32_revision_video.set(paramInt7);
      paramString3.source_channel_id.set(this.aHx);
      if ((paramVideoInfo != null) && (paramVideoInfo.height != 0) && (paramVideoInfo.width != 0))
      {
        if (paramVideoInfo.height > paramVideoInfo.width) {
          paramString3.int32_scene_id.set(2);
        }
      }
      else
      {
        if (paramArrayList != null) {
          break label1254;
        }
        paramString3.int32_req_type.set(0);
        bool = false;
        label432:
        paramString2.msg_ad_req_info.set(paramString3);
        if (anwa.aze()) {
          paramString3 = new JSONObject();
        }
      }
      try
      {
        paramString3.put("reqLearningPatternFlag", 1);
        label467:
        paramString2.bytes_ad_user_info.set(ByteStringMicro.copyFromUtf8(paramString3.toString()));
        localReqBody.req_advertise_para.set(paramString2);
        localReqBody.uint32_req_dislike_type.set(1);
        paramString2 = localReqBody.uint32_req_vertical_video;
        if (paramBoolean)
        {
          paramInt1 = 1;
          label517:
          paramString2.set(paramInt1);
          paramString2 = localReqBody.uint32_is_ugc;
          if (!paramVideoInfo.adB) {
            break label1334;
          }
          paramInt1 = 1;
          label542:
          paramString2.set(paramInt1);
          if (!TextUtils.isEmpty(paramString4)) {
            localReqBody.bytes_req_range_cookie.set(ByteStringMicro.copyFromUtf8(paramString4));
          }
          if (paramVideoInfo.adB)
          {
            paramString2 = new oidb_0x6cf.FeedsIdInfo();
            paramString2.uint64_feeds_id.set(paramVideoInfo.rA);
            paramString2.uint32_feeds_type.set(paramVideoInfo.feedType);
            localReqBody.ugc_feeds_info.set(paramString2);
          }
          if ((paramWeishiRedDotInfo != null) && (paramWeishiRedDotInfo.ba() != null) && (paramWeishiRedDotInfo.ba().size() > 0)) {
            paramString2 = new ArrayList();
          }
        }
      }
      catch (JSONException paramArrayList)
      {
        try
        {
          paramString3 = ByteStringMicro.copyFromUtf8(paramWeishiRedDotInfo.getTitle());
          paramInt1 = Integer.parseInt(paramWeishiRedDotInfo.jY());
          paramLong1 = Long.parseLong(paramWeishiRedDotInfo.jX());
          paramString4 = ByteStringMicro.copyFromUtf8(paramWeishiRedDotInfo.jd());
          paramWeishiRedDotInfo = paramWeishiRedDotInfo.ba().iterator();
          while (paramWeishiRedDotInfo.hasNext())
          {
            paramArrayList = (String)paramWeishiRedDotInfo.next();
            localObject = new oidb_0x6cf.InnerMsg();
            ((oidb_0x6cf.InnerMsg)localObject).bytes_title.set(paramString3);
            ((oidb_0x6cf.InnerMsg)localObject).uint32_strategy_id.set(paramInt1);
            ((oidb_0x6cf.InnerMsg)localObject).uint64_algorithm_id.set(paramLong1);
            ((oidb_0x6cf.InnerMsg)localObject).bytes_push_context.set(paramString4);
            ((oidb_0x6cf.InnerMsg)localObject).article_content_type.set(2);
            ((oidb_0x6cf.InnerMsg)localObject).uint32_jump_src_type.set(10);
            ((oidb_0x6cf.InnerMsg)localObject).bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramArrayList));
            paramString2.add(localObject);
          }
        }
        catch (Exception paramString3)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList: 解析redDotInfo失败" + paramString3);
          }
          if (!paramString2.isEmpty()) {
            localReqBody.rpt_inner_msg_list.set(paramString2);
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label1397;
            }
            paramString2 = new StringBuilder("getRecommendList AdvertiseParam:\n");
            paramString2.append("last_time=").append(this.rG).append(", info_num=").append(paramString1.uint32_info_num.get());
            if ((!paramString1.rpt_msg_ad_video_pos.has()) || (paramString1.rpt_msg_ad_video_pos.get() == null)) {
              break label1386;
            }
            paramString2.append(", adList=\n");
            paramString1 = paramString1.rpt_msg_ad_video_pos.get().iterator();
            while (paramString1.hasNext())
            {
              paramString3 = (oidb_0x6cf.AdVideoPos)paramString1.next();
              paramString2.append("[pos=").append(paramString3.int32_kd_pos.get()).append(", aid=").append(paramString3.uint64_aid.get()).append(", traceID=").append(paramString3.bytes_trace_id.get().toStringUtf8()).append("]\n");
            }
            paramString3 = new ArrayList();
            int i = 0;
            paramInt1 = 0;
            if (paramInt1 < paramArrayList1.size())
            {
              localObject = (VideoInfo)paramArrayList1.get(paramInt1);
              if (!((VideoInfo)localObject).isAD) {
                i += 1;
              }
              for (;;)
              {
                paramInt1 += 1;
                break;
                oidb_0x6cf.AdVideoPos localAdVideoPos = new oidb_0x6cf.AdVideoPos();
                if (((VideoInfo)localObject).jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo != null)
                {
                  if (!TextUtils.isEmpty(((VideoInfo)localObject).jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo.We)) {
                    localAdVideoPos.bytes_trace_id.set(ByteStringMicro.copyFromUtf8(((VideoInfo)localObject).jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo.We));
                  }
                  localAdVideoPos.uint64_aid.set(((VideoInfo)localObject).jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo.ru);
                }
                localAdVideoPos.int32_kd_pos.set(paramInt1);
                paramString3.add(localAdVideoPos);
              }
            }
            paramString1.uint32_info_num.set(i);
            if (paramString3.size() <= 0) {
              break;
            }
            paramString1.rpt_msg_ad_video_pos.set(paramString3);
            break;
            paramString3.int32_scene_id.set(1);
            break label415;
            label1254:
            paramString3.int32_req_type.set(2);
            localObject = new oidb_0x885.GameComponentInfo();
            ((oidb_0x885.GameComponentInfo)localObject).uint32_day_display_count.set(paramInt5);
            ((oidb_0x885.GameComponentInfo)localObject).uint32_session_display_count.set(paramInt4);
            ((oidb_0x885.GameComponentInfo)localObject).rpt_tag_info.set(paramArrayList);
            paramString3.msg_game_component_info.set((MessageMicro)localObject);
            bool = true;
            break label432;
            paramArrayList = paramArrayList;
            paramArrayList.printStackTrace();
            break label467;
            paramInt1 = 0;
            break label517;
            label1334:
            paramInt1 = 0;
            break label542;
            if (!paramString2.isEmpty()) {
              localReqBody.rpt_inner_msg_list.set(paramString2);
            }
          }
        }
        finally
        {
          if (!paramString2.isEmpty()) {
            localReqBody.rpt_inner_msg_list.set(paramString2);
          }
        }
      }
    }
    label1386:
    QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramString2.toString());
    label1397:
    if (paramArrayOfByte != null)
    {
      localReqBody.bytes_req_context_pb.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty()))
      {
        paramArrayList1 = (VideoInfo)paramArrayList1.get(paramArrayList1.size() - 1);
        if (!TextUtils.isEmpty(paramArrayList1.Wz)) {
          localReqBody.bytes_end_rowkey.set(ByteStringMicro.copyFromUtf8(paramArrayList1.Wz));
        }
        localReqBody.uint64_end_recommend_seq.set(paramArrayList1.recommendSeq);
      }
    }
    localReqBody.uint32_req_times.set(paramInt3);
    localReqBody.uint32_req_network.set(nc());
    localReqBody.uint32_req_os.set(1);
    localReqBody.uint32_req_sim_type.set(awit.Qg());
    localReqBody.uint32_req_column_id.set(paramInt2);
    localReqBody.enum_req_video_show_mode.set(paramInt6);
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
    {
      paramArrayList1 = new oidb_0x6cf.UserExposeArticle();
      paramString1 = new ArrayList();
      paramString2 = paramArrayList2.iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (VideoInfo)paramString2.next();
        if (!TextUtils.isEmpty(paramString3.Wz))
        {
          paramWeishiRedDotInfo = new oidb_0x6cf.ExposeArticleInfo();
          paramWeishiRedDotInfo.bytes_rowkeys.set(ByteStringMicro.copyFromUtf8(paramString3.Wz));
          paramWeishiRedDotInfo.uint64_algorithm_id.set(paramString3.algorithmID);
          paramString1.add(paramWeishiRedDotInfo);
        }
      }
      paramArrayList1.rpt_article.set(paramString1);
      localReqBody.user_expose_article.set(paramArrayList1);
    }
    a(localReqBody);
    paramInt1 = ((Integer)awit.f("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue();
    localReqBody.uint32_youngster_status.set(paramInt1);
    localReqBody.uint32_req_recommend_flag.set(getRecommendFlag());
    paramArrayList1 = super.makeOIDBPkg("OidbSvc.0x6cf", 1743, 0, localReqBody.toByteArray());
    paramArrayList1.addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(paramObject.hashCode()));
    paramArrayList1.addAttribute("VALUE_REQUEST_VIDEO_ARTICLE_ID", paramVideoInfo.Wz);
    paramArrayList1.addAttribute("VALUE_REQUEST_GAME_DATA", Boolean.valueOf(bool));
    super.sendPbReq(paramArrayList1);
  }
  
  private void a(oidb_0x6cf.ReqBody paramReqBody)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = this.pkgList;
    int k = arrayOfString.length;
    int i = 0;
    if (i < k)
    {
      String str = arrayOfString[i];
      oidb_0x6cf.PkgInstallInfo localPkgInstallInfo = new oidb_0x6cf.PkgInstallInfo();
      localPkgInstallInfo.bytes_pkg_name.set(ByteStringMicro.copyFromUtf8(str));
      str = aqiz.O(BaseApplicationImpl.getContext(), str);
      PBUInt32Field localPBUInt32Field = localPkgInstallInfo.uint32_is_installed;
      if (!str.equals("0")) {}
      for (int j = 1;; j = 0)
      {
        localPBUInt32Field.set(j);
        localPkgInstallInfo.bytes_version.set(ByteStringMicro.copyFromUtf8(str));
        localPkgInstallInfo.uint32_platform_type.set(1);
        localArrayList.add(localPkgInstallInfo);
        i += 1;
        break;
      }
    }
    paramReqBody.rpt_pkg_install_info.set(localArrayList);
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    boolean bool = true;
    if ((paramVideoInfo == null) || (paramVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo == null)) {
      bool = false;
    }
    do
    {
      return bool;
      if (paramVideoInfo.qU != 2) {
        break;
      }
    } while ((!TextUtils.isEmpty(paramVideoInfo.WC)) && (!TextUtils.isEmpty(paramVideoInfo.title)) && (!TextUtils.isEmpty(paramVideoInfo.coverUrl)) && (!TextUtils.isEmpty(paramVideoInfo.webUrl)));
    while ((paramVideoInfo.qU != 1) || (TextUtils.isEmpty(paramVideoInfo.WC)) || (TextUtils.isEmpty(paramVideoInfo.accountName)) || (TextUtils.isEmpty(paramVideoInfo.title)) || (TextUtils.isEmpty(paramVideoInfo.vid)) || (TextUtils.isEmpty(paramVideoInfo.webUrl))) {
      return false;
    }
    return true;
  }
  
  private VideoInfo b(oidb_0x6cf.ArticleSummary paramArticleSummary, oidb_0x6cf.RspBody paramRspBody)
    throws JSONException
  {
    localVideoInfo = new VideoInfo();
    if ((paramArticleSummary.bytes_article_title.has()) && (paramArticleSummary.bytes_article_title.get() != null)) {
      localVideoInfo.title = paramArticleSummary.bytes_article_title.get().toStringUtf8();
    }
    String str1 = a(paramRspBody.bytes_rsp_ug_interface_data);
    try
    {
      Object localObject1 = new JSONObject(((JSONObject)new JSONObject(str1).getJSONArray("items").get(0)).getString("extData"));
      localObject5 = null;
      try
      {
        localObject7 = ((JSONObject)new JSONObject(str1).getJSONArray("items").get(0)).getJSONObject("privateInfo");
        localObject5 = localObject7;
      }
      catch (Exception localException3)
      {
        Object localObject7;
        label128:
        break label128;
      }
      localObject7 = null;
      try
      {
        str1 = ((JSONObject)new JSONObject(str1).getJSONArray("items").get(0)).getString("backoffGroup");
        localObject7 = str1;
      }
      catch (Exception localException5)
      {
        label165:
        int i;
        int j;
        label1079:
        label1223:
        break label165;
      }
      if ((localObject1 != null) && (localObject5 != null) && (!TextUtils.isEmpty((CharSequence)localObject7))) {}
      try
      {
        str1 = ((JSONObject)localObject1).optString("top_base_pic");
        str2 = ((JSONObject)localObject1).optString("top_redenv_pic");
        str3 = ((JSONObject)localObject1).optString("top_txt_showpic");
        str4 = ((JSONObject)localObject1).optString("top_close_pic");
        str5 = ((JSONObject)localObject1).optString("download_word_color");
        str6 = ((JSONObject)localObject1).optString("apk_link");
        str7 = ((JSONObject)localObject5).getJSONObject(a(paramArticleSummary.bytes_kb_id)).optString("deepLink");
        str8 = ((JSONObject)localObject1).optString("clipboard_data");
        str9 = (String)((JSONObject)localObject5).getJSONObject(a(paramArticleSummary.bytes_kb_id)).getJSONObject("statInfo").getJSONArray("999").get(0);
        str10 = ((JSONObject)localObject1).optString("pkg_name");
        str11 = ((JSONObject)localObject1).optString("top_downloading_txt");
        str12 = ((JSONObject)localObject1).optString("top_dldparse_txt");
        str13 = ((JSONObject)localObject1).optString("top_downloaded_txt");
        i = ((JSONObject)localObject1).optInt("max_click_num");
        j = ((JSONObject)localObject1).optInt("max_exposure_num");
        k = ((JSONObject)localObject5).getJSONObject(a(paramArticleSummary.bytes_kb_id)).getInt("useUG");
        if (k == 2) {
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str7)) && (!TextUtils.isEmpty(str9)) && (!TextUtils.isEmpty(str10)))
          {
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a = new VideoInfo.a();
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.Xz = str1;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XA = str2;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XB = str3;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XC = str4;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XD = str5;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XE = str6;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XF = str7;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XG = str8;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XH = str9;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XI = str10;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XJ = str11;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XK = str12;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XL = str13;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.aHu = i;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.aHv = j;
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XM = ((String)localObject7);
            localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.aHw = k;
          }
        }
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          String str2;
          String str3;
          String str4;
          String str5;
          String str6;
          String str7;
          String str8;
          String str9;
          String str10;
          String str11;
          String str12;
          String str13;
          int k;
          Object localObject2;
          continue;
          if ((k == 1) && (!TextUtils.isEmpty(localException4)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str6)) && (!TextUtils.isEmpty(str8)) && (!TextUtils.isEmpty(str9)) && (!TextUtils.isEmpty(str10)) && (!TextUtils.isEmpty(str11)) && (!TextUtils.isEmpty(str12)) && (!TextUtils.isEmpty(str13)))
          {
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a = new VideoInfo.a();
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.Xz = localException4;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XA = str2;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XB = str3;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XC = str4;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XD = str5;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XE = str6;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XF = str7;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XG = str8;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XH = str9;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XI = str10;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XJ = str11;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XK = str12;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XL = str13;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.aHu = i;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.aHv = j;
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XM = ((String)localObject7);
            localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.aHw = k;
          }
        }
      }
      try
      {
        str1 = ((JSONObject)localObject1).optString("shoot_base_pic");
        str2 = ((JSONObject)localObject1).optString("shoot_redenv_pic");
        str3 = ((JSONObject)localObject1).optString("shoot_txt_showpic");
        str4 = ((JSONObject)localObject1).optString("shoot_close_pic");
        str5 = ((JSONObject)localObject1).optString("download_word_color");
        str6 = ((JSONObject)localObject1).optString("apk_link");
        str7 = ((JSONObject)localObject5).getJSONObject(a(paramArticleSummary.bytes_kb_id)).optString("deepLink");
        str8 = ((JSONObject)localObject1).optString("clipboard_data");
        str9 = (String)((JSONObject)localObject5).getJSONObject(a(paramArticleSummary.bytes_kb_id)).getJSONObject("statInfo").getJSONArray("999").get(0);
        str10 = ((JSONObject)localObject1).optString("pkg_name");
        str11 = ((JSONObject)localObject1).optString("shoot_downloading_txt");
        str12 = ((JSONObject)localObject1).optString("shoot_dldparse_txt");
        str13 = ((JSONObject)localObject1).optString("shoot_downloaded_txt");
        i = ((JSONObject)localObject1).optInt("max_click_num");
        j = ((JSONObject)localObject1).optInt("max_exposure_num");
        k = ((JSONObject)localObject5).getJSONObject(a(paramArticleSummary.bytes_kb_id)).getInt("useUG");
        if (k != 2) {
          break label1521;
        }
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str7)) && (!TextUtils.isEmpty(str9)) && (!TextUtils.isEmpty(str10)))
        {
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a = new VideoInfo.a();
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.Xz = str1;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XA = str2;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XB = str3;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XC = str4;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XD = str5;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XE = str6;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XF = str7;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XG = str8;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XH = str9;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XI = str10;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XJ = str11;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XK = str12;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XL = str13;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.aHu = i;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.aHv = j;
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.XM = ((String)localObject7);
          localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoInfo$a.aHw = k;
        }
      }
      catch (Exception localException2)
      {
        break label1079;
        localVideoInfo.jR.add(localObject5);
        break label1223;
        if ((!paramArticleSummary.uint64_time.has()) || (paramArticleSummary.uint64_time.get() == 0L)) {
          break label1878;
        }
        localVideoInfo.createTime = this.q.format(Long.valueOf(paramArticleSummary.uint64_time.get() * 1000L));
        localVideoInfo.rx = paramArticleSummary.uint64_time.get();
        if ((!paramArticleSummary.bytes_subscribe_id.has()) || (paramArticleSummary.bytes_subscribe_id.get() == null)) {
          break label1913;
        }
        localVideoInfo.hH = paramArticleSummary.bytes_subscribe_id.get().toStringUtf8();
        if ((!paramArticleSummary.bytes_subscribe_name.has()) || (paramArticleSummary.bytes_subscribe_name.get() == null)) {
          break label1948;
        }
        localVideoInfo.accountName = paramArticleSummary.bytes_subscribe_name.get().toStringUtf8();
        if ((!paramArticleSummary.bytes_article_content_url.has()) || (paramArticleSummary.bytes_article_content_url.get() == null)) {
          break label1983;
        }
        localVideoInfo.webUrl = paramArticleSummary.bytes_article_content_url.get().toStringUtf8();
        if ((!paramArticleSummary.bytes_aio_share_url.has()) || (paramArticleSummary.bytes_aio_share_url.get() == null)) {
          break label2018;
        }
        localVideoInfo.aioShareUrl = paramArticleSummary.bytes_aio_share_url.get().toStringUtf8();
        if ((!paramArticleSummary.bytes_qzone_share_url.has()) || (paramArticleSummary.bytes_qzone_share_url.get() == null)) {
          break label2053;
        }
        localVideoInfo.qzoneShareUrl = paramArticleSummary.bytes_qzone_share_url.get().toStringUtf8();
        if (!paramArticleSummary.uint32_strategy_id.has()) {
          break label2075;
        }
        localVideoInfo.strategyID = paramArticleSummary.uint32_strategy_id.get();
        if (!paramArticleSummary.uint64_algorithm_id.has()) {
          break label2097;
        }
        localVideoInfo.algorithmID = paramArticleSummary.uint64_algorithm_id.get();
        if ((!paramArticleSummary.bytes_recommend_reason.has()) || (paramArticleSummary.bytes_recommend_reason.get() == null)) {
          break label2132;
        }
        localVideoInfo.recommendReason = paramArticleSummary.bytes_recommend_reason.get().toStringUtf8();
        if (!paramArticleSummary.uint32_video_comment_count.has()) {
          break label2154;
        }
        localVideoInfo.commentCount = paramArticleSummary.uint32_video_comment_count.get();
        if (!paramArticleSummary.uint32_like_count.has()) {
          break label2176;
        }
        localVideoInfo.aHi = paramArticleSummary.uint32_like_count.get();
        if (!paramArticleSummary.uint32_biu_count.has()) {
          break label2198;
        }
        localVideoInfo.aHb = paramArticleSummary.uint32_biu_count.get();
        if (!paramArticleSummary.uint32_ads_guide_time.has()) {
          break label2220;
        }
        localVideoInfo.aHd = paramArticleSummary.uint32_ads_guide_time.get();
        if (!paramArticleSummary.uint32_ads_jump_type.has()) {
          break label2242;
        }
        localVideoInfo.adsJumpType = paramArticleSummary.uint32_ads_jump_type.get();
        if (!paramArticleSummary.uint32_video_source_type.has()) {
          break label2273;
        }
        if (paramArticleSummary.uint32_video_source_type.get() != 1) {
          break label3873;
        }
        boolean bool = true;
        for (;;)
        {
          localVideoInfo.adD = bool;
          if ((!paramArticleSummary.bytes_video_subscript_txt.has()) || (paramArticleSummary.bytes_video_subscript_txt.get() == null)) {
            break label2308;
          }
          localVideoInfo.WH = paramArticleSummary.bytes_video_subscript_txt.get().toStringUtf8();
          if ((!paramArticleSummary.bytes_video_subscript_color.has()) || (paramArticleSummary.bytes_video_subscript_color.get() == null)) {
            break label2343;
          }
          localVideoInfo.WI = paramArticleSummary.bytes_video_subscript_color.get().toStringUtf8();
          if (!paramArticleSummary.uint32_account_grade.has()) {
            break label2374;
          }
          if (paramArticleSummary.uint32_account_grade.get() != 1) {
            break label3879;
          }
          bool = true;
          localVideoInfo.isVerified = bool;
          if (!paramArticleSummary.uint32_myself_like_status.has()) {
            break label2405;
          }
          if (paramArticleSummary.uint32_myself_like_status.get() != 1) {
            break label3885;
          }
          bool = true;
          localVideoInfo.adM = bool;
          if (!paramArticleSummary.bytes_video_report_info.has()) {
            break label2428;
          }
          localVideoInfo.videoReportInfo = a(paramArticleSummary.bytes_video_report_info);
          if (!paramArticleSummary.uint64_article_id.has()) {
            break label2450;
          }
          localVideoInfo.rz = paramArticleSummary.uint64_article_id.get();
          if (!paramArticleSummary.uint32_trigger_sec.has()) {
            break label2472;
          }
          localVideoInfo.aHg = paramArticleSummary.uint32_trigger_sec.get();
          if ((!paramArticleSummary.msg_top_bar_info.has()) || (paramArticleSummary.msg_top_bar_info.get() == null)) {
            break label2692;
          }
          Object localObject3 = paramArticleSummary.msg_top_bar_info;
          localObject5 = new VideoInfo.TopBarInfo();
          ((VideoInfo.TopBarInfo)localObject5).a = new UrlJumpInfo();
          if (!((oidb_0x6cf.TopBarInfo)localObject3).uint32_topbar_id.has()) {
            break label3891;
          }
          i = ((oidb_0x6cf.TopBarInfo)localObject3).uint32_topbar_id.get();
          ((VideoInfo.TopBarInfo)localObject5).logoId = i;
          ((VideoInfo.TopBarInfo)localObject5).iconUrl = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_icon_url);
          ((VideoInfo.TopBarInfo)localObject5).title = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_title);
          ((VideoInfo.TopBarInfo)localObject5).WT = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_common_data);
          ((VideoInfo.TopBarInfo)localObject5).backgroundUrl = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_background_url);
          ((VideoInfo.TopBarInfo)localObject5).a.jumpUrl = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_jump_url);
          localObject7 = ((VideoInfo.TopBarInfo)localObject5).a;
          if (!((oidb_0x6cf.TopBarInfo)localObject3).uint32_jump_type.has()) {
            break label3896;
          }
          i = ((oidb_0x6cf.TopBarInfo)localObject3).uint32_jump_type.get();
          ((UrlJumpInfo)localObject7).jumpType = i;
          ((VideoInfo.TopBarInfo)localObject5).a.aiM = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_ios_jump_bundle);
          ((VideoInfo.TopBarInfo)localObject5).a.jumpSchema = a(((oidb_0x6cf.TopBarInfo)localObject3).bytes_jump_schema);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$TopBarInfo = ((VideoInfo.TopBarInfo)localObject5);
          if ((!paramArticleSummary.msg_download_bar_info.has()) || (paramArticleSummary.msg_download_bar_info.get() == null)) {
            break label2856;
          }
          localObject3 = paramArticleSummary.msg_download_bar_info;
          localObject5 = new VideoInfo.DownloadBarInfo();
          ((VideoInfo.DownloadBarInfo)localObject5).logoUrl = a(((oidb_0x6cf.DownloadBarInfo)localObject3).bytes_logo_url);
          if (!((oidb_0x6cf.DownloadBarInfo)localObject3).uint32_appear_time.has()) {
            break label3901;
          }
          i = ((oidb_0x6cf.DownloadBarInfo)localObject3).uint32_appear_time.get();
          ((VideoInfo.DownloadBarInfo)localObject5).appearTime = i;
          if (!((oidb_0x6cf.DownloadBarInfo)localObject3).uint32_button_bg_color.has()) {
            break label3906;
          }
          i = ((oidb_0x6cf.DownloadBarInfo)localObject3).uint32_button_bg_color.get();
          ((VideoInfo.DownloadBarInfo)localObject5).aHl = i;
          ((VideoInfo.DownloadBarInfo)localObject5).WQ = a(((oidb_0x6cf.DownloadBarInfo)localObject3).bytes_download_button_text);
          ((VideoInfo.DownloadBarInfo)localObject5).WR = a(((oidb_0x6cf.DownloadBarInfo)localObject3).bytes_open_button_text);
          ((VideoInfo.DownloadBarInfo)localObject5).WT = a(((oidb_0x6cf.DownloadBarInfo)localObject3).bytes_common_data);
          ((VideoInfo.DownloadBarInfo)localObject5).a = a(((oidb_0x6cf.DownloadBarInfo)localObject3).msg_url_jump_info);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$DownloadBarInfo = ((VideoInfo.DownloadBarInfo)localObject5);
          if ((!paramArticleSummary.json_video_list.has()) || (paramArticleSummary.json_video_list.get() == null)) {
            break label3245;
          }
          try
          {
            localVideoInfo.WB = paramArticleSummary.json_video_list.get().toStringUtf8();
            localObject3 = new JSONObject(paramArticleSummary.json_video_list.get().toStringUtf8()).getJSONArray("videos").optJSONObject(0);
            if (localObject3 == null) {
              break label3245;
            }
            localVideoInfo.vid = ((JSONObject)localObject3).optString("vid");
            if (!((JSONObject)localObject3).has("width")) {
              break label2962;
            }
            localVideoInfo.width = ((JSONObject)localObject3).getInt("width");
            if (!((JSONObject)localObject3).has("height")) {
              break label2986;
            }
            localVideoInfo.height = ((JSONObject)localObject3).getInt("height");
            if (!((JSONObject)localObject3).has("duration")) {
              break label3013;
            }
          }
          catch (JSONException localJSONException1)
          {
            try
            {
              localVideoInfo.duration = Integer.parseInt(((JSONObject)localObject3).optString("duration"));
              localVideoInfo.coverUrl = ((JSONObject)localObject3).optString("picture");
              if (!((JSONObject)localObject3).has("innerUniqueID")) {
                break label3050;
              }
              localVideoInfo.Wz = ((JSONObject)localObject3).optString("innerUniqueID");
              localVideoInfo.busiType = 1;
              if (!((JSONObject)localObject3).has("busiType")) {
                break label3080;
              }
              localVideoInfo.busiType = ((JSONObject)localObject3).getInt("busiType");
              localVideoInfo.thirdAction = ((JSONObject)localObject3).optString("thirdAction");
              localVideoInfo.WC = ((JSONObject)localObject3).optString("thirdIcon");
              localVideoInfo.thirdUinName = ((JSONObject)localObject3).optString("thirdUinName");
              if (TextUtils.isEmpty(((JSONObject)localObject3).optString("thirdName"))) {
                break label3146;
              }
              localVideoInfo.accountName = ((JSONObject)localObject3).optString("thirdName");
              if (TextUtils.isEmpty(((JSONObject)localObject3).optString("third_uin"))) {
                break label3173;
              }
              localVideoInfo.hH = ((JSONObject)localObject3).optString("third_uin");
              localObject3 = ((JSONObject)localObject3).optJSONArray("video_info");
              if (localObject3 == null) {
                break label3245;
              }
              i = 0;
              if (i >= ((JSONArray)localObject3).length()) {
                break label3245;
              }
              localObject5 = ((JSONArray)localObject3).optJSONObject(i);
              if (localObject5 == null) {
                break label3944;
              }
              j = ((JSONObject)localObject5).optInt("network_type");
              l = ((JSONObject)localObject5).optLong("file_size");
              if (j != 2) {
                break label3944;
              }
              localVideoInfo.ry = l;
              if ((!paramArticleSummary.uint32_is_ugc.has()) || (paramArticleSummary.uint32_is_ugc.get() != 1)) {
                break label3637;
              }
              localVideoInfo.adB = true;
              if ((!paramArticleSummary.msg_ugc_feeds_info.has()) || (paramArticleSummary.msg_ugc_feeds_info.get() == null)) {
                break label3637;
              }
              localObject3 = (oidb_0x6cf.UGCFeedsInfo)paramArticleSummary.msg_ugc_feeds_info.get();
              if ((!((oidb_0x6cf.UGCFeedsInfo)localObject3).ugc_feeds_info.has()) || (((oidb_0x6cf.UGCFeedsInfo)localObject3).ugc_feeds_info.get() == null)) {
                break label3387;
              }
              localObject5 = (oidb_0x6cf.FeedsIdInfo)((oidb_0x6cf.UGCFeedsInfo)localObject3).ugc_feeds_info.get();
              if (!((oidb_0x6cf.FeedsIdInfo)localObject5).uint64_feeds_id.has()) {
                break label3363;
              }
              localVideoInfo.rA = ((oidb_0x6cf.FeedsIdInfo)localObject5).uint64_feeds_id.get();
              if (!((oidb_0x6cf.FeedsIdInfo)localObject5).uint32_feeds_type.has()) {
                break label3387;
              }
              localVideoInfo.feedType = ((oidb_0x6cf.FeedsIdInfo)localObject5).uint32_feeds_type.get();
              if (!((oidb_0x6cf.UGCFeedsInfo)localObject3).uint32_follow_status.has()) {
                break label3420;
              }
              if (((oidb_0x6cf.UGCFeedsInfo)localObject3).uint32_follow_status.get() != 2) {
                break label3951;
              }
              bool = true;
              localVideoInfo.isFollowed = bool;
              if (!((oidb_0x6cf.UGCFeedsInfo)localObject3).uint64_cuin.has()) {
                break label3447;
              }
              localVideoInfo.hH = String.valueOf(((oidb_0x6cf.UGCFeedsInfo)localObject3).uint64_cuin.get());
              if ((!((oidb_0x6cf.UGCFeedsInfo)localObject3).msg_ugc_video_info_list.has()) || (((oidb_0x6cf.UGCFeedsInfo)localObject3).msg_ugc_video_info_list.get() == null)) {
                break label3637;
              }
              localObject3 = (oidb_0x6cf.UGCVideoInfo)((oidb_0x6cf.UGCFeedsInfo)localObject3).msg_ugc_video_info_list.get();
              localVideoInfo.videoUrl = a(((oidb_0x6cf.UGCVideoInfo)localObject3).bytes_video_url);
              localVideoInfo.coverUrl = a(((oidb_0x6cf.UGCVideoInfo)localObject3).bytes_pic_url);
              localVideoInfo.title = a(((oidb_0x6cf.UGCVideoInfo)localObject3).bytes_title);
              localVideoInfo.duration = ((int)(((oidb_0x6cf.UGCVideoInfo)localObject3).uint64_duration.get() / 1000L));
              localVideoInfo.width = ((oidb_0x6cf.UGCVideoInfo)localObject3).uint32_video_width.get();
              localVideoInfo.height = ((oidb_0x6cf.UGCVideoInfo)localObject3).uint32_video_height.get();
              localVideoInfo.Wz = a(((oidb_0x6cf.UGCVideoInfo)localObject3).bytes_uniq_id);
              localVideoInfo.rx = ((oidb_0x6cf.UGCVideoInfo)localObject3).uint32_create_time.get();
              localVideoInfo.webUrl = a(((oidb_0x6cf.UGCVideoInfo)localObject3).bytes_share_url);
              localVideoInfo.busiType = ((oidb_0x6cf.UGCVideoInfo)localObject3).uint32_busi_type.get();
              localVideoInfo.vid = a(((oidb_0x6cf.UGCVideoInfo)localObject3).bytes_vid);
              if ((!paramArticleSummary.rpt_label_list.has()) || (paramArticleSummary.rpt_label_list.get() == null)) {
                break label3975;
              }
              localObject5 = paramArticleSummary.rpt_label_list.get();
              if (((List)localObject5).size() <= 0) {
                break label3688;
              }
              localVideoInfo.jQ = new ArrayList();
              i = 0;
              for (;;)
              {
                if (i >= ((List)localObject5).size()) {
                  break label3975;
                }
                localObject7 = (oidb_0x6cf.ChannelInfo)((List)localObject5).get(i);
                VideoInfo.ChannelInfo localChannelInfo = new VideoInfo.ChannelInfo();
                localChannelInfo.channelID = ((oidb_0x6cf.ChannelInfo)localObject7).uint32_channel_id.get();
                localChannelInfo.channelType = ((oidb_0x6cf.ChannelInfo)localObject7).uint32_channel_type.get();
                if (((oidb_0x6cf.ChannelInfo)localObject7).bytes_channel_name.get() == null) {
                  break;
                }
                localObject3 = ((oidb_0x6cf.ChannelInfo)localObject7).bytes_channel_name.get().toStringUtf8();
                localChannelInfo.channelName = ((String)localObject3);
                if (((oidb_0x6cf.ChannelInfo)localObject7).bytes_channel_display_name.get() == null) {
                  break label3963;
                }
                localObject3 = ((oidb_0x6cf.ChannelInfo)localObject7).bytes_channel_display_name.get().toStringUtf8();
                localChannelInfo.WL = ((String)localObject3);
                if (((oidb_0x6cf.ChannelInfo)localObject7).bytes_channel_url.get() == null) {
                  break label3969;
                }
                localObject3 = ((oidb_0x6cf.ChannelInfo)localObject7).bytes_channel_url.get().toStringUtf8();
                localChannelInfo.WM = ((String)localObject3);
                localChannelInfo.aHk = ((oidb_0x6cf.ChannelInfo)localObject7).uint32_is_topic.get();
                localVideoInfo.jQ.add(localChannelInfo);
                i += 1;
              }
              bool = false;
              continue;
              bool = false;
              break label2367;
              bool = false;
              break label2398;
              i = -1;
              break label2539;
              i = 0;
              break label2645;
              i = 0;
              break label2761;
              i = 0;
              break label2787;
              localJSONException1 = localJSONException1;
              if (!QLog.isColorLevel()) {
                break label3928;
              }
              QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, jsonVideoList 解析出错");
              localObject4 = null;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              long l;
              for (;;)
              {
                localNumberFormatException.printStackTrace();
                continue;
                i += 1;
                continue;
                bool = false;
                continue;
                localObject4 = null;
                continue;
                localObject4 = null;
                continue;
                localObject4 = null;
              }
              if ((!paramArticleSummary.msg_feeds_info.has()) || (((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).feeds_type.get() != 1)) {
                break label4432;
              }
              localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo = new VideoAdInfo(this.rG, (oidb_0x6cf.PosAdInfo)((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).msg_pos_ad_info.get());
              if (!((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).rpt_msg_neg_feedback.has()) {
                break label4083;
              }
              localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo.bG(((oidb_0x6cf.FeedsInfo)paramArticleSummary.msg_feeds_info.get()).rpt_msg_neg_feedback.get());
              if (!QLog.isColorLevel()) {
                break label4122;
              }
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList recv adInfo=" + localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo.toString());
              localVideoInfo.isAD = true;
              i = localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo.mAdMaterialId;
              if (i != 65) {
                break label4199;
              }
              localVideoInfo.qU = 2;
              if (a(localVideoInfo)) {
                break label4324;
              }
              if (!QLog.isColorLevel()) {
                break label4197;
              }
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isInvalidImageAd traceID=" + localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo.We);
              return null;
              if ((i != 185) && (i != 350) && (i != 450) && (i != 1122)) {
                break label4283;
              }
              localVideoInfo.qU = 1;
              if (a(localVideoInfo)) {
                break label4324;
              }
              if (!QLog.isColorLevel()) {
                break label4281;
              }
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isInvalidVideoAd traceID=" + localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo.We);
              return null;
              if (!QLog.isColorLevel()) {
                break label4322;
              }
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList isUnknownTypeAd traceID=" + localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo.We);
              return null;
              Object localObject4 = jzk.a(localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo);
              if (!knc.a(null, localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo)) {
                break label4424;
              }
              Object localObject6 = new JSONObject();
              try
              {
                ((JSONObject)localObject6).put("svrresp_result", 0);
                ((JSONObject)localObject6).put("svrresp_count", 1);
                jzk.a(new kku.a().a(BaseApplication.getContext()).a(jzk.aET).b(jzk.aFE).a((AdvertisementInfo)localObject4).a(localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo).b((JSONObject)localObject6).a());
                knd.c(localVideoInfo.jdField_b_of_type_ComTencentBizPubaccountVideoAdInfo);
                if ((!paramArticleSummary.bytes_recommend_barrage_text_list.has()) || (paramArticleSummary.bytes_recommend_barrage_text_list.get() == null)) {
                  break label4515;
                }
                localObject4 = paramArticleSummary.bytes_recommend_barrage_text_list.get().iterator();
                while (((Iterator)localObject4).hasNext())
                {
                  localObject6 = (ByteStringMicro)((Iterator)localObject4).next();
                  localVideoInfo.jS.add(((ByteStringMicro)localObject6).toStringUtf8());
                }
              }
              catch (JSONException localJSONException2)
              {
                for (;;)
                {
                  localJSONException2.printStackTrace();
                }
                localVideoInfo.WE = a(paramArticleSummary.bytes_video_logo_url);
                if (!paramArticleSummary.msg_account_v_info.has()) {
                  break label4554;
                }
                localVideoInfo.vIconUrl = a(paramArticleSummary.msg_account_v_info.bytes_v_icon_url);
                if (!paramArticleSummary.msg_like_download_bar_info.has()) {
                  break label4802;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar = new VideoInfo.LikeActionDownloadBar();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.Xx = a(paramArticleSummary.msg_like_download_bar_info.bytes_bar_text);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.logoUrl = a(paramArticleSummary.msg_like_download_bar_info.bytes_icon_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.WT = a(paramArticleSummary.msg_like_download_bar_info.bytes_common_data);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.c = new UrlJumpInfo();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.c.jumpType = ((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).uint32_jump_type.get();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.c.aiM = a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_bundle);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.c.jumpSchema = a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_schema);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.c.jumpUrl = a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_jump_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$LikeActionDownloadBar.c.aiN = a(((oidb_0x6cf.UrlJumpInfo)paramArticleSummary.msg_like_download_bar_info.msg_url_jump_info.get()).bytes_clipboard_info);
                if (!paramArticleSummary.msg_soft_ad_download_bar_info.has()) {
                  break label4937;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo = new VideoInfo.SoftAdDownloadBarInfo();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.title = a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_title);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.subTitle = a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_sub_title);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.smallIconUrl = a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_small_icon_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.Xy = a(paramArticleSummary.msg_soft_ad_download_bar_info.bytes_big_icon_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.aHt = paramArticleSummary.msg_soft_ad_download_bar_info.uint32_change_bigger_position.get();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$SoftAdDownloadBarInfo.c = a(paramArticleSummary.msg_soft_ad_download_bar_info.msg_url_jump_info);
                if ((!localVideoInfo.isAD) || (localVideoInfo.qU != 2)) {
                  break label4956;
                }
                return null;
                if (!paramArticleSummary.msg_ecommerce_entrance_info.has()) {
                  break label5644;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo = new VideoInfo.ECommerceEntranceInfo();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.title = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_title);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.subTitle = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_subtitle);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.WU = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_thumbnail_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.WV = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_link_icon_url);
                if (!paramArticleSummary.msg_ecommerce_entrance_info.uint32_jump_type.has()) {
                  break label5085;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jumpType = paramArticleSummary.msg_ecommerce_entrance_info.uint32_jump_type.get();
                if (!paramArticleSummary.msg_ecommerce_entrance_info.uint32_ecommerce_id.has()) {
                  break label5116;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.videoSource = paramArticleSummary.msg_ecommerce_entrance_info.uint32_ecommerce_id.get();
                if (!paramArticleSummary.msg_ecommerce_entrance_info.uint32_display_count_ver.has()) {
                  break label5147;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.aHn = paramArticleSummary.msg_ecommerce_entrance_info.uint32_display_count_ver.get();
                if (!paramArticleSummary.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.has()) {
                  break label5178;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.aHp = paramArticleSummary.msg_ecommerce_entrance_info.uint32_one_day_max_display_count.get();
                if (!paramArticleSummary.msg_ecommerce_entrance_info.uint32_session_max_display_count.has()) {
                  break label5209;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.aHo = paramArticleSummary.msg_ecommerce_entrance_info.uint32_session_max_display_count.get();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.jumpUrl = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_jump_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.WT = a(paramArticleSummary.msg_ecommerce_entrance_info.bytes_common_data);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.aHm = paramArticleSummary.msg_ecommerce_entrance_info.video_play_length.get();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.style = paramArticleSummary.msg_ecommerce_entrance_info.uint32_style.get();
                if (!paramArticleSummary.msg_ecommerce_entrance_info.appInfo.has()) {
                  break label5605;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.b = new UrlJumpInfo();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.b.jumpType = ((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).uint32_jump_type.get();
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.b.aiM = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_bundle);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.b.jumpSchema = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_schema);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.b.jumpUrl = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_jump_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.b.aiN = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_clipboard_info);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.WR = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_open_wording);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.WQ = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_download_wording);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.subTitle = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_app_desc);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.WU = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_icon_url);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.title = a(((oidb_0x6cf.AppAdInfo)paramArticleSummary.msg_ecommerce_entrance_info.appInfo.get()).bytes_name);
                if (!QLog.isColorLevel()) {
                  break label5644;
                }
                QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "commerceEntranceInfo: " + localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.toString());
                if ((!paramRspBody.msg_ecommerce_entrance_config.has()) || (localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo == null) || (!paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.has())) {
                  break label5693;
                }
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$ECommerceEntranceInfo.playTime = paramRspBody.msg_ecommerce_entrance_config.uint32_show_after_play_time.get();
                localVideoInfo.WJ = a(paramArticleSummary.bytes_avatar_jump_url);
                if (!paramArticleSummary.uint64_recommend_seq.has()) {
                  break label6073;
                }
                l = paramArticleSummary.uint64_recommend_seq.get();
                localVideoInfo.recommendSeq = l;
                if (!paramArticleSummary.uint32_is_first_page_use_gif.has()) {
                  break label5763;
                }
                if (paramArticleSummary.uint32_is_first_page_use_gif.get() != 1) {
                  break label6079;
                }
                bool = true;
                localVideoInfo.isUseGif = bool;
                localVideoInfo.Gx = a(paramArticleSummary.bytes_first_page_gif_url);
                if (!paramArticleSummary.uint32_is_no_show_cover.has()) {
                  break label5806;
                }
                if (paramArticleSummary.uint32_is_no_show_cover.get() != 0) {
                  break label6085;
                }
                bool = true;
                localVideoInfo.adF = bool;
                muj.x(localVideoInfo);
                jzq.a(paramArticleSummary, localVideoInfo);
                if (!paramArticleSummary.video_column_info.has()) {
                  break label6026;
                }
                paramRspBody = new VideoColumnInfo();
                paramRspBody.aHc = paramArticleSummary.video_column_info.uint32_column_id.get();
                paramRspBody.columnName = a(paramArticleSummary.video_column_info.bytes_column_name);
                paramRspBody.aiO = a(paramArticleSummary.video_column_info.bytes_column_icon_url);
                paramRspBody.subscribeCount = paramArticleSummary.video_column_info.uint32_subscribe_count.get();
                if (paramArticleSummary.video_column_info.uint32_is_subscribed.get() != 1) {
                  break label6091;
                }
                bool = true;
                paramRspBody.amw = bool;
                paramRspBody.appName = a(paramArticleSummary.video_column_info.bytes_app_name);
                paramRspBody.appIconUrl = a(paramArticleSummary.video_column_info.bytes_app_icon_url);
                paramRspBody.j = a(paramArticleSummary.video_column_info.subscribe_jump_info);
                paramRspBody.k = a(paramArticleSummary.video_column_info.app_jump_info);
                paramRspBody.h = a(paramArticleSummary.video_column_info.default_jump_info);
                paramRspBody.aTm = paramArticleSummary.video_column_info.uint32_style.get();
                paramRspBody.aiR = a(paramArticleSummary.video_column_info.bytes_from_txt);
                localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo = paramRspBody;
                if ((!paramArticleSummary.uint32_forbid_reprint_flag.has()) || (paramArticleSummary.uint32_forbid_reprint_flag.get() != 1)) {
                  break label6097;
                }
                for (bool = true;; bool = false)
                {
                  localVideoInfo.isForbidReprint = bool;
                  localVideoInfo.wechatShareUrl = a(paramArticleSummary.bytes_wechat_share_url);
                  return localVideoInfo;
                  l = 0L;
                  break;
                  bool = false;
                  break label5756;
                  bool = false;
                  break label5799;
                  bool = false;
                  break label5910;
                }
              }
            }
          }
        }
      }
      if ((paramArticleSummary.bytes_article_summary.has()) && (paramArticleSummary.bytes_article_summary.get() != null)) {
        localVideoInfo.summary = paramArticleSummary.bytes_article_summary.get().toStringUtf8();
      }
      if ((paramArticleSummary.rpt_dislike_list.has()) && (paramArticleSummary.rpt_dislike_list.get() != null))
      {
        localObject1 = paramArticleSummary.rpt_dislike_list.get();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          j = ((List)localObject1).size();
          localVideoInfo.jR = new ArrayList();
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label1818;
            }
            localObject5 = new DislikeInfo();
            ((DislikeInfo)localObject5).a((oidb_0x6cf.DisLikeInfo)((List)localObject1).get(i));
            if (!TextUtils.isEmpty(((DislikeInfo)localObject5).agQ)) {
              break;
            }
            i += 1;
          }
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localObject2 = null;
        continue;
        if ((k == 1) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(str6)) && (!TextUtils.isEmpty(str8)) && (!TextUtils.isEmpty(str9)) && (!TextUtils.isEmpty(str10)) && (!TextUtils.isEmpty(str11)) && (!TextUtils.isEmpty(str12)) && (!TextUtils.isEmpty(str13)))
        {
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a = new VideoInfo.a();
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.Xz = str1;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XA = str2;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XB = str3;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XC = str4;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XD = str5;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XE = str6;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XF = str7;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XG = str8;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XH = str9;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XI = str10;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XJ = str11;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XK = str12;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XL = str13;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.aHu = i;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.aHv = j;
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.XM = ((String)localObject7);
          localVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$a.aHw = k;
        }
      }
    }
  }
  
  public static int getRecommendFlag()
  {
    int i = 1;
    if (anwa.aze()) {
      i = 8193;
    }
    return i;
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    Bundle localBundle;
    StringBuilder localStringBuilder;
    List localList;
    Object localObject2;
    Object localObject1;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      localBundle = new Bundle();
      localStringBuilder = null;
      localList = null;
      localObject2 = null;
      localObject1 = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList onReceive :" + bool1);
      }
      bool3 = ((Boolean)paramToServiceMsg.getAttribute("VALUE_REQUEST_GAME_DATA", Boolean.valueOf(false))).booleanValue();
      if (!bool1) {
        break label1229;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        localObject1 = localObject2;
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        localObject1 = localObject2;
        if (!paramFromServiceMsg.uint32_result.has()) {
          continue;
        }
        localObject1 = localObject2;
        if (paramFromServiceMsg.uint32_result.get() != 83) {
          continue;
        }
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = localObject2;
          QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 热门长视频黑名单");
        }
        localObject1 = localObject2;
        localBundle.putBoolean("VALUE_USER_IN_BLACK", true);
        localObject1 = localObject2;
        paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        localObject1 = localObject2;
        localRspBody = new oidb_0x6cf.RspBody();
        localObject1 = localObject2;
        localRspBody.mergeFrom(paramFromServiceMsg);
        localObject1 = localObject2;
        if (localRspBody.uint64_pos_ad_time.has())
        {
          localObject1 = localObject2;
          this.rG = localRspBody.uint64_pos_ad_time.get();
        }
        localObject1 = localObject2;
        if (localRspBody.bytes_cookie.has())
        {
          localObject1 = localObject2;
          if (localRspBody.bytes_cookie.get() != null)
          {
            localObject1 = localObject2;
            localBundle.putString("VALUE_COOKIE", localRspBody.bytes_cookie.get().toStringUtf8());
          }
        }
        localObject1 = localObject2;
        if (!localRspBody.bytes_ads_context.has()) {
          continue;
        }
        localObject1 = localObject2;
        paramObject = localRspBody.bytes_ads_context.get().toStringUtf8();
        i = 1;
        localObject1 = localObject2;
        if (this.q == null)
        {
          localObject1 = localObject2;
          this.q = new SimpleDateFormat("yyyy-MM-dd");
        }
        if (bool3) {
          continue;
        }
        localObject1 = localObject2;
        if (!localRspBody.rpt_article_list.has()) {
          continue;
        }
        localObject1 = localObject2;
        if (localRspBody.rpt_article_list.get() == null) {
          continue;
        }
        localObject1 = localObject2;
        localList = localRspBody.rpt_article_list.get();
        paramFromServiceMsg = localStringBuilder;
        if (localList == null) {
          continue;
        }
        paramFromServiceMsg = localStringBuilder;
        localObject1 = localObject2;
        if (localList.isEmpty()) {
          continue;
        }
        localObject1 = localObject2;
        paramFromServiceMsg = new ArrayList(localList.size());
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList, 解析推荐视频列表: article size=" + localList.size());
          }
          localObject1 = localList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          localObject2 = (oidb_0x6cf.ArticleSummary)((Iterator)localObject1).next();
          try
          {
            localObject2 = b((oidb_0x6cf.ArticleSummary)localObject2, localRspBody);
            if (localObject2 == null) {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList，解析推荐视频列表：article = " + ((VideoInfo)localObject2).toLogString());
            }
            paramFromServiceMsg.add(localObject2);
          }
          catch (Exception localException) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, ERROR e=" + localException.getMessage());
          continue;
          paramFromServiceMsg = (FromServiceMsg)localObject1;
        }
        catch (Exception paramObject)
        {
          localObject1 = paramFromServiceMsg;
        }
      }
      catch (Exception paramObject)
      {
        oidb_0x6cf.RspBody localRspBody;
        int i;
        VideoInfo localVideoInfo;
        label1229:
        continue;
        continue;
        continue;
        paramObject = "null";
        continue;
        boolean bool2 = false;
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, ERROR e=" + paramObject.getMessage());
        paramFromServiceMsg = (FromServiceMsg)localObject1;
      }
      if (!bool3)
      {
        paramObject = paramToServiceMsg.getAttribute("is_from_first_recommend_video");
        if ((paramObject != null) && ((paramObject instanceof Boolean))) {
          localBundle.putBoolean("is_from_first_recommend_video", ((Boolean)paramObject).booleanValue());
        }
        localBundle.putString("VALUE_REQUEST_VIDEO_ARTICLE_ID", (String)paramToServiceMsg.getAttribute("VALUE_REQUEST_VIDEO_ARTICLE_ID"));
        jzq.c(localBundle, paramFromServiceMsg);
        localBundle.putBoolean("VALUE_REQUEST_GAME_DATA", false);
        paramToServiceMsg = paramToServiceMsg.getAttribute("VALUE_OBSERVER_TAG");
        if ((paramToServiceMsg instanceof Integer)) {
          localBundle.putInt("VALUE_OBSERVER_TAG", ((Integer)paramToServiceMsg).intValue());
        }
        super.notifyUI(0, bool1, localBundle);
        return;
        bool1 = false;
        break;
        localObject1 = localException;
        localBundle.putBoolean("VALUE_USER_IN_BLACK", false);
        continue;
        if (paramFromServiceMsg != null)
        {
          localObject1 = paramFromServiceMsg;
          if (!paramFromServiceMsg.isEmpty()) {}
        }
        else
        {
          localObject1 = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            localObject1 = paramFromServiceMsg;
            QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list 中合法数据为空");
          }
        }
        localObject1 = paramFromServiceMsg;
        localBundle.putParcelableArrayList("VIDEO_RECOMMEND_LIST", paramFromServiceMsg);
        if (i != 0)
        {
          localObject1 = paramFromServiceMsg;
          jzk.lA(paramObject);
        }
        localObject1 = paramFromServiceMsg;
        if (localRspBody.req_article_summary.has())
        {
          localObject1 = paramFromServiceMsg;
          if (localRspBody.req_article_summary.get() != null)
          {
            localObject1 = paramFromServiceMsg;
            localVideoInfo = a((oidb_0x6cf.ArticleSummary)localRspBody.req_article_summary.get(), localRspBody);
            localObject1 = paramFromServiceMsg;
            if (QLog.isColorLevel())
            {
              localObject1 = paramFromServiceMsg;
              localStringBuilder = new StringBuilder().append("handleGetRecommendList，解析第一个视频的详细信息：firstVideoInfo = ");
              if (localVideoInfo == null) {
                continue;
              }
              localObject1 = paramFromServiceMsg;
              paramObject = localVideoInfo.toLogString();
              localObject1 = paramFromServiceMsg;
              QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, paramObject);
            }
            localObject1 = paramFromServiceMsg;
            localBundle.putParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO", localVideoInfo);
            localObject1 = paramFromServiceMsg;
            if (localRspBody.msg_ecommerce_entrance_config.has())
            {
              localObject1 = paramFromServiceMsg;
              if (localRspBody.msg_ecommerce_entrance_config.get() != null)
              {
                localObject1 = paramFromServiceMsg;
                localBundle.putParcelable("VALUE_ECOMMERCE_ENTRANCE_INFO", a((oidb_0x6cf.InterruptedWeishiAd)localRspBody.msg_ecommerce_entrance_config.get(), localRspBody));
              }
            }
            localObject1 = paramFromServiceMsg;
            if (localRspBody.uint32_is_end.has())
            {
              localObject1 = paramFromServiceMsg;
              if (localRspBody.uint32_is_end.get() != 0) {
                continue;
              }
              bool2 = true;
              localObject1 = paramFromServiceMsg;
              localBundle.putBoolean("VALUE_HAS_MORE_DATA", bool2);
            }
            localObject1 = paramFromServiceMsg;
            if (!localRspBody.msg_entrance_download_info.has()) {
              continue;
            }
            localObject1 = paramFromServiceMsg;
            if (localRspBody.msg_entrance_download_info.get() == null) {
              continue;
            }
            localObject1 = paramFromServiceMsg;
            localBundle.putParcelable("value_entrance_download_info", a((oidb_0x6cf.EntranceDownloadInfo)localRspBody.msg_entrance_download_info.get()));
            continue;
            paramFromServiceMsg = localList;
            localObject1 = localVideoInfo;
            if (!QLog.isColorLevel()) {
              continue;
            }
            localObject1 = localVideoInfo;
            QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list null");
            paramFromServiceMsg = localList;
            continue;
          }
        }
        localObject1 = paramFromServiceMsg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = paramFromServiceMsg;
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "handleGetRecommendList: 返回的req_article_summary null");
        continue;
        localObject1 = localVideoInfo;
        jzq.a(localRspBody, localBundle, this.rG);
        paramFromServiceMsg = null;
        continue;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "getRecommendList, 返回的rpt_article_list null 或者直接出错了");
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        continue;
      }
      localBundle.putBoolean("VALUE_REQUEST_GAME_DATA", true);
      continue;
      continue;
      i = 0;
      paramObject = null;
    }
  }
  
  private int nc()
  {
    switch (aqiw.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext()))
    {
    case 2: 
    default: 
      return 2;
    case 1: 
      return 0;
    }
    return 1;
  }
  
  public VideoInfo.EntranceDownloadInfo a(oidb_0x6cf.EntranceDownloadInfo paramEntranceDownloadInfo)
  {
    boolean bool = false;
    if (paramEntranceDownloadInfo == null) {
      return null;
    }
    VideoInfo.EntranceDownloadInfo localEntranceDownloadInfo = new VideoInfo.EntranceDownloadInfo();
    localEntranceDownloadInfo.iconUrl = a(paramEntranceDownloadInfo.bytes_icon_url);
    localEntranceDownloadInfo.smallIconUrl = a(paramEntranceDownloadInfo.bytes_small_icon_url);
    if (paramEntranceDownloadInfo.uint32_is_use_gif.has()) {}
    for (int i = paramEntranceDownloadInfo.uint32_is_use_gif.get();; i = 0)
    {
      if (i > 0) {
        bool = true;
      }
      localEntranceDownloadInfo.isUseGif = bool;
      localEntranceDownloadInfo.WT = a(paramEntranceDownloadInfo.bytes_common_data);
      localEntranceDownloadInfo.a = a(paramEntranceDownloadInfo.msg_url_jump_info);
      return localEntranceDownloadInfo;
    }
  }
  
  public UrlJumpInfo a(oidb_0x6cf.UrlJumpInfo paramUrlJumpInfo)
  {
    if ((paramUrlJumpInfo != null) && (paramUrlJumpInfo.has()) && (paramUrlJumpInfo.get() != null))
    {
      UrlJumpInfo localUrlJumpInfo = new UrlJumpInfo();
      if (paramUrlJumpInfo.uint32_jump_type.has()) {}
      for (int i = paramUrlJumpInfo.uint32_jump_type.get();; i = 0)
      {
        localUrlJumpInfo.jumpType = i;
        localUrlJumpInfo.jumpSchema = a(paramUrlJumpInfo.bytes_jump_schema);
        localUrlJumpInfo.aiM = a(paramUrlJumpInfo.bytes_jump_bundle);
        localUrlJumpInfo.jumpUrl = a(paramUrlJumpInfo.bytes_jump_url);
        localUrlJumpInfo.aiN = a(paramUrlJumpInfo.bytes_clipboard_info);
        localUrlJumpInfo.WT = a(paramUrlJumpInfo.bytes_common_data);
        return localUrlJumpInfo;
      }
    }
    return null;
  }
  
  public void a(kcs paramkcs, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, int paramInt4, int paramInt5, ArrayList<VideoInfo> paramArrayList2)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    ThreadManager.post(new VideoPlayRecommendHandler.3(this, paramkcs, paramLong1, paramVideoInfo, paramInt1, paramArrayList1, paramString1, paramLong2, paramBoolean, paramInt2, paramString2, paramString3, paramWeishiRedDotInfo, paramInt3, paramString4, paramArrayOfByte, paramInt4, paramInt5, paramArrayList2), 5, null, true);
  }
  
  public void a(kcs paramkcs, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, int paramInt4, ArrayList<VideoInfo> paramArrayList2)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    ThreadManager.post(new VideoPlayRecommendHandler.1(this, paramkcs, paramLong1, paramVideoInfo, paramInt1, paramArrayList1, paramString1, paramLong2, paramBoolean, paramInt2, paramString2, paramString3, paramWeishiRedDotInfo, paramInt3, paramString4, paramArrayOfByte, paramInt4, paramArrayList2), 5, null, true);
  }
  
  public void a(kcs paramkcs, long paramLong1, VideoInfo paramVideoInfo, int paramInt1, ArrayList<VideoInfo> paramArrayList1, String paramString1, long paramLong2, boolean paramBoolean, int paramInt2, String paramString2, String paramString3, WeishiRedDotInfo paramWeishiRedDotInfo, int paramInt3, String paramString4, byte[] paramArrayOfByte, ArrayList<VideoInfo.AdTagInfo> paramArrayList, int paramInt4, int paramInt5, int paramInt6, ArrayList<VideoInfo> paramArrayList2)
  {
    if (paramVideoInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 4, "getRecommendList()  videoInfo == null, RETURN");
      }
      return;
    }
    ThreadManager.post(new VideoPlayRecommendHandler.2(this, paramArrayList, paramkcs, paramLong1, paramVideoInfo, paramInt1, paramArrayList1, paramString1, paramLong2, paramBoolean, paramInt2, paramString2, paramString3, paramWeishiRedDotInfo, paramInt3, paramString4, paramArrayOfByte, paramInt4, paramInt5, paramInt6, paramArrayList2), 5, null, true);
  }
  
  public void a(kcs paramkcs, long paramLong, String paramString, int paramInt, VideoInfo paramVideoInfo)
  {
    ThreadManager.post(new VideoPlayRecommendHandler.4(this, paramLong, paramInt, paramString, paramkcs, paramVideoInfo), 5, null, true);
  }
  
  public void a(kcs paramkcs, String paramString, int paramInt, boolean paramBoolean)
  {
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    localReqBody.uint32_req_source.set(16);
    if (!TextUtils.isEmpty(paramString)) {
      localReqBody.bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    localReqBody.uint32_req_sub_source.set(paramInt);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localReqBody.uint32_has_cache_pre_video.set(paramInt);
      localReqBody.uint32_req_sim_type.set(awit.Qg());
      if (muj.Eu())
      {
        int i = mru.a().pH();
        localReqBody.uint32_entrance_one_day_display_count.set(i);
      }
      paramString = lup.makeOIDBPkg("OidbSvc.0x6cf", 1743, 1, localReqBody.toByteArray());
      paramString.addAttribute("is_from_first_recommend_video", Boolean.valueOf(true));
      paramString.addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(paramkcs.hashCode()));
      sendPbReq(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayRecommendHandler", 2, "has cache pre video: " + paramInt);
      }
      return;
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return kcs.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    m(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void ox(int paramInt)
  {
    this.aHx = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kcr
 * JD-Core Version:    0.7.0.1
 */