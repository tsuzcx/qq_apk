import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.VideoData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class nmf
  implements nln
{
  public int a(BaseData paramBaseData)
  {
    return 5;
  }
  
  public nlm a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new nmf.a(LayoutInflater.from(paramContext).inflate(2131560379, null), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.type == 5;
  }
  
  public static class a
    extends nlm
    implements View.OnClickListener
  {
    private URLImageView J;
    private int bas;
    private ImageView kN;
    
    public a(View paramView, BaseData paramBaseData)
    {
      super(paramBaseData);
      this.J = ((URLImageView)paramView.findViewById(2131381646));
      this.kN = ((ImageView)paramView.findViewById(2131381757));
      this.kN.setOnClickListener(this);
    }
    
    private void H(ArticleInfo paramArticleInfo)
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
        a(localb, paramArticleInfo);
        return;
      }
    }
    
    private Bundle a(mye.b paramb, BaseArticleInfo paramBaseArticleInfo)
    {
      Bundle localBundle1 = new Bundle();
      label107:
      boolean bool;
      label284:
      label295:
      int i;
      label387:
      Bundle localBundle2;
      if (paramb.aDs == 1)
      {
        localBundle1.putString("VIDEO_PUB_ACCOUNT_UIN", paramBaseArticleInfo.mSubscribeID);
        localBundle1.putString("VIDEO_PUB_ACCOUNT_NAME", paramBaseArticleInfo.mSubscribeName);
        if (paramb.aDs != 6) {
          break label933;
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
          break label962;
        }
        localBundle1.putString("VIDEO_ARTICLE_ID", ((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aim);
        localBundle1.putLong("VIDEO_FEED_ID", paramBaseArticleInfo.mFeedId);
        localBundle1.putInt("VIDEO_FEED_TYPE", paramBaseArticleInfo.mFeedType);
        localBundle1.putString("VIDEO_TITLE", ((SocializeFeedsInfo.t)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).title);
        if (paramb.aDs != 1) {
          break label989;
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
          break label995;
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
          break label1000;
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
        localBundle1.putString("KEY_VIDEO_JSON_LIST", paramBaseArticleInfo.mJsonVideoList);
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
        label933:
        localBundle1.putString("VIDEO_H5_URL", paramBaseArticleInfo.mArticleContentUrl);
        localBundle1.putString("VIDEO_CREATE_TIME", kxl.c(paramBaseArticleInfo.mTime, true));
        break label107;
        label962:
        localBundle1.putString("VIDEO_ARTICLE_ID", paramBaseArticleInfo.innerUniqueID);
        localBundle1.putString("VIDEO_TITLE", paramBaseArticleInfo.mTitle);
        break label284;
        label989:
        bool = false;
        break label295;
        label995:
        i = 1;
        break label387;
        label1000:
        localBundle2.putString("ACCOUNT_UIN", paramBaseArticleInfo.thirdUin);
        localBundle2.putString("ACCOUNT_NAME", paramBaseArticleInfo.thirdUinName);
      }
    }
    
    public static int getScreenWidth(Context paramContext)
    {
      return paramContext.getResources().getDisplayMetrics().widthPixels;
    }
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
    {
      paramBaseData1 = (VideoData)paramBaseData2;
      int i = wja.dp2px(12.0F, this.itemView.getContext().getResources());
      i = getScreenWidth(this.J.getContext()) - i - i;
      this.bas = (i * 280 / 496);
      paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
      paramBaseData2.mRequestWidth = i;
      paramBaseData2.mRequestHeight = this.bas;
      paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
      paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
      if (TextUtils.isEmpty(paramBaseData1.coverUrl))
      {
        paramBaseData1.coverUrl = ("https://puui.qpic.cn/qqvideo_ori/0/" + paramBaseData1.vid + "_496_280/0");
        kxm.a(paramBaseData1.vid, paramBaseData1.appKey, paramBaseData1.appid, paramBaseData1.tid, new nmg(this, paramBaseData1));
      }
      paramBaseData2 = URLDrawable.getDrawable(obs.a(paramBaseData1.coverUrl, 4), paramBaseData2);
      if ((paramBaseData2 != null) && (paramBaseData2.getStatus() == 2)) {
        paramBaseData2.restartDownload();
      }
      this.J.setImageDrawable(paramBaseData2);
      this.J.getLayoutParams().width = i;
      this.J.getLayoutParams().height = this.bas;
      this.kN.setTag(paramBaseData1);
    }
    
    public void a(mye.b paramb, BaseArticleInfo paramBaseArticleInfo)
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
      Object localObject = (Activity)this.itemView.getContext();
      Intent localIntent = new Intent((Context)localObject, VideoFeedsPlayActivity.class);
      localIntent.addFlags(536870912);
      if (BaseApplicationImpl.sProcessId != 1)
      {
        localBundle.putBoolean("param_needSmooth", mzj.a().Fc());
        mzj.a().oY(true);
        localBundle.putBoolean("param_needAlertInXg", mst.Ei());
      }
      if (paramb.aDs == 6) {
        localBundle.putParcelable("VIDEO_ARTICLE_INFO_FOR_BIU", (ArticleInfo)paramBaseArticleInfo);
      }
      localIntent.putExtras(localBundle);
      int i = 9091;
      if (1 == paramBaseArticleInfo.mVideoType) {
        i = 1;
      }
      for (;;)
      {
        int j = 0;
        try
        {
          boolean bool = kzc.b(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
          j = bool;
        }
        catch (Exception paramb)
        {
          label323:
          break label323;
        }
        if (j == 0) {
          break;
        }
        paramb = new Intent();
        paramb.putExtras(localBundle);
        MultiVideoFragment.d((Activity)localObject, paramb, i);
        ((Activity)localObject).overridePendingTransition(2130772027, 2130772028);
        return;
        if (0L == paramBaseArticleInfo.mChannelID) {
          i = 1;
        }
      }
      ((Activity)localObject).startActivityForResult(localIntent, i);
      ((Activity)localObject).overridePendingTransition(2130772129, 2130772130);
    }
    
    public void onClick(View paramView)
    {
      VideoData localVideoData = (VideoData)this.g;
      Context localContext = this.itemView.getContext();
      ArticleInfo localArticleInfo = this.g.articleInfo;
      Object localObject;
      if (this.g.d.FP()) {
        localObject = "2";
      }
      for (;;)
      {
        localObject = kxm.a(localContext, localArticleInfo, 0, (String)localObject);
        try
        {
          ((JSONObject)localObject).put("vedio_rowkey", localVideoData.vid);
          nns.c(this.g.articleInfo, "0X800898F", ((JSONObject)localObject).toString());
          localObject = new ArticleInfo();
          ((ArticleInfo)localObject).mVideoJsonWidth = localVideoData.width;
          ((ArticleInfo)localObject).mVideoJsonHeight = localVideoData.height;
          ((ArticleInfo)localObject).mVideoVid = localVideoData.vid;
          ((ArticleInfo)localObject).busiType = localVideoData.busiType;
          ((ArticleInfo)localObject).mVideoCoverUrl = kxm.b(localVideoData.coverUrl);
          ((ArticleInfo)localObject).mArticleContentUrl = this.g.articleInfo.mArticleContentUrl;
          ((ArticleInfo)localObject).mTitle = this.g.articleInfo.mTitle;
          H((ArticleInfo)localObject);
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject = "1";
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nmf
 * JD-Core Version:    0.7.0.1
 */