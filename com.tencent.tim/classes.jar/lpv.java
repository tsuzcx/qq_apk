import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

public class lpv
  implements ViewBase.OnClickListener
{
  BaseArticleInfo j;
  
  public lpv(BaseArticleInfo paramBaseArticleInfo)
  {
    this.j = paramBaseArticleInfo;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.j.mSocialFeedInfo.a.a.homePageUrl;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    ndi.g((ArticleInfo)this.j, (int)this.j.mChannelID);
    kxm.aJ(localBaseActivity, paramViewBase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpv
 * JD-Core Version:    0.7.0.1
 */