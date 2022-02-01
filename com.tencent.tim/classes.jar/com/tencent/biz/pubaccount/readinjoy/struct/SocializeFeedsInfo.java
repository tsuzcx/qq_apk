package com.tencent.biz.pubaccount.readinjoy.struct;

import anbk;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import aofk;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kgj;
import mgp;
import mib;
import mic;
import mid;
import mih;
import mih.b;
import nqj;
import nql;
import nqp;
import tencent.im.oidb.articlesummary.articlesummary.AnswerDetail;
import tencent.im.oidb.articlesummary.articlesummary.ArticleBasicInfo;
import tencent.im.oidb.articlesummary.articlesummary.BiuMultiLevel;
import tencent.im.oidb.articlesummary.articlesummary.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.articlesummary.BuluoInfo;
import tencent.im.oidb.articlesummary.articlesummary.ColumnTopicInfo;
import tencent.im.oidb.articlesummary.articlesummary.GalleryPGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.GameLiveInfo;
import tencent.im.oidb.articlesummary.articlesummary.JumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.LongContentInfo;
import tencent.im.oidb.articlesummary.articlesummary.OutsideLinkInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.PGCVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsExtInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfoUser;
import tencent.im.oidb.articlesummary.articlesummary.TopicEntranceInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCPicInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCVideoInfo;
import tencent.im.oidb.articlesummary.articlesummary.UGCVoiceInfo;
import tencent.im.oidb.articlesummary.articlesummary.WendaInfo;
import tencent.im.oidb.articlesummary.feeds_info.AccountProfile;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.feeds_info.BuluoInfo;
import tencent.im.oidb.articlesummary.feeds_info.IconWordingInfo;
import tencent.im.oidb.articlesummary.feeds_info.JumpInfo;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;
import tencent.im.oidb.articlesummary.feeds_info.NowLiveInfo;
import tencent.im.oidb.articlesummary.feeds_info.ShareWebPageInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCVoiceInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleInfo;
import tencent.im.oidb.articlesummary.feeds_info.VisibleShowInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfoUser;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendInfo;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.MedalInfo;
import tencent.im.oidb.nowlive.nowlive.AnchorInfo;
import tencent.im.oidb.nowlive.nowlive.LiveInfo;
import tencent.im.oidb.nowlive.nowlive.MixInfo;
import tencent.im.oidb.nowlive.nowlive.VideoInfo;

