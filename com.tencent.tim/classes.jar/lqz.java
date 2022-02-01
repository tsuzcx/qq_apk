import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class lqz
  implements ViewBase.OnClickListener
{
  private ArticleInfo b;
  private Context mContext;
  
  public lqz(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.b = paramArticleInfo;
    this.mContext = paramContext;
  }
  
  private void aNc()
  {
    if (this.b == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnTopicRecommendHeaderClickListener", 2, "business url is " + this.b.businessUrl);
    }
    if ((this.b.mTopicRecommendFeedsInfo != null) && (this.b.mTopicRecommendFeedsInfo.ld != null) && (this.b.mTopicRecommendFeedsInfo.ld.size() > 0)) {}
    for (Object localObject = (mih.b)this.b.mTopicRecommendFeedsInfo.ld.get(0);; localObject = null)
    {
      if ((this.b == null) || (localObject == null))
      {
        QLog.d("OnTopicRecommendHeaderClickListener", 1, new Object[] { "articleInfo is null or topicRecommendInfo is null, articleInfo: ", this.b, " topicRecommendInfo: ", localObject });
        return;
      }
      String str = this.b.businessUrl;
      if (TextUtils.isEmpty(str)) {
        break;
      }
      Intent localIntent = new Intent(this.mContext, PublicAccountBrowser.class);
      localIntent.putExtra("url", str);
      this.mContext.startActivity(localIntent);
      str = kxm.f(this.b);
      localObject = kxm.a(this.b.innerUniqueID, ((mih.b)localObject).businessId + "", this.b);
      kbp.a(null, str, "0X8008A63", "0X8008A63", 0, 0, Long.toString(this.b.mFeedId), Long.toString(this.b.mArticleID), Long.toString(this.b.mStrategyId), (String)localObject, false);
      ndi.g(this.b, (int)this.b.mChannelID);
      kxm.b(this.b, (int)this.b.mChannelID);
      return;
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = ndi.k(this.b);
    if (((this.mContext instanceof Activity)) && (i != 79)) {
      aNc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqz
 * JD-Core Version:    0.7.0.1
 */