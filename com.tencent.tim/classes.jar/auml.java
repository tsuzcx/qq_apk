import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.teamwork.PadInfo;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity;

public class auml
  implements View.OnClickListener
{
  public auml(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    PadInfo localPadInfo = (PadInfo)((atjv.a)paramView.getTag()).a;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", jpa.r(localPadInfo.pad_url, "_bid=2517"));
    localBundle.putInt("key_team_work_edit_type", localPadInfo.type);
    localBundle.putString("key_team_work_title", localPadInfo.title);
    localBundle.putString("key_team_work_rul", localPadInfo.pad_url);
    localBundle.putInt("key_team_work_pad_list_type", localPadInfo.type_list);
    localBundle.putString("tdsourcetag", "s_tim_grpfile");
    TeamWorkDocEditBrowserActivity.a(this.this$0, localBundle, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auml
 * JD-Core Version:    0.7.0.1
 */