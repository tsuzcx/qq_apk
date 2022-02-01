import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.u;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class lqj
  implements ViewBase.OnClickListener
{
  private ndi a;
  private ArticleInfo b;
  private Context mContext;
  
  public lqj(ArticleInfo paramArticleInfo, Context paramContext, ndi paramndi)
  {
    this.b = paramArticleInfo;
    this.mContext = paramContext;
    this.a = paramndi;
  }
  
  private void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    kxm.a((Activity)this.mContext, paramArticleInfo);
  }
  
  private void aMW()
  {
    if ((this.b == null) || (this.mContext == null)) {}
    label210:
    do
    {
      return;
      QLog.d("OnReadArticleClickListener", 2, "jumpToArticle. ");
      int i = ndi.k(this.b);
      if ((35 == i) || (34 == i) || (85 == i))
      {
        if (!TextUtils.isEmpty(this.b.mArticleContentUrl))
        {
          if (!kxm.a(this.b.mArticleContentUrl, this.b.mChannelID, this.b)) {
            break label210;
          }
          q(this.b);
        }
        for (;;)
        {
          aMX();
          if ((kxm.i(this.b)) || (kxm.j(this.b))) {
            kbp.a(null, kxm.f(this.b), "0X8008A62", "0X8008A62", 0, 0, Long.toString(this.b.mFeedId), Long.toString(this.b.mArticleID), Integer.toString(this.b.mStrategyId), kxm.a(this.b.innerUniqueID, this.b.businessId + "", this.b), false);
          }
          aMY();
          return;
          kxm.aJ(this.mContext, this.b.mArticleContentUrl);
        }
      }
      if (kxm.r(this.b))
      {
        lqw.a(this.b, this.mContext);
        ndi.g(this.b, (int)this.b.mChannelID);
        aMY();
        return;
      }
      if (kxm.s(this.b))
      {
        str = this.b.mSocialFeedInfo.a.aiq;
        kxm.a(this.mContext, str, null);
        QLog.i("OnReadArticleClickListener", 2, "click readArticle answerUrl +" + str);
        ndi.g(this.b, (int)this.b.mChannelID);
        aMY();
        return;
      }
      if (ndi.ak(this.b))
      {
        kxm.a(this.mContext, this.b, 4, false, 7, false);
        ndi.g(this.b, this.b.mChannelInfoId);
        return;
      }
      if (ndi.S(this.b))
      {
        kxm.a(this.mContext, this.b, 2, false, 6, false);
        ndi.g(this.b, (int)this.b.mChannelID);
        return;
      }
    } while ((!ndi.al(this.b)) || (ndi.ap(this.b)));
    String str = ((mih.b)this.b.mSocialFeedInfo.mTopicRecommendFeedsInfo.ld.get(0)).businessUrl;
    if (!TextUtils.isEmpty(str)) {
      kxm.aJ(this.mContext, str);
    }
    kxm.a(this.mContext, this.b, this.a, (int)this.b.mChannelID);
  }
  
  private void aMX()
  {
    if (this.b != null)
    {
      ndi.h(this.b, (int)this.b.mChannelID);
      return;
    }
    QLog.d("Q.readinjoy.ui", 1, "ComponentAccountSummary report click read article data, articleInfo is null!");
  }
  
  private void aMY()
  {
    if (this.b != null) {
      odv.J(this.b);
    }
  }
  
  private void q(ArticleInfo paramArticleInfo)
  {
    nnw.K("fast_web_show_light_house_1");
    lbz.a().a().a(paramArticleInfo.mArticleContentUrl, String.valueOf(paramArticleInfo.innerUniqueID), paramArticleInfo.mSubscribeID, 1, null);
    a(paramArticleInfo, null);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    aMW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqj
 * JD-Core Version:    0.7.0.1
 */