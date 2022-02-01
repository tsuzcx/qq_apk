import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;

public class lpz
  extends lqv
{
  public lpz(ArticleInfo paramArticleInfo, Context paramContext)
  {
    super(paramArticleInfo, paramContext);
  }
  
  public static Intent a(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    paramActivity = new Intent(paramActivity, ReadInJoyDeliverBiuActivity.class);
    paramActivity.putExtra("arg_article_info", paramArticleInfo);
    paramActivity.putExtra("feedsType", paramArticleInfo.mFeedType);
    if (paramArticleInfo.mChannelID == 70L)
    {
      paramActivity.putExtra("biu_src", 9);
      paramActivity.putExtra("arg_from_type", 14);
    }
    for (;;)
    {
      if (kxr.K(paramArticleInfo)) {
        paramActivity.putExtra("arg_type", 4);
      }
      return paramActivity;
      paramActivity.putExtra("biu_src", 1);
      paramActivity.putExtra("arg_from_type", 1);
    }
  }
  
  protected void b(ViewBase paramViewBase)
  {
    boolean bool = true;
    QLog.d("OnBiuClickListener", 1, "click biu");
    if ((this.articleInfo != null) && (this.articleInfo.mSocialFeedInfo != null) && (this.articleInfo.mSocialFeedInfo.DC())) {}
    while ((!(this.context instanceof Activity)) || (this.articleInfo == null)) {
      return;
    }
    paramViewBase = (Activity)this.context;
    Intent localIntent = a(paramViewBase, this.articleInfo);
    if (kpn.nx() == 1) {}
    for (;;)
    {
      localIntent.putExtra("fast_biu_type", bool);
      paramViewBase.startActivity(localIntent);
      paramViewBase.overridePendingTransition(0, 0);
      return;
      bool = false;
    }
  }
  
  protected int getOperation()
  {
    return 25;
  }
  
  public void o(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (odv.aT(paramArticleInfo.mChannelID)) {}
    String str2;
    for (String str1 = "0X8009361";; str1 = "0X8007EE4")
    {
      str2 = kxm.d(paramArticleInfo);
      if ((!ndi.S(paramArticleInfo)) && (!ndi.ak(paramArticleInfo)) && (!ndi.T(paramArticleInfo)) && (!ndi.U(paramArticleInfo))) {
        break;
      }
      if (!ndi.Y(paramArticleInfo)) {
        kbp.a(null, String.valueOf(localSocializeFeedsInfo.a.cuin), str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.mFeedId), "0", "" + paramArticleInfo.mStrategyId, str2, false);
      }
      if ((!kxm.r(paramArticleInfo)) && (!kxm.s(paramArticleInfo))) {
        ndi.g(paramArticleInfo, (int)paramArticleInfo.mChannelID);
      }
      return;
    }
    kbp.a(null, paramArticleInfo.mSubscribeID, str1, str1, 0, 0, String.valueOf(localSocializeFeedsInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, str2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpz
 * JD-Core Version:    0.7.0.1
 */