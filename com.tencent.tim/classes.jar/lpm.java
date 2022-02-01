import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lpm
  implements View.OnClickListener
{
  lpm(lpl paramlpl, lie paramlie, Context paramContext, int paramInt) {}
  
  public void onClick(View paramView)
  {
    lqw.a(this.b.a(), this.val$context);
    ArticleInfo localArticleInfo = this.b.a();
    String str1 = String.valueOf(kxm.a(this.b.a(), this.aMg));
    String str2 = kxm.a(localArticleInfo.mAlgorithmID, kxm.a(localArticleInfo), 70, 0, 0, aqiw.isWifiConnected(this.val$context), str1, null, localArticleInfo.innerUniqueID, null, localArticleInfo);
    kbp.a(null, str1, "0X8009355", "0X8009355", 0, 0, localArticleInfo.mFeedId + "", String.valueOf(localArticleInfo.businessId), String.valueOf(localArticleInfo.mAlgorithmID), str2, false);
    odv.J(localArticleInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpm
 * JD-Core Version:    0.7.0.1
 */