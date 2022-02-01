import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.c;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import java.util.ArrayList;

public class mrv
{
  public static VideoInfo a(BaseArticleInfo paramBaseArticleInfo)
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.Wz = paramBaseArticleInfo.getInnerUniqueID();
    localVideoInfo.adB = ndi.ak(paramBaseArticleInfo);
    localVideoInfo.rA = paramBaseArticleInfo.mFeedId;
    localVideoInfo.feedType = paramBaseArticleInfo.mFeedType;
    return localVideoInfo;
  }
  
  public static BaseArticleInfo a(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (paramVideoInfo.busiType != 0))
    {
      ArticleInfo localArticleInfo = new ArticleInfo();
      try
      {
        localArticleInfo.mArticleID = paramVideoInfo.rz;
        localArticleInfo.innerUniqueID = paramVideoInfo.Wz;
        localArticleInfo.mTitle = paramVideoInfo.title;
        localArticleInfo.mSubscribeName = paramVideoInfo.accountName;
        localArticleInfo.mSubscribeID = paramVideoInfo.hH;
        localArticleInfo.mFirstPagePicUrl = paramVideoInfo.coverUrl;
        localArticleInfo.mVideoDuration = paramVideoInfo.duration;
        localArticleInfo.mVideoCoverUrl = obs.a(paramVideoInfo.coverUrl, paramVideoInfo.busiType);
        localArticleInfo.mVideoVid = paramVideoInfo.vid;
        localArticleInfo.mFeedType = paramVideoInfo.feedType;
        localArticleInfo.mFeedId = paramVideoInfo.rA;
        localArticleInfo.mXGFileSize = paramVideoInfo.ry;
        localArticleInfo.busiType = paramVideoInfo.busiType;
        localArticleInfo.mJsonVideoList = paramVideoInfo.WB;
        localArticleInfo.mVideoCommentCount = paramVideoInfo.commentCount;
        localArticleInfo.mVideoJsonWidth = paramVideoInfo.width;
        localArticleInfo.mVideoJsonHeight = paramVideoInfo.height;
        localArticleInfo.mArticleContentUrl = paramVideoInfo.webUrl;
        localArticleInfo.thirdIcon = paramVideoInfo.WC;
        localArticleInfo.thirdName = paramVideoInfo.accountName;
        localArticleInfo.thirdAction = paramVideoInfo.thirdAction;
        localArticleInfo.thirdUin = paramVideoInfo.hH;
        localArticleInfo.thirdUinName = paramVideoInfo.thirdUinName;
        localArticleInfo.mVideoPlayCount = paramVideoInfo.playCount;
        localArticleInfo.mRecommentdReason = paramVideoInfo.recommendReason;
        localArticleInfo.videoReportInfo = paramVideoInfo.videoReportInfo;
        localArticleInfo.mSummary = paramVideoInfo.summary;
        localArticleInfo.mTime = paramVideoInfo.rx;
        localArticleInfo.mAlgorithmID = paramVideoInfo.algorithmID;
        localArticleInfo.mDiskLikeInfoString = DislikeInfo.k(paramVideoInfo.jR);
        localArticleInfo.mArticleSubscriptText = paramVideoInfo.WH;
        localArticleInfo.mArticleSubscriptColor = paramVideoInfo.WI;
        localArticleInfo.mRecommendSeq = paramVideoInfo.recommendSeq;
        localArticleInfo.mVideoLogoUrl = paramVideoInfo.WE;
        if (paramVideoInfo.adB)
        {
          paramVideoInfo.busiType = 6;
          localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r = new SocializeFeedsInfo.r();
          if (!TextUtils.isEmpty(paramVideoInfo.hH)) {
            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin = Long.valueOf(paramVideoInfo.hH).longValue();
          }
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.aTa = paramVideoInfo.feedType;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.nickName = paramVideoInfo.accountName;
          localArticleInfo.mSocialFeedInfo.mCommentCount = paramVideoInfo.commentCount;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb = new ArrayList();
          SocializeFeedsInfo.t localt = new SocializeFeedsInfo.t();
          localt.pic_url = paramVideoInfo.coverUrl;
          localt.title = paramVideoInfo.title;
          localt.duration = (paramVideoInfo.duration * 1000);
          localt.aTc = paramVideoInfo.width;
          localt.aTd = paramVideoInfo.height;
          localt.aim = paramVideoInfo.Wz;
          if (paramVideoInfo.createTime != null) {
            localt.aTe = Integer.parseInt(paramVideoInfo.createTime);
          }
          localt.share_url = paramVideoInfo.webUrl;
          localt.aSY = paramVideoInfo.busiType;
          localt.vid = paramVideoInfo.vid;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.add(localt);
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin = Long.parseLong(paramVideoInfo.hH);
          paramVideoInfo = new SocializeFeedsInfo.c();
          paramVideoInfo.y = Long.valueOf(localArticleInfo.mFeedId);
          paramVideoInfo.z = Long.valueOf(localArticleInfo.mFeedType);
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$c = paramVideoInfo;
        }
        return localArticleInfo;
      }
      catch (Throwable paramVideoInfo)
      {
        paramVideoInfo.printStackTrace();
        return localArticleInfo;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mrv
 * JD-Core Version:    0.7.0.1
 */