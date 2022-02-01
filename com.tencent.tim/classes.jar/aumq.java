import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity;

public class aumq
  implements View.OnClickListener
{
  public aumq(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    aulw.a locala = (aulw.a)paramView.getTag();
    if (locala.dOb == aulw.dOa) {
      ault.a(this.this$0.app, this.this$0, 2, this.this$0.aoW);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ault.a(this.this$0.app, this.this$0, locala.a);
      if ((locala == null) || (locala.a == null)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aumq
 * JD-Core Version:    0.7.0.1
 */