import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nyu
  implements View.OnClickListener
{
  public nyu(FolderRecommendTabFragment.a parama) {}
  
  public void onClick(View paramView)
  {
    sqn.b("", "auth_discover", "fold_clk", 0, 0, new String[0]);
    sgs.a(FolderRecommendTabFragment.a.a(this.a), FolderRecommendTabFragment.a(this.a.a), new nyv(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyu
 * JD-Core Version:    0.7.0.1
 */