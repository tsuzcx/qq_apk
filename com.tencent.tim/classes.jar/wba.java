import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wba
  implements View.OnClickListener
{
  public wba(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.Qq();
    new anov(this.this$0.app).a("dc00899").b("Grp_online").c("mber_list").d("clk_more").a(new String[] { this.this$0.mTroopUin }).report();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wba
 * JD-Core Version:    0.7.0.1
 */