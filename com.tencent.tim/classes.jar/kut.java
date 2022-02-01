import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.a;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.1;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.10;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.11;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.2;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.3;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.4;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.5;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.6;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.7;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.8;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule.9;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Activity;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.AdRspInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ArticleInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Banner;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Comment;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ExtraInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.MedalInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.MediaData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqAdvertisePara;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqBody;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqParam;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.RspBody;
import tencent.im.oidb.cmd0xdc8.oidb_cmd0xdc8.ReqBody;

public class kut
  extends lir
{
  private ksw a;
  
  public kut(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
  }
  
  private List<CommentData> I(List<oidb_cmd0xc46.Comment> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (oidb_cmd0xc46.Comment)paramList.next();
      if (localObject != null)
      {
        localObject = a((oidb_cmd0xc46.Comment)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private List<SubCommentData> J(List<oidb_cmd0xc46.Comment> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (oidb_cmd0xc46.Comment)paramList.next();
      if (localObject != null)
      {
        localObject = a((oidb_cmd0xc46.Comment)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private CommentData a(oidb_cmd0xc46.Comment paramComment)
  {
    boolean bool2 = true;
    if ((paramComment == null) || (!paramComment.comment_id.has())) {
      return null;
    }
    CommentData localCommentData = new CommentData();
    a(paramComment, localCommentData);
    if (paramComment.sub_comments_total.has()) {
      localCommentData.subCommentNum = paramComment.sub_comments_total.get();
    }
    if (paramComment.sub_comments.has())
    {
      localCommentData.subCommentList = new ArrayList();
      Iterator localIterator = paramComment.sub_comments.get().iterator();
      while (localIterator.hasNext())
      {
        SubCommentData localSubCommentData = a((oidb_cmd0xc46.Comment)localIterator.next());
        if (localSubCommentData != null) {
          localCommentData.subCommentList.add(localSubCommentData);
        }
      }
    }
    if (paramComment.is_anchor.has())
    {
      if (paramComment.is_anchor.get() == 1)
      {
        bool1 = true;
        localCommentData.isAnchor = bool1;
      }
    }
    else if (paramComment.is_delete.has()) {
      if (paramComment.is_delete.get() != 1) {
        break label237;
      }
    }
    label237:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCommentData.isDelete = bool1;
      if (paramComment.rpt_medal_info_list.has()) {
        localCommentData.medalInfo = a(false, paramComment.rpt_medal_info_list.get(), localCommentData.uin);
      }
      return localCommentData;
      bool1 = false;
      break;
    }
  }
  
  private SubCommentData a(oidb_cmd0xc46.Comment paramComment)
  {
    boolean bool2 = false;
    if ((paramComment == null) || (!paramComment.comment_id.has())) {
      return null;
    }
    SubCommentData localSubCommentData = new SubCommentData();
    a(paramComment, localSubCommentData);
    if (paramComment.first_comment_id.has()) {
      localSubCommentData.parentCommentId = paramComment.first_comment_id.get();
    }
    if (paramComment.replied_user_id.has()) {
      localSubCommentData.repliedUserUin = paramComment.replied_user_id.get();
    }
    if (paramComment.replied_user_nick_name.has()) {
      localSubCommentData.repliedUserNickname = paramComment.replied_user_nick_name.get();
    }
    if (paramComment.replied_user_homepage.has()) {
      localSubCommentData.repliedUserHomePage = paramComment.replied_user_homepage.get();
    }
    if (paramComment.has_target.has()) {
      localSubCommentData.hasTarget = paramComment.has_target.get();
    }
    if (paramComment.is_anchor.has()) {
      if (paramComment.is_anchor.get() != 1) {
        break label239;
      }
    }
    label239:
    for (boolean bool1 = true;; bool1 = false)
    {
      localSubCommentData.isAnchor = bool1;
      if (paramComment.is_delete.has())
      {
        bool1 = bool2;
        if (paramComment.is_delete.get() == 1) {
          bool1 = true;
        }
        localSubCommentData.isDelete = bool1;
      }
      if (paramComment.rpt_medal_info_list.has()) {
        localSubCommentData.medalInfo = a(true, paramComment.rpt_medal_info_list.get(), localSubCommentData.uin);
      }
      return localSubCommentData;
    }
  }
  
  private kgj a(boolean paramBoolean, List<oidb_cmd0xc46.MedalInfo> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        oidb_cmd0xc46.MedalInfo localMedalInfo = (oidb_cmd0xc46.MedalInfo)paramList.next();
        kgj localkgj = new kgj();
        if (localMedalInfo.is_jump.has()) {
          localkgj.aIC = localMedalInfo.is_jump.get();
        }
        if (localMedalInfo.jump_url.has()) {
          localkgj.mJumpUrl = localMedalInfo.jump_url.get().toStringUtf8();
        }
        if (localMedalInfo.medal_type.has()) {
          localkgj.aIB = localMedalInfo.medal_type.get();
        }
        if (localMedalInfo.medal_id.has()) {
          localkgj.rU = localMedalInfo.medal_id.get();
        }
        if (localMedalInfo.medal_name.has()) {
          localkgj.Za = localMedalInfo.medal_name.get().toStringUtf8();
        }
        if (localMedalInfo.medal_url.has()) {
          localkgj.Zb = localMedalInfo.medal_url.get().toStringUtf8();
        }
        if (localMedalInfo.pic_width.has()) {
          localkgj.mPicWidth = localMedalInfo.pic_width.get();
        }
        if (localMedalInfo.pic_height.has()) {
          localkgj.mPicHeight = localMedalInfo.pic_height.get();
        }
        localkgj.Zd = "3";
        if (paramBoolean) {}
        for (localkgj.Ze = "7";; localkgj.Ze = "6")
        {
          localkgj.Zg = paramString;
          localArrayList.add(localkgj);
          break;
        }
      }
    }
    paramList = null;
    if (!localArrayList.isEmpty()) {
      paramList = (kgj)localArrayList.get(0);
    }
    return paramList;
  }
  
  private void a(oidb_cmd0xc46.Comment paramComment, BaseCommentData paramBaseCommentData)
  {
    if ((paramComment == null) || (paramBaseCommentData == null)) {}
    for (;;)
    {
      return;
      if (paramComment.comment_id.has()) {
        paramBaseCommentData.commentId = paramComment.comment_id.get();
      }
      if (paramComment.author_id.has()) {
        paramBaseCommentData.uin = paramComment.author_id.get();
      }
      if (paramComment.create_time.has()) {
        paramBaseCommentData.commentTime = paramComment.create_time.get();
      }
      if (paramComment.content.has()) {
        paramBaseCommentData.commentContent = paramComment.content.get();
      }
      if (paramComment.like_num.has()) {
        paramBaseCommentData.likeCnt = paramComment.like_num.get();
      }
      if (paramComment.like.has()) {
        paramBaseCommentData.like = paramComment.like.get();
      }
      if (paramComment.dislike.has()) {
        paramBaseCommentData.disLike = paramComment.dislike.get();
      }
      if (paramComment.anonymous.has()) {
        paramBaseCommentData.anonymous = paramComment.anonymous.get();
      }
      if (paramComment.author_selection.has()) {
        paramBaseCommentData.authorSelection = paramComment.author_selection.get();
      }
      if (paramComment.rank.has()) {
        paramBaseCommentData.rank = paramComment.rank.get();
      }
      if (paramComment.level.has()) {
        paramBaseCommentData.level = paramComment.level.get();
      }
      if (paramComment.author_comment.has()) {
        paramBaseCommentData.authorComment = paramComment.author_comment.get();
      }
      if (paramComment.nick_name.has()) {
        paramBaseCommentData.nickName = paramComment.nick_name.get();
      }
      if (paramComment.avatar.has()) {
        paramBaseCommentData.avatar = paramComment.avatar.get();
      }
      if (paramComment.myself.has()) {
        paramBaseCommentData.myself = paramComment.myself.get();
      }
      if (paramComment.homepage.has()) {
        paramBaseCommentData.homepage = paramComment.homepage.get();
      }
      if (paramComment.awesome.has()) {
        paramBaseCommentData.awesome = paramComment.awesome.get();
      }
      if (paramComment.rowkey.has()) {
        paramBaseCommentData.rowKey = paramComment.rowkey.get();
      }
      if (paramComment.content_source.has()) {
        paramBaseCommentData.contentSrc = paramComment.content_source.get();
      }
      if (paramComment.passthrough.has()) {
        paramBaseCommentData.passthrough = paramComment.passthrough.get().toStringUtf8();
      }
      if (paramComment.is_activity.has()) {
        paramBaseCommentData.isActivity = paramComment.is_activity.get();
      }
      if (paramComment.pic_url.has()) {
        paramBaseCommentData.activityPicUrl = paramComment.pic_url.get();
      }
      if (paramComment.jump_url.has()) {
        paramBaseCommentData.activityJumpUrl = paramComment.jump_url.get();
      }
      if ((paramComment.activity.has()) && (paramComment.activity.config_id.has())) {
        paramBaseCommentData.activityCfgID = paramComment.activity.config_id.get();
      }
      if (paramComment.is_star.has()) {
        paramBaseCommentData.isStar = paramComment.is_star.get();
      }
      if (paramComment.is_approved.has()) {
        paramBaseCommentData.isApproved = paramComment.is_approved.get();
      }
      if (paramComment.create_source.has())
      {
        paramBaseCommentData.createSrc = paramComment.create_source.get();
        QLog.d("ReadInJoyCommentPBModule", 1, "create_source : " + paramComment.create_source.get());
      }
      if (paramComment.is_author_reply.has()) {
        paramBaseCommentData.isAuthorReply = paramComment.is_author_reply.get();
      }
      if (paramComment.user_title.has()) {
        paramBaseCommentData.userTitle = paramComment.user_title.get();
      }
      if (paramComment.ks_homepage.has()) {
        paramBaseCommentData.ksHomePage = paramComment.ks_homepage.get();
      }
      if (paramComment.jump_schema.has()) {}
      try
      {
        paramBaseCommentData.flowGuidePtsData = new String(aqgo.decode(paramComment.jump_schema.get(), 0), "utf-8");
        QLog.d("ReadInJoyCommentPBModule", 1, "flowGuidePtsData : " + paramBaseCommentData.flowGuidePtsData);
        label756:
        if ((paramComment.is_multi_media.has()) && (paramComment.is_multi_media.get() == 1))
        {
          QLog.d("ReadInJoyCommentPBModule", 1, "comment type is multi media");
          if (paramComment.rpt_media_data_list.has()) {}
          for (List localList = paramComment.rpt_media_data_list.get(); (localList != null) && (localList.size() > 0); localList = null)
          {
            int j = localList.size();
            QLog.d("ReadInJoyCommentPBModule", 1, "comment media size : " + j);
            paramBaseCommentData.mediaDataList = new ArrayList();
            int i = 0;
            while (i < j)
            {
              oidb_cmd0xc46.MediaData localMediaData = (oidb_cmd0xc46.MediaData)localList.get(i);
              BaseCommentData.a locala = new BaseCommentData.a();
              locala.text = localMediaData.text.get().toString();
              locala.medalType = localMediaData.media_type.get();
              locala.picWidth = localMediaData.pic_width.get();
              locala.aLN = localMediaData.pic_length.get();
              locala.picUrl = localMediaData.pic_url.get();
              locala.thumbUrl = localMediaData.thumbnail_url.get();
              locala.videoUrl = localMediaData.video_url.get();
              locala.videoDuration = localMediaData.video_duration.get();
              locala.ace = localMediaData.sound_url.get();
              locala.aLO = localMediaData.sound_duration.get();
              paramBaseCommentData.mediaDataList.add(locala);
              i += 1;
            }
          }
        }
        if (paramComment.style_data.has())
        {
          paramBaseCommentData.styleData = paramComment.style_data.get();
          QLog.d("ReadInJoyCommentPBModule", 1, "comment style_data " + paramBaseCommentData.styleData);
        }
        if (paramComment.is_ad.has()) {
          if (paramComment.is_ad.get() != 1) {
            break label1274;
          }
        }
        label1274:
        for (boolean bool = true;; bool = false)
        {
          paramBaseCommentData.isAd = bool;
          if ((!paramBaseCommentData.isAd) || (!paramComment.ad_rsp_info.has()) || (!paramComment.ad_rsp_info.data.has())) {
            break;
          }
          paramComment = kmt.a(paramComment.ad_rsp_info.data.get().toByteArray());
          if (paramComment.size() <= 0) {
            break;
          }
          paramBaseCommentData.advertisementInfo = ((AdvertisementInfo)paramComment.get(0));
          if ((paramBaseCommentData.advertisementInfo == null) || (paramBaseCommentData.advertisementInfo.mCommentAdParams == null)) {
            break;
          }
          if (paramBaseCommentData.advertisementInfo.mCommentAdParams.aJO > 0) {
            kmt.aJO = paramBaseCommentData.advertisementInfo.mCommentAdParams.aJO;
          }
          if (paramBaseCommentData.advertisementInfo.mCommentAdParams.aJN <= 0) {
            break;
          }
          kmt.aJN = paramBaseCommentData.advertisementInfo.mCommentAdParams.aJN;
          return;
        }
      }
      catch (Exception localException)
      {
        break label756;
      }
    }
  }
  
  private void a(oidb_cmd0xc46.ReqBody paramReqBody, CommonCommentData paramCommonCommentData)
  {
    if (paramCommonCommentData == null) {}
    do
    {
      return;
      if (paramCommonCommentData.getFeedsType() != -1) {
        paramReqBody.feeds_type.set(paramCommonCommentData.getFeedsType());
      }
    } while (TextUtils.isEmpty(paramCommonCommentData.getFeedsId()));
    paramReqBody.feeds_id.set(paramCommonCommentData.getFeedsId());
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0xc46.RspBody();
    int j = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleCommonCommentList | retCode " + j);
    paramFromServiceMsg = new kut.a();
    paramObject = new kut.a();
    kut.b localb = new kut.b();
    boolean bool;
    if (j == 0) {
      if (((oidb_cmd0xc46.RspBody)localObject).next.has())
      {
        if (((oidb_cmd0xc46.RspBody)localObject).next.get() != 1) {
          break label954;
        }
        bool = true;
      }
    }
    for (;;)
    {
      paramObject.hasNextPage = bool;
      QLog.d("ReadInJoyCommentPBModule", 2, "handleCommonCommentList | hasNextPage " + ((oidb_cmd0xc46.RspBody)localObject).next.get());
      if (((oidb_cmd0xc46.RspBody)localObject).page_cookie.has()) {
        paramObject.acv = ((oidb_cmd0xc46.RspBody)localObject).page_cookie.get().toStringUtf8();
      }
      if (((oidb_cmd0xc46.RspBody)localObject).extra_info.has())
      {
        if (((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).hot_next.has())
        {
          if (((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).hot_next.get() != 1) {
            break label960;
          }
          bool = true;
          paramFromServiceMsg.hasNextPage = bool;
        }
        if (((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).hot_page_cookie.has()) {
          paramFromServiceMsg.acv = ((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).hot_page_cookie.get().toStringUtf8();
        }
        if (((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).hidden_comment_count.has()) {
          localb.sO = ((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).hidden_comment_count.get();
        }
        if (((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).show_mask.has()) {
          localb.aLW = ((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).show_mask.get();
        }
        if (!((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).jump_kva_schema.has()) {}
      }
      try
      {
        localb.jumpSchema = new String(aqgo.decode(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject).extra_info.get()).jump_kva_schema.get().toString(), 0), "utf-8");
        if (((oidb_cmd0xc46.RspBody)localObject).hot_comment_list.has()) {
          paramFromServiceMsg.gH = I(((oidb_cmd0xc46.RspBody)localObject).hot_comment_list.get());
        }
        if (((oidb_cmd0xc46.RspBody)localObject).comment_list.has()) {
          paramObject.gH = I(((oidb_cmd0xc46.RspBody)localObject).comment_list.get());
        }
        if (((oidb_cmd0xc46.RspBody)localObject).article_info.has())
        {
          oidb_cmd0xc46.ArticleInfo localArticleInfo = (oidb_cmd0xc46.ArticleInfo)((oidb_cmd0xc46.RspBody)localObject).article_info.get();
          if (localArticleInfo.comment_count.has()) {
            localb.sN = localArticleInfo.comment_count.get();
          }
          if ((paramToServiceMsg.getAttribute("anchor_request") != null) && (localArticleInfo.has_anchor.has()))
          {
            if (localArticleInfo.has_anchor.get() == 0) {
              this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.1(this));
            }
            QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + localArticleInfo.has_anchor.get());
          }
        }
        else
        {
          paramToServiceMsg = null;
          if (((oidb_cmd0xc46.RspBody)localObject).banner.has())
          {
            localObject = (oidb_cmd0xc46.Banner)((oidb_cmd0xc46.RspBody)localObject).banner.get();
            paramToServiceMsg = new CommentData();
            paramToServiceMsg.commentId = String.valueOf(((oidb_cmd0xc46.Banner)localObject).config_id.get());
            paramToServiceMsg.commentContent = ((oidb_cmd0xc46.Banner)localObject).title.get();
            paramToServiceMsg.activityJumpUrl = ((oidb_cmd0xc46.Banner)localObject).jump_url.get();
            paramToServiceMsg.isBanner = true;
            QLog.d("ReadInJoyCommentPBModule", 1, "handleCommonCommentList | banner configid ：" + paramToServiceMsg.commentId + "; title :" + paramToServiceMsg.commentContent + "; url " + paramToServiceMsg.activityJumpUrl);
          }
          localObject = new StringBuilder().append("handleCommonCommentList | retCode ").append(j).append(" | hasNewNextPage ").append(paramObject.hasNextPage).append(" | hasHotNextPage+").append(paramFromServiceMsg.hasNextPage).append(" | newPageCookie ").append(paramObject.acv).append("; hotPageCookie ").append(paramFromServiceMsg.acv).append("| articleCommentCnt ").append(localb.sN).append(" | hotCommentListSize ");
          if (paramFromServiceMsg.gH == null) {
            break label989;
          }
          i = paramFromServiceMsg.gH.size();
          localObject = ((StringBuilder)localObject).append(i).append(" | newCommentListSize ");
          if (paramObject.gH == null) {
            break label995;
          }
          i = paramObject.gH.size();
          QLog.d("ReadInJoyCommentPBModule", 1, i);
          if (paramFromServiceMsg.AB()) {
            paramFromServiceMsg.gH.add(0, paramToServiceMsg);
          }
          if (paramObject.AB()) {
            paramObject.gH.add(0, paramToServiceMsg);
          }
          this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.2(this, j, paramFromServiceMsg, paramObject, localb));
          return;
          label954:
          bool = false;
          continue;
          label960:
          bool = false;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          continue;
          QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
          continue;
          label989:
          int i = 0;
          continue;
          label995:
          i = 0;
        }
      }
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc46.RspBody localRspBody = new oidb_cmd0xc46.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleFamilyCommentList | retCode " + i);
    kut.a locala = new kut.a();
    kut.b localb = new kut.b();
    paramObject = null;
    paramFromServiceMsg = paramObject;
    boolean bool;
    if (i == 0)
    {
      if (localRspBody.next.has())
      {
        if (localRspBody.next.get() != 1) {
          break label473;
        }
        bool = true;
        locala.hasNextPage = bool;
        QLog.d("ReadInJoyCommentPBModule", 1, "handleFamilyCommentList | hasNextPage " + localRspBody.next.get());
      }
      if (localRspBody.page_cookie.has()) {
        locala.acv = localRspBody.page_cookie.get().toStringUtf8();
      }
      if (localRspBody.comment_list.has()) {
        locala.gH = I(localRspBody.comment_list.get());
      }
      if (localRspBody.article_info.has())
      {
        paramFromServiceMsg = (oidb_cmd0xc46.ArticleInfo)localRspBody.article_info.get();
        if (paramFromServiceMsg.comment_count.has()) {
          localb.sN = paramFromServiceMsg.comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!paramFromServiceMsg.has_anchor.has())) {
          break label479;
        }
        if (paramFromServiceMsg.has_anchor.get() == 0) {
          this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.3(this));
        }
        QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + paramFromServiceMsg.has_anchor.get());
      }
    }
    for (;;)
    {
      paramFromServiceMsg = paramObject;
      if (localRspBody.banner.has())
      {
        paramToServiceMsg = (oidb_cmd0xc46.Banner)localRspBody.banner.get();
        paramFromServiceMsg = new CommentData();
        paramFromServiceMsg.commentId = String.valueOf(paramToServiceMsg.config_id.get());
        paramFromServiceMsg.commentContent = paramToServiceMsg.title.get();
        paramFromServiceMsg.activityJumpUrl = paramToServiceMsg.jump_url.get();
        paramFromServiceMsg.isBanner = true;
        QLog.d("ReadInJoyCommentPBModule", 1, "family comment banner configid ：" + paramFromServiceMsg.commentId + "; title :" + paramFromServiceMsg.commentContent + "; url" + paramFromServiceMsg.activityPicUrl);
      }
      this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.4(this, i, locala, localb, paramFromServiceMsg));
      return;
      label473:
      bool = false;
      break;
      label479:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc46.RspBody localRspBody = new oidb_cmd0xc46.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleNewCommentList | retCode " + i);
    kut.a locala = new kut.a();
    kut.b localb = new kut.b();
    paramObject = null;
    paramFromServiceMsg = paramObject;
    boolean bool;
    if (i == 0)
    {
      if (localRspBody.next.has())
      {
        if (localRspBody.next.get() != 1) {
          break label473;
        }
        bool = true;
        locala.hasNextPage = bool;
        QLog.d("ReadInJoyCommentPBModule", 1, "handleNewCommentList | hasNextPage " + localRspBody.next.get());
      }
      if (localRspBody.page_cookie.has()) {
        locala.acv = localRspBody.page_cookie.get().toStringUtf8();
      }
      if (localRspBody.comment_list.has()) {
        locala.gH = I(localRspBody.comment_list.get());
      }
      if (localRspBody.article_info.has())
      {
        paramFromServiceMsg = (oidb_cmd0xc46.ArticleInfo)localRspBody.article_info.get();
        if (paramFromServiceMsg.comment_count.has()) {
          localb.sN = paramFromServiceMsg.comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!paramFromServiceMsg.has_anchor.has())) {
          break label479;
        }
        if (paramFromServiceMsg.has_anchor.get() == 0) {
          this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.5(this));
        }
        QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + paramFromServiceMsg.has_anchor.get());
      }
    }
    for (;;)
    {
      paramFromServiceMsg = paramObject;
      if (localRspBody.banner.has())
      {
        paramToServiceMsg = (oidb_cmd0xc46.Banner)localRspBody.banner.get();
        paramFromServiceMsg = new CommentData();
        paramFromServiceMsg.commentId = String.valueOf(paramToServiceMsg.config_id.get());
        paramFromServiceMsg.commentContent = paramToServiceMsg.title.get();
        paramFromServiceMsg.activityJumpUrl = paramToServiceMsg.jump_url.get();
        paramFromServiceMsg.isBanner = true;
        QLog.d("ReadInJoyCommentPBModule", 1, "new comment banner configid ：" + paramFromServiceMsg.commentId + "; title :" + paramFromServiceMsg.commentContent + "; url" + paramFromServiceMsg.activityPicUrl);
      }
      this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.6(this, i, locala, localb, paramFromServiceMsg));
      return;
      label473:
      bool = false;
      break;
      label479:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
    }
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc46.RspBody localRspBody = new oidb_cmd0xc46.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleHotCommentList | retCode " + i);
    kut.a locala = new kut.a();
    kut.b localb = new kut.b();
    paramObject = null;
    paramFromServiceMsg = paramObject;
    boolean bool;
    if (i == 0)
    {
      if (localRspBody.next.has())
      {
        if (localRspBody.next.get() != 1) {
          break label473;
        }
        bool = true;
        locala.hasNextPage = bool;
        QLog.d("ReadInJoyCommentPBModule", 1, "handleHotCommentList | hasNextPage " + localRspBody.next.get());
      }
      if (localRspBody.page_cookie.has()) {
        locala.acv = localRspBody.page_cookie.get().toStringUtf8();
      }
      if (localRspBody.hot_comment_list.has()) {
        locala.gH = I(localRspBody.hot_comment_list.get());
      }
      if (localRspBody.article_info.has())
      {
        paramFromServiceMsg = (oidb_cmd0xc46.ArticleInfo)localRspBody.article_info.get();
        if (paramFromServiceMsg.comment_count.has()) {
          localb.sN = paramFromServiceMsg.comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!paramFromServiceMsg.has_anchor.has())) {
          break label479;
        }
        if (paramFromServiceMsg.has_anchor.get() == 0) {
          this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.7(this));
        }
        QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + paramFromServiceMsg.has_anchor.get());
      }
    }
    for (;;)
    {
      paramFromServiceMsg = paramObject;
      if (localRspBody.banner.has())
      {
        paramToServiceMsg = (oidb_cmd0xc46.Banner)localRspBody.banner.get();
        paramFromServiceMsg = new CommentData();
        paramFromServiceMsg.commentId = String.valueOf(paramToServiceMsg.config_id.get());
        paramFromServiceMsg.commentContent = paramToServiceMsg.title.get();
        paramFromServiceMsg.activityJumpUrl = paramToServiceMsg.jump_url.get();
        paramFromServiceMsg.isBanner = true;
        QLog.d("ReadInJoyCommentPBModule", 1, "hot comment banner configid ：" + paramFromServiceMsg.commentId + "; title :" + paramFromServiceMsg.commentContent + "; url" + paramFromServiceMsg.activityPicUrl);
      }
      this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.8(this, i, locala, localb, paramFromServiceMsg));
      return;
      label473:
      bool = false;
      break;
      label479:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
    }
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0xc46.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleSubCommentList | retCode " + i);
    paramFromServiceMsg = new kut.a();
    paramObject = new kut.b();
    boolean bool;
    if (i == 0) {
      if (((oidb_cmd0xc46.RspBody)localObject).next.has())
      {
        if (((oidb_cmd0xc46.RspBody)localObject).next.get() == 1)
        {
          bool = true;
          paramFromServiceMsg.hasNextPage = bool;
          QLog.d("ReadInJoyCommentPBModule", 1, "handleSubCommentList | hasNextPage " + ((oidb_cmd0xc46.RspBody)localObject).next.get());
        }
      }
      else
      {
        if (((oidb_cmd0xc46.RspBody)localObject).page_cookie.has()) {
          paramFromServiceMsg.acv = ((oidb_cmd0xc46.RspBody)localObject).page_cookie.get().toStringUtf8();
        }
        if (!((oidb_cmd0xc46.RspBody)localObject).comment_list.has()) {
          break label331;
        }
        paramFromServiceMsg.gI = J(((oidb_cmd0xc46.RspBody)localObject).comment_list.get());
        label186:
        if (((oidb_cmd0xc46.RspBody)localObject).article_info.has())
        {
          localObject = (oidb_cmd0xc46.ArticleInfo)((oidb_cmd0xc46.RspBody)localObject).article_info.get();
          if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!((oidb_cmd0xc46.ArticleInfo)localObject).has_anchor.has())) {
            break label345;
          }
          if (((oidb_cmd0xc46.ArticleInfo)localObject).has_anchor.get() == 0) {
            this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.9(this));
          }
          QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + ((oidb_cmd0xc46.ArticleInfo)localObject).has_anchor.get());
        }
      }
    }
    for (;;)
    {
      paramToServiceMsg = (String)paramToServiceMsg.getAttribute("parent_comment_id");
      this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.11(this, i, paramFromServiceMsg, paramToServiceMsg, paramObject));
      return;
      bool = false;
      break;
      label331:
      paramFromServiceMsg.gI = new ArrayList();
      break label186;
      label345:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
      continue;
      paramFromServiceMsg.gI = new ArrayList();
      this.mMainThreadHandler.post(new ReadInJoyCommentPBModule.10(this, i));
    }
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_cmd0xc46.RspBody());
    int j = ((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue();
    odv.a(i, paramToServiceMsg, 5, null);
    if (kxm.getAppRuntime() == null) {
      return;
    }
    paramFromServiceMsg = new HashMap();
    paramFromServiceMsg.put("retCode", String.valueOf(i));
    paramFromServiceMsg.put("request_comment_type", String.valueOf(j));
    paramObject = anpc.a(kxm.getAppRuntime().getApplication());
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramObject.collectPerformance(null, "actKandian0xc46Result", bool, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"), 0L, paramFromServiceMsg, null);
      QLog.d("ReadInJoyCommentPBModule", 1, "report0xc46Result | actKandian0xc46Result | retCode ： " + i + "| request_comment_type : " + j);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestFamliyCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestFamliyCommentList | articleId : " + paramString1 + " contentSrc : " + paramInt2 + " ; pageCookie : " + paramString2);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    oidb_cmd0xc46.ReqParam localReqParam = new oidb_cmd0xc46.ReqParam();
    localReqParam.with_sub_comments.set(1);
    localReqParam.with_author_reply.set(1);
    localReqParam.with_style_data.set(1);
    localReqBody.req_param.set(localReqParam);
    localReqBody.rowkey.set(paramString1);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(paramInt2);
    localReqBody.with_activity_data.set(1);
    a(localReqBody, paramCommonCommentData);
    paramString1 = lup.makeOIDBPkg("OidbSvc.0xc46", 3142, 6, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(6));
    sendPbReq(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestCommonCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestCommonCommentList | articleId : " + paramString1 + " contentSrc : " + paramInt2 + "; mainCommentId : " + paramString3 + " ; pageCookie : " + paramString2 + "; commonCommentData " + paramCommonCommentData);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    oidb_cmd0xc46.ReqParam localReqParam = new oidb_cmd0xc46.ReqParam();
    localReqParam.with_style_data.set(1);
    localReqParam.with_sub_comments.set(1);
    localReqParam.with_author_reply.set(1);
    localReqParam.req_advertise_para.set(kmt.a(1, kmt.p(paramString1, 1), paramInt1, null));
    localReqBody.req_param.set(localReqParam);
    localReqBody.rowkey.set(paramString1);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(paramInt2);
    localReqBody.with_activity_data.set(1);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestCommonCommentList | articleId : " + paramString1 + " contentSrc : " + paramInt2 + "; mainCommentId : " + paramString3 + " ; pageCookie : " + paramString2);
    paramString1 = lup.makeOIDBPkg("OidbSvc.0xc46", 3142, 5, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(5));
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    sendPbReq(paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestSubCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestSubCommentList | subPageCookie : " + paramString4);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    localReqBody.rowkey.set(paramString1);
    localReqBody.comment_id.set(paramString2);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString4));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(paramInt2);
    localReqBody.with_activity_data.set(1);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.with_first_comment_detail.set(1);
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    paramString1 = lup.makeOIDBPkg("OidbSvc.0xc46", 3142, 4, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(4));
    paramString1.addAttribute("parent_comment_id", paramString2);
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    sendPbReq(paramString1);
  }
  
  public void a(ksw paramksw)
  {
    this.a = paramksw;
  }
  
  public void aEL()
  {
    this.a = null;
  }
  
  public void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestNewCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestNewCommentList | newCookie : " + paramString2);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    localReqBody.rowkey.set(paramString1);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(paramInt2);
    localReqBody.with_activity_data.set(1);
    paramString2 = new oidb_cmd0xc46.ReqParam();
    paramString2.with_sub_comments.set(1);
    paramString2.with_author_reply.set(1);
    paramString2.with_style_data.set(1);
    paramString2.req_advertise_para.set(kmt.a(1, kmt.p(paramString1, 2), paramInt1, null));
    localReqBody.req_param.set(paramString2);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    paramString1 = lup.makeOIDBPkg("OidbSvc.0xc46", 3142, 2, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(2));
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    sendPbReq(paramString1);
  }
  
  public void c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestHotCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestHotCommentList | hotPageCookie : " + paramString2);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    localReqBody.rowkey.set(paramString1);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(paramInt2);
    localReqBody.with_activity_data.set(1);
    paramString2 = new oidb_cmd0xc46.ReqParam();
    paramString2.with_sub_comments.set(1);
    paramString2.with_author_reply.set(1);
    paramString2.with_style_data.set(1);
    paramString2.req_advertise_para.set(kmt.a(1, kmt.p(paramString1, 3), paramInt1, null));
    localReqBody.req_param.set(paramString2);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    paramString1 = lup.makeOIDBPkg("OidbSvc.0xc46", 3142, 3, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(3));
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    sendPbReq(paramString1);
  }
  
  public void i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString4 == null) || (paramString3 == null) || (paramString2 == null)) {}
    do
    {
      return;
      oidb_cmd0xdc8.ReqBody localReqBody = new oidb_cmd0xdc8.ReqBody();
      QLog.d("ReadInJoyCommentPBModule", 1, "start request 0xdc8  rowKey :" + paramString1 + " parentCommentId :" + paramString2 + " subCommentId : " + paramString3 + " commentId :" + paramString4);
      localReqBody.str_rowkey.set(paramString1);
      localReqBody.str_first_comment_id.set(paramString2);
      localReqBody.str_sub_comment_id.set(paramString3);
      localReqBody.str_comment_id.set(paramString4);
      localReqBody.int32_flag.set(1);
      paramString1 = lup.makeOIDBPkg("OidbSvc.0xdc8", 3528, 1, localReqBody.toByteArray());
    } while (paramString1 == null);
    sendPbReq(paramString1);
    QLog.d("ReadInJoyCommentPBModule", 1, "0xdc8 request :" + paramString1.toString());
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc46"))
    {
      v(paramToServiceMsg, paramFromServiceMsg, paramObject);
      if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() != 1) {
        break label91;
      }
      q(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    for (;;)
    {
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xdc8")) {
        QLog.d("ReadInJoyCommentPBModule", 1, "handle 0xdc8 : " + paramFromServiceMsg.toString());
      }
      return;
      label91:
      if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 4) {
        u(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 3) {
        t(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 2) {
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 5) {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 6) {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public static class a
  {
    public String acv;
    public List<CommentData> gH = new ArrayList();
    public List<SubCommentData> gI = new ArrayList();
    public boolean hasNextPage;
    
    public boolean AB()
    {
      return (this.gH != null) && (this.gH.size() > 0);
    }
  }
  
  public static class b
  {
    public int aLW = -1;
    public String jumpSchema;
    public long sN;
    public long sO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kut
 * JD-Core Version:    0.7.0.1
 */