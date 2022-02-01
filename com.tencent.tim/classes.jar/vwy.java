import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vwy
  implements View.OnClickListener
{
  public vwy(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onClick(View paramView)
  {
    int i = TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0).getIntExtra("key_team_work_edit_type", -1);
    if ((i != 1) && (i != 2)) {
      i = this.this$0.bKY;
    }
    String str1 = this.this$0.getShareUrl();
    String str2 = this.this$0.b().getShareTitle();
    Intent localIntent = new Intent(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.this$0), TeamWorkAuthorizeSettingFragment.class);
    if (!TextUtils.isEmpty(str2)) {
      localIntent.putExtra("team_work_name", str2);
    }
    localIntent.putExtra("team_work_pad_url", str1);
    localIntent.putExtra("team_work_pad_list_type", this.this$0.bLb);
    PublicFragmentActivity.start(this.this$0.getActivity(), localIntent, TeamWorkAuthorizeSettingFragment.class);
    this.this$0.report(14);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vwy
 * JD-Core Version:    0.7.0.1
 */