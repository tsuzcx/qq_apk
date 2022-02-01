import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PinnedHeadAndFootExpandableListView;
import com.tencent.widget.PinnedHeadAndFootExpandableListView.b;

public class auuu
  implements View.OnClickListener
{
  public auuu(PinnedHeadAndFootExpandableListView paramPinnedHeadAndFootExpandableListView1, PinnedHeadAndFootExpandableListView paramPinnedHeadAndFootExpandableListView2) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.a(this.b, this.a.Lv, this.a.eue);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auuu
 * JD-Core Version:    0.7.0.1
 */