import android.os.ResultReceiver;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.teamwork.TeamWorkTransparentShareActivity;

public class aulq
  implements View.OnClickListener
{
  public aulq(TeamWorkTransparentShareActivity paramTeamWorkTransparentShareActivity, SharePolicyInfo paramSharePolicyInfo) {}
  
  public void onClick(View paramView)
  {
    if (TeamWorkTransparentShareActivity.a(this.this$0) != null)
    {
      if (this.b.taskType != 2) {
        break label48;
      }
      TeamWorkTransparentShareActivity.a(this.this$0).send(2, null);
    }
    for (;;)
    {
      this.this$0.finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label48:
      TeamWorkTransparentShareActivity.a(this.this$0).send(1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aulq
 * JD-Core Version:    0.7.0.1
 */