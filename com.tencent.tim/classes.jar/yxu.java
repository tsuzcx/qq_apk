import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;

public class yxu
  implements View.OnClickListener
{
  public yxu(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.app, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_clk", 0, 0, "", "", "", "");
    yxz.Bb(false);
    this.this$0.aK(false, 1);
    TroopNotifyAndRecommendView.a(this.this$0).setVisibility(8);
    this.this$0.i.setVisibility(0);
    if (this.this$0.mType != 1)
    {
      if (this.this$0.Mn != null) {
        this.this$0.Mn.setVisibility(4);
      }
      this.this$0.setType(1);
      this.this$0.AX(true);
      this.this$0.tz = yxz.dd();
      ArrayList localArrayList = new ArrayList();
      this.this$0.b.gS(localArrayList);
      this.this$0.b.notifyDataSetChanged();
      this.this$0.b.gR(this.this$0.tz);
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
      this.this$0.AX(false);
      this.this$0.b.gR(this.this$0.mDataList);
      if ((this.this$0.tA != null) && (this.this$0.tA.size() > 0)) {
        this.this$0.b.gS(this.this$0.tA);
      }
      this.this$0.b.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxu
 * JD-Core Version:    0.7.0.1
 */