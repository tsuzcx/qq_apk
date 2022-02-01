import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;

public class lqa
  extends lqv
{
  private VafContext mVafContext;
  
  public lqa(ArticleInfo paramArticleInfo, VafContext paramVafContext)
  {
    super(paramArticleInfo, paramVafContext.getContext());
    this.mVafContext = paramVafContext;
  }
  
  private void p(ArticleInfo paramArticleInfo)
  {
    if ((ndi.ag(paramArticleInfo)) || (ndi.L(paramArticleInfo)))
    {
      if (!TextUtils.isEmpty(paramArticleInfo.comment_jump_url)) {
        kxm.C(this.context, paramArticleInfo.comment_jump_url);
      }
      while ((paramArticleInfo.isCardJumpUrlAvailable != 1) || (TextUtils.isEmpty(paramArticleInfo.getCardJumpUrl()))) {
        return;
      }
      kxm.C(this.context, paramArticleInfo.getCardJumpUrl());
      return;
    }
    kxm.a(this.context, paramArticleInfo, true);
  }
  
  protected void b(ViewBase paramViewBase)
  {
    QLog.d("OnCommentClickListener", 1, "click comment");
    if (this.articleInfo.mFeedType == 36)
    {
      if ((this.context instanceof Activity)) {
        kxm.c(this.context, this.articleInfo, 8);
      }
      return;
    }
    if ((this.articleInfo.mSocialFeedInfo != null) && (this.articleInfo.mSocialFeedInfo.mCommentCount > 0) && (!ods.ac(this.articleInfo)))
    {
      QLog.d("OnCommentClickListener", 1, "jumpUrl");
      p(this.articleInfo);
      return;
    }
    QLog.d("OnCommentClickListener", 1, "openCommentComponent");
  }
  
  protected int getOperation()
  {
    return 3;
  }
  
  protected void o(ArticleInfo paramArticleInfo)
  {
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    if (odv.aT(paramArticleInfo.mChannelID)) {}
    String str2;
    for (String str1 = "0X8009360";; str1 = "0X8007B67")
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
 * Qualified Name:     lqa
 * JD-Core Version:    0.7.0.1
 */