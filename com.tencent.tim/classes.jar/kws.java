import android.app.Activity;
import android.text.TextPaint;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoInfoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.VideoViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class kws
{
  public static mye.b a(BaseArticleInfo paramBaseArticleInfo)
  {
    mye.b localb = new mye.b();
    localb.videoVid = paramBaseArticleInfo.mVideoVid;
    localb.articleID = paramBaseArticleInfo.mArticleID;
    localb.videoDuration = paramBaseArticleInfo.mVideoDuration;
    localb.videoWidth = paramBaseArticleInfo.mVideoJsonWidth;
    localb.videoHeight = paramBaseArticleInfo.mVideoJsonHeight;
    if (paramBaseArticleInfo.mVideoCoverUrl == null) {}
    for (Object localObject = null;; localObject = paramBaseArticleInfo.mVideoCoverUrl.getFile())
    {
      localb.videoCoverUrl = ((String)localObject);
      localb.puin = paramBaseArticleInfo.mSubscribeID;
      localb.strategyId = paramBaseArticleInfo.mStrategyId;
      localb.algorithmID = paramBaseArticleInfo.mAlgorithmID;
      localObject = new mhu();
      ((mhu)localObject).w = Long.valueOf(paramBaseArticleInfo.mArticleID);
      ((mhu)localObject).rowkey = paramBaseArticleInfo.innerUniqueID;
      ((mhu)localObject).vid = paramBaseArticleInfo.mVideoVid;
      ((mhu)localObject).busiType = paramBaseArticleInfo.busiType;
      localb.c = ((mhu)localObject);
      localb.thirdIcon = paramBaseArticleInfo.thirdIcon;
      localb.thirdName = paramBaseArticleInfo.thirdName;
      localb.thirdAction = paramBaseArticleInfo.thirdAction;
      localb.aDs = paramBaseArticleInfo.busiType;
      localb.akK = paramBaseArticleInfo.innerUniqueID;
      localb.channelId = paramBaseArticleInfo.mChannelID;
      return localb;
    }
  }
  
  public static void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, Activity paramActivity, int paramInt3, int paramInt4)
  {
    paramLinearLayout.setVisibility(0);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    localLayoutParams.leftMargin = paramInt3;
    localLayoutParams.topMargin = paramInt4;
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = (wja.dp2px(42.0F, paramActivity.getResources()) + paramInt2);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public static void a(LinearLayout paramLinearLayout, ArticleInfo paramArticleInfo, Activity paramActivity, ndh paramndh, int paramInt1, int paramInt2, int paramInt3)
  {
    lgf.f localf = new lgf.f(paramActivity);
    localf.c = ((RoundAngleFrameLayout)paramLinearLayout.findViewById(2131381801));
    localf.h = ((KandianUrlImageView)paramLinearLayout.findViewById(2131368820));
    localf.i = ((ReadInJoyHeadImageView)paramLinearLayout.findViewById(2131368698));
    localf.g = ((ReadInJoyNickNameTextView)paramLinearLayout.findViewById(2131376710));
    localf.pr = ((TextView)paramLinearLayout.findViewById(2131366156));
    localf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup = ((VideoViewGroup)paramLinearLayout.findViewById(2131381724));
    localf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup = ((ReadInJoyVideoInfoViewGroup)paramLinearLayout.findViewById(2131370125));
    a(localf, paramArticleInfo, paramLinearLayout, paramActivity, paramndh, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean, Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    mde.a(paramActivity, paramKandianUrlImageView);
    if (ndi.k(paramArticleInfo) == 71) {
      paramURL = paramArticleInfo.getVideoCoverUrlWithSmartCut(false);
    }
    kwz.a(paramKandianUrlImageView, paramURL, paramActivity, paramBoolean);
  }
  
  public static void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    paramReadInJoyHeadImageView.setImageDrawable(aqhu.at());
  }
  
  public static void a(lgf.f paramf, ArticleInfo paramArticleInfo, LinearLayout paramLinearLayout, Activity paramActivity, ndh paramndh, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramArticleInfo == null) {
      return;
    }
    a(paramf, paramArticleInfo);
    mye.b localb = paramf.jdField_a_of_type_Mye$b;
    paramf.pr.setText(kwz.ba(localb.videoDuration));
    a(paramf.i);
    paramf.i.setTag(paramArticleInfo);
    paramf.i.setContentDescription(paramArticleInfo.mSubscribeName);
    Object localObject = paramArticleInfo.mSubscribeName;
    if (paramArticleInfo.mSubscribeName.length() > 18) {
      localObject = paramArticleInfo.mSubscribeName.substring(0, 17) + "…";
    }
    paramf.g.setVisibility(0);
    paramf.g.setText((CharSequence)localObject);
    paramf.g.setContentDescription(paramArticleInfo.mSubscribeName);
    paramf.g.getPaint().setFakeBoldText(true);
    localObject = new HashSet();
    paramf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyVideoInfoViewGroup.setArticleInfo(paramArticleInfo, paramndh, paramInt1, (Set)localObject);
    a(paramf.h, paramArticleInfo.getVideoCoverUrlWithSmartCut(false), false, paramActivity, paramArticleInfo);
    paramf.pr.setVisibility(0);
    paramf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoViewGroup.setCustomSize(1.0F, kwz.c(localb.videoWidth, localb.videoHeight));
    float f1 = aqgz.aM(paramActivity);
    float f2 = f1 * kwz.c(localb.videoWidth, localb.videoHeight);
    paramArticleInfo = paramf.c.getLayoutParams();
    paramArticleInfo.width = ((int)f1);
    paramArticleInfo.height = ((int)f2);
    paramf.c.setLayoutParams(paramArticleInfo);
    a(paramLinearLayout, (int)f1, (int)f2, paramActivity, paramInt2, paramInt3);
  }
  
  public static void a(lgf.f paramf, BaseArticleInfo paramBaseArticleInfo)
  {
    mye.b localb = a(paramBaseArticleInfo);
    localb.ma = paramf.h;
    localb.position = paramf.position;
    localb.d = paramBaseArticleInfo;
    paramf.jdField_a_of_type_Mye$b = localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kws
 * JD-Core Version:    0.7.0.1
 */