import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.statistics.ReportController;

public class exq
  implements View.OnClickListener
{
  public exq(BuddyListAdapter paramBuddyListAdapter) {}
  
  public void onClick(View paramView)
  {
    if ((BuddyListAdapter.a(this.a) != null) && (BuddyListAdapter.a(this.a).isShowing())) {
      BuddyListAdapter.a(this.a).dismiss();
    }
    GroupManagerActivity.a((Activity)BuddyListAdapter.a(this.a));
    ReportController.b(BuddyListAdapter.a(this.a), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     exq
 * JD-Core Version:    0.7.0.1
 */