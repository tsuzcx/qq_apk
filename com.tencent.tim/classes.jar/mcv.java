import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericPullAnimatorView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

public class mcv
  implements View.OnClickListener
{
  public mcv(ComponentPolymericPullAnimatorView paramComponentPolymericPullAnimatorView, ArticleInfo paramArticleInfo, JSONObject paramJSONObject) {}
  
  public void onClick(View paramView)
  {
    kxm.C(this.a.mContext, this.d.mNewPolymericInfo.aho);
    String str2 = this.d.mFeedId + "";
    if (kxm.x(this.d)) {}
    for (String str1 = "1";; str1 = "2")
    {
      kbp.a(null, "CliOper", "", "", "0X800982B", "0X800982B", 0, 0, str2, str1, this.d.mStrategyId + "", this.as.toString(), false);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mcv
 * JD-Core Version:    0.7.0.1
 */