import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ExpandableListView;

class agdt
  implements View.OnClickListener
{
  agdt(agdq paramagdq, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (agdq.a(this.a).isGroupExpanded(this.Ju)) {
      agdq.a(this.a).collapseGroup(this.Ju);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      agdq.a(this.a).expandGroup(this.Ju);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agdt
 * JD-Core Version:    0.7.0.1
 */