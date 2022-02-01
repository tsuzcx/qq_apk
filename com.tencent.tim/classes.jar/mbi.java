import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mbi
  implements View.OnClickListener
{
  mbi(mbg parammbg, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void onClick(View paramView)
  {
    ComponentContentRecommend localComponentContentRecommend = this.a.this$0;
    RecommendFollowInfo localRecommendFollowInfo = this.c;
    if (!this.c.isFollowed) {}
    for (boolean bool = true;; bool = false)
    {
      localComponentContentRecommend.a(localRecommendFollowInfo, bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mbi
 * JD-Core Version:    0.7.0.1
 */