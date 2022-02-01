import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mbf
  implements View.OnClickListener
{
  public mbf(ComponentContentRecommend paramComponentContentRecommend) {}
  
  public void onClick(View paramView)
  {
    this.this$0.i(ComponentContentRecommend.a(this.this$0));
    lbz.a().f(ComponentContentRecommend.a(this.this$0).mArticleID, ComponentContentRecommend.a(this.this$0).mRecommendFollowInfos.bq);
    ComponentContentRecommend.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mbf
 * JD-Core Version:    0.7.0.1
 */