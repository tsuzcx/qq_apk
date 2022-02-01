import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;

public class yxf
  implements View.OnClickListener
{
  public yxf(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.app, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_clk", 0, 0, "", "", "", "");
    if (this.this$0.mType != 3)
    {
      if (this.this$0.Mn != null) {
        this.this$0.Mn.setVisibility(4);
      }
      TroopNotifyAndRecommendView.a(this.this$0).setVisibility(0);
      this.this$0.i.setVisibility(8);
      this.this$0.setType(3);
      this.this$0.AZ(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.Mn != null) {
        this.this$0.Mn.setVisibility(0);
      }
      TroopNotifyAndRecommendView.a(this.this$0).setVisibility(8);
      this.this$0.i.setVisibility(0);
      this.this$0.setType(0);
      this.this$0.b.gR(this.this$0.mDataList);
      this.this$0.b.notifyDataSetChanged();
      this.this$0.AZ(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxf
 * JD-Core Version:    0.7.0.1
 */