import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity;

public class aump
  implements View.OnClickListener
{
  public aump(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    if (GroupTeamWorkListActivity.a(this.this$0)) {
      GroupTeamWorkListActivity.a(this.this$0).Vr(GroupTeamWorkListActivity.b(this.this$0));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.doOnBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aump
 * JD-Core Version:    0.7.0.1
 */