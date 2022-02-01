import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PinnedFooterExpandableListView;
import com.tencent.widget.PinnedFooterExpandableListView.a;

public class auus
  implements View.OnClickListener
{
  public auus(PinnedFooterExpandableListView paramPinnedFooterExpandableListView1, PinnedFooterExpandableListView paramPinnedFooterExpandableListView2) {}
  
  public void onClick(View paramView)
  {
    if (PinnedFooterExpandableListView.a(this.d) != null) {
      PinnedFooterExpandableListView.a(this.d).a(this.c, this.d.mHeaderView, this.d.eue);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auus
 * JD-Core Version:    0.7.0.1
 */