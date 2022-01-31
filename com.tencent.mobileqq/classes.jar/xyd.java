import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberBuddyListAdapter;
import com.tencent.mobileqq.statistics.ReportController;

public class xyd
  implements View.OnClickListener
{
  public xyd(SelectMemberBuddyListAdapter paramSelectMemberBuddyListAdapter) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)SelectMemberBuddyListAdapter.a(this.a));
    ReportController.b(SelectMemberBuddyListAdapter.a(this.a), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xyd
 * JD-Core Version:    0.7.0.1
 */