public class SocializeFeedsInfo
  implements Cloneable
{
  public c a;
  public d a;
  public e a;
  public g a;
  public h a;
  public i a;
  public j a;
  public k a;
  public m a;
  public p a;
  public q a;
  public r a;
  public u a;
  public articlesummary.ColumnTopicInfo a;
  public articlesummary.TopicEntranceInfo a;
  public int aRW;
  public int aSG;
  public int aSH;
  public int aSI;
  public int aSJ;
  public int aSK;
  public int aSL;
  public int aSM;
  public int aSN;
  public String ahL;
  public String ahM;
  public String ahN;
  public String ahO;
  public String ahP = "";
  public String ahQ;
  public String ahR;
  public boolean amL;
  public kgj b;
  public byte[] br;
  public AdvertisementInfo g;
  public List<e> iS = new ArrayList();
  public int mCommentCount;
  public long mFeedId;
  public int mFollowStatus;
  public int mLikeCount;
  public mih mTopicRecommendFeedsInfo;
  public long rX;
  
  public SocializeFeedsInfo()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e = new e();
  }
  
  public static int a(PBEnumField paramPBEnumField)
  {
    if (paramPBEnumField.has()) {
      return paramPBEnumField.get();
    }
    return 0;
  }
  
  public static int a(PBUInt32Field paramPBUInt32Field)
  {
    if (paramPBUInt32Field.has()) {
      return paramPBUInt32Field.get();
    }
    return 0;
  }
  
  public static long a(PBUInt64Field paramPBUInt64Field)
  {
    if (paramPBUInt64Field.has()) {
      return paramPBUInt64Field.get();
    }
    return 0L;
  }
  
  public static SpannableStringBuilder a(ArticleInfo paramArticleInfo, String paramString, ReadInJoyUserInfoModule.a parama, List<BiuCommentInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramList.size();
    String str1 = ((BiuCommentInfo)paramList.get(i - 1)).ahj;
    Object localObject;
    int j;
    ArrayList localArrayList;
    label101:
    BiuCommentInfo localBiuCommentInfo;
    long l;
    if ((!TextUtils.isEmpty(str1)) && ((str1.startsWith(":")) || (str1.startsWith("："))))
    {
      localObject = str1.substring(1);
      localStringBuilder.append((String)localObject);
      j = localStringBuilder.length();
      localArrayList = new ArrayList();
      i -= 2;
      if (i < 0) {
        break label449;
      }
      localBiuCommentInfo = (BiuCommentInfo)paramList.get(i);
      switch (localBiuCommentInfo.aSO)
      {
      default: 
        l = localBiuCommentInfo.i.longValue();
        localObject = ReadInJoyUserInfoModule.a(l, parama);
        if (localObject != null)
        {
          localObject = ((ReadInJoyUserInfo)localObject).nick;
          label178:
          str1 = "@" + (String)localObject;
          localObject = str1;
          if (localBiuCommentInfo.aSO == 1) {
            localObject = str1 + " ";
          }
          if (localBiuCommentInfo.ahj != null) {
            break label439;
          }
        }
        break;
      }
    }
    label439:
    for (str1 = "";; str1 = localBiuCommentInfo.ahj)
    {
      localStringBuilder.append((String)localObject).append(str1);
      localArrayList.add(new nql(j, ((String)localObject).length() + j, new nqp(l, paramString, paramArticleInfo)));
      do
      {
        j = localStringBuilder.length();
        i -= 1;
        break label101;
        localObject = str1;
        if (str1 != null) {
          break;
        }
        localObject = "";
        break;
      } while (localBiuCommentInfo.a == null);
      str1 = localBiuCommentInfo.a.iZ();
      String str2 = localBiuCommentInfo.a.getJumpUrl();
      if (localBiuCommentInfo.ahj == null) {}
      for (localObject = "";; localObject = localBiuCommentInfo.ahj)
      {
        localStringBuilder.append(str1).append((String)localObject);
        localArrayList.add(new nql(j, str1.length() + j, new nqj(str2, 13421772)));
        break;
      }
      localObject = ReadInJoyUserInfoModule.getDefaultNickName();
      break label178;
    }
    label449:
    paramArticleInfo = new SpannableStringBuilder(new aofk(localStringBuilder, 3, 16));
    paramString = localArrayList.iterator();
    while (paramString.hasNext())
    {
      parama = (nql)paramString.next();
      paramArticleInfo.setSpan(parama.A(), parama.getStartPos(), parama.getEndPos(), 17);
    }
    return paramArticleInfo;
  }
  
  public static BiuCommentInfo a(articlesummary.BiuOneLevelItem paramBiuOneLevelItem)
  {
    BiuCommentInfo localBiuCommentInfo = new BiuCommentInfo();
    localBiuCommentInfo.i = Long.valueOf(a(paramBiuOneLevelItem.uint64_uin));
    localBiuCommentInfo.x = Long.valueOf(a(paramBiuOneLevelItem.uint64_feeds_id));
    localBiuCommentInfo.aRW = a(paramBiuOneLevelItem.uint32_biu_time);
    localBiuCommentInfo.aLh = a(paramBiuOneLevelItem.feeds_type);
    localBiuCommentInfo.aSO = a(paramBiuOneLevelItem.op_type);
    if ((paramBiuOneLevelItem.bytes_biu_comments.has()) && (paramBiuOneLevelItem.bytes_biu_comments.get() != null)) {}
    try
    {
      String str = new String(paramBiuOneLevelItem.bytes_biu_comments.get().toByteArray(), "utf-8");
      localBiuCommentInfo.ahU = str;
      localBiuCommentInfo.ahj = anbk.nn(str);
      if ((paramBiuOneLevelItem.msg_jump_info.has()) && (paramBiuOneLevelItem.msg_jump_info.get() != null))
      {
        paramBiuOneLevelItem = (articlesummary.JumpInfo)paramBiuOneLevelItem.msg_jump_info.get();
        localBiuCommentInfo.a = new JumpInfo(a(paramBiuOneLevelItem.uint64_id), paramBiuOneLevelItem.bytes_wording.get().toStringUtf8(), paramBiuOneLevelItem.bytes_jump_url.get().toStringUtf8());
      }
      return localBiuCommentInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("SocializeFeedsInfo", 1, "parse bytes_biu_comment failed ", localException);
      }
    }
  }
  
  public static SocializeFeedsInfo a(articlesummary.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    long l2 = 0L;
    int j = 0;
    if (paramSocializeFeedsInfo == null)
    {
      QLog.d("SocializeFeedsInfo", 1, "convertPBToInfo feedsInfo == null");
      return null;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = new SocializeFeedsInfo();
    localSocializeFeedsInfo.mFeedId = a(paramSocializeFeedsInfo.uint64_feeds_id);
    Object localObject1 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e;
    long l1;
    label116:
    Object localObject3;
    label156:
    label207:
    label483:
    Object localObject4;
    if (paramSocializeFeedsInfo.msg_master_uin.has())
    {
      l1 = a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).uint64_uin);
      ((e)localObject1).uin = l1;
      localObject1 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e;
      if (!paramSocializeFeedsInfo.msg_master_uin.has()) {
        break label605;
      }
      i = a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).enum_uin_type);
      ((e)localObject1).type = i;
      localObject1 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e;
      if (!paramSocializeFeedsInfo.msg_master_uin.has()) {
        break label610;
      }
      i = a(((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).uint32_star_style);
      ((e)localObject1).starType = i;
      localObject3 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e;
      if (!paramSocializeFeedsInfo.msg_master_uin.has()) {
        break label622;
      }
      if (!paramSocializeFeedsInfo.msg_master_uin.bytes_person_desc.has()) {
        break label615;
      }
      localObject1 = paramSocializeFeedsInfo.msg_master_uin.bytes_person_desc.get().toStringUtf8();
      ((e)localObject3).ahV = ((String)localObject1);
      if ((paramSocializeFeedsInfo.msg_master_uin.has()) && (paramSocializeFeedsInfo.msg_master_uin.uint32_is_real_user.has())) {
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.aSP = paramSocializeFeedsInfo.msg_master_uin.uint32_is_real_user.get();
      }
      localSocializeFeedsInfo.aSG = a(paramSocializeFeedsInfo.uint32_feeds_style);
      localSocializeFeedsInfo.mLikeCount = a(paramSocializeFeedsInfo.uint32_like_count);
      localSocializeFeedsInfo.mCommentCount = a(paramSocializeFeedsInfo.uint32_comments_count);
      localSocializeFeedsInfo.aRW = a(paramSocializeFeedsInfo.uint32_biu_time);
      localSocializeFeedsInfo.aSH = a(paramSocializeFeedsInfo.uint32_myself_like_status);
      localSocializeFeedsInfo.aSK = a(paramSocializeFeedsInfo.uint32_follow_counts);
      localSocializeFeedsInfo.mFollowStatus = a(paramSocializeFeedsInfo.uint32_follow_status);
      localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q = q.a((feeds_info.ShareWebPageInfo)paramSocializeFeedsInfo.share_web_page_info.get());
      QLog.d("SocializeFeedsInfo", 1, "create SocialFeedsInfo, feedsID : " + localSocializeFeedsInfo.mFeedId + ", followCnt : " + localSocializeFeedsInfo.aSK + ", followStatus : " + localSocializeFeedsInfo.mFollowStatus + ", masterUin : " + localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin + ", followStatusHas : " + paramSocializeFeedsInfo.uint32_follow_status.has());
      if ((!paramSocializeFeedsInfo.rpt_recommend_list.has()) || (paramSocializeFeedsInfo.rpt_recommend_list.get() == null)) {
        break label639;
      }
      localObject1 = paramSocializeFeedsInfo.rpt_recommend_list.get().iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label639;
      }
      localObject3 = (articlesummary.SocializeFeedsInfoUser)((Iterator)localObject1).next();
      localSocializeFeedsInfo.getClass();
      localObject4 = new e(localSocializeFeedsInfo);
      if ((!((articlesummary.SocializeFeedsInfoUser)localObject3).has()) || (((articlesummary.SocializeFeedsInfoUser)localObject3).get() == null)) {
        break label629;
      }
      l1 = a(((articlesummary.SocializeFeedsInfoUser)localObject3).uint64_uin);
      label547:
      ((e)localObject4).uin = l1;
      if ((!((articlesummary.SocializeFeedsInfoUser)localObject3).has()) || (((articlesummary.SocializeFeedsInfoUser)localObject3).get() == null)) {
        break label634;
      }
    }
    label605:
    label610:
    label615:
    label622:
    label629:
    label634:
    for (int i = a(((articlesummary.SocializeFeedsInfoUser)localObject3).enum_uin_type);; i = 0)
    {
      ((e)localObject4).type = i;
      localSocializeFeedsInfo.iS.add(localObject4);
      break label483;
      l1 = 0L;
      break;
      i = 0;
      break label116;
      i = 0;
      break label156;
      localObject1 = "";
      break label207;
      localObject1 = "";
      break label207;
      l1 = 0L;
      break label547;
    }
    label639:
    if ((paramSocializeFeedsInfo.bytes_comments.has()) && (paramSocializeFeedsInfo.bytes_comments.get() != null)) {}
    try
    {
      localObject1 = new String(paramSocializeFeedsInfo.bytes_comments.get().toByteArray(), "utf-8");
      localSocializeFeedsInfo.ahM = ((String)localObject1);
      localSocializeFeedsInfo.ahL = anbk.nn((String)localObject1);
      if ((!paramSocializeFeedsInfo.bytes_recommend_reason.has()) || (paramSocializeFeedsInfo.bytes_recommend_reason.get() == null)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        localSocializeFeedsInfo.ahN = new String(paramSocializeFeedsInfo.bytes_recommend_reason.get().toByteArray(), "utf-8");
        if ((paramSocializeFeedsInfo.msg_socialize_feeds_ext_info.has()) && (paramSocializeFeedsInfo.msg_socialize_feeds_ext_info.get() != null)) {
          localSocializeFeedsInfo.br = ((articlesummary.SocializeFeedsExtInfo)paramSocializeFeedsInfo.msg_socialize_feeds_ext_info.get()).toByteArray();
        }
        localSocializeFeedsInfo.aSI = a(paramSocializeFeedsInfo.uint32_biu_count);
        localSocializeFeedsInfo.aSJ = a(paramSocializeFeedsInfo.uint32_myself_biu_status);
        if ((paramSocializeFeedsInfo.msg_biu_mutli_level.has()) && (paramSocializeFeedsInfo.msg_biu_mutli_level.get() != null)) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c = localSocializeFeedsInfo.a((articlesummary.BiuMultiLevel)paramSocializeFeedsInfo.msg_biu_mutli_level.get());
        }
        if (paramSocializeFeedsInfo.game_live_info.has())
        {
          localObject1 = (articlesummary.GameLiveInfo)paramSocializeFeedsInfo.game_live_info.get();
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g = new g();
          if (((articlesummary.GameLiveInfo)localObject1).bytes_play_bill_id.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.ahX = ((articlesummary.GameLiveInfo)localObject1).bytes_play_bill_id.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).uint32_status.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.status = ((articlesummary.GameLiveInfo)localObject1).uint32_status.get();
          }
          if (((articlesummary.GameLiveInfo)localObject1).uint32_audience_count.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.aSQ = ((articlesummary.GameLiveInfo)localObject1).uint32_audience_count.get();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_game_name.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.gameName = ((articlesummary.GameLiveInfo)localObject1).bytes_game_name.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_play_url.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.playUrl = ((articlesummary.GameLiveInfo)localObject1).bytes_play_url.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_tips_wording.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.tipsWording = ((articlesummary.GameLiveInfo)localObject1).bytes_tips_wording.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_status.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.ahZ = ((articlesummary.GameLiveInfo)localObject1).bytes_status.get().toStringUtf8();
          }
          if (((articlesummary.GameLiveInfo)localObject1).bytes_status_icon_url.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.agW = ((articlesummary.GameLiveInfo)localObject1).bytes_status_icon_url.get().toStringUtf8();
          }
        }
        if (paramSocializeFeedsInfo.uint64_article_id.has()) {
          localSocializeFeedsInfo.rX = paramSocializeFeedsInfo.uint64_article_id.get();
        }
        if (paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.has())
        {
          localObject1 = (articlesummary.UGCFeedsInfo)paramSocializeFeedsInfo.msg_ugc_topic_feeds_info.get();
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r = new r();
          if (((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_card_type.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa = ((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_card_type.get();
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).uint64_cuin.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin = ((articlesummary.UGCFeedsInfo)localObject1).uint64_cuin.get();
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_src.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTb = ((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_src.get();
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).bytes_ugc_comments.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.ail = ((articlesummary.UGCFeedsInfo)localObject1).bytes_ugc_comments.get().toStringUtf8();
          }
          if ((((articlesummary.UGCFeedsInfo)localObject1).msg_at_multi_level.has()) && (((articlesummary.UGCFeedsInfo)localObject1).msg_at_multi_level.get() != null)) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b = localSocializeFeedsInfo.a((articlesummary.BiuMultiLevel)((articlesummary.UGCFeedsInfo)localObject1).msg_at_multi_level.get());
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).account_profile.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.a = a.a((feeds_info.AccountProfile)((articlesummary.UGCFeedsInfo)localObject1).account_profile.get());
          }
          if (((articlesummary.UGCFeedsInfo)localObject1).msg_ugc_pic_info_list.has())
          {
            localObject3 = ((articlesummary.UGCFeedsInfo)localObject1).msg_ugc_pic_info_list.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (articlesummary.UGCPicInfo)((Iterator)localObject3).next();
              localObject5 = new s();
              if (((articlesummary.UGCPicInfo)localObject4).bytes_pic_md5.has()) {
                ((s)localObject5).pic_md5 = ((articlesummary.UGCPicInfo)localObject4).bytes_pic_md5.get().toStringUtf8();
              }
              if (((articlesummary.UGCPicInfo)localObject4).bytes_pic_url.has()) {
                ((s)localObject5).pic_url = ((articlesummary.UGCPicInfo)localObject4).bytes_pic_url.get().toStringUtf8();
              }
              if (((articlesummary.UGCPicInfo)localObject4).uint32_pic_height.has()) {
                ((s)localObject5).pic_height = ((articlesummary.UGCPicInfo)localObject4).uint32_pic_height.get();
              }
              if (((articlesummary.UGCPicInfo)localObject4).uint32_pic_width.has()) {
                ((s)localObject5).pic_width = ((articlesummary.UGCPicInfo)localObject4).uint32_pic_width.get();
              }
              if (((articlesummary.UGCPicInfo)localObject4).bytes_thumbnail_url.has()) {
                ((s)localObject5).aii = ((articlesummary.UGCPicInfo)localObject4).bytes_thumbnail_url.get().toStringUtf8();
              }
              if (((articlesummary.UGCPicInfo)localObject4).is_animation.has()) {
                ((s)localObject5).aSX = ((articlesummary.UGCPicInfo)localObject4).is_animation.get();
              }
              localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.add(localObject5);
              continue;
              localException1 = localException1;
              QLog.d("SocializeFeedsInfo", 1, "parse bytes_comments failed ", localException1);
            }
          }
        }
      }
      catch (Exception localException2)
      {
        Object localObject5;
        for (;;)
        {
          QLog.d("SocializeFeedsInfo", 1, "parse bytes_comments reason failed ", localException2);
        }
        if (localException2.msg_ugc_video_info_list.has())
        {
          localObject3 = localException2.msg_ugc_video_info_list.get().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (articlesummary.UGCVideoInfo)((Iterator)localObject3).next();
            localObject5 = new t();
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_pic_md5.has()) {
              ((t)localObject5).pic_md5 = ((articlesummary.UGCVideoInfo)localObject4).bytes_pic_md5.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_pic_url.has()) {
              ((t)localObject5).pic_url = ((articlesummary.UGCVideoInfo)localObject4).bytes_pic_url.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_title.has()) {
              ((t)localObject5).title = ((articlesummary.UGCVideoInfo)localObject4).bytes_title.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_uuid.has()) {
              ((t)localObject5).uuid = ((articlesummary.UGCVideoInfo)localObject4).bytes_uuid.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_video_md5.has()) {
              ((t)localObject5).aik = ((articlesummary.UGCVideoInfo)localObject4).bytes_video_md5.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_video_url.has()) {
              ((t)localObject5).video_url = ((articlesummary.UGCVideoInfo)localObject4).bytes_video_url.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_share_url.has()) {
              ((t)localObject5).share_url = ((articlesummary.UGCVideoInfo)localObject4).bytes_share_url.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_vid.has()) {
              ((t)localObject5).vid = ((articlesummary.UGCVideoInfo)localObject4).bytes_vid.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).bytes_uniq_id.has()) {
              ((t)localObject5).aim = ((articlesummary.UGCVideoInfo)localObject4).bytes_uniq_id.get().toStringUtf8();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_busi_type.has()) {
              ((t)localObject5).aSY = ((articlesummary.UGCVideoInfo)localObject4).uint32_busi_type.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_create_time.has()) {
              ((t)localObject5).aTe = ((articlesummary.UGCVideoInfo)localObject4).uint32_create_time.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint64_duration.has()) {
              ((t)localObject5).duration = ((articlesummary.UGCVideoInfo)localObject4).uint64_duration.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_video_width.has()) {
              ((t)localObject5).aTc = ((articlesummary.UGCVideoInfo)localObject4).uint32_video_width.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_video_height.has()) {
              ((t)localObject5).aTd = ((articlesummary.UGCVideoInfo)localObject4).uint32_video_height.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_pic_width.has()) {
              ((t)localObject5).pic_width = ((articlesummary.UGCVideoInfo)localObject4).uint32_pic_width.get();
            }
            if (((articlesummary.UGCVideoInfo)localObject4).uint32_pic_height.has()) {
              ((t)localObject5).pic_height = ((articlesummary.UGCVideoInfo)localObject4).uint32_pic_height.get();
            }
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.add(localObject5);
          }
        }
        if (localException2.msg_ugc_voice_info_list.has())
        {
          localObject3 = localException2.msg_ugc_voice_info_list.get().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (articlesummary.UGCVoiceInfo)((Iterator)localObject3).next();
            localObject5 = new UGCVoiceInfo();
            ((UGCVoiceInfo)localObject5).voiceUrl = ((articlesummary.UGCVoiceInfo)localObject4).bytes_voice_url.get().toStringUtf8();
            ((UGCVoiceInfo)localObject5).duration = ((articlesummary.UGCVoiceInfo)localObject4).uint32_duration.get();
            ((UGCVoiceInfo)localObject5).fileSize = ((articlesummary.UGCVoiceInfo)localObject4).uint32_file_size.get();
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lc.add(localObject5);
          }
        }
        if (localException2.bytes_jump_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.jumpUrl = localException2.bytes_jump_url.get().toStringUtf8();
        }
        if (paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.has())
        {
          localObject2 = (articlesummary.PGCFeedsInfo)paramSocializeFeedsInfo.msg_pgc_topic_feeds_info.get();
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m = new m();
          if (((articlesummary.PGCFeedsInfo)localObject2).bytes_pgc_comments.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih = ((articlesummary.PGCFeedsInfo)localObject2).bytes_pgc_comments.get().toStringUtf8();
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).uint32_myself_follow_status.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aSV = ((articlesummary.PGCFeedsInfo)localObject2).uint32_myself_follow_status.get();
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).uint32_follow_counts.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aSU = ((articlesummary.PGCFeedsInfo)localObject2).uint32_follow_counts.get();
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).uint32_article_type.has()) {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.amM = true;
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_pic_info_list.has())
          {
            localObject3 = ((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_pic_info_list.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              Object localObject6 = (articlesummary.PGCPicInfo)((Iterator)localObject3).next();
              localObject4 = new n();
              if (((articlesummary.PGCPicInfo)localObject6).bytes_pic_md5.has()) {
                ((n)localObject4).pic_md5 = ((articlesummary.PGCPicInfo)localObject6).bytes_pic_md5.get().toStringUtf8();
              }
              if (((articlesummary.PGCPicInfo)localObject6).bytes_pic_url.has()) {
                ((n)localObject4).pic_url = ((articlesummary.PGCPicInfo)localObject6).bytes_pic_url.get().toStringUtf8();
              }
              if (((articlesummary.PGCPicInfo)localObject6).uint32_pic_height.has()) {
                ((n)localObject4).pic_height = ((articlesummary.PGCPicInfo)localObject6).uint32_pic_height.get();
              }
              if (((articlesummary.PGCPicInfo)localObject6).uint32_pic_width.has()) {
                ((n)localObject4).pic_width = ((articlesummary.PGCPicInfo)localObject6).uint32_pic_width.get();
              }
              if (((articlesummary.PGCPicInfo)localObject6).is_animation.has()) {
                ((n)localObject4).aSX = ((articlesummary.PGCPicInfo)localObject6).is_animation.get();
              }
              if (((articlesummary.PGCPicInfo)localObject6).bytes_thumbnail_url.has()) {
                ((n)localObject4).aii = ((articlesummary.PGCPicInfo)localObject6).bytes_thumbnail_url.get().toStringUtf8();
              }
              if (((articlesummary.PGCPicInfo)localObject6).bytes_pic_desc.has()) {
                ((n)localObject4).aij = ((articlesummary.PGCPicInfo)localObject6).bytes_pic_desc.get().toStringUtf8();
              }
              if (((articlesummary.PGCPicInfo)localObject6).uint64_gallery_index.has()) {
                ((n)localObject4).vP = ((articlesummary.PGCPicInfo)localObject6).uint64_gallery_index.get();
              }
              if (((articlesummary.PGCPicInfo)localObject6).msg_video_info.has())
              {
                localObject5 = new o();
                localObject6 = (articlesummary.PGCVideoInfo)((articlesummary.PGCPicInfo)localObject6).msg_video_info.get();
                if (((articlesummary.PGCVideoInfo)localObject6).bytes_pic_md5.has()) {
                  ((o)localObject5).pic_md5 = ((articlesummary.PGCVideoInfo)localObject6).bytes_pic_md5.get().toStringUtf8();
                }
                if (((articlesummary.PGCVideoInfo)localObject6).bytes_pic_url.has()) {
                  ((o)localObject5).pic_url = ((articlesummary.PGCVideoInfo)localObject6).bytes_pic_url.get().toStringUtf8();
                }
                if (((articlesummary.PGCVideoInfo)localObject6).bytes_vid.has()) {
                  ((o)localObject5).vid = ((articlesummary.PGCVideoInfo)localObject6).bytes_vid.get().toStringUtf8();
                }
                if (((articlesummary.PGCVideoInfo)localObject6).uint32_duration.has()) {
                  ((o)localObject5).duration = ((articlesummary.PGCVideoInfo)localObject6).uint32_duration.get();
                }
                if (((articlesummary.PGCVideoInfo)localObject6).uint32_busi_type.has()) {
                  ((o)localObject5).aSY = ((articlesummary.PGCVideoInfo)localObject6).uint32_busi_type.get();
                }
                ((n)localObject4).b = ((o)localObject5);
              }
              localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY.add(localObject4);
            }
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_video_info_list.has())
          {
            localObject3 = ((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_video_info_list.get().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (articlesummary.PGCVideoInfo)((Iterator)localObject3).next();
              localObject5 = new o();
              if (((articlesummary.PGCVideoInfo)localObject4).bytes_pic_md5.has()) {
                ((o)localObject5).pic_md5 = ((articlesummary.PGCVideoInfo)localObject4).bytes_pic_md5.get().toStringUtf8();
              }
              if (((articlesummary.PGCVideoInfo)localObject4).bytes_pic_url.has()) {
                ((o)localObject5).pic_url = ((articlesummary.PGCVideoInfo)localObject4).bytes_pic_url.get().toStringUtf8();
              }
              if (((articlesummary.PGCVideoInfo)localObject4).bytes_video_md5.has()) {
                ((o)localObject5).aik = ((articlesummary.PGCVideoInfo)localObject4).bytes_video_md5.get().toStringUtf8();
              }
              if (((articlesummary.PGCVideoInfo)localObject4).bytes_video_url.has()) {
                ((o)localObject5).video_url = ((articlesummary.PGCVideoInfo)localObject4).bytes_video_url.get().toStringUtf8();
              }
              localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kZ.add(localObject5);
            }
          }
          if (((articlesummary.PGCFeedsInfo)localObject2).msg_gallery_feeds_info.has())
          {
            localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a = new f();
            localObject2 = (articlesummary.GalleryPGCFeedsInfo)((articlesummary.PGCFeedsInfo)localObject2).msg_gallery_feeds_info.get();
            if (((articlesummary.GalleryPGCFeedsInfo)localObject2).uint64_pic_count.has()) {
              localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a.vN = ((articlesummary.GalleryPGCFeedsInfo)localObject2).uint64_pic_count.get();
            }
          }
        }
        if (!paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) {
          break label4984;
        }
      }
    }
    localSocializeFeedsInfo.mTopicRecommendFeedsInfo = mih.a((articlesummary.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get());
    QLog.d("SocializeFeedsInfo", 1, new Object[] { "info.topicRecommendFeedsInfo = ", localSocializeFeedsInfo.mTopicRecommendFeedsInfo });
    label3190:
    boolean bool;
    if (paramSocializeFeedsInfo.bytes_recommend_account_reason.has())
    {
      localSocializeFeedsInfo.ahO = paramSocializeFeedsInfo.bytes_recommend_account_reason.get().toStringUtf8();
      QLog.d("SocializeFeedsInfo", 1, new Object[] { "info.mRecommendAccountReason = ", localSocializeFeedsInfo.ahO });
      if (paramSocializeFeedsInfo.wenda_info.has())
      {
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u = new u();
        localObject2 = (articlesummary.WendaInfo)paramSocializeFeedsInfo.wenda_info.get();
        if (((articlesummary.WendaInfo)localObject2).uint32_is_super_wenda.has())
        {
          i = ((articlesummary.WendaInfo)localObject2).uint32_is_super_wenda.get();
          localObject3 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u;
          if (i != 1) {
            break label5010;
          }
          bool = true;
          label3259:
          ((u)localObject3).amO = bool;
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_question_rowkey.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.agH = ((articlesummary.WendaInfo)localObject2).bytes_question_rowkey.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_question_desc.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.ain = ((articlesummary.WendaInfo)localObject2).bytes_question_desc.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_question_pic_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aio = ((articlesummary.WendaInfo)localObject2).bytes_question_pic_url.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_wenda_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.wendaUrl = ((articlesummary.WendaInfo)localObject2).bytes_wenda_url.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).uint32_follow_count.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.followCount = ((articlesummary.WendaInfo)localObject2).uint32_follow_count.get();
        }
        if (((articlesummary.WendaInfo)localObject2).uint32_answer_count.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aTf = ((articlesummary.WendaInfo)localObject2).uint32_answer_count.get();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_icon_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aip = ((articlesummary.WendaInfo)localObject2).bytes_icon_url.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).bytes_answer_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aiq = ((articlesummary.WendaInfo)localObject2).bytes_answer_url.get().toStringUtf8();
        }
        if (((articlesummary.WendaInfo)localObject2).channel_id.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.channelId = ((articlesummary.WendaInfo)localObject2).channel_id.get();
        }
        if (((articlesummary.WendaInfo)localObject2).channel_id_name.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.ais = ((articlesummary.WendaInfo)localObject2).channel_id_name.get();
        }
        if (((articlesummary.WendaInfo)localObject2).channel_second_id.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aTg = ((articlesummary.WendaInfo)localObject2).channel_second_id.get();
        }
        if (((articlesummary.WendaInfo)localObject2).channel_second_id_name.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.ait = ((articlesummary.WendaInfo)localObject2).channel_second_id_name.get();
        }
        if (((articlesummary.WendaInfo)localObject2).tag_id.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.iV = ((articlesummary.WendaInfo)localObject2).tag_id.get();
        }
        if (((articlesummary.WendaInfo)localObject2).tag_id_name.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.iW = ((articlesummary.WendaInfo)localObject2).tag_id_name.get();
        }
        if (((articlesummary.WendaInfo)localObject2).author_nick.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aiu = ((articlesummary.WendaInfo)localObject2).author_nick.get();
        }
        if (((articlesummary.WendaInfo)localObject2).jump_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.jumpUrl = ((articlesummary.WendaInfo)localObject2).jump_url.get();
        }
        if (((articlesummary.WendaInfo)localObject2).images_url.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.iX = ((articlesummary.WendaInfo)localObject2).images_url.get();
        }
        if (((articlesummary.WendaInfo)localObject2).icon_name.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aiv = ((articlesummary.WendaInfo)localObject2).icon_name.get();
        }
        if (((articlesummary.WendaInfo)localObject2).icon_color.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aiw = ((articlesummary.WendaInfo)localObject2).icon_color.get();
        }
        if (((articlesummary.WendaInfo)localObject2).super_wenda_button_title.has()) {
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.aix = ((articlesummary.WendaInfo)localObject2).super_wenda_button_title.get();
        }
        if (((articlesummary.WendaInfo)localObject2).answer_detail.has())
        {
          localObject2 = (articlesummary.AnswerDetail)((articlesummary.WendaInfo)localObject2).answer_detail.get();
          localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a((articlesummary.AnswerDetail)localObject2);
        }
      }
      localSocializeFeedsInfo.aSL = a(paramSocializeFeedsInfo.uint32_is_origin_feeds_deleted);
      if (paramSocializeFeedsInfo.icon_wording_info.has())
      {
        localObject2 = new h();
        localObject3 = (feeds_info.IconWordingInfo)paramSocializeFeedsInfo.icon_wording_info.get();
        ((h)localObject2).appType = a(((feeds_info.IconWordingInfo)localObject3).uint32_type);
        if (((feeds_info.IconWordingInfo)localObject3).bytes_icon_url.has()) {
          ((h)localObject2).appIcon = ((feeds_info.IconWordingInfo)localObject3).bytes_icon_url.get().toStringUtf8();
        }
        if (((feeds_info.IconWordingInfo)localObject3).bytes_wording.has()) {
          ((h)localObject2).appName = ((feeds_info.IconWordingInfo)localObject3).bytes_wording.get().toStringUtf8();
        }
        if (((feeds_info.IconWordingInfo)localObject3).bytes_status_icon_url.has()) {
          ((h)localObject2).aia = ((feeds_info.IconWordingInfo)localObject3).bytes_status_icon_url.get().toStringUtf8();
        }
        ((h)localObject2).status = a(((feeds_info.IconWordingInfo)localObject3).uint32_status);
        if (((feeds_info.IconWordingInfo)localObject3).bytes_status.has()) {
          ((h)localObject2).aib = ((feeds_info.IconWordingInfo)localObject3).bytes_status.get().toStringUtf8();
        }
        ((h)localObject2).aSR = a(((feeds_info.IconWordingInfo)localObject3).uint32_icon_show_mode);
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$h = ((h)localObject2);
      }
      if (paramSocializeFeedsInfo.uint32_feed_status.has()) {
        localSocializeFeedsInfo.aSM = paramSocializeFeedsInfo.uint32_feed_status.get();
      }
      if (paramSocializeFeedsInfo.bytes_private_status_title.has()) {
        localSocializeFeedsInfo.ahP = paramSocializeFeedsInfo.bytes_private_status_title.get().toStringUtf8();
      }
      if ((paramSocializeFeedsInfo.location_info.has()) && (paramSocializeFeedsInfo.location_info.get() != null))
      {
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i = new i();
        localObject3 = (feeds_info.LocationInfo)paramSocializeFeedsInfo.location_info.get();
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i;
        if (!((feeds_info.LocationInfo)localObject3).bytes_name.has()) {
          break label5016;
        }
        localObject2 = ((feeds_info.LocationInfo)localObject3).bytes_name.get().toStringUtf8();
        label4177:
        ((i)localObject4).name = ((String)localObject2);
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i.longitude = ((feeds_info.LocationInfo)localObject3).uint32_longitude.get();
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i.latitude = ((feeds_info.LocationInfo)localObject3).uint32_latitude.get();
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i;
        if (!((feeds_info.LocationInfo)localObject3).bytes_icon_url.has()) {
          break label5023;
        }
        localObject2 = ((feeds_info.LocationInfo)localObject3).bytes_icon_url.get().toStringUtf8();
        label4247:
        ((i)localObject4).iconUrl = ((String)localObject2);
      }
      if (paramSocializeFeedsInfo.uint32_is_jump_recommend_page.has())
      {
        localSocializeFeedsInfo.aSN = a(paramSocializeFeedsInfo.uint32_is_jump_recommend_page);
        if (paramSocializeFeedsInfo.bytes_jump_recommend_url.has()) {
          localSocializeFeedsInfo.ahQ = paramSocializeFeedsInfo.bytes_jump_recommend_url.get().toStringUtf8();
        }
        if (paramSocializeFeedsInfo.bytes_jump_recommend_prompt.has()) {
          localSocializeFeedsInfo.ahR = paramSocializeFeedsInfo.bytes_jump_recommend_prompt.get().toStringUtf8();
        }
        QLog.d("SocializeFeedsInfo", 1, "parse jumpchannel " + localSocializeFeedsInfo.aSN + "  " + localSocializeFeedsInfo.ahQ + "  " + localSocializeFeedsInfo.ahR);
      }
      if ((paramSocializeFeedsInfo.visible_info.has()) && (paramSocializeFeedsInfo.visible_info.visible_show_info.has()))
      {
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p = new p();
        localObject2 = (feeds_info.VisibleShowInfo)paramSocializeFeedsInfo.visible_info.visible_show_info.get();
        localObject3 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p;
        if (!((feeds_info.VisibleShowInfo)localObject2).uint64_feed_id.has()) {
          break label5030;
        }
        l1 = ((feeds_info.VisibleShowInfo)localObject2).uint64_feed_id.get();
        label4462:
        ((p)localObject3).vd = l1;
        localObject3 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p;
        i = j;
        if (((feeds_info.VisibleShowInfo)localObject2).uint32_visible_type.has()) {
          i = ((feeds_info.VisibleShowInfo)localObject2).uint32_visible_type.get();
        }
        ((p)localObject3).aSZ = i;
        localObject3 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p;
        l1 = l2;
        if (((feeds_info.VisibleShowInfo)localObject2).uint64_who.has()) {
          l1 = ((feeds_info.VisibleShowInfo)localObject2).uint64_who.get();
        }
        ((p)localObject3).vR = l1;
        QLog.d("SocializeFeedsInfo", 1, "feeds privacy | feedsid  " + localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p.vd + " | privacyType " + localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p.aSZ + " | privacySetUin " + localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p.vR);
      }
      if ((paramSocializeFeedsInfo.msg_master_uin.has()) && (((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.has())) {
        a(localSocializeFeedsInfo, ((articlesummary.SocializeFeedsInfoUser)paramSocializeFeedsInfo.msg_master_uin.get()).rpt_msg_medal_info.get());
      }
      if ((paramSocializeFeedsInfo.buluo_info.has()) && (paramSocializeFeedsInfo.buluo_info.get() != null))
      {
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d = new d();
        localObject3 = (articlesummary.BuluoInfo)paramSocializeFeedsInfo.buluo_info.get();
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d;
        if (!((articlesummary.BuluoInfo)localObject3).bytes_wording.has()) {
          break label5035;
        }
        localObject2 = ((articlesummary.BuluoInfo)localObject3).bytes_wording.get().toStringUtf8();
        label4732:
        ((d)localObject4).wording = ((String)localObject2);
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d;
        if (!((articlesummary.BuluoInfo)localObject3).bytes_head_url.has()) {
          break label5042;
        }
        localObject2 = ((articlesummary.BuluoInfo)localObject3).bytes_head_url.get().toStringUtf8();
        label4770:
        ((d)localObject4).headUrl = ((String)localObject2);
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d.bid = ((articlesummary.BuluoInfo)localObject3).uint64_buluo_id.get();
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d;
        if (!((articlesummary.BuluoInfo)localObject3).bytes_jump_url.has()) {
          break label5049;
        }
        localObject2 = ((articlesummary.BuluoInfo)localObject3).bytes_jump_url.get().toStringUtf8();
        label4824:
        ((d)localObject4).jumpUrl = ((String)localObject2);
        localObject4 = localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d;
        if (!((articlesummary.BuluoInfo)localObject3).bytes_name.has()) {
          break label5056;
        }
      }
    }
    label5010:
    label5016:
    label5023:
    label5030:
    label5035:
    label5042:
    label5049:
    label5056:
    for (Object localObject2 = ((articlesummary.BuluoInfo)localObject3).bytes_name.get().toStringUtf8();; localObject2 = "")
    {
      ((d)localObject4).name = ((String)localObject2);
      if ((paramSocializeFeedsInfo.long_content_info.has()) && (paramSocializeFeedsInfo.long_content_info.get() != null)) {
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j = new j((articlesummary.LongContentInfo)paramSocializeFeedsInfo.long_content_info.get());
      }
      if ((paramSocializeFeedsInfo.msg_column_topic_info.has()) && (paramSocializeFeedsInfo.msg_column_topic_info.get() != null)) {
        localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo = ((articlesummary.ColumnTopicInfo)paramSocializeFeedsInfo.msg_column_topic_info.get());
      }
      if ((paramSocializeFeedsInfo.msg_topic_entrance_info.has()) && (paramSocializeFeedsInfo.msg_topic_entrance_info.get() != null)) {
        localSocializeFeedsInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo = ((articlesummary.TopicEntranceInfo)paramSocializeFeedsInfo.msg_topic_entrance_info.get());
      }
      return localSocializeFeedsInfo;
      label4984:
      QLog.d("SocializeFeedsInfo", 1, "info.topicRecommendFeedsInfo is null.");
      break;
      QLog.d("SocializeFeedsInfo", 1, "info.mRecommendAccountReason is null.");
      break label3190;
      bool = false;
      break label3259;
      localObject2 = "";
      break label4177;
      localObject2 = "";
      break label4247;
      l1 = 0L;
      break label4462;
      localObject2 = "";
      break label4732;
      localObject2 = "";
      break label4770;
      localObject2 = "";
      break label4824;
    }
  }
  
  private static void a(SocializeFeedsInfo paramSocializeFeedsInfo, List<oidb_cmd0xb57.MedalInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      paramList = (oidb_cmd0xb57.MedalInfo)paramList.get(0);
      paramSocializeFeedsInfo.b = new kgj();
      if (paramList.bytes_jump_url.has()) {
        paramSocializeFeedsInfo.b.mJumpUrl = paramList.bytes_jump_url.get().toStringUtf8();
      }
      if (paramList.uint32_is_jump.has()) {
        paramSocializeFeedsInfo.b.aIC = paramList.uint32_is_jump.get();
      }
      if (paramList.uint32_medal_type.has()) {
        paramSocializeFeedsInfo.b.aIB = paramList.uint32_medal_type.get();
      }
      if (paramList.uint64_medal_id.has()) {
        paramSocializeFeedsInfo.b.rU = paramList.uint64_medal_id.get();
      }
      if (paramList.bytes_medal_name.has()) {
        paramSocializeFeedsInfo.b.Za = paramList.bytes_medal_name.get().toStringUtf8();
      }
      if (paramList.bytes_medal_url.has()) {
        paramSocializeFeedsInfo.b.Zb = paramList.bytes_medal_url.get().toStringUtf8();
      }
      if (paramList.uint32_pic_width.has()) {
        paramSocializeFeedsInfo.b.mPicWidth = paramList.uint32_pic_width.get();
      }
    } while (!paramList.uint32_pic_height.has());
    paramSocializeFeedsInfo.b.mPicHeight = paramList.uint32_pic_height.get();
  }
  
  public boolean DB()
  {
    return this.aSM == 1;
  }
  
  public boolean DC()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p.aSZ != 0);
  }
  
  public byte[] E()
  {
    articlesummary.SocializeFeedsInfo localSocializeFeedsInfo = new articlesummary.SocializeFeedsInfo();
    localSocializeFeedsInfo.uint64_feeds_id.set(this.mFeedId);
    localSocializeFeedsInfo.uint32_comments_count.set(this.mCommentCount);
    localSocializeFeedsInfo.uint32_biu_time.set(this.aRW);
    localSocializeFeedsInfo.uint32_feeds_style.set(this.aSG);
    localSocializeFeedsInfo.uint32_like_count.set(this.mLikeCount);
    localSocializeFeedsInfo.uint32_myself_like_status.set(this.aSH);
    articlesummary.SocializeFeedsInfoUser localSocializeFeedsInfoUser = new articlesummary.SocializeFeedsInfoUser();
    localSocializeFeedsInfoUser.uint64_uin.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);
    localSocializeFeedsInfoUser.enum_uin_type.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.type);
    localSocializeFeedsInfoUser.uint32_star_style.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.starType);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.ahV)) {
      localSocializeFeedsInfoUser.bytes_person_desc.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.ahV));
    }
    localSocializeFeedsInfoUser.uint32_is_real_user.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.aSP);
    localSocializeFeedsInfo.msg_master_uin.set(localSocializeFeedsInfoUser);
    localSocializeFeedsInfo.uint32_follow_counts.set(this.aSK);
    localSocializeFeedsInfo.uint32_follow_status.set(this.mFollowStatus);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q != null) {
      localSocializeFeedsInfo.share_web_page_info.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q.a());
    }
    Object localObject1 = new ArrayList();
    Object localObject3 = this.iS.iterator();
    Object localObject5;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (e)((Iterator)localObject3).next();
      localObject5 = new articlesummary.SocializeFeedsInfoUser();
      ((articlesummary.SocializeFeedsInfoUser)localObject5).uint64_uin.set(((e)localObject4).uin);
      ((articlesummary.SocializeFeedsInfoUser)localObject5).enum_uin_type.set(((e)localObject4).type);
      ((List)localObject1).add(localObject5);
    }
    localSocializeFeedsInfo.rpt_recommend_list.set((List)localObject1);
    if (this.ahM != null) {
      localSocializeFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(this.ahM));
    }
    if (this.ahN != null) {
      localSocializeFeedsInfo.bytes_recommend_reason.set(ByteStringMicro.copyFromUtf8(this.ahN));
    }
    localSocializeFeedsInfo.uint32_myself_biu_status.set(this.aSJ);
    localSocializeFeedsInfo.uint32_biu_count.set(this.aSI);
    try
    {
      if (this.br != null) {
        localSocializeFeedsInfo.msg_socialize_feeds_ext_info.mergeFrom(this.br);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c != null) {
        localSocializeFeedsInfo.msg_biu_mutli_level.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.a());
      }
    }
    catch (Exception localException)
    {
      Object localObject6;
      for (;;)
      {
        QLog.d("SocializeFeedsInfo", 1, "merge info failed ", localException);
      }
      localException.msg_ugc_pic_info_list.set((List)localObject3);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.size() <= 0)) {
        break label1438;
      }
      localObject3 = new ArrayList();
      localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (t)((Iterator)localObject4).next();
        localObject6 = new articlesummary.UGCVideoInfo();
        ((articlesummary.UGCVideoInfo)localObject6).uint64_duration.set(((t)localObject5).duration);
        if (!TextUtils.isEmpty(((t)localObject5).video_url)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((t)localObject5).video_url));
        }
        if (!TextUtils.isEmpty(((t)localObject5).aik)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((t)localObject5).aik));
        }
        if (!TextUtils.isEmpty(((t)localObject5).uuid)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_uuid.set(ByteStringMicro.copyFromUtf8(((t)localObject5).uuid));
        }
        if (!TextUtils.isEmpty(((t)localObject5).pic_md5)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((t)localObject5).pic_md5));
        }
        if (!TextUtils.isEmpty(((t)localObject5).pic_url)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((t)localObject5).pic_url));
        }
        if (!TextUtils.isEmpty(((t)localObject5).title)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_title.set(ByteStringMicro.copyFromUtf8(((t)localObject5).title));
        }
        if (!TextUtils.isEmpty(((t)localObject5).aim)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_uniq_id.set(ByteStringMicro.copyFromUtf8(((t)localObject5).aim));
        }
        if (!TextUtils.isEmpty(((t)localObject5).share_url)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_share_url.set(ByteStringMicro.copyFromUtf8(((t)localObject5).share_url));
        }
        if (!TextUtils.isEmpty(((t)localObject5).vid)) {
          ((articlesummary.UGCVideoInfo)localObject6).bytes_vid.set(ByteStringMicro.copyFromUtf8(((t)localObject5).vid));
        }
        ((articlesummary.UGCVideoInfo)localObject6).uint32_create_time.set(((t)localObject5).aTe);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_busi_type.set(((t)localObject5).aSY);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_pic_height.set(((t)localObject5).pic_height);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_pic_width.set(((t)localObject5).pic_width);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_video_height.set(((t)localObject5).aTd);
        ((articlesummary.UGCVideoInfo)localObject6).uint32_video_width.set(((t)localObject5).aTc);
        ((List)localObject3).add(localObject6);
      }
      localException.msg_ugc_video_info_list.set((List)localObject3);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lc == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lc.size() <= 0)) {
        break label1588;
      }
      localObject3 = new ArrayList();
      localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lc.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (UGCVoiceInfo)((Iterator)localObject4).next();
        localObject6 = new articlesummary.UGCVoiceInfo();
        ((articlesummary.UGCVoiceInfo)localObject6).uint32_duration.set(((UGCVoiceInfo)localObject5).duration);
        ((articlesummary.UGCVoiceInfo)localObject6).uint32_file_size.set(((UGCVoiceInfo)localObject5).fileSize);
        if (!TextUtils.isEmpty(((UGCVoiceInfo)localObject5).voiceUrl)) {
          ((articlesummary.UGCVoiceInfo)localObject6).bytes_voice_url.set(ByteStringMicro.copyFromUtf8(((UGCVoiceInfo)localObject5).voiceUrl));
        }
        ((List)localObject3).add(localObject6);
      }
      localException.msg_ugc_voice_info_list.set((List)localObject3);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.a == null) {
        break label1615;
      }
      localException.account_profile.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.a.a());
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.jumpUrl)) {
        break label1645;
      }
      localException.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.jumpUrl));
      localSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(localException);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m == null) {
        break label2952;
      }
      localObject2 = new articlesummary.PGCFeedsInfo();
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih)) {
        break label1698;
      }
      ((articlesummary.PGCFeedsInfo)localObject2).bytes_pgc_comments.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aih));
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.amM) {
        break label1716;
      }
      ((articlesummary.PGCFeedsInfo)localObject2).uint32_article_type.set(1);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aSV == -1) {
        break label1741;
      }
      ((articlesummary.PGCFeedsInfo)localObject2).uint32_myself_follow_status.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aSV);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aSU == -1) {
        break label1766;
      }
      ((articlesummary.PGCFeedsInfo)localObject2).uint32_follow_counts.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aSU);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY.size() <= 0)) {
        break label2259;
      }
      localObject3 = new ArrayList();
      localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kY.iterator();
      Object localObject7;
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (n)((Iterator)localObject4).next();
        localObject6 = new articlesummary.PGCPicInfo();
        if (!TextUtils.isEmpty(((n)localObject5).pic_md5)) {
          ((articlesummary.PGCPicInfo)localObject6).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((n)localObject5).pic_md5));
        }
        if (!TextUtils.isEmpty(((n)localObject5).pic_url)) {
          ((articlesummary.PGCPicInfo)localObject6).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((n)localObject5).pic_url));
        }
        ((articlesummary.PGCPicInfo)localObject6).uint32_pic_height.set(((n)localObject5).pic_height);
        ((articlesummary.PGCPicInfo)localObject6).uint32_pic_width.set(((n)localObject5).pic_width);
        if (!TextUtils.isEmpty(((n)localObject5).aii)) {
          ((articlesummary.PGCPicInfo)localObject6).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((n)localObject5).aii));
        }
        if (!TextUtils.isEmpty(((n)localObject5).aij)) {
          ((articlesummary.PGCPicInfo)localObject6).bytes_pic_desc.set(ByteStringMicro.copyFromUtf8(((n)localObject5).aij));
        }
        if (((n)localObject5).vP != -1L) {
          ((articlesummary.PGCPicInfo)localObject6).uint64_gallery_index.set(((n)localObject5).vP);
        }
        if (((n)localObject5).b != null)
        {
          localObject7 = new articlesummary.PGCVideoInfo();
          if (!TextUtils.isEmpty(((n)localObject5).b.vid)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_vid.set(ByteStringMicro.copyFromUtf8(((n)localObject5).b.vid));
          }
          if (!TextUtils.isEmpty(((n)localObject5).b.video_url)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((n)localObject5).b.video_url));
          }
          if (!TextUtils.isEmpty(((n)localObject5).b.aik)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((n)localObject5).b.aik));
          }
          if (!TextUtils.isEmpty(((n)localObject5).b.pic_md5)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((n)localObject5).b.pic_md5));
          }
          if (!TextUtils.isEmpty(((n)localObject5).b.pic_url)) {
            ((articlesummary.PGCVideoInfo)localObject7).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((n)localObject5).b.pic_url));
          }
          ((articlesummary.PGCVideoInfo)localObject7).uint32_duration.set(((n)localObject5).b.duration);
          ((articlesummary.PGCVideoInfo)localObject7).uint32_busi_type.set(((n)localObject5).b.aSY);
          ((articlesummary.PGCPicInfo)localObject6).msg_video_info.set((MessageMicro)localObject7);
        }
        ((articlesummary.PGCPicInfo)localObject6).is_animation.set(((n)localObject5).aSX);
        ((List)localObject3).add(localObject6);
      }
      ((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_pic_info_list.set((List)localObject3);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kZ == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kZ.size() <= 0)) {
        break label2464;
      }
      localObject3 = new ArrayList();
      localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.kZ.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (o)((Iterator)localObject4).next();
        localObject6 = new articlesummary.PGCVideoInfo();
        if (!TextUtils.isEmpty(((o)localObject5).video_url)) {
          ((articlesummary.PGCVideoInfo)localObject6).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((o)localObject5).video_url));
        }
        if (!TextUtils.isEmpty(((o)localObject5).aik)) {
          ((articlesummary.PGCVideoInfo)localObject6).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((o)localObject5).aik));
        }
        if (!TextUtils.isEmpty(((o)localObject5).pic_md5)) {
          ((articlesummary.PGCVideoInfo)localObject6).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((o)localObject5).pic_md5));
        }
        if (!TextUtils.isEmpty(((o)localObject5).pic_url)) {
          ((articlesummary.PGCVideoInfo)localObject6).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((o)localObject5).pic_url));
        }
        ((List)localObject3).add(localObject6);
      }
      ((articlesummary.PGCFeedsInfo)localObject2).msg_pgc_video_info_list.set((List)localObject3);
      ((articlesummary.PGCFeedsInfo)localObject2).enum_pgc_feeds_type.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.aSW);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a == null) {
        break label2944;
      }
      localObject3 = new articlesummary.GalleryPGCFeedsInfo();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a.vN == -1L) {
        break label2532;
      }
      ((articlesummary.GalleryPGCFeedsInfo)localObject3).uint64_pic_count.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a.vN);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a.source == -1L) {
        break label2567;
      }
      ((articlesummary.GalleryPGCFeedsInfo)localObject3).uint64_source.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a.source);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a.vO == -1L) {
        break label2602;
      }
      ((articlesummary.GalleryPGCFeedsInfo)localObject3).uint64_sub_source.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a.vO);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a.ahW)) {
        break label2639;
      }
      ((articlesummary.GalleryPGCFeedsInfo)localObject3).bytes_gallery_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a.ahW));
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a.kY == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a.kY.size() <= 0)) {
        break label2935;
      }
      localObject4 = new ArrayList();
      localObject5 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m.a.kY.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (n)((Iterator)localObject5).next();
        localObject7 = new articlesummary.PGCPicInfo();
        if (((n)localObject6).pic_width != -1) {
          ((articlesummary.PGCPicInfo)localObject7).uint32_pic_width.set(((n)localObject6).pic_width);
        }
        if (((n)localObject6).pic_height != -1) {
          ((articlesummary.PGCPicInfo)localObject7).uint32_pic_height.set(((n)localObject6).pic_height);
        }
        if (!TextUtils.isEmpty(((n)localObject6).pic_md5)) {
          ((articlesummary.PGCPicInfo)localObject7).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((n)localObject6).pic_md5));
        }
        if (!TextUtils.isEmpty(((n)localObject6).pic_url)) {
          ((articlesummary.PGCPicInfo)localObject7).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((n)localObject6).pic_url));
        }
        if (!TextUtils.isEmpty(((n)localObject6).aii)) {
          ((articlesummary.PGCPicInfo)localObject7).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((n)localObject6).aii));
        }
        if (((n)localObject6).aSX != -1) {
          ((articlesummary.PGCPicInfo)localObject7).is_animation.set(((n)localObject6).aSX);
        }
        if (!TextUtils.isEmpty(((n)localObject6).aij)) {
          ((articlesummary.PGCPicInfo)localObject7).bytes_pic_desc.set(ByteStringMicro.copyFromUtf8(((n)localObject6).aij));
        }
        if (((n)localObject6).vP != -1L) {
          ((articlesummary.PGCPicInfo)localObject7).uint64_gallery_index.set(((n)localObject6).vP);
        }
        ((List)localObject4).add(localObject7);
      }
      ((articlesummary.PGCFeedsInfo)localObject2).msg_gallery_feeds_info.set((MessageMicro)localObject3);
      localSocializeFeedsInfo.msg_pgc_topic_feeds_info.set((MessageMicro)localObject2);
      if (this.mTopicRecommendFeedsInfo == null) {
        break label2973;
      }
      localSocializeFeedsInfo.msg_topic_recommend_feeds_info.set(this.mTopicRecommendFeedsInfo.a());
      if (this.ahO == null) {
        break label2994;
      }
      localSocializeFeedsInfo.bytes_recommend_account_reason.set(ByteStringMicro.copyFromUtf8(this.ahO));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u == null) {
        break label3015;
      }
      localSocializeFeedsInfo.wenda_info.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.a());
      localSocializeFeedsInfo.uint32_is_origin_feeds_deleted.set(this.aSL);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$h == null) {
        break label3047;
      }
      localSocializeFeedsInfo.icon_wording_info.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$h.a());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i == null) {
        break label3166;
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g != null)
    {
      localObject1 = new articlesummary.GameLiveInfo();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.ahX)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_play_bill_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.ahX));
      }
      ((articlesummary.GameLiveInfo)localObject1).uint32_status.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.status);
      ((articlesummary.GameLiveInfo)localObject1).uint32_audience_count.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.aSQ);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.gameName)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_game_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.gameName));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.playUrl)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_play_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.playUrl));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.tipsWording)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.tipsWording));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.ahZ)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_status.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.ahZ));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.agW)) {
        ((articlesummary.GameLiveInfo)localObject1).bytes_status_icon_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$g.agW));
      }
      localSocializeFeedsInfo.game_live_info.set((MessageMicro)localObject1);
    }
    localSocializeFeedsInfo.uint64_article_id.set(this.rX);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r != null)
    {
      localObject1 = new articlesummary.UGCFeedsInfo();
      ((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_card_type.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa);
      ((articlesummary.UGCFeedsInfo)localObject1).enum_ugc_feeds_src.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTb);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.ail)) {
        ((articlesummary.UGCFeedsInfo)localObject1).bytes_ugc_comments.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.ail));
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b != null) {
        ((articlesummary.UGCFeedsInfo)localObject1).msg_at_multi_level.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.b.a());
      }
      ((articlesummary.UGCFeedsInfo)localObject1).uint64_cuin.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.size() > 0))
      {
        localObject3 = new ArrayList();
        localObject4 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.la.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (s)((Iterator)localObject4).next();
          localObject6 = new articlesummary.UGCPicInfo();
          ((articlesummary.UGCPicInfo)localObject6).uint32_pic_width.set(((s)localObject5).pic_width);
          ((articlesummary.UGCPicInfo)localObject6).uint32_pic_height.set(((s)localObject5).pic_height);
          if (!TextUtils.isEmpty(((s)localObject5).pic_url)) {
            ((articlesummary.UGCPicInfo)localObject6).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((s)localObject5).pic_url));
          }
          if (!TextUtils.isEmpty(((s)localObject5).pic_md5)) {
            ((articlesummary.UGCPicInfo)localObject6).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((s)localObject5).pic_md5));
          }
          if (!TextUtils.isEmpty(((s)localObject5).aii)) {
            ((articlesummary.UGCPicInfo)localObject6).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((s)localObject5).aii));
          }
          ((articlesummary.UGCPicInfo)localObject6).is_animation.set(((s)localObject5).aSX);
          ((List)localObject3).add(localObject6);
        }
      }
    }
    label1438:
    label1588:
    label1615:
    label1645:
    label2935:
    localObject3 = new feeds_info.LocationInfo();
    label1698:
    label1716:
    label1741:
    label1766:
    label3047:
    Object localObject4 = ((feeds_info.LocationInfo)localObject3).bytes_name;
    label2259:
    label2532:
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i.name))
    {
      localObject2 = "";
      ((PBBytesField)localObject4).set(ByteStringMicro.copyFromUtf8((String)localObject2));
      ((feeds_info.LocationInfo)localObject3).uint32_longitude.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i.longitude);
      ((feeds_info.LocationInfo)localObject3).uint32_latitude.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i.latitude);
      localObject4 = ((feeds_info.LocationInfo)localObject3).bytes_icon_url;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i.iconUrl)) {
        break label3695;
      }
    }
    label2464:
    label2602:
    label2639:
    label3166:
    label3695:
    for (Object localObject2 = "";; localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i.iconUrl)
    {
      ((PBBytesField)localObject4).set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localSocializeFeedsInfo.location_info.set((MessageMicro)localObject3);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p != null)
      {
        localObject2 = new feeds_info.VisibleInfo();
        localObject3 = new feeds_info.VisibleShowInfo();
        ((feeds_info.VisibleShowInfo)localObject3).uint32_visible_type.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p.aSZ);
        ((feeds_info.VisibleShowInfo)localObject3).uint64_feed_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p.vd);
        ((feeds_info.VisibleShowInfo)localObject3).uint64_who.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$p.vR);
        ((feeds_info.VisibleInfo)localObject2).visible_show_info.set((MessageMicro)localObject3);
        localSocializeFeedsInfo.visible_info.set((MessageMicro)localObject2);
      }
      localSocializeFeedsInfo.uint32_feed_status.set(this.aSM);
      if (!TextUtils.isEmpty(this.ahP)) {
        localSocializeFeedsInfo.bytes_private_status_title.set(ByteStringMicro.copyFromUtf8(this.ahP));
      }
      if (this.ahQ != null)
      {
        localSocializeFeedsInfo.uint32_is_jump_recommend_page.set(this.aSN);
        localSocializeFeedsInfo.bytes_jump_recommend_url.set(ByteStringMicro.copyFromUtf8(this.ahQ));
      }
      if (this.ahR != null) {
        localSocializeFeedsInfo.bytes_jump_recommend_prompt.set(ByteStringMicro.copyFromUtf8(this.ahR));
      }
      if (this.b != null)
      {
        localObject2 = new ArrayList();
        localObject3 = new oidb_cmd0xb57.MedalInfo();
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint32_pic_width.set(this.b.mPicHeight);
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint32_pic_height.set(this.b.mPicWidth);
        ((oidb_cmd0xb57.MedalInfo)localObject3).bytes_medal_url.set(ByteStringMicro.copyFromUtf8(this.b.Zb));
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint64_medal_id.set(this.b.rU);
        ((oidb_cmd0xb57.MedalInfo)localObject3).bytes_medal_name.set(ByteStringMicro.copyFromUtf8(this.b.Za));
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint32_is_jump.set(this.b.aIC);
        ((oidb_cmd0xb57.MedalInfo)localObject3).bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.b.mJumpUrl));
        ((oidb_cmd0xb57.MedalInfo)localObject3).uint32_medal_type.set(this.b.aIB);
        ((List)localObject2).add(localObject3);
        localSocializeFeedsInfoUser.rpt_msg_medal_info.set((List)localObject2);
      }
      if ((localSocializeFeedsInfo.buluo_info.has()) && (localSocializeFeedsInfo.buluo_info.get() != null))
      {
        localObject2 = new feeds_info.BuluoInfo();
        ((feeds_info.BuluoInfo)localObject2).bytes_wording.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d.wording));
        ((feeds_info.BuluoInfo)localObject2).bytes_head_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d.headUrl));
        ((feeds_info.BuluoInfo)localObject2).bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d.jumpUrl));
        ((feeds_info.BuluoInfo)localObject2).bytes_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d.name));
        ((feeds_info.BuluoInfo)localObject2).uint64_buluo_id.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$d.bid);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$j.a();
        localSocializeFeedsInfo.long_content_info.set((MessageMicro)localObject2);
      }
      if (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo != null) {
        localSocializeFeedsInfo.msg_column_topic_info.set(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo);
      }
      if (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo != null) {
        localSocializeFeedsInfo.msg_topic_entrance_info.set(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo);
      }
      return localSocializeFeedsInfo.toByteArray();
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$i.name;
      break;
    }
  }
  
  public c a(articlesummary.BiuMultiLevel paramBiuMultiLevel)
  {
    c localc = new c();
    localc.y = Long.valueOf(a(paramBiuMultiLevel.uint64_origin_feeds_id));
    localc.z = Long.valueOf(a(paramBiuMultiLevel.uint64_origin_feeds_type));
    if ((paramBiuMultiLevel.rpt_biu_mutli_level.has()) && (paramBiuMultiLevel.rpt_biu_mutli_level.get() != null))
    {
      paramBiuMultiLevel = paramBiuMultiLevel.rpt_biu_mutli_level.get().iterator();
      while (paramBiuMultiLevel.hasNext())
      {
        articlesummary.BiuOneLevelItem localBiuOneLevelItem = (articlesummary.BiuOneLevelItem)paramBiuMultiLevel.next();
        localc.iT.add(a(localBiuOneLevelItem));
      }
    }
    QLog.d("SocializeFeedsInfo", 1, new Object[] { "convertPb2BiuInfo, mFeedsId =  ", Long.valueOf(this.mFeedId), ", mOriFeedType = ", localc.z });
    return localc;
  }
  
  public SocializeFeedsInfo a()
  {
    try
    {
      localSocializeFeedsInfo1 = (SocializeFeedsInfo)super.clone();
      try
      {
        localSocializeFeedsInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.a();
        localSocializeFeedsInfo1.iS = new ArrayList();
        Iterator localIterator = this.iS.iterator();
        while (localIterator.hasNext())
        {
          e locale = (e)localIterator.next();
          localSocializeFeedsInfo1.iS.add(locale.a());
        }
        QLog.d("SocializeFeedsInfo", 1, "clone SocializeFeedsInfo failed ", localCloneNotSupportedException1);
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1) {}
    }
    catch (CloneNotSupportedException localCloneNotSupportedException2)
    {
      for (;;)
      {
        SocializeFeedsInfo localSocializeFeedsInfo2;
        SocializeFeedsInfo localSocializeFeedsInfo1 = null;
      }
    }
    localSocializeFeedsInfo2 = localSocializeFeedsInfo1;
    do
    {
      return localSocializeFeedsInfo2;
      localSocializeFeedsInfo2 = localSocializeFeedsInfo1;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c == null);
    localSocializeFeedsInfo1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c.a();
    return localSocializeFeedsInfo1;
  }
  
  public void a(oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    if (paramSocializeFeedsInfo == null) {
      return;
    }
    this.mLikeCount = a(paramSocializeFeedsInfo.uint32_like_count);
    this.mCommentCount = a(paramSocializeFeedsInfo.uint32_comments_count);
    this.aSH = a(paramSocializeFeedsInfo.uint32_myself_like_status);
    this.aSI = a(paramSocializeFeedsInfo.uint32_biu_count);
    this.aSJ = a(paramSocializeFeedsInfo.uint32_myself_biu_status);
    if (paramSocializeFeedsInfo.uint32_follow_count.has()) {
      this.aSK = a(paramSocializeFeedsInfo.uint32_follow_count);
    }
    if (paramSocializeFeedsInfo.uint32_follow_status.has()) {
      this.mFollowStatus = a(paramSocializeFeedsInfo.uint32_follow_status);
    }
    this.iS.clear();
    Object localObject1;
    Object localObject2;
    if ((paramSocializeFeedsInfo.rpt_recommend_list.has()) && (paramSocializeFeedsInfo.rpt_recommend_list.get() != null))
    {
      localObject1 = paramSocializeFeedsInfo.rpt_recommend_list.get().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (oidb_cmd0x8c8.SocializeFeedsInfoUser)((Iterator)localObject1).next();
        e locale = new e();
        if ((((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).has()) && (((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).get() != null)) {}
        for (long l = a(((oidb_cmd0x8c8.SocializeFeedsInfoUser)localObject2).uint64_uin);; l = 0L)
        {
          locale.uin = l;
          this.iS.add(locale);
          break;
        }
      }
    }
    if ((paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) && (this.mTopicRecommendFeedsInfo != null) && (this.mTopicRecommendFeedsInfo.ld != null))
    {
      paramSocializeFeedsInfo = (oidb_cmd0x8c8.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get();
      if (paramSocializeFeedsInfo.msg_topic_recommend_info.has())
      {
        paramSocializeFeedsInfo = paramSocializeFeedsInfo.msg_topic_recommend_info.get();
        int i = 0;
        while ((i < paramSocializeFeedsInfo.size()) && (i < this.mTopicRecommendFeedsInfo.ld.size()))
        {
          localObject1 = (oidb_cmd0x8c8.TopicRecommendInfo)paramSocializeFeedsInfo.get(i);
          localObject2 = (mih.b)this.mTopicRecommendFeedsInfo.ld.get(i);
          if (((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.has()) {
            ((mih.b)localObject2).aTk = ((oidb_cmd0x8c8.TopicRecommendInfo)localObject1).uint32_number_of_participants.get();
          }
          i += 1;
        }
      }
    }
    QLog.d("SocializeFeedsInfo", 2, "8c8 update followStatus : " + this.mFollowStatus + ", followCnt : " + this.mFollowStatus + ", feedsID : " + this.mFeedId);
  }
  
  public String toString()
  {
    return "SocializeFeedsInfo{mFeedStyle=" + this.aSG + ", mRecommUinList=" + this.iS + ", mLikeCount=" + this.mLikeCount + ", mLikeStatus=" + this.aSH + ", mCommentCount=" + this.mCommentCount + ", mBiuTime=" + this.aRW + ", mCommentWording='" + this.ahL + '\'' + ", mRecommReason='" + this.ahN + '\'' + ", mRecommendAccountReason='" + this.ahO + '\'' + ", mMasterUser.uin='" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin + '\'' + ", mMasterUser.type='" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.type + '\'' + ", mMasterUser.starType='" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.starType + '\'' + ", mBiuCount='" + this.aSI + '\'' + ", mBiuStatus='" + this.aSJ + '\'' + ", mBiuInfo='" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c + '\'' + ", mFollowStatus='" + this.mFollowStatus + '\'' + ", mFollowCnt='" + this.aSK + '\'' + ", mIsOriginFeedsDeleted='" + this.aSL + '\'' + ", mFeedStatus='" + this.aSM + '\'' + ", mPrivateStatusTitle='" + this.ahP + '\'' + ", mIs_jump_recommend_page='" + this.aSN + '\'' + ", mJump_recommend__url='" + this.ahQ + '\'' + ", mJump_recommend__prompt='" + this.ahR + '\'' + ", mPGCFeedsInfo=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$m + ", mUGCFeedsInfo=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r + '}';
  }
  
  public static class BiuCommentInfo
    implements Parcelable, Cloneable
  {
    public static final Parcelable.Creator<BiuCommentInfo> CREATOR = new mib();
    public SocializeFeedsInfo.JumpInfo a;
    public int aLh = 1;
    public int aRW;
    public int aSO = 0;
    public String ahU;
    public String ahj;
    public SocializeFeedsInfo.UGCVoiceInfo b;
    public Long i;
    public Long x;
    
    public BiuCommentInfo() {}
    
    public BiuCommentInfo(Parcel paramParcel)
    {
      this.aRW = paramParcel.readInt();
      this.i = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
      this.x = ((Long)paramParcel.readValue(Long.class.getClassLoader()));
      this.ahj = paramParcel.readString();
      this.ahU = paramParcel.readString();
      this.aLh = paramParcel.readInt();
      this.a = ((SocializeFeedsInfo.JumpInfo)paramParcel.readParcelable(SocializeFeedsInfo.JumpInfo.class.getClassLoader()));
      this.aSO = paramParcel.readInt();
      this.b = ((SocializeFeedsInfo.UGCVoiceInfo)paramParcel.readParcelable(SocializeFeedsInfo.UGCVoiceInfo.class.getClassLoader()));
    }
    
    public BiuCommentInfo(Long paramLong1, Long paramLong2, String paramString)
    {
      this.i = paramLong1;
      this.x = paramLong2;
      this.ahj = paramString;
    }
    
    public BiuCommentInfo(String paramString1, Long paramLong, String paramString2)
    {
      try
      {
        this.i = Long.valueOf(paramString1);
        this.x = paramLong;
        this.ahj = paramString2;
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          this.i = Long.valueOf(0L);
        }
      }
    }
    
    public BiuCommentInfo(String paramString1, Long paramLong, String paramString2, int paramInt)
    {
      this(paramString1, paramLong, paramString2);
      this.aSO = paramInt;
    }
    
    public BiuCommentInfo(String paramString1, Long paramLong, String paramString2, int paramInt, SocializeFeedsInfo.JumpInfo paramJumpInfo)
    {
      this(paramString1, paramLong, paramString2, paramInt);
      this.a = paramJumpInfo;
    }
    
    public BiuCommentInfo a()
    {
      try
      {
        BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)super.clone();
        return localBiuCommentInfo;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return null;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      return "biuTime=" + this.aRW + "uin=" + this.i + "feedId=" + this.x + "comment=" + this.ahj + "feedsType=" + this.aLh;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.aRW);
      paramParcel.writeValue(this.i);
      paramParcel.writeValue(this.x);
      paramParcel.writeString(this.ahj);
      paramParcel.writeString(this.ahU);
      paramParcel.writeInt(this.aLh);
      paramParcel.writeParcelable(this.a, paramInt);
      paramParcel.writeInt(this.aSO);
      paramParcel.writeParcelable(this.b, paramInt);
    }
  }
  
  public static class JumpInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<JumpInfo> CREATOR = new mic();
    private final long id;
    private final String jumpUrl;
    private final String wording;
    
    public JumpInfo(long paramLong, String paramString1, String paramString2)
    {
      this.id = paramLong;
      this.wording = paramString1;
      this.jumpUrl = paramString2;
    }
    
    public JumpInfo(Parcel paramParcel)
    {
      this.id = paramParcel.readLong();
      this.wording = paramParcel.readString();
      this.jumpUrl = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public long getId()
    {
      return this.id;
    }
    
    public String getJumpUrl()
    {
      if (this.jumpUrl != null) {
        return this.jumpUrl;
      }
      return "";
    }
    
    public String iZ()
    {
      if (this.wording != null) {
        return this.wording;
      }
      return "";
    }
    
    public String toString()
    {
      return "JumpInfo{id=" + this.id + ", wording='" + this.wording + '\'' + ", jumpUrl='" + this.jumpUrl + '\'' + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.id);
      paramParcel.writeString(this.wording);
      paramParcel.writeString(this.jumpUrl);
    }
  }
  
  public static class UGCVoiceInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<UGCVoiceInfo> CREATOR = new mid();
    public int duration;
    public int fileSize;
    public boolean isPlaying;
    public String voiceUrl;
    
    protected UGCVoiceInfo() {}
    
    public UGCVoiceInfo(Parcel paramParcel)
    {
      this.voiceUrl = paramParcel.readString();
      this.duration = paramParcel.readInt();
      this.fileSize = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.voiceUrl);
      paramParcel.writeInt(this.duration);
      paramParcel.writeInt(this.fileSize);
    }
  }
  
  public static class a
  {
    public String accountNick;
    public int accountType;
    public String ahS;
    public String ahT;
    public String homePageUrl;
    public long vM;
    
    public static a a(feeds_info.AccountProfile paramAccountProfile)
    {
      Object localObject;
      if (paramAccountProfile == null) {
        localObject = null;
      }
      a locala;
      do
      {
        return localObject;
        locala = new a();
        locala.vM = paramAccountProfile.uint64_uin.get();
        locala.accountType = paramAccountProfile.uint32_account_type.get();
        if (paramAccountProfile.bytes_desc.has()) {
          locala.ahT = paramAccountProfile.bytes_desc.get().toStringUtf8();
        }
        if (paramAccountProfile.bytes_profile_photo_url.has()) {
          locala.ahS = paramAccountProfile.bytes_profile_photo_url.get().toStringUtf8();
        }
        if (paramAccountProfile.bytes_nick.has()) {
          locala.accountNick = paramAccountProfile.bytes_nick.get().toStringUtf8();
        }
        localObject = locala;
      } while (!paramAccountProfile.bytes_home_page_url.has());
      locala.homePageUrl = paramAccountProfile.bytes_home_page_url.get().toStringUtf8();
      return locala;
    }
    
    public feeds_info.AccountProfile a()
    {
      feeds_info.AccountProfile localAccountProfile = new feeds_info.AccountProfile();
      if (!TextUtils.isEmpty(this.accountNick)) {
        localAccountProfile.bytes_nick.set(ByteStringMicro.copyFromUtf8(this.accountNick));
      }
      if (!TextUtils.isEmpty(this.ahS)) {
        localAccountProfile.bytes_profile_photo_url.set(ByteStringMicro.copyFromUtf8(this.ahS));
      }
      if (!TextUtils.isEmpty(this.ahT)) {
        localAccountProfile.bytes_desc.set(ByteStringMicro.copyFromUtf8(this.ahT));
      }
      if (!TextUtils.isEmpty(this.homePageUrl)) {
        localAccountProfile.bytes_home_page_url.set(ByteStringMicro.copyFromUtf8(this.homePageUrl));
      }
      localAccountProfile.uint32_account_type.set(this.accountType);
      localAccountProfile.uint64_uin.set(this.vM);
      return localAccountProfile;
    }
  }
  
  public static class b
  {
    public String jumpUrl;
    public ArrayList<articlesummary.PGCPicInfo> kX;
    public String rowKey;
    public String title;
    
    public b(articlesummary.ArticleBasicInfo paramArticleBasicInfo)
    {
      if (paramArticleBasicInfo.rowkey.has()) {
        this.rowKey = paramArticleBasicInfo.rowkey.get();
      }
      if (paramArticleBasicInfo.title.has()) {
        this.title = paramArticleBasicInfo.title.get();
      }
      if (paramArticleBasicInfo.jump_url.has()) {
        this.jumpUrl = paramArticleBasicInfo.jump_url.get();
      }
      this.kX = new ArrayList();
      if (paramArticleBasicInfo.msg_pgc_pic_info_list.has()) {
        this.kX.addAll(paramArticleBasicInfo.msg_pgc_pic_info_list.get());
      }
    }
    
    public articlesummary.ArticleBasicInfo a()
    {
      articlesummary.ArticleBasicInfo localArticleBasicInfo = new articlesummary.ArticleBasicInfo();
      if (!TextUtils.isEmpty(this.rowKey)) {
        localArticleBasicInfo.rowkey.set(this.rowKey);
      }
      if (!TextUtils.isEmpty(this.title)) {
        localArticleBasicInfo.title.set(this.title);
      }
      if (!TextUtils.isEmpty(this.jumpUrl)) {
        localArticleBasicInfo.jump_url.set(this.jumpUrl);
      }
      if (this.kX != null)
      {
        Iterator localIterator = this.kX.iterator();
        while (localIterator.hasNext())
        {
          articlesummary.PGCPicInfo localPGCPicInfo1 = (articlesummary.PGCPicInfo)localIterator.next();
          articlesummary.PGCPicInfo localPGCPicInfo2 = new articlesummary.PGCPicInfo();
          localPGCPicInfo2.setHasFlag(true);
          localPGCPicInfo2.bytes_pic_md5.set(localPGCPicInfo1.bytes_pic_md5.get());
          localPGCPicInfo2.bytes_pic_desc.set(localPGCPicInfo1.bytes_pic_desc.get());
          localPGCPicInfo2.bytes_pic_url.set(localPGCPicInfo1.bytes_pic_url.get());
          localPGCPicInfo2.bytes_thumbnail_url.set(localPGCPicInfo1.bytes_thumbnail_url.get());
          localPGCPicInfo2.is_animation.set(localPGCPicInfo1.is_animation.get());
          localPGCPicInfo2.uint32_pic_height.set(localPGCPicInfo1.uint32_pic_height.get());
          localPGCPicInfo2.uint32_pic_width.set(localPGCPicInfo1.uint32_pic_width.get());
          localArticleBasicInfo.msg_pgc_pic_info_list.add(localPGCPicInfo1);
        }
      }
      return localArticleBasicInfo;
    }
  }
  
  public static class c
    implements Cloneable
  {
    public List<SocializeFeedsInfo.BiuCommentInfo> iT = new ArrayList();
    public Long y;
    public Long z;
    
    public SpannableStringBuilder a(ArticleInfo paramArticleInfo, String paramString, ReadInJoyUserInfoModule.a parama)
    {
      return SocializeFeedsInfo.a(paramArticleInfo, paramString, parama, this.iT);
    }
    
    public c a()
    {
      try
      {
        c localc = (c)super.clone();
        try
        {
          localc.iT = new ArrayList();
          Iterator localIterator = this.iT.iterator();
          while (localIterator.hasNext())
          {
            SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localIterator.next();
            localc.iT.add(localBiuCommentInfo.a());
          }
          return localc;
        }
        catch (CloneNotSupportedException localCloneNotSupportedException2) {}
        return null;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1) {}
    }
    
    public articlesummary.BiuMultiLevel a()
    {
      articlesummary.BiuMultiLevel localBiuMultiLevel = new articlesummary.BiuMultiLevel();
      if (this.y != null) {
        localBiuMultiLevel.uint64_origin_feeds_id.set(this.y.longValue());
      }
      if (this.z != null) {
        localBiuMultiLevel.uint64_origin_feeds_type.set(this.z.longValue());
      }
      if ((this.iT != null) && (this.iT.size() != 0))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.iT.iterator();
        while (localIterator.hasNext())
        {
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localIterator.next();
          articlesummary.BiuOneLevelItem localBiuOneLevelItem = new articlesummary.BiuOneLevelItem();
          localBiuOneLevelItem.uint32_biu_time.set(localBiuCommentInfo.aRW);
          localBiuOneLevelItem.uint64_uin.set(localBiuCommentInfo.i.longValue());
          if (localBiuCommentInfo.x != null) {
            localBiuOneLevelItem.uint64_feeds_id.set(localBiuCommentInfo.x.longValue());
          }
          if (!TextUtils.isEmpty(localBiuCommentInfo.ahU)) {
            localBiuOneLevelItem.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.ahU));
          }
          localBiuOneLevelItem.feeds_type.set(localBiuCommentInfo.aLh);
          localBiuOneLevelItem.op_type.set(localBiuCommentInfo.aSO);
          if (localBiuCommentInfo.a != null)
          {
            localBiuOneLevelItem.msg_jump_info.set(new articlesummary.JumpInfo());
            localBiuOneLevelItem.msg_jump_info.uint64_id.set(localBiuCommentInfo.a.getId());
            localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.a.getJumpUrl()));
            localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.a.iZ()));
          }
          localArrayList.add(localBiuOneLevelItem);
        }
        localBiuMultiLevel.rpt_biu_mutli_level.set(localArrayList);
      }
      return localBiuMultiLevel;
    }
    
    public feeds_info.BiuMultiLevel a()
    {
      feeds_info.BiuMultiLevel localBiuMultiLevel = new feeds_info.BiuMultiLevel();
      if (this.y != null) {
        localBiuMultiLevel.uint64_origin_feeds_id.set(this.y.longValue());
      }
      if (this.z != null) {
        localBiuMultiLevel.uint64_origin_feeds_type.set(this.z.longValue());
      }
      if ((this.iT != null) && (this.iT.size() != 0))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.iT.iterator();
        while (localIterator.hasNext())
        {
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localIterator.next();
          feeds_info.BiuOneLevelItem localBiuOneLevelItem = new feeds_info.BiuOneLevelItem();
          localBiuOneLevelItem.uint32_biu_time.set(localBiuCommentInfo.aRW);
          localBiuOneLevelItem.uint64_uin.set(localBiuCommentInfo.i.longValue());
          if (localBiuCommentInfo.x != null) {
            localBiuOneLevelItem.uint64_feeds_id.set(localBiuCommentInfo.x.longValue());
          }
          if (!TextUtils.isEmpty(localBiuCommentInfo.ahU)) {
            localBiuOneLevelItem.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.ahU));
          }
          localBiuOneLevelItem.feeds_type.set(localBiuCommentInfo.aLh);
          localBiuOneLevelItem.op_type.set(localBiuCommentInfo.aSO);
          if (localBiuCommentInfo.a != null)
          {
            localBiuOneLevelItem.msg_jump_info.set(new feeds_info.JumpInfo());
            localBiuOneLevelItem.msg_jump_info.uint64_id.set(localBiuCommentInfo.a.getId());
            localBiuOneLevelItem.msg_jump_info.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.a.getJumpUrl()));
            localBiuOneLevelItem.msg_jump_info.bytes_wording.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.a.iZ()));
          }
          if (localBiuCommentInfo.b != null)
          {
            localBiuOneLevelItem.msg_voice_info.set(new feeds_info.UGCVoiceInfo());
            localBiuOneLevelItem.msg_voice_info.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.b.voiceUrl));
            localBiuOneLevelItem.msg_voice_info.uint32_duration.set(localBiuCommentInfo.b.duration);
            localBiuOneLevelItem.msg_voice_info.uint32_file_size.set(localBiuCommentInfo.b.fileSize);
          }
          localArrayList.add(localBiuOneLevelItem);
        }
        localBiuMultiLevel.rpt_biu_mutli_level.set(localArrayList);
      }
      return localBiuMultiLevel;
    }
    
    public CharSequence e()
    {
      List localList = this.iT;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      int i = localList.size();
      String str = ((SocializeFeedsInfo.BiuCommentInfo)localList.get(i - 1)).ahj;
      Object localObject;
      label84:
      SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo;
      if ((!TextUtils.isEmpty(str)) && ((str.startsWith(":")) || (str.startsWith("："))))
      {
        localObject = str.substring(1);
        localSpannableStringBuilder.append((CharSequence)localObject);
        i -= 2;
        if (i < 0) {
          break label332;
        }
        localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
        switch (localBiuCommentInfo.aSO)
        {
        default: 
          localObject = ReadInJoyUserInfoModule.a(localBiuCommentInfo.i.longValue(), null);
          if (localObject != null)
          {
            localObject = ((ReadInJoyUserInfo)localObject).nick;
            label150:
            str = "@" + (String)localObject;
            localObject = str;
            if (localBiuCommentInfo.aSO == 1) {
              localObject = str + " ";
            }
            if (localBiuCommentInfo.ahj != null) {
              break label323;
            }
          }
          break;
        }
      }
      label269:
      label307:
      label323:
      for (str = "";; str = localBiuCommentInfo.ahj)
      {
        localSpannableStringBuilder.append((CharSequence)localObject).append(str);
        do
        {
          i -= 1;
          break label84;
          localObject = str;
          if (str != null) {
            break;
          }
          localObject = "";
          break;
        } while (localBiuCommentInfo.a == null);
        if (SocializeFeedsInfo.JumpInfo.a(localBiuCommentInfo.a) == null)
        {
          localObject = "";
          if (localBiuCommentInfo.ahj != null) {
            break label307;
          }
        }
        for (str = "";; str = localBiuCommentInfo.ahj)
        {
          localSpannableStringBuilder.append((CharSequence)localObject).append(str);
          break;
          localObject = SocializeFeedsInfo.JumpInfo.a(localBiuCommentInfo.a);
          break label269;
        }
        localObject = ReadInJoyUserInfoModule.getDefaultNickName();
        break label150;
      }
      label332:
      return localSpannableStringBuilder;
    }
    
    public String toString()
    {
      return "BiuInfo{oriFeedId=" + this.y + "BiuCommentList=" + this.iT + "oriFeedType" + this.z;
    }
  }
  
  public static class d
  {
    public long bid;
    public String headUrl;
    public String jumpUrl;
    public String name;
    public String wording;
  }
  
  public class e
    implements Cloneable
  {
    public int aSP = 1;
    public String ahV;
    public int starType;
    public int type;
    public long uin;
    
    public e() {}
    
    public boolean DD()
    {
      return this.starType == 1;
    }
    
    public e a()
    {
      try
      {
        e locale = (e)super.clone();
        return locale;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return null;
    }
    
    public String toString()
    {
      return "uin=" + this.uin + "type=" + this.type;
    }
  }
  
  public static class f
  {
    public String ahW;
    public ArrayList<SocializeFeedsInfo.n> kY = new ArrayList();
    public long source;
    public long vN;
    public long vO;
  }
  
  public static class g
  {
    public int aSQ;
    public String agW;
    public String ahX;
    public String ahY;
    public String ahZ;
    public String gameName;
    public String playUrl;
    public int status;
    public String tipsWording;
    
    public String toString()
    {
      return "GameLiveInfo{playBillId=" + this.ahX + ", status=" + this.status + ", audienceCount=" + this.aSQ + ", audiences=" + this.ahY + ", playUrl=" + this.playUrl + ", gameName=" + this.gameName + ", tipsWording=" + this.tipsWording + ", liveStatus=" + this.ahZ + ", statusIconUrl=" + this.agW + '}';
    }
  }
  
  public static class h
  {
    public int aSR;
    public String aia;
    public String aib;
    public String appIcon;
    public String appName;
    public int appType;
    public int status;
    
    public feeds_info.IconWordingInfo a()
    {
      feeds_info.IconWordingInfo localIconWordingInfo = new feeds_info.IconWordingInfo();
      localIconWordingInfo.uint32_type.set(this.appType);
      if (!TextUtils.isEmpty(this.appIcon)) {
        localIconWordingInfo.bytes_icon_url.set(ByteStringMicro.copyFromUtf8(this.appIcon));
      }
      if (!TextUtils.isEmpty(this.appName)) {
        localIconWordingInfo.bytes_wording.set(ByteStringMicro.copyFromUtf8(this.appName));
      }
      if (!TextUtils.isEmpty(this.aia)) {
        localIconWordingInfo.bytes_status_icon_url.set(ByteStringMicro.copyFromUtf8(this.aia));
      }
      localIconWordingInfo.uint32_status.set(this.status);
      localIconWordingInfo.uint32_icon_show_mode.set(this.aSR);
      if (!TextUtils.isEmpty(this.aib)) {
        localIconWordingInfo.bytes_status.set(ByteStringMicro.copyFromUtf8(this.aib));
      }
      return localIconWordingInfo;
    }
  }
  
  public static class i
    implements Cloneable
  {
    public String iconUrl;
    public int latitude;
    public int longitude;
    public String name;
    
    public i a()
    {
      try
      {
        i locali = (i)super.clone();
        return locali;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return null;
    }
  }
  
  public static class j
  {
    public SocializeFeedsInfo.b a;
    public SocializeFeedsInfo.l a;
    public int aSS;
    public SocializeFeedsInfo.o b;
    
    public j() {}
    
    public j(articlesummary.LongContentInfo paramLongContentInfo)
    {
      this.aSS = paramLongContentInfo.enum_long_content_card_type.get();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$b = new SocializeFeedsInfo.b(paramLongContentInfo.msg_article_basic_ingo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$l = new SocializeFeedsInfo.l(paramLongContentInfo.msg_outside_link_info);
      this.b = new SocializeFeedsInfo.o(paramLongContentInfo.msg_pgc_video_info);
    }
    
    public articlesummary.LongContentInfo a()
    {
      articlesummary.LongContentInfo localLongContentInfo = new articlesummary.LongContentInfo();
      localLongContentInfo.enum_long_content_card_type.set(this.aSS);
      localLongContentInfo.msg_article_basic_ingo.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$b.a());
      localLongContentInfo.msg_outside_link_info.set(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$l.a());
      localLongContentInfo.msg_pgc_video_info.set(this.b.a());
      localLongContentInfo.setHasFlag(true);
      return localLongContentInfo;
    }
  }
  
  public static class k
  {
    private a a = new a();
    private int msgType;
    private int timestamp;
    
    public feeds_info.NowLiveInfo a()
    {
      feeds_info.NowLiveInfo localNowLiveInfo = new feeds_info.NowLiveInfo();
      localNowLiveInfo.msg_type.set(this.msgType);
      localNowLiveInfo.uint32_timestamp.set(this.timestamp);
      nowlive.MixInfo localMixInfo = new nowlive.MixInfo();
      Object localObject = new nowlive.AnchorInfo();
      ((nowlive.AnchorInfo)localObject).fans.set(SocializeFeedsInfo.k.a.a.a(a.a(this.a)));
      ((nowlive.AnchorInfo)localObject).status.set(SocializeFeedsInfo.k.a.a.a(a.a(this.a)));
      ((nowlive.AnchorInfo)localObject).uin.set(SocializeFeedsInfo.k.a.a.b(a.a(this.a)));
      localMixInfo.anchor_info.set((MessageMicro)localObject);
      localObject = new nowlive.LiveInfo();
      if (SocializeFeedsInfo.k.a.b.a(a.a(this.a)) != null) {
        ((nowlive.LiveInfo)localObject).live_url.set(SocializeFeedsInfo.k.a.b.a(a.a(this.a)));
      }
      if (SocializeFeedsInfo.k.a.b.b(a.a(this.a)) != null) {
        ((nowlive.LiveInfo)localObject).room_name.set(SocializeFeedsInfo.k.a.b.b(a.a(this.a)));
      }
      if (SocializeFeedsInfo.k.a.b.c(a.a(this.a)) != null) {
        ((nowlive.LiveInfo)localObject).room_cover.set(SocializeFeedsInfo.k.a.b.c(a.a(this.a)));
      }
      ((nowlive.LiveInfo)localObject).live_statue.set(SocializeFeedsInfo.k.a.b.a(a.a(this.a)));
      ((nowlive.LiveInfo)localObject).audience.set(SocializeFeedsInfo.k.a.b.b(a.a(this.a)));
      if (SocializeFeedsInfo.k.a.b.d(a.a(this.a)) != null)
      {
        ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(SocializeFeedsInfo.k.a.b.d(a.a(this.a))));
        localMixInfo.live_info.set((MessageMicro)localObject);
        localObject = new nowlive.VideoInfo();
        if (SocializeFeedsInfo.k.a.c.a(a.a(this.a)) != null) {
          ((nowlive.VideoInfo)localObject).video_url.set(SocializeFeedsInfo.k.a.c.a(a.a(this.a)));
        }
        if (SocializeFeedsInfo.k.a.c.b(a.a(this.a)) != null) {
          ((nowlive.VideoInfo)localObject).video_cover_url.set(SocializeFeedsInfo.k.a.c.b(a.a(this.a)));
        }
        if (SocializeFeedsInfo.k.a.c.c(a.a(this.a)) == null) {
          break label410;
        }
        ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(SocializeFeedsInfo.k.a.c.c(a.a(this.a))));
      }
      for (;;)
      {
        localMixInfo.video_info.set((MessageMicro)localObject);
        localNowLiveInfo.mix_info.set(localMixInfo);
        return localNowLiveInfo;
        ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.EMPTY);
        break;
        label410:
        ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.EMPTY);
      }
    }
    
    public void a(a parama)
    {
      this.a = parama;
    }
    
    public static class a
    {
      private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$k$a$a = new a(0L);
      private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$k$a$b = new b("");
      private c jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$k$a$c = new c("");
      
      public void a(a parama)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$k$a$a = parama;
      }
      
      public void a(b paramb)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$k$a$b = paramb;
      }
      
      public static class a
      {
        private long fansCount;
        private int status;
        private long uin;
        
        public a(long paramLong)
        {
          this.uin = paramLong;
        }
      }
      
      public static class b
      {
        private int aSQ;
        private int aST;
        private String aic;
        private String aie;
        private String aif;
        private String vid;
        
        public b(String paramString)
        {
          this.vid = paramString;
        }
      }
      
      public static class c
      {
        private String vid;
        private String videoCoverUrl;
        private String videoUrl;
        
        public c(String paramString)
        {
          this.vid = paramString;
        }
      }
    }
  }
  
  public static class l
  {
    public String aig;
    public String iconUrl;
    public String title;
    
    public l(articlesummary.OutsideLinkInfo paramOutsideLinkInfo)
    {
      if (paramOutsideLinkInfo.title.has()) {
        this.title = paramOutsideLinkInfo.title.get();
      }
      if (paramOutsideLinkInfo.bring_goods_url.has()) {
        this.aig = paramOutsideLinkInfo.bring_goods_url.get();
      }
      if (paramOutsideLinkInfo.icon_url.has()) {
        this.iconUrl = paramOutsideLinkInfo.icon_url.get();
      }
    }
    
    public articlesummary.OutsideLinkInfo a()
    {
      articlesummary.OutsideLinkInfo localOutsideLinkInfo = new articlesummary.OutsideLinkInfo();
      if (!TextUtils.isEmpty(this.iconUrl)) {
        localOutsideLinkInfo.icon_url.set(this.iconUrl);
      }
      if (!TextUtils.isEmpty(this.aig)) {
        localOutsideLinkInfo.bring_goods_url.set(this.aig);
      }
      if (!TextUtils.isEmpty(this.title)) {
        localOutsideLinkInfo.title.set(this.title);
      }
      return localOutsideLinkInfo;
    }
  }
  
  public static class m
  {
    public SocializeFeedsInfo.f a;
    public int aSU;
    public int aSV;
    public int aSW = 0;
    public String aih;
    public boolean amM;
    public ArrayList<SocializeFeedsInfo.n> kY = new ArrayList();
    public ArrayList<SocializeFeedsInfo.o> kZ = new ArrayList();
    
    private String jQ()
    {
      if (this.kY == null) {
        return null;
      }
      Iterator localIterator = this.kY.iterator();
      SocializeFeedsInfo.n localn;
      for (String str = "["; localIterator.hasNext(); str = str + "{" + localn.toString() + "},") {
        localn = (SocializeFeedsInfo.n)localIterator.next();
      }
      return str + "]";
    }
    
    private String jR()
    {
      if (this.kZ == null) {
        return null;
      }
      Iterator localIterator = this.kZ.iterator();
      SocializeFeedsInfo.o localo;
      for (String str = "["; localIterator.hasNext(); str = str + "{" + localo.toString() + "},") {
        localo = (SocializeFeedsInfo.o)localIterator.next();
      }
      return str + "]";
    }
    
    public String toString()
    {
      return "PGCFeedsInfo{pGCPicInfos=" + jQ() + ", pGCVideoInfos=" + jR() + ", pgc_comments='" + this.aih + '\'' + ", follow_count=" + this.aSU + ", follow_status=" + this.aSV + ", isShortContent=" + this.amM + ", pgcFeedsType=" + this.aSW + ", galleryPGCFeedsInfo=" + this.a + '}';
    }
  }
  
  public static class n
  {
    public int aSX;
    public String aii;
    public String aij;
    public SocializeFeedsInfo.o b;
    public int pic_height;
    public String pic_md5;
    public String pic_url;
    public int pic_width;
    public long vP;
    
    public String toString()
    {
      return "PGCPicInfo{pic_width=" + this.pic_width + ", pic_height=" + this.pic_height + ", pic_md5='" + this.pic_md5 + '\'' + ", pic_url='" + this.pic_url + '\'' + ", thumbnail_url='" + this.aii + '\'' + ", is_animation=" + this.aSX + ", picDesc='" + this.aij + '\'' + ", galleryIndex=" + this.vP + ", pgcVideoInfo=" + this.b + '}';
    }
  }
  
  public static class o
  {
    public int aSY;
    public String aik;
    public boolean amN;
    public int duration;
    public String jumpUrl;
    public String pic_md5;
    public String pic_url;
    public String rowkey;
    public String title;
    public long vQ;
    public String vid;
    public String video_url;
    
    public o() {}
    
    public o(articlesummary.PGCVideoInfo paramPGCVideoInfo)
    {
      if (paramPGCVideoInfo.bytes_pic_md5.has()) {
        this.pic_md5 = paramPGCVideoInfo.bytes_pic_md5.get().toStringUtf8();
      }
      if (paramPGCVideoInfo.bytes_pic_url.has()) {
        this.pic_url = paramPGCVideoInfo.bytes_pic_url.get().toStringUtf8();
      }
      if (paramPGCVideoInfo.bytes_vid.has()) {
        this.vid = paramPGCVideoInfo.bytes_vid.get().toStringUtf8();
      }
      if (paramPGCVideoInfo.bytes_video_url.has()) {
        this.video_url = paramPGCVideoInfo.bytes_video_url.get().toStringUtf8();
      }
      if (paramPGCVideoInfo.bytes_video_md5.has()) {
        this.aik = paramPGCVideoInfo.bytes_video_md5.get().toStringUtf8();
      }
      if (paramPGCVideoInfo.uint32_duration.has()) {
        this.duration = paramPGCVideoInfo.uint32_duration.get();
      }
      if (paramPGCVideoInfo.uint32_busi_type.has()) {
        this.aSY = paramPGCVideoInfo.uint32_busi_type.get();
      }
      if (paramPGCVideoInfo.uint64_play_num.has()) {
        this.vQ = paramPGCVideoInfo.uint64_play_num.get();
      }
      if (paramPGCVideoInfo.video_auto_play.has()) {
        this.amN = paramPGCVideoInfo.video_auto_play.get();
      }
      if (paramPGCVideoInfo.title.has()) {
        this.title = paramPGCVideoInfo.title.get();
      }
      if (paramPGCVideoInfo.rowkey.has()) {
        this.rowkey = paramPGCVideoInfo.rowkey.get();
      }
      if (paramPGCVideoInfo.jump_url.has()) {
        this.jumpUrl = paramPGCVideoInfo.jump_url.get();
      }
    }
    
    public articlesummary.PGCVideoInfo a()
    {
      articlesummary.PGCVideoInfo localPGCVideoInfo = new articlesummary.PGCVideoInfo();
      if (this.jumpUrl != null) {
        localPGCVideoInfo.jump_url.set(this.jumpUrl);
      }
      if (!TextUtils.isEmpty(this.aik)) {
        localPGCVideoInfo.bytes_video_md5.set(ByteStringMicro.copyFromUtf8(this.aik));
      }
      if (!TextUtils.isEmpty(this.vid)) {
        localPGCVideoInfo.bytes_vid.set(ByteStringMicro.copyFromUtf8(this.vid));
      }
      if (!TextUtils.isEmpty(this.rowkey)) {
        localPGCVideoInfo.rowkey.set(this.rowkey);
      }
      if (!TextUtils.isEmpty(this.title)) {
        localPGCVideoInfo.title.set(this.title);
      }
      localPGCVideoInfo.video_auto_play.set(this.amN);
      localPGCVideoInfo.uint64_play_num.set(this.vQ);
      localPGCVideoInfo.uint32_busi_type.set(this.aSY);
      if (!TextUtils.isEmpty(this.pic_md5)) {
        localPGCVideoInfo.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(this.pic_md5));
      }
      if (!TextUtils.isEmpty(this.pic_url)) {
        localPGCVideoInfo.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(this.pic_url));
      }
      if (!TextUtils.isEmpty(this.video_url)) {
        localPGCVideoInfo.bytes_video_url.set(ByteStringMicro.copyFromUtf8(this.video_url));
      }
      localPGCVideoInfo.uint32_duration.set(this.duration);
      return localPGCVideoInfo;
    }
    
    public String toString()
    {
      return "PGCVideoInfo{video_md5='" + this.aik + '\'' + ", video_url='" + this.video_url + '\'' + ", pic_md5='" + this.pic_md5 + '\'' + ", pic_url='" + this.pic_url + '\'' + ", vid='" + this.vid + '\'' + ", duration='" + this.duration + '\'' + ", busi_type='" + this.aSY + '\'' + ", playCount='" + this.vQ + '\'' + ", isVideoAutoPlay='" + this.amN + '\'' + ", rowkey='" + this.rowkey + '\'' + ", title='" + this.title + '\'' + ", jumpUrl='" + this.jumpUrl + '\'' + '}';
    }
  }
  
  public static class p
    implements Cloneable
  {
    public int aSZ = 0;
    public long vR;
    public long vd;
    
    public p a()
    {
      try
      {
        p localp = (p)super.clone();
        return localp;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException) {}
      return null;
    }
  }
  
  public static class q
  {
    public String coverUrl;
    public String desc;
    public String source;
    public String title;
    public String webUrl;
    
    public static q a(feeds_info.ShareWebPageInfo paramShareWebPageInfo)
    {
      if (paramShareWebPageInfo == null) {
        return null;
      }
      q localq = new q();
      if (paramShareWebPageInfo.bytes_desc.has()) {
        localq.desc = paramShareWebPageInfo.bytes_desc.get().toStringUtf8();
      }
      if (paramShareWebPageInfo.bytes_pic_url.has()) {
        localq.coverUrl = paramShareWebPageInfo.bytes_pic_url.get().toStringUtf8();
      }
      if (paramShareWebPageInfo.bytes_title.has()) {
        localq.title = paramShareWebPageInfo.bytes_title.get().toStringUtf8();
      }
      if (paramShareWebPageInfo.bytes_source.has()) {
        localq.source = paramShareWebPageInfo.bytes_source.get().toStringUtf8();
      }
      if (paramShareWebPageInfo.bytes_web_url.has()) {
        localq.webUrl = paramShareWebPageInfo.bytes_web_url.get().toStringUtf8();
      }
      if ((TextUtils.isEmpty(localq.source)) || (TextUtils.isEmpty(localq.webUrl)))
      {
        QLog.d("SocializeFeedsInfo", 1, "WebSharePageInfo core info is empty!");
        return null;
      }
      return localq;
    }
    
    public feeds_info.ShareWebPageInfo a()
    {
      feeds_info.ShareWebPageInfo localShareWebPageInfo = new feeds_info.ShareWebPageInfo();
      if (!TextUtils.isEmpty(this.webUrl)) {
        localShareWebPageInfo.bytes_web_url.set(ByteStringMicro.copyFromUtf8(this.webUrl));
      }
      if (!TextUtils.isEmpty(this.coverUrl)) {
        localShareWebPageInfo.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(this.coverUrl));
      }
      if (!TextUtils.isEmpty(this.title)) {
        localShareWebPageInfo.bytes_title.set(ByteStringMicro.copyFromUtf8(this.title));
      }
      if (!TextUtils.isEmpty(this.source)) {
        localShareWebPageInfo.bytes_source.set(ByteStringMicro.copyFromUtf8(this.source));
      }
      if (!TextUtils.isEmpty(this.desc)) {
        localShareWebPageInfo.bytes_desc.set(ByteStringMicro.copyFromUtf8(this.desc));
      }
      return localShareWebPageInfo;
    }
  }
  
  public static class r
  {
    public SocializeFeedsInfo.a a;
    public int aTa;
    public int aTb;
    public String ail;
    public SocializeFeedsInfo.c b;
    public long cuin;
    public String jumpUrl;
    public ArrayList<SocializeFeedsInfo.s> la = new ArrayList();
    public ArrayList<SocializeFeedsInfo.t> lb = new ArrayList();
    public ArrayList<SocializeFeedsInfo.UGCVoiceInfo> lc = new ArrayList();
    public String nickName;
    
    public String toString()
    {
      return "UGCFeedsInfo{ugcFeedsCardType=" + this.aTa + ", ugcPicInfos=" + this.la + ", ugcVideoInfos=" + this.lb + ", ugcVoiceInfos=" + this.lc + ", cuin=" + this.cuin + ", ugc_comments='" + this.ail + '\'' + ", nickName='" + this.nickName + '\'' + ", ugcAtComments=" + this.b + ", ugcFeedsSrc=" + this.aTb + ", jumpUrl='" + this.jumpUrl + '\'' + ", accountProfileInfo=" + this.a + '}';
    }
  }
  
  public static class s
  {
    public int aSX;
    public String aii;
    public int pic_height;
    public String pic_md5;
    public String pic_url;
    public int pic_width;
  }
  
  public static class t
  {
    public int aSY;
    public int aTc;
    public int aTd;
    public int aTe;
    public String aik;
    public String aim;
    public long duration;
    public int pic_height;
    public String pic_md5;
    public String pic_url;
    public int pic_width;
    public String share_url;
    public String title;
    public String uuid;
    public String vid;
    public String video_url;
  }
  
  public static class u
  {
    public mgp a = new mgp();
    public int aTf;
    public int aTg;
    public String agH;
    public String ain;
    public String aio;
    public String aip;
    public String aiq;
    public String air;
    public String ais;
    public String ait;
    public String aiu;
    public String aiv;
    public String aiw;
    public String aix;
    public boolean amO;
    public int channelId;
    public int followCount;
    public List<Integer> iV = new ArrayList();
    public List<String> iW = new ArrayList();
    public List<String> iX = new ArrayList();
    public String jumpUrl;
    public String wendaUrl;
    
    public articlesummary.WendaInfo a()
    {
      articlesummary.WendaInfo localWendaInfo = new articlesummary.WendaInfo();
      PBUInt32Field localPBUInt32Field = localWendaInfo.uint32_is_super_wenda;
      if (this.amO) {}
      for (int i = 1;; i = 0)
      {
        localPBUInt32Field.set(i);
        if (!TextUtils.isEmpty(this.agH)) {
          localWendaInfo.bytes_question_rowkey.set(ByteStringMicro.copyFromUtf8(this.agH));
        }
        if (!TextUtils.isEmpty(this.ain)) {
          localWendaInfo.bytes_question_desc.set(ByteStringMicro.copyFromUtf8(this.ain));
        }
        if (!TextUtils.isEmpty(this.aio)) {
          localWendaInfo.bytes_question_pic_url.set(ByteStringMicro.copyFromUtf8(this.aio));
        }
        if (!TextUtils.isEmpty(this.wendaUrl)) {
          localWendaInfo.bytes_wenda_url.set(ByteStringMicro.copyFromUtf8(this.wendaUrl));
        }
        localWendaInfo.uint32_follow_count.set(this.followCount);
        localWendaInfo.uint32_answer_count.set(this.aTf);
        if (!TextUtils.isEmpty(this.aip)) {
          localWendaInfo.bytes_icon_url.set(ByteStringMicro.copyFromUtf8(this.aip));
        }
        if (!TextUtils.isEmpty(this.aiq)) {
          localWendaInfo.bytes_answer_url.set(ByteStringMicro.copyFromUtf8(this.aiq));
        }
        localWendaInfo.channel_id.set(this.channelId);
        if (!TextUtils.isEmpty(this.ais)) {
          localWendaInfo.channel_id_name.set(this.ais);
        }
        localWendaInfo.channel_second_id.set(this.aTg);
        if (!TextUtils.isEmpty(this.ait)) {
          localWendaInfo.channel_second_id_name.set(this.ait);
        }
        localWendaInfo.tag_id.set(this.iV);
        localWendaInfo.tag_id_name.set(this.iW);
        if (!TextUtils.isEmpty(this.aiu)) {
          localWendaInfo.author_nick.set(this.aiu);
        }
        if (!TextUtils.isEmpty(this.jumpUrl)) {
          localWendaInfo.jump_url.set(this.jumpUrl);
        }
        localWendaInfo.images_url.set(this.iX);
        if (!TextUtils.isEmpty(this.aiv)) {
          localWendaInfo.icon_name.set(this.aiv);
        }
        if (!TextUtils.isEmpty(this.aiw)) {
          localWendaInfo.icon_color.set(this.aiw);
        }
        if (!TextUtils.isEmpty(this.aix)) {
          localWendaInfo.super_wenda_button_title.set(this.aix);
        }
        localWendaInfo.answer_detail.set(this.a.a());
        return localWendaInfo;
      }
    }
    
    public void a(articlesummary.AnswerDetail paramAnswerDetail)
    {
      this.a = mgp.a(paramAnswerDetail);
    }
    
    public String toString()
    {
      return "isSuperWenda = " + this.amO + ", questionRowkey = " + this.agH + ", questionDes = " + this.ain + ", questionPicUrl = " + this.aio + ", wendaUrl = " + this.wendaUrl + ", followCount = " + this.followCount + ", answerCount = " + this.aTf + ", questionIconUrl = " + this.aip + ", answerUrl = " + this.aiq + ", questionPicUrlForSmartCrop = " + this.air;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */