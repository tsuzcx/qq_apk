import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;

public class yxo
  implements View.OnClickListener
{
  public yxo(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.app, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_clk", 0, 0, "", "", "", "");
    yxz.Ba(false);
    TroopNotifyAndRecommendView.a(this.this$0).setVisibility(8);
    this.this$0.i.setVisibility(0);
    if (this.this$0.mType != 2)
    {
      if (this.this$0.Mn != null) {
        this.this$0.Mn.setVisibility(4);
      }
      this.this$0.setType(2);
      this.this$0.AY(true);
      this.this$0.ty = yxz.dc();
      ArrayList localArrayList = new ArrayList();
      this.this$0.b.gS(localArrayList);
      this.this$0.b.gR(this.this$0.ty);
      this.this$0.b.notifyDataSetChanged();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.Mn != null) {
        this.this$0.Mn.setVisibility(0);
      }
      this.this$0.setType(0);
      this.this$0.AY(false);
      this.this$0.b.gR(this.this$0.mDataList);
      if ((this.this$0.tA != null) && (this.this$0.tA.size() > 0)) {
        this.this$0.b.gS(this.this$0.tA);
      }
      this.this$0.b.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxo
 * JD-Core Version:    0.7.0.1
 */