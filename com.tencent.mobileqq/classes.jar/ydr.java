import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.statistics.ReportController;

public class ydr
  implements View.OnClickListener
{
  public ydr(BuddyListAdapter paramBuddyListAdapter) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a(this.a.a);
    ReportController.b(BuddyListAdapter.a(this.a), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ydr
 * JD-Core Version:    0.7.0.1
 */