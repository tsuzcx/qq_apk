import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mda
  implements View.OnClickListener
{
  public mda(ComponentTopicItemMulti paramComponentTopicItemMulti) {}
  
  public void onClick(View paramView)
  {
    kxm.c = ComponentTopicItemMulti.a(this.a);
    kxm.aJ(this.a.getContext(), this.a.b.businessUrl);
    String str1 = odv.aB(ComponentTopicItemMulti.a(this.a));
    String str2 = kxm.a(ComponentTopicItemMulti.a(this.a).mAlgorithmID, kxm.a(ComponentTopicItemMulti.a(this.a)), ComponentTopicItemMulti.a(this.a), 0, 0, aqiw.isWifiConnected(this.a.getContext()), ComponentTopicItemMulti.a(this.a).mSubscribeID, null, ComponentTopicItemMulti.a(this.a).innerUniqueID, null, ComponentTopicItemMulti.a(this.a));
    kbp.a(null, ComponentTopicItemMulti.a(this.a).mSubscribeID, str1, str1, 0, 0, ComponentTopicItemMulti.a(this.a).mFeedId + "", String.valueOf(this.a.b.businessId), String.valueOf(ComponentTopicItemMulti.a(this.a).mAlgorithmID), str2, false);
    kxm.b(ComponentTopicItemMulti.a(this.a), ComponentTopicItemMulti.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mda
 * JD-Core Version:    0.7.0.1
 */