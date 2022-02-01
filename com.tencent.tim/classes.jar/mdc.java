import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mdc
  implements View.OnClickListener
{
  public mdc(ComponentTopicItemSingle paramComponentTopicItemSingle, mih.b paramb) {}
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.b.a.a.a();
    kxm.c = localArticleInfo;
    kxm.aJ(this.b.getContext(), this.c.businessUrl);
    String str1 = kxm.a(localArticleInfo.mAlgorithmID, kxm.a(localArticleInfo), this.b.a.a.nh(), 0, 0, aqiw.isWifiConnected(this.b.getContext()), localArticleInfo.mSubscribeID, null, localArticleInfo.innerUniqueID, null, localArticleInfo);
    String str2 = odv.aB(localArticleInfo.mChannelID);
    kbp.a(null, localArticleInfo.mSubscribeID, str2, str2, 0, 0, localArticleInfo.mFeedId + "", String.valueOf(this.c.businessId), String.valueOf(localArticleInfo.mAlgorithmID), str1, false);
    kxm.b(localArticleInfo, this.b.a.a.nh());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdc
 * JD-Core Version:    0.7.0.1
 */