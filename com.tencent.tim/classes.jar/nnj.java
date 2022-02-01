import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class nnj
{
  private static Bundle a(mye.b paramb, BaseArticleInfo paramBaseArticleInfo)
  {
    Bundle localBundle1 = new Bundle();
    label107:
    boolean bool;
    label278:
    label288:
    int i;
    label372:
    Bundle localBundle2;
    if (paramb.aDs == 1)
    {
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
      if (paramb.aDs != 6) {
        break label881;
      }
      localBundle1.putString("VIDEO_H5_URL", ((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).share_url);
      localBundle1.putString("VIDEO_CREATE_TIME", kxl.c(((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aTe, true));
      localBundle1.putString("VIDEO_TIME", String.valueOf(paramb.videoDuration));
      localBundle1.putString("VIDEO_WIDTH", String.valueOf(paramb.videoWidth));
      localBundle1.putString("VIDEO_HEIGHT", String.valueOf(paramb.videoHeight));
      localBundle1.putString("VIDEO_VID", paramb.videoVid);
      localBundle1.putString("VIDEO_COVER", paramb.videoCoverUrl);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      localBundle1.putString("VIDEO_SUMMARY", paramBaseArticleInfo.mTitle);
      if (paramb.aDs != 6) {
        break label910;
      }
      localBundle1.putString("VIDEO_ARTICLE_ID", ((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aim);
      localBundle1.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mFeedId);
      localBundle1.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mFeedType);
      localBundle1.putString("VIDEO_TITLE", ((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).title);
      if (paramb.aDs != 1) {
        break label935;
      }
      bool = true;
      localBundle1.putBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT", bool);
      localBundle1.putString("VIDEO_RECOMMEND_REASON", paramBaseArticleInfo.mRecommentdReason);
      localBundle1.putBoolean("isFromKandian", true);
      localBundle1.putLong("channelID", paramBaseArticleInfo.mChannelID);
      localBundle1.putLong("algorithmID", paramBaseArticleInfo.mAlgorithmID);
      localBundle1.putString("innderId", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putLong("strategyId", paramBaseArticleInfo.mStrategyId);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleFriendLikeText)) {
        break label940;
      }
      i = 0;
      localBundle1.putInt("interactionType", i);
      localBundle1.putString("VIDEO_THIRD_ICON", paramb.thirdIcon);
      localBundle1.putString("VIDEO_THIRD_NAME", paramb.thirdName);
      localBundle1.putString("VIDEO_THIRD_ACTION", paramb.thirdAction);
      localBundle1.putString("VIDEO_THIRD_URL", paramb.ahw);
      localBundle1.putInt("VIDEO_ARTICLE_BUSITYPE", paramb.aDs);
      localBundle2 = new Bundle();
      localBundle2.putString("VINFO", paramb.videoVid);
      localBundle2.putString("TINFO", paramb.videoVid);
      localBundle2.putInt("PREVIEW_VIDEO_TIME", paramb.videoDuration);
      localBundle2.putInt("PREVIEW_START_POSI", myh.T(0, paramb.videoDuration));
      localBundle2.putInt("PREVIEW_VIDEO_WIDTH", paramb.videoWidth);
      localBundle2.putInt("PREVIEW_VIDEO_HEIGHT", paramb.videoHeight);
      localBundle2.putInt("FULL_VIDEO_TIME", paramb.videoDuration);
      localBundle2.putString("source_puin", paramBaseArticleInfo.mSubscribeID);
      if (paramb.aDs != 1) {
        break label945;
      }
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
    }
    for (;;)
    {
      localBundle2.putInt("TYPE", paramb.aDs);
      localBundle2.putString("ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle2.putInt("layout_item", 5);
      localBundle2.putBoolean("video_url_load", false);
      localBundle2.putString("image_url_remote", paramb.videoCoverUrl);
      localBundle2.putString("detail_url", paramBaseArticleInfo.mArticleContentUrl);
      localBundle2.putString("video_url", paramb.videoVid);
      localBundle2.putString("title", paramBaseArticleInfo.mTitle);
      localBundle2.putString("req_create_time", kxl.ap(paramBaseArticleInfo.mTime));
      localBundle2.putString("brief_key", paramBaseArticleInfo.mTitle);
      localBundle2.putInt("req_type", 140);
      localBundle1.putByteArray("STRUCT_MSG_BYTES", ((StructMsgForGeneralShare)anre.a(localBundle2)).getBytes());
      return localBundle1;
      if (paramb.aDs == 6)
      {
        if (ndi.ak(paramBaseArticleInfo)) {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin);
        }
        for (;;)
        {
          localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.nickName);
          if (ndi.aa((ArticleInfo)paramBaseArticleInfo)) {
            break;
          }
          localBundle1.putString("VIDEO_URL", ((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).video_url);
          break;
          localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", "" + paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin);
        }
      }
      localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      break;
      label881:
      localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
      localBundle1.putString("VIDEO_CREATE_TIME", kxl.c(paramBaseArticleInfo.mTime, true));
      break label107;
      label910:
      localBundle1.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
      localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
      break label278;
      label935:
      bool = false;
      break label288;
      label940:
      i = 1;
      break label372;
      label945:
      localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
      localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
    }
  }
  
  public static void a(Activity paramActivity, mye.b paramb, BaseArticleInfo paramBaseArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "open full play activity, articleID : " + paramBaseArticleInfo.mArticleID + ", playPosition : " + paramb.xb + ",vid : " + paramb.videoVid);
    }
    Bundle localBundle = a(paramb, paramBaseArticleInfo);
    if (paramb.aDs == 2)
    {
      localObject = kxv.a(paramb.videoVid);
      if (localObject != null)
      {
        localBundle.putString("VIDEO_THIRD_VID_URL", ((kxz)localObject).url);
        localBundle.putLong("VIDEO_THIRD_VID_URL_TIME", ((kxz)localObject).time);
      }
    }
    localBundle.putBoolean("VIDEO_LIST_SCROLL_EXIT", true);
    localBundle.putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 3);
    localBundle.putInt("VIDEO_FROM_TYPE", 10);
    Object localObject = new Intent(paramActivity, VideoFeedsPlayActivity.class);
    ((Intent)localObject).addFlags(536870912);
    if (BaseApplicationImpl.sProcessId != 1)
    {
      localBundle.putBoolean("param_needSmooth", mzj.a().Fc());
      mzj.a().oY(true);
      localBundle.putBoolean("param_needAlertInXg", mst.Ei());
    }
    if (paramb.aDs == 6) {
      localBundle.putParcelable("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
    }
    ((Intent)localObject).putExtras(localBundle);
    int i = 9091;
    if (1 == paramBaseArticleInfo.mVideoType) {
      i = 1;
    }
    for (;;)
    {
      localBundle.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
      int j = 0;
      try
      {
        boolean bool = kzc.b(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
        j = bool;
      }
      catch (Exception paramb)
      {
        label321:
        break label321;
      }
      if (j == 0) {
        break;
      }
      paramb = new Intent();
      paramb.putExtras(localBundle);
      MultiVideoFragment.d(paramActivity, paramb, i);
      paramActivity.overridePendingTransition(2130772027, 2130772028);
      return;
      if (0L == paramBaseArticleInfo.mChannelID) {
        i = 1;
      }
    }
    paramActivity.startActivityForResult((Intent)localObject, i);
    paramActivity.overridePendingTransition(2130772129, 2130772130);
  }
  
  public static void a(List<BaseData> paramList, String paramString, int paramInt1, int paramInt2)
  {
    if (paramList == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          ;;
          while (TextUtils.isEmpty(paramString)) {}
          paramList = paramList.iterator();
        } while (!paramList.hasNext());
        localObject = (BaseData)paramList.next();
      } while (!(localObject instanceof ProteusItemData));
      localObject = (ProteusItemData)localObject;
    } while (((ProteusItemData)localObject).bad != 3);
    a(((ProteusItemData)localObject).aD, paramString, paramInt1, paramInt2);
  }
  
  public static void a(JSONObject paramJSONObject, Activity paramActivity, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    try
    {
      int i = paramJSONObject.getInt("mVideoJsonWidth");
      int j = paramJSONObject.getInt("mVideoJsonHeight");
      String str = paramJSONObject.getString("mVideoVid");
      int k = paramJSONObject.getInt("busiType");
      paramJSONObject = paramJSONObject.getString("mVideoCoverUrl");
      ArticleInfo localArticleInfo = new ArticleInfo();
      localArticleInfo.mVideoJsonWidth = i;
      localArticleInfo.mVideoJsonHeight = j;
      localArticleInfo.mVideoVid = str;
      localArticleInfo.busiType = k;
      localArticleInfo.mVideoCoverUrl = kxm.b(paramJSONObject);
      localArticleInfo.mArticleContentUrl = paramArticleInfo.mArticleContentUrl;
      localArticleInfo.mTitle = paramArticleInfo.mTitle;
      if (paramFastWebArticleInfo.FP()) {}
      for (paramJSONObject = "2";; paramJSONObject = "1")
      {
        paramJSONObject = kxm.a(paramActivity, paramArticleInfo, 0, paramJSONObject);
        paramJSONObject.put("vedio_rowkey", str);
        nns.c(paramArticleInfo, "0X800898F", paramJSONObject.toString());
        c(paramActivity, localArticleInfo);
        return;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebVideoItemUtils", 1, "handleVideoClick error! msg=" + paramJSONObject);
    }
  }
  
  private static void a(JSONObject paramJSONObject, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramJSONObject == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    try
    {
      paramJSONObject.put("mVideoJsonWidth", paramInt1);
      paramJSONObject.put("mVideoJsonHeight", paramInt2);
      paramJSONObject.put("mVideoCoverUrl", paramString);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebVideoItemUtils", 1, "updateVideoInfo error! msg=" + paramJSONObject);
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, int paramInt3)
  {
    try
    {
      paramJSONObject.put("articleImageUrl", paramString1);
      paramJSONObject.put("play_icon", "video_play_icon");
      paramJSONObject.put("style_ID", "ReadInjoy_article_video_cell");
      paramJSONObject.put("lineup", "0");
      paramJSONObject.put("vedio_rowkey", paramString2);
      paramJSONObject.put("mVideoVid", paramString2);
      paramJSONObject.put("busiType", paramInt3);
      a(paramJSONObject, paramString1, paramInt1, paramInt2);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebVideoItemUtils", 1, "insertDynamicData error! msg=" + paramJSONObject);
    }
  }
  
  public static void c(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    mye.b localb = new mye.b();
    localb.articleID = paramArticleInfo.mArticleID;
    localb.fileSize = paramArticleInfo.mXGFileSize;
    localb.thirdUin = paramArticleInfo.thirdUin;
    localb.thirdUinName = paramArticleInfo.thirdUinName;
    localb.puin = paramArticleInfo.mSubscribeID;
    localb.strategyId = paramArticleInfo.mStrategyId;
    localb.algorithmID = paramArticleInfo.mAlgorithmID;
    mhu localmhu = new mhu();
    localmhu.w = Long.valueOf(paramArticleInfo.mArticleID);
    localmhu.rowkey = paramArticleInfo.innerUniqueID;
    localb.videoVid = paramArticleInfo.mVideoVid;
    localb.aDs = paramArticleInfo.busiType;
    localb.videoWidth = paramArticleInfo.mVideoJsonWidth;
    localb.videoHeight = paramArticleInfo.mVideoJsonHeight;
    localmhu.busiType = paramArticleInfo.busiType;
    localb.videoDuration = paramArticleInfo.mVideoDuration;
    if (paramArticleInfo.mVideoCoverUrl == null) {}
    for (String str = null;; str = paramArticleInfo.mVideoCoverUrl.getFile())
    {
      localb.videoCoverUrl = str;
      localb.akK = paramArticleInfo.innerUniqueID;
      localmhu.vid = paramArticleInfo.mVideoVid;
      localb.c = localmhu;
      localb.thirdIcon = paramArticleInfo.thirdIcon;
      localb.thirdName = paramArticleInfo.thirdName;
      localb.thirdAction = paramArticleInfo.thirdAction;
      new ReportInfo.b().aSz = 409409;
      a(paramActivity, localb, paramArticleInfo);
      return;
    }
  }
  
  public static String e(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = "https://puui.qpic.cn/qqvideo_ori/0/" + paramString1 + "_496_280/0";
    kxm.a(paramString1, paramString3, paramString2, paramString4, new nnk());
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nnj
 * JD-Core Version:    0.7.0.1
 */