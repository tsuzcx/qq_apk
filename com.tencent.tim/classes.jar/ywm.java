import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ywm
  implements View.OnClickListener
{
  ywm(ywk paramywk) {}
  
  public void onClick(View paramView)
  {
    RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)paramView.getTag(-1);
    apuh.a(ywk.a(this.a), localRecommendTroopItem, 10001);
    aqfr.b("Grp_contacts_news", "notice", "recom_clk_add", 0, 0, new String[] { localRecommendTroopItem.uin, localRecommendTroopItem.recomAlgol });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywm
 * JD-Core Version:    0.7.0.1
 */