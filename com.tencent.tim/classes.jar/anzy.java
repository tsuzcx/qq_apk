import android.view.View;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeSettingActivity;

public class anzy
  implements ausj.a
{
  public anzy(TeamWorkAuthorizeSettingActivity paramTeamWorkAuthorizeSettingActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    TeamWorkAuthorizeSettingActivity.a(this.a);
    this.a.a.notifyDataSetChanged();
    if (this.val$sheet.isShowing()) {
      this.val$sheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anzy
 * JD-Core Version:    0.7.0.1
 */