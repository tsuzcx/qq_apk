import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity;

public class aumv
  implements View.OnClickListener
{
  public aumv(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, View paramView) {}
  
  public void onClick(View paramView)
  {
    this.HJ.setVisibility(8);
    GroupTeamWorkListActivity.a(this.this$0).notifyDataSetChanged();
    aqmj.d(this.this$0, this.this$0.app.getCurrentUin(), 1, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aumv
 * JD-Core Version:    0.7.0.1
 